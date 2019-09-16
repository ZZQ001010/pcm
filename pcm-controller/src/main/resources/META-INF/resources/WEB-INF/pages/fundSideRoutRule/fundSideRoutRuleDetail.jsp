<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="fundSideRoutRule.detail.title" text="资产方路由规则明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="fundSideRoutRule">
		<div class="form-group row">
			<!-- 资金方路由编码 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideRoutRule.fundSideRoutCode" text="资金方路由编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${fundSideRoutRule.fundSideRoutCode }	
			</label>
			<!-- 资金方路由描述 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideRoutRule.fundSIdeRoutDesc" text="资金方路由描述" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideRoutRule.fundSIdeRoutDesc }	
			</label>
			<!-- 路由规则编码 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideRoutRule.routRuleCode" text="路由规则编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideRoutRule.routRuleCode }	
			</label>
		</div>
		<c:if test="${factory }">
		<div class="form-controls auto-float">
			<div class="btn-group-sm">
			<k:access code="fundSideRoutRule_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updateFundSideRoutRule" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updateFundSideRoutRule").click(function(){
						var params = [];
						params.push("fundSideRoutCode=${fundSideRoutRule.fundSideRoutCode }");
						$K.frame.reloadSlideInner("${ctx}/fundSideRoutRule/fundSideRoutRuleEditPage.in?" + params.join("&"));
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