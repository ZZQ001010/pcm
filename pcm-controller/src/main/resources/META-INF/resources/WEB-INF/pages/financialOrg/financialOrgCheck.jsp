<%@page import="cn.sunline.common.KC"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="financialOrg.detail.title" text="合作机构明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
<style type="text/css">
.form-horizontal .control-label {
    padding-top: 5px;
}
@media (max-width: 768px) {
	.form-horizontal .control-label {
	    text-align: right !important;
	}
	.form-product .control-label {
		text-align: right !important;
	}
}
</style>
</head>
<script type="text/javascript">
	var var1 = "<spring:message code='financialOrg.financialOrgNO.desc'  text='金融机构编码描述'/>";
</script>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px;padding-right: 40px" modelAttribute="financialOrg" method="post">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					<spring:message code="financial.baseInfo" text="基本信息" />
				</h2>
				<ul class="nav navbar-right panel_toolbox def-toolbox">
					<li>
						<a class="collapse-link">
							<i class="fa fa-chevron-up"></i>
						</a>
					</li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<div class="form-group row">
					<!-- 金融机构编码 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.financialOrgNO" text="金融机构编码" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.financialOrgNO } </label>
					<!-- 金融机构名称 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.financialOrgName" text="金融机构名称" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.financialOrgName } </label>
					<!-- 法人编号 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.corporationCd" text="法人编号" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.corporationCd } </label>

					<!-- 货币代码 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.currencyCd" text="货币代码" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.currencyCd} </label>
					<!-- 提前还款手续费分成比例 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.adFeeScale" text="提前还款手续费分成比例" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.adFeeScale} </label>

					<!-- 金融机构标识码 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.acqAcceptorId" text="金融机构标识码" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.acqAcceptorId} </label>
					<!-- 代位追偿金额拆分方式 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.splitTableId" text="代位追偿金额拆分方式" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.splitTableId} </label>
					<!-- 国家代码 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.countryCd" text="国家代码" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.countryCd} </label>
					<!-- 省份 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.province" text="省份" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.province} </label>
					<!-- 城市 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.city" text="城市" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.city} </label>
					<!-- 地址 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.address" text="地址" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.address} </label>

					<!-- 联系电话1 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.phone1" text="联系电话1" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.phone1} </label>

					<!-- 联系电话2 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.phone2" text="联系电话2" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.phone2} </label>

					<!-- 传真 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.fax" text="传真" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.fax} </label>
					<!-- 电子邮箱 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.email" text="电子邮箱" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.email} </label>

					<!-- 外部放款对账方 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.externalLoanCompOrg" text="外部放款对账方" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.externalLoanCompOrg} </label>

					<!-- 直接扣款对账方 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.derectCutCompOrg" text="直接扣款对账方" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.derectCutCompOrg} </label>
					<!-- 直接放款对账方 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.derectLoanCompOrg" text="直接放款对账方" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.derectLoanCompOrg} </label>
					<!-- 外部扣款对账方 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.externalCutCompOrg" text="外部扣款对账方" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.externalCutCompOrg} </label>
					
					<!-- 外部扣款是否强制不对账 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.externalCutCompInd" text="外部扣款是否强制不对账" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6 detailStyle" >
						&nbsp;${externalCutCompInd}
					</label>
					<!-- 外部放款是否强制不对账 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.externalLoanCompInd" text="外部放款是否强制不对账" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6 detailStyle" >
						&nbsp;${externalLoanCompInd}
					</label>
					<!-- 直接扣款是否强制不对账 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.derectCutCompInd" text="直接扣款是否强制不对账" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6 detailStyle"  >
						&nbsp;${derectCutCompInd }
					</label>
					<!-- 直接放款是否强制不对账 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.derectLoanCompInd" text="直接放款是否强制不对账" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6 detailStyle"  >
						&nbsp;${derectLoanCompInd}
					</label>
		</div>
		</div>
		</div>
		
		<div class="x_panel">
			<div class="x_title">
				<h2>
					<spring:message code="financial.acctInfo" text="对公账户" />
				</h2>
				<ul class="nav navbar-right panel_toolbox def-toolbox">
					<li>
						<a class="collapse-link">
							<i class="fa fa-chevron-up"></i>
						</a>
					</li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<div class="form-group row">
					<!-- 金融机构对公账户 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.financialOrgAcctNo" text="金融机构对公账户" />:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;&nbsp;${financialOrg.financialOrgAcctNo} </label>
					
					<!-- 对公账户的开户行号 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.acctOpenBankId" text="对公账户的开户行号" />:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.acctOpenBankId} </label>
					<!-- 开户银行 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.acctBank" text="开户银行" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.acctBank} </label>
					
					<!-- 代偿费金融机构对公账户 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.subrogationAcctNo" text="代偿费金融机构对公账户" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.subrogationAcctNo} </label>
					<!-- 代偿费银行对公账户 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.subrogationBankAcctNo" text="代偿费银行对公账户" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.subrogationBankAcctNo} </label>
					
					<!-- 开户行省份 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.acctProvince" text="开户行省份" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.acctProvince} </label>
					<!-- 开户行城市 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.acctCity" text="开户行城市" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.acctCity} </label>
					<!-- 开户行支行 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.acctBranchBank" text="开户行支行" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.acctBranchBank} </label>
					<!-- 每月结算日 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.monthSettleDay" text="每月结算日" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.monthSettleDay} </label>

					<!-- 结算起始日 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.settleStartDay" text="结算起始日" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.settleStartDay} </label>
					<!-- 结算截止日 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.settleEndDay" text="结算截止日" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.settleEndDay} </label>

					<!-- 结算渠道 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.inputSource" text="结算渠道" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.inputSource} </label>
					<!-- 对公账户的开户行号 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.acctOpenBankId" text="对公账户的开户行号" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.acctOpenBankId} </label>
					<!-- 结算周期 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.settleUnit" text="结算周期" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${settleUnit} </label>
					<!-- 提前还款手续费金融机构账户 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.repayTxnFeeAcctNo" text="提前还款手续费金融机构账户" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.repayTxnFeeAcctNo } </label>
					<!-- 提前还款手续费银行账户 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.repayTxnFeeBankAcctNo" text="提前还款手续费银行账户" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.repayTxnFeeBankAcctNo } </label>
					<!-- 是否参与结算 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.isSettle" text="是否参与结算" />:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6 detailStyle" >
						&nbsp;${isSettle}
					</label>
					<!-- 合作方直接收取费用银行对公账户  -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.insuranceFeeBankAcctNo" text="合作方直接收取费用银行对公账户 " />:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.insuranceFeeBankAcctNo} </label>
					
					<!-- 合作方直接收取费用金融机构对公账户 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.insuranceFeeAcctNo" text="合作方直接收取费用金融机构对公账户" />:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.insuranceFeeAcctNo} </label>
					
					</div>
				</div>
			</div>
		<div class="x_panel">
			<div class="x_title">
				<h2>
					<spring:message code="financial.payInfo" text="理赔账户" />
				</h2>
				<ul class="nav navbar-right panel_toolbox def-toolbox">
					<li>
						<a class="collapse-link">
							<i class="fa fa-chevron-up"></i>
						</a>
					</li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<div class="form-group row">
					<!-- 金融机构理赔账户 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.financialOrgPayNo" text="金融机构理赔账户" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.financialOrgPayNo} </label>

					<!-- 开户银行 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.payBank" text="开户银行" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.payBank} </label>
					<!-- 开户行省份 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.payProvince" text="开户行省份" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.payProvince} </label>
					<!-- 开户行城市 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.payCity" text="开户行城市" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.payCity} </label>
					<!-- 开户行支行 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.payBranchBank" text="开户行支行" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.payBranchBank} </label>
					<!-- 理赔账户的开户行号 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.payOpenBankId" text="理赔账户的开户行号" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.payOpenBankId} </label>
				</div>
			</div>
			
			</div>
		<div class="x_panel">
			<div class="x_title">
				<h2>
					<spring:message code="financial.claimInfo" text="理赔信息" />
				</h2>
				<ul class="nav navbar-right panel_toolbox def-toolbox">
					<li>
						<a class="collapse-link">
							<i class="fa fa-chevron-up"></i>
						</a>
					</li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<div class="form-group row">
					<!-- 理赔方式 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.claimType" text="理赔方式" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${claimType} </label>
					<!-- 理赔天数 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.claimDays" text="理赔天数" />
						:
					</label>
					<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> &nbsp;${financialOrg.claimDays } </label>
				</div>
			</div>
		</div>
		<div class="x_panel">
			<div class="x_title">
				<h2>
					<spring:message code="financial.claimInfo" text="预理赔申请书" />
				</h2>
				<ul class="nav navbar-right panel_toolbox def-toolbox">
					<li>
						<a class="collapse-link">
							<i class="fa fa-chevron-up"></i>
						</a>
					</li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<div class="form-group row">
					<!-- 索赔申请书模板 -->
					<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
						<spring:message code="financialOrg.claimApplicationTemplate" text="索赔申请书模板" />
						:
					</label>
					<label class="col-lg-9 col-md-9 col-sm-12 col-xs-12 detailStyle"> &nbsp;${financialOrg.claimApplicationTemplate } </label>
				</div>
			</div>
		</div>
		<div class="form-controls">
			<div class="cbtn-group-md">
				<k:access code="financialOrg_edit">
					<!-- 确定 -->
					<input type="button" id="updateFinancialOrg" class="btn-info btn" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
					<script type="text/javascript">
						$("#updateFinancialOrg")
								.click(
										function() {
											var params = [];
											params
													.push("financialOrgNO=${financialOrg.financialOrgNO}");
											$K.frame
													.reloadSlideInner("${ctx}/financialOrg/financialOrgEditPage.in?"
															+ params.join("&"));
										})
					</script>
				</k:access>
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
			</div>
		</div>
	</form:form>
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp"%>
	<script>
		bindfun(".js-switch", "Y", "N");
		function bindfun(classStyle, cheVal, uncheVal) {
			$(classStyle).each(
					function(i, ck) {
						//給開發賦值
						var value = $(this).parent().find('input[type=hidden]')
								.val();
						if (value == "Y") {
							$(this).attr("checked", "checked");
						}
						//给开关判断事件
						$(this).change(
								function() {
									if ($(this).is(':checked')) {
										$(this).parent().find(
												'input[type=hidden]').val(
												cheVal);
									} else {
										$(this).parent().find(
												'input[type=hidden]').val(
												uncheVal);
									}
								});
					});
		}
	</script>
</body>
</html>