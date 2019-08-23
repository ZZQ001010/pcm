package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 保费缴纳频率
 * @author fgy
 * @date 2019年7月24日
 * 
 *
 */

@EnumInfo({
	"N|年",
	"B|月",
	"J|季度"
	//"Q|分期"
})	
public enum FrequencyOfCharge {

	/**
	 * 年
	 */
	N,
	
	/**
	 * 月
	 */
	B,

    /**
     * 季度
     */
    J
	
}
