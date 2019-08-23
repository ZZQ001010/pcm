package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

@EnumInfo({
	"L|使用全部信用额度",
	"C|使用取现信用额度"
})
public enum CashLoanLimitType {

	/**
	 * 使用全部信用额度
	 */
	L,
	/**
	 * 使用取现信用额度
	 */
	C
}
