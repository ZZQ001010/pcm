package cn.sunline.pcm.service.sdk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunline.pcm.service.api.UnifiedParameterRefreshService;

@Service
public class UnifiedParameterRefreshServiceImpl implements UnifiedParameterRefreshService {
	
	@Autowired
	private UnifiedParameterFacility facility;

	@Override
	public void refreshParameter(String key, String paramClazzName) {
		facility.refreshParameter(key, paramClazzName);
	}

}
