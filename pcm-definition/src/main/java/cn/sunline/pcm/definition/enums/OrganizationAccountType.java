/**
* @ClassName: AccountOwne,
* 
* @Description: TODO()
* @author BlueMelancholy
* @date 2019年7月10日
*
*/
package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 账户归属
 * @author BlueMelancholy
 * 2019年7月10日
 */
@EnumInfo({
	"B|保费收入",
	"Z|追偿收入",
	"L|理赔支出",
	"J|借款人对公还款"
})
public enum OrganizationAccountType {
	/**
	 * 保费收入
	 */
	B,
	/**
	 * 保费收入
	 */
	Z,
	/**
	 * 理赔支出
	 */
	L,
	/**
	 * 借款人对公还款
	 */
	J
}
