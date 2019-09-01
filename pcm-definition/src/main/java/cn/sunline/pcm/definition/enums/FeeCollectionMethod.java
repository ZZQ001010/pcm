package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 费用收取方式
 * @author fgy
 * @date 2019年7月24日
 * 基于本金、基于剩余金额
 *
 */
@EnumInfo({
	//"A|按比例",
	//"C|按固定金额",
    "D|基于本金" ,
	"U|按剩余金额"
})	
public enum FeeCollectionMethod {
    /**
     * 基于本金
     */
    D,

    /**
     * 基于剩余金额
     */
    U
}
