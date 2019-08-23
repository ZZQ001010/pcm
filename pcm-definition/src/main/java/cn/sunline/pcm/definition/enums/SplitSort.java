package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 拆分后金额排序
* @author songyanchao
 *
 */
@EnumInfo({
	"A|金额由小到大",
	"D|金额由大到小"
})
public enum SplitSort {
	/**
	 * 金额由小到大
	 */
	A,
	/**
	 * 金额由大到小
	 */
	D
}
