package cn.sunline.pcm.definition.enums;


import cn.sunline.common.annotation.enums.EnumInfo;

// FIXME 账户类型需包含3个维度，业务类型、入账币种、是否共享额度
@EnumInfo({
	"S|正确",
	"E|差错",
	"O|已修正"
	
})
public enum ResultCode {
	/**
	 * 正确
	 */
	S,
	/**
	 * 差错
	 */
	E,
	/**
	 * 已修正
	 */
	O
}