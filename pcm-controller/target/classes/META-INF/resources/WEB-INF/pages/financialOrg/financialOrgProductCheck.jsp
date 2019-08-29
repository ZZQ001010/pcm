<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="financialOrgProduct.detail.title" text="合作机构管理明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="financialOrgParam">
		<div class="form-group row">
			<!-- 所属金融机构 -->
			<label class="col-lg-2 col-md-2 col-sm-12 col-xs-12 control-label">
				<spring:message code="financialOrgParam.financeOrgNo" text="所属金融机构" />
				:
			</label>
			<label class="col-lg-2 col-md-2 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${financeOrgNO}
			</label>
			<!-- 预理赔起始天数 -->
			<label class="col-lg-2 col-md-2 col-sm-12 col-xs-12 control-label">
				<spring:message code="financialOrgParam.preClaimStartDays" text="预理赔起始天数" />
				:
			</label>
			<label class="col-lg-2 col-md-2 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${financialOrgParam.preClaimStartDays }	
			</label>
			<!-- 预理赔终止天数 -->
			<label class="col-lg-2 col-md-2 col-sm-12 col-xs-12 control-label">
				<spring:message code="financialOrgParam.preClaimEndDays" text="预理赔终止天数" />
				:
			</label>
			<label class="col-lg-2 col-md-2 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${financialOrgParam.preClaimEndDays }	
			</label>
			<!-- 理赔天数 -->
			<label class="col-lg-2 col-md-2 col-sm-12 col-xs-12 control-label">
				<spring:message code="financialOrgParam.claimsDays" text="理赔天数" />
				:
			</label>
			<label class="col-lg-2 col-md-2 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${financialOrgParam.claimsDays }	
			</label>
			<!-- 是否循环额度 -->
			<label class="col-lg-2 col-md-2 col-sm-12 col-xs-12 control-label">
				<spring:message code="financialOrgParam.circleAble" text="是否循环额度" />
				:
			</label>
			<label class="col-lg-2 col-md-2 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${circleAble}
			</label>
		</div>
	</form:form>
	<%@ include file="/common/foot.jsp"%>
</body>
</html>