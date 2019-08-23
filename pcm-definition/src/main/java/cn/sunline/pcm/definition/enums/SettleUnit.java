package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * @author sky
 * 结算周期
 */
@EnumInfo({
	"D|按日结算",
	"M|按月结算"
})
public enum SettleUnit {
	/**
	 * 日
	 */
	D,
	/**
	 * 月
	 */
	M
}
