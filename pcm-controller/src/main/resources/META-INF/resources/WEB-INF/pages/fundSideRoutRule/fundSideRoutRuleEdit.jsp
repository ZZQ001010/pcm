<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="fundSideRoutRule.update.title" text="资产方路由规则修改" /></title>
<%@ include file="/common/head.jsp"%>
</head>
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="fundSideRoutRuleUpdForm" cssStyle="padding-top: 40px" modelAttribute="fundSideRoutRule" method="post" action="${ctx}/fundSideRoutRule/updFundSideRoutRule.in" data-confirm="true">
		<div class="form-group row">
			<!-- 资金方路由编码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="fundSideRoutRule.fundSideRoutCode" text="资金方路由编码" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="fundSideRoutCode"  data-rule-required="true" data-rule-maxlength="32" />
			</div>
			<!-- 资金方路由编码描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="fundSideRoutRule.fundSideRoutCode.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 资金方路由描述 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="fundSideRoutRule.fundSIdeRoutDesc" text="资金方路由描述" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="fundSIdeRoutDesc"  data-rule-required="true" data-rule-maxlength="200" />
			</div>
			<!-- 资金方路由描述描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="fundSideRoutRule.fundSIdeRoutDesc.desc" />
			</div>
		</div>
		
		 
		<div class="form-group row">
			<!-- 路由规则编码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="fundSideRoutRule.routRuleCode" text="路由规则编码" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="routRuleCode"  data-rule-required="true" data-rule-maxlength="200" />
			</div>
			<!-- 路由规则编码描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="fundSideRoutRule.routRuleCode.desc" />
			</div>
		</div>			
		
		
		
		<div class="form-controls auto-float">
			<div class="btn-group-md">
				<!-- 确定 -->
				<input type="submit" class="btn-primary btn" value="<spring:message code='kite.web.common.btnSure' text='确定' />" />
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='取消' />" />
			</div>
		</div>
	</form:form>
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp"%>
	<script type="text/javascript">
		//开启表单验证
		$("#fundSideRoutRuleUpdForm").validate();
	</script>
</body>
</html>