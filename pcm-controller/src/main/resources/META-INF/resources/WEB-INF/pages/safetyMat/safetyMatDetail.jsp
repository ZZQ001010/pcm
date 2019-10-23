<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="safetyMat.detail.title" text="安全垫明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="safetyMat">
		<div class="form-group row">
			<!-- 编码 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="safetyMat.code" text="编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${safetyMat.code }	
			</label>
			<!-- 描述 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="safetyMat.desc" text="描述" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${safetyMat.desc }	
			</label>
			<!-- 费用收取方式 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="safetyMat.feeCollectionMethod" text="费用收取方式" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${feeCollectionMethod}
			</label>
			<!-- 费用收取基础 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="safetyMat.feeBasis" text="费用收取基础" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${feeBasis}
			</label>
			<!-- 费用收取频次 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="safetyMat.frequencyOfCharge" text="费用收取频次" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${frequencyOfCharge}
			</label>
			<!-- 收取比例 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="safetyMat.chargeRatio" text="收取比例" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${safetyMat.chargeRatio }	
			</label>
			
			
			<!-- 所属机构 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="safetyMat.organization" text="所属机构" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${org }	
			</label>
			
			<!-- 资产方 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="safetyMat.asset" text="资产方" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${assetSideInfo }	
			</label>
			
			<!-- 安全垫下限控制方式 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="safetyMat.controlMode" text="安全垫下限控制方式" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${controlMode }	
			</label>
			
			<!-- 安全垫下限控制比例 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="safetyMat.controlRatio" text="安全垫下限控制比例" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${safetyMat.controlRatio }	
			</label>
			
			<!-- 安全垫下限控制金额 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="safetyMat.controlMoney" text="安全垫下限控制比例" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${safetyMat.controlMoney }	
			</label>
			
			<!-- 技术服务费收取方式  -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="safetyMat.chargeWay" text="技术服务费收取方式 " />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${chargeWay }	
			</label>
			
			<!--技术服务费收取基础  -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="safetyMat.chargeBasics" text="技术服务费收取基础 " />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${chargeBasics }	
			</label>
			
			<!-- 转出账号 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="safetyMat.transferAccount" text="转出账号" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${safetyMat.transferAccount }	
			</label>
			<!-- 转入账号 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="safetyMat.transferToAccount" text="转入账号" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${safetyMat.transferToAccount }	
			</label>
			<!-- 结算周期 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="safetyMat.billingCycle" text="结算周期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${billingCycle}
			</label>
								 <!-- 结算日期 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="safetyMat.balanceDate" text="结算日期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${safetyMat.balanceDate}
			</label>
			<!-- 起始结算逾期周期 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="safetyMat.period" text="起始结算逾期周期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${billingCycle }	
			</label>
			<!-- 起始结算逾期周期数量 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="safetyMat.periodNum" text="起始结算逾期周期数量" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${safetyMat.periodNum }	
			</label>
			<!-- 保费垫付是否参与分润 -->
			<%--<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">--%>
				<%--<spring:message code="" text="保费垫付是否参与分润" />--%>
				<%--:--%>
			<%--</label>--%>
			<%--<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">--%>
				<%--&nbsp;${participationStatus }	--%>
			</label>
			
			
						<!-- 费用累计月天数-->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="" text="费用累计月天数" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${expenses }	
			</label>
			
			
												<!-- 结算信息-->
<!-- 			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"> -->
<!-- 				<spring:message code="fundSideServiceFee.settleAccounts" text="结算信息" /> -->
<!-- 				: -->
<!-- 			</label> -->
<!-- 			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle"> -->
<%-- 				&nbsp;${safetyMat.settleAccounts}	 --%>
<!-- 			</label> -->
			
			
						<!-- 放款当天提前还款手续费方式 -->
			<%--<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">--%>
				<%--<spring:message code="" text="放款当天提前还款手续费方式" />--%>
				<%--:--%>
			<%--</label>--%>
			<%--<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">--%>
				<%--&nbsp;${backsettlement }	--%>
			<%--</label>--%>
			
			
			<%-- 			<!-- 放款当天提前结清手续费方式 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="" text="放款当天提前结清手续费方式" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${settlement }	
			</label> --%>
		</div>
		
		<c:if test="${factory}">
		<div class="form-controls auto-float">
			<div class="btn-group-sm">
			<k:access code="safetyMat_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updatesafetyMat" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updatesafetyMat").click(function(){
						var params = [];
						params.push("code=${safetyMat.code }");
						$K.frame.reloadSlideInner("${ctx}/safetyMat/safetyMatEditPage.in?" + params.join("&"));
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