package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.BanceDate;
import cn.sunline.pcm.definition.enums.BillingCycle;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.definition.enums.DeditBasisOfFeeCollection;
import cn.sunline.pcm.definition.enums.DeditMethodOfFeeCollection;
import cn.sunline.pcm.definition.enums.SafeTymatFeeBasis;

/**
 * 太保违约金收入
 * @author 杨贵博
 *
 */
public class PacificInsuranceAgencyDedit implements Serializable {
	@PropertyInfo(name="违约金编码", length=15)
	public  String deditCode; 
	
	@PropertyInfo(name="违约金描述", length=15)
	public  String deditDesc; 
	
	@PropertyInfo(name="费用收取方式",length=12)
	public DeditMethodOfFeeCollection feeCollectionMethod; 
	
	@PropertyInfo(name="费用收取基础",length=12)
	public DeditBasisOfFeeCollection feeBasis; 
	
	/**
	 *  例如 30% 填写 0.3
	 */
	@PropertyInfo(name="收取比例",length=12)
	public BigDecimal chargeRatio; 
	
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
	
	@PropertyInfo(name="结算星期",length=32)
	public BanceDate banceDate;
	
	
	public BanceDate getBanceDate() {
		return banceDate;
	}


	public void setBanceDate(BanceDate banceDate) {
		this.banceDate = banceDate;
	}
	

	public String getDeditCode() {
		return deditCode;
	}

	public void setDeditCode(String deditCode) {
		this.deditCode = deditCode;
	}

	public String getDeditDesc() {
		return deditDesc;
	}

	public void setDeditDesc(String deditDesc) {
		this.deditDesc = deditDesc;
	}

	public DeditMethodOfFeeCollection getFeeCollectionMethod() {
		return feeCollectionMethod;
	}

	public void setFeeCollectionMethod(DeditMethodOfFeeCollection feeCollectionMethod) {
		this.feeCollectionMethod = feeCollectionMethod;
	}

	public DeditBasisOfFeeCollection getFeeBasis() {
		return feeBasis;
	}

	public void setFeeBasis(DeditBasisOfFeeCollection feeBasis) {
		this.feeBasis = feeBasis;
	}

	public BigDecimal getChargeRatio() {
		return chargeRatio;
	}

	public void setChargeRatio(BigDecimal chargeRatio) {
		this.chargeRatio = chargeRatio;
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
