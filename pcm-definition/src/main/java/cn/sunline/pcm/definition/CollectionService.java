package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.BanceDate;
import cn.sunline.pcm.definition.enums.BillingCycle;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.definition.enums.FeeBasis;
import cn.sunline.pcm.definition.enums.FeeCollectionMethod;

/**
 *  催收服务费
 * @author ww
 * @date 2019年7月15日
 *
 */
public class CollectionService implements Serializable{

	
	
	
	@PropertyInfo(name="催收服务费", length=15)
	public  String code ; 
	
	@PropertyInfo(name="催收服务描述", length=50)
	public  String desc ;
	
	@PropertyInfo(name="费用收取方式",length=12)
	public FeeCollectionMethod feeCollectionMethod; 
	
	@PropertyInfo(name="费用收取基础",length=12)
	public FeeBasis feeBasis; 
	
	/**
	 *  例如 30% 填写 0.3
	 */
	@PropertyInfo(name="收取比例",length=12)
	public BigDecimal chargeRatio; 
	
	@PropertyInfo(name = "最大收取期数",length=32)
	public String periodsMax;
	
	@PropertyInfo(name="资产方编码")
	public  String assetSideCode ;
	
	/**
	 * 机构编码
	 */
	@PropertyInfo(name = "机构编码",length=32)
	public String orgCode;
	
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
	
	@PropertyInfo(name="转出账号",length=12)
	public String transferAccount; 
	
	@PropertyInfo(name="转入账号",length=12)
	public String transferToAccount; 
	
	@PropertyInfo(name="结算周期",length=12)
	public BillingCycle billingCycle;
	
	/**
	 * 结算日期
	 */
	@PropertyInfo(name="结算日期",length=32)
	public String balanceDate;
	
	@PropertyInfo(name="结算星期",length=32)
	public BanceDate banceDate;
	
	
	@PropertyInfo(name="结算信息",length=32)
	public String  settleAccounts ; 
	
	
	
	
	
	
	public String getSettleAccounts() {
		return settleAccounts;
	}


	public void setSettleAccounts(String settleAccounts) {
		this.settleAccounts = settleAccounts;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public FeeCollectionMethod getFeeCollectionMethod() {
		return feeCollectionMethod;
	}

	public void setFeeCollectionMethod(FeeCollectionMethod feeCollectionMethod) {
		this.feeCollectionMethod = feeCollectionMethod;
	}

	public FeeBasis getFeeBasis() {
		return feeBasis;
	}

	public void setFeeBasis(FeeBasis feeBasis) {
		this.feeBasis = feeBasis;
	}

	public BigDecimal getChargeRatio() {
		return chargeRatio;
	}

	public void setChargeRatio(BigDecimal chargeRatio) {
		this.chargeRatio = chargeRatio;
	}

	public String getPeriodsMax() {
		return periodsMax;
	}

	public void setPeriodsMax(String periodsMax) {
		this.periodsMax = periodsMax;
	}

	public String getAssetSideCode() {
		return assetSideCode;
	}

	public void setAssetSideCode(String assetSideCode) {
		this.assetSideCode = assetSideCode;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
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
