<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="assetSideCtrlInfo.add.title" text="资产方管控信息新增" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="assetSideCtrlInfoAddForm" cssStyle="padding-top: 40px" modelAttribute="assetSideCtrlInfo" method="post" action="${ctx}/assetSideCtrlInfo/addAssetSideCtrlInfo.in" data-confirm="true">
		<div class="form-group row">
			<!-- 资产方管控编码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="assetSideCtrlInfo.assetSideCtrlCode" text="资产方管控编码" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="assetSideCtrlCode"  data-rule-required="true" data-rule-maxlength="32" />
			</div>
			<!-- 资产方管控编码描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="assetSideCtrlInfo.assetSideCtrlCode.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 资产方管控描述 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="assetSideCtrlInfo.assetSideCtrlDesc" text="资产方管控描述" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="assetSideCtrlDesc" data-rule-required="true" data-rule-maxlength="50" />
			</div>
			<!-- 资产方管控描述描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="assetSideCtrlInfo.assetSideCtrlDesc.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 资产方编码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="assetSideCtrlInfo.assetSideCode" text="资产方编码" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:select cssClass="form-control" path="assetSideCode" data-rule-required="true">
                	<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
                    <form:options items="${assetFundSideCode}" />
                </form:select>
            </div>
			<!-- 资产方编码描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="assetSideCtrlInfo.assetSideCode.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 资产方授信管控 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="assetSideCtrlInfo.assetSideCreditCtrl" text="资产方授信管控" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="assetSideCreditCtrl">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${assetSideLoanCtrl}" />
				</form:select>
			</div>
			<!-- 资产方授信管控描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="assetSideCtrlInfo.assetSideCreditCtrl.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 资产方额度总控 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="assetSideCtrlInfo.assetSideAmountGeneralControl" text="资产方额度总控" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="number"  oninput = "value=value.replace(/[^\d]/g,'')" path="assetSideAmountGeneralControl" />
			</div>
			<!-- 资产方额度总控描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="assetSideCtrlInfo.assetSideAmountGeneralControl.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 授信额度有效期 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="assetSideCtrlInfo.authorizationAmountUsefulLife" text="授信额度有效期" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
				<form:input class='form-control customize-datetime' type="text" data-picker-position="top-right" data-role-formate="yyyy-mm-dd" path="authorizationAmountUsefulLife" onfocus="this.blur()" />
				<i class="fa fa-calendar input_date" ></i>
			</div>
			<!-- 授信额度有效期描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="assetSideCtrlInfo.authorizationAmountUsefulLife.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 资产方放款管控 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="assetSideCtrlInfo.assetSideLoanCtrl" text="资产方放款管控" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="assetSideLoanCtrl">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${assetSideLoanCtrl}" />
				</form:select>
			</div>
			<!-- 资产方放款管控描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="assetSideCtrlInfo.assetSideLoanCtrl.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 资产方放款额总控 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="assetSideCtrlInfo.assetSideAmountLoanControl" text="资产方放款额总控" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="number" oninput = "value=value.replace(/[^\d]/g,'')" path="assetSideAmountLoanControl"/>
			</div>
			<!-- 资产方放款额总控描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="assetSideCtrlInfo.assetSideAmountLoanControl.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 放款额度有效期 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="assetSideCtrlInfo.loanAmountUsefulLife" text="放款额度有效期" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
				<form:input class='form-control customize-datetime' type="text" data-picker-position="top-right" data-role-formate="yyyy-mm-dd" path="loanAmountUsefulLife" onfocus="this.blur()"/>
				<i class="fa fa-calendar input_date" ></i>
			</div>
			<!-- 放款额度有效期描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="assetSideCtrlInfo.loanAmountUsefulLife.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 资产方月放款额管控 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="assetSideCtrlInfo.assetSideControlMonth" text="资产方月放款额管控" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="number" oninput = "value=value.replace(/[^\d]/g,'')" path="assetSideControlMonth"/>
			</div>
			<!-- 资产方月放款额管控描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="assetSideCtrlInfo.assetSideControlMonth.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 资产方周放款额管控 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="assetSideCtrlInfo.assetSideControlWeek" text="资产方周放款额管控" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="number" oninput = "value=value.replace(/[^\d]/g,'')" path="assetSideControlWeek"/>
			</div>
			<!-- 资产方余额总控描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="assetSideCtrlInfo.assetSideControlWeek.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 资产方日放款额管控 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="assetSideCtrlInfo.assetSideControlDay" text="资产方日放款额管控" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="number" oninput = "value=value.replace(/[^\d]/g,'')" path="assetSideControlDay"/>
			</div>
			<!-- 资产方余额总控描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="assetSideCtrlInfo.assetSideControlDay.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 资产方余额总控 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="assetSideCtrlInfo.assetSideBalanceControl" text="资产方余额总控" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="number" oninput = "value=value.replace(/[^\d]/g,'')" path="assetSideBalanceControl"/>
			</div>
			<!-- 资产方余额总控描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="assetSideCtrlInfo.assetSideBalanceControl.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 余额额度有效期 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="assetSideCtrlInfo.balanceAmountUsefulLife" text="余额额度有效期" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
				<form:input class='form-control customize-datetime' type="text" data-picker-position="top-right" data-role-formate="yyyy-mm-dd" path="balanceAmountUsefulLife" onfocus="this.blur()"/>
				<i class="fa fa-calendar input_date" ></i>
			</div>
			<!-- 余额额度有效期描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="assetSideCtrlInfo.balanceAmountUsefulLife.desc" />
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
		$("#assetSideCtrlInfoAddForm").validate();
	</script>
</body>
</html>