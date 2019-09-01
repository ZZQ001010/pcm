package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.*;

/**
 *  基础净含保费
 * @author zzq
 * @date 2019年7月15日
 *
 */
@SuppressWarnings("serial")
public class BasicNetPremium implements Serializable{

	@PropertyInfo(name="流量服务费", length=15)
	public  String code ; 
	
	@PropertyInfo(name="流量服务描述", length=50)
	public  String desc ;
	
	@PropertyInfo(name="单笔最小金额", length=15)
	public  BigDecimal  minimumAmount ;
	
	@PropertyInfo(name="单笔最大金额", length=15)
	public  BigDecimal maximumAmount ;
	
	@PropertyInfo(name="费用收取方式",length=12)
	public FeeCollectionMethod feeCollectionMethod; 
	
	@PropertyInfo(name="费用收取基础",length=12)
	public FeeBasis feeBasis; 
	
	@PropertyInfo(name="费用收取频次",length=12)
	public FrequencyTimes frequencyOfCharge; 
	
	/**
	 *  例如 30% 填写 0.3
	 */
	@PropertyInfo(name="收取比例",length=12)
	public BigDecimal chargeRatio; 
	
//	
//	@PropertyInfo(name="收取金额",length=12)
//	public BigDecimal chargeAmount; 


	@PropertyInfo(name="转出账号",length=12)
	public String transferAccount; 
	
	@PropertyInfo(name="转入账号",length=12)
	public String transferToAccount; 
	
	@PropertyInfo(name="结算周期",length=12)
	public BillingCycle billingCycle;
	
	@PropertyInfo(name="上限控制方式",length=12)
	public LimitControlMethod upperLimitControlMethod;
	
	/**
	 *  例如 30% 填写 0.3
	 */
	@PropertyInfo(name="上限控制比例",length=12)
	public BigDecimal upperLimitControlRatio; 
	
	/**
	 * 上限控制金额
	 */
	@PropertyInfo(name="上限控制金额",length=12)
	public BigDecimal upperControlAmount; 
	
	
	@PropertyInfo(name="下限控制方式",length=12)
	public LimitControlMethod downLimitControlMethod;
	
	
	/**
	 *  例如 30% 填写 0.3
	 */
	@PropertyInfo(name="上限控制比例",length=12)
	public BigDecimal downLimitControlRatio; 
	
	/**
	 * 上限控制金额
	 */
	@PropertyInfo(name="上限控制金额",length=12)
	public BigDecimal downControlAmount;
	
	/**
	 * 资产方编码
	 */
	@PropertyInfo(name="资产方编码")
	public  String assetSideCode ;
	
	/**
	 * 机构编码
	 */
	@PropertyInfo(name = "机构编码",length=32)
	public String orgCode;

	
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
	 * 费用累计月天数
	 * @return
	 */
	@PropertyInfo(name="费用累计月天数",length=32)
	public Expenses expenses;
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
	 * 放款当天提前结清费用收取方式
	 * @return
	 */
	@PropertyInfo(name="提前结清费用收取方式",length=32)
	public Settlement settlement;

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

	public BigDecimal getMinimumAmount() {
		return minimumAmount;
	}

	public void setMinimumAmount(BigDecimal minimumAmount) {
		this.minimumAmount = minimumAmount;
	}

	public BigDecimal getMaximumAmount() {
		return maximumAmount;
	}

	public void setMaximumAmount(BigDecimal maximumAmount) {
		this.maximumAmount = maximumAmount;
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

	public FrequencyTimes getFrequencyOfCharge() {
		return frequencyOfCharge;
	}

	public void setFrequencyOfCharge(FrequencyTimes frequencyOfCharge) {
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

	public LimitControlMethod getUpperLimitControlMethod() {
		return upperLimitControlMethod;
	}

	public void setUpperLimitControlMethod(LimitControlMethod upperLimitControlMethod) {
		this.upperLimitControlMethod = upperLimitControlMethod;
	}

	public BigDecimal getUpperLimitControlRatio() {
		return upperLimitControlRatio;
	}

	public void setUpperLimitControlRatio(BigDecimal upperLimitControlRatio) {
		this.upperLimitControlRatio = upperLimitControlRatio;
	}

	public BigDecimal getUpperControlAmount() {
		return upperControlAmount;
	}

	public void setUpperControlAmount(BigDecimal upperControlAmount) {
		this.upperControlAmount = upperControlAmount;
	}

	public LimitControlMethod getDownLimitControlMethod() {
		return downLimitControlMethod;
	}

	public void setDownLimitControlMethod(LimitControlMethod downLimitControlMethod) {
		this.downLimitControlMethod = downLimitControlMethod;
	}

	public BigDecimal getDownLimitControlRatio() {
		return downLimitControlRatio;
	}

	public void setDownLimitControlRatio(BigDecimal downLimitControlRatio) {
		this.downLimitControlRatio = downLimitControlRatio;
	}

	public BigDecimal getDownControlAmount() {
		return downControlAmount;
	}

	public void setDownControlAmount(BigDecimal downControlAmount) {
		this.downControlAmount = downControlAmount;
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

	
	
}
