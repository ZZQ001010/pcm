<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="premiumLatePaymentFee.update.title" text="保费滞纳金
修改" /></title>
<%@ include file="/common/head.jsp"%>
</head>
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="premiumLatePaymentFeeUpdForm" cssStyle="padding-top: 40px" modelAttribute="premiumLatePaymentFee" method="post" action="${ctx}/premiumLatePaymentFee/updPremiumLatePaymentFee.in" data-confirm="true">
		<form:hidden path="code" />
		<div class="form-group row">
			<!-- 描述 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="premiumLatePaymentFee.desc" text="描述" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="desc"  data-rule-required="true" data-rule-maxlength="50" />
			</div>
			<!-- 描述描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="premiumLatePaymentFee.desc.desc" />
			</div>
		</div>				

		<div class="form-group row">
			<!-- 费用收取方式 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="premiumLatePaymentFee.feeCollectionMethod" text="费用收取方式" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="feeCollectionMethod"  data-rule-required="true">
					<form:options items="${feeCollectionMethod}" />
				</form:select>
			</div>
			<!-- 费用收取方式描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="premiumLatePaymentFee.feeCollectionMethod.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 费用收取基础 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="premiumLatePaymentFee.feeBasis" text="费用收取基础" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="feeBasis">
					<form:options items="${feeBasis}" />
				</form:select>
			</div>
			<!-- 费用收取基础描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="premiumLatePaymentFee.feeBasis.desc" />
			</div>
		</div>
        <div class="form-group row">
            <!-- 费用收取频次 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="premiumLatePaymentFee.frequencyOfCharge" text="费用收取频次" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:select cssClass="form-control" path="frequencyOfCharge">
                    <form:options items="${frequencyOfCharge}" />
                </form:select>
            </div>
            <!-- 费用收取频次描述 -->
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
                <spring:message code="premiumLatePaymentFee.frequencyOfCharge.desc" />
            </div>
        </div>
        <div class="form-group row">
			<!-- 收取比例 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="premiumLatePaymentFee.chargeRatio" text="收取比例" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="chargeRatio"  data-rule-required="false" data-rule-digits="true" data-rule-min="0" data-rule-max="999999999999" />
			</div>
			<!-- 收取比例描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="premiumLatePaymentFee.chargeRatio.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 收取金额 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="premiumLatePaymentFee.chargeAmount" text="收取金额" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="chargeAmount"  data-rule-required="false" data-rule-digits="true" data-rule-min="0" data-rule-max="999999999999" />
			</div>
			<!-- 收取金额描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="premiumLatePaymentFee.chargeAmount.desc" />
			</div>
		</div>
		<div class="form-group row">
            <!-- 滞纳金宽限期 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="premiumLatePaymentFee.kuanxianqi" text="滞纳金宽限期" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
                <form:input class='form-control customize-datetime' type="text" data-picker-position="top-right" data-role-formate="yyyy-mm-dd" path="kuanxianqi" onfocus="this.blur()"   />
                <i class="fa fa-calendar input_date" ></i>
            </div>
            <!-- 滞纳金宽限期描述 -->
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
                <spring:message code="premiumLatePaymentFee.kuanxianqi.desc" />
            </div>
        </div>				
		<div class="form-controls auto-float">
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
	<script type="text/javascript" src="${ctx }/static/js/cost_model_common.js"></script>
	<script type="text/javascript">
		//开启表单验证
		$("#premiumLatePaymentFeeUpdForm").validate();
	</script>
</body>
</html>