package cn.sunline.pcm.definition;

import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.definition.enums.Expenses;
import cn.sunline.pcm.definition.enums.FrequencyOfChannel;

@SuppressWarnings("all")
public class Premium implements Serializable {
    @PropertyInfo(name="保费编码", length=12)
    public String premiumCode ;

    @PropertyInfo(name="保费描述",length=50)
    public String premiumDesc ;
    @PropertyInfo(name="费用收取频次",length=12)
    public FrequencyOfChannel FrequencyOfCharge;

    @PropertyInfo(name="费用累计月天数",length=32)
    public Expenses expenses;

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
    public cn.sunline.pcm.definition.enums.BillingCycle BillingCycle;
    /**
     * 结算日期
     */
    @PropertyInfo(name="结算日期",length=32)
    public String  balanceDate;

    public String getPremiumCode() {
        return premiumCode;
    }

    public void setPremiumCode(String premiumCode) {
        this.premiumCode = premiumCode;
    }

    public String getPremiumDesc() {
        return premiumDesc;
    }

    public void setPremiumDesc(String premiumDesc) {
        this.premiumDesc = premiumDesc;
    }

    public FrequencyOfChannel getFrequencyOfCharge() {
        return FrequencyOfCharge;
    }

    public void setFrequencyOfCharge(FrequencyOfChannel frequencyOfCharge) {
        FrequencyOfCharge = frequencyOfCharge;
    }

    public Expenses getExpenses() {
        return expenses;
    }

    public void setExpenses(Expenses expenses) {
        this.expenses = expenses;
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
