package cn.sunline.pcm.facility;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cn.sunline.common.enums.DelFlag;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.MapperWrapper;

import cn.sunline.common.KC;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.pcm.definition.Product;
import cn.sunline.pcm.infrastructure.server.repos.RPcmPrmAudit;
import cn.sunline.pcm.infrastructure.server.repos.RPcmPrmObject;
import cn.sunline.pcm.infrastructure.shared.model.QPcmPrmControl;
import cn.sunline.pcm.infrastructure.shared.model.QPcmPrmObject;
import cn.sunline.pcm.infrastructure.shared.model.QPcmProductData;
import cn.sunline.pcm.infrastructure.shared.model.PcmPrmAudit;
import cn.sunline.pcm.infrastructure.shared.model.PcmPrmControl;
import cn.sunline.pcm.infrastructure.shared.model.PcmPrmObject;
import cn.sunline.pcm.infrastructure.shared.model.PcmProductData;

/**
 * <p>
 * 参数公共管理类实现
 * </p>
 * 
 * @version 1.0 2017年5月27日 linxiaocheng 修改内容:初版
 */
@Service
public class ParameterManage {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@PersistenceContext(unitName = "default")
	private EntityManager em;

	@Autowired
	private RPcmPrmObject rPrmObject;

	@Autowired
	private RPcmPrmAudit rPrmAudit;

	public static final String GLOBAL_KEY = "*";

	private QPcmPrmControl qPcmPrmControl = QPcmPrmControl.pcmPrmControl;

	private XStream xstream = new XStream(new DomDriver()){

		// 目的是为了忽略不存在的字段，这种情况在参数结构变动经常发生
		@Override
		protected MapperWrapper wrapMapper(MapperWrapper next) {
			return new MapperWrapper(next){
				
				@Override
				@SuppressWarnings("rawtypes")
				public boolean shouldSerializeMember(Class definedIn, String fieldName) {
					return definedIn != Object.class ? super.shouldSerializeMember(definedIn, fieldName) : false;
				}

			};
		}
	};

	/**
	 * 参数查询
	 * 
	 * @param request
	 * @param clazz
	 * @return
	 */
	public Iterable<PcmPrmObject> getFetchResponse(FetchRequest request, String paramClazz) {
		// TODO 暂时全返回
		QPcmPrmObject qPrmObject = QPcmPrmObject.pcmPrmObject;

//		FetchResponse response = new FetchResponse();
//		List<Serializable[]> data = new ArrayList<Serializable[]>();
//		List<String> fields = request.getFields();
		Iterable<PcmPrmObject> iter = rPrmObject.findAll(qPrmObject.paramClass.eq(paramClazz).and(qPrmObject.org.eq(KC.threadLocal.getCurrentOrg())));
		// .and(qPrmObject.delStatus.ne(DelFlag.D))

		return iter;
	}

	/**
	 * 取对应参数，按key取。
	 * 
	 * @param key 取key为null代表机构级全局参数
	 * @param clazz
	 * @return
	 */
	public PcmPrmObject getParameterObject(String key, String paramClazz) {
		if (key == null) {
			key = GLOBAL_KEY;
		}
		QPcmPrmObject q = QPcmPrmObject.pcmPrmObject;
		// TODO 参数检查
		String org = KC.threadLocal.getCurrentOrg();
		if (StringUtils.isBlank(org)) {
			throw new IllegalArgumentException("没有有效的当前机构号");
		}
		PcmPrmObject prm = rPrmObject.findOne(q.paramClass.eq(paramClazz).and(q.org.eq(org)).and(q.paramKey.eq(key))).orElse(null);
		// .and(q.delStatus.ne(DelFlag.D))
		return prm;
	}

