package cn.sunline.pcm.definition;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.BillingCycle;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.definition.enums.FrequencyOfChannel;

import java.io.Serializable;
import java.math.BigDecimal;

public class BankChargeMorePenaltyInterest implements Serializable {
    @PropertyInfo(name="银行多记罚息编码", length=15)
    public String bankChargeMorePenaltyInterestCode;

    @PropertyInfo(name="银行多记罚息描述", length=50)
    public String bankChargeMorePenaltyInterestDesc;

    @PropertyInfo(name="罚息分担比例",length=12)
    public BigDecimal penaltyInterestShareProportion ;

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
    
    
    /**
     * 结算内容
     */
    @PropertyInfo(name="结算内容",length=32)
    public String  settleAccounts;
    
    
    

    public String getSettleAccounts() {
		return settleAccounts;
	}

	public void setSettleAccounts(String settleAccounts) {
		this.settleAccounts = settleAccounts;
	}

	public String getBankChargeMorePenaltyInterestCode() {
        return bankChargeMorePenaltyInterestCode;
    }

    public void setBankChargeMorePenaltyInterestCode(String bankChargeMorePenaltyInterestCode) {
        this.bankChargeMorePenaltyInterestCode = bankChargeMorePenaltyInterestCode;
    }

    public String getBankChargeMorePenaltyInterestDesc() {
        return bankChargeMorePenaltyInterestDesc;
    }

    public void setBankChargeMorePenaltyInterestDesc(String bankChargeMorePenaltyInterestDesc) {
        this.bankChargeMorePenaltyInterestDesc = bankChargeMorePenaltyInterestDesc;
    }

    public BigDecimal getPenaltyInterestShareProportion() {
        return penaltyInterestShareProportion;
    }

    public void setPenaltyInterestShareProportion(BigDecimal penaltyInterestShareProportion) {
        this.penaltyInterestShareProportion = penaltyInterestShareProportion;
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
