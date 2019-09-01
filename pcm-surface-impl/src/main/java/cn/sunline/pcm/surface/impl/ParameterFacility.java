package cn.sunline.pcm.surface.impl;

import java.io.Serializable;
import java.io.StringReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.MapperWrapper;

import cn.sunline.common.KC;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.pcm.facility.ParameterManage;
import cn.sunline.pcm.facility.audit.ParamObjDiffUtils;
import cn.sunline.pcm.infrastructure.shared.enums.ParamOperationDef;
import cn.sunline.pcm.infrastructure.shared.model.PcmPrmAudit;
import cn.sunline.pcm.infrastructure.shared.model.PcmPrmControl;
import cn.sunline.pcm.infrastructure.shared.model.PcmPrmObject;

/**
 * 供bmp平台内部使用的参数基础设置，包含了参数的增删改查
 * 
 * @author alen
 * 
 */
@Service
public class ParameterFacility {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ParameterManage parameterManage;

	public static final String GLOBAL_KEY = "*";

//	private static final String CONNECT = "-";

	private static final String COMMA = "\\|";

	/**
	 * xstream对象. xstream是线程安全的
	 */
	public static XStream xstream = new XStream(new DomDriver()){

		// 目的是为了忽略不存在的字段，这种情况在参数结构变动经常发生
		@Override
		protected MapperWrapper wrapMapper(MapperWrapper next) {
			return new MapperWrapper(next){
				@Override
				public boolean shouldSerializeMember(@SuppressWarnings("rawtypes") Class definedIn, String fieldName) {
					return definedIn != Object.class ? super.shouldSerializeMember(definedIn, fieldName) : false;
				}

			};
		}
	};

	/**
	 * 取对应参数，按key取。
	 * 
	 * @param key
	 *            取key为null代表机构级全局参数
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T getParameterObject(String key, Class<T> clazz) {
		PcmPrmObject prm = parameterManage.getParameterObject(key, clazz.getCanonicalName());
		if (prm == null){
			return null;
		}
		return (T)xstream.fromXML(new String(prm.getParamObject()));
	}

	
	/**
	 * 取对应参数，按key取。
	 * 
	 * @param key
	 *            取key为null代表机构级全局参数
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T getParameterObject2(String key, Class<T> clazz) {
		PcmPrmObject prm = parameterManage.getParameterObject(key, clazz.getCanonicalName());
		if (prm == null){
			return null;
		}
		String paramObject = prm.getParamObject();
		try {
			return (T) xml2Java(clazz,paramObject);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T> Object xml2Java(Class<T> cls,String content) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(cls);
		Unmarshaller unmarsheller = context.createUnmarshaller();//XML格式的反解析类
		StringReader reader = new StringReader(content);
		return unmarsheller.unmarshal(reader);
	}	


	
	/**
	 * 
	 * @param paramClazzName
	 * @return
	 */
	public <T extends Serializable> Map<String, T> retrieveParameterObject(Class<T> paramClazz) {
		Map<String, PcmPrmObject> params = parameterManage.getParameterObjectMap(paramClazz.getCanonicalName());
		Map<String, T> result = new HashMap<String, T>();
		for (Entry<String, PcmPrmObject> entry : params.entrySet()) {
			@SuppressWarnings("unchecked")
			T param = (T)xstream.fromXML(entry.getValue().getParamObject());
			result.put(entry.getKey(), param);
		}
		return result;
	}

