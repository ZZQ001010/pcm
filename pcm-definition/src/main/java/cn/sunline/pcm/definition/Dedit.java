package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.BanceDate;
import cn.sunline.pcm.definition.enums.BillingCycle;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.definition.enums.DeditBasisOfFeeCollection;
import cn.sunline.pcm.definition.enums.DeditMethodOfFeeCollection;
import cn.sunline.pcm.definition.enums.FeeBasis;
import cn.sunline.pcm.definition.enums.FeeCollectionMethod;

/**
 * 平台违约金
 * @author 杨贵博
 *
 */
public class Dedit implements Serializable{
	private static final long serialVersionUID = 1L;

	@PropertyInfo(name="平台违约金编码", length=15)
	public  String deditCode ; 
	
	@PropertyInfo(name="平台违约金描述", length=15)
	public  String deditDesc ; 
	
	@PropertyInfo(name="费用收取方式",length=12)
	public DeditMethodOfFeeCollection feeCollectionMethod; 
	
	@PropertyInfo(name="费用收取基础",length=12)
	public DeditBasisOfFeeCollection FeeBasis; 
	
	@PropertyInfo(name="收取比例",length=12)
	public BigDecimal ChargeRatio;
	
	@PropertyInfo(name="所属机构",length=12)
	public String organization; 
	
	@PropertyInfo(name="资产方",length=50)
	public String asset; 
	
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
	public String balanceDate;
	
	@PropertyInfo(name="结算星期",length=32)
	public BanceDate banceDate;
	
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


	
	
	public BanceDate getBanceDate() {
		return banceDate;
	}


	public void setBanceDate(BanceDate banceDate) {
		this.banceDate = banceDate;
	}
	
	
	
	
	public String getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(String balanceDate) {
		this.balanceDate = balanceDate;
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
		return FeeBasis;
	}

	public void setFeeBasis(DeditBasisOfFeeCollection feeBasis) {
		FeeBasis = feeBasis;
	}

	public BigDecimal getChargeRatio() {
		return ChargeRatio;
	}

	public void setChargeRatio(BigDecimal chargeRatio) {
		ChargeRatio = chargeRatio;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getAsset() {
		return asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
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
