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
	"F|资金方",
	"A|资产方",
	"O|自有"
})
public enum AccountOwner {
	/**
	 * 资金方
	 */
	F,
	/**
	 * 资产方
	 */
	A,
	/**
	 * 渠道方
	 */
	Q,
	/**
	 * 服务方
	 */
	Z,
	/**
	 * 自有
	 */
	O
	
}
