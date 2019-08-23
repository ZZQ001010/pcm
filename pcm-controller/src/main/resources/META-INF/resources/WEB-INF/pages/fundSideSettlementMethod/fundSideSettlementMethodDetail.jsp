<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="fundSideSettlementMethod.detail.title" text="资金方理赔方式
明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="fundSideSettlementMethod">
		<div class="form-group row">
			<!-- 资金方编码 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideSettlementMethod.fundSideCode" text="资金方编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideSettlementMethod.fundSideCode }	
			</label>
			<!-- 资金方描述 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideSettlementMethod.fundSideDesc" text="资金方描述" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideSettlementMethod.fundSideDesc }	
			</label>
            <!-- 资金方 -->
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
                <spring:message code="fundSideSettlementMethod.fundSide" text="资金方" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
                &nbsp;${fundSide}
            </label>
			<!-- 理赔方式 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideSettlementMethod.fundSideInfo" text="理赔模式" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideInfo}
			</label>
			<!-- 理赔逾期天数 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideSettlementMethod.daysOverdue" text="逾期理赔等待期天数" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideSettlementMethod.daysOverdue }	
			</label>
			<!-- 全期理赔起始期数 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideSettlementMethod.otalNumberOfClaimsStartPeriods" text="全期理赔起始期数" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideSettlementMethod.otalNumberOfClaimsStartPeriods }	
			</label>
		</div>
		
	<c:if test="${factory==false }">
		<div class="form-controls auto-float">
			<div class="btn-group-sm">
			<k:access code="fundSideSettlementMethod_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updateFundSideSettlementMethod" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updateFundSideSettlementMethod").click(function(){
						var params = [];
						params.push("fundSideCode=${fundSideSettlementMethod.fundSideCode }");
						$K.frame.reloadSlideInner("${ctx}/fundSideSettlementMethod/fundSideSettlementMethodEditPage.in?" + params.join("&"));
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