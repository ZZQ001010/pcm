package cn.sunline.pcm.surface.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import com.netflix.discovery.shared.LookupService;

import cn.sunline.common.KC;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.pcm.surface.ParameterRefreshSurface;


/**
 * 
 * @author zzq
 *
 */
@Service
public class ParameterRefreshSurfaceImpl implements ParameterRefreshSurface {
	
	private final static String COLON = ":";
	
	private final static String BACKS_LASH="/";
	
	private final static String HTTP = "http://";
	
	@Value("#{env['dcn']}")
	private String registerDcn = "T134505762"; 
	
	
	@Value("#{env['parameterRefresh.uri']}")
	private String uri = "parameterRefreshService/refreshParameter"; 
	
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	 CloseableHttpClient httpClient = HttpClients.createDefault();
	
	@Autowired
	private LookupService lookupService;
	
	@Override
	public void refreshParameter(String key, String paramClazzName) throws Exception {
		List<Application> registeredApplications = filterApplications(getEurekaRegisteredApps());
		List<List<InstanceInfo>> collect = registeredApplications.stream().map(Application::getInstances).collect(Collectors.toList());
		for (List<InstanceInfo> info : collect) {
			for (InstanceInfo instanceInfo : info) {
				sendNotice(instanceInfo.getHostName(),instanceInfo.getPort());
			}
		}
		logger.info("参数刷新完成!");
	}
	
	/**
	 * 过滤 applications
	 * @return
	 */
	private List<Application> filterApplications(List<Application> apps){
		return apps.stream().filter(app-> app.getName().contains(registerDcn)).collect(Collectors.toList());
	}
	
	/**
	 * 获取eureka 上所有注册的application
	 * @return
	 */
	private List<Application> getEurekaRegisteredApps(){
		Applications applications = lookupService.getApplications();
		List<Application> registeredApplications = applications.getRegisteredApplications();
		return registeredApplications;
	}

	
	/**
	 *  发送通知
	 * @param hostName ip地址
	 * @param port 端口
	 * @throws Exception  处理异常
	 */
	private void  sendNotice(String hostName,Integer port) throws Exception{
		String url = encapsulationUrl(hostName, port, uri);
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(encapsulationMessage());
		try{
		logger.info("url:[{}]",url);
		logger.info("通知ip[{}]，端口port[{}]的参数刷新接口",hostName,port);
		 CloseableHttpResponse result = httpClient.execute(httpPost);
		}catch(Exception ex){
			throw new ProcessException("发送通知失败", ex);
		}finally{
			httpPost.releaseConnection();
		}
	}
	
	
	/**
	 * 拼装url
	 */
	private String encapsulationUrl(String hostName,Integer port,String uri){
		return HTTP+hostName+COLON+port+BACKS_LASH+uri; 
	}
	
	/**
	 * 封装报文
	 */
	private StringEntity  encapsulationMessage(){
		 Map<String, String> encapsulationEntity = encapsulationEntity();
		 String serializerNoType = KC.json.serializerNoType(encapsulationEntity);
		 logger.info("param:[{}]",serializerNoType);
		 StringEntity entity = new StringEntity(serializerNoType,"utf-8");
		 entity.setContentEncoding("UTF-8");
         entity.setContentType("application/json");
		 return entity ; 
	}
	
	
	/**
	 * 封装实体类
	 * @return
	 */
	private Map<String,String> encapsulationEntity(){
		Map<String , String > map = new HashMap<>();
		map.put("arg0_class_type_","java.lang.String");
		map.put("arg0", "null");
		map.put("arg1_class_type_", "java.lang.String");
		map.put("arg1", "");
		return map ; 
	}
 
	
	
	

}
