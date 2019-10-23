<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="platformCoupon.detail.title" text="平台优惠券编码明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="platformCoupon">
		<div class="form-group row">
			<!-- 平台优惠券编码 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="platformCoupon.couponCode" text="平台优惠券编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${platformCoupon.couponCode }	
			</label>
			<!-- 平台优惠券描述 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="platformCoupon.couponDescription" text="平台优惠券描述" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${platformCoupon.couponDescription }	
			</label>
			<!-- 所属机构 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="platformCoupon.organization" text="所属机构" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${org }	
			</label>
			<!-- 合作方类型 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="platformCoupon.partnerType" text="合作方类型" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${partnerType }	
			</label>
			<!-- 合作方编码 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="platformCoupon.partnerCode" text="合作方编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${partner }	
			</label>
			<!-- 转出账号 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="platformCoupon.transferAccount" text="转出账号" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${platformCoupon.transferAccount }	
			</label>
			<!-- 转入账号 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="platformCoupon.transferToAccount" text="转入账号" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${platformCoupon.transferToAccount }	
			</label>
			<!-- 结算周期 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="platformCoupon.billingCycle" text="结算周期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${billingCycle }	
			</label>
			<!-- 结算日期 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="platformCoupon.balanceDate" text="结算日期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle" id="balanceDate">
					&nbsp;${balanceDate}
			</label>
			
													<!-- 结算信息-->
<!-- 			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"> -->
<!-- 				<spring:message code="fundSideServiceFee.settleAccounts" text="结算信息" /> -->
<!-- 				: -->
<!-- 			</label> -->
<!-- 			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle"> -->
<%-- 				&nbsp;${platformCoupon.settleAccounts}	 --%>
<!-- 			</label> -->
			
		</div>
		<div class="form-controls auto-float">
			<div class="btn-group-sm">
			<k:access code="platformCoupon_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updatePlatformCoupon" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updatePlatformCoupon").click(function(){
						var params = [];
						params.push("couponCode=${platformCoupon.couponCode }");
						$K.frame.reloadSlideInner("${ctx}/platformCoupon/platformCouponEditPage.in?" + params.join("&"));
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