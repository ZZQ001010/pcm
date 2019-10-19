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
 * 银行本息
 * @author fgy
 */

public class BankPrincipalInterest  implements Serializable{
    @PropertyInfo(name="银行本息编码", length=15)
    public String bankPrincipalInterestCode;
    @PropertyInfo(name="银行本息描述", length=50)
    public String bankPrincipalInterestDesc;
    @PropertyInfo(name="费用收取频次",length=12)
    public FrequencyOfChannel FrequencyOfCharge;
    @PropertyInfo(name="所属机构",length=12)
    public String organization;

    @PropertyInfo(name="合作方类型",length=12)
    public ChannelPartnerType partnerType;

    @PropertyInfo(name="合作方编码",length=12)
    public String partnerCode;

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
    public String  balanceDate;
    
    
    /**
     * 结算信息
     */
    @PropertyInfo(name="结算信息",length=32)
    public String  settleAccounts;

    
    
    public String getSettleAccounts() {
		return settleAccounts;
	}

	public void setSettleAccounts(String settleAccounts) {
		this.settleAccounts = settleAccounts;
	}

	public String getBankPrincipalInterestCode() {
        return bankPrincipalInterestCode;
    }

    public void setBankPrincipalInterestCode(String bankPrincipalInterestCode) {
        this.bankPrincipalInterestCode = bankPrincipalInterestCode;
    }

    public String getBankPrincipalInterestDesc() {
        return bankPrincipalInterestDesc;
    }

    public void setBankPrincipalInterestDesc(String bankPrincipalInterestDesc) {
        this.bankPrincipalInterestDesc = bankPrincipalInterestDesc;
    }

    public FrequencyOfChannel getFrequencyOfCharge() {
        return FrequencyOfCharge;
    }

    public void setFrequencyOfCharge(FrequencyOfChannel frequencyOfCharge) {
        FrequencyOfCharge = frequencyOfCharge;
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

    public cn.sunline.pcm.definition.enums.BillingCycle getBillingCycle() {
        return BillingCycle;
    }

    public void setBillingCycle(cn.sunline.pcm.definition.enums.BillingCycle billingCycle) {
        BillingCycle = billingCycle;
    }

    public String getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(String balanceDate) {
        this.balanceDate = balanceDate;
    }
}
