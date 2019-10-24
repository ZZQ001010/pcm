package cn.sunline.pcm.definition;


import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.BillingCycle;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;

import java.io.Serializable;

/**
 * 保费垫付返还
 * @author 王唯
 *
 */
public class PaymentPremiumBack implements Serializable {

	@PropertyInfo(name="保费垫付返还编码", length=15)
	public String paymentPremiumBackCode;
	
	@PropertyInfo(name="保费垫付返还描述", length=50)
	public String paymentPremiumBackDesc;
	
	@PropertyInfo(name="所属机构",length=12)
	public String organization; 
	
	@PropertyInfo(name="合作方类型",length=12)
	public ChannelPartnerType partnerType; 
	
	@PropertyInfo(name="合作方编码",length=12)
	public String partnerCode; 
	
	@PropertyInfo(name="转出账号",length=12)
	public String TransferAccount; 
	
	@PropertyInfo(name="转入账号",length=12)
	public String TransferToAccount; 
	
	@PropertyInfo(name="结算周期",length=12)
	public BillingCycle BillingCycle;
	
	/**
	 * 结算日期
	 */
	@PropertyInfo(name="结算日期",length=32)
	public String  balanceDate;
	
	/**
	 * 结算日期
	 */
	@PropertyInfo(name="结算日期",length=32)
	public String  settleAccounts;
	
	
	

	public String getPaymentPremiumBackCode() {
		return paymentPremiumBackCode;
	}

	public void setPaymentPremiumBackCode(String paymentPremiumBackCode) {
		this.paymentPremiumBackCode = paymentPremiumBackCode;
	}

	public String getPaymentPremiumBackDesc() {
		return paymentPremiumBackDesc;
	}

	public void setPaymentPremiumBackDesc(String paymentPremiumBackDesc) {
		this.paymentPremiumBackDesc = paymentPremiumBackDesc;
	}


	public String getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(String balanceDate) {
		this.balanceDate = balanceDate;
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
		return TransferAccount;
	}

	public void setTransferAccount(String transferAccount) {
		TransferAccount = transferAccount;
	}

	public String getTransferToAccount() {
		return TransferToAccount;
	}

	public void setTransferToAccount(String transferToAccount) {
		TransferToAccount = transferToAccount;
	}

	public BillingCycle getBillingCycle() {
		return BillingCycle;
	}

	public void setBillingCycle(BillingCycle billingCycle) {
		BillingCycle = billingCycle;
	}
	
	
}
