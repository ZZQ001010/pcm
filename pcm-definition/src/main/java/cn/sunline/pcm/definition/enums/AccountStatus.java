package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 账户状态
* @author alen
 *
 */
@EnumInfo({
	"N|新增",
	"A|活动",
	"L|锁定"
})
public enum AccountStatus {
	/**
	 * 新增
	 */
	N,
	/**
	 * 活动
	 */
	A,
	/**
	 * 锁定
	 */
	L
}
