package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;


/**
 * 未垫付还款安全垫分润标识
 * 
 * @author zzq
 * @date 2019年8月21日
 *
 */
@EnumInfo({
	"A|不分润",
	"B|分润（比例分润)",
	"C|分润（全额分润）",
})
public enum UnpaidRepaymentSafetyPad {
A,B,C
}
