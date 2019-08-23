package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 放款方式
* @author lisy
 * @date 2015-9-23
 * @version 1.2
 */
@EnumInfo({
	"O|实时放款",
	"B|批量放款"
})
public enum CreditType {

	/**
	 * 实时放款
	 */
	O,
	/**
	 * 批量放款
	 */
	B
}
