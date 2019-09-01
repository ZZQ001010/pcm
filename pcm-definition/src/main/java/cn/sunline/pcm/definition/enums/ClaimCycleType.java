package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 理赔周期方式
 * @author wangyx
 * @version 
 *	@date 创建时间：2018年2月9日  上午10:51:14
 */
@EnumInfo({
	"ByOverDue|按逾期天数理赔",
	"ByFixDay|按固定理赔日理赔"
})
public enum ClaimCycleType {
	/**
	 * 按逾期天数理赔
	 */
	ByOverDue,
	
	/**
	 *按固定理赔日理赔
	 */
	ByFixDay;
}
