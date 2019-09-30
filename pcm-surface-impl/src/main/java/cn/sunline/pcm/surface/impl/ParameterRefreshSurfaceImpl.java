package cn.sunline.pcm.surface.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunline.pcm.service.api.UnifiedParameterRefreshService;
import cn.sunline.pcm.surface.ParameterRefreshSurface;


@Service
public class ParameterRefreshSurfaceImpl implements ParameterRefreshSurface {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired(required = false)
	private UnifiedParameterRefreshService parameterSurface;

	@Override
	public void refreshParameter(String key, String paramClazzName) throws Exception {
		parameterSurface.refreshParameter(key, paramClazzName);
	}

}
