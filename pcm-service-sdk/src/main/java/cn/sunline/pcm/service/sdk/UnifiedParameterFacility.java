package cn.sunline.pcm.service.sdk;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.MapperWrapper;

import cn.sunline.common.KC;
import cn.sunline.pcm.service.api.UnifiedParameter;
import cn.sunline.pcm.service.api.UnifiedParameterService;

/**
 * 统一参数工具类
 * 
 * @author linxch
 *
 */
@Service
public class UnifiedParameterFacility {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UnifiedParameterService unifiedParameterService;
	
	/**
	 * xstream对象. xstream是线程安全的
	 */
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
	 * 取单个参数
	 * 
	 * @param key
	 * @param paramClazz
	 * @return
	 */
	public <T extends Serializable> T retrieveParameterObject(String key, Class<T> paramClazz) {
		return retrieveParameterObject(key, paramClazz.getCanonicalName());
	}

	/** 
	 * <p>
	 * 取单个参数
	 * </p>
	 * @param key
	 * @param paramClazzName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Cacheable(value = "parameterUniqueCache",
			key = "T(cn.sunline.common.KC.threadLocal).getCurrentOrg() + #paramClazzName + #key")
	public <T extends Serializable> T retrieveParameterObject(String key, String paramClazzName) {
		if (logger.isDebugEnabled()) {
			logger.debug("获取单个参数org[{}]key[{}]className[{}]", KC.threadLocal.getCurrentOrg(), key, paramClazzName);
		}
		UnifiedParameter param = unifiedParameterService.retrieveParameter(key, paramClazzName);
		if (param != null){
			return (T)xstream.fromXML(param.getParameterXML());
		}else{
			return null;
		}
	}
	
	/** 
	 * <p>
	 * 根据产品取单个参数
	 * </p>
	 * @param paramClazz
	 * @return
	 */
	public <T extends Serializable> T retrieveParameterByProductCd(String productCd, Class<T> paramClazz) {
		return retrieveParameterByProductCd(productCd, paramClazz.getCanonicalName());
	}
	
	/** 
	 * <p>
	 * 根据产品取单个参数
	 * </p>
	 * @param key
	 * @param paramClazzName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Cacheable(value = "productParameterCache",
			key = "T(cn.sunline.common.KC.threadLocal).getCurrentOrg() + #paramClazzName + #productCd")
	public <T extends Serializable> T retrieveParameterByProductCd(String productCd, String paramClazzName) {
		if (productCd == null) {
			throw new IllegalArgumentException("参数productCd不能为空");
		}
		if (paramClazzName == null) {
			throw new IllegalArgumentException("参数paramClazzName不能为空");
		}
		if (logger.isDebugEnabled()) {
			logger.debug("根据产品取单个参数org[{}]productCd[{}]className[{}]", KC.threadLocal.getCurrentOrg(), productCd, paramClazzName);
		}
		UnifiedParameter param = unifiedParameterService.retrieveParameterByProductCd(productCd, paramClazzName);
		if (param != null){
			return (T)xstream.fromXML(param.getParameterXML());
		}else{
			return null;
		}
	}
	
	/** 
	 * <p>
	 * 根据参数类型获取当前机构下所有此类型参数
	 * </p>
	 * @param paramClazz
	 * @return
	 */
	public <T extends Serializable> Map<String, T> retrieveParameterObject(Class<T> paramClazz) {
		return retrieveParameterObject(paramClazz.getCanonicalName());
	}

	/** 
	 * <p>
	 * 根据参数类型获取当前机构下所有此类型参数
	 * </p>
	 * @param paramClazzName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Cacheable(value = "parameterMapCache",
			key = "T(cn.sunline.common.KC.threadLocal).getCurrentOrg() + #paramClazzName")
	public <T extends Serializable> Map<String, T> retrieveParameterObject(String paramClazzName) {
		if (logger.isDebugEnabled()) {
			logger.debug("根据参数类型获取当前机构下所有此类型参数org[{}]className[{}]", KC.threadLocal.getCurrentOrg(),  paramClazzName);
		}
		Map<String, UnifiedParameter> params = unifiedParameterService.retrieveParameter(paramClazzName);
		Map<String, T> result = new HashMap<String, T>();
		for (Entry<String, UnifiedParameter> entry : params.entrySet()) {
			T param = (T)xstream.fromXML(entry.getValue().getParameterXML());
			result.put(entry.getKey(), param);
		}
		return result;
	}

	/** 
	 * <p>
	 * 取一定参数的便利函数，如果不存在则抛异常
	 * </p>
	 * @param key
	 * @param clazz
	 * @return
	 */
	public <T extends Serializable> T loadParameter(Object key, Class<T> clazz) {
		T param = retrieveParameterObject(key == null ? null : String.valueOf(key), clazz);
		if (param == null) {
			String msg = MessageFormat.format("机构[{0}]参数[{1}]没取到，key值为[{2}]。", KC.threadLocal.getCurrentOrg(), clazz, key);
			logger.error(msg);
			throw new IllegalArgumentException(msg);
		}
		return param;
	}
	
	/** 
	 * <p>
	 * 取一定参数的便利函数，如果不存在返回null
	 * </p>
	 * @param key
	 * @param clazz
	 * @return
	 */
	public <T extends Serializable> T loadParameterReturnNull(Object key, Class<T> clazz) {
		T param = retrieveParameterObject(key == null ? null : String.valueOf(key), clazz);
		return param;
	}
	
