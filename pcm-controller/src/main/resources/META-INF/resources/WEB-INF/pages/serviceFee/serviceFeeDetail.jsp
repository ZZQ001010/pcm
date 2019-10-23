<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="serviceFee.detail.title" text="服务方服务费明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="serviceFee">
		<div class="form-group row">
			<!-- 服务方服务费编码 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serviceFee.serviceFeeNo" text="服务方服务费编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${serviceFee.serviceFeeNo }	
			</label>
			<!-- 服务方服务费描述 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serviceFee.serviceFeeDesc" text="服务方服务费描述" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${serviceFee.serviceFeeDesc }	
			</label>
			<!-- 费用收取方式 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serviceFee.feeCollectionMethod" text="费用收取方式" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${feeCollectionMethod }	
			</label>
			<!-- 费用收取基础 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serviceFee.feeBasis" text="费用收取基础" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${feeBasis }	
			</label>
			<!-- 费用收取频次 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serviceFee.frequencyOfCharge" text="费用收取频次" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${frequencyOfCharge }	
			</label>
			<!-- 收取比例 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serviceFee.chargeRatio" text="收取比例" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${serviceFee.chargeRatio }	
			</label>
			<!-- 收取金额 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serviceFee.chargeAmount" text="收取金额" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${serviceFee.chargeAmount }	
			</label>
			<!-- 所属机构 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serviceFee.organization" text="所属机构" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${org}	
			</label>
			<!-- 合作方类型 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serviceFee.partnerType" text="合作方类型" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${partnerType }	
			</label>
			<!-- 合作方编码 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serviceFee.partnerCode" text="合作方编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${partner}	
			</label>
			<!-- 转出账号 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serviceFee.transferAccount" text="转出账号" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${serviceFee.transferAccount }	
			</label>
			<!-- 转入账号 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serviceFee.transferToAccount" text="转入账号" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${serviceFee.transferToAccount }	
			</label>
			<!-- 结算周期 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serviceFee.billingCycle" text="结算周期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${billingCycle }	
			</label>
			
			<!-- 结算日期 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serviceFee.balanceDate" text="结算日期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${serviceFee.balanceDate}
			</label>
			
			
													<!-- 结算信息-->
<!-- 			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"> -->
<!-- 				<spring:message code="fundSideServiceFee.settleAccounts" text="结算信息" /> -->
<!-- 				: -->
<!-- 			</label> -->
<!-- 			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle"> -->
<%-- 				&nbsp;${serviceFee.settleAccounts}	 --%>
<!-- 			</label> -->
		</div>
		<div class="form-controls auto-float">
			<div class="btn-group-sm">
			<k:access code="serviceFee_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updateServiceFee" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updateServiceFee").click(function(){
						var params = [];
						params.push("serviceFeeNo=${serviceFee.serviceFeeNo }");
						$K.frame.reloadSlideInner("${ctx}/serviceFee/serviceFeeEditPage.in?" + params.join("&"));
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