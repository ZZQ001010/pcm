<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="countryCd.detail.title" text="国家代码管理明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
<style type="text/css">
label.detailStyle {
    font-weight: 700;
    margin-top: 10px;
    text-align: left;
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
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="countryCd">
		<div class="form-group row">
			<!-- 国家代码 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="countryCd.countryCd" text="国家代码" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 detailStyle">
				&nbsp;${countryCd.countryCd }	
			</label>
			<!-- 中文名 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="countryCd.description" text="中文名" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 detailStyle">
				&nbsp;${countryCd.description }	
			</label>
			<!-- 币种 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="countryCd.currencyCd" text="币种" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 detailStyle">
				&nbsp;${countryCd.currencyCd }_${countryCd.description }	
			</label>
			<!-- 代码缩写 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="countryCd.countryCdShort" text="代码缩写" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 detailStyle">
				&nbsp;${countryCd.countryCdShort }	
			</label>
		</div>
		<div class="form-controls auto-float">
			<div class="btn-group-sm">
			<k:access code="countryCd_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updateCountryCd" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updateCountryCd").click(function(){
						var params = [];
						params.push("countryCd=${countryCd.countryCd }");
						$K.frame.reloadSlideInner("${ctx}/countryCd/countryCdEditPage.in?" + params.join("&"));
					})
				</script>
			</k:access>
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
			</div>
		</div>
	</form:form>
	<%@ include file="/common/foot.jsp"%>
</body>
</html>