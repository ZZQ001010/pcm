package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

import cn.sunline.pcm.definition.enums.AgePmtHierInd;
import cn.sunline.pcm.definition.enums.CycleBaseInd;
import cn.sunline.pcm.definition.enums.DelqDayInd;
import cn.sunline.pcm.definition.enums.DelqTolInd;
import cn.sunline.pcm.definition.enums.DirectDbIndicator;
import cn.sunline.pcm.definition.enums.DownpmtTolInd;
import cn.sunline.pcm.definition.enums.PaymentDueDay;
import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.common.annotation.enums.ReferEnums;
import cn.sunline.ppy.dictionary.enums.AccountType;

/**
 * 账户核算信息
 * 主键-accountInfoId
 */
public class AccountInfo implements Serializable{

	private static final long serialVersionUID = 2290878920078688409L;

	/**
	 * 账户核算信息ID
	 */
	@PropertyInfo(name="账户参数标识", length=8)
	public Integer accountInfoId;
	
	/**
	 * 账户类型
	 */
	@PropertyInfo(name="账户类型", length=1)
	public AccountType accountType;

	/**
	 * 到期还款日类型
	 */
	@PropertyInfo(name="到期还款日类型", length=1)
    public PaymentDueDay paymentDueDay;

    /**
     * 到期还款日天数：（对于每月固定日期的情况 ）
     */
    @PropertyInfo(name="到期还款日天数", length=2)
    public Integer pmtDueDays;

	/**
     * 到期还款固定日
     * 01 - 28 ： 固定日期 
     * 99 ： 月末
     */
    @PropertyInfo(name="到期还款固定日", length=2)
    public Integer pmtDueDate;
    
    /**
     * 大小月统一到期还款日
     * 启用后不管大月小月，到期还款日期都将维持在同一天
     */
    @PropertyInfo(name="大小月统一到期还款日", length=1)
    public Boolean pmtDueDayFix;
    
    /**
     * 大小月统一月天数
     * 手工输入，输入30则每月按30天计算
     */
    @PropertyInfo(name="大小月统一月天数", length=2)
    public Integer pmtDueDayFixUnit;
    
    /**
     * 到期还款短信/信函提前天数
     */
    @PropertyInfo(name="到期还款提醒提前天数", length=1)
    public Integer pmtDueLtrPrd;


    /**
     * 到期还款宽限天数
     */
    @PropertyInfo(name="到期还款宽限天数", length=2)
    public Integer pmtGracePrd;

    /**
     * 全额还款容忍度标识：
     */
    @PropertyInfo(name="全额还款容忍度标识", length=1)
    public DownpmtTolInd downpmtTolInd;

	/**
     * 全额还款容差比例
     */
    @PropertyInfo(name="全额还款容差比例", length=7, precision=4)
    public BigDecimal downpmtTolPerc;
    
    /**
     * 全额还款容差金额
     * 如果存放比例值，该值为允许少还的比例，如0.01允许少还1%
     */
    @PropertyInfo(name="全额还款容差金额", length=15, precision=2)
    public BigDecimal downpmtTol;
    
    /**
     * 约定还款日标识
     */
    @PropertyInfo(name="约定还款日标识", length=1)
    public DirectDbIndicator directDbInd;
    
    /**
     * 约定还款提前天数
     */
    @PropertyInfo(name="约定还款提前天数", length=2)
    public Integer directDbDays;
    
    /**
     * 约定还款固定日
     */
    @PropertyInfo(name="约定还款固定日", length=2)
    public Integer directDbDate;

    /**
     * 拖欠处理日标识
     */
    @PropertyInfo(name="拖欠处理日", length=1)
    public DelqDayInd delqDayInd;

    /**
     * 拖欠处理容忍度标志
     */
    @PropertyInfo(name="拖欠容忍计算方式", length=1)
    public DelqTolInd delqTolInd;

    /**
     * 拖欠处理容忍度金额
     */
    @PropertyInfo(name="拖欠处理容忍度金额", length=15, precision=2)
    public BigDecimal delqTol;

    /**
     * 拖欠容忍度比例
     */
    @PropertyInfo(name="拖欠容忍度比例",  length=7, precision=4)
    public BigDecimal delqTolPerc;

