package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 分段计算方式：
 * F - 使用全部金额（full） 
 * T - 采用分段金额（tier）
 */
@EnumInfo({
	"F|使用全部金额（full）",
	"T|采用分段金额（tier）"
})
public enum TierInd{
	/**
	 * 使用全部金额
	 */
	F,
	/**
	 * 采用分段金额
	 */
	T
}
