package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.BanceDate;
import cn.sunline.pcm.definition.enums.BillingCycle;
import cn.sunline.pcm.definition.enums.CapitalMoneyBasics;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.definition.enums.DeditMethodOfFeeCollection;
import cn.sunline.pcm.definition.enums.SafeTyMatFrequencyOfCharge;
import cn.sunline.pcm.definition.enums.Settlement;

/**
 * 资金方技术服务费
 * @author 杨贵博
 *
 */
@SuppressWarnings("serial")
public class FundSideServiceFee implements Serializable{

	@PropertyInfo(name="技术服务编码", length=15)
	public String skillcode ; 
	
	@PropertyInfo(name="技术服务描述", length=50)
	public  String skillDesc ;
	
	@PropertyInfo(name="费用收取方式",length=12)
	public DeditMethodOfFeeCollection feeCollectionMethod; 
	
	@PropertyInfo(name="费用收取基础",length=12)
	public CapitalMoneyBasics FeeBasis; 
	
	@PropertyInfo(name="费用收取频次",length=12)
	public SafeTyMatFrequencyOfCharge FrequencyOfCharge; 
	
	@PropertyInfo(name="收取比例",length=12)
	public BigDecimal ChargeRatio; 
	
	@PropertyInfo(name="所属机构",length=12)
	public String organization; 
	
	@PropertyInfo(name="资金方",length=50)
	public String capital; 
	
	@PropertyInfo(name="资金方平台服务方",length=50)
	public String platformService ;
	
	@PropertyInfo(name="转出账号",length=12)
	public String TransferAccount; 
	
	@PropertyInfo(name="转入账号",length=12)
	public String TransferToAccount; 
	
	@PropertyInfo(name="结算周期",length=12)
	public BillingCycle BillingCycle;
	
	/**
	 * 
	 * @return
	 */
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

	
	/**
	 * 结算日期
	 */
	@PropertyInfo(name="结算日期",length=32)
	public String balanceDate;
	
	/**
	 * 提前还款手续费方式
	 * @return
	 */
	@PropertyInfo(name="提前还款手续费方式",length=32)
	public Settlement settlement;
	
	
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


	public Settlement getSettlement() {
		return settlement;
	}


	public void setSettlement(Settlement settlement) {
		this.settlement = settlement;
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

	public String getSkillcode() {
		return skillcode;
	}

	public void setSkillcode(String skillcode) {
		this.skillcode = skillcode;
	}

	public String getSkillDesc() {
		return skillDesc;
	}

	public void setSkillDesc(String skillDesc) {
		this.skillDesc = skillDesc;
	}

	public DeditMethodOfFeeCollection getFeeCollectionMethod() {
		return feeCollectionMethod;
	}

	public void setFeeCollectionMethod(DeditMethodOfFeeCollection feeCollectionMethod) {
		this.feeCollectionMethod = feeCollectionMethod;
	}

	public CapitalMoneyBasics getFeeBasis() {
		return FeeBasis;
	}

	public void setFeeBasis(CapitalMoneyBasics feeBasis) {
		FeeBasis = feeBasis;
	}

	public SafeTyMatFrequencyOfCharge getFrequencyOfCharge() {
		return FrequencyOfCharge;
	}

	public void setFrequencyOfCharge(SafeTyMatFrequencyOfCharge frequencyOfCharge) {
		FrequencyOfCharge = frequencyOfCharge;
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

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getPlatformService() {
		return platformService;
	}

	public void setPlatformService(String platformService) {
		this.platformService = platformService;
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
