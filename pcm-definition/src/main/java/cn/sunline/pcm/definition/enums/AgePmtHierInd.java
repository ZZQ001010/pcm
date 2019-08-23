package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 还款帐龄冲销优先方式
* @author fanghj
 *
 */
@EnumInfo({
	"B|BUCKET优先",
	"P|PLAN优先",
	"D|有DUE(往期欠款)的PLAN优先（有DUE的PLAN之间按照PLAN优先级顺序）"
})
public enum AgePmtHierInd {

	/**
	 * BUCKET优先
	 */
	B,
	/**
	 * PLAN优先
	 */
	P,
	/**
	 * 有DUE的PLAN优先
	 */
	D
}
