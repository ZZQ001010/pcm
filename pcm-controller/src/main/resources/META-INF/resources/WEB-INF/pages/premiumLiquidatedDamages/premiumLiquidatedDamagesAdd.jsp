<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="premiumLiquidatedDamages.add.title" text="提前还款保费收取方式新增" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="premiumLiquidatedDamagesAddForm" cssStyle="padding-top: 40px" modelAttribute="premiumLiquidatedDamages" method="post" action="${ctx}/premiumLiquidatedDamages/addPremiumLiquidatedDamages.in" data-confirm="true">
		<div class="form-group row">
			<!-- 费用编码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="premiumLiquidatedDamages.code" text="费用编码" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="code"  data-rule-required="true" data-rule-maxlength="12" />
			</div>
			<!-- 费用编码描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="premiumLiquidatedDamages.code.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 费用描述 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="premiumLiquidatedDamages.desc" text="费用描述" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="desc"  data-rule-required="true" data-rule-maxlength="50" />
			</div>
			<!-- 费用描述描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="premiumLiquidatedDamages.desc.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 费用收取方式 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <span class="span-icon">*&nbsp;</span>
                <spring:message code="premiumLiquidatedDamages.costCalculationMethod" text="费用收取方式" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="costCalculationMethod" data-rule-required="true">
					<form:options items="${costCalculationMethod}" />
				</form:select>
			</div>
			<!-- 费用收取方式描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="premiumLiquidatedDamages.costCalculationMethod.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 当期保费是否收取 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="premiumLiquidatedDamages.whetherToCharge" text="当期保费是否收取" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="whetherToCharge">
					<form:options items="${whetherToCharge}" />
				</form:select>
			</div>
			<!-- 当期保费是否收取描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="premiumLiquidatedDamages.whetherToCharge.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 手续费率 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="premiumLiquidatedDamages.percentageRemainingPrincipal" text="手续费率" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="percentageRemainingPrincipal"  data-rule-required="false" data-rule-digits="true" data-rule-min="0" data-rule-max="999999999999" />
			</div>
			<!-- 手续费率描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="premiumLiquidatedDamages.percentageRemainingPrincipal.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 加收N期保费 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="premiumLiquidatedDamages.additionalNPremiums" text="加收N期保费" />
				:
			</label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:select cssClass="form-control" path="additionalNPremiums">
                    <form:options items="${additionalNPremiums}" />
                </form:select>
            </div>
			<!-- 加收N期保费描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="premiumLiquidatedDamages.additionalNPremiums.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 收取固定金额 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="premiumLiquidatedDamages.chargeFixedAmount" text="收取固定金额" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="chargeFixedAmount"  data-rule-required="false" data-rule-digits="true" data-rule-min="0" data-rule-max="999999999999" />
			</div>
			<!-- 收取固定金额描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="premiumLiquidatedDamages.chargeFixedAmount.desc" />
			</div>
		</div>
        <div class="form-group row">
            <!-- 收取起始账期 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="premiumLiquidatedDamages.startDate" text="收取起始账期" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
                <form:input class='form-control customize-datetime' type="text" data-picker-position="top-right" data-role-formate="yyyy-mm-dd" path="startDate" onfocus="this.blur()"   />
                <i class="fa fa-calendar input_date" ></i>
            </div>
            <!-- 收取起始账期额描述 -->
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
                <spring:message code="premiumLiquidatedDamages.startDate.desc" />
            </div>
        </div>
        <div class="form-group row">
            <!-- 余额额度有效期 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="premiumLiquidatedDamages.endDate" text="收取终止账期" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:input class='form-control customize-datetime' type="text"
                            data-picker-position="top-right" data-role-formate="yyyy-mm-dd"
                            path="endDate" onfocus="this.blur()"   />
                <i class="fa fa-calendar input_date" ></i>
            </div>
            <!-- 余额额度有效期描述 -->
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
                <spring:message code="premiumLiquidatedDamages.endDate.desc" />
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
	<script type="text/javascript">
		//开启表单验证
		$("#premiumLiquidatedDamagesAddForm").validate();
	</script>
</body>
</html>