package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 理赔周期 
 * @author wangyx
 * @version 
 *	@date 创建时间：2018年2月9日  上午11:01:09
 */
@EnumInfo({
	"MonthStart|月初",
	"MonthMid|月中",
	"MonthEnd|月末",
	"SeasonStart|季初",
	"SeasonEnd|季末",
	"YearStart|年初",
	"YearMid|年中",
	"YearEnd|年末",
	"Unlimited|无限制"
})
public enum ClaimCycle {
	
	/**
	 * 月初
	 */
	MonthStart,
	/**
	 * 月中
	 */
	MonthMid,
	/**
	 * 月末
	 */
	MonthEnd,
	/**
	 * 季初
	 */
	SeasonStart,
	/**
	 * 季末
	 */
	SeasonEnd,
	/**
	 * 年初
	 */
	YearStart,
	/**
	 * 年中
	 */
	YearMid,
	/**
	 * 年末
	 */
	YearEnd,
	/**
	 * 无限制
	 */
	Unlimited
	
}
