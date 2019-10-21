package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

@EnumInfo({
	"R|实体账号",
	"V|虚拟账号"
})
public enum SettlementAccountType {

	/**
	 * 实体账号
	 */
	R("实体账号"),
	/**
	 * 虚拟账号
	 */
	V("虚拟账号");
	String desc;
	private SettlementAccountType(String desc){
		this.desc=desc;
	}
	
	public String getDesc(){
		return this.desc;
	}
}
