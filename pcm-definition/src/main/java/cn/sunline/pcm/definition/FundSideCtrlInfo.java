package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.FundSideCreditLimit;
/**
 * 
 * @author fgy
 * @date 2019年7月30日
 *	资金方管控信息
 */
public class FundSideCtrlInfo implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * 资金方管控编码
	 */
	@PropertyInfo(name="资金方管控编码")
	public  String fundSideCtrlCode ; 
	
	/**
	 * 资金方管控描述
	 */
	@PropertyInfo(name="资金方管控描述")
	public String  fundSideCtrlDesc ;
    /**
     * 资金方编码
     */
    @PropertyInfo(name="资金方编码")
    public String  fundSide ;
    /**
     * 资金方授信管控
     */
    @PropertyInfo(name="资金方授信管控")
    public FundSideCreditLimit  fundSideCreditLimit ;
	/**
	 * 资金方总授信额度
	 */
	@PropertyInfo(name="资金方授信额度总控")
	public BigDecimal  fundSideTotalTrustworthinessLimit;
	
	/**
	 *授信额度有效期
	 */
	@PropertyInfo(name="授信额度有效期")
	public  Date authorizationAmountUsefulLife;

    /**
     * 资金方放款管控
     */
    @PropertyInfo(name="资金方放款管控")
    public FundSideCreditLimit  fundSideLoanLimit ;

	/**
	 * 资金方总放款额度
	 */
	@PropertyInfo(name="资金方放款额总控")
	public BigDecimal fundSideTotalLoanAmount;

    /**
     * 资金方月放款额管控
     */
    @PropertyInfo(name="资金方月放款额管控")
    public BigDecimal fundSideTotalLoanAmountM;
    /**
     * 资金方周放款额管控
     */
    @PropertyInfo(name="资金方周放款额管控")
    public BigDecimal fundSideTotalLoanAmountW;
    /**
     * 资金方日放款额管控
     */
    @PropertyInfo(name="资金方日放款额管控")
    public BigDecimal fundSideTotalLoanAmountD;
	/**
	 * 放款额度有效期
	 */
	@PropertyInfo(name="放款额度有效期")
	public Date   loanAmountUsefulLife;
	
	
	/**
	 *资金方余额总控
	 */
	@PropertyInfo(name="资金方余额总控")
	public BigDecimal fundSideTotalBalance;
	
	
	/**
	 * 余额额度有效期
	 */
	@PropertyInfo(name="余额额度有效期")
	public Date balanceAmountUsefulLife;

    public String getFundSideCtrlCode() {
        return fundSideCtrlCode;
    }

    public void setFundSideCtrlCode(String fundSideCtrlCode) {
        this.fundSideCtrlCode = fundSideCtrlCode;
    }

    public String getFundSideCtrlDesc() {
        return fundSideCtrlDesc;
    }

    public void setFundSideCtrlDesc(String fundSideCtrlDesc) {
        this.fundSideCtrlDesc = fundSideCtrlDesc;
    }

    public String getFundSide() {
        return fundSide;
    }

    public void setFundSide(String fundSide) {
        this.fundSide = fundSide;
    }

    public FundSideCreditLimit getFundSideCreditLimit() {
        return fundSideCreditLimit;
    }

    public void setFundSideCreditLimit(FundSideCreditLimit fundSideCreditLimit) {
        this.fundSideCreditLimit = fundSideCreditLimit;
    }

    public BigDecimal getFundSideTotalTrustworthinessLimit() {
        return fundSideTotalTrustworthinessLimit;
    }

    public void setFundSideTotalTrustworthinessLimit(BigDecimal fundSideTotalTrustworthinessLimit) {
        this.fundSideTotalTrustworthinessLimit = fundSideTotalTrustworthinessLimit;
    }

    public Date getAuthorizationAmountUsefulLife() {
        return authorizationAmountUsefulLife;
    }

    public void setAuthorizationAmountUsefulLife(Date authorizationAmountUsefulLife) {
        this.authorizationAmountUsefulLife = authorizationAmountUsefulLife;
    }

    public FundSideCreditLimit getFundSideLoanLimit() {
        return fundSideLoanLimit;
    }

    public void setFundSideLoanLimit(FundSideCreditLimit fundSideLoanLimit) {
        this.fundSideLoanLimit = fundSideLoanLimit;
    }

    public BigDecimal getFundSideTotalLoanAmount() {
        return fundSideTotalLoanAmount;
    }

    public void setFundSideTotalLoanAmount(BigDecimal fundSideTotalLoanAmount) {
        this.fundSideTotalLoanAmount = fundSideTotalLoanAmount;
    }

    public BigDecimal getFundSideTotalLoanAmountM() {
        return fundSideTotalLoanAmountM;
    }

    public void setFundSideTotalLoanAmountM(BigDecimal fundSideTotalLoanAmountM) {
        this.fundSideTotalLoanAmountM = fundSideTotalLoanAmountM;
    }

    public BigDecimal getFundSideTotalLoanAmountW() {
        return fundSideTotalLoanAmountW;
    }

    public void setFundSideTotalLoanAmountW(BigDecimal fundSideTotalLoanAmountW) {
        this.fundSideTotalLoanAmountW = fundSideTotalLoanAmountW;
    }

    public BigDecimal getFundSideTotalLoanAmountD() {
        return fundSideTotalLoanAmountD;
    }

    public void setFundSideTotalLoanAmountD(BigDecimal fundSideTotalLoanAmountD) {
        this.fundSideTotalLoanAmountD = fundSideTotalLoanAmountD;
    }

    public Date getLoanAmountUsefulLife() {
        return loanAmountUsefulLife;
    }

    public void setLoanAmountUsefulLife(Date loanAmountUsefulLife) {
        this.loanAmountUsefulLife = loanAmountUsefulLife;
    }

    public BigDecimal getFundSideTotalBalance() {
        return fundSideTotalBalance;
    }

    public void setFundSideTotalBalance(BigDecimal fundSideTotalBalance) {
        this.fundSideTotalBalance = fundSideTotalBalance;
    }

    public Date getBalanceAmountUsefulLife() {
        return balanceAmountUsefulLife;
    }

    public void setBalanceAmountUsefulLife(Date balanceAmountUsefulLife) {
        this.balanceAmountUsefulLife = balanceAmountUsefulLife;
    }
}
