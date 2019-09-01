<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="safetyMat.update.title" text="安全垫修改" /></title>
<%@ include file="/common/head.jsp"%>
</head>
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="safetyMatAddForm" cssStyle="padding-top: 40px" modelAttribute="safetyMat" method="post" action="${ctx}/safetyMat/updSafetyMat.in" data-confirm="true">
		<input type="hidden" value="${safetyMat.code }" name="code">
		<div class="form-group row">
			<!-- 描述 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="safetyMat.desc" text="描述" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="desc"  data-rule-required="true" data-rule-maxlength="50" />
			</div>
			<!-- 描述描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="safetyMat.desc.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 费用收取方式 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="safetyMat.feeCollectionMethod" text="费用收取方式" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="feeCollectionMethod">
					<form:options items="${feeCollectionMethod}" />
				</form:select>
			</div>
			<!-- 费用收取方式描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="safetyMat.feeCollectionMethod.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 费用收取基础 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">&nbsp;</span>
				<spring:message code="safetyMat.feeBasis" text="费用收取基础" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="feeBasis">
					<form:options items="${feeBasis}" />
				</form:select>
			</div>
			<!-- 费用收取基础描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="safetyMat.feeBasis.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 费用收取频次 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">&nbsp;</span>
				<spring:message code="safetyMat.frequencyOfCharge" text="费用收取频次" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="frequencyOfCharge">
					<form:options items="${frequencyOfCharge}" />
				</form:select>
			</div>
			<!-- 费用收取频次描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="safetyMat.frequencyOfCharge.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 收取比例 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">&nbsp;</span>
				<spring:message code="safetyMat.chargeRatio" text="收取比例" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="chargeRatio" id="chargeRatio"   />
			</div>
			<!-- 收取比例描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="safetyMat.chargeRatio.desc" />
			</div>
		</div>
		
				<div class="form-group row">
			<!-- 费用累计月天数 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">&nbsp;</span>
				<spring:message code="safetyMat.expenses" text="费用收取频次" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="expenses">
					<form:options items="${expenses}" />
				</form:select>
			</div>
			<!-- 费用累计月天数描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="safetyMat.expenses.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 所属机构 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">&nbsp;</span>
				<spring:message code="safetyMat.organization" text="所属机构 " />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="organization">
					<form:options items="${orgMap}" />
				</form:select>
			</div>
			<!-- 所属机构描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="safetyMat.organization.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 资产方 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">&nbsp;</span>
				<spring:message code="safetyMat.asset" text="资产方 " />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="asset" value="${assetSideInfo }">
					<form:options items="${assetSideInfoMap}" />
				</form:select>
			</div>
			<!-- 资产方描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="safetyMat.asset.desc" />
			</div>
		</div>
		
		<div class="form-group row">
			<!-- 安全垫下限控制方式 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">&nbsp;</span>
				<spring:message code="safetyMat.controlMode" text="安全垫下限控制方式" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="controlMode">
					<form:options items="${controlModeMap}" />
				</form:select>
			</div>
			<!-- 安全垫下限控制方式 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="safetyMat.controlMode.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 安全垫下限控制比例 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="safetyMat.controlRatio" text="安全垫下限控制比例" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="controlRatio" id="controlRatio" onchange="change();" />
			</div>
			<!-- 安全垫下限控制比例 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="safetyMat.controlRatio.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 安全垫下限控制金额 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="safetyMat.controlMoney" text="安全垫下限控制金额" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="controlMoney"  data-rule-digits="true" data-rule-min="0" />
			</div>
			<!-- 安全垫下限控制金额描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="safetyMat.controlMoney.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 技术服务费收取方式 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="safetyMat.chargeWay" text="技术服务费收取方式" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="chargeWay">
					<form:options items="${chargeWayMap}" />
				</form:select>
			</div>
			<!-- 技术服务费收取方式描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="safetyMat.chargeWay.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 技术服务费收取基础-->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">&nbsp;</span>
				<spring:message code="safetyMat.chargeBasics" text="技术服务费收取基础" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="chargeBasics">
					<form:options items="${chargeBasicsMap}" />
				</form:select>
			</div>
			<!-- 技术服务费收取基础描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="safetyMat.chargeBasics.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 转出账号 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="safetyMat.transferAccount" text="转出账号" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="transferAccount" >
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${pcmSettleAccMan}" />
				</form:select>
			</div>
			<!-- 转出账号描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="safetyMat.transferAccount.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 转入账号 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="safetyMat.transferToAccount" text="转入账号" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="transferToAccount" >
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${pcmSettleAccMan}" />
				</form:select>
			</div>
			<!-- 转入账号描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="safetyMat.transferToAccount.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 结算周期 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="safetyMat.billingCycle" text="结算周期" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="billingCycle">
					<form:options items="${billingCycle}" />
				</form:select>
			</div>
			<!-- 结算周期描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="safetyMat.billingCycle.desc" />
			</div>
		</div>
		<div class="form-group row">
		<!-- 结算日期 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="safetyMat.balanceDate" text="结算日期" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<from:input id="balanceDate" path="balanceDate" 
				class='form-control customize-datetime' type="text" 
				data-picker-position="top-right" data-role-formate="yyyy-mm-dd"  
					onfocus="this.blur()"/>
			</div>
			 <!-- 结算日期描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="basicNetPremium.balanceDate.desc" />
			</div>
		</div>		
		<div class="form-group row">
			<!-- 起始结算逾期周期-->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="safetyMat.period" text="起始结算逾期周期" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="period">
					<form:options items="${billingCycle}" />
				</form:select>
			</div>
			<!-- 起始结算逾期周期描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="safetyMat.period.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 起始结算逾期周期数量 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="safetyMat.periodNum" text="起始结算逾期周期数量" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="periodNum" data-rule-maxlength="12" />
			</div>
			<!-- 起始结算逾期周期数量描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="safetyMat.periodNum.desc" />
			</div>
		</div>
		<%--<div class="form-group row">--%>
			<%--<!-- 保费垫付是否参与分润-->--%>
			<%--<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">--%>
				<%--<spring:message code="" text="保费垫付是否参与分润" />--%>
				<%--:--%>
			<%--</label>--%>
			<%--<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">--%>
				<%--<form:select cssClass="form-control" path="participationStatus">--%>
					<%--<form:options items="${participationStatusMap}" />--%>
				<%--</form:select>--%>
			<%--</div>--%>
			<%--<!-- 保费垫付是否参与分润 -->--%>
			<%--<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">--%>
				<%--<spring:message code="" text="保费垫付是否参与分润" />--%>
			<%--</div>--%>
		<%--</div>--%>
				<%--<div class="form-group row">--%>
			<%--<!-- 放款当天提前还款手续费方式-->--%>
			<%--<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">--%>
				<%--<spring:message code="" text="放款当天提前还款手续费方式" />--%>
				<%--:--%>
			<%--</label>--%>
			<%--<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">--%>
				<%--<form:select cssClass="form-control" path="backsettlement">--%>
					<%--<form:options items="${backsettlement}" />--%>
				<%--</form:select>--%>
			<%--</div>--%>
			<%--<!-- 放款当天提前还款手续费方式 -->--%>
			<%--<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">--%>
				<%--<spring:message code="safetyMat.backsettlement.desc" />--%>
			<%--</div>--%>
		<%--</div>--%>
				<div class="form-group row">
			<!-- 放款当天提前还款手续费方式-->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="" text="放款当天提前还款手续费方式" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="settlement">
					<form:options items="${settlement}" />
				</form:select>
			</div>
			<!-- 放款当天提前还款手续费方式 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="safetyMat.settlement.desc" />
			</div>
		</div>
		<div class="form-controls auto-float">
			<div class="btn-group-md">
				<!-- 确定 -->
				<input type="submit" id="submit" class="btn-primary btn" value="<spring:message code='kite.web.common.btnSure' text='确定' />" />
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='取消' />" />
			</div>
		</div>
	</form:form>
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp"%>
	<script type="text/javascript">
	//开启表单验证
	$("#safetyMatAddForm").validate();
	
	$(function(){
		var value = $("#billingCycle").val();
		if(value=='A'){
			var zzqParent = $('#balanceDate').parent('div');
			zzqParent.empty();
			zzqParent.append('<input id="balanceDate" name="balanceDate"  class="form-control" type="text"   />')
			$('#balanceDate').attr("disabled",true); 
		}else if(value=='Z'){
			var zzqParent = $('#balanceDate').parent('div');
			zzqParent.empty();
			zzqParent.append('<select id="balanceDate" name="balanceDate"  class="form-control">'
					<c:forEach items="${banceDate}" var="item"> 
  					+'<option value="${item.value}">${item.value}</option>'
  				</c:forEach>
			+'<select>');
			$('#balanceDate').val('${safetyMat.balanceDate}')
		}else if(value=='C'){
			var zzqParent = $('#balanceDate').parent('div');
			zzqParent.empty();
			zzqParent.append('<input id="balanceDate" name="balanceDate"  class="form-control customize-datetime" type="text" data-picker-position="top-right" data-role-formate="dd"  onfocus="this.blur()" />')
			$('#balanceDate').datepicker({
				autoclose : true,
				format: 'dd',
			})
			$('#balanceDate').val('${safetyMat.balanceDate}')
		}else if(value=='I'){
			$('#balanceDate').datepicker('destroy')
			var zzqParent = $('#balanceDate').parent('div');
			zzqParent.empty();
			zzqParent.append('<input id="balanceDate"  name="balanceDate" class="form-control" type="text"   />')
			$('#balanceDate').datepicker({
				autoclose : true,
				format: 'mm-dd',
			})
			$('#balanceDate').val('${safetyMat.balanceDate}')
		}else{
			$('#balanceDate').attr("disabled",false); 
		}
	})
	
	$('#billingCycle').change(function(){
		var value = $(this).val();
		if(value=='A'){
			var zzqParent = $('#balanceDate').parent('div');
			zzqParent.empty();
			zzqParent.append('<input id="balanceDate" name="balanceDate"  class="form-control" type="text"   />')
			$('#balanceDate').attr("disabled",true); 
		}else if(value=='Z'){
			var zzqParent = $('#balanceDate').parent('div');
			zzqParent.empty();
			zzqParent.append('<select id="balanceDate" name="balanceDate"  class="form-control">'
					<c:forEach items="${banceDate}" var="item"> 
  					+'<option value="${item.value}">${item.value}</option>'
  				</c:forEach>
			+'<select>');
		}else if(value=='C'){
			var zzqParent = $('#balanceDate').parent('div');
			zzqParent.empty();
			zzqParent.append('<input id="balanceDate" name="balanceDate"  class="form-control customize-datetime" type="text" data-picker-position="top-right" data-role-formate="dd"  onfocus="this.blur()" />')
			$('#balanceDate').datepicker({
				autoclose : true,
				format: 'dd',
			})
		}else if(value=='I'){
			$('#balanceDate').datepicker('destroy')
			var zzqParent = $('#balanceDate').parent('div');
			zzqParent.empty();
			zzqParent.append('<input id="balanceDate"  name="balanceDate" class="form-control" type="text"   />')
			$('#balanceDate').datepicker({
				autoclose : true,
				format: 'mm-dd',
			})
		}else{
			$('#balanceDate').attr("disabled",false); 
		}
	})
	</script>
</body>
</html>