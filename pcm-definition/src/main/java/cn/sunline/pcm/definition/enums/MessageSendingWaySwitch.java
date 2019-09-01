package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 信息接口开关
 * 
* @author alen
 */
@EnumInfo({
	"BatchOnly|仅开放批量接口",
	"OnlineOnly|仅开放联机接口",
	"BatchOnline|联机批量接口均开放",
	"NONE|不开放任何信息接口"
})
public enum MessageSendingWaySwitch {
	/**
	 * 仅开放批量接口
	 */
	BatchOnly, 
	
	/**
	 * 仅开放联机接口
	 */
	OnlineOnly,
	
	/**
	 * 联机批量接口均开放
	 */
	BatchOnline, 
	
	/**
	 * 不开放任何信息接口
	 */
	NONE
}
