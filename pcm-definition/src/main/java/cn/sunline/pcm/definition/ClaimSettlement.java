package cn.sunline.pcm.definition;

import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;

@SuppressWarnings("serial")
public class ClaimSettlement  implements Serializable{
	
	
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
    public String transferAccount;

    @PropertyInfo(name="转入账号",length=12)
    public String transferToAccount;
    
    
    @PropertyInfo(name="结算信息",length=12)
    public String settleAccounts;
    

    

    public String getSettleAccounts() {
		return settleAccounts;
	}

	public void setSettleAccounts(String settleAccounts) {
		this.settleAccounts = settleAccounts;
	}

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

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

    
}
