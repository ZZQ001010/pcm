<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="prmControl.update.title" text="参数管控修改" /></title>
<%@ include file="/common/head.jsp"%>
<style type="text/css">
label.detailStyle {
    font-weight: 700;
    margin-top: 10px;
    text-align: left;
}
@media (max-width: 750px) {
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
	<form:form cssClass="form-horizontal" id="tmPrmControlUpdForm" cssStyle="padding-top: 40px" modelAttribute="tmPrmControl" method="post" action="${ctx}/prmControl/updPrmControl.in" data-confirm="true">
		<form:hidden path="id" />
		<div class="form-group row">
			<!-- 受控参数 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="tmPrmControl.paramClass" text="受控参数" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="paramClass"  data-rule-required="true" data-rule-maxlength="200" />
			</div>
			<!-- 受控参数描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="tmPrmControl.paramClass.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 参数名称 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="tmPrmControl.paramClassLabel" text="参数名称" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="paramClassLabel"  data-rule-required="true" data-rule-maxlength="100" />
			</div>
			<!-- 参数名称描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="tmPrmControl.paramClassLabel.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 参数属性 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="tmPrmControl.paramField" text="参数属性" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="paramField"  data-rule-required="true" data-rule-maxlength="50" />
			</div>
			<!-- 参数属性描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="tmPrmControl.paramField.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 属性名称 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="tmPrmControl.paramFieldLabel" text="属性名称" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="paramFieldLabel"  data-rule-required="true" data-rule-maxlength="100" />
			</div>
			<!-- 属性名称描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="tmPrmControl.paramFieldLabel.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 最小值 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="tmPrmControl.minValue" text="最小值" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="minValue"  data-rule-required="true" data-rule-maxlength="20" />
			</div>
			<!-- 最小值描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="tmPrmControl.minValue.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 最大值 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="tmPrmControl.maxValue" text="最大值" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="maxValue"  data-rule-required="true" data-rule-maxlength="20" />
			</div>
			<!-- 最大值描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="tmPrmControl.maxValue.desc" />
			</div>
		</div>				
		<div class="form-controls">
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
	<script>
		//开启表单验证
		$("#tmPrmControlUpdForm").validate();
	</script>
</body>

</html>