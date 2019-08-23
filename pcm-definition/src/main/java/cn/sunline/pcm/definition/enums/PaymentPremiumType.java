package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 保费垫付方式
 * @author 王唯
 *
 */
@EnumInfo({
    "A|已到期保费+未到期净保费" ,
	"B|全基础净保费" ,
	"C|全保费"
})
public enum PaymentPremiumType {
	/**
	 * 已到期保费+未到期净保费
	 */
	A,
	/**
	 * 全基础净保费
	 */
	B,
	/**
	 * 全保费
	 */
	C
}
