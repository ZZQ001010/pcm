package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 到期还款日类型
 */
@EnumInfo({
	"C|账单日",
	"D|账单日后若干天",
	"F|每月固定日期"
})
public enum PaymentDueDay{
	/**
	 * 账单日
	 */
	C,
	/**
	 * 账单日后若干天
	 */
	D,
	/**
	 * 每月固定日期
	 */
	F}
