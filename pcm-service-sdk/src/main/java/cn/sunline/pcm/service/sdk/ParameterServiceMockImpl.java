package cn.sunline.pcm.service.sdk;

import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import cn.sunline.pcm.service.api.UnifiedParameter;
import cn.sunline.pcm.service.api.UnifiedParameterService;

/**
 * 用于测试的参数mock对象，可以直接注入所有参数
 * 
 * @author alen
 *
 */
public class ParameterServiceMockImpl implements UnifiedParameterService {

	private Map<String, Map<String, UnifiedParameter>> parameters =
			new HashMap<String, Map<String, UnifiedParameter>>();

	private XStream xstream = new XStream(new DomDriver());

	@Override
	public UnifiedParameter retrieveParameter(String key, String paramClazz) {
		if (key == null){
			key = "*";}
		Map<String, ?> map = parameters.get(paramClazz);
		
		if (map == null){
			return null;}
		return (UnifiedParameter)map.get(key);
	}

	public <T> void putParameter(String key, T parameter) {
		if (key == null){
			key = "*";
			}
		Class<?> clazz = parameter.getClass();
		if (!parameters.containsKey(clazz.getCanonicalName())){
			parameters.put(clazz.getCanonicalName(), new HashMap<String, UnifiedParameter>());}
		UnifiedParameter up = new UnifiedParameter();
		up.setParameterXML(xstream.toXML(parameter));
		parameters.get(clazz.getCanonicalName()).put(key, up);
		
	}
	@Override
	public Map<String, UnifiedParameter> retrieveParameter(String paramClazz) {
		return parameters.get(paramClazz);
	}
	
	public Map<String, Map<String, UnifiedParameter>> getParameters() {
		return parameters;
	}

	@Override
	public UnifiedParameter retrieveParameterByProductCd(String productCd, String paramClazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, UnifiedParameter> retrieveParametersByProductCd(String productCd, String paramClazz) {
		// TODO Auto-generated method stub
		return null;
	}
}
