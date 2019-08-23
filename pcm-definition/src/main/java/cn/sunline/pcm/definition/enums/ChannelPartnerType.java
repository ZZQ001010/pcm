package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 渠道  合作方类型
 * @author 杨贵博
 *
 */
@EnumInfo({
	"ZJ|资金方",
    "ZC|资产方" ,
	"QD|渠道方",
	"FW|服务方"
})
public enum ChannelPartnerType {
	/**
	 * 资金方
	 */
	ZJ,
	/**
	 * 资产方
	 */
	ZC,
	/**
	 * 渠道方
	 */
	QD,
	/**
	 * 服务方
	 */
	FW
}
