<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="channelServiceFee.detail.title" text="渠道方服务费明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="channelServiceFee">
		<div class="form-group row">
			<!-- 渠道方服务费编码 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelServiceFee.channelServiceCode" text="渠道方服务费编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${channelServiceFee.channelServiceCode }	
			</label>
			<!-- 渠道方服务费描述 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelServiceFee.channelServiceDesc" text="渠道方服务费描述" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${channelServiceFee.channelServiceDesc }	
			</label>
			<!-- 费用收取方式 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelServiceFee.feeCollectionMethod" text="费用收取方式" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${feeCollectionMethod}
			</label>
			<!-- 费用收取基础 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelServiceFee.feeBasis" text="费用收取基础" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${feeBasis}
			</label>
			<!-- 费用收取频次 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelServiceFee.frequencyOfCharge" text="费用收取频次" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${frequencyOfCharge}
			</label>
			<!-- 收取比例 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelServiceFee.chargeRatio" text="收取比例" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${channelServiceFee.chargeRatio }	
			</label>
			<!-- 收取金额 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelServiceFee.chargeAmount" text="收取金额" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${channelServiceFee.chargeAmount }	
			</label>
			<!-- 所属机构 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelServiceFee.organization" text="所属机构" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${org }	
			</label>
			<!-- 合作方类型 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelServiceFee.partnerType" text="合作方类型" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${partnerType}
			</label>
			<!-- 合作方编码 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelServiceFee.partnerCode" text="合作方编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${partner }	
			</label>
			<!-- 转出账号 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelServiceFee.transferAccount" text="转出账号" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${channelServiceFee.transferAccount }	
			</label>
			<!-- 转入账号 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelServiceFee.transferToAccount" text="转入账号" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${channelServiceFee.transferToAccount }	
			</label>
			<!-- 结算周期 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelServiceFee.billingCycle" text="结算周期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${billingCycle}
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
			<k:access code="channelServiceFee_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updateChannelServiceFee" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updateChannelServiceFee").click(function(){
						var params = [];
						params.push("channelServiceCode=${channelServiceFee.channelServiceCode }");
						$K.frame.reloadSlideInner("${ctx}/channelServiceFee/channelServiceFeeEditPage.in?" + params.join("&"));
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