package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 结算周期
 * @author lh
 * @date 2019年8月15日
 *
 */
@EnumInfo({
	"MON|星期一",
	"TUE|星期二",
	"WED|星期三",
	"THU|星期四",
	"FRI|星期五",
	"SAT|星期六",
	"SUN|星期日"

})	
public enum BanceDate {
	/**
	 * 星期一
	 */
	MON,
	/**
	 * 星期二
	 */
	TUE,
	/**
	 * 星期三
	 */
	WED,
	/**
	 * 星期四
	 */
	THU,
	/**
	 * 星期五
	 */
	FRI,
	/**
	 * 星期六
	 */
	SAT,
	/**
	 * 星期日
	 */
	SUN
}
