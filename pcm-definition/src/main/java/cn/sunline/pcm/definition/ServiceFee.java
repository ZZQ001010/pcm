package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.BillingCycle;
import cn.sunline.pcm.definition.enums.ChannelFeeCollectionMethod;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.definition.enums.FeeBasis;
import cn.sunline.pcm.definition.enums.FrequencyOfChannel;

/**
 * 服务方服务费
 * @author LHG
 * 主键=编码
 */
public class ServiceFee implements Serializable{

	/**
	 * 服务方服务费编码
	 */
	@PropertyInfo(name="服务方服务费编码",length=15)
	public String serviceFeeNo;
	

	/**
	 * 服务方服务费描述
	 */
	@PropertyInfo(name="服务方服务费描述", length=50)
	public String serviceFeeDesc;
	
	/**
	 * 费用收取方式
	 */
	@PropertyInfo(name="费用收取方式",length=12)
	public ChannelFeeCollectionMethod feeCollectionMethod; 
	
	/**
	 * 费用收取基础
	 */
	@PropertyInfo(name="费用收取基础",length=12)
	public FeeBasis FeeBasis; 
	
	/**
	 * 费用收取频次
	 */
	@PropertyInfo(name="费用收取频次",length=12)
	public FrequencyOfChannel FrequencyOfCharge; 
	
	/**
	 * 收取比例
	 * 例如 30% 填写 0.3
	 */
	@PropertyInfo(name="收取比例",length=12)
	public BigDecimal ChargeRatio; 
	
	/**
	 * 收取金额
	 */
	@PropertyInfo(name="收取金额",length=12)
	public BigDecimal ChargeAmount; 
	
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
	public String TransferAccount; 
	
	/**
	 * 转入账号
	 */
	@PropertyInfo(name="转入账号",length=12)
	public String TransferToAccount; 
	
	/**
	 * 结算周期
	 */
	@PropertyInfo(name="结算周期",length=12)
	public BillingCycle BillingCycle;
	
	
	/**
	 * 结算日期
	 */
	@PropertyInfo(name="结算日期",length=32)
	public String balanceDate;
	
	
	
	
	/**
	 * 结算内容
	 */
	@PropertyInfo(name="结算内容",length=32)
	public String settleAccounts;
	
	
	
	
	
	
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
	
	
	
	public String getServiceFeeNo() {
		return serviceFeeNo;
	}

	public void setServiceFeeNo(String serviceFeeNo) {
		this.serviceFeeNo = serviceFeeNo;
	}

	public String getServiceFeeDesc() {
		return serviceFeeDesc;
	}

	public void setServiceFeeDesc(String serviceFeeDesc) {
		this.serviceFeeDesc = serviceFeeDesc;
	}

	public ChannelFeeCollectionMethod getFeeCollectionMethod() {
		return feeCollectionMethod;
	}

	public void setFeeCollectionMethod(ChannelFeeCollectionMethod feeCollectionMethod) {
		this.feeCollectionMethod = feeCollectionMethod;
	}

	public FeeBasis getFeeBasis() {
		return FeeBasis;
	}

	public void setFeeBasis(FeeBasis feeBasis) {
		FeeBasis = feeBasis;
	}

	public FrequencyOfChannel getFrequencyOfCharge() {
		return FrequencyOfCharge;
	}

	public void setFrequencyOfCharge(FrequencyOfChannel frequencyOfCharge) {
		FrequencyOfCharge = frequencyOfCharge;
	}

	public BigDecimal getChargeRatio() {
		return ChargeRatio;
	}

	public void setChargeRatio(BigDecimal chargeRatio) {
		ChargeRatio = chargeRatio;
	}

	public BigDecimal getChargeAmount() {
		return ChargeAmount;
	}

	public void setChargeAmount(BigDecimal chargeAmount) {
		ChargeAmount = chargeAmount;
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
