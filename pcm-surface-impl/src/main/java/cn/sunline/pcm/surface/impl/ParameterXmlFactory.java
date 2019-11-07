package cn.sunline.pcm.surface.impl;

import java.io.Serializable;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.text.MessageFormat;
import java.util.*;
import java.util.Map.Entry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.MapperWrapper;

import cn.sunline.common.KC;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.pcm.facility.ParameterManage;
import cn.sunline.pcm.infrastructure.shared.enums.ParamOperationDef;
import cn.sunline.pcm.infrastructure.shared.model.PcmPrmControl;
import cn.sunline.pcm.infrastructure.shared.model.PcmPrmObject;

/**
 * 供bmp平台内部使用的参数基础设置，包含了参数的增删改查
 * 
 * @author alen
 * 
 */
public class ParameterXmlFactory extends AbstractParameterFactory {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ParameterManage parameterManage;

	public static final String GLOBAL_KEY = "*";


	private static final String COMMA = "\\|";


	private DateConverter dateConverter;

	private final String SPLIT_COMMA = ",";


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
	 * @param
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
	public <T> List<T> getParameterObjects(Class<T> clazz) {
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
//		checkParmControl(obj);
		if (key == null){
			key = GLOBAL_KEY;}
		String org = KC.threadLocal.getCurrentOrg();
		Class<?> paramClass = obj.getClass();
		PcmPrmObject param = loadParam(org, paramClass, key);
		if (param == null) {
			throw new ProcessException(String.format("参数编码%s,该参数已被删除", key));
		}
		Object oldObj = decode(new String(param.getParamObject()),null);
		param.setParamObject(encode(obj));
		param.setLstUpdTime(new Date());
//		param.setUpdateUser(KC.threadLocal.getUserId());
		param.setLstUpdUser(KC.threadLocal.getUserId());
		parameterManage.update(param);
//		refreshParameter(key, paramClass.getCanonicalName());
		auditPrmModify(org, key, paramClass, ParamOperationDef.UPDATE, obj, oldObj, KC.threadLocal.getUserId());
	}





	@Override
	public Object decode(String data,String canonicalName) {
		return xstream.fromXML(data);
	}



    public String encode(Object obj) {

		return xstream.toXML(obj);
	}

