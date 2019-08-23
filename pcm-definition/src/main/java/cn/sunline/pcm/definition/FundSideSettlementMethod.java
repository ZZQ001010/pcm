package cn.sunline.pcm.definition;

import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.SettlementMethod;

/**
 * 
 * @author zzq
 * @date 2019年7月12日
 *	资金方理赔方式
 */

public class FundSideSettlementMethod implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * 资金方编码
	 */
	@PropertyInfo(name="资金方编码", length=32)
	public String  fundSideCode ;
	
	/**
	 * 资金方描述
	 */
	@PropertyInfo(name="资金方描述", length=32)
	public String  fundSideDesc ;

    /**
     * 资金方
     */
    @PropertyInfo(name="资金方", length=32)
    public String  fundSide ;
	/**
	 * 理赔方式
	 */
	@PropertyInfo(name="理赔方式", length=32)
	public SettlementMethod fundSideInfo;
	
	/**
	 * 理赔逾期天数
	 */
	@PropertyInfo(name="理赔逾期天数",length=32)
	public Integer  daysOverdue ;
	
	/**
	 * 全期理赔起始期数
	 */
	@PropertyInfo(name="全期理赔起始期数",length=32)
	public Integer  otalNumberOfClaimsStartPeriods ;

	public String getFundSideCode() {
		return fundSideCode;
	}

	public void setFundSideCode(String fundSideCode) {
		this.fundSideCode = fundSideCode;
	}

	public String getFundSideDesc() {
		return fundSideDesc;
	}

	public void setFundSideDesc(String fundSideDesc) {
		this.fundSideDesc = fundSideDesc;
	}



	public SettlementMethod getFundSideInfo() {
		return fundSideInfo;
	}

	public void setFundSideInfo(SettlementMethod fundSideInfo) {
		this.fundSideInfo = fundSideInfo;
	}

	public Integer getDaysOverdue() {
		return daysOverdue;
	}

	public void setDaysOverdue(Integer daysOverdue) {
		this.daysOverdue = daysOverdue;
	}

	public Integer getOtalNumberOfClaimsStartPeriods() {
		return otalNumberOfClaimsStartPeriods;
	}

	public void setOtalNumberOfClaimsStartPeriods(Integer otalNumberOfClaimsStartPeriods) {
		this.otalNumberOfClaimsStartPeriods = otalNumberOfClaimsStartPeriods;
	}


    public String getFundSide() {
        return fundSide;
    }

    public void setFundSide(String fundSide) {
        this.fundSide = fundSide;
    }
}
