package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.BanceDate;
import cn.sunline.pcm.definition.enums.BillingCycle;
import cn.sunline.pcm.definition.enums.Expenses;
import cn.sunline.pcm.definition.enums.Indicator;
import cn.sunline.pcm.definition.enums.SafeTyFeeCollectionMethod;
import cn.sunline.pcm.definition.enums.SafeTyMatFrequencyOfCharge;
import cn.sunline.pcm.definition.enums.SafeTymatFeeBasis;
import cn.sunline.pcm.definition.enums.SafetyPadLowerLimitControlMode;
import cn.sunline.pcm.definition.enums.Settlement;
import cn.sunline.pcm.definition.enums.TechnicalServiceFeeCollectionBasics;
import cn.sunline.pcm.definition.enums.TechnicalServiceFeeCollectionMethod;

/**
 * 安全垫
 * @author zzq
 * @date 2019年7月15日
 *
 */

@SuppressWarnings("serial")
public class SafetyMat implements Serializable{

	@PropertyInfo(name="安全垫编码", length=15)
	public  String code ; 
	
	@PropertyInfo(name="安全垫描述", length=50)
	public  String desc ;
	
	@PropertyInfo(name="费用收取方式",length=12)
	public SafeTyFeeCollectionMethod feeCollectionMethod; 
	
	@PropertyInfo(name="费用收取基础",length=12)
	public SafeTymatFeeBasis feeBasis; 
	
	@PropertyInfo(name="费用收取频次",length=12)
	public SafeTyMatFrequencyOfCharge frequencyOfCharge; 
	
	/**
	 *  例如 30% 填写 0.3
	 */
	@PropertyInfo(name="收取比例",length=12)
	public BigDecimal chargeRatio; 
	
	@PropertyInfo(name="所属机构",length=12)
	public String organization; 
	
	@PropertyInfo(name="资产方",length=50)
	public String asset; 
	
	@PropertyInfo(name="安全垫下限控制方式",length=12)
	public SafetyPadLowerLimitControlMode controlMode ; 
	
	@PropertyInfo(name="安全垫下限控制比例",length=12)
	public BigDecimal controlRatio ; 
	
	@PropertyInfo(name="安全垫下限控制金额",length=12)
	public BigDecimal controlMoney ; 
	
	@PropertyInfo(name="技术服务费收取方式",length=12)
	public TechnicalServiceFeeCollectionMethod chargeWay; 
	
	@PropertyInfo(name="技术服务费收取基础",length=12)
	public TechnicalServiceFeeCollectionBasics chargeBasics; 
	
	@PropertyInfo(name="转出账号",length=12)
	public String transferAccount; 
	
	@PropertyInfo(name="转入账号",length=12)
	public String transferToAccount; 
	
	@PropertyInfo(name="结算周期",length=12)
	public BillingCycle billingCycle;
	
	@PropertyInfo(name="起始结算逾期周期",length=12)
	public String period ;
	
	@PropertyInfo(name="起始结算逾期周期数量",length=12)
	public Integer periodNum ;
	
	//@PropertyInfo(name="保费垫付是否参与分润",length=12)
	//public Indicator participationStatus  ;
	
	
	/**
	 * 结算日期
	 */
	@PropertyInfo(name="结算日期",length=32)
	public String balanceDate;
	
	
	/**
	 * 
	 */
	@PropertyInfo(name="结算星期",length=32)
	public BanceDate banceDate;
	
	
	

	/**
	 * 费用累计月天数
	 * @return
	 */
	@PropertyInfo(name="费用累计月天数",length=32)
	public Expenses expenses;
	
	
	/**
	 * 放款当天提前结清费用收取方式
	 * @return
	 */
	@PropertyInfo(name="提前结清费用收取方式",length=32)
	public Settlement settlement;
	
	
	/**
	 * 放款当天提前还款费用收取方式
	 * @return
	 */
	//@PropertyInfo(name="提前还款费用收取方式",length=32)
	//public Settlement backsettlement;
	
	
	
	//public Settlement getBacksettlement() {
	//	return backsettlement;
	//}
    //
    //
	//public void setBacksettlement(Settlement backsettlement) {
	//	this.backsettlement = backsettlement;
	//}


	public Expenses getExpenses() {
		return expenses;
	}


	public void setExpenses(Expenses expenses) {
		this.expenses = expenses;
	}


	public Settlement getSettlement() {
		return settlement;
	}


	public void setSettlement(Settlement settlement) {
		this.settlement = settlement;
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

	public SafeTyFeeCollectionMethod getFeeCollectionMethod() {
		return feeCollectionMethod;
	}

	public void setFeeCollectionMethod(SafeTyFeeCollectionMethod feeCollectionMethod) {
		this.feeCollectionMethod = feeCollectionMethod;
	}

	public SafeTymatFeeBasis getFeeBasis() {
		return feeBasis;
	}

	public void setFeeBasis(SafeTymatFeeBasis feeBasis) {
		this.feeBasis = feeBasis;
	}

	public SafeTyMatFrequencyOfCharge getFrequencyOfCharge() {
		return frequencyOfCharge;
	}

	public void setFrequencyOfCharge(SafeTyMatFrequencyOfCharge frequencyOfCharge) {
		this.frequencyOfCharge = frequencyOfCharge;
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

	public String getAsset() {
		return asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}

	public SafetyPadLowerLimitControlMode getControlMode() {
		return controlMode;
	}

	public void setControlMode(SafetyPadLowerLimitControlMode controlMode) {
		this.controlMode = controlMode;
	}

	public BigDecimal getControlRatio() {
		return controlRatio;
	}

	public void setControlRatio(BigDecimal controlRatio) {
		this.controlRatio = controlRatio;
	}

	public BigDecimal getControlMoney() {
		return controlMoney;
	}

	public void setControlMoney(BigDecimal controlMoney) {
		this.controlMoney = controlMoney;
	}

	public TechnicalServiceFeeCollectionMethod getChargeWay() {
		return chargeWay;
	}

	public void setChargeWay(TechnicalServiceFeeCollectionMethod chargeWay) {
		this.chargeWay = chargeWay;
	}

	public TechnicalServiceFeeCollectionBasics getChargeBasics() {
		return chargeBasics;
	}

	public void setChargeBasics(TechnicalServiceFeeCollectionBasics chargeBasics) {
		this.chargeBasics = chargeBasics;
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

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public Integer getPeriodNum() {
		return periodNum;
	}

	public void setPeriodNum(Integer periodNum) {
		this.periodNum = periodNum;
	}

	//public Indicator getParticipationStatus() {
	//	return participationStatus;
	//}
    //
	//public void setParticipationStatus(Indicator participationStatus) {
	//	this.participationStatus = participationStatus;
	//}

	
	

	
}
