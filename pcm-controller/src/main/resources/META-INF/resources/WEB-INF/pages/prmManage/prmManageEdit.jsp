<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="prmManage.update.title" text="参数管理页面
修改" /></title>
<%@ include file="/common/head.jsp"%>
</head>
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="prmManageUpdForm" cssStyle="padding-top: 40px" modelAttribute="prmManage" method="post" action="${ctx}/prmManage/updPrmManage.in" data-confirm="true">
		<form:hidden path="id" />
		<div class="form-group row">
			<!-- 资金方管控描述 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="prmManage.name" text="参数名称" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="name"  data-rule-required="true" data-rule-maxlength="12" />
			</div>
			<!-- 资金方管控描述描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="prmManage.name.desc" />
			</div>
		</div>
        <div class="form-group row">
            <!-- 资产方 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <span class="span-icon">*&nbsp;</span>
                <spring:message code="prmManage.desc" text="参数描述" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:input cssClass="form-control" type="text" path="desc"  data-rule-required="true" data-rule-maxlength="12" />
            </div>
            <!-- 资产方描述 -->
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
                <spring:message code="prmManage.desc.desc" />
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
		$("#prmManageUpdForm").validate();
	</script>
</body>
</html>