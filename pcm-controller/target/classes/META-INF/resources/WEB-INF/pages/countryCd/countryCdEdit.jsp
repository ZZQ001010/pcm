<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="countryCd.update.title" text="国家代码管理修改" /></title>
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
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="countryCdUpdForm" cssStyle="padding-top: 40px" modelAttribute="countryCd" method="post" action="${ctx}/countryCd/updCountryCd.in" data-confirm="true">
		<div class="form-group row">
			<!-- 国家代码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label">
				<spring:message code="countryCd.countryCd" text="国家代码" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
				<form:input cssClass="form-control" type="text" path="countryCd"  data-rule-maxlength="3" readonly="true"/>
			</div>
			<!-- 国家代码描述 -->
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
				<spring:message code="countryCd.countryCd.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 中文名 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label">
				<spring:message code="countryCd.description" text="中文名" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
				<form:input cssClass="form-control" type="text" path="description"  data-rule-maxlength="40" />
			</div>
			<!-- 中文名描述 -->
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
				<spring:message code="countryCd.description.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 币种 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label">
				<spring:message code="countryCd.currencyCd" text="币种" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
				<form:input cssClass="form-control" type="text" path="currencyCd"  data-rule-maxlength="12" />
			</div>
			<!-- 币种描述 -->
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
				<spring:message code="countryCd.currencyCd.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 代码缩写 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label">
				<spring:message code="countryCd.countryCdShort" text="代码缩写" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
				<form:input cssClass="form-control" type="text" path="countryCdShort"  data-rule-maxlength="2" />
			</div>
			<!-- 代码缩写描述 -->
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
				<spring:message code="countryCd.countryCdShort.desc" />
			</div>
		</div>				
		<div class="form-controls">
			<div class="btn-group-md auto-float">
				<!-- 确定 -->
				<input type="submit" class="btn-primary btn" value="<spring:message code='kite.web.common.btnSure' text='确定' />" />
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='取消' />" />
			</div>
		</div>
	</form:form>
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp"%>
	<script>
		//开启表单验证
		$("#countryCdUpdForm").validate();
	</script>
</body>

</html>