	/**
	 * 取所有参数
	 * 
	 * @param clazz
	 * @return
	 */
	public Iterable<PcmPrmObject> getParameterObject(String paramClazz) {
		QPcmPrmObject qPrmObject = QPcmPrmObject.pcmPrmObject;
		// TODO 参数检查
		String org = KC.threadLocal.getCurrentOrg();
		if (StringUtils.isBlank(org)) {
			throw new IllegalArgumentException("没有有效的当前机构号");
		}
		return rPrmObject.findAll(qPrmObject.paramClass.eq(paramClazz).and(qPrmObject.org.eq(org)));
		// .and(qPrmObject.delStatus.ne(DelFlag.D))
	}

	public PcmPrmObject loadParam(String org, String paramClazz, String key) {
		PcmPrmObject param = rPrmObject.findByOrgAndParamClassAndParamKey(org, paramClazz, key);
//		if (param != null && param.getDelStatus() == DelFlag.D) {
//			return null;
//		}
		return param;
	}

	public void deleteParameterObject(PcmPrmObject tmPrmObject) {
//		tmPrmObject.setDelStatus(DelFlag.D);
//		rPrmObject.save(tmPrmObject);
		rPrmObject.delete(tmPrmObject);
	}

	public PcmPrmObject findByOrgAndParamClassAndParamKey(String org, String paramClass, String paramKey) {
		PcmPrmObject param = rPrmObject.findByOrgAndParamClassAndParamKey(org, paramClass, paramKey);
		// && param.getDelStatus() == DelFlag.D
		if (param != null) {
			return null;
		}
		return param;
	}

	/**
	 * 保存参数
	 * @param tmPrmObject
	 */
	public void save(PcmPrmObject tmPrmObject) {
		PcmPrmObject prmObjectO = rPrmObject.findByOrgAndParamClassAndParamKey(tmPrmObject.getOrg(), tmPrmObject.getParamClass(), tmPrmObject.getParamKey());
		if (prmObjectO != null) {
			throw new ProcessException(String.format("参数编码%s,已存在", tmPrmObject.getParamKey()));
		} else {
//			tmPrmObject.setDelStatus(DelFlag.N);
			rPrmObject.save(tmPrmObject);
		}
	}

	public void persistPrmAudit(PcmPrmAudit tmPrmAudit) {
		// em.persist(tmPrmAudit);
		rPrmAudit.save(tmPrmAudit);
	}