	/**
	 * 取所有参数
	 * 
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> getParameterObject(Class<T> clazz) {
		ArrayList<T> result = new ArrayList<T>();
		// for (PcmPrmObject o :
		// rPrmObject.findAll(qPrmObject.paramClass.eq(clazz.getCanonicalName()).and(qPrmObject.org.eq(org))))
		for (PcmPrmObject o : parameterManage.getParameterObject(clazz.getCanonicalName())) {
			T obj = (T)xstream.fromXML(new String(o.getParamObject()));
			result.add(obj);
		}

		return result;
	}

	@Transactional
	public <T> void updateParameterObject(String key, T obj) throws ProcessException {
		// 优先检查参数管控
		checkParmControl(obj);
		if (key == null){
			key = GLOBAL_KEY;}
		String org = KC.threadLocal.getCurrentOrg();
		Class<?> paramClass = obj.getClass();
		PcmPrmObject param = loadParam(org, paramClass, key);
		if (param == null) {
			throw new ProcessException(String.format("参数编码%s,该参数已被删除", key));
		}
		Object oldObj = decode(new String(param.getParamObject()));
		param.setParamObject(encode(obj));
		param.setLstUpdTime(new Date());
//		param.setUpdateUser(KC.threadLocal.getUserId());
		param.setLstUpdUser(KC.threadLocal.getUserId());
		parameterManage.update(param);
//		refreshParameter(key, paramClass.getCanonicalName());
		auditPrmModify(org, key, paramClass, ParamOperationDef.UPDATE, obj, oldObj, KC.threadLocal.getUserId());
	}

	private PcmPrmObject loadParam(String org, Class<?> paramClass, String key) {
		// PcmPrmObject param = rPrmObject.findByOrgAndParamClassAndParamKey(org, paramClass.getCanonicalName(), key);
		PcmPrmObject param = parameterManage.loadParam(org, paramClass.getCanonicalName(), key);
		if (param == null){
			throw new ProcessException("没找到参数:" + org + "|" + paramClass.getCanonicalName() + "|" + key);}
		return param;
	}

	@Transactional
	public <T> void deleteParameterObject(String key, Class<T> clazz) throws ProcessException {
		if (key == null){
			key = GLOBAL_KEY;}

		String org = KC.threadLocal.getCurrentOrg();
		PcmPrmObject param = loadParam(org, clazz, key);
		Object oldObj = decode(new String(param.getParamObject()));
		// rPrmObject.delete(param);
		parameterManage.deleteParameterObject(param);

//		refreshParameter(key, clazz.getCanonicalName());

		auditPrmModify(org, key, clazz, ParamOperationDef.DELETE, null, oldObj, KC.threadLocal.getUserId());
	}

	public Object decode(String data) {
		return xstream.fromXML(data);
	}

	public String encode(Object obj) {

		return xstream.toXML(obj);
	}

	@Transactional
	public void addNewParameter(String key, Object param) throws ProcessException {
		checkParmControl(param);
		if (key == null){
			key = GLOBAL_KEY;}

		String org = KC.threadLocal.getCurrentOrg();
		Class<?> paramClass = param.getClass();
		// if (rPrmObject.findByOrgAndParamClassAndParamKey(org,
		// paramClass.getCanonicalName(), key) != null)
		// throw new ProcessException("该参数已存在");
		if (parameterManage.findByOrgAndParamClassAndParamKey(org, paramClass.getCanonicalName(), key) != null){
			throw new ProcessException("该参数已存在");
		}
		PcmPrmObject object = new PcmPrmObject();
		object.setOrg(org);
		object.setParamClass(param.getClass().getCanonicalName());
		object.setParamKey(key);
		object.setParamObject(encode(param));
//		object.setMtnTimestamp(new Date());
		object.setLstUpdUser(KC.threadLocal.getUserId());
//		object.setCreateUser(KC.threadLocal.getUserId());
//		object.setUpdateUser(KC.threadLocal.getUserId());
		// em.persist(object);
		parameterManage.save(object);

		// 新增也要发刷新，因为有可能要更新集合缓存
//		refreshParameter(key, paramClass.getCanonicalName());

		auditPrmModify(org, key, paramClass, ParamOperationDef.INSERT, param, null, KC.threadLocal.getUserId());
	}

	/**
	 * 发送参数刷新广播
	 * 
	 * @param key
	 * @param paramClazzName
	 */
//	public void refreshParameter(String key, String paramClazzName) {
//		if (parameterRefreshExchange != null) {
//			logger.info("发送参数刷新广播:[{}] - [{}]", key, paramClazzName);
//			ParameterRefreshRequest request = new ParameterRefreshRequest();
//			request.setKey(key);
//			request.setParamClazzName(paramClazzName);
//			parameterRefreshExchange.convertAndSend(request);
//		}
//	}

	/**
	 * 记录参数操作审计日志
	 * 
	 * @param org
	 * @param key
	 * @param paramClass
	 * @param operation
	 * @param newObj
	 * @param oldObj
	 * @param user
	 */
	private void auditPrmModify(String org, String key, Class<?> paramClass, ParamOperationDef operation, Object newObj,
			Object oldObj, String user) {
		PcmPrmAudit prmAudit = new PcmPrmAudit();
		prmAudit.setOrg(org);
		prmAudit.setParamKey(key);
		prmAudit.setParamClass(paramClass.getName());
		prmAudit.setParamOperation(operation);
		prmAudit.setOldObject(encode(oldObj));
		prmAudit.setNewObject(encode(newObj));
		prmAudit.setMtnUser(user);
//		prmAudit.setUpdateUser(user);
		switch (operation) {
		case INSERT:
			prmAudit.setUpdateLog("新增参数，详细记录参看xml数据");
			break;
		case DELETE:
			prmAudit.setUpdateLog("删除参数，原记录参看xml数据");
			break;
		case UPDATE:
			try {
				prmAudit.setUpdateLog(ParamObjDiffUtils.diff(newObj, oldObj, "", "", 0, 0));
			} catch (IllegalArgumentException e) {
				logger.error("对象对比时异常", e);
				throw new RuntimeException("记录参数修改审计日志异常");
			} catch (IllegalAccessException e) {
				logger.error("对象对比时异常", e);
				throw new RuntimeException("记录参数修改审计日志异常");
			}
			break;
		default:
			break;
		}

		// em.persist(prmAudit);
		parameterManage.persistPrmAudit(prmAudit);
	}

