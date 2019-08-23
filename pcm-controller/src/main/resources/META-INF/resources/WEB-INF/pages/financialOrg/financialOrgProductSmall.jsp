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
	<form:form cssClass="form-horizontal form-product" modelAttribute="financialOrgParam">
		<div class="form-group row">
			<!-- 所属金融机构 -->
			<label class="ccol-lg-5 col-md-5 col-sm-5 col-xs-5  control-label">
				<spring:message code="financialOrgParam.financeOrgNo" text="所属金融机构" />
				:
			</label>
			<label class="col-lg-7 col-md-7 col-sm-7 col-xs-7 detailStyle"> &nbsp;${financialOrgParam.financialOrgNO} </label>
		</div>
		<div class="form-group row">
			<!-- 预理赔起始天数 -->
			<label class="ccol-lg-5 col-md-5 col-sm-5 col-xs-5  control-label">
				<spring:message code="financialOrgParam.preClaimStartDays" text="预理赔起始天数" />
				:
			</label>
			<label class="col-lg-7 col-md-7 col-sm-7 col-xs-7 detailStyle"> &nbsp;${financialOrgParam.preClaimStartDays } </label>
		</div>
		<div class="form-group row">
			<!-- 预理赔终止天数 -->
			<label class="ccol-lg-5 col-md-5 col-sm-5 col-xs-5  control-label">
				<spring:message code="financialOrgParam.preClaimEndDays" text="预理赔终止天数" />
				:
			</label>
			<label class="col-lg-7 col-md-7 col-sm-7 col-xs-7 detailStyle"> &nbsp;${financialOrgParam.preClaimEndDays } </label>
		</div>
		<div class="form-group row">
			<!-- 理赔天数 -->
			<label class="ccol-lg-5 col-md-5 col-sm-5 col-xs-5  control-label">
				<spring:message code="financialOrgParam.claimsDays" text="理赔天数" />
				:
			</label>
			<label class="col-lg-7 col-md-7 col-sm-7 col-xs-7 detailStyle"> &nbsp;${financialOrgParam.claimsDays } </label>
		</div>
	</form:form>
	<%@ include file="/common/foot.jsp"%>
	<script type="text/javascript">
		function getRowData(){
			return null;
		}
	</script>
</body>
</html>