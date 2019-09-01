package cn.sunline.pcm.service.api;

import java.util.Map;

/** 
 * <p>
 * 全局参数服务
 * </p>
 * @version 1.0 2017年5月27日 linxiaocheng 修改内容:初版
 */ 
public interface UnifiedParameterService {

	/**
	 * 取单一参数
	 * 
	 * @param key 参数的主键
	 * @param paramClass 参数类全名
	 */
	UnifiedParameter retrieveParameter(String key, String paramClazz);

	/**
	 * 取所有该参数类的参数，以参数主键为key的一个Map
	 * 
	 * @param paramClass
	 * @return
	 */
	Map<String, UnifiedParameter> retrieveParameter(String paramClazz);
	
	/**
	 * 根据产品编码取单一参数
	 * 
	 * @param key 参数的主键
	 * @param paramClass 参数类全名
	 */
	UnifiedParameter retrieveParameterByProductCd(String productCd, String paramClazz);

	/**
	 * 根据产品编码取所有该参数类的参数，以参数主键为key的一个Map
	 * 
	 * @param paramClass
	 * @return
	 */
	Map<String, UnifiedParameter> retrieveParametersByProductCd(String productCd, String paramClazz);
}
