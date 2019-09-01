<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="terminal.detail.title" text="终端类型维护明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="terminal">
		<div class="form-group row">
			<!-- 终端类型ID -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="terminal.terminalId" text="终端类型ID" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3  detailStyle">
				${terminal.terminalId }	
			</label>
			<!-- 终端描述 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="terminal.terminalDesc" text="终端描述" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3  detailStyle"> 
				${terminal.terminalDesc }	
			</label>
		</div>				
		<div class="form-controls">
			<div class="btn-group-sm">
			<k:access code="terminal_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updateTerminal" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updateTerminal").click(function(){
						var params = [];
						params.push("terminalId=${terminal.terminalId }");
						$K.frame.reloadSlideInner("${ctx}/terminal/terminalEditPage.in?" + params.join("&"));
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