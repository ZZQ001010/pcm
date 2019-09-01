package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

@EnumInfo({ 
	"C|使用介质卡号发送",
	"D|使用约定还款卡号发送",
	"L|使用逻辑卡号发送"
	})
public enum SendMessageCardType {
	/**
	 * 介质卡号发送
	 */
	C,
	/**
	 * 约定还款卡号发送
	 */
	D,
	/**
	 * 逻辑卡号发送
	 */
	L
}
