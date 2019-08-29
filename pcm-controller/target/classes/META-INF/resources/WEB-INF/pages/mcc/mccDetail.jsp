<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
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
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="mcc.detail.title" text="MCC参数管理明细" /></title>
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
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px;padding-right: 40px" modelAttribute="mcc">
		<div class="form-group row">
			<!-- 接入卡组织 -->
			<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
				<spring:message code="mcc.inputSource" text="接入卡组织" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle">
				${inputSource}
			</label>
			<!-- 国际组织MCC代码 -->
			<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
				<spring:message code="mcc.mcc" text="国际组织MCC代码" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> 
				${mcc.mcc }	
			</label>
		<!-- </div>				
		<div class="form-group row"> -->
			<!-- MCC大类 -->
			<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
				<spring:message code="mcc.mccType" text="MCC大类" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle">
				${mcc.mccType }	
			</label>
			<!-- 描述 -->
			<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
				<spring:message code="mcc.description" text="描述" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle"> 
				${mcc.description }	
			</label>
		</div>				
		<div class="form-controls">
			<div class="btn-group-sm">
			<k:access code="mcc_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updateMcc" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updateMcc").click(function(){
						var params = [];
						params.push("inputSource=${mcc.inputSource }");
						params.push("mcc=${mcc.mcc }");
						$K.frame.reloadSlideInner("${ctx}/mcc/mccEditPage.in?" + params.join("&"));
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