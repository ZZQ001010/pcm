<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="trafficServiceFee.update.title" text="流量服务费修改" /></title>
<%@ include file="/common/head.jsp"%>
</head>
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="trafficServiceFeeUpdForm" cssStyle="padding-top: 40px" modelAttribute="trafficServiceFee" method="post" action="${ctx}/trafficServiceFee/updTrafficServiceFee.in" data-confirm="true">
		<form:hidden path="trafficServiceFeeCode" />
		<div class="form-group row">
			<!-- 流量服务描述 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="trafficServiceFee.trafficServiceFeeDesc" text="流量服务描述" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="trafficServiceFeeDesc"  data-rule-required="true" data-rule-maxlength="50" />
			</div>
			<!-- 流量服务描述描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="trafficServiceFee.trafficServiceFeeDesc.desc" />
			</div>
		</div>				
		<!-- <div class="form-group row">
			单笔最小金额
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<%--<spring:message code="trafficServiceFee.singleMinimumAmount" text="单笔最小金额" />--%>
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<%--<form:input cssClass="form-control" type="text" path="singleMinimumAmount"  data-rule-required="true" data-rule-digits="true" data-rule-min="0" data-rule-max="999999999999999" />--%>
			</div>
			单笔最小金额描述
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<%--<spring:message code="trafficServiceFee.singleMinimumAmount.desc" />--%>
			</div>
		</div>				
		<div class="form-group row">
			单笔最大金额
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<%--<spring:message code="trafficServiceFee.singleMaximumAmount" text="单笔最大金额" />--%>
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<%--<form:input cssClass="form-control" type="text" path="singleMaximumAmount"  data-rule-required="true" data-rule-digits="true" data-rule-min="0" data-rule-max="999999999999999" />--%>
			</div>
			单笔最大金额描述
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<%--<spring:message code="trafficServiceFee.singleMaximumAmount.desc" />--%>
			</div>
		</div>	 -->			
		<div class="form-group row">
			<!-- 费用收取方式 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="trafficServiceFee.feeCollectionMethod" text="费用收取方式" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="feeCollectionMethod">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${feeCollectionMethod}" />
				</form:select>
			</div>
			<!-- 费用收取方式描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="trafficServiceFee.feeCollectionMethod.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 费用收取基础 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="trafficServiceFee.feeBasis" text="费用收取基础" />
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
				<spring:message code="trafficServiceFee.feeBasis.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 费用收取频次 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="trafficServiceFee.frequencyOfCharge" text="费用收取频次" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="frequencyOfCharge">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${frequencyOfCharge}" />
				</form:select>
			</div>
			<!-- 费用收取频次描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="trafficServiceFee.frequencyOfCharge.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 收取比例 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="trafficServiceFee.chargeRatio" text="收取比例" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="number" path="chargeRatio"  data-rule-required="true"  data-rule-min="0" data-rule-max="999999999999" />
			</div>
			<!-- 收取比例描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="trafficServiceFee.chargeRatio.desc" />
			</div>
		</div>	
		
		<div class="form-group row">
            <!-- 费用累计月天数 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="trafficServiceFee.expenses" text="费用累计月天数" />
				:
			</label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:select cssClass="form-control" path="expenses">
                	<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
                  	 <form:options items="${expenses}" />
                </form:select>
            </div>
            <!-- 资产方描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="trafficServiceFee.expenses.desc" />
			</div>
        </div>
		
		<!-- 流量服务费折扣    -->
		<div class="form-group row">
			<!-- 流量服务费折扣 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="trafficServiceFee.trafficService" text="流量服务费折扣" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="number" path="trafficService"  data-rule-required="true"   data-rule-min="0" data-rule-max="999999999999" />
			</div>
			<!-- 流量服务费折扣 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="trafficServiceFee.trafficService.desc" />
			</div>
		</div>	
		
		<div class="form-group row">
			<!-- 所属机构 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="trafficServiceFee.organization" text="所属机构 " />
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
				<spring:message code="safetyMat.organization.desc" />
			</div>
		</div>
		<%-- <div class="form-group row">
			<!-- 资产方 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="trafficServiceFee.asset" text="资产方 " />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="asset">
					<form:options items="${assetSideInfoMap}" />
				</form:select>
			</div>
			<!-- 资产方描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="safetyMat.asset.desc" />
			</div>
		</div> --%>
		
		
		<div class="form-group row">
			<!-- 合作方类型 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
			<span class="span-icon">*&nbsp;</span>
				<spring:message code="platformCoupon.partnerType" text="合作方类型" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="partnerType" id="partnerType" onchange="typeChange();" data-rule-required="true">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${partnerType}" />
				</form:select>
			</div>
			<!-- 合作方类型描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="platformCoupon.partnerType.desc" />
			</div>
		</div>	
		
		<div class="form-group row">
			<!-- 合作方编码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
			<span class="span-icon">*&nbsp;</span>
				<spring:message code="platformCoupon.partnerCode" text="合作方编码" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="partnerCode" id="partnerCode">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
				</form:select>
			</div>
			<!-- 合作方编码描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="platformCoupon.partnerCode.desc" />
			</div>
		</div>	
		
		<div class="form-group row">
			<!-- 转出账号 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="trafficServiceFee.transferAccount" text="转出账号" />
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
				<spring:message code="trafficServiceFee.transferAccount.desc" />
			</div>
		</div>			
		<!-- <div class="form-group row">
			收取金额
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<%--<spring:message code="trafficServiceFee.chargeAmount" text="收取金额" />--%>
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<%--<form:input cssClass="form-control" type="text" path="chargeAmount"  data-rule-required="true" data-rule-digits="true" data-rule-min="0" data-rule-max="999999999999" />--%>
			</div>
			收取金额描述
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<%--<spring:message code="trafficServiceFee.chargeAmount.desc" />--%>
			</div>
		</div> -->				
		<div class="form-group row">
			<!-- 转入账号 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon"></span>
				<spring:message code="trafficServiceFee.transferToAccount" text="转入账号" />
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
				<spring:message code="trafficServiceFee.transferToAccount.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 结算周期 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="trafficServiceFee.billingCycle" text="结算周期" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="billingCycle">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${billingCycle}" />
				</form:select>
			</div>
			<!-- 结算周期描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="trafficServiceFee.billingCycle.desc" />
			</div>
		</div>	
				 <div class="form-group row">
		<!-- 结算日期 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="trafficServiceFee.balanceDate" text="结算日期" />
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
		
		
<!-- 				<div class="form-group row"> -->
<!-- 			<!-- 结算信息 --> -->
<!-- 			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label"> -->
<!-- 				<spring:message code="fundSideServiceFee.settleAccounts" text="结算信息" /> -->
<!-- 				: -->
<!-- 			</label> -->
<!-- 			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6"> -->
<!-- 				<form:input cssClass="form-control" type="text" path="settleAccounts" data-rule-min="0" /> -->
<!-- 			</div> -->
<!-- 			<!-- 结算信息描述 --> -->
<!-- 			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark"> -->
<!-- 				<spring:message code="fundSideServiceFee.settleAccounts.desc" /> -->
<!-- 			</div> -->
<!-- 		</div>	 -->
		
		<!-- 放款当天提前结清费用收取方式 -->
		<%--<div class="form-group row">--%>
			<%--<!-- 放款当天提前结清费用收取方式 -->--%>
			<%--<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">--%>
				<%--<span class="span-icon"></span>--%>
				<%--<spring:message code="trafficServiceFee.advanceSettlement" text="放款当天提前结清费用收取方式" />--%>
				<%--:--%>
			<%--</label>--%>
			<%--<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">--%>
				<%--<form:select cssClass="form-control" path="advanceSettlement">--%>
					<%--<form:options items="${advanceSettlement}" />--%>
				<%--</form:select>--%>
			<%--</div>--%>
			<%--<!-- 放款当天提前结清费用收取方式描述描述 -->--%>
			<%--<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">--%>
				<%--<spring:message code="trafficServiceFee.advanceSettlement.desc" />--%>
			<%--</div>--%>
		<%--</div>	--%>
		
				
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
		$("#trafficServiceFeeUpdForm").validate();
		
		$(function(){
			//初始化数据
			typeChange();
		});
		
		function typeChange(){
			var type = $("#partnerType").val();
			if(type=='ZJ'){
				var map = ${fundSideInfoMap}
				$("#partnerCode").empty();
				$("#partnerCode").append('<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>');
				for(var key in map){
					$("#partnerCode").append('<option value="'+key+'">'+map[key]+'</option>');
				}
				$("#partnerCode").selectpicker("refresh");
			}
			if(type=='ZC'){
				var map = ${assetSideInfoMap}
				$("#partnerCode").empty();
				$("#partnerCode").append('<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>');
				for(var key in map){
					$("#partnerCode").append('<option value="'+key+'">'+map[key]+'</option>');
				}
				$("#partnerCode").selectpicker("refresh");
			}
			if(type=='QD'){
				var map = ${channelInfoMap}
				$("#partnerCode").empty();
				$("#partnerCode").append('<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>');
				for(var key in map){
					$("#partnerCode").append('<option value="'+key+'">'+map[key]+'</option>');
				}
				$("#partnerCode").selectpicker("refresh");
			}
			if(type=='FW'){
				var map = ${serverInfoMap}
				$("#partnerCode").empty();
				$("#partnerCode").append('<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>');
				for(var key in map){
					$("#partnerCode").append('<option value="'+key+'">'+map[key]+'</option>');
				}
				$("#partnerCode").selectpicker("refresh");
			}
		}
		
		
		
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
				$('#balanceDate').val('${trafficServiceFee.balanceDate}')
			}else if(value=='C'){
				var zzqParent = $('#balanceDate').parent('div');
				zzqParent.empty();
				zzqParent.append('<input id="balanceDate" name="balanceDate"  class="form-control customize-datetime" type="text" data-picker-position="top-right" data-role-formate="dd"  onfocus="this.blur()" />')
				$('#balanceDate').datepicker({
					autoclose : true,
					format: 'dd',
				})
				$('#balanceDate').val('${trafficServiceFee.balanceDate}')
			}else if(value=='I'){
				$('#balanceDate').datepicker('destroy')
				var zzqParent = $('#balanceDate').parent('div');
				zzqParent.empty();
				zzqParent.append('<input id="balanceDate"  name="balanceDate" class="form-control" type="text"   />')
				$('#balanceDate').datepicker({
					autoclose : true,
					format: 'mm-dd',
				})
				$('#balanceDate').val('${trafficServiceFee.balanceDate}')
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