	public List<PcmPrmControl> getPrmControls() {
		JPAQuery<PcmPrmControl> query = new JPAQueryFactory(em).select(qPcmPrmControl);
		List<PcmPrmControl> controls = query.from(qPcmPrmControl).select(qPcmPrmControl).fetch();
		return controls;
	}

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.facility.service.ParameterManage#getParameterObjectMap(java.lang.String)
	 */
	public Map<String, PcmPrmObject> getParameterObjectMap(String paramClazz) {
		String org = KC.threadLocal.getCurrentOrg();
		assert org != null;
		QPcmPrmObject qPrmObject = QPcmPrmObject.pcmPrmObject;

		Map<String, PcmPrmObject> result = new HashMap<String, PcmPrmObject>();
		for (PcmPrmObject prm : rPrmObject.findAll(qPrmObject.org.eq(org).and(qPrmObject.paramClass.eq(paramClazz)))) {
			// .and(qPrmObject.delStatus.ne(DelFlag.D))
			result.put(prm.getParamKey(), prm);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.facility.service.ParameterManage#retrieveParameter(java.lang.String, java.lang.String)
	 */
	public PcmPrmObject retrieveParameter(String key, String paramClazz) {
		String org = KC.threadLocal.getCurrentOrg();
		if (key == null){
			key = GLOBAL_KEY;
			}
		if (org == null) {
			logger.warn("没有指定ORG");
			return null;
		}
		if (logger.isDebugEnabled()) {
			logger.debug("取参数{}, key 为 {}", paramClazz, key);
		}
		PcmPrmObject obj = rPrmObject.findByOrgAndParamClassAndParamKey(org, paramClazz, key);
		return obj;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * cn.sunline.pcm.facility.service.ParameterManage#update(cn.sunline.pcm.infrastructure.shared.model.PcmPrmObject)
	 */
	public void update(PcmPrmObject tmPrmObject) {
		rPrmObject.save(tmPrmObject);
	}

	/** 
	 * <p>
	 * 获取指定产品数据
	 * </p>
	 * @param productCode
	 * @return
	 */
	public List<PcmPrmObject> getProductParameter(String productCode) {
		PcmPrmObject productParam = rPrmObject.findByOrgAndParamClassAndParamKey(KC.threadLocal.getCurrentOrg(), Product.class.getName(), productCode);
		List<PcmPrmObject> list=new ArrayList<PcmPrmObject>();
		list.add(productParam);
		if (productParam != null) {
//			Product product = (Product)xstream.fromXML(productParam.getParamObject());
//			QPcmPrmObject qPcmPrmObject = QPcmPrmObject.tmPrmObject;
//			QPcmProductData qPcmProductData = QPcmProductData.tmProductData;
//			JPAQuery<PcmPrmObject> query = new JPAQuery<PcmPrmObject>(em);
//			query.select(qPcmPrmObject);
//			query.from(qPcmPrmObject, qPcmProductData);
//			// 两表关联条件
//			query.where(qPcmProductData.paramClass.eq(qPcmPrmObject.paramClass).and(qPcmProductData.paramKey.eq(qPcmPrmObject.paramKey)));
//			// 方法传入条件 || 默认条件
//			query.where(qPcmProductData.productType.eq(product.getProductType().name()).and(qPcmProductData.productCode.eq(productCode)));
//			query.where(qPcmPrmObject.org.eq(KC.threadLocal.getCurrentOrg()));
//			List<PcmPrmObject> fetch = query.fetch();
//			list.addAll(fetch);
			
			Product product = (Product)xstream.fromXML(productParam.getParamObject());
			QPcmProductData qPcmProductData = QPcmProductData.pcmProductData;
			JPAQuery<PcmProductData> queryData = new JPAQuery<PcmProductData>(em);
			queryData.select(qPcmProductData).from(qPcmProductData);
			queryData.where(qPcmProductData.productCode.eq(productCode));
			queryData.where(qPcmProductData.org.eq(KC.threadLocal.getCurrentOrg()));
			List<PcmProductData> fetch = queryData.fetch();
			QPcmPrmObject qPcmPrmObject = QPcmPrmObject.pcmPrmObject;
			JPAQuery<PcmPrmObject> query = new JPAQuery<PcmPrmObject>(em);
			for (PcmProductData data : fetch) {
				 String[] split = data.getParamKey().split(",");
				 qPcmPrmObject = QPcmPrmObject.pcmPrmObject;
				 query = new JPAQuery<PcmPrmObject>(em);
				 query.select(qPcmPrmObject).from(qPcmPrmObject);
				 query.where(qPcmPrmObject.org.eq(KC.threadLocal.getCurrentOrg()));
				 query.where(qPcmPrmObject.paramClass.eq(data.getParamClass()));
				 query.where(qPcmPrmObject.paramKey.in(split));
				 list.addAll(query.fetch());
			}
			return list;
		} else {
			return new ArrayList<PcmPrmObject>();
		}

	}

	/** 
	 * <p>
	 * 获取全部产品数据
	 * </p>
	 * @return
	 */
	public Map<String, List<PcmPrmObject>> getProductParameters() {
		QPcmPrmObject qPcmPrmObject = QPcmPrmObject.pcmPrmObject;
		JPAQuery<PcmPrmObject> query = new JPAQuery<PcmPrmObject>(em);
		query.select(qPcmPrmObject);
		query.from(qPcmPrmObject);
		query.where(qPcmPrmObject.paramClass.eq(Product.class.getName()).and(qPcmPrmObject.org.eq(KC.threadLocal.getCurrentOrg())));
		List<PcmPrmObject> objects = query.fetch();
		Map<String, List<PcmPrmObject>> map = new LinkedHashMap<String, List<PcmPrmObject>>();
		for (PcmPrmObject object : objects) {
			map.put(object.getParamKey(), getProductParameter(object.getParamKey()));
		}
		return map;
	}

	/** 
	 * <p>
	 * 获取全部LoanPlan数据
	 * </p>
	 * @param paramClazzName
	 * @return
	 */
	public List<String> getLoanPlanParameters(String paramClazzName) {
		QPcmPrmObject qPcmPrmObject = QPcmPrmObject.pcmPrmObject;
		JPAQuery<String> query = new JPAQuery<String>(em);
		query.select(qPcmPrmObject.paramKey);
		query.from(qPcmPrmObject);
		query.where(qPcmPrmObject.paramClass.eq(paramClazzName).and(qPcmPrmObject.org.eq(KC.threadLocal.getCurrentOrg())));
		List<String> objects = query.fetch();
		return objects;
	}

	/** 
	 * <p>
	 * 获取指定的LoanPlan
	 * </p>
	 * @param loanCode
	 * @param paramClazzName
	 * @return
	 */
	public Map<String, ?> getLoanPlanParameter(String loanCode, String paramClazzName) {
		// 查询参数表中的ProductLoanParam数据
		PcmPrmObject loanPlanParam = rPrmObject.findByOrgAndParamClassAndParamKey(KC.threadLocal.getCurrentOrg(), paramClazzName, loanCode);
		if (loanPlanParam != null) {
			// 查询映射表中的映射数据
			Map<String, Object> map = new HashMap<String, Object>();
			QPcmProductData qPcmProductData = QPcmProductData.pcmProductData;
			JPAQuery<PcmProductData> query = new JPAQuery<PcmProductData>(em);
			query.select(qPcmProductData);
			query.from(qPcmProductData);
			query.where(qPcmProductData.paramClass.eq(paramClazzName));
			query.where(qPcmProductData.paramKey.eq(loanPlanParam.getParamKey()));
			query.where(qPcmProductData.org.eq(KC.threadLocal.getCurrentOrg()));
			PcmProductData loanplanData = query.fetchFirst();
			// 定义了参数模版，但是没有组装产品工厂
			if (loanplanData == null) {
				return null;
			}
			// 查询参数表的产品数据
			PcmPrmObject productParam = rPrmObject.findByOrgAndParamClassAndParamKey(KC.threadLocal.getCurrentOrg(), Product.class.getName(), loanplanData.getProductCode());
			// 删除产品工厂时，没有删除相关映射数据
			if (productParam == null) {
				return null;
			}
			// 查询子产品关联数据
			List<PcmProductData> loanPlanTermParam = getProductData(loanPlanParam.getParamKey(), loanplanData.getProductCode(), paramClazzName.replace("ProductLoanParam", "ProductLoanTermParam"));
			map.put("product", productParam);
			map.put("productLoan", loanPlanParam);
			map.put("productLoanTerm", loanPlanTermParam);
			return map;
		}
		return null;
	}

	/** 
	 * <p>
	 * 获取指定产品数据
	 * </p>
	 * @param paramkey
	 * @param productType
	 * @param productCode
	 * @param paramClazzName
	 * @return
	 */
	public List<PcmProductData> getProductData(String paramkey, String productCode, String paramClazzName) {
		QPcmProductData qPcmProductData = QPcmProductData.pcmProductData;
		JPAQuery<PcmProductData> query = new JPAQuery<PcmProductData>(em);
		query.select(qPcmProductData);
		query.from(qPcmProductData);
		// 条件
		query.where(qPcmProductData.productCode.eq(productCode));
		query.where(qPcmProductData.paramClass.eq(paramClazzName));
		query.where(qPcmProductData.org.eq(KC.threadLocal.getCurrentOrg()));
		return query.fetch();
	}
}
