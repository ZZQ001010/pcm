package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 费用累计年天数
 * @author cy
 *
 */

@EnumInfo({
	"A|360",
	"B|365"
})
public enum Accumulated {
	/**
	 * 360
	 */
	A,
	
	/**
	 * 365
	 */
	B
}
