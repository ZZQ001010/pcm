<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="pcmOrgParameter.update.title" text="机构参数修改" /></title>
<%@ include file="/common/head.jsp"%>
</head>
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="pcmOrgParameterUpdForm" cssStyle="padding-top: 40px" modelAttribute="pcmOrgParameter" method="post" action="${ctx}/pcmOrgParameter/updPcmOrgParameter.in" data-confirm="true">
		<form:hidden path="orgCode" />
		<div class="form-group row">
			<!-- 机构名称 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="pcmOrgParameter.orgName" text="机构名称" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="orgName"  data-rule-required="true" data-rule-maxlength="32" />
			</div>
			<!-- 机构名称描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmOrgParameter.orgName.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 机构地址 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmOrgParameter.orgAddress" text="机构地址" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="orgAddress"  data-rule-required="true" data-rule-maxlength="200" />
			</div>
			<!-- 机构地址描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmOrgParameter.orgAddress.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 机构级别 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmOrgParameter.orgLevel" text="机构级别" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="orgLevel"  data-rule-required="true" data-rule-maxlength="32" />
			</div>
			<!-- 机构级别描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmOrgParameter.orgLevel.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 上级机构编码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="pcmOrgParameter.parentOrgCode" text="上级机构编码" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="parentOrgCode"  data-rule-required="true" data-rule-maxlength="32" />
			</div>
			<!-- 上级机构编码描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmOrgParameter.parentOrgCode.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 机构联系电话 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmOrgParameter.orgContactPhone" text="机构联系电话" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="orgContactPhone"  />
			</div>
			<!-- 机构联系电话描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmOrgParameter.orgContactPhone.desc" />
			</div>
		</div>		
		<div class="form-group row">
			<!-- 机构联系人 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmOrgParameter.orgContactPerson" text="机构联系人" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="orgContactPerson"  />
			</div>
			<!-- 机构联系人描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="机构联系人" />
			</div>
		</div>	
		
		<div class="form-group row">
			<!-- 业务范围 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmOrgParameter.bussinessScope" text="业务范围" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="bussinessScope"  />
			</div>
			<!-- 业务范围描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="业务范围" />
			</div>
		</div>		
		<div class="form-group row">
			<!-- 企业性质代码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmOrgParameter.enterpriseNatureCode" text="企业性质代码" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="enterpriseNatureCode"  />
			</div>
			<!--企业性质代码描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="企业性质代码" />
			</div>
		</div>	
		
		<div class="form-group row">
			<!-- 业务许可有效起期  -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmOrgParameter.businessLicensStartDate" text="业务许可有效起期 " />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<fmt:formatDate var="businessLicensStartDateFmt" value="${pcmOrgParameter.businessLicensStartDate}" type="date" pattern="yyyy-MM-dd"/>
    			<form:input class='form-control customize-datetime' value="${businessLicensStartDateFmt }" type="text" data-picker-position="top-right" data-role-formate="yyyy-mm-dd" path="businessLicensStartDate" onfocus="this.blur()"  data-rule-required="true" />
				<i class="fa fa-calendar input_date" ></i>
			</div>
			<!-- 业务许可有效起期 描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="业务许可有效起期 " />
			</div>
		</div>	
		<div class="form-group row">
			<!-- 业务许可有效止期   -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmOrgParameter.businessLicensEndDate" text="业务许可有效止期  " />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<fmt:formatDate var="businessLicensEndDateFmt" value="${pcmOrgParameter.businessLicensEndDate}" type="date" pattern="yyyy-MM-dd"/>
   				<form:input class='form-control customize-datetime' value="${businessLicensEndDateFmt }" type="text" data-picker-position="top-right" data-role-formate="yyyy-mm-dd" path="businessLicensEndDate" onfocus="this.blur()"  data-rule-required="true" />
				<i class="fa fa-calendar input_date" ></i>
			</div>
			<!-- 业务许可有效止期 描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="业务许可有效止期  " />
			</div>
		</div>		
		
		<div class="form-group row">
			<!-- 注册资本-->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmOrgParameter.registeredCapital" text="注册资本" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="registeredCapital"  />
			</div>
			<!-- 注册资本描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="注册资本" />
			</div>
		</div>		
		<div class="form-group row">
			<!-- 注册资本货币代码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmOrgParameter.regCapitalCurrencyCod" text="注册资本货币代码" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="regCapitalCurrencyCod"  />
			</div>
			<!-- 注册资本货币代码描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="注册资本货币代码" />
			</div>
		</div>	
		
		<div class="form-group row">
			<!-- 统一社会信用代码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmOrgParameter.unifiedSocialCreditCode" text="统一社会信用代码" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="unifiedSocialCreditCode"  />
			</div>
			<!-- 统一社会信用代码描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="统一社会信用代码" />
			</div>
		</div>		
		<div class="form-group row">
			<!-- 组织机构代码  -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmOrgParameter.organizationCode" text="组织机构代码 " />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="organizationCode"  />
			</div>
			<!-- 组织机构代码 描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="组织机构代码 " />
			</div>
		</div>	
		
		<div class="form-group row">
			<!--税务登记号码  -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmOrgParameter.taxRegNum" text="税务登记号码 " />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="taxRegNum"  />
			</div>
			<!-- 税务登记号码 描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="税务登记号码 " />
			</div>
		</div>		
		<div class="form-group row">
			<!-- 营业执照号码  -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmOrgParameter.businessNo" text="营业执照号码 " />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="businessNo"  />
			</div>
			<!-- 营业执照号码 描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="营业执照号码 " />
			</div>
		</div>	
		
		<div class="form-group row">
			<!-- 监管辖区代码  -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmOrgParameter.supervisoryJurisdictionCod" text="监管辖区代码 " />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="supervisoryJurisdictionCod"  />
			</div>
			<!-- 监管辖区代码 描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="监管辖区代码 " />
			</div>
		</div>		
		<div class="form-group row">
			<!-- 注册地  -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmOrgParameter.registration" text="注册地 " />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="registration"  />
			</div>
			<!--注册地 描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="注册地 " />
			</div>
		</div>	
		
		<div class="form-group row">
			<!-- 经营场所  -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmOrgParameter.busPlace" text="经营场所 " />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="busPlace"  />
			</div>
			<!-- 经营场所 描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="经营场所 " />
			</div>
		</div>		
		<div class="form-group row">
			<!-- 经营场所邮编  -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmOrgParameter.busPlaceZipCode" text="经营场所邮编 " />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="busPlaceZipCode"  />
			</div>
			<!-- 经营场所邮编 描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="经营场所邮编 " />
			</div>
		</div>	
		
		<div class="form-group row">
			<!-- 传真 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmOrgParameter.fax" text="传真" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="fax"  />
			</div>
			<!-- 传真描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="传真" />
			</div>
		</div>		
		<div class="form-group row">
			<!-- 营业执照有效起期 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmOrgParameter.busCertificateStartDate" text="营业执照有效起期" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<fmt:formatDate var="busCertificateStartDateFmt" value="${pcmOrgParameter.busCertificateStartDate}" type="date" pattern="yyyy-MM-dd"/>
				<form:input class='form-control customize-datetime' value="${busCertificateStartDateFmt }" type="text" data-picker-position="top-right" data-role-formate="yyyy-mm-dd" path="busCertificateStartDate" onfocus="this.blur()"  data-rule-required="true" />
				<i class="fa fa-calendar input_date" ></i>
			</div>
			<!-- 营业执照有效起期描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="营业执照有效起期" />
			</div>
		</div>	
		<div class="form-group row">
			<!-- 营业执照有效止期  -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmOrgParameter.busCertificateEndDate" text="营业执照有效止期 " />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<fmt:formatDate var="busCertificateEndDateFmt" value="${pcmOrgParameter.busCertificateEndDate}" type="date" pattern="yyyy-MM-dd"/>
    			<form:input class='form-control customize-datetime' value="${busCertificateEndDateFmt }" type="text" data-picker-position="top-right" data-role-formate="yyyy-mm-dd" path="busCertificateEndDate" onfocus="this.blur()"  data-rule-required="true" />
				<i class="fa fa-calendar input_date" ></i>
			</div>
			<!-- 营业执照有效止期 描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="营业执照有效止期 " />
			</div>
		</div>
		<div class="form-controls auto-float" >
			<div class="btn-group-md">
				<!-- 确定 -->
				<input type="submit" class="btn-primary btn" value="<spring:message code='kite.web.common.btnSure' text='确定' />" />
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='取消' />" />
			</div>
		</div>
	</form:form>
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp"%>
	<script type="text/javascript">
		//开启表单验证
		$("#pcmOrgParameterUpdForm").validate();
	</script>
</body>
</html>