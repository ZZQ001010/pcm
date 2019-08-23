package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

@EnumInfo({
	"Yes|允许",
	"No|禁止"
})	
public enum AuthFlagAction {
	/**
	 * 允许
	 */
	Yes, 
	/**
	 * 禁止
	 */
	No
}
