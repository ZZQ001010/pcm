<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="trafficServiceFee.detail.title" text="流量服务费明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="trafficServiceFee">
		<div class="form-group row">
			<!-- 流量服务费 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="trafficServiceFee.trafficServiceFeeCode" text="流量服务费编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${trafficServiceFee.trafficServiceFeeCode }	
			</label>
			<!-- 流量服务描述 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="trafficServiceFee.trafficServiceFeeDesc" text="流量服务描述" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${trafficServiceFee.trafficServiceFeeDesc }	
			</label>
			<!-- 单笔最小金额 -->
			<%-- <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="trafficServiceFee.singleMinimumAmount" text="单笔最小金额" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${trafficServiceFee.singleMinimumAmount }	
			</label>
			<!-- 单笔最大金额 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="trafficServiceFee.singleMaximumAmount" text="单笔最大金额" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${trafficServiceFee.singleMaximumAmount }	
			</label> --%>
			<!-- 费用收取方式 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="trafficServiceFee.feeCollectionMethod" text="费用收取方式" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${feeCollectionMethod}
			</label>
			<!-- 费用收取基础 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="trafficServiceFee.feeBasis" text="费用收取基础" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${feeBasis}
			</label>
			<!-- 费用收取频次 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="trafficServiceFee.frequencyOfCharge" text="费用收取频次" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${frequencyOfCharge}
			</label>
			<!-- 收取比例 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="trafficServiceFee.chargeRatio" text="收取比例" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${trafficServiceFee.chargeRatio }	
			</label>
			
			<!--  费用累计月天数 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="basicNetPremium.expenses" text="费用累计月天数" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${expenses}
			</label>
			
			<!-- 流量服务费折扣 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="trafficServiceFee.trafficService" text="收取比例" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${trafficServiceFee.trafficService }	
			</label>
			<!-- 所属机构 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="trafficServiceFee.organization" text="所属机构" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${org }	
			</label>
			
			<!-- 资产方 -->
			<%-- <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="trafficServiceFee.asset" text="资产方" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${assetSideInfo }	
			</label> --%>
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
				<spring:message code="trafficServiceFee.transferAccount" text="转出账号" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${trafficServiceFee.transferAccount }	
			</label>
			<!-- 收取金额 -->
			<%-- <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="trafficServiceFee.chargeAmount" text="收取金额" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${trafficServiceFee.chargeAmount }	
			</label> --%>
			<!-- 转入账号 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="trafficServiceFee.transferToAccount" text="转入账号" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${trafficServiceFee.transferToAccount }	
			</label>
			<!-- 结算周期 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="trafficServiceFee.billingCycle" text="结算周期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${billingCycle}
			</label>
			
					 <!-- 结算日期 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="trafficServiceFee.balanceDate" text="结算日期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${trafficServiceFee.balanceDate}
			</label>
			
			
												<!-- 结算信息-->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="fundSideServiceFee.settleAccounts" text="结算信息" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${fundSideServiceFee.settleAccounts}	
			</label>
			
			<!-- 放款当天提前结清费用收取方式 -->
			<%--<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">--%>
				<%--<spring:message code="trafficServiceFee.advanceSettlement" text="放款当天提前结清费用收取方式" />--%>
				<%--:--%>
			<%--</label>--%>
			<%--<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">--%>
				<%--&nbsp;${advanceSettlement}--%>
			<%--</label>--%>
		</div>
	<c:if test="${factory==false }">
		<div class="form-controls auto-float">
			<div class="btn-group-sm">
			<k:access code="trafficServiceFee_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updateTrafficServiceFee" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updateTrafficServiceFee").click(function(){
						var params = [];
						params.push("trafficServiceFeeCode=${trafficServiceFee.trafficServiceFeeCode }");
						$K.frame.reloadSlideInner("${ctx}/trafficServiceFee/trafficServiceFeeEditPage.in?" + params.join("&"));
					})
				</script>
			</k:access>
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
			</div>
		</div>
	</c:if>
	</form:form>
	<%@ include file="/common/foot.jsp"%>
</body>
</html>