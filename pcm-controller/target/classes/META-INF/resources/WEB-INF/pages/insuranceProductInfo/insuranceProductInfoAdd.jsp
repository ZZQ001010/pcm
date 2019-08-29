<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="insuranceProductInfo.add.title" text="保险产品信息新增" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="insuranceProductInfoAddForm" cssStyle="padding-top: 40px" modelAttribute="insuranceProductInfo" method="post" action="${ctx}/insuranceProductInfo/addInsuranceProductInfo.in" data-confirm="true">
		<div class="form-group row">
			<!-- 保险产品编号 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="insuranceProductInfo.code" text="保险产品编号" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="code"  data-rule-required="true" data-rule-maxlength="12" />
			</div>
			<!-- 保险产品编号描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="insuranceProductInfo.code.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 保险产品名称 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="insuranceProductInfo.name" text="保险产品名称" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="name"  data-rule-required="true" data-rule-maxlength="50" />
			</div>
			<!-- 保险产品名称描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="insuranceProductInfo.name.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 险种 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="insuranceProductInfo.insuranceType" text="险种" />
				:
			</label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:input cssClass="form-control" type="text" path="insuranceType"  data-rule-required="true" data-rule-maxlength="50" />
            </div>
			<!-- 险种描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="insuranceProductInfo.insuranceType.desc" />
			</div>
		</div>
        <div class="form-group row">
            <!-- 单证代码（保单) -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
                <span class="span-icon">*&nbsp;</span>
                <spring:message code="insuranceProductInfo.insuranceCode" text="单证代码（保单)" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:input cssClass="form-control" type="text" path="insuranceCode"  data-rule-required="true" data-rule-maxlength="50" />
            </div>
            <!-- 单证代码（保单)描述 -->
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
                <spring:message code="insuranceProductInfo.insuranceCode.desc" />
            </div>
        </div>
		<div class="form-controls auto-float">
			<div class="btn-group-md">
				<!-- 确定 -->
				<input type="submit" class="btn-primary btn" value="<spring:message code='kite.web.common.btnSure' text='确定' />" />
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
			</div>
		</div>
	</form:form>
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp"%>
	<script type="text/javascript" src="${ctx }/static/js/cost_model_common.js"></script>
	<script type="text/javascript">
		//开启表单验证
		$("#insuranceProductInfoAddForm").validate();
	</script>
</body>
</html>