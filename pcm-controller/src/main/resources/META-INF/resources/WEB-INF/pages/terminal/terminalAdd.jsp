<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="terminal.add.title" text="终端类型维护新增" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="terminalAddForm" cssStyle="padding-top: 40px" modelAttribute="terminal" method="post" action="${ctx}/terminal/addTerminal.in" data-confirm="true">
		<div class="form-group row">
			<!-- 终端类型ID -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="terminal.terminalId" text="终端类型ID" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="terminalId"  data-rule-maxlength="20" />
			</div>
			<!-- 终端类型ID描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="terminal.terminalId.desc" />
			</div>
		</div>
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
			<div class="cbtn-group-md">
				<!-- 确定 -->
				<input type="submit" class="btn-primary btn" value="<spring:message code='kite.web.common.btnSure' text='确定' />" />
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
			</div>
		</div>
	</form:form>
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp"%>
	<script>
		//开启表单验证
		$("#terminalAddForm").validate();
	</script>
</body>
</html>