	@Override
	public <T> FetchResponse<T> getFetchResponse(FetchRequest request, Class<T> clazz) {
		// 不分页的情况，避免空指针，这里初始化FetchRequest对象
		if (request == null) {
			request = new FetchRequest();
		}

		Iterable<PcmPrmObject> iter = parameterManage.getFetchResponse(request, clazz.getCanonicalName());
		FetchResponse response = new FetchResponse();

		// 获取请求条件
		Map<String, String> requestParam = request.getCriteriaMap();

		/* List<String> fields = request.getFields(); */
		List<Object> data = new ArrayList<Object>();

		// 如果请求条件参数为空，直接添加到列表
		if (requestParam == null) {
			for (PcmPrmObject prm : iter) {
				Object obj = this.decode(new String(prm.getParamObject()),null);
				data.add(obj);
			}
		}

		// 对于带条件的查询，满足条件查询才添加到列表
		else {
			for (PcmPrmObject prm : iter) {
				boolean flag = true;
				Object obj = this.decode(new String(prm.getParamObject()),null);

				for (Entry param : requestParam.entrySet()) {
					try {
						if (null != param.getValue() && null != FieldUtils.getField(clazz, (String)param.getKey())) {
							Object value = FieldUtils.readField(obj, (String)param.getKey(), true);
							if (value == null) {
								value = new String("");
							}
							if ((param.getValue() instanceof String) && value.getClass().isEnum()) {
								value = ((Enum)value).name();
							}
							if ((param.getValue() instanceof String) && value.getClass().equals(Date.class)) {
								// 只支持单字段日期判断
								if (this.dealDate(param, value)) {
									flag = false;
									break;
								}
								continue;
							} else {
								if (!String.valueOf(value)
										.contains(URLDecoder.decode(String.valueOf(param.getValue()), "utf-8"))){
									flag = false;}
							}
						}
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
				if (flag) {
					data.add(obj);
				}
			}
		}

		if (request.getSortorder() != null) {
			final String order = request.getSortorder();
			final String sortName = request.getSortname();
			Collections.sort(data, new Comparator(){

				@Override
				public int compare(Object o1, Object o2) {
					try {
						Class type = o1.getClass().getField(sortName).getType();
						Object f1 = o1.getClass().getField(sortName).get(o1);
						Object f2 = o2.getClass().getField(sortName).get(o2);
						// 若有空值,特殊处理
						if (f1 == null && f2 == null){
							return 0;
						}else if (f1 == null && f2 != null){
							return 1;
						}else if (f1 != null && f2 == null){
							return -1;
						}

						if (type.equals(Date.class)) {
							Date d1 = (Date)f1;
							Date d2 = (Date)f2;
							if (order.equals("asc")){
								return d1.compareTo(d2);
							}else{
								return d2.compareTo(d1);}
						} else {
							if (order.equals("asc")){
								return (f1.toString()).compareTo(f2.toString());
							}else{
								return (f2.toString()).compareTo(f1.toString());}
						}

					} catch (Exception e) {
						throw new ProcessException("字段名[" + sortName + "]排序异常", e);
					}
				}

			});
		}
		// 数据总长度,
		int dataSize = data.size();

		// 不分页处理
		if (request == null || request.getPage() == null || request.getPageSize() == null) {
			response.setRows(data);
			response.setTotal(dataSize);
		}

		// 分页处理
		else {
			int page = request.getPage();
			int pageSize = request.getPageSize();
			int rowStart = (page - 1) * pageSize;
			int rowEnd = page * pageSize > dataSize ? dataSize : page * pageSize;

			// 如果开始行超出查询记录数，返回无记录
			if (rowStart < dataSize) {
				response.setRows(data.subList(rowStart, rowEnd));
			}
			response.setTotal(dataSize);
		}
		return response;
	}

	@Override
	public <T> void deleteParameterObjects(List<String> key, Class<T> clazz) throws ProcessException {

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



	/**
	 * <p>
	 * 处理日期的筛选
	 * </p>
	 *
	 * @param param
	 * @param value
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private boolean dealDate(Entry<String, String> param, Object value) throws UnsupportedEncodingException {
		// 只支持单字段日期判断
		if (null == dateConverter) {
			dateConverter = new DateConverter(KC.datetimePattern.DATETIME24_LINE,
					new String[]{KC.datetimePattern.DATETIME24_BACKSLASH, KC.datetimePattern.DATE_LINE,
							KC.datetimePattern.DATE, KC.datetimePattern.DATE_BACKSLASH});
		}
		Date valueDate = (Date)value;
		String paramValue = URLDecoder.decode(String.valueOf(param.getValue()), "utf-8");
		if (paramValue.contains(SPLIT_COMMA)) {
			// 含有逗号，是日期范围strs=['2018-12-30', '2018-12-31']
			String[] strs = paramValue.split(SPLIT_COMMA, 2);
			String start = strs[0];
			String end = strs[1];
			if (KC.string.isNotBlank(start)) {
				Date startDate = (Date)dateConverter.fromString(start);
				// startDate=2018-12-30 00:00:00
				startDate = KC.date.getDateForZeroTime(startDate);
				if (startDate.after(valueDate)) {
					return true;
				}
			}
			if (KC.string.isNotBlank(end)) {
				Date endDate = (Date)dateConverter.fromString(end);
				// endDate=2019-01-01 00:00:00
				endDate = KC.date.addDays(KC.date.getDateForZeroTime(endDate), 1);
				if (endDate.before(valueDate) || endDate.getTime() == valueDate.getTime()) {
					return true;
				}
			}
		} else {
			// 无逗号，是单个日期，传入2019-01-01则要求在2019-01-01 00:00:00到2019-01-01 23:59:59之间
			if (KC.string.isNotBlank(paramValue)) {
				// date=2019-01-01
				Date date = (Date)dateConverter.fromString(paramValue);
				// startDate=2019-01-01 00:00:00
				Date startDate = KC.date.getDateForZeroTime(date);
				if (startDate.after(valueDate)) {
					return true;
				}
				// endDate=2019-01-02 00:00:00
				Date endDate = KC.date.addDays(startDate, 1);
				if (endDate.before(valueDate) || endDate.getTime() == valueDate.getTime()) {
					return true;
				}
			}
		}
		return false;
	}



}
