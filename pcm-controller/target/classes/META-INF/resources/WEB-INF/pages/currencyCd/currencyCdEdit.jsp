<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="currencyCd.update.title" text="货币代码管理修改" /></title>
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
	<form:form cssClass="form-horizontal" id="currencyCdUpdForm" cssStyle="padding-top: 40px" modelAttribute="currencyCd" method="post" action="${ctx}/currencyCd/updCurrencyCd.in" data-confirm="true">
		<div class="form-group row">
			<!-- 数字代码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-3 control-label">
				<spring:message code="currencyCd.currencyCd" text="数字代码" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="currencyCd"  data-rule-maxlength="3" readonly="true"/>
			</div>
			<!-- 数字代码描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-3 remark">
				<spring:message code="currencyCd.currencyCd.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 英文代码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-3 control-label">
				<spring:message code="currencyCd.alphaCd" text="英文代码" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="alphaCd"  data-rule-maxlength="3" />
			</div>
			<!-- 英文代码描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-3 remark">
				<spring:message code="currencyCd.alphaCd.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 兑换汇率 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-3 control-label">
				<spring:message code="currencyCd.conversionRt" text="兑换汇率" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="conversionRt"  data-rule-number="true" data-rule-min="0" data-rule-max="99999.9999" />
			</div>
			<!-- 兑换汇率描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-3 remark">
				<spring:message code="currencyCd.conversionRt.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 小数位数 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-3 control-label">
				<spring:message code="currencyCd.exponent" text="小数位数" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="exponent"  data-rule-maxlength="1" />
			</div>
			<!-- 小数位数描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-3 remark">
				<spring:message code="currencyCd.exponent.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 描述 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-3 control-label">
				<spring:message code="currencyCd.description" text="描述" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="description"  data-rule-maxlength="20" />
			</div>
			<!-- 描述描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-3 remark">
				<spring:message code="currencyCd.description.desc" />
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
		$("#currencyCdUpdForm").validate();
	</script>
</body>

</html>