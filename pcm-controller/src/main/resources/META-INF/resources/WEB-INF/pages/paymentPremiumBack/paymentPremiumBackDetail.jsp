<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="paymentPremiumBack.detail.title" text="保费垫付返还明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="paymentPremiumBack">
		<div class="form-group row">
			<!-- 保费垫付返还编码 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="paymentPremiumBack.paymentPremiumBackCode" text="保费垫付返还编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${paymentPremiumBack.paymentPremiumBackCode }	
			</label>
			<!-- 保费垫付返还描述 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="paymentPremiumBack.paymentPremiumBackDesc" text="保费垫付返还描述" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${paymentPremiumBack.paymentPremiumBackDesc }	
			</label>
			<!-- 所属机构 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="paymentPremiumBack.organization" text="所属机构" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${org }	
			</label>
			<!-- 合作方类型 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="paymentPremiumBack.partnerType" text="合作方类型" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${partnerType }	
			</label>
			<!-- 合作方编码 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="paymentPremiumBack.partnerCode" text="合作方编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${partner }	
			</label>
			<!-- 转出账号 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="paymentPremiumBack.transferAccount" text="转出账号" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${paymentPremiumBack.transferAccount }	
			</label>
			<!-- 转入账号 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="paymentPremiumBack.transferToAccount" text="转入账号" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${paymentPremiumBack.transferToAccount }	
			</label>
			<!-- 结算周期 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="paymentPremiumBack.billingCycle" text="结算周期" />
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
			<k:access code="paymentPremiumBack_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updatePaymentPremiumBack" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updatePaymentPremiumBack").click(function(){
						var params = [];
						params.push("paymentPremiumBackCode=${paymentPremiumBack.paymentPremiumBackCode }");
						$K.frame.reloadSlideInner("${ctx}/paymentPremiumBack/paymentPremiumBackEditPage.in?" + params.join("&"));
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