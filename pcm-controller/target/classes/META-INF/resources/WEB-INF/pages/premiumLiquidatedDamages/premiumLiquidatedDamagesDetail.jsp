<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="premiumLiquidatedDamages.detail.title" text="提前还款保费收取方式明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="premiumLiquidatedDamages">
		<div class="form-group row">
			<!-- 编码 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="premiumLiquidatedDamages.code" text="费用编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${premiumLiquidatedDamages.code }	
			</label>
			<!-- 描述 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="premiumLiquidatedDamages.desc" text="费用描述" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${premiumLiquidatedDamages.desc }	
			</label>
			<!-- 费用计算方式 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="premiumLiquidatedDamages.costCalculationMethod" text="费用收取方式" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${costCalculationMethod}
			</label>
			<!-- 当期保费是否收取 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="premiumLiquidatedDamages.whetherToCharge" text="当期保费是否收取" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${whetherToCharge }	
			</label>
			<!-- 剩余本金百分比 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="premiumLiquidatedDamages.percentageRemainingPrincipal" text="手续费率" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${premiumLiquidatedDamages.percentageRemainingPrincipal }	
			</label>
			<!-- 加收N期保费 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="premiumLiquidatedDamages.additionalNPremiums" text="加收N期保费" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${additionalNPremiums }
			</label>
			<!-- 收取固定金额 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="premiumLiquidatedDamages.chargeFixedAmount" text="收取固定金额" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${premiumLiquidatedDamages.chargeFixedAmount }	
			</label>
            <!-- 收取固定金额 -->
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
             <fmt:formatDate var="startDateFmt" value="${premiumLiquidatedDamages.startDate}" type="date" pattern="yyyy-MM-dd"/>
                <spring:message code="premiumLiquidatedDamages.startDate" text="收取起始账期" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
                &nbsp;${startDateFmt }
            </label>
            <!-- 收取固定金额 -->
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
                <spring:message code="premiumLiquidatedDamages.endDate" text="收取终止账期" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
            <fmt:formatDate var="endDateFmt" value="${premiumLiquidatedDamages.endDate}" type="date" pattern="yyyy-MM-dd"/>
                &nbsp;${endDateFmt }
            </label>
		</div>
		<div class="form-controls auto-float">
			<div class="btn-group-sm">
			<k:access code="premiumLiquidatedDamages_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updatePremiumLiquidatedDamages" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updatePremiumLiquidatedDamages").click(function(){
						var params = [];
						params.push("code=${premiumLiquidatedDamages.code }");
						$K.frame.reloadSlideInner("${ctx}/premiumLiquidatedDamages/premiumLiquidatedDamagesEditPage.in?" + params.join("&"));
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