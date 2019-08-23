package cn.sunline.pcm.service.api;

/**
 * 参数相关，目前只是参数刷新服务
 *
* @author alen
 *
 */
public interface UnifiedParameterRefreshService {
	
	/**
	 * 刷新缓存中的指定参数
	 * 
	 * @param key
	 * @param paramClazzName
	 */
	public void refreshParameter(String key, String paramClazzName);


}
