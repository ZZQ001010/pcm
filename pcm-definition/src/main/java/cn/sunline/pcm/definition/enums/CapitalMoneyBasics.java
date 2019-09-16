package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 资金方技术费用收取基础
* @author ygb
 *
 */
@EnumInfo({
	"BJ|基于保费",
	"FBJ|非基于本金"
})
public enum CapitalMoneyBasics {
	/**
	 * 基于本金
	 */
	BJ,
	
	/**
	 * 非基于本金
	 */
	FBJ
}
