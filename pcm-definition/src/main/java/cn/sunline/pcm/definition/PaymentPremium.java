package cn.sunline.pcm.definition;


import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.BillingCycle;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.definition.enums.IsNotParticipate;
import cn.sunline.pcm.definition.enums.PaymentPremiumType;
import cn.sunline.pcm.definition.enums.PremiumAdvanceFlowServiceCharges;
import cn.sunline.pcm.definition.enums.PremiumAdvanceSafetyPadDividedLogo;
import cn.sunline.pcm.definition.enums.UnpaidRepaymentSafetyPad;
import cn.sunline.pcm.definition.enums.UnpaidRepaymentServiceFee;

import java.io.Serializable;

/**
 * 保费垫付
 * @author 王唯
 *
 */
public class PaymentPremium  implements Serializable {

	@PropertyInfo(name="保费垫付编码", length=15)
	public String paymentPremiumCode;
	
	@PropertyInfo(name="保费垫付描述", length=50)
	public String paymentPremiumDesc;
	
	@PropertyInfo(name="保费垫付方式",length=12)
	public PaymentPremiumType paymentPremiumType; 
	
	@PropertyInfo(name="保费垫付安全垫分润标识",length=23)
	public PremiumAdvanceSafetyPadDividedLogo premiumAdvanceSafetyPadDividedLogo;
	
	@PropertyInfo(name="保费垫付流量服务费分润标识",length=23)
	public PremiumAdvanceFlowServiceCharges premiumAdvanceFlowServiceCharges;
	
	@PropertyInfo(name="未垫付还款安全垫分润标识",length=23)
	public UnpaidRepaymentSafetyPad unpaidRepaymentSafetyPad;
	
	@PropertyInfo(name="未垫付还款流量服务费分润标识",length=23)
	public UnpaidRepaymentServiceFee unpaidRepaymentServiceFee;
	
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
	
	@PropertyInfo(name="结算日期",length=12)
	public String balanceDate;

	
	public String getPaymentPremiumCode() {
		return paymentPremiumCode;
	}

	public void setPaymentPremiumCode(String paymentPremiumCode) {
		this.paymentPremiumCode = paymentPremiumCode;
	}

	public String getPaymentPremiumDesc() {
		return paymentPremiumDesc;
	}

	public void setPaymentPremiumDesc(String paymentPremiumDesc) {
		this.paymentPremiumDesc = paymentPremiumDesc;
	}

	public PaymentPremiumType getPaymentPremiumType() {
		return paymentPremiumType;
	}

	public void setPaymentPremiumType(PaymentPremiumType paymentPremiumType) {
		this.paymentPremiumType = paymentPremiumType;
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

	public PremiumAdvanceSafetyPadDividedLogo getPremiumAdvanceSafetyPadDividedLogo() {
		return premiumAdvanceSafetyPadDividedLogo;
	}

	public void setPremiumAdvanceSafetyPadDividedLogo(
			PremiumAdvanceSafetyPadDividedLogo premiumAdvanceSafetyPadDividedLogo) {
		this.premiumAdvanceSafetyPadDividedLogo = premiumAdvanceSafetyPadDividedLogo;
	}

	public PremiumAdvanceFlowServiceCharges getPremiumAdvanceFlowServiceCharges() {
		return premiumAdvanceFlowServiceCharges;
	}

	public void setPremiumAdvanceFlowServiceCharges(PremiumAdvanceFlowServiceCharges premiumAdvanceFlowServiceCharges) {
		this.premiumAdvanceFlowServiceCharges = premiumAdvanceFlowServiceCharges;
	}

	public UnpaidRepaymentSafetyPad getUnpaidRepaymentSafetyPad() {
		return unpaidRepaymentSafetyPad;
	}

	public void setUnpaidRepaymentSafetyPad(UnpaidRepaymentSafetyPad unpaidRepaymentSafetyPad) {
		this.unpaidRepaymentSafetyPad = unpaidRepaymentSafetyPad;
	}

	public UnpaidRepaymentServiceFee getUnpaidRepaymentServiceFee() {
		return unpaidRepaymentServiceFee;
	}

	public void setUnpaidRepaymentServiceFee(UnpaidRepaymentServiceFee unpaidRepaymentServiceFee) {
		this.unpaidRepaymentServiceFee = unpaidRepaymentServiceFee;
	}
	
	
	
	
	
}
