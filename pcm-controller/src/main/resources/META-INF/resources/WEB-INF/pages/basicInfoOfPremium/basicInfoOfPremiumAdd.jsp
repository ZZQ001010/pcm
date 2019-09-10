<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="basicInfoOfPremium.add.title" text="保费基本信息新增" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="basicInfoOfPremiumAddForm" cssStyle="padding-top: 40px" modelAttribute="basicInfoOfPremium" method="post" action="${ctx}/basicInfoOfPremium/addBasicInfoOfPremium.in" data-confirm="true">
		<div class="form-group row">
			<!-- 编码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="basicInfoOfPremium.code" text="保费编码" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="code"  data-rule-required="true" data-rule-maxlength="12" />
			</div>
			<!-- 编码描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="basicInfoOfPremium.code.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 描述 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="basicInfoOfPremium.desc" text="保费描述" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="desc"  data-rule-required="true" data-rule-maxlength="50" />
			</div>
			<!-- 描述描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="basicInfoOfPremium.desc.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 费用收取方式 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="basicInfoOfPremium.feeCollectionMethod" text="费用收取方式" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="feeCollectionMethod" data-rule-required="true">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${feeCollectionMethod}" />
				</form:select>
			</div>
			<!-- 费用收取方式描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="basicInfoOfPremium.feeCollectionMethod.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 保费缴纳频率 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="basicInfoOfPremium.frequencyOfCharge" text="保费缴纳频率" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="frequencyOfCharge">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${frequencyOfCharge}" />
				</form:select>
			</div>
			<!-- 保费缴纳频率描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="basicInfoOfPremium.frequencyOfCharge.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 保费率 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="basicInfoOfPremium.principalCollectionRatio" text="保费率" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="principalCollectionRatio"  data-rule-required="false" data-rule-digits="true" data-rule-min="0" data-rule-max="999999999999" />
			</div>
			<!-- 保费率描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="basicInfoOfPremium.principalCollectionRatio.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 保费缴纳方式 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="basicInfoOfPremium.feePayMethod" text="保费缴纳方式" />
				:
			</label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:select cssClass="form-control" path="feePayMethod" data-rule-required="false">
                    <option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
                    <form:options items="${feePayMethod}" />
                </form:select>
            </div>
            <!-- 保费缴纳方式 -->
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
                <spring:message code="basicInfoOfPremium.feePayMethod.desc" />
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
		$("#basicInfoOfPremiumAddForm").validate();
	</script>
</body>
</html>