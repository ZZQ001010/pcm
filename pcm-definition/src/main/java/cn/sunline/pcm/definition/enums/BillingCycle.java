package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 结算周期
 * @author zzq
 * @date 2019年7月15日
 *
 */
@EnumInfo({
	"A|按天",
	"Z|按周",
	"C|按月",
	"I|按年"
})	
public enum BillingCycle {

	/**
	 * 按天
	 */
	A,
	/**
	 * 按周
	 */
	Z,
	/**
	 * 按月
	 */
	C,
	/**
	 * 按年
	 */
	I
}
