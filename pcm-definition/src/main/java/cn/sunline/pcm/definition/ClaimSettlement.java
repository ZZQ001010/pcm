package cn.sunline.pcm.definition;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;

public class ClaimSettlement {
    @PropertyInfo(name="理赔编码", length=15)
    public String claimSettlementCode;
    @PropertyInfo(name="理赔描述", length=50)
    public String claimSettlementDesc;

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

    public String getClaimSettlementCode() {
        return claimSettlementCode;
    }

    public void setClaimSettlementCode(String claimSettlementCode) {
        this.claimSettlementCode = claimSettlementCode;
    }

    public String getClaimSettlementDesc() {
        return claimSettlementDesc;
    }

    public void setClaimSettlementDesc(String claimSettlementDesc) {
        this.claimSettlementDesc = claimSettlementDesc;
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
}