    /**
     * 拖欠短信/信函产生标识天数（拖欠之后第多少天产生）
     * 00 - 98 ： 实际天数
     * 99 ： 下个账单日产生
     */
    @PropertyInfo(name="拖欠通知延期天数", length=2)
    public Integer delqLtrPrd;

    /**
     * 是否连续拖欠都输出信函
     */
    @PropertyInfo(name="连续拖欠输出信函", length=1)
    public Boolean ltrOnContDlq;

    /**
     * 账单周期类型：
     */
    @PropertyInfo(name="账单周期类型", length=1)
    public CycleBaseInd cycleBaseInd;
    
    /**
     * 账单合并标识
     * 用法举例： CYCLE_BASE_IND为'M'，
     * CYCLE_BASE_MULT为2，
     * 表明每2个月组成一个账单周期
     */
    @PropertyInfo(name="账单周期乘数", length=1)
    public Integer cycleBaseMult;

    /**
     * 溢缴款免出账单最大金额
     */
    @PropertyInfo(name="溢缴款免出账单最大金额", length=15, precision=2)
    public BigDecimal crMaxbalNoStmt;

    /**
     * 积分账单标识 
     */
    @PropertyInfo(name="仅有积分需出账单", length=1)
    public Boolean stmtOnBpt;

    /**
     * 账单最小阈值，欠款大于等于该值才输出账单
     */
    @PropertyInfo(name="免出账单最大欠款", length=15, precision=2)
    public BigDecimal stmtMinBal;

    /**
     * 临时额度失效提醒天数
     */
    @PropertyInfo(name="临时额度失效提醒天数", length=2)
    public Integer tlExpPrmptPrd;

    /**
     * 缺省授权允许超限比例
     */
    @PropertyInfo(name="默认允许超限比例", length=7, precision=4)
    public BigDecimal ovrlmtRate;

    /**
     * 缺省取现额度比例
     */
    @PropertyInfo(name="默认取现比例", length=7, precision=4)
    public BigDecimal cashLimitRate;

    /**
     * 缺省额度内分期比例
     */
    @PropertyInfo(name="默认额度内分期比例", length=7, precision=4)
    public BigDecimal loanLimitRate;

    /**
     * 催收账龄阀值
     */
    @PropertyInfo(name="入催最小账龄", length=1)
    public String collOnAge;

    /**
     * 超限催收标志
     * Y/N
     */
    @PropertyInfo(name="超限入催", length=1)
    public Boolean collOnOvrlmt;

    /**
     * 首次还款拖欠催收标志
     * collect on first statment delinquncy
     */
    @PropertyInfo(name="首次还款拖欠入催", length=1)
    public Boolean collOnFsDlq;

    /**
     * 入催最小金额阀值
     */
    @PropertyInfo(name="免催最大金额", length=15, precision=2)
    public BigDecimal collMinpmt;
    
    /**
     * 账龄还款冲销优先标识
     * key - 账龄代码
     */
    @ReferEnums(AgePmtHierInd.class)
    public Map<String, AgePmtHierInd> agesPmtHierInd;
    
    /**
     * 账龄对应还款冲销顺序表id
     * key - 账龄代码
     */
    @PropertyInfo(name="账龄对应冲销顺序标识", length=9)
    public Map<String, Integer> agesPmtHierId;
    
    /**
     * 固定额度调整最小间隔日
     */
    @PropertyInfo(name="固定额度调整最小间隔日", length=3)
    public Integer creditLimitAdjustInterval;
    

	/**
	 * @return the accountInfoId
	 */
	public Integer getAccountInfoId() {
		return accountInfoId;
	}


	/**
	 * @param accountInfoId the accountInfoId to set
	 */
	public void setAccountInfoId(Integer accountInfoId) {
		this.accountInfoId = accountInfoId;
	}


