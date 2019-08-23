<%@page import="cn.sunline.common.KC"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="financialOrg.add.title" text="合作机构新增" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
<style type="text/css">

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
	<form:form cssClass="form-horizontal" id="financialOrgAddForm" cssStyle="padding-top: 40px;padding-right: 40px" modelAttribute="financialOrg" method="post" action="${ctx}/financialOrg/addFinancialOrg.in" data-confirm="true">
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
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 金融机构编码 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<span class="span-icon">*&nbsp;</span>
						<spring:message code="financialOrg.financialOrgNO" text="金融机构编码" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<!-- <spring:message code='financialOrg.financialOrgNO.desc'  text='金融机构编码描述'/> -->
						<form:input cssClass="form-control" path="financialOrgNO" data-rule-required="true" data-rule-maxlength="9" />
					</div>
					<!-- 金融机构编码描述 -->
					<div class="hide desc" for="financialOrgNO">
						<spring:message code="financialOrg.financialOrgNO.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 金融机构名称 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<span class="span-icon">*&nbsp;</span>
						<spring:message code="financialOrg.financialOrgName" text="金融机构名称" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="financialOrgName" data-rule-required="true" data-rule-maxlength="200" />
					</div>
					<!-- 金融机构名称描述 -->
					<div class="hide desc" for="financialOrgName">
						<spring:message code="financialOrg.financialOrgName.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 法人编号 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.corporationCd" text="法人编号" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="corporationCd" data-rule-maxlength="9" />
					</div>
					<!-- 法人编号描述 -->
					<div class="hide desc" for="corporationCd">
						<spring:message code="financialOrg.corporationCd.desc" />
					</div>
				</div>
					<!-- 货币代码 -->
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.currencyCd" text="货币代码" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="currencyCd" data-rule-maxlength="3" />
					</div>
					<!-- 货币代码描述 -->
					<div class="hide desc" for="currencyCd">
						<spring:message code="financialOrg.currencyCd.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 预理赔起始天数 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-12 control-label">
						<spring:message code="financialOrg.preClaimStartDays" text="预理赔起始天数" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-12">
						<form:input cssClass="form-control" path="preClaimStartDays" data-rule-maxlength="9" />
					</div>
						<!-- 预理赔起始天数描述 -->
					<div class="hide desc" for="corporationCd">
						<spring:message code="financialOrg.preClaimStartDays.desc" />
					</div>
				</div>
				
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 预理赔终止天数 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-12 control-label">
						<spring:message code="financialOrg.preClaimEndDays" text="预理赔终止天数" />
						:
					</label>
				<div class="col-lg-6 col-md-6  col-sm-6 col-xs-12">
						<form:input cssClass="form-control" path="preClaimEndDays" data-rule-maxlength="3" />
					</div>
					<!-- 预理赔终止天数描述 -->
					<div class="hide desc" for="currencyCd">
						<spring:message code="financialOrg.preClaimEndDays.desc" />
					</div>
					
				</div>
				
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 理赔天数 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-12 control-label">
						<spring:message code="financialOrg.claimsDays" text="理赔天数" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-12">
						<form:input cssClass="form-control" path="claimsDays" data-rule-maxlength="3" />
					</div>
					<!-- 理赔天数 -->
					<div class="hide desc" for="currencyCd">
						<spring:message code="financialOrg.claimsDays.desc" />
					</div>
				</div>
				</div>
			<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 提前还款手续费分成比例 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<span class="span-icon">*&nbsp;</span>
						<spring:message code="financialOrg.adFeeScale" text="提前还款手续费分成比例" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="adFeeScale" data-rule-required="true" data-rule-number="true" data-rule-min="0" data-rule-max="99.9999" />
					</div>
					<!-- 提前还款手续费分成比例描述 -->
					<div class="hide desc" for="adFeeScale">
						<spring:message code="financialOrg.adFeeScale.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 金融机构标识码 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<span class="span-icon">*&nbsp;</span>
						<spring:message code="financialOrg.acqAcceptorId" text="金融机构标识码" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="acqAcceptorId" data-rule-required="true" data-rule-maxlength="15" />
					</div>
					<!-- 金融机构标识码描述 -->
					<div class="hide desc" for="acqAcceptorId">
						<spring:message code="financialOrg.acqAcceptorId.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 代位追偿金额拆分方式 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<span class="span-icon">*&nbsp;</span>
						<spring:message code="financialOrg.splitTableId" text="代位追偿金额拆分方式" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="splitTableId">
							<form:options items="${splitTableId}" />
						</form:select>
					</div>
					<!-- 代位追偿金额拆分方式描述 -->
					<div class="hide desc" for="splitTableId">
						<spring:message code="financialOrg.splitTableId.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 国家代码 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.countryCd" text="国家代码" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="countryCd" data-rule-maxlength="9" />
					</div>
					<!-- 国家代码描述 -->
					<div class="hide desc" for="countryCd">
						<spring:message code="financialOrg.countryCd.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 省份 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.province" text="省份" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="province" id="province">
							<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
							<form:options items="${province}" />
						</form:select>
					</div>
					<!-- 省份描述 -->
					<div class="hide desc" for="province">
						<spring:message code="financialOrg.province.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 城市 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.city" text="城市" />
						:
					</label>
					<div id="cityBox" class="col-lg-6 col-md-6  col-sm-6 col-xs-12">
						<form:select cssClass="form-control" path="city" id="city" name="city">
							<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
							<form:options items="${city}" />
						</form:select>
					</div>
					<!-- 城市描述 -->
					<div class="hide desc" for="city">
						<spring:message code="financialOrg.city.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 地址 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.address" text="地址" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="address" data-rule-maxlength="200" />
					</div>
					<!-- 地址描述 -->
					<div class="hide desc" for="address">
						<spring:message code="financialOrg.address.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 联系电话1 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.phone1" text="联系电话1" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="phone1" data-rule-maxlength="20" />
					</div>
					<!-- 联系电话1描述 -->
					<div class="hide desc" for="phone1">
						<spring:message code="financialOrg.phone1.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 联系电话2 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.phone2" text="联系电话2" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="phone2" data-rule-maxlength="20" />
					</div>
					<!-- 联系电话2描述 -->
					<div class="hide desc" for="phone2">
						<spring:message code="financialOrg.phone2.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 传真 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.fax" text="传真" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="fax" data-rule-maxlength="20" />
					</div>
					<!-- 传真描述 -->
					<div class="hide desc" for="fax">
						<spring:message code="financialOrg.fax.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 电子邮箱 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.email" text="电子邮箱" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="email" data-rule-maxlength="40" />
					</div>
					<!-- 电子邮箱描述 -->
					<div class="hide desc" for="email">
						<spring:message code="financialOrg.email.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 外部放款对账方 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.externalLoanCompOrg" text="外部放款对账方" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="externalLoanCompOrg">
							<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
							<form:options items="${financialOrgMap}" />
						</form:select>
					</div>
					<!-- 外部放款对账方描述 -->
					<div class="hide desc" for="externalLoanCompOrg">
						<spring:message code="financialOrg.externalLoanCompOrg.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 直接扣款对账方 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.derectCutCompOrg" text="直接扣款对账方" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="derectCutCompOrg">
							<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
							<form:options items="${financialOrgMap}" />
						</form:select>
					</div>
					<!-- 直接扣款对账方描述 -->
					<div class="hide desc" for="derectCutCompOrg">
						<spring:message code="financialOrg.derectCutCompOrg.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 直接放款对账方 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.derectLoanCompOrg" text="直接放款对账方" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="derectLoanCompOrg">
							<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
							<form:options items="${financialOrgMap}" />
						</form:select>
					</div>
					<!-- 直接放款对账方描述 -->
					<div class="hide desc" for="derectLoanCompOrg">
						<spring:message code="financialOrg.derectLoanCompOrg.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 外部扣款对账方 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.externalCutCompOrg" text="外部扣款对账方" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="externalCutCompOrg">
							<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
							<form:options items="${financialOrgMap}" />
						</form:select>
					</div>
					<!-- 外部扣款对账方描述 -->
					<div class="hide desc" for="externalCutCompOrg">
						<spring:message code="financialOrg.externalCutCompOrg.desc" />
					</div>
				</div>
			</div>
				<!-- 分界线aaa -->
				<div class="form-group row col-lg-12 col-md-12 col-sm-10 col-xs-10">
					<!-- 外部扣款是否强制不对账 -->
					<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.externalCutCompInd" text="外部扣款是否强制不对账" />
						:
					</label>
					<div class="col-lg-2 col-md-3 col-sm-6 col-xs-6" style="margin-top: 8px;">
						<input id="externalLoanCompInd" type="checkbox" class="js-switch" unchecked />
						<form:hidden path="externalCutCompInd" value="N" />
					</div>
					<!-- 外部扣款是否强制不对账描述 -->
					<div class="hide desc">
						<spring:message code="financialOrg.externalCutCompInd.desc" />
					</div>
				
					<!-- 外部放款是否强制不对账 -->
					<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.externalLoanCompInd" text="外部放款是否强制不对账" />
						:
					</label>
					<div class="col-lg-2 col-md-3 col-sm-6 col-xs-6" style="margin-top: 8px;">
						<input id="externalLoanCompInd" type="checkbox" class="js-switch" unchecked />
						<form:hidden path="externalLoanCompInd" value="N" />
					</div>
					<!-- 外部放款是否强制不对账描述 -->
					<div class="hide desc" for="externalLoanCompInd">
						<spring:message code="financialOrg.externalLoanCompInd.desc" />
					</div>
				
				
					<!-- 直接扣款是否强制不对账 -->
					<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.derectCutCompInd" text="直接扣款是否强制不对账" />
						:
					</label>
					<div class="col-lg-2 col-md-3 col-sm-6 col-xs-6" style="margin-top: 8px;">

						<input id="derectCutCompInd" type="checkbox" class="js-switch" unchecked />
						<form:hidden path="derectCutCompInd" value="N" />
					</div>
					<!-- 直接扣款是否强制不对账描述 -->
					<div class="hide desc" for="derectCutCompInd">
						<spring:message code="financialOrg.derectCutCompInd.desc" />
					</div>
					<!-- 直接放款是否强制不对账 -->
					<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.derectLoanCompInd" text="直接放款是否强制不对账" />
						:
					</label>
					<div class="col-lg-2 col-md-3 col-sm-6 col-xs-6" style="margin-top: 8px;">

						<input id="derectLoanCompInd" type="checkbox" class="js-switch" unchecked />
						<form:hidden path="derectLoanCompInd" value="N" />
					</div>
					<!-- 直接放款是否强制不对账描述 -->
					<div class="hide desc" for="derectLoanCompInd">
						<spring:message code="financialOrg.derectLoanCompInd.desc" />
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
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 金融机构对公账户 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.financialOrgAcctNo" text="金融机构对公账户" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="financialOrgAcctNo" data-rule-maxlength="19" />
					</div>
					<!-- 金融机构对公账户描述 -->
					<div class="hide desc" id="financialOrgAcctNo">
						<spring:message code="financialOrg.financialOrgAcctNo.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!--合作方直接收取费用金融机构对公账户 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.insuranceFeeAcctNo" text="合作方直接收取费用金融机构对公账户" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="insuranceFeeAcctNo" data-rule-maxlength="200" />
					</div>
					<!-- 合作方直接收取费用金融机构对公账户描述 -->
					<div class="hide desc" for="insuranceFeeAcctNo">
						<spring:message code="financialOrg.insuranceFeeAcctNo.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 合作方直接收取费用银行对公账户 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.insuranceFeeBankAcctNo" text="合作方直接收取费用银行对公账户" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="insuranceFeeBankAcctNo" data-rule-maxlength="32" />
					</div>
					<!-- 合作方直接收取费用银行对公账户描述 -->
					<div class="hide desc" for="insuranceFeeBankAcctNo">
						<spring:message code="financialOrg.insuranceFeeBankAcctNo.desc" />
					</div>
				</div>

				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!--代偿费金融机构对公账户 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.subrogationAcctNo" text="代偿费金融机构对公账户" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="SubrogationAcctNo" data-rule-maxlength="200" />
					</div>
					<!-- 代偿费金融机构对公账户描述 -->
					<div class="hide desc" for="SubrogationAcctNo">
						<spring:message code="financialOrg.SubrogationAcctNo.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 代偿费银行对公账户 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.subrogationBankAcctNo" text="代偿费银行对公账户" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="SubrogationBankAcctNo" data-rule-maxlength="32" />
					</div>
					<!-- 代偿费银行对公账户描述 -->
					<div class="hide desc" for="SubrogationBankAcctNo">
						<spring:message code="financialOrg.SubrogationBankAcctNo.desc" />
					</div>
				</div>

				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 对公账户的开户行号 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.acctOpenBankId" text="对公账户的开户行号" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="acctOpenBankId" data-rule-maxlength="20" />
					</div>
					<!-- 对公账户的开户行号描述 -->
					<div class="hide desc" for="acctOpenBankId">
						<spring:message code="financialOrg.acctOpenBankId.desc" />
					</div>
				</div>
				
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 开户银行 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.acctBank" text="开户银行" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="acctBank" data-rule-maxlength="50" />
					</div>
					<!-- 开户银行描述 -->
					<div class="hide desc" for="acctBank">
						<spring:message code="financialOrg.acctBank.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 开户行省份 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.acctProvince" text="开户行省份" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="acctProvince">
							<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
							<form:options items="${acctProvince}" />
						</form:select>
					</div>
					<!-- 开户行省份描述 -->
					<div class="hide desc" for="acctProvince">
						<spring:message code="financialOrg.acctProvince.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 开户行城市 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.acctCity" text="开户行城市" />
						:
					</label>
					<div id="acctCityBox" class="col-lg-6 col-md-6  col-sm-6 col-xs-12">
						<form:select cssClass="form-control" path="acctCity" id="acctcity" name="acctcity">
							<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
							<form:options items="${acctCity}" />
						</form:select>
					</div>
					<!-- 开户行城市描述 -->
					<div class="hide desc" for="acctCity">
						<spring:message code="financialOrg.acctCity.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 开户行支行 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.acctBranchBank" text="开户行支行" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="acctBranchBank" data-rule-maxlength="80" />
					</div>
					<!-- 开户行支行描述 -->
					<div class="hide desc" for="acctBranchBank">
						<spring:message code="financialOrg.acctBranchBank.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 每月结算日 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.monthSettleDay" text="每月结算日" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="monthSettleDay" data-rule-maxlength="2" />
					</div>
					<!-- 每月结算日描述 -->
					<div class="hide desc" for="monthSettleDay">
						<spring:message code="financialOrg.monthSettleDay.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 结算起始日 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.settleStartDay" text="结算起始日" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="settleStartDay" data-rule-maxlength="2" />
					</div>
					<!-- 结算起始日描述 -->
					<div class="hide desc" for="settleStartDay">
						<spring:message code="financialOrg.settleStartDay.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 结算截止日 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.settleEndDay" text="结算截止日" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="settleEndDay" data-rule-maxlength="1" />
					</div>
					<!-- 结算截止日描述 -->
					<div class="hide desc" for="settleEndDay">
						<spring:message code="financialOrg.settleEndDay.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 结算渠道 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.inputSource" text="结算渠道" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="inputSource" data-rule-maxlength="40" />
					</div>
					<!-- 结算渠道描述 -->
					<div class="hide desc" for="inputSource">
						<spring:message code="financialOrg.inputSource.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 结算周期 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.settleUnit" text="结算周期" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="settleUnit">
							<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
							<form:options items="${settleUnit}" />
						</form:select>
					</div>
					<!-- 结算周期描述 -->
					<div class="hide desc" for="settleUnit">
						<spring:message code="financialOrg.settleUnit.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 提前还款手续费金融机构账户 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.repayTxnFeeAcctNo" text="提前还款手续费金融机构账户" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="repayTxnFeeAcctNo" data-rule-maxlength="32" />
					</div>
					<!-- 提前还款手续费金融机构账户描述 -->
					<div class="hide desc" for="repayTxnFeeAcctNo">
						<spring:message code="financialOrg.repayTxnFeeAcctNo.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 提前还款手续费银行账户 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.repayTxnFeeBankAcctNo" text="提前还款手续费银行账户" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="repayTxnFeeBankAcctNo" data-rule-maxlength="32" />
					</div>
					<!-- 提前还款手续费银行账户描述 -->
					<div class="hide desc" for="repayTxnFeeBankAcctNo">
						<spring:message code="financialOrg.repayTxnFeeBankAcctNo.desc" />
					</div>
				</div>
			</div>
				<div class="form-group row col-lg-12 col-md-12 col-sm-10 col-xs-10">
				<!-- 是否参与结算 -->
					<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
						<span class="span-icon">*&nbsp;</span>
						<spring:message code="financialOrg.isSettle" text="是否参与结算" />
						:
					</label>
					<div class="col-lg-2 col-md-3 col-sm-6 col-xs-6" style="margin-top: 8px;">
						<input id="isSettle" type="checkbox" class="js-switch" unchecked />
						<form:hidden path="isSettle" value="N" />
					</div>
					<!-- 是否参与结算描述 -->
					<div class="hide desc" for="isSettle">
						<spring:message code="financialOrg.isSettle.desc" />
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
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 金融机构理赔账户 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.financialOrgPayNo" text="金融机构理赔账户" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="financialOrgPayNo" data-rule-maxlength="200" />
					</div>
					<!-- 金融机构理赔账户描述 -->
					<div class="hide desc" for="financialOrgPayNo">
						<spring:message code="financialOrg.financialOrgPayNo.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 开户银行 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.payBank" text="开户银行" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="payBank" data-rule-maxlength="50" />
					</div>
					<!-- 开户银行描述 -->
					<div class="hide desc" for="payBank">
						<spring:message code="financialOrg.payBank.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 开户行省份 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.payProvince" text="开户行省份" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="payProvince">
							<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
							<form:options items="${payProvince}" />
						</form:select>
					</div>
					<!-- 开户行省份描述 -->
					<div class="hide desc" for="payProvince">
						<spring:message code="financialOrg.payProvince.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 开户行城市 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.payCity" text="开户行城市" />
						:
					</label>
					<div id="payCityBox" class="col-lg-6 col-md-6  col-sm-6 col-xs-12">
						<form:select cssClass="form-control" path="payCity" id="paycity" name="paycity">
							<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
							<form:options items="${payCity}" />
						</form:select>
					</div>
					<!-- 开户行城市描述 -->
					<div class="hide desc" for="payCity">
						<spring:message code="financialOrg.payCity.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 开户行支行 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.payBranchBank" text="开户行支行" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="payBranchBank" data-rule-maxlength="80" />
					</div>
					<!-- 开户行支行描述 -->
					<div class="hide desc" for="payBranchBank">
						<spring:message code="financialOrg.payBranchBank.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 理赔账户的开户行号 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.payOpenBankId" text="理赔账户的开户行号" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="payOpenBankId" data-rule-maxlength="20" />
					</div>
					<!-- 理赔账户的开户行号描述 -->
					<div class="hide desc" for="payOpenBankId">
						<spring:message code="financialOrg.payOpenBankId.desc" />
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
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 理赔方式 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.claimType" text="理赔方式" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="claimType">
							<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
							<form:options items="${claimType}" />
						</form:select>
					</div>
					<!-- 理赔方式描述 -->
					<div class="hide desc" for="claimType">
						<spring:message code="financialOrg.claimType.desc" />
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 理赔天数 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="financialOrg.claimDays" text="理赔天数" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:input cssClass="form-control" path="claimDays" data-rule-digits="true" data-rule-min="0" data-rule-max="9999" />
					</div>
					<!-- 理赔天数描述 -->
					<div class="hide desc" for="claimDays">
						<spring:message code="financialOrg.claimDays.desc" />
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
				<div class="form-group row col-lg-12 col-md-10 col-sm-10 col-xs-10 ">
					<!-- 索赔申请书模板 -->
					<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
						<spring:message code="financialOrg.claimApplicationTemplate" text="索赔申请书模板" />
						:
					</label>
					<div class="col-lg-8 col-md-8 col-sm-8 col                                                                                                                                                                     -xs-8">
						<form:textarea cssClass='form-control noresize' path="claimApplicationTemplate" rows="5" />
					</div>
					<!-- 索赔申请书模板描述 -->
					<div class="hide desc" for="claimApplicationTemplate">
						<spring:message code="financialOrg.claimApplicationTemplate.desc" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-controls">
			<div class="cbtn-group-md auto-float">
				<!-- 确定 -->
				<input type="submit" class="btn-primary btn" value="<spring:message code='kite.web.common.btnSure' text='确定' />" />
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
			</div>
		</div>
	</form:form>
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp"%>
	<script>
		$(function() {
			$("[data-toggle='tooltip']").tooltip();
		});
		//开启表单验证
		$("#financialOrgAddForm").validate();
		$(".js-switch").each(function(i, ck) {
			$(this).change(function() {
				if ($(this).is(":checked")) {
					$(this).parent().find('input[type=hidden]').val('Y');
				} else {
					$(this).parent().find('input[type=hidden]').val('N');
				}
			});

		});
		//得到頁面上所有class 为 desc 的标签
		$.each($(".desc"), function(i, d) {
			var tar = $('#' + $(d).attr('for')), desc = d.innerText;
			if (tar && tar[0] && tar[0].tagName === 'SELECT') {
				tar = tar.parent();
			}
			tar.tooltip({
				title : desc
			});
		});
		//省份城市
		$("#province")
				.on(
						"change",
						function() {

							$
									.ajax({
										type : "post",
										url : "${ctx}/webCommon/loadCity.in ",
										cache : false,
										//async : false,
										data : $("#province").val(),
										dataType : "json",
										contentType : "application/json",
										success : function(data) {
											$("#cityBox").empty();
											$("#cityBox")
													.append(
															`<select id="city" class="form-control" name="city"><option value="">--- 请选择 --- </option></select>`);
											for ( var key in data) {
												$("#city").append(
														`<option value=`+key+`>`
																+ data[key]
																+ `</option>`);
											}
										}

									});
						});

		//开户城市
		$("#acctProvince")
				.on(
						"change",
						function() {
							$
									.ajax({
										type : "post",
										url : "${ctx}/webCommon/loadCity.in ",
										cache : false,
										//async : false,
										data : $("#acctProvince").val(),
										dataType : "json",
										contentType : "application/json",
										success : function(data) {
											$("#acctCityBox").empty();
											$("#acctCityBox")
													.append(
															`<select id="acctcity" class="form-control" name="acctcity"><option value="">--- 请选择 --- </option></select>`);
											for ( var key in data) {
												$("#acctcity").append(
														`<option value=`+key+`>`
																+ data[key]
																+ `</option>`);
											}
										}

									});
						});
		//开户城市2号	
		$("#payProvince")
				.on(
						"change",
						function() {
							$
									.ajax({
										type : "post",
										url : "${ctx}/webCommon/loadCity.in ",
										cache : false,
										//async : false,
										data : $("#payProvince").val(),
										dataType : "json",
										contentType : "application/json",
										success : function(data) {
											$("#payCityBox").empty();
											$("#payCityBox")
													.append(
															`<select id="paycity" class="form-control" name="paycity"><option value="">--- 请选择 --- </option></select>`);
											for ( var key in data) {
												$("#paycity").append(
														`<option value=`+key+`>`
																+ data[key]
																+ `</option>`);
											}
										}

									});
						});
	</script>
</body>
</html>