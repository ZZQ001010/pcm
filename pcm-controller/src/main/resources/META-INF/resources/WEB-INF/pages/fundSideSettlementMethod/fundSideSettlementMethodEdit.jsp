<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="fundSideSettlementMethod.update.title" text="资金方理赔方式
修改" /></title>
<%@ include file="/common/head.jsp"%>
</head>
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="fundSideSettlementMethodUpdForm" cssStyle="padding-top: 40px" modelAttribute="fundSideSettlementMethod" method="post" action="${ctx}/fundSideSettlementMethod/updFundSideSettlementMethod.in" data-confirm="true">
		<form:hidden path="fundSideCode" />
<%--<div class="form-group row">--%>
			<%--<!-- 资金方编码 -->--%>
			<%--<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">--%>
				<%--<span class="span-icon">*&nbsp;</span>--%>
				<%--<spring:message code="fundSideSettlementMethod.fundSideCode" text="资金方编码" />--%>
				<%--:--%>
			<%--</label>--%>
			<%--<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">--%>
				<%--<form:input cssClass="form-control" type="text" path="fundSideCode"   data-rule-required="true"  data-rule-maxlength="32" />--%>
			<%--</div>--%>
			<%--<!-- 资金方编码描述 -->--%>
			<%--<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">--%>
				<%--<spring:message code="fundSideSettlementMethod.fundSideCode.desc" />--%>
			<%--</div>--%>
		<%--</div>--%>
		<div class="form-group row">
			<!-- 资金方描述 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="fundSideSettlementMethod.fundSideDesc" text="资金方描述" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="fundSideDesc" data-rule-required="true" data-rule-maxlength="32" />
			</div>
			<!-- 资金方描述描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="fundSideSettlementMethod.fundSideDesc.desc" />
			</div>
		</div>
    <div class="form-group row">
        <!-- 资产方 -->
        <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
            <span class="span-icon">*&nbsp;</span>
            <spring:message code="fundSideSettlementMethod.fundSide" text="资金方 " />
            :
        </label>
        <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
            <form:select cssClass="form-control" path="fundSide" data-rule-required="true">
                <option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
                <form:options items="${fundSideInfoMap}" />
            </form:select>
        </div>
        <!-- 资产方描述 -->
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
            <spring:message code="fundSideSettlementMethod.fundSide.desc" />
        </div>
    </div>
		<div class="form-group row">
			<!-- 理赔方式 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="fundSideSettlementMethod.fundSideInfo" text="理赔模式" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="fundSideInfo" data-rule-required="true">
					<!-- <option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option> -->
					<form:options items="${fundSideInfo}" />
				</form:select>
			</div>
			<!-- 理赔方式描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="fundSideSettlementMethod.fundSideInfo.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 理赔逾期天数 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="fundSideSettlementMethod.daysOverdue" text="逾期理赔等待期天数" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="daysOverdue" 
				 data-rule-digits="true" data-rule-min="0" data-rule-required="true" data-rule-max="99999999999999999999999999999999" />
			</div>
			<!-- 理赔逾期天数描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="fundSideSettlementMethod.daysOverdue.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 全期理赔起始期数 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="fundSideSettlementMethod.otalNumberOfClaimsStartPeriods" text="全期理赔起始期数" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="otalNumberOfClaimsStartPeriods"  data-rule-digits="true" data-rule-min="0" data-rule-max="99999999999999999999999999999999" />
			</div>
			<!-- 全期理赔起始期数描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="fundSideSettlementMethod.otalNumberOfClaimsStartPeriods.desc" />
			</div>
		</div>
        <div class="form-group row">
            <!-- 理赔对账容差金额 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="fundSideSettlementMethod.claimsReconciliationAllowanceAmount" text="理赔对账容差金额" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:input cssClass="form-control" type="number" path="claimsReconciliationAllowanceAmount"  data-rule-min="0" data-rule-max="99999999999999999999999999999999" />
            </div>
            <!-- 理赔对账容差金额描述 -->
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
                <spring:message code="fundSideSettlementMethod.claimsReconciliationAllowanceAmount.desc" />
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
		$("#fundSideSettlementMethodUpdForm").validate();
	</script>
</body>
</html>