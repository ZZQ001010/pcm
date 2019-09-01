package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 渠道   收取频次
 * @author 杨贵博
 *
 */
@EnumInfo({
    "Y|一次性" ,
	"Q|分期"
})
public enum FrequencyOfChannel {
	/**
	 * 一次性
	 */
	Y,
	/**
	 * 分期
	 */
	Q
}