	/**
	 * 
	 * 更新或新增参数字段管控
	 * 
	 * @param <T>
	 * @param paramClass
	 * @param obj
	 * @throws ProcessException
	 */
	@SuppressWarnings("all")
	private <T> void checkParmControl(Object obj) throws ProcessException {
		try {
			// 拉取所有的控制参数 -- 由于此处数据量暂时比较小,先这么干了 后期优化
			List<PcmPrmControl> controls = parameterManage.getPrmControls();
			// 若无控制,直接返回
			if (controls == null || controls.size() == 0)
				return;
			// 包装key-value
			Map<String, Object> fieldMap = new HashMap<String, Object>();
			Field[] fields = obj.getClass().getDeclaredFields();
			// 获取类所有非静态属性
			for (Field field : fields) {
				if ((field.getModifiers() & 0x8) > 0)
					continue;
				fieldMap.put(field.getName(), field.get(obj));
			}
			for (PcmPrmControl tmPrmControl : controls) {
				String[] locations = tmPrmControl.getParamClass().split(COMMA);
				// 若不是修改当前参数
				if (!obj.getClass().getCanonicalName().equals(locations[0]))
					continue;

				Object checkField = fieldMap.get(locations[1]);
				if (checkField == null)
					return;
				// 若没有子节点,校验该节点数据
				if (locations.length == 2) {
					checkField(tmPrmControl, obj);
					return;
				}
				// 若有子节点,遍历取出子节点数据,校验
				fetchChildNode(Arrays.asList(checkField), locations, tmPrmControl, 1);
			}

		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ProcessException("参数管控异常,请联系管理员");
		}

	}

	/**
	 * 遍历获取子节点
	 * 
	 * @param objs
	 * @param locations
	 * @param tmPrmControl
	 * @param num
	 * @throws Exception
	 */
	@SuppressWarnings("all")
	private <T> void fetchChildNode(Collection objs, String[] locations, PcmPrmControl tmPrmControl, int num)
			throws Exception {
		int i = num + 1;
		for (Object obj : objs) {
			// 若字段为list
			if (List.class.isInstance(obj)) {
				List<T> list = (List<T>)obj;
				fetchChildNode(list, locations, tmPrmControl, i);
				return;
			} else if (Map.class.isInstance(obj)) {
				Map map = (Map)obj;
				// 预留map处理
				Collection colls = map.values();
				fetchChildNode(colls, locations, tmPrmControl, i);
				return;
			}

			// 取出需校验字段
			String fieldName = locations[num];
			Map<String, Object> fieldMap = new HashMap<String, Object>();
			Field[] fields = obj.getClass().getDeclaredFields();
			// 获取类所有非静态属性
			for (Field field : fields) {
				if ((field.getModifiers() & 0x8) > 0)
					continue;
				fieldMap.put(field.getName(), field.get(obj));
			}
			Object checkField = fieldMap.get(fieldName);
			if (checkField == null)
				return;

			if (num == locations.length - 1)
				checkField(tmPrmControl, checkField);
			else
				fetchChildNode(Arrays.asList(checkField), locations, tmPrmControl, i);

		}
	}

	@SuppressWarnings("all")
	private <T> void checkField(PcmPrmControl control, Object obj) throws Exception {

		Class classType = obj.getClass();
		Constructor cstr = classType.getConstructor(String.class);
		Method compareTo = obj.getClass().getDeclaredMethod("compareTo", classType);

		if (StringUtils.isNotBlank(control.getMinValue())) {
			T minValue = (T)cstr.newInstance(control.getMinValue());
			Integer min = (Integer)compareTo.invoke(obj, minValue);
			if (min < 0) {
				throw new ProcessException(
						MessageFormat.format(	"管控参数[{0}]字段[{1}]不能小于最小值[{2}]", control.getParamClassLabel(),
												control.getParamFieldLabel(), control.getMinValue()));
			}
		}
		if (StringUtils.isNotBlank(control.getMaxValue())) {
			T maxValue = (T)cstr.newInstance(control.getMaxValue());
			Integer max = (Integer)compareTo.invoke(obj, maxValue);
			if (max > 0) {
				throw new ProcessException(
						MessageFormat.format(	"管控参数[{0}]字段[{1}]不能大于最大值[{2}]", control.getParamClassLabel(),
												control.getParamFieldLabel(), control.getMaxValue()));
			}
		}

	}

}
