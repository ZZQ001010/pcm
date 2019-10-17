<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="organization.detail.title" text="机构参数管理明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="organization">
		<div class="form-group row">
			<!-- 支付渠道 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="organization.paymentChannel" text="支付渠道" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${organization.paymentChannel }	
			</label>
			<!-- 征信金融机构 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="organization.creditInstitutions" text="征信金融机构" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${organization.creditInstitutions }	
			</label>
			<!-- 人行征信报送类型 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="organization.pbocType" text="人行征信报送类型" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${organization.pbocType }	
			</label>
			<!-- 默认分行号 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="organization.defaultBranchNo" text="默认分行号" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${organization.defaultBranchNo }	
			</label>
			<!-- 发送短信机构号 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="organization.smsToOrg" text="发送短信机构号" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${organization.smsToOrg }	
			</label>
			<!-- 实时入账标志 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="organization.bookingOnlineFlag" text="放款实时入账标志" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${organization.bookingOnlineFlag }	
			</label>
            <!-- 实时入账标志 -->
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
                <spring:message code="organization.repayBookingOnlineFlag" text="还款实时入账标志" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
                &nbsp;${organization.repayBookingOnlineFlag }
            </label>
			<!-- 基准货币代码 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="organization.baseCurrCd" text="基准货币代码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${organization.baseCurrCd }	
			</label>
			<!-- 最大授信额度 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="organization.maxCreditLimit" text="最大授信额度" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${organization.maxCreditLimit }	
			</label>
			<!-- 超限免息标识 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="organization.overlimitDeferInd" text="超限免息标识" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${organization.overlimitDeferInd }	
			</label>
			<!-- 未全额还款免息标识 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="organization.nofullpayDeferInd" text="未全额还款免息标识" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${organization.nofullpayDeferInd }	
			</label>
			<!-- 溢缴款信用计划号 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="organization.depositPlanNbr" text="溢缴款信用计划号" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${organization.depositPlanNbr }	
			</label>
			<!-- 临额最大有效月数 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="organization.tempLimitMaxMths" text="临额最大有效月数" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${organization.tempLimitMaxMths }	
			</label>
			<!-- 利息按信用计划入账 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="organization.intPostOnPlan" text="利息按信用计划入账" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${organization.intPostOnPlan }	
			</label>
			<!-- 还款日调整区间内可调整次数 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="organization.adjStmtCount" text="还款日调整区间内可调整次数" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${organization.adjStmtCount }	
			</label>
			<!-- 还款日调整区间（月） -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="organization.adjStmtMonth" text="还款日调整区间（月）" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${organization.adjStmtMonth }	
			</label>
		</div>
		
		<%-- <div class="form-controls">
			<div class="btn-group-sm">
			<k:access code="organization_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updateOrganization" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updateOrganization").click(function(){
						var params = [];
						params.push("baseCurrCd=${organization.baseCurrCd }");
						$K.frame.reloadSlideInner("${ctx}/organization/organizationEditPage.in?" + params.join("&"));
					})
				</script>
			</k:access>
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
			</div>
		</div> --%>
	</form:form>
	<%@ include file="/common/foot.jsp"%>
</body>
</html>