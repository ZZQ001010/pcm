package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.AdvanceSettlement;
import cn.sunline.pcm.definition.enums.BanceDate;
import cn.sunline.pcm.definition.enums.BillingCycle;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.definition.enums.Expenses;
import cn.sunline.pcm.definition.enums.FeeBasis;
import cn.sunline.pcm.definition.enums.FeeCollectionMethod;
import cn.sunline.pcm.definition.enums.FrequencyOfCharge;

/**
 * 流量服务费
 * @author zzq
 * @date 2019年7月15日
 *
 */
@SuppressWarnings("serial")
public class TrafficServiceFee implements Serializable{

	@PropertyInfo(name="流量服务费", length=15)
	public  String trafficServiceFeeCode ; 
	
	@PropertyInfo(name="所属机构", length=50)
	public  String organization ;
	
	@PropertyInfo(name="资产方", length=50)
	public  String asset ;
	
	@PropertyInfo(name="转出账号", length=50)
	public  String transferAccount ;
	
	@PropertyInfo(name="流量服务描述", length=50)
	public  String trafficServiceFeeDesc ;
	
//	@PropertyInfo(name="单笔最小金额", length=15)
//	public  BigDecimal singleMinimumAmount ;
//	
//	@PropertyInfo(name="单笔最大金额", length=15)
//	public  BigDecimal singleMaximumAmount ;
	
	@PropertyInfo(name="费用收取方式",length=12)
	public FeeCollectionMethod feeCollectionMethod; 
	
	@PropertyInfo(name="费用收取基础",length=12)
	public FeeBasis feeBasis; 
	
	@PropertyInfo(name="费用收取频次",length=12)
	public FrequencyOfCharge frequencyOfCharge; 
	
	/**
	 *  例如 30% 填写 0.3
	 */
	@PropertyInfo(name="收取比例",length=12)
	public BigDecimal chargeRatio; 
	
//	@PropertyInfo(name="收取金额",length=12)
//	public BigDecimal chargeAmount; 
	
	@PropertyInfo(name="转入账号",length=12)
	public String transferToAccount; 
	
	@PropertyInfo(name="结算周期",length=12)
	public BillingCycle billingCycle;
	
	/**
	 * 结算日期
	 */
	@PropertyInfo(name="结算日期",length=32)
	public String balanceDate;
	
	/**
	 * 
	 * @return
	 */
	@PropertyInfo(name="结算星期",length=32)
	public BanceDate banceDate;
	
	/**
	 * 
	 * @return
	 */
	@PropertyInfo(name="流量服务费折扣",length=12)
	public BigDecimal trafficService; 
	
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
	 * 
	 *  费用累计月天数
	 */
	@PropertyInfo(name="费用累计月天数",length=32)
	public Expenses expenses;
	
	
	/**
	 * 
	 *  费用累计月天数
	 */
	@PropertyInfo(name="结算信息",length=32)
	public String settleAccounts;
	
	
	
	
	///**
	// *  放款当天提前结清费用收取方式
	// * @return
	// */
	//@PropertyInfo(name="放款当天提前结清费用收取方式",length=32)
	//public AdvanceSettlement advanceSettlement;
	
	
	
	//public AdvanceSettlement getAdvanceSettlement() {
	//	return advanceSettlement;
	//}
    //
    //
	//public void setAdvanceSettlement(AdvanceSettlement advanceSettlement) {
	//	this.advanceSettlement = advanceSettlement;
	//}

	
	

	public String getSettleAccounts() {
		return settleAccounts;
	}


	public void setSettleAccounts(String settleAccounts) {
		this.settleAccounts = settleAccounts;
	}


	public Expenses getExpenses() {
		return expenses;
	}


	public void setExpenses(Expenses expenses) {
		this.expenses = expenses;
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


	public BigDecimal getTrafficService() {
		return trafficService;
	}


	public void setTrafficService(BigDecimal trafficService) {
		this.trafficService = trafficService;
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

	public String getTrafficServiceFeeCode() {
		return trafficServiceFeeCode;
	}

	public void setTrafficServiceFeeCode(String trafficServiceFeeCode) {
		this.trafficServiceFeeCode = trafficServiceFeeCode;
	}

	public String getTrafficServiceFeeDesc() {
		return trafficServiceFeeDesc;
	}

	public void setTrafficServiceFeeDesc(String trafficServiceFeeDesc) {
		this.trafficServiceFeeDesc = trafficServiceFeeDesc;
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
		return transferAccount;
	}

	public void setTransferAccount(String transferAccount) {
		this.transferAccount = transferAccount;
	}

//	public BigDecimal getSingleMinimumAmount() {
//		return singleMinimumAmount;
//	}
//
//	public void setSingleMinimumAmount(BigDecimal singleMinimumAmount) {
//		this.singleMinimumAmount = singleMinimumAmount;
//	}
//
//	public BigDecimal getSingleMaximumAmount() {
//		return singleMaximumAmount;
//	}
//
//	public void setSingleMaximumAmount(BigDecimal singleMaximumAmount) {
//		this.singleMaximumAmount = singleMaximumAmount;
//	}

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

	public FrequencyOfCharge getFrequencyOfCharge() {
		return frequencyOfCharge;
	}

	public void setFrequencyOfCharge(FrequencyOfCharge frequencyOfCharge) {
		this.frequencyOfCharge = frequencyOfCharge;
	}

	public BigDecimal getChargeRatio() {
		return chargeRatio;
	}

	public void setChargeRatio(BigDecimal chargeRatio) {
		this.chargeRatio = chargeRatio;
	}

//	public BigDecimal getChargeAmount() {
//		return chargeAmount;
//	}
//
//	public void setChargeAmount(BigDecimal chargeAmount) {
//		this.chargeAmount = chargeAmount;
//	}

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
