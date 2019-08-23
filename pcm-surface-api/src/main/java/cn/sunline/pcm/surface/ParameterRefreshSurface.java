package cn.sunline.pcm.surface;


public interface ParameterRefreshSurface {
	
	/**
	 * 清除缓存中的指定参数
	 * 
	 * @param key
	 * @param paramClazzName
	 */
	public void refreshParameter(String key, String paramClazzName) throws Exception;


}
