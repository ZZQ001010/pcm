<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="organization.add.title" text="机构参数管理新增" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="organizationAddForm" cssStyle="padding-top: 40px" modelAttribute="organization" method="post" action="${ctx}/organization/addOrganization.in" data-confirm="true">
		<div class="form-group row">
			<!-- 支付渠道 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="organization.paymentChannel" text="支付渠道" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="paymentChannel"  data-rule-maxlength="20" />
			</div>
			<!-- 支付渠道描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="organization.paymentChannel.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 征信金融机构 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="organization.creditInstitutions" text="征信金融机构" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="creditInstitutions"  data-rule-maxlength="20" />
			</div>
			<!-- 征信金融机构描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="organization.creditInstitutions.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 人行征信报送类型 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="organization.pbocType" text="人行征信报送类型" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="pbocType"  data-rule-maxlength="1" />
			</div>
			<!-- 人行征信报送类型描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="organization.pbocType.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 默认分行号 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="organization.defaultBranchNo" text="默认分行号" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="defaultBranchNo"  data-rule-maxlength="16" />
			</div>
			<!-- 默认分行号描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="organization.defaultBranchNo.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 发送短信机构号 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="organization.smsToOrg" text="发送短信机构号" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="smsToOrg"  data-rule-maxlength="10" />
			</div>
			<!-- 发送短信机构号描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="organization.smsToOrg.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 实时入账标志 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="organization.bookingOnlineFlag" text="放款实时入账标志" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="bookingOnlineFlag"  data-rule-maxlength="1" />
			</div>
			<!-- 实时入账标志描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="organization.bookingOnlineFlag.desc" />
			</div>
		</div>
        <div class="form-group row">
            <!-- 实时入账标志 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
                <spring:message code="organization.repayBookingOnlineFlag" text="还款实时入账标志" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:input cssClass="form-control" type="text" path="repayBookingOnlineFlag"  data-rule-maxlength="1" />
            </div>
            <!-- 实时入账标志描述 -->
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
                <spring:message code="organization.repayBookingOnlineFlag.desc" />
            </div>
        </div>
		<div class="form-group row">
			<!-- 基准货币代码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="organization.baseCurrCd" text="基准货币代码" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="baseCurrCd"  data-rule-maxlength="3" />
			</div>
			<!-- 基准货币代码描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="organization.baseCurrCd.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 最大授信额度 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="organization.maxCreditLimit" text="最大授信额度" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="maxCreditLimit"  data-rule-maxlength="15" />
			</div>
			<!-- 最大授信额度描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="organization.maxCreditLimit.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 超限免息标识 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="organization.overlimitDeferInd" text="超限免息标识" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="overlimitDeferInd"  data-rule-maxlength="1" />
			</div>
			<!-- 超限免息标识描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="organization.overlimitDeferInd.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 未全额还款免息标识 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="organization.nofullpayDeferInd" text="未全额还款免息标识" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="nofullpayDeferInd"  data-rule-maxlength="1" />
			</div>
			<!-- 未全额还款免息标识描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="organization.nofullpayDeferInd.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 溢缴款信用计划号 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="organization.depositPlanNbr" text="溢缴款信用计划号" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="depositPlanNbr"  data-rule-maxlength="6" />
			</div>
			<!-- 溢缴款信用计划号描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="organization.depositPlanNbr.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 临额最大有效月数 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="organization.tempLimitMaxMths" text="临额最大有效月数" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="tempLimitMaxMths"  data-rule-maxlength="1" />
			</div>
			<!-- 临额最大有效月数描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="organization.tempLimitMaxMths.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 利息按信用计划入账 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="organization.intPostOnPlan" text="利息按信用计划入账" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="intPostOnPlan"  data-rule-maxlength="1" />
			</div>
			<!-- 利息按信用计划入账描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="organization.intPostOnPlan.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 还款日调整区间内可调整次数 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="organization.adjStmtCount" text="还款日调整区间内可调整次数" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="adjStmtCount"  data-rule-maxlength="1" />
			</div>
			<!-- 还款日调整区间内可调整次数描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="organization.adjStmtCount.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 还款日调整区间（月） -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="organization.adjStmtMonth" text="还款日调整区间（月）" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="adjStmtMonth"  data-rule-maxlength="1" />
			</div>
			<!-- 还款日调整区间（月）描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="organization.adjStmtMonth.desc" />
			</div>
		</div>
		<div class="form-controls">
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
		$("#organizationAddForm").validate();
	</script>
</body>
</html>