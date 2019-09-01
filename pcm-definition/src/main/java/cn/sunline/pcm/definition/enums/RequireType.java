package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 电子资料类型必填性
 * @author lisy
 *
 */
@EnumInfo({
	"M|必送",
	"O|选送",
	"N|不送"
})
public enum RequireType {
	/**
	 * 必送
	 */
	M("必送"),
	/**
	 * 选送
	 */
	O("选送"),
	/**
	 * 不送
	 */
	N("不送");
	String desc;
	private RequireType(String desc){
		this.desc=desc;
	}
	
	public String getDesc(){
		return this.desc;
	}
}
