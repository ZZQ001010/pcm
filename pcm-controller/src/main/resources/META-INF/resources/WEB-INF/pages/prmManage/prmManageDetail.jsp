<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="prmManage.detail.title" text="参数管理页面
明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="prmManage">
		<div class="form-group row">
			<!-- 资金方管控编码 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="prmManage.id" text="参数编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${prmManage.id }
			</label>
			<!-- 资金方管控描述 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="prmManage.name" text="参数名称" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${prmManage.name }
			</label>
            <!-- 资金方 -->
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
                <spring:message code="prmManage.desc" text="参数描述" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
                &nbsp;${prmManage.desc}
            </label>
		</div>
	<c:if test="${factory==false }">
		<div class="form-controls auto-float">
			<div class="btn-group-sm">
			<k:access code="prmManage_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updatePrmManage" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updatePrmManage").click(function(){
						var params = [];
						params.push("id=${prmManage.id }");
						$K.frame.reloadSlideInner("${ctx}/prmManage/prmManageEditPage.in?" + params.join("&"));
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