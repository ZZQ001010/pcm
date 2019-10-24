package cn.sunline.pcm.definition;

import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.BanceDate;
import cn.sunline.pcm.definition.enums.BillingCycle;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;





/**
 * 
 * @author lh
 * 
 * 平台优惠券
 *
 */
public class PlatformCoupon implements Serializable {

	/**
	 * 平台优惠券编码
	 */
	@PropertyInfo(name="平台优惠券编码",length=32)
	public String couponCode;
	
	
	/**
	 * 平台优惠券描述
	 */
	@PropertyInfo(name="平台优惠券描述",length=100)
	public String couponDescription;
	
	
	/**
	 * 所属机构
	 */
	@PropertyInfo(name="所属机构",length=12)
	public String organization; 
	
	
	/**
	 * 合作方类型
	 */
	@PropertyInfo(name="合作方类型",length=12)
	public ChannelPartnerType partnerType; 
	
	
	/**
	 * 合作方编码
	 */
	@PropertyInfo(name="合作方编码",length=12)
	public String partnerCode; 
	
	
	/**
	 * 转出账号
	 */
	@PropertyInfo(name="转出账号",length=12)
	public String transferAccount; 
	
	
	/**
	 * 转入账号
	 */
	@PropertyInfo(name="转入账号",length=12)
	public String transferToAccount; 
	
	
	/**
	 * 结算周期
	 */
	@PropertyInfo(name="结算周期",length=12)
	public BillingCycle billingCycle;
	
	
	/**
	 * 结算日期
	 */
	@PropertyInfo(name="结算日期",length=32)
	public String  balanceDate;
	
	
	/**
	 * 结算内容
	 */
	@PropertyInfo(name="结算内容",length=32)
	public String  settleAccounts;
	
	
	
	
	
	public String getSettleAccounts() {
		return settleAccounts;
	}


	public void setSettleAccounts(String settleAccounts) {
		this.settleAccounts = settleAccounts;
	}


	public String getBalanceDate() {
		return balanceDate;
	}


	public void setBalanceDate(String balanceDate) {
		this.balanceDate = balanceDate;
	}


	public String getCouponCode() {
		return couponCode;
	}


	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}


	public String getCouponDescription() {
		return couponDescription;
	}


	public void setCouponDescription(String couponDescription) {
		this.couponDescription = couponDescription;
	}


	public String getOrganization() {
		return organization;
	}


	public void setOrganization(String organization) {
		this.organization = organization;
	}


	public ChannelPartnerType getPartnerType() {
		return partnerType;
	}


	public void setPartnerType(ChannelPartnerType partnerType) {
		this.partnerType = partnerType;
	}


	public String getPartnerCode() {
		return partnerCode;
	}


	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}


	public String getTransferAccount() {
		return transferAccount;
	}


	public void setTransferAccount(String transferAccount) {
		this.transferAccount = transferAccount;
	}


	public String getTransferToAccount() {
		return transferToAccount;
	}


	public void setTransferToAccount(String transferToAccount) {
		this.transferToAccount = transferToAccount;
	}


	public BillingCycle getBillingCycle() {
		return billingCycle;
	}


	public void setBillingCycle(BillingCycle billingCycle) {
		this.billingCycle = billingCycle;
	}


	
	
}
