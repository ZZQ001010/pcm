package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 费用计算方式
 * @author zzq
 * @date 2019年7月15日
 *
 */
@EnumInfo({
	"A|不收",
	"B|剩余本金百分比",
	"C|剩余保费百分比",
	"D|加收N期保费",
	"E|剩余全部保费",
	"F|固定金额"
})
public enum CostCalculationMethod {

	A,B,C,D,E,F
}