	/**
	 * @return the accountType
	 */
	public AccountType getAccountType() {
		return accountType;
	}


	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}


	/**
	 * @return the paymentDueDay
	 */
	public PaymentDueDay getPaymentDueDay() {
		return paymentDueDay;
	}


	/**
	 * @param paymentDueDay the paymentDueDay to set
	 */
	public void setPaymentDueDay(PaymentDueDay paymentDueDay) {
		this.paymentDueDay = paymentDueDay;
	}


	/**
	 * @return the pmtDueDays
	 */
	public Integer getPmtDueDays() {
		return pmtDueDays;
	}


	/**
	 * @param pmtDueDays the pmtDueDays to set
	 */
	public void setPmtDueDays(Integer pmtDueDays) {
		this.pmtDueDays = pmtDueDays;
	}


	/**
	 * @return the pmtDueDate
	 */
	public Integer getPmtDueDate() {
		return pmtDueDate;
	}


	/**
	 * @param pmtDueDate the pmtDueDate to set
	 */
	public void setPmtDueDate(Integer pmtDueDate) {
		this.pmtDueDate = pmtDueDate;
	}


	/**
	 * @return the pmtDueDayFix
	 */
	public Boolean getPmtDueDayFix() {
		return pmtDueDayFix;
	}


	/**
	 * @param pmtDueDayFix the pmtDueDayFix to set
	 */
	public void setPmtDueDayFix(Boolean pmtDueDayFix) {
		this.pmtDueDayFix = pmtDueDayFix;
	}


	/**
	 * @return the pmtDueDayFixUnit
	 */
	public Integer getPmtDueDayFixUnit() {
		return pmtDueDayFixUnit;
	}


	/**
	 * @param pmtDueDayFixUnit the pmtDueDayFixUnit to set
	 */
	public void setPmtDueDayFixUnit(Integer pmtDueDayFixUnit) {
		this.pmtDueDayFixUnit = pmtDueDayFixUnit;
	}


	/**
	 * @return the pmtDueLtrPrd
	 */
	public Integer getPmtDueLtrPrd() {
		return pmtDueLtrPrd;
	}


	/**
	 * @param pmtDueLtrPrd the pmtDueLtrPrd to set
	 */
	public void setPmtDueLtrPrd(Integer pmtDueLtrPrd) {
		this.pmtDueLtrPrd = pmtDueLtrPrd;
	}


	/**
	 * @return the pmtGracePrd
	 */
	public Integer getPmtGracePrd() {
		return pmtGracePrd;
	}


	/**
	 * @param pmtGracePrd the pmtGracePrd to set
	 */
	public void setPmtGracePrd(Integer pmtGracePrd) {
		this.pmtGracePrd = pmtGracePrd;
	}


	/**
	 * @return the downpmtTolInd
	 */
	public DownpmtTolInd getDownpmtTolInd() {
		return downpmtTolInd;
	}


	/**
	 * @param downpmtTolInd the downpmtTolInd to set
	 */
	public void setDownpmtTolInd(DownpmtTolInd downpmtTolInd) {
		this.downpmtTolInd = downpmtTolInd;
	}


	/**
	 * @return the downpmtTolPerc
	 */
	public BigDecimal getDownpmtTolPerc() {
		return downpmtTolPerc;
	}


	/**
	 * @param downpmtTolPerc the downpmtTolPerc to set
	 */
	public void setDownpmtTolPerc(BigDecimal downpmtTolPerc) {
		this.downpmtTolPerc = downpmtTolPerc;
	}


	/**
	 * @return the downpmtTol
	 */
	public BigDecimal getDownpmtTol() {
		return downpmtTol;
	}


	/**
	 * @param downpmtTol the downpmtTol to set
	 */
	public void setDownpmtTol(BigDecimal downpmtTol) {
		this.downpmtTol = downpmtTol;
	}


	/**
	 * @return the directDbInd
	 */
	public DirectDbIndicator getDirectDbInd() {
		return directDbInd;
	}


	/**
	 * @param directDbInd the directDbInd to set
	 */
	public void setDirectDbInd(DirectDbIndicator directDbInd) {
		this.directDbInd = directDbInd;
	}


	/**
	 * @return the directDbDays
	 */
	public Integer getDirectDbDays() {
		return directDbDays;
	}


	/**
	 * @param directDbDays the directDbDays to set
	 */
	public void setDirectDbDays(Integer directDbDays) {
		this.directDbDays = directDbDays;
	}


	/**
	 * @return the directDbDate
	 */
	public Integer getDirectDbDate() {
		return directDbDate;
	}


	/**
	 * @param directDbDate the directDbDate to set
	 */
	public void setDirectDbDate(Integer directDbDate) {
		this.directDbDate = directDbDate;
	}


	/**
	 * @return the delqDayInd
	 */
	public DelqDayInd getDelqDayInd() {
		return delqDayInd;
	}


	/**
	 * @param delqDayInd the delqDayInd to set
	 */
	public void setDelqDayInd(DelqDayInd delqDayInd) {
		this.delqDayInd = delqDayInd;
	}


	/**
	 * @return the delqTolInd
	 */
	public DelqTolInd getDelqTolInd() {
		return delqTolInd;
	}


	/**
	 * @param delqTolInd the delqTolInd to set
	 */
	public void setDelqTolInd(DelqTolInd delqTolInd) {
		this.delqTolInd = delqTolInd;
	}


	/**
	 * @return the delqTol
	 */
	public BigDecimal getDelqTol() {
		return delqTol;
	}


	/**
	 * @param delqTol the delqTol to set
	 */
	public void setDelqTol(BigDecimal delqTol) {
		this.delqTol = delqTol;
	}


	/**
	 * @return the delqTolPerc
	 */
	public BigDecimal getDelqTolPerc() {
		return delqTolPerc;
	}


	/**
	 * @param delqTolPerc the delqTolPerc to set
	 */
	public void setDelqTolPerc(BigDecimal delqTolPerc) {
		this.delqTolPerc = delqTolPerc;
	}


	/**
	 * @return the delqLtrPrd
	 */
	public Integer getDelqLtrPrd() {
		return delqLtrPrd;
	}


	/**
	 * @param delqLtrPrd the delqLtrPrd to set
	 */
	public void setDelqLtrPrd(Integer delqLtrPrd) {
		this.delqLtrPrd = delqLtrPrd;
	}


	/**
	 * @return the ltrOnContDlq
	 */
	public Boolean getLtrOnContDlq() {
		return ltrOnContDlq;
	}


	/**
	 * @param ltrOnContDlq the ltrOnContDlq to set
	 */
	public void setLtrOnContDlq(Boolean ltrOnContDlq) {
		this.ltrOnContDlq = ltrOnContDlq;
	}


	/**
	 * @return the cycleBaseInd
	 */
	public CycleBaseInd getCycleBaseInd() {
		return cycleBaseInd;
	}


	/**
	 * @param cycleBaseInd the cycleBaseInd to set
	 */
	public void setCycleBaseInd(CycleBaseInd cycleBaseInd) {
		this.cycleBaseInd = cycleBaseInd;
	}


	/**
	 * @return the cycleBaseMult
	 */
	public Integer getCycleBaseMult() {
		return cycleBaseMult;
	}


	/**
	 * @param cycleBaseMult the cycleBaseMult to set
	 */
	public void setCycleBaseMult(Integer cycleBaseMult) {
		this.cycleBaseMult = cycleBaseMult;
	}


	/**
	 * @return the crMaxbalNoStmt
	 */
	public BigDecimal getCrMaxbalNoStmt() {
		return crMaxbalNoStmt;
	}


	/**
	 * @param crMaxbalNoStmt the crMaxbalNoStmt to set
	 */
	public void setCrMaxbalNoStmt(BigDecimal crMaxbalNoStmt) {
		this.crMaxbalNoStmt = crMaxbalNoStmt;
	}


	/**
	 * @return the stmtOnBpt
	 */
	public Boolean getStmtOnBpt() {
		return stmtOnBpt;
	}


	/**
	 * @param stmtOnBpt the stmtOnBpt to set
	 */
	public void setStmtOnBpt(Boolean stmtOnBpt) {
		this.stmtOnBpt = stmtOnBpt;
	}


	/**
	 * @return the stmtMinBal
	 */
	public BigDecimal getStmtMinBal() {
		return stmtMinBal;
	}


	/**
	 * @param stmtMinBal the stmtMinBal to set
	 */
	public void setStmtMinBal(BigDecimal stmtMinBal) {
		this.stmtMinBal = stmtMinBal;
	}


	/**
	 * @return the tlExpPrmptPrd
	 */
	public Integer getTlExpPrmptPrd() {
		return tlExpPrmptPrd;
	}


	/**
	 * @param tlExpPrmptPrd the tlExpPrmptPrd to set
	 */
	public void setTlExpPrmptPrd(Integer tlExpPrmptPrd) {
		this.tlExpPrmptPrd = tlExpPrmptPrd;
	}


	/**
	 * @return the ovrlmtRate
	 */
	public BigDecimal getOvrlmtRate() {
		return ovrlmtRate;
	}


	/**
	 * @param ovrlmtRate the ovrlmtRate to set
	 */
	public void setOvrlmtRate(BigDecimal ovrlmtRate) {
		this.ovrlmtRate = ovrlmtRate;
	}


	/**
	 * @return the cashLimitRate
	 */
	public BigDecimal getCashLimitRate() {
		return cashLimitRate;
	}


	/**
	 * @param cashLimitRate the cashLimitRate to set
	 */
	public void setCashLimitRate(BigDecimal cashLimitRate) {
		this.cashLimitRate = cashLimitRate;
	}


	/**
	 * @return the loanLimitRate
	 */
	public BigDecimal getLoanLimitRate() {
		return loanLimitRate;
	}


	/**
	 * @param loanLimitRate the loanLimitRate to set
	 */
	public void setLoanLimitRate(BigDecimal loanLimitRate) {
		this.loanLimitRate = loanLimitRate;
	}


	/**
	 * @return the collOnAge
	 */
	public String getCollOnAge() {
		return collOnAge;
	}


	/**
	 * @param collOnAge the collOnAge to set
	 */
	public void setCollOnAge(String collOnAge) {
		this.collOnAge = collOnAge;
	}


	/**
	 * @return the collOnOvrlmt
	 */
	public Boolean getCollOnOvrlmt() {
		return collOnOvrlmt;
	}


	/**
	 * @param collOnOvrlmt the collOnOvrlmt to set
	 */
	public void setCollOnOvrlmt(Boolean collOnOvrlmt) {
		this.collOnOvrlmt = collOnOvrlmt;
	}


	/**
	 * @return the collOnFsDlq
	 */
	public Boolean getCollOnFsDlq() {
		return collOnFsDlq;
	}


	/**
	 * @param collOnFsDlq the collOnFsDlq to set
	 */
	public void setCollOnFsDlq(Boolean collOnFsDlq) {
		this.collOnFsDlq = collOnFsDlq;
	}


	/**
	 * @return the collMinpmt
	 */
	public BigDecimal getCollMinpmt() {
		return collMinpmt;
	}


	/**
	 * @param collMinpmt the collMinpmt to set
	 */
	public void setCollMinpmt(BigDecimal collMinpmt) {
		this.collMinpmt = collMinpmt;
	}


	/**
	 * @return the agesPmtHierInd
	 */
	public Map<String, AgePmtHierInd> getAgesPmtHierInd() {
		return agesPmtHierInd;
	}


	/**
	 * @param agesPmtHierInd the agesPmtHierInd to set
	 */
	public void setAgesPmtHierInd(Map<String, AgePmtHierInd> agesPmtHierInd) {
		this.agesPmtHierInd = agesPmtHierInd;
	}


	/**
	 * @return the agesPmtHierId
	 */
	public Map<String, Integer> getAgesPmtHierId() {
		return agesPmtHierId;
	}


	/**
	 * @param agesPmtHierId the agesPmtHierId to set
	 */
	public void setAgesPmtHierId(Map<String, Integer> agesPmtHierId) {
		this.agesPmtHierId = agesPmtHierId;
	}


	/**
	 * @return the creditLimitAdjustInterval
	 */
	public Integer getCreditLimitAdjustInterval() {
		return creditLimitAdjustInterval;
	}


	/**
	 * @param creditLimitAdjustInterval the creditLimitAdjustInterval to set
	 */
	public void setCreditLimitAdjustInterval(Integer creditLimitAdjustInterval) {
		this.creditLimitAdjustInterval = creditLimitAdjustInterval;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
    
}
