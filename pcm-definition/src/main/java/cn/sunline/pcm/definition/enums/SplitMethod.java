package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 拆分方式
* @author songyanchao
 *
 */
@EnumInfo({
	"A|按比例拆分",
	"B|按固定金额"
})
public enum SplitMethod {
	/**
	 * 按比例拆分
	 */
	A,
	/**
	 * 按固定金额
	 */
	B
}
