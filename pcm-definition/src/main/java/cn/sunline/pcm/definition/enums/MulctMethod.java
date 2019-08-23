package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 罚金收取方式
* @author liuqi
 *
 */
@EnumInfo({
	"CPD|按CPD规则收取",
	"DPD|按DPD规则收取"
})
public enum MulctMethod {
	/**
	 * 按CPD规则收取
	 */
	CPD,
	/**
	 * 按DPD规则收取
	 */
	DPD
}
