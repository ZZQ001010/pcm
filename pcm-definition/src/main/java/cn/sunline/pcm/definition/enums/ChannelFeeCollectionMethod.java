package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 渠道费用收取方式
 * @author 杨贵博
 *
 */
@EnumInfo({
    "BL|按比例" ,
	"JE|按固定金额"
})
public enum ChannelFeeCollectionMethod {
	/**
	 * 按比例
	 */
	BL,
	/**
	 * 按固定金额
	 */
	JE
}
