package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.common.enums.Indicator;
import cn.sunline.pcm.definition.enums.ClaimType;
import cn.sunline.pcm.definition.enums.SettleUnit;
import cn.sunline.ppy.dictionary.enums.InputSource;

/**
 *银行账户管理
 * 主键-Financial_Org_NO
 */
public class FinancialOrg implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 4944306234987507184L;

    /**
     * 金融机构编码
     */
    @PropertyInfo(name="金融机构编码", length=9)
    public String financialOrgNO;

    /**
     * 金融机构名称
     */
    @PropertyInfo(name="金融机构名称", length=200)
    public String financialOrgName;

    /**
     * 金融机构对公账户
     */
    @PropertyInfo(name="金融机构对公账户", length=32)
    public String financialOrgAcctNo;

    /**
     * 对公账户开户银行
     */
    @PropertyInfo(name="开户银行",length=50)
    public String acctBank;
    
    /**
     * 对公账户开户省份
     */
    @PropertyInfo(name="开户行省份",length=20)
    public String acctProvince;
    
    /**
     * 对公账户开户城市
     */
    @PropertyInfo(name="开户行城市",length=40)
    public String acctCity;
    
    /**
     * 对公账户开户支行
     */
    @PropertyInfo(name="开户行支行",length=80)
    public String acctBranchBank;
    
    /**
     * 金融机构理赔账户
     */
    @PropertyInfo(name="金融机构理赔账户", length=32)
    public String financialOrgPayNo;

    /**
     * 理赔账户开户银行
     */
    @PropertyInfo(name="开户银行",length=50)
    public String payBank;
    
    /**
     * 理赔账户开户省份
     */
    @PropertyInfo(name="开户行省份",length=20)
    public String payProvince;
    
    /**
     * 理赔账户开户城市
     */
    @PropertyInfo(name="开户行城市",length=40)
    public String payCity;
    
    /**
     * 理赔账户开户支行
     */
    @PropertyInfo(name="开户行支行",length=80)
    public String payBranchBank;
    
    /**
     * 提前还款手续费分成比例
     */
    @PropertyInfo(name="提前还款手续费分成比例", length=6,precision=4)
    public BigDecimal adFeeScale;

    /**
     * 金融机构标识码
     */
    @PropertyInfo(name="金融机构标识码", length=15)
    public String acqAcceptorId;

    /**
     * 代位追偿金额拆分方式
     */
    @PropertyInfo(name="代位追偿金额拆分方式", length=6)
    public String splitTableId;
    /**
     * 对公账户是否参与结算
     */
    @PropertyInfo(name="是否参与结算", length=1)
    public Indicator isSettle;
    /**
     * 对公账户每月结算日期
     */
    @PropertyInfo(name="每月结算日",length=2)
    public Integer monthSettleDay;
    /**
     * 对公账户结算起始日期
     */
    @PropertyInfo(name="结算起始日",length=2)
    public Integer settleStartDay;
    /**
     * 对公账户结算截止日期
     */
    @PropertyInfo(name="结算截止日",length=1)
    public Integer settleEndDay;
    
    /**
     * 对公账户结算周期
     */
    @PropertyInfo(name="结算周期",length=2)
    public SettleUnit settleUnit;

    /**
     * 货币代码
     */
    @PropertyInfo(name="货币代码",length=3)
    public String currencyCd;

    /**
     * 国家代码
     */
    @PropertyInfo(name="国家代码",length=9)
    public String countryCd;
    
    /**
     * 省份
     */
    @PropertyInfo(name="省份",length=20)
    public String province;
    /**
     * 城市
     */
    @PropertyInfo(name="城市",length=40)
    public String city;
    /**
     * 地址
     */
    @PropertyInfo(name="地址",length=200)
    public String address;
    /**
     * 法人编号
     * @date 2017-03-24 modify
     * <p>目前用来区分理赔和追偿的保险公司区分标识</p>
     * <p>以逗号分隔的方式来配置</p>
     * <p>配置举例:011,0D15</p>
     * <p>目前顺位第一个用于标识理赔的业务类型</p>
     * <p>目前顺位第二个用于标识代偿的保险公司类型</p>
     */
    @PropertyInfo(name="法人编号",length=9)
    public String corporationCd;
    /**
     * 联系电话1
     */
    @PropertyInfo(name="联系电话1",length=20)
    public String phone1;
    
    /**
     * 联系电话2
     */
    @PropertyInfo(name="联系电话2",length=20)
    public String phone2;
    
    /**
     * 传真
     */
    @PropertyInfo(name="传真",length=20)
    public String fax;
    
    /**
     * 电子邮箱
     */
    @PropertyInfo(name="电子邮箱",length=40)
    public String email;
    
    /**
     * 结算渠道
     */
    @PropertyInfo(name="结算渠道",length=40)
    public InputSource inputSource;
    /**
     * 理赔账户的开户行号
     */
    @PropertyInfo(name="理赔账户的开户行号", length=20)
    public String payOpenBankId;
    /**
     * 对公账户的开户行号
     */
    @PropertyInfo(name="对公账户的开户行号", length=20)
    public String acctOpenBankId;
    
    /**
     * 外部放款对账方
     */
    @PropertyInfo(name="外部放款对账方" ,length = 5)
    public String externalLoanCompOrg;
    
    /**
     * 直接放款对账方
     */
    @PropertyInfo(name="直接放款对账方" ,length=5)
    public String derectLoanCompOrg;
    
    /**
     * 外部扣款对账方
     */
    @PropertyInfo(name="外部扣款对账方" ,length=5)
    public String externalCutCompOrg;
    
    /**
     * 直接扣款对账方
     */
    @PropertyInfo(name="直接扣款对账方",length=5)
    public String derectCutCompOrg;
    
    /**
     * 外部放款是否强制不对账
     */
    @PropertyInfo(name="外部放款是否强制不对账" ,length=1)
    public Indicator externalLoanCompInd;
    
    /**
     * 直接放款是否强制不对账
     */
    @PropertyInfo(name="直接放款是否强制不对账" ,length=1)
    public Indicator derectLoanCompInd;
    
    /**
     * 外部扣款是否强制不对账
     */
    @PropertyInfo(name="外部扣款是否强制不对账" ,length=1)
    public Indicator externalCutCompInd;
    
    /**
     * 直接扣款是否强制不对账
     */
    @PropertyInfo(name="直接扣款是否强制不对账" ,length=1)
    public Indicator derectCutCompInd;
    
    /**
     * 保费金融机构对公账户
     */
    @PropertyInfo(name = "保费金融机构对公账户", length = 100)
    public String insuranceFeeAcctNo;
    
    /**
     * 保费银行对公账户
     */
    @PropertyInfo(name = "保费银行对公账户", length = 100)
    public String insuranceFeeBankAcctNo;
    
    /**
     * 代偿费金融机构对公账户
     */
    @PropertyInfo(name = "代偿费金融机构对公账户", length = 100)
    public String subrogationAcctNo;
    
    /**
     * 代偿费银行对公账户
     */
    @PropertyInfo(name = "代偿费银行对公账户", length = 100)
    public String subrogationBankAcctNo;
    
    /**
     * 提前还款手续费金融机构账户
     */
    @PropertyInfo(name = "提前还款手续费金融机构账户", length = 32)
    public String repayTxnFeeAcctNo;
    
    /**
     * 提前还款手续费银行账户
     */
    @PropertyInfo(name = "提前还款手续费银行账户", length = 32)
    public String repayTxnFeeBankAcctNo;
    
    
    /**
     * 允许批量代偿标识
     */
    @PropertyInfo(name = "是否允许批量代偿", length = 1)
    public Indicator allowBatchSubrogation;
    
    /**
     * 索赔申请书模板
     */
    @PropertyInfo(name = "索赔申请书模板", length = 2000)
    public String claimApplicationTemplate;
    
    /**
     * 是否参与批扣，默认参与批扣
     */
    @PropertyInfo(name = "是否参与批扣", length = 1)
    public Indicator joinBatchDeduct;
    
    /**
	 * 理赔参数列表
	 * KEY-自定义id
	 * VALUE-理赔参数
	 */
	public Map<Integer, ClaimDef> claimDefMap;
	
	/**
     * 业务合作分支行名称
     */
    @PropertyInfo(name = "业务合作分支行名称", length = 100)
    public String bizBranchBankName;
    
    /**
     * 支付 - 设备号
     */
    @PropertyInfo(name = "设备号", length = 100)
    public String loanDeviceId;
    
    /**
     * 支付 - 放款转出账号
     */
    @PropertyInfo(name = "放款转出账号", length = 100)
    public String bankOutAcctNbr;
    
    /**
     * 支付 - 扣款转入账号
     */
    @PropertyInfo(name = "扣款转入账号", length = 100)
    public String bankInAcctNbr;
    
    /**
     * 支付 - 对公还款转入账号
     */
    @PropertyInfo(name = "对公还款转入账号", length = 100)
    public String bankPublicInAcctNbr;
    
    /**
     * 支付 - 合作方转入账号
     */
    @PropertyInfo(name = "合作方转入账号", length = 100)
    public String coopInAcctNbr;
    
    /**
     * 支付 - 交易网点号
     */
    @PropertyInfo(name = "交易网点号", length = 100)
    public String transBranCode;
    
    /**
     * 支付 - 操作人员
     */
    @PropertyInfo(name = "操作人员", length = 100)
    public String operNo;
    
    /**
     * 支付 - 机构代码
     */
    @PropertyInfo(name = "机构代码", length = 100)
    public String branchNo;
    
    /**
     * 支付 - 柜员号
     */
    @PropertyInfo(name = "柜员号", length = 100)
    public String telerNo;
    
    /**
     * 支付 - 商户号
     */
    @PropertyInfo(name = "商户号", length = 100)
    public String merchantId;
    
    /**
     * 支付 - 渠道标识
     */
    @PropertyInfo(name = "操渠道标识", length = 100)
    public String transSrc;
    
    /**
     * 支付 - 银行转出户名
     */
    @PropertyInfo(name = "银行转出户名", length = 100)
    public String bankOutAcctName;
    
    /**
     * 支付 - 银行转入户名
     */
    @PropertyInfo(name = "银行转入户名", length = 100)
    public String bankInAcctName;
    
    /**
     * 支付 - 对公还款转入户名
     */
    @PropertyInfo(name = "对公还款转入户名", length = 100)
    public String bankPublicInAcctName;
    
    /**
     * 理赔方式
     */
    @PropertyInfo(name = "理赔方式", length = 2)
    public ClaimType claimType;
    
    /**
     * 理赔天数
     */
    @PropertyInfo(name = "理赔天数", length = 4)
    public Integer claimDays;

    /**
     * 发送扣款指令通知
     * 配置数据字典
     */
    @PropertyInfo(name = "发送扣款指令通知", length = 100)
    public String sendDeductNotice;
    
    /**
	 * 预理赔起始天数
	 */
	@PropertyInfo(name = "预理赔起始天数", length = 3)
	public Integer preClaimStartDays;

	/**
	 * 预理赔终止天数
	 */
	@PropertyInfo(name = "预理赔终止天数", length = 3)
	public Integer preClaimEndDays;

	/**
	 * 理赔天数
	 */
	@PropertyInfo(name = "理赔天数", length = 3)
	public Integer claimsDays;
    

	public String getFinancialOrgNO() {
		return financialOrgNO;
	}

	public void setFinancialOrgNO(String financialOrgNO) {
		this.financialOrgNO = financialOrgNO;
	}

	public String getFinancialOrgName() {
		return financialOrgName;
	}

	public void setFinancialOrgName(String financialOrgName) {
		this.financialOrgName = financialOrgName;
	}

	public String getFinancialOrgAcctNo() {
		return financialOrgAcctNo;
	}

	public void setFinancialOrgAcctNo(String financialOrgAcctNo) {
		this.financialOrgAcctNo = financialOrgAcctNo;
	}

	public String getAcctBank() {
		return acctBank;
	}

	public void setAcctBank(String acctBank) {
		this.acctBank = acctBank;
	}

	public String getAcctProvince() {
		return acctProvince;
	}

	public void setAcctProvince(String acctProvince) {
		this.acctProvince = acctProvince;
	}

	public String getAcctCity() {
		return acctCity;
	}

	public void setAcctCity(String acctCity) {
		this.acctCity = acctCity;
	}

	public String getAcctBranchBank() {
		return acctBranchBank;
	}

	public void setAcctBranchBank(String acctBranchBank) {
		this.acctBranchBank = acctBranchBank;
	}

	public String getFinancialOrgPayNo() {
		return financialOrgPayNo;
	}

	public void setFinancialOrgPayNo(String financialOrgPayNo) {
		this.financialOrgPayNo = financialOrgPayNo;
	}

	public String getPayBank() {
		return payBank;
	}

	public void setPayBank(String payBank) {
		this.payBank = payBank;
	}

	public String getPayProvince() {
		return payProvince;
	}

	public void setPayProvince(String payProvince) {
		this.payProvince = payProvince;
	}

	public String getPayCity() {
		return payCity;
	}

	public void setPayCity(String payCity) {
		this.payCity = payCity;
	}

	public String getPayBranchBank() {
		return payBranchBank;
	}

	public void setPayBranchBank(String payBranchBank) {
		this.payBranchBank = payBranchBank;
	}

	public BigDecimal getAdFeeScale() {
		return adFeeScale;
	}

	public void setAdFeeScale(BigDecimal adFeeScale) {
		this.adFeeScale = adFeeScale;
	}

	public String getAcqAcceptorId() {
		return acqAcceptorId;
	}

	public void setAcqAcceptorId(String acqAcceptorId) {
		this.acqAcceptorId = acqAcceptorId;
	}

	public String getSplitTableId() {
		return splitTableId;
	}

	public void setSplitTableId(String splitTableId) {
		this.splitTableId = splitTableId;
	}

	public Indicator getIsSettle() {
		return isSettle;
	}

	public void setIsSettle(Indicator isSettle) {
		this.isSettle = isSettle;
	}

	public Integer getMonthSettleDay() {
		return monthSettleDay;
	}

	public void setMonthSettleDay(Integer monthSettleDay) {
		this.monthSettleDay = monthSettleDay;
	}

	public Integer getSettleStartDay() {
		return settleStartDay;
	}

	public void setSettleStartDay(Integer settleStartDay) {
		this.settleStartDay = settleStartDay;
	}

	public Integer getSettleEndDay() {
		return settleEndDay;
	}

	public void setSettleEndDay(Integer settleEndDay) {
		this.settleEndDay = settleEndDay;
	}

	public SettleUnit getSettleUnit() {
		return settleUnit;
	}

	public void setSettleUnit(SettleUnit settleUnit) {
		this.settleUnit = settleUnit;
	}

	public String getCurrencyCd() {
		return currencyCd;
	}

	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
	}

	public String getCountryCd() {
		return countryCd;
	}

	public void setCountryCd(String countryCd) {
		this.countryCd = countryCd;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCorporationCd() {
		return corporationCd;
	}

	public void setCorporationCd(String corporationCd) {
		this.corporationCd = corporationCd;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InputSource getInputSource() {
		return inputSource;
	}

	public void setInputSource(InputSource inputSource) {
		this.inputSource = inputSource;
	}

	public String getPayOpenBankId() {
		return payOpenBankId;
	}

	public void setPayOpenBankId(String payOpenBankId) {
		this.payOpenBankId = payOpenBankId;
	}

	public String getAcctOpenBankId() {
		return acctOpenBankId;
	}

	public void setAcctOpenBankId(String acctOpenBankId) {
		this.acctOpenBankId = acctOpenBankId;
	}

	public String getExternalLoanCompOrg() {
		return externalLoanCompOrg;
	}

	public void setExternalLoanCompOrg(String externalLoanCompOrg) {
		this.externalLoanCompOrg = externalLoanCompOrg;
	}

	public String getDerectLoanCompOrg() {
		return derectLoanCompOrg;
	}

	public void setDerectLoanCompOrg(String derectLoanCompOrg) {
		this.derectLoanCompOrg = derectLoanCompOrg;
	}

	public String getExternalCutCompOrg() {
		return externalCutCompOrg;
	}

	public void setExternalCutCompOrg(String externalCutCompOrg) {
		this.externalCutCompOrg = externalCutCompOrg;
	}

	public String getDerectCutCompOrg() {
		return derectCutCompOrg;
	}

	public void setDerectCutCompOrg(String derectCutCompOrg) {
		this.derectCutCompOrg = derectCutCompOrg;
	}

	public Indicator getExternalLoanCompInd() {
		return externalLoanCompInd;
	}

	public void setExternalLoanCompInd(Indicator externalLoanCompInd) {
		this.externalLoanCompInd = externalLoanCompInd;
	}

	public Indicator getDerectLoanCompInd() {
		return derectLoanCompInd;
	}

	public void setDerectLoanCompInd(Indicator derectLoanCompInd) {
		this.derectLoanCompInd = derectLoanCompInd;
	}

	public Indicator getExternalCutCompInd() {
		return externalCutCompInd;
	}

	public void setExternalCutCompInd(Indicator externalCutCompInd) {
		this.externalCutCompInd = externalCutCompInd;
	}

	public Indicator getDerectCutCompInd() {
		return derectCutCompInd;
	}

	public void setDerectCutCompInd(Indicator derectCutCompInd) {
		this.derectCutCompInd = derectCutCompInd;
	}

	public String getInsuranceFeeAcctNo() {
		return insuranceFeeAcctNo;
	}

	public void setInsuranceFeeAcctNo(String insuranceFeeAcctNo) {
		this.insuranceFeeAcctNo = insuranceFeeAcctNo;
	}

	public String getInsuranceFeeBankAcctNo() {
		return insuranceFeeBankAcctNo;
	}

	public void setInsuranceFeeBankAcctNo(String insuranceFeeBankAcctNo) {
		this.insuranceFeeBankAcctNo = insuranceFeeBankAcctNo;
	}

	public String getSubrogationAcctNo() {
		return subrogationAcctNo;
	}

	public void setSubrogationAcctNo(String subrogationAcctNo) {
		this.subrogationAcctNo = subrogationAcctNo;
	}

	public String getSubrogationBankAcctNo() {
		return subrogationBankAcctNo;
	}

	public void setSubrogationBankAcctNo(String subrogationBankAcctNo) {
		this.subrogationBankAcctNo = subrogationBankAcctNo;
	}

	public String getRepayTxnFeeAcctNo() {
		return repayTxnFeeAcctNo;
	}

	public void setRepayTxnFeeAcctNo(String repayTxnFeeAcctNo) {
		this.repayTxnFeeAcctNo = repayTxnFeeAcctNo;
	}

	public String getRepayTxnFeeBankAcctNo() {
		return repayTxnFeeBankAcctNo;
	}

	public void setRepayTxnFeeBankAcctNo(String repayTxnFeeBankAcctNo) {
		this.repayTxnFeeBankAcctNo = repayTxnFeeBankAcctNo;
	}

	public Indicator getAllowBatchSubrogation() {
		return allowBatchSubrogation;
	}

	public void setAllowBatchSubrogation(Indicator allowBatchSubrogation) {
		this.allowBatchSubrogation = allowBatchSubrogation;
	}

	public String getClaimApplicationTemplate() {
		return claimApplicationTemplate;
	}

	public void setClaimApplicationTemplate(String claimApplicationTemplate) {
		this.claimApplicationTemplate = claimApplicationTemplate;
	}

	public ClaimType getClaimType() {
		return claimType;
	}

	public void setClaimType(ClaimType claimType) {
		this.claimType = claimType;
	}

	public Integer getClaimDays() {
		return claimDays;
	}

	public void setClaimDays(Integer claimDays) {
		this.claimDays = claimDays;
	}

	public Indicator getJoinBatchDeduct() {
		return joinBatchDeduct;
	}

	public void setJoinBatchDeduct(Indicator joinBatchDeduct) {
		this.joinBatchDeduct = joinBatchDeduct;
	}

	public String getLoanDeviceId() {
		return loanDeviceId;
	}

	public void setLoanDeviceId(String loanDeviceId) {
		this.loanDeviceId = loanDeviceId;
	}

	public String getBankOutAcctNbr() {
		return bankOutAcctNbr;
	}

	public void setBankOutAcctNbr(String bankOutAcctNbr) {
		this.bankOutAcctNbr = bankOutAcctNbr;
	}

	public String getBankInAcctNbr() {
		return bankInAcctNbr;
	}

	public void setBankInAcctNbr(String bankInAcctNbr) {
		this.bankInAcctNbr = bankInAcctNbr;
	}

	public String getCoopInAcctNbr() {
		return coopInAcctNbr;
	}

	public void setCoopInAcctNbr(String coopInAcctNbr) {
		this.coopInAcctNbr = coopInAcctNbr;
	}

	public String getTransBranCode() {
		return transBranCode;
	}

	public void setTransBranCode(String transBranCode) {
		this.transBranCode = transBranCode;
	}

	public String getOperNo() {
		return operNo;
	}

	public void setOperNo(String operNo) {
		this.operNo = operNo;
	}

	public String getBranchNo() {
		return branchNo;
	}

	public void setBranchNo(String branchNo) {
		this.branchNo = branchNo;
	}

	public String getTelerNo() {
		return telerNo;
	}

	public void setTelerNo(String telerNo) {
		this.telerNo = telerNo;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getTransSrc() {
		return transSrc;
	}

	public void setTransSrc(String transSrc) {
		this.transSrc = transSrc;
	}

	public String getBankOutAcctName() {
		return bankOutAcctName;
	}

	public void setBankOutAcctName(String bankOutAcctName) {
		this.bankOutAcctName = bankOutAcctName;
	}

	public String getBankInAcctName() {
		return bankInAcctName;
	}

	public void setBankInAcctName(String bankInAcctName) {
		this.bankInAcctName = bankInAcctName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public Map<Integer, ClaimDef> getClaimDefMap() {
		return claimDefMap;
	}

	
	public void setClaimDefMap(Map<Integer, ClaimDef> claimDefMap) {
		this.claimDefMap = claimDefMap;
	}

	
	public String getBizBranchBankName() {
		return bizBranchBankName;
	}

	
	public void setBizBranchBankName(String bizBranchBankName) {
		this.bizBranchBankName = bizBranchBankName;
	}

	
	public String getBankPublicInAcctNbr() {
		return bankPublicInAcctNbr;
	}

	
	public void setBankPublicInAcctNbr(String bankPublicInAcctNbr) {
		this.bankPublicInAcctNbr = bankPublicInAcctNbr;
	}

	
	public String getBankPublicInAcctName() {
		return bankPublicInAcctName;
	}

	
	public void setBankPublicInAcctName(String bankPublicInAcctName) {
		this.bankPublicInAcctName = bankPublicInAcctName;
	}

	
	public String getSendDeductNotice() {
		return sendDeductNotice;
	}

	
	public void setSendDeductNotice(String sendDeductNotice) {
		this.sendDeductNotice = sendDeductNotice;
	}

	public Integer getPreClaimStartDays() {
		return preClaimStartDays;
	}

	public void setPreClaimStartDays(Integer preClaimStartDays) {
		this.preClaimStartDays = preClaimStartDays;
	}

	public Integer getPreClaimEndDays() {
		return preClaimEndDays;
	}

	public void setPreClaimEndDays(Integer preClaimEndDays) {
		this.preClaimEndDays = preClaimEndDays;
	}

	public Integer getClaimsDays() {
		return claimsDays;
	}

	public void setClaimsDays(Integer claimsDays) {
		this.claimsDays = claimsDays;
	}
	
}
