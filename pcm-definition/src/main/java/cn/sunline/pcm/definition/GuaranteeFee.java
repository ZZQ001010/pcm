package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.Accumulated;
import cn.sunline.pcm.definition.enums.BanceDate;
import cn.sunline.pcm.definition.enums.BillingCycle;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.definition.enums.FeeBasis;
import cn.sunline.pcm.definition.enums.FeeCollectionMethod;
import cn.sunline.pcm.definition.enums.FrequencyOfCharge;
import cn.sunline.pcm.definition.enums.Settlement;

/**
 * 担保费
 * @author zzq
 * @date 2019年7月15日
 *
 */
@SuppressWarnings("serial")
public class GuaranteeFee  implements Serializable{
	

	@PropertyInfo(name="担保费编码", length=12)
	public String guaranteeFeeCode ; 
	
	@PropertyInfo(name="担保费描述",length=50)
	public String guaranteeFeeDesc ; 

	
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
	public BigDecimal ratio;
	

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
	
	
	
	/**
	 * 
	 * @return
	 */
	@PropertyInfo(name="结算星期",length=32)
	public BanceDate banceDate;
	
	
	@PropertyInfo(name="费用累计年天数",length=12)
	public Accumulated accumulated;
	
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
	

	
	
	public String getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(String balanceDate) {
		this.balanceDate = balanceDate;
	}

	public BanceDate getBanceDate() {
		return banceDate;
	}

	public void setBanceDate(BanceDate banceDate) {
		this.banceDate = banceDate;
	}

	public Accumulated getAccumulated() {
		return accumulated;
	}

	public void setAccumulated(Accumulated accumulated) {
		this.accumulated = accumulated;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
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



	
	

	public String getGuaranteeFeeCode() {
		return guaranteeFeeCode;
	}

	public void setGuaranteeFeeCode(String guaranteeFeeCode) {
		this.guaranteeFeeCode = guaranteeFeeCode;
	}

	public String getGuaranteeFeeDesc() {
		return guaranteeFeeDesc;
	}

	public void setGuaranteeFeeDesc(String guaranteeFeeDesc) {
		this.guaranteeFeeDesc = guaranteeFeeDesc;
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

	public FrequencyOfCharge getFrequencyOfCharge() {
		return frequencyOfCharge;
	}

	public void setFrequencyOfCharge(FrequencyOfCharge frequencyOfCharge) {
		this.frequencyOfCharge = frequencyOfCharge;
	}

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
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