package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 超限费计算方法：
 * H - 最高超限>金额
 * P - 超限费入账当天超限金额
 */
@EnumInfo({
	"H|最高超限>金额",
	"P|超限费入账当天超限金额"
})
public enum OverlimitCalcInd{
	/**
	 * 高超限>金额
	 */
	H,
	/**
	 * 超限费入账当天超限金额
	 */
	P
}
