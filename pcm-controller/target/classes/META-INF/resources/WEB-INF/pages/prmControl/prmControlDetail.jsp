<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="prmControl.detail.title" text="参数管控明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
<style type="text/css">
label.detailStyle {
    font-weight: 700;
    margin-top: 10px;
    text-align: left;
}
@media (max-width: 768px) {
	.form-horizontal .control-label {
	    text-align: right !important;
	}
	.form-product .control-label {
		text-align: right !important;
	}
}
</style>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px;padding-right: 40px" modelAttribute="tmPrmControl">
		<div class="form-group row">
			<!-- 受控参数 -->
			<label class="col-lg-2 col-md-2 col-sm-3 col-xs-6 control-label">
				<spring:message code="tmPrmControl.paramClass" text="受控参数" />
				:
			</label>
			<label class="col-lg-2 col-md-2 col-sm-3 col-xs-6  detailStyle">
				&nbsp;${tmPrmControl.paramClass }	
			</label>
			<!-- 参数名称 -->
			<label class="col-lg-2 col-md-2 col-sm-3 col-xs-6 control-label">
				<spring:message code="tmPrmControl.paramClassLabel" text="参数名称" />
				:
			</label>
			<label class="col-lg-2 col-md-2 col-sm-3 col-xs-6  detailStyle"> 
				&nbsp;${tmPrmControl.paramClassLabel }	
			</label>
		<!-- </div>				
		<div class="form-group row"> -->
			
			<!-- 属性名称 -->
			<label class="col-lg-2 col-md-2 col-sm-3 col-xs-6 control-label">
				<spring:message code="tmPrmControl.paramFieldLabel" text="属性名称" />
				:
			</label>
			<label class="col-lg-2 col-md-2 col-sm-3 col-xs-6  detailStyle"> 
				&nbsp;${tmPrmControl.paramFieldLabel }	
			</label>
		<!-- </div>				
		<div class="form-group row"> -->
			<!-- 最小值 -->
			<label class="col-lg-2 col-md-2 col-sm-3 col-xs-6 control-label">
				<spring:message code="tmPrmControl.minValue" text="最小值" />
				:
			</label>
			<label class="col-lg-2 col-md-2 col-sm-3 col-xs-6  detailStyle">
				&nbsp;${tmPrmControl.minValue }	
			</label>
			<!-- 最大值 -->
			<label class="col-lg-2 col-md-2 col-sm-3 col-xs-6 control-label">
				<spring:message code="tmPrmControl.maxValue" text="最大值" />
				:
			</label>
			<label class="col-lg-2 col-md-2 col-sm-3 col-xs-6  detailStyle"> 
				&nbsp;${tmPrmControl.maxValue }	
			</label>
			<!-- 参数属性 -->
			<label class="col-lg-2 col-md-2 col-sm-3 col-xs-6 control-label">
				<spring:message code="tmPrmControl.paramField" text="参数属性" />
				:
			</label>
			<label class="col-lg-2 col-md-2 col-sm-3 col-xs-6  detailStyle" style="word-break:break-all; word-wrap:break-all;">
				&nbsp;${tmPrmControl.paramField }	
			</label>
		</div>				
		<div class="form-controls">
			<div class="btn-group-sm">
			<k:access code="paramContrDetail">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updateTmPrmControl" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updateTmPrmControl").click(function(){
						var params = [];
						params.push("id=${tmPrmControl.id }");
						$K.frame.reloadSlideInner("${ctx}/prmControl/prmControlEditPage.in?" + params.join("&"));
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