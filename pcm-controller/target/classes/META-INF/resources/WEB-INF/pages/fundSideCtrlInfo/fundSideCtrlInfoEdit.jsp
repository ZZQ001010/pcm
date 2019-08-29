<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="fundSideCtrlInfo.update.title" text="资金方管控信息
修改" /></title>
<%@ include file="/common/head.jsp"%>
</head>
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="fundSideCtrlInfoUpdForm" cssStyle="padding-top: 40px" modelAttribute="fundSideCtrlInfo" method="post" action="${ctx}/fundSideCtrlInfo/updFundSideCtrlInfo.in" data-confirm="true">
		<form:hidden path="fundSideCtrlCode" />
		<div class="form-group row">
			<!-- 资金方管控描述 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="fundSideCtrlInfo.fundSideCtrlDesc" text="资金方管控描述" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="fundSideCtrlDesc"  data-rule-required="true" data-rule-maxlength="12" />
			</div>
			<!-- 资金方管控描述描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="fundSideCtrlInfo.fundSideCtrlDesc.desc" />
			</div>
		</div>
        <div class="form-group row">
            <!-- 资产方 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <span class="span-icon">*&nbsp;</span>
                <spring:message code="fundSideCtrlInfo.fundSide" text="资金方编码" />
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
                <spring:message code="fundSideCtrlInfo.fundSide.desc" />
            </div>
        </div>
        <div class="form-group row">
            <!-- 资金方授信管控 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="fundSideCtrlInfo.fundSideCreditLimit" text="资金方授信管控" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:select cssClass="form-control" path="fundSideCreditLimit" >
                    <option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
                    <form:options items="${fundSideCreditLimit}" />
                </form:select>
            </div>
            <!-- 资产方描述 -->
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
                <spring:message code="fundSideCtrlInfo.fundSideCreditLimit.desc" />
            </div>
        </div>
		<div class="form-group row">
			<!-- 资金方总授信额度 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="fundSideCtrlInfo.fundSideTotalTrustworthinessLimit" text="资金方授信额度总控" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="number" path="fundSideTotalTrustworthinessLimit"   data-rule-maxlength="12" />
			</div>
			<!-- 资金方总授信额度描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="fundSideCtrlInfo.fundSideTotalTrustworthinessLimit.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 授信额度有效期 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="fundSideCtrlInfo.authorizationAmountUsefulLife" text="授信额度有效期" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <fmt:formatDate var="authorizationAmountUsefulLifeFmt" value="${fundSideCtrlInfo.authorizationAmountUsefulLife}" type="date" pattern="yyyy-MM-dd"/>
                <form:input class='form-control customize-datetime' value="${authorizationAmountUsefulLifeFmt}" type="text" data-picker-position="top-right" data-role-formate="yyyy-mm-dd" path="authorizationAmountUsefulLife" onfocus="this.blur()"   />
				<i class="fa fa-calendar input_date" ></i>
			</div>
			<!-- 授信额度有效期描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="fundSideCtrlInfo.authorizationAmountUsefulLife.desc" />
			</div>
		</div>
        <div class="form-group row">
            <!-- 资金方授信管控 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="fundSideCtrlInfo.fundSideLoanLimit" text="资金方放款管控" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:select cssClass="form-control" path="fundSideLoanLimit" >
                    <option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
                    <form:options items="${fundSideLoanLimit}" />
                </form:select>
            </div>
            <!-- 资产方描述 -->
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
                <spring:message code="fundSideCtrlInfo.fundSideCreditLimit.desc" />
            </div>
        </div>
		<div class="form-group row">
			<!-- 资金方总放款额度 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="fundSideCtrlInfo.fundSideTotalLoanAmount" text="资金方放款额总控" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="number" path="fundSideTotalLoanAmount"  data-rule-maxlength="12" />
			</div>
			<!-- 资金方总放款额度描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="fundSideCtrlInfo.fundSideTotalLoanAmount.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 放款额度有效期 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="fundSideCtrlInfo.loanAmountUsefulLife" text="放款额度有效期" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <fmt:formatDate var="loanAmountUsefulLifeFmt" value="${fundSideCtrlInfo.loanAmountUsefulLife}" type="date" pattern="yyyy-MM-dd"/>
			<form:input class='form-control customize-datetime' type="text"
			 data-picker-position="top-right" data-role-formate="yyyy-mm-dd"  value="${loanAmountUsefulLifeFmt}"
				 path="loanAmountUsefulLife" onfocus="this.blur()"   />
				<i class="fa fa-calendar input_date" ></i>
			</div>
			<!-- 放款额度有效期描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="fundSideCtrlInfo.loanAmountUsefulLife.desc" />
			</div>
		</div>
        <div class="form-group row">
            <!-- 资金方总放款额度 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="fundSideCtrlInfo.fundSideTotalLoanAmountM" text="资金方月放款额管控" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:input cssClass="form-control" type="number" path="fundSideTotalLoanAmountM"  data-rule-maxlength="12" />
            </div>
            <!-- 资金方总放款额度描述 -->
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
                <spring:message code="fundSideCtrlInfo.fundSideTotalLoanAmountM.desc" />
            </div>
        </div>
        <div class="form-group row">
            <!-- 资金方总放款额度 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="fundSideCtrlInfo.fundSideTotalLoanAmountW" text="资金方周放款额管控" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:input cssClass="form-control" type="number" path="fundSideTotalLoanAmountW"   data-rule-maxlength="12" />
            </div>
            <!-- 资金方总放款额度描述 -->
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
                <spring:message code="fundSideCtrlInfo.fundSideTotalLoanAmountW.desc" />
            </div>
        </div>
        <div class="form-group row">
            <!-- 资金方总放款额度 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="fundSideCtrlInfo.fundSideTotalLoanAmountD" text="资金方日放款额管控" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:input cssClass="form-control" type="number" path="fundSideTotalLoanAmountD"   data-rule-maxlength="12" />
            </div>
            <!-- 资金方总放款额度描述 -->
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
                <spring:message code="fundSideCtrlInfo.fundSideTotalLoanAmountD.desc" />
            </div>
        </div>
		<div class="form-group row">
			<!-- 资金方总余额 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="fundSideCtrlInfo.fundSideTotalBalance" text="资金方余额总控" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="number" path="fundSideTotalBalance"   data-rule-maxlength="12" />
			</div>
			<!-- 资金方总余额描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="fundSideCtrlInfo.fundSideTotalBalance.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 余额额度有效期 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="fundSideCtrlInfo.balanceAmountUsefulLife" text="余额额度有效期" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <fmt:formatDate var="balanceAmountUsefulLifeFmt" value="${fundSideCtrlInfo.balanceAmountUsefulLife}" type="date" pattern="yyyy-MM-dd"/>
                <form:input class='form-control customize-datetime' type="text" value="${balanceAmountUsefulLifeFmt}"
                            data-picker-position="top-right" data-role-formate="yyyy-mm-dd"
				 path="balanceAmountUsefulLife" onfocus="this.blur()"   />
				<i class="fa fa-calendar input_date" ></i>
			</div>
			<!-- 余额额度有效期描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="fundSideCtrlInfo.balanceAmountUsefulLife.desc" />
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
		$("#fundSideCtrlInfoUpdForm").validate();
	</script>
</body>
</html>