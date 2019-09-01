package cn.sunline.pcm.controller.common;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.sunline.pcm.definition.PcmSettleAccMan;
import cn.sunline.pcm.surface.api.ParameterSurface;

/**
 * 费用公共类
 * @author zzq
 * @date 2019年8月28日
 *
 */
@Component
public class Fee {
	
	@Autowired
	protected ParameterSurface parameterSurface;
	
	
	/**
	 * 获取账号管理中的所有账号
	 * @return
	 */
	public  Map<String,String> getPcmSettleAccManList(){
		return parameterSurface.getParameterObject(PcmSettleAccMan.class)
				.stream().collect(Collectors.
						toMap(PcmSettleAccMan::getSettleAccCode,
								x->x.getSettleAccCode()+"-"+x.getSettleAccDes()));
	}
	
	public  String getPcmSettleAccMan(String code){
		return getPcmSettleAccManList().get(code);
	}
}
