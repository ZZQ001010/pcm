<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="pcmOrgParameter.detail.title" text="机构参数明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="pcmOrgParameter">
		<div class="form-group row">
			<!-- 机构编码 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="pcmOrgParameter.orgCode" text="机构编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${pcmOrgParameter.orgCode }	
			</label>
			<!-- 机构名称 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="pcmOrgParameter.orgName" text="机构名称" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${pcmOrgParameter.orgName }	
			</label>
			<!-- 机构地址 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="pcmOrgParameter.orgAddress" text="机构地址" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${pcmOrgParameter.orgAddress }	
			</label>
			<!-- 机构级别 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="pcmOrgParameter.orgLevel" text="机构级别" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${pcmOrgParameter.orgLevel }	
			</label>
			<!-- 上级机构编码 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="pcmOrgParameter.parentOrgCode" text="上级机构编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${pcmOrgParameter.parentOrgCode }	
			</label>
			<!-- 机构联系电话 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="pcmOrgParameter.orgContactPhone" text="联系电话" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${pcmOrgParameter.orgContactPhone }	
			</label>
			<!-- 机构联系人 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="pcmOrgParameter.orgContactPerson" text="机构联系人" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${pcmOrgParameter.orgContactPerson }	
			</label>
			<!-- 业务范围-->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="pcmOrgParameter.bussinessScope" text="业务范围" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${pcmOrgParameter.bussinessScope }	
			</label>
			<!-- 企业性质代码 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="pcmOrgParameter.enterpriseNatureCode" text="企业性质代码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${pcmOrgParameter.enterpriseNatureCode }	
			</label>
			<!-- 业务许可有效起期 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="pcmOrgParameter.businessLicensStartDate" text="业务许可有效起期 " />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				<fmt:formatDate var="businessLicensStartDateFmt" value="${pcmOrgParameter.businessLicensStartDate}" type="date" pattern="yyyy-MM-dd"/>
				&nbsp;${businessLicensStartDateFmt }	
			</label>
			<!-- 业务许可有效止期  -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="pcmOrgParameter.businessLicensEndDate" text="业务许可有效止期 " />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				<fmt:formatDate var="businessLicensEndDateFmt" value="${pcmOrgParameter.businessLicensEndDate}" type="date" pattern="yyyy-MM-dd"/>
				&nbsp;${businessLicensEndDateFmt  }	
			</label>
			<!-- 注册资本 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="pcmOrgParameter.registeredCapital" text="注册资本" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${pcmOrgParameter.registeredCapital }	
			</label>
			<!-- 注册资本货币代码 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="pcmOrgParameter.regCapitalCurrencyCod" text="注册资本货币代码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${pcmOrgParameter.regCapitalCurrencyCod }	
			</label>
			<!-- 统一社会信用代码 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="pcmOrgParameter.unifiedSocialCreditCode" text="统一社会信用代码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${pcmOrgParameter.unifiedSocialCreditCode }	
			</label>
			<!-- 组织机构代码  -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="pcmOrgParameter.organizationCode" text="组织机构代码 " />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${pcmOrgParameter.organizationCode }	
			</label>
			<!-- 税务登记号码  -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="pcmOrgParameter.taxRegNum" text="税务登记号码 " />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${pcmOrgParameter.taxRegNum }	
			</label>
			<!-- 营业执照号码 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="pcmOrgParameter.businessNo" text="营业执照号码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${pcmOrgParameter.businessNo }	
			</label>
			<!-- 监管辖区代码  -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="pcmOrgParameter.supervisoryJurisdictionCod" text="监管辖区代码 " />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${pcmOrgParameter.supervisoryJurisdictionCod }	
			</label>
			<!-- 注册地  -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="pcmOrgParameter.registration" text="注册地 " />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${pcmOrgParameter.registration }	
			</label>
			<!-- 经营场所 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="pcmOrgParameter.busPlace" text="经营场所 " />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${pcmOrgParameter.busPlace }	
			</label>
			<!-- 经营场所邮编 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="pcmOrgParameter.busPlaceZipCode" text="经营场所邮编" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${pcmOrgParameter.busPlaceZipCode }	
			</label>
			<!--传真 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="pcmOrgParameter.fax" text="传真" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${pcmOrgParameter.fax }	
			</label>
			<!-- 营业执照有效起期  -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="pcmOrgParameter.busCertificateStartDate" text="营业执照有效起期 " />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				<fmt:formatDate var="busCertificateStartDateFmt" value="${pcmOrgParameter.busCertificateStartDate}" type="date" pattern="yyyy-MM-dd"/>
				&nbsp;${busCertificateStartDateFmt }	
			</label>
			<!-- 营业执照有效止期  -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="pcmOrgParameter.busCertificateEndDate" text="营业执照有效止期 " />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				<fmt:formatDate var="busCertificateEndDateFmt" value="${pcmOrgParameter.busCertificateEndDate}" type="date" pattern="yyyy-MM-dd"/>
				&nbsp;${busCertificateEndDateFmt }	
			</label>
			
		</div>
		<c:if test="${factroy }">
		<div class="form-controls">
			<div class="btn-group-sm" auto-float>
			<k:access code="pcmOrgParameter_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updatePcmOrgParameter" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updatePcmOrgParameter").click(function(){
						var params = [];
						params.push("orgCode=${pcmOrgParameter.orgCode }");
						$K.frame.reloadSlideInner("${ctx}/pcmOrgParameter/pcmOrgParameterEditPage.in?" + params.join("&"));
					})
				</script>
			</k:access>
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
			</div>
		</div>
		</c:if>
	</form:form>
	<%@ include file="/common/foot.jsp"%>
</body>
</html>