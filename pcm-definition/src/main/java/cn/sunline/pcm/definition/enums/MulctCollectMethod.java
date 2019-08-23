package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 罚金计算方式
* @author songyanchao
 *
 */
@EnumInfo({
	"D|按金额收取",
	"R|按利率收取"
})
public enum MulctCollectMethod {
	/**
	 * 按金额收取
	 */
	D,
	/**
	 * 按费率收取
	 */
	R
}
