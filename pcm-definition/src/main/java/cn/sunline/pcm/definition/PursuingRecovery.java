package cn.sunline.pcm.definition;

import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;

@SuppressWarnings("serial")
public class PursuingRecovery  implements Serializable{
	
	
    @PropertyInfo(name="追偿编码", length=15)
    public String pursuingRecoveryCode;
    @PropertyInfo(name="追偿描述", length=50)
    public String pursuingRecoveryDesc;

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

    public String getPursuingRecoveryCode() {
        return pursuingRecoveryCode;
    }

    public void setPursuingRecoveryCode(String pursuingRecoveryCode) {
        this.pursuingRecoveryCode = pursuingRecoveryCode;
    }

    public String getPursuingRecoveryDesc() {
        return pursuingRecoveryDesc;
    }

    public void setPursuingRecoveryDesc(String pursuingRecoveryDesc) {
        this.pursuingRecoveryDesc = pursuingRecoveryDesc;
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
