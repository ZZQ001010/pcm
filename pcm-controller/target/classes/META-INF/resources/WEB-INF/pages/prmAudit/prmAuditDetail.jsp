<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="prmAudit.detail.title" text="参数变更日志明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="tmPrmAudit">
		<div class="form-group row">
			<!-- 所属机构 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="tmPrmAudit.org" text="所属机构" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3  detailStyle">
				&nbsp;${tmPrmAudit.org }	
			</label>
			<!-- 参数主键 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="tmPrmAudit.paramKey" text="参数主键" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3  detailStyle"> 
				&nbsp;${tmPrmAudit.paramKey }	
			</label>
			<!-- 参数类别 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="tmPrmAudit.paramClass" text="参数类别" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3  detailStyle">
				&nbsp;${tmPrmAudit.paramClass }	
			</label>
			<!-- 修改用户 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="tmPrmAudit.mtnUser" text="修改用户" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3  detailStyle"> 
				&nbsp;${tmPrmAudit.mtnUser }	
			</label>
			<!-- 操作 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="tmPrmAudit.paramOperation" text="操作" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3  detailStyle">
				&nbsp;${paramOperation}
			</label>
			<!-- 操作时间 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="tmPrmAudit.jpaTimestamp" text="操作时间" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3  detailStyle"> 
				<fmt:formatDate var="jpaTimestampFmt" value="${tmPrmAudit.jpaTimestamp }" type="date" pattern="yyyy-MM-dd" />
				&nbsp;${jpaTimestampFmt }
			</label>
			<!-- 原参数值 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="tmPrmAudit.oldObject" text="原参数值" />
				:
			</label>
			<label class="col-lg-9 col-md-9 col-sm-9 col-xs-9  detailStyle">
				&nbsp;${tmPrmAudit.oldObject }	
			</label>
			<!-- 新参数值 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="tmPrmAudit.newObject" text="新参数值" />
				:
			</label>
			<label class="col-lg-9 col-md-9 col-sm-9col-xs-9  detailStyle"> 
				&nbsp;${tmPrmAudit.newObject }	
			</label>
			<!-- 修改日志 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="tmPrmAudit.updateLog" text="修改日志" />
				:
			</label>
			<label class="col-lg-9 col-md-9 col-sm-9 col-xs-9 detailStyle">
				&nbsp;${tmPrmAudit.updateLog }	
			</label>
		</div>
		<div class="form-controls">
			<div class="btn-group-sm">
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
			</div>
		</div>
	</form:form>
	<%@ include file="/common/foot.jsp"%>
</body>
</html>