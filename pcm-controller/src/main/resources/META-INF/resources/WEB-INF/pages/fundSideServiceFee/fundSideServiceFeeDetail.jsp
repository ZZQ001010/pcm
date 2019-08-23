<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="fundSideServiceFee.detail.title" text="资金方技术服务费明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="fundSideServiceFee">
		<div class="form-group row">
			<!-- 技术服务编码 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideServiceFee.skillcode" text="技术服务编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideServiceFee.skillcode }	
			</label>
			<!-- 技术服务描述 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideServiceFee.skillDesc" text="技术服务描述" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideServiceFee.skillDesc }	
			</label>
			<!-- 费用收取方式 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideServiceFee.feeCollectionMethod" text="费用收取方式" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${feeCollectionMethod}
			</label>
			<!-- 费用收取基础 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideServiceFee.feeBasis" text="费用收取基础" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${feeBasis}
			</label>
			<!-- 费用收取频次 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideServiceFee.frequencyOfCharge" text="费用收取频次" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${frequencyOfCharge}
			</label>
			<!-- 收取比例 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideServiceFee.chargeRatio" text="收取比例" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideServiceFee.chargeRatio }	
			</label>
			<!-- 所属机构 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideServiceFee.organization" text="所属机构" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${organization }	
			</label>
			<!-- 资金方 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideServiceFee.capital" text="资金方" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${capital }	
			</label>
			<!-- 资金方平台服务方 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideServiceFee.platformService" text="资金方平台服务方" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSeverSide }	
			</label>
			<!-- 转出账号 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideServiceFee.transferAccount" text="转出账号" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideServiceFee.transferAccount }	
			</label>
			<!-- 转入账号 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideServiceFee.transferToAccount" text="转入账号" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideServiceFee.transferToAccount }	
			</label>
			<!-- 结算周期 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideServiceFee.billingCycle" text="结算周期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${billingCycle}
			</label>
			
						<!-- 结算日期 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideServiceFee.balanceDate" text="结算日期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideServiceFee.balanceDate}	
			</label>
			
												<!-- 提前还款手续费方式 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideServiceFee.settlement" text="提前还款手续费方式" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${settlement }	
			</label>

		</div>
		<c:if test="${!factory }">
		<div class="form-controls auto-float">
			<div class="btn-group-sm">
			<k:access code="fundSideServiceFee_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updateFundSideServiceFee" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updateFundSideServiceFee").click(function(){
						var params = [];
						params.push("skillcode=${fundSideServiceFee.skillcode }");
						$K.frame.reloadSlideInner("${ctx}/fundSideServiceFee/fundSideServiceFeeEditPage.in?" + params.join("&"));
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