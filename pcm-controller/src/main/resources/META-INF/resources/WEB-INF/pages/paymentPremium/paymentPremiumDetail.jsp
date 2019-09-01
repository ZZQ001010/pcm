<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="paymentPremium.detail.title" text="保费垫付明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="paymentPremium">
		<div class="form-group row">
			<!-- 保费垫付编码 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="paymentPremium.paymentPremiumCode" text="保费垫付编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${paymentPremium.paymentPremiumCode }	
			</label>
			<!-- 保费垫付描述 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="paymentPremium.paymentPremiumDesc" text="保费垫付描述" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${paymentPremium.paymentPremiumDesc }	
			</label>
			<!-- 保费垫付方式 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="paymentPremium.paymentPremiumType" text="保费垫付方式" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${paymentPremiumType }	
			</label>
			 
			 
			 			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="paymentPremium.premiumAdvanceSafetyPadDividedLogo" text="保费垫付方式" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${premiumAdvanceSafetyPadDividedLogo }	
			</label>
			 
			 
			 			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="paymentPremium.premiumAdvanceFlowServiceCharges" text="保费垫付方式" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${premiumAdvanceFlowServiceCharges }	
			</label>
			 
			 
			 			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="paymentPremium.unpaidRepaymentSafetyPad" text="未垫付还款安全垫分润标识" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${unpaidRepaymentSafetyPad }	
			</label>
			 
			 
			 
			 			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="paymentPremium.unpaidRepaymentServiceFee" text="未垫付还款流量服务费分润标识" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${unpaidRepaymentServiceFee }	
			</label>
			 
			 
			 
			<!-- 所属机构 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="paymentPremium.organization" text="所属机构" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${org }	
			</label>
			<!-- 合作方类型 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="paymentPremium.partnerType" text="合作方类型" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${partnerType }	
			</label>
			<!-- 合作方编码 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="paymentPremium.partnerCode" text="合作方编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${partner }	
			</label>
			<!-- 转出账号 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="paymentPremium.transferAccount" text="转出账号" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${paymentPremium.transferAccount }	
			</label>
			<!-- 转入账号 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="paymentPremium.transferToAccount" text="转入账号" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${paymentPremium.transferToAccount }	
			</label>
			<!-- 结算周期 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="paymentPremium.billingCycle" text="结算周期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${billingCycle }	
			</label>
			
			<!-- 结算日期 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="platformCoupon.balanceDate" text="结算日期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle" id="balanceDate">
					&nbsp;${balanceDate}
			</label>
			
		</div>
		<div class="form-controls auto-float">
			<div class="btn-group-sm">
			<k:access code="paymentPremium_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updatePaymentPremium" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updatePaymentPremium").click(function(){
						var params = [];
						params.push("paymentPremiumCode=${paymentPremium.paymentPremiumCode }");
						$K.frame.reloadSlideInner("${ctx}/paymentPremium/paymentPremiumEditPage.in?" + params.join("&"));
					})
				</script>
			</k:access>
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
			</div>
		</div>
	</form:form>
	<%@ include file="/common/foot.jsp"%>
</body>
</html>