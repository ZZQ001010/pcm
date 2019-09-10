<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="premiumLiquidatedDamages.update.title" text="提前还款保费收取方式修改" /></title>
<%@ include file="/common/head.jsp"%>
</head>
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="premiumLiquidatedDamagesUpdForm" cssStyle="padding-top: 40px" modelAttribute="premiumLiquidatedDamages" method="post" action="${ctx}/premiumLiquidatedDamages/updPremiumLiquidatedDamages.in" data-confirm="true">
		<form:hidden path="code" />
		<div class="form-group row">
			<!-- 描述 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="premiumLiquidatedDamages.desc" text="费用描述" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="desc"  data-rule-required="true" data-rule-maxlength="50" />
			</div>
			<!-- 描述描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="premiumLiquidatedDamages.desc.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 费用计算方式 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="premiumLiquidatedDamages.costCalculationMethod" text="费用收取方式" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="costCalculationMethod">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${costCalculationMethod}" />
				</form:select>
			</div>
			<!-- 费用计算方式描述 -->
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
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${whetherToCharge}" />
				</form:select>
			</div>
			<!-- 当期保费是否收取描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="premiumLiquidatedDamages.whetherToCharge.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 剩余本金百分比 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="premiumLiquidatedDamages.percentageRemainingPrincipal" text="手续费率" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="percentageRemainingPrincipal"   data-rule-digits="true" data-rule-min="0" data-rule-max="999999999999" />
			</div>
			<!-- 剩余本金百分比描述 -->
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
                    <option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
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
				<form:input cssClass="form-control" type="text" path="chargeFixedAmount"   data-rule-digits="true" data-rule-min="0" data-rule-max="999999999999" />
			</div>
			<!-- 收取固定金额描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="premiumLiquidatedDamages.chargeFixedAmount.desc" />
			</div>
		</div>
		
       <%--  <div class="form-group row">
            <!-- 收取固定金额 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="premiumLiquidatedDamages.startDate" text="收取起始账期" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <fmt:formatDate var="startDateFmt" value="${premiumLiquidatedDamages.startDate}" type="date" pattern="yyyy-MM-dd"/>
                <form:input class='form-control customize-datetime' value="${startDateFmt}" type="text" data-picker-position="top-right" data-role-formate="yyyy-mm-dd" path="startDate" onfocus="this.blur()"   />
                <i class="fa fa-calendar input_date" ></i>
            </div>
          </div> --%>
            
        <div class="form-group row">
			<!-- 收取起始账期 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="premiumLiquidatedDamages.startDate" text="收取起始账期" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <fmt:formatDate var="startDate" value="${premiumLiquidatedDamages.startDate}" type="date" pattern="yyyy-MM-dd"/>
                <form:input class='form-control customize-datetime' type="text" value="${startDate}"
                            data-picker-position="top-right" data-role-formate="yyyy-mm-dd"
				 path="startDate" onfocus="this.blur()"   />
				<i class="fa fa-calendar input_date" ></i>
			</div>
			<!-- 收取起始账期描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="premiumLiquidatedDamages.startDate.desc" />
			</div>
		</div>
        
        <div class="form-group row">
            <!-- 收取终止账期 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="premiumLiquidatedDamages.endDate" text="收取终止账期" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <fmt:formatDate var="endDateFmt" value="${premiumLiquidatedDamages.endDate}" type="date" pattern="yyyy-MM-dd"/>
                <form:input class='form-control customize-datetime' type="text" value="${endDateFmt}" data-picker-position="top-right" data-role-formate="yyyy-mm-dd" path="endDate" onfocus="this.blur()"   />
                <i class="fa fa-calendar input_date" ></i>
            </div>
            <!-- 收取终止账期描述 -->
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
                <spring:message code="premiumLiquidatedDamages.endDate.desc" />
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
	<script type="text/javascript">
		//开启表单验证
		$("#premiumLiquidatedDamagesUpdForm").validate();
	</script>
</body>
</html>