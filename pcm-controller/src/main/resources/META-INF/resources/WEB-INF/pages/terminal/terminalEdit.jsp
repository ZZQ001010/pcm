<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="terminal.update.title" text="终端类型维护修改" /></title>
<%@ include file="/common/head.jsp"%>
</head>
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="terminalUpdForm" cssStyle="padding-top: 40px" modelAttribute="terminal" method="post" action="${ctx}/terminal/updTerminal.in" data-confirm="true">
		<form:hidden path="terminalId" />
		<div class="form-group row">
			<!-- 终端描述 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="terminal.terminalDesc" text="终端描述" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="terminalDesc"  data-rule-maxlength="100" />
			</div>
			<!-- 终端描述描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="terminal.terminalDesc.desc" />
			</div>
		</div>				
		<div class="form-controls">
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
	<script>
		//开启表单验证
		$("#terminalUpdForm").validate();
	</script>
</body>

</html>