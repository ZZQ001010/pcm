package cn.sunline.pcm.definition.product.utils;

import java.util.HashMap;
import java.util.Map;

public class Boolean2Component {
	
	static Map<Boolean,String> map = new HashMap<>();
	
	static{
		map.put(true, "是"); 
		map.put(false, "否"); 
	}
	
	public static Map<Boolean,String> get(){
		return map ; 
	}
	
}