	/** 
	 * <p>
	 * 根据产品编码和class类型加载参数如果没有，则抛异常
	 * </p>
	 * @param key
	 * @param clazz
	 * @return
	 */
	public <T extends Serializable> Map<String, T> loadParametersByProdctCd(String prodctCd, Class<T> clazz) {
		Map<String, T> params = retrieveParametersByProductCd(prodctCd, clazz.getCanonicalName());
		
		return params;
	}
	/**
	 * 根据productCd查询参数
	 * @param productCd
	 * @param paramClazzName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Cacheable(value = "productParameterCache",
			key = "T(cn.sunline.common.KC.threadLocal).getCurrentOrg() + #paramClazzName + #productCd")
	public <T extends Serializable> Map<String, T> retrieveParametersByProductCd(String productCd, String paramClazzName) {
		if (productCd == null) {
			throw new IllegalArgumentException("参数productCd不能为空");
		}
		if (paramClazzName == null) {
			throw new IllegalArgumentException("参数paramClazzName不能为空");
		}
		if (logger.isDebugEnabled()) {
			logger.debug("根据产品编号和参数类型获取当前机构下所有此类型参数org[{}]productCd[{}]className[{}]", KC.threadLocal.getCurrentOrg(), productCd, paramClazzName);
		}
		Map<String, UnifiedParameter> params = unifiedParameterService.retrieveParametersByProductCd(productCd, paramClazzName);
		Map<String, T> result = new HashMap<String, T>();
		for (Entry<String, UnifiedParameter> entry : params.entrySet()) {
			T param = (T)xstream.fromXML(entry.getValue().getParameterXML());
			result.put(entry.getKey(), param);
		}
		return result;
	}
	/** 
	 * <p>
	 * 根据产品编码和class类型加载参数如果没有，则抛异常
	 * </p>
	 * @param key
	 * @param clazz
	 * @return
	 */
	public <T extends Serializable> T loadParameterByProdctCd(String prodctCd, Class<T> clazz) {
		return loadParameterByProdctCd(prodctCd, clazz, false);
	}
	/** 
	 * <p>
	 * 根据产品编码和class类型加载参数如果没有，则抛异常
	 * </p>
	 * @param key
	 * @param clazz
	 * @return
	 */
	public <T extends Serializable> T loadParameterByProdctCd(String prodctCd, Class<T> clazz, boolean nullable) {
		T param = retrieveParameterByProductCd(prodctCd, clazz);
		if (param == null) {
			String msg = MessageFormat.format("机构[{0}]产品编码[{1}]没有取到参数[{2}]。", KC.threadLocal.getCurrentOrg(), prodctCd, clazz);
			logger.error(msg);
			if (!nullable) {
				throw new IllegalArgumentException(msg);
			}
		}
		return param;
	}
	
	/** 
	 * <p>
	 * 根据产品编码和class类型加载参数如果没有，不抛异常
	 * </p>
	 * @param key
	 * @param clazz
	 * @return
	 */
	public <T extends Serializable> T loadParamByProdctCd(String prodctCd, Class<T> clazz) {
		T param = retrieveParameterByProductCd(prodctCd, clazz);
		if (param == null) {
			String msg = MessageFormat.format("机构[{0}]产品编码[{1}]没有取到参数[{2}]。", KC.threadLocal.getCurrentOrg(), prodctCd, clazz);
			logger.info(msg);
		}
		return param;
	}
	
	/**
	 * 清除缓存中的指定参数。仅供内部调用。
	 * 
	 * @param key
	 * @param paramClazzName
	 */
	@CacheEvict(value = "parameterUniqueCache",
			key = "T(cn.sunline.common.KC.threadLocal).getCurrentOrg() + #paramClazzName + #key")
	public void clearParameter(String key, String paramClazzName) {
		logger.info("刷新参数{}, key={}", paramClazzName, key);
	}

	/**
	 * 清除指定的参数集合。仅供内部调用。
	 * 
	 * @param paramClazz
	 */
	@CacheEvict(value = "parameterMapCache",
			key = "T(cn.sunline.common.KC.threadLocal).getCurrentOrg() + #paramClazzName")
	public void clearParameter(String paramClazzName) {
		logger.info("刷新参数集合{}", paramClazzName);
	}
	
	/** 
	 * <p>
	 * 指定产品刷新缓存
	 * </p>
	 * @param productCd
	 * @param paramClazzName
	 */
	@CacheEvict(value = "productParameterCache",
			key = "T(cn.sunline.common.KC.threadLocal).getCurrentOrg() + #paramClazzName + #productCd")
	public void clearParameterByProduct(String productCd, String paramClazzName) {
		logger.info("刷新参数{}, productCd={}", paramClazzName, productCd);
	}

	/**
	 * 清除所有缓存。仅供内部调用
	 */
	@CacheEvict(value = {"parameterUniqueCache", "parameterMapCache", "productParameterCache"}, allEntries = true)
	public void clearAll() {
		logger.info("刷新所有参数");
	}

	/**
	 * 处理刷新参数请求，供bmp-sdk-mq-context.xml中配置的listener调用
	 * 
	 * @param request
	 */
	public void refreshParameter(String key, String paramClassName) {
		logger.info("收到参数刷新请求");
		if (KC.string.isBlank(paramClassName)) {
			clearAll();
		} else {
			// 要把单个参数刷新，同时它所属的集合也要刷新
			clearParameter(key, paramClassName);
			clearParameter(paramClassName);
		}
	}

	public void setUnifiedParameterService(UnifiedParameterService unifiedParameterService) {
		this.unifiedParameterService = unifiedParameterService;
	}
}
