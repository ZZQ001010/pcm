package cn.sunline.pcm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.jpa.impl.JPAQueryFactory;

import cn.sunline.common.KC;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.pcm.facility.ParameterManage;
import cn.sunline.pcm.infrastructure.shared.model.PcmPrmObject;
import cn.sunline.pcm.infrastructure.shared.model.QPcmPrmObject;
import cn.sunline.pcm.infrastructure.shared.model.QPcmProductRel;
import cn.sunline.pcm.service.api.UnifiedParameter;
import cn.sunline.pcm.service.api.UnifiedParameterService;

/**
 * <p>
 * 参数服务实现类
 * </p>
 * 
 * @version 1.0 2017年5月27日 linxiaocheng 修改内容:初版
 */
@Service
public class UnifiedParameterServiceImpl implements UnifiedParameterService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ParameterManage parameterManage;

	@PersistenceContext(unitName = "default")
	private EntityManager em;

	protected QPcmProductRel qPcmProductRel = QPcmProductRel.pcmProductRel;

	protected QPcmPrmObject qPcmPrmObject = QPcmPrmObject.pcmPrmObject;

	@Override
	public UnifiedParameter retrieveParameter(String key, String paramClazz) {
		try {
			PcmPrmObject obj = parameterManage.retrieveParameter(key, paramClazz);
			if (obj == null) {
				return null;
			}
			UnifiedParameter result = new UnifiedParameter();
			result.setParameterXML(obj.getParamObject());
			result.setVersion(obj.getJpaVersion());
			if (logger.isDebugEnabled()) {
				logger.debug("取回参数版本：{}", result.getVersion());
			}
			return result;
		} catch (ProcessException e) {
			throw e;
		} catch (Exception e) {
			logger.error("获取参数异常", e);
			throw new ProcessException("获取参数异常", e);
		}
	}

	@Override
	public Map<String, UnifiedParameter> retrieveParameter(String paramClazz) {
		try {
			Map<String, PcmPrmObject> paramterMap = parameterManage.getParameterObjectMap(paramClazz);
			Map<String, UnifiedParameter> result = new HashMap<String, UnifiedParameter>();
			for (Entry<String, PcmPrmObject> prmEntry : paramterMap.entrySet()) {
				UnifiedParameter up = new UnifiedParameter();
				up.setParameterXML(prmEntry.getValue().getParamObject());
				up.setVersion(prmEntry.getValue().getJpaVersion());
				result.put(prmEntry.getKey(), up);
			}
			return result;
		} catch (ProcessException e) {
			throw e;
		} catch (Exception e) {
			logger.error("获取参数异常", e);
			throw new ProcessException("获取参数异常", e);
		}
	}

	@Override
	public UnifiedParameter retrieveParameterByProductCd(String productCd, String paramClazz) {
		try {
			if (productCd == null) {
				throw new ProcessException("参数productCd不能为空");
			}
			if (paramClazz == null) {
				throw new ProcessException("参数paramClazzName不能为空");
			}
			String paramKey = new JPAQueryFactory(em).select(qPcmProductRel.paramKey).from(qPcmProductRel)
					.where(qPcmProductRel.productCode.eq(productCd),
							qPcmProductRel.org.eq(KC.threadLocal.getCurrentOrg()),
							qPcmProductRel.paramClass.eq(paramClazz))
					.fetchFirst();
			return retrieveParameter(paramKey, paramClazz);
		} catch (ProcessException e) {
			throw e;
		} catch (Exception e) {
			logger.error("获取参数异常", e);
			throw new ProcessException("获取参数异常", e);
		}
	}

	@Override
	public Map<String, UnifiedParameter> retrieveParametersByProductCd(String productCd, String paramClazz) {
		try {
			if (productCd == null) {
				throw new ProcessException("参数productCd不能为空");
			}
			if (paramClazz == null) {
				throw new ProcessException("参数paramClazzName不能为空");
			}
			List<String> paramKeys = new JPAQueryFactory(em).select(qPcmProductRel.paramKey).from(qPcmProductRel)
					.where(qPcmProductRel.productCode.eq(productCd),
							qPcmProductRel.org.eq(KC.threadLocal.getCurrentOrg()),
							qPcmProductRel.paramClass.eq(paramClazz))
					.fetch();

			List<PcmPrmObject> pcmPrmObjects = new JPAQueryFactory(em).from(qPcmPrmObject).select(qPcmPrmObject)
					.where(qPcmPrmObject.paramClass.eq(paramClazz),
							qPcmPrmObject.org.eq(KC.threadLocal.getCurrentOrg()), qPcmPrmObject.paramKey.in(paramKeys))
					.fetch();
			Map<String, UnifiedParameter> result = new HashMap<String, UnifiedParameter>();
			for (PcmPrmObject pcmPrmObject : pcmPrmObjects) {
				UnifiedParameter up = new UnifiedParameter();
				up.setParameterXML(pcmPrmObject.getParamObject());
				up.setVersion(pcmPrmObject.getJpaVersion());
				result.put(pcmPrmObject.getParamKey(), up);
			}
			return result;
		} catch (ProcessException e) {
			throw e;
		} catch (Exception e) {
			logger.error("获取参数异常", e);
			throw new ProcessException("获取参数异常", e);
		}
	}
}
