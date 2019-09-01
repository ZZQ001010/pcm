/**
* @ClassName: FundSideRoutRule
* @Description: TODO()
* @author BlueMelancholy
* @date 2019年7月11日
*
*/
package cn.sunline.pcm.definition;

import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;

/**
 * @author zzq
 * 2019年7月11日
 * 资金方路由规则(主键资金方路由编码)
 */
@SuppressWarnings("serial")
public class FundSideRoutRule implements Serializable{
	/**
	 * 资金方路由编码
	 */
	@PropertyInfo(name="资金方路由编码",length=32)
	public String fundSideRoutCode;
	/**
	 * 资金方路由描述
	 */
	@PropertyInfo(name="资金方路由描述",length=200)
	public String fundSIdeRoutDesc;
	/**
	 * 信保产品的编码描述
	 */
	@PropertyInfo(name="信保产品的编码描述",length=200)
	public String xinBaoProduct;
	/**
	 * 资金方基本信息中的资金方编码-描述
	 */
	@PropertyInfo(name="资金方基本信息中的资金方编码-描述",length=200)
	public String fundSide;
	/**
	 * 对应资金管理系统规则中配置的规则编码
	 */
	@PropertyInfo(name="路由规则编码",length=200)
	public String routRuleCode;
	
	
	
	/**
	 * @return the fundSideRoutCode
	 */
	public String getFundSideRoutCode() {
		return fundSideRoutCode;
	}
	/**
	 * @param fundSideRoutCode the fundSideRoutCode to set
	 */
	public void setFundSideRoutCode(String fundSideRoutCode) {
		this.fundSideRoutCode = fundSideRoutCode;
	}
	/**
	 * @return the fundSIdeRoutDesc
	 */
	public String getFundSIdeRoutDesc() {
		return fundSIdeRoutDesc;
	}
	/**
	 * @param fundSIdeRoutDesc the fundSIdeRoutDesc to set
	 */
	public void setFundSIdeRoutDesc(String fundSIdeRoutDesc) {
		this.fundSIdeRoutDesc = fundSIdeRoutDesc;
	}
	/**
	 * @return the xinBaoProduct
	 */
	public String getXinBaoProduct() {
		return xinBaoProduct;
	}
	/**
	 * @param xinBaoProduct the xinBaoProduct to set
	 */
	public void setXinBaoProduct(String xinBaoProduct) {
		this.xinBaoProduct = xinBaoProduct;
	}
	/**
	 * @return the fundSide
	 */
	public String getFundSide() {
		return fundSide;
	}
	/**
	 * @param fundSide the fundSide to set
	 */
	public void setFundSide(String fundSide) {
		this.fundSide = fundSide;
	}
	/**
	 * @return the routRuleCode
	 */
	public String getRoutRuleCode() {
		return routRuleCode;
	}
	/**
	 * @param routRuleCode the routRuleCode to set
	 */
	public void setRoutRuleCode(String routRuleCode) {
		this.routRuleCode = routRuleCode;
	}
	
}
