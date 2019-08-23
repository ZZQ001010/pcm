package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 渠道归属类型
 * @author fwp
 * @date 2019年7月30日
 * 
 *
 */

@EnumInfo({
	"A|资金方",
	"B|资产方",
	"C|渠道方",
	"D|服务方",
	"E|自有机构"
})	
public enum ChannelAttributionType {

	/**
	 * 资金方
	 */
	A,
	
	/**
	 * 资产方
	 */
	B,

    /**
     * 渠道方
     */
    C,
    /**
	 * 服务方
	 */
    D,
    /**
	 * 自有机构
	 */
    E
}
