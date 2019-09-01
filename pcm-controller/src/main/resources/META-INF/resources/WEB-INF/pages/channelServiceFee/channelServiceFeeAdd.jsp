<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="channelServiceFee.add.title" text="渠道方服务费新增" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="channelServiceFeeAddForm" cssStyle="padding-top: 40px" modelAttribute="channelServiceFee" method="post" action="${ctx}/channelServiceFee/addChannelServiceFee.in" data-confirm="true">
	<div class="form-group row">
			<!-- 渠道方服务费编码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
			<span class="span-icon">*&nbsp;</span>
				<spring:message code="channelServiceFee.channelServiceCode" text="渠道方服务费编码" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="channelServiceCode" data-rule-required="true" data-rule-maxlength="15" />
			</div>
			<!-- 渠道方服务费编码描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="channelServiceFee.channelServiceCode.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 渠道方服务费描述 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
			<span class="span-icon">*&nbsp;</span>
				<spring:message code="channelServiceFee.channelServiceDesc" text="渠道方服务费描述" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="channelServiceDesc" data-rule-required="true" data-rule-maxlength="50" />
			</div>
			<!-- 渠道方服务费描述描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="channelServiceFee.channelServiceDesc.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 费用收取方式 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="channelServiceFee.feeCollectionMethod" text="费用收取方式" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="feeCollectionMethod" id="feeCollectionMethod">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${feeCollectionMethod}" />
				</form:select>
			</div>
			<!-- 费用收取方式描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="channelServiceFee.feeCollectionMethod.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 费用收取基础 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="channelServiceFee.feeBasis" text="费用收取基础" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="feeBasis">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${feeBasis}" />
				</form:select>
			</div>
			<!-- 费用收取基础描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="channelServiceFee.feeBasis.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 费用收取频次 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
			<span class="span-icon">*&nbsp;</span>
				<spring:message code="channelServiceFee.frequencyOfCharge" text="费用收取频次" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="frequencyOfCharge" data-rule-required="true">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${frequencyOfCharge}" />
				</form:select>
			</div>
			<!-- 费用收取频次描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="channelServiceFee.frequencyOfCharge.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 收取比例 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="channelServiceFee.chargeRatio" text="收取比例" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="chargeRatio"  data-rule-maxlength="12" data-rule-min="0" />
			</div>
			<!-- 收取比例描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="channelServiceFee.chargeRatio.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 收取金额 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="channelServiceFee.chargeAmount" text="收取金额" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="chargeAmount" id="chargeAmount"  data-rule-maxlength="12" data-rule-min="0"/>
			</div>
			<!-- 收取金额描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="channelServiceFee.chargeAmount.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 所属机构 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="channelServiceFee.organization" text="所属机构" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="organization">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${orgMap}" />
				</form:select>
			</div>
			<!-- 所属机构描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="channelServiceFee.organization.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 合作方类型 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="channelServiceFee.partnerType" text="合作方类型" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="partnerType" id="partnerType" onchange="typeChange();">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${partnerType}" />
				</form:select>
			</div>
			<!-- 合作方类型描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="channelServiceFee.partnerType.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 合作方编码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="channelServiceFee.partnerCode" text="合作方编码" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="partnerCode" id="partnerCode">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
				</form:select>
			</div>
			<!-- 合作方编码描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="channelServiceFee.partnerCode.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 转出账号 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="channelServiceFee.transferAccount" text="转出账号" />
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
				<spring:message code="channelServiceFee.transferAccount.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 转入账号 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="channelServiceFee.transferToAccount" text="转入账号" />
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
				<spring:message code="channelServiceFee.transferToAccount.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 结算周期 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
			<span class="span-icon">*&nbsp;</span>
				<spring:message code="channelServiceFee.billingCycle" text="结算周期" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="billingCycle" data-rule-required="true">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${billingCycle}" />
				</form:select>
			</div>
			<!-- 结算周期描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="channelServiceFee.billingCycle.desc" />
			</div>
			
		</div>
		
		
						<div class="form-group row">
		<!-- 结算日期 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="dedit.balanceDate" text="结算日期" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<input id="balanceDate" name="balanceDate" class='form-control customize-datetime' type="text" data-picker-position="top-right" data-role-formate="yyyy-mm-dd"  onfocus="this.blur()" disabled/>
			</div>
			 <!-- 结算日期描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="basicNetPremium.balanceDate.desc" />
			</div>
		</div>
		<div class="form-controls auto-float">
			<div class="btn-group-md">
				<!-- 确定 -->
				<input type="submit" id="submit" onclick="amountControl();" class="btn-primary btn" value="<spring:message code='kite.web.common.btnSure' text='确定' />" />
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
			</div>
		</div>
	</form:form>
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp"%>
	<script type="text/javascript">
		//开启表单验证
		$("#channelServiceFeeAddForm").validate();
		//收取金额控制
		$("#submit").click(function(){
			var method = $("#feeCollectionMethod").val();
			var amount = $("#chargeAmount").val();
			if(method=='JE'){
				if(amount=='' || amount==null){
					//data-rule-required="true"
					/* $("#chargeAmount").removeAttr("data-rule-required");
					$("#chargeAmount").attr("data-rule-required","true"); */
					$("#chargeAmount").focus();
					layer.msg("请填写收取金额！");
					return false; 
				}
			}
		});
		//合作方编码控制
		function typeChange(){
			var type = $("#partnerType").val();
			if(type=='ZJ'){
				var map = ${fundSideInfoMap}
				$("#partnerCode").empty();
				for(var key in map){
					$("#partnerCode").append('<option value="'+key+'">'+map[key]+'</option>');
				}
				$("#partnerCode").selectpicker("refresh");
			}
			if(type=='ZC'){
				var map = ${assetSideInfoMap}
				$("#partnerCode").empty();
				for(var key in map){
					$("#partnerCode").append('<option value="'+key+'">'+map[key]+'</option>');
				}
				$("#partnerCode").selectpicker("refresh");
			}
			if(type=='QD'){
				var map = ${channelInfoMap}
				$("#partnerCode").empty();
				for(var key in map){
					$("#partnerCode").append('<option value="'+key+'">'+map[key]+'</option>');
				}
				$("#partnerCode").selectpicker("refresh");
			}
			if(type=='FW'){
				var map = ${serverInfoMap}
				$("#partnerCode").empty();
				for(var key in map){
					$("#partnerCode").append('<option value="'+key+'">'+map[key]+'</option>');
				}
				$("#partnerCode").selectpicker("refresh");
			}
		}
		
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
				debugger
				zzqParent.append(
				'<select id="balanceDate" name="balanceDate"  class="form-control">'
	  				 <c:forEach items="${banceDate}" var="item"> 
	  					+'<option value="${item.key}">${item.value}</option>'
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