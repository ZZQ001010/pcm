package cn.sunline.pcm.definition;

import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.BillingCycle;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.definition.enums.PrepaymentFeeMethod;
import cn.sunline.pcm.definition.enums.Settlement;

/**
 * 提前还款手续费
 * @author 杨贵博
 *
 */
public class PrepaymentFee implements Serializable {
	@PropertyInfo(name="提前还款手续费编码", length=15)
	public  String prepaymentFeeCode; 
	
	@PropertyInfo(name="提前还款手续费描述", length=15)
	public  String prepaymentFeeDesc; 
	
	@PropertyInfo(name="费用收取方式",length=12)
	public PrepaymentFeeMethod feeCollectionMethod; 
	
	@PropertyInfo(name="放款当天提前结清费用收取方式",length=2)
	public Settlement loanDayFeeColMethod;
	
	@PropertyInfo(name="所属机构",length=12)
	public String organization;
	
	@PropertyInfo(name="合作方类型",length=12)
	public ChannelPartnerType partnerType; 
	
	@PropertyInfo(name="合作方编码",length=12)
	public String partnerCode;
	
	@PropertyInfo(name="转出账号",length=12)
	public String transferAccount; 
	
	@PropertyInfo(name="转入账号",length=12)
	public String transferToAccount;
	
	@PropertyInfo(name="结算周期",length=12)
	public BillingCycle billingCycle;
	
	@PropertyInfo(name="结算日期",length=12)
	public String balanceDate;

	
	
	public String getPrepaymentFeeCode() {
		return prepaymentFeeCode;
	}

	public void setPrepaymentFeeCode(String prepaymentFeeCode) {
		this.prepaymentFeeCode = prepaymentFeeCode;
	}

	public String getPrepaymentFeeDesc() {
		return prepaymentFeeDesc;
	}

	public void setPrepaymentFeeDesc(String prepaymentFeeDesc) {
		this.prepaymentFeeDesc = prepaymentFeeDesc;
	}

	public PrepaymentFeeMethod getFeeCollectionMethod() {
		return feeCollectionMethod;
	}

	public void setFeeCollectionMethod(PrepaymentFeeMethod feeCollectionMethod) {
		this.feeCollectionMethod = feeCollectionMethod;
	}

	public Settlement getLoanDayFeeColMethod() {
		return loanDayFeeColMethod;
	}

	public void setLoanDayFeeColMethod(Settlement loanDayFeeColMethod) {
		this.loanDayFeeColMethod = loanDayFeeColMethod;
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

	public String getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(String balanceDate) {
		this.balanceDate = balanceDate;
	}
	
	
}
