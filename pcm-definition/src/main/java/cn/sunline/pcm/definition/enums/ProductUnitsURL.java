package cn.sunline.pcm.definition.enums;

import cn.sunline.ppy.dictionary.enums.PlanType;

public enum ProductUnitsURL {
	/**
	 *卡片代码
	 */
	PHYCARD("/phyCardCd/phyCardCdConfigPage.in","/phyCardCd/phyCardCdCheckPage.in","/phyCardCd/phyCardCdSmallPage.in","cn.sunline.pcm.definition.PhyCardCd"),
	/**
	 * 超限费
	 */
	OVERLIMIT("/overlimit/overlimitConfigPage.in","/overlimit/overlimitCheckPage.in","/overlimit/overlimitSmallPage.in","cn.sunline.ccs.definition.OverlimitCharge"), 
	/**
	 * 短信模板
	 */
	MSG("/ccsProductMsg/ccsProductMsgConfigPage.in","/ccsProductMsg/ccsProductMsgCheckPage.in","/ccsProductMsg/ccsProductMsgSmallPage.in","cn.sunline.ccs.definition.productParam.CcsProductMessageParam"), 
	/**
	 * 客服服务费用
	 */
	CUS("/customServiceFee/customServiceFeeConfigPage.in","/customServiceFee/customServiceFeeCheckPage.in","/customServiceFee/customServiceFeeSmallPage.in","cn.sunline.ccs.definition.CustomerServiceFee"), 
	/**
	 * 杂项费用
	 */
	FEE("/fee/feeConfigPage.in","/fee/feeCheckPage.in","/fee/feeSmallPage.in","cn.sunline.ccs.definition.Fee"), 
	/**
	 * 滞纳金信息
	 */
	LATEFEE("/latePayCharge/latePayChargeConfigPage.in","/latePayCharge/latePayChargeCheckPage.in","/latePayCharge/latePayChargeSmallPage.in","cn.sunline.ccs.definition.LatePaymentCharge"), 
	/**
	 * 账户定义信息
	 */
	CRE("/accountAttribute/accountAttributeConfigPage.in","/accountAttribute/accountAttributeCheckPage.in","/accountAttribute/accountAttributeSmallPage.in","cn.sunline.ccs.definition.AccountAttribute"), 
	/**
	 * 交易费用
	 */
	TXNFEE("/txnFee/txnFeeConfigPage.in","/txnFee/txnFeeCheckPage.in","/txnFee/txnFeeSmallPage.in","cn.sunline.ccs.definition.TxnFee"), 
	
	/**
	 *贷款产品
	 */
	LOAN("/productLoan/productLoanConfigPage.in","/productLoan/productLoanCheckPage.in","/productLoan/productLoanSmallPage.in","cn.sunline.ccs.definition.ProductLoanParam"),
	
	/**
	 *贷款产品子产品
	 */
	LOANTERM("/productLoan/productLoanTermConfigPage.in","/productLoan/productLoanTermCheckPage.in","/productLoan/productLoanTermSmallPage.in","cn.sunline.ccs.definition.ProductLoanTermParam"),
	
	/** 
	 * 信用计划产品
	 */  
	CREDITPLAN("/creditPlanTemplate/creditPlanTemplateConfigPage.in","/planTemplate/planTemplateCheckPage.in","/creditPlanTemplate/creditPlanTemplateSmallPage.in","cn.sunline.ccs.definition.PlanTemplate",PlanType.class),

	/** 
	 * 合作机构管理
	 */  
	FINANCYORG("/financialOrg/financialOrgProductConfigPage.in","/financialOrg/financialOrgProductCheckPage.in","/financialOrg/financialOrgProductSmallPage.in","cn.sunline.pcm.definition.FinancialOrg"),
	
	/**
	 * 借记产品
	 */
	DEBIT("/productDebit/productDebitConfigPage.in","/productDebit/productDebitCheckPage.in","/productDebit/productDebitSmallPage.in","cn.sunline.ccs.definition.ProductDebit"),
	
	/**
	 * 借记账户
	 */
	DEBITACCT("/debitAccountAttribute/debitAccountAttributeConfigPage.in","/debitAccountAttribute/debitAccountAttributeCheckPage.in","/debitAccountAttribute/debitAccountAttributeSmallPage.in","cn.sunline.ccs.definition.DebitAccountAttribute"),
	
	/**
	 * 借记子账户
	 */
	DEBYACCT("/debitPlanTemplate/debitPlanTemplateConfigPage.in","/debitPlanTemplate/debitPlanTemplateCheckPage.in","/debitPlanTemplate/debitPlanTemplateSmallPage.in","cn.sunline.ccs.definition.DebitPlanTemplate",PlanType.class);
	
	
	private String unitConfigUrl;
	private String unitDetaiUrl;
	private String unitBaseUrl;
	private String unitClass;
	private Class<?> e;
	private ProductUnitsURL(String unitConfigUrl, String unitDetaiUrl, String unitBaseUrl, String unitClass) {
		this(unitConfigUrl,unitDetaiUrl,unitBaseUrl,unitClass, null);
	}
	private ProductUnitsURL(String unitConfigUrl, String unitDetaiUrl, String unitBaseUrl, String unitClass, Class<?> e) {
		this.unitConfigUrl = unitConfigUrl;
		this.unitDetaiUrl = unitDetaiUrl;
		this.unitBaseUrl = unitBaseUrl;
		this.unitClass = unitClass;
		this.e = e;
	}
	public String getUnitConfigUrl() {
		return unitConfigUrl;
	}
	public String getUnitDetaiUrl() {
		return unitDetaiUrl;
	}
	public String getUnitBaseUrl() {
		return unitBaseUrl;
	}
	public String getUnitClass() {
		return unitClass;
	}
	
	public Class<?> getEnum() {
		return e;
	}
	
}
	
	

