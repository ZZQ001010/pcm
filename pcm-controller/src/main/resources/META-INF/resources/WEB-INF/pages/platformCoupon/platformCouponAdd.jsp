<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="platformCoupon.add.title" text="平台优惠券编码新增" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="platformCouponAddForm" cssStyle="padding-top: 40px" modelAttribute="platformCoupon" method="post" action="${ctx}/platformCoupon/addPlatformCoupon.in" data-confirm="true">
		<div class="form-group row">
			<!-- 平台优惠券编码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
			<span class="span-icon">*&nbsp;</span>
				<spring:message code="platformCoupon.couponCode" text="平台优惠券编码" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="couponCode"  data-rule-maxlength="32" data-rule-required="true" />
			</div>
			<!-- 平台优惠券编码描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="platformCoupon.couponCode.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 平台优惠券 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
			<span class="span-icon">*&nbsp;</span>
				<spring:message code="platformCoupon.couponDescription" text="平台优惠券描述" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="couponDescription"  data-rule-maxlength="100" data-rule-required="true" />
			</div>
			<!-- 平台优惠券描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="platformCoupon.couponDescription.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 所属机构 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="platformCoupon.organization" text="所属机构" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="organization" >
				<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${orgMap}" />
				</form:select>
			</div>
			<!-- 所属机构描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="platformCoupon.organization.desc" />
			</div>
		</div>
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
				<form:select cssClass="form-control" path="partnerCode" data-rule-required="true" id="partnerCode">
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
				<spring:message code="platformCoupon.transferAccount" text="转出账号" />
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
				<spring:message code="platformCoupon.transferAccount.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 转入账号 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="platformCoupon.transferToAccount" text="转入账号" />
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
				<spring:message code="platformCoupon.transferToAccount.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 结算周期 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
			<span class="span-icon">*&nbsp;</span>
				<spring:message code="platformCoupon.billingCycle" text="结算周期" />
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
				<spring:message code="platformCoupon.billingCycle.desc" />
			</div>
		</div>
		
		<div class="form-group row">
		<!-- 结算日期 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="platformCoupon.balanceDate" text="结算日期" />
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
		
			
	 <div class="form-group row">
		<!-- 结算信息 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="fundSideServiceFee.settleAccounts" text="结算信息" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<input id="settleAccounts" name="settleAccounts" class='form-control' type="text"   />
			</div>
			 <!-- 结算信息 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="fundSideServiceFee.settleAccounts.desc" />
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
		$("#platformCouponAddForm").validate();
		
		//合作方编码控制
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