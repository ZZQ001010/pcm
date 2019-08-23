<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="split.detail.title" text="扣款拆分明细" /></title>
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
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px;padding-right: 40px" modelAttribute="split">
		<div class="form-group row">
			<!-- 拆分表id -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="split.splitTableId" text="拆分表id" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6  detailStyle">
				${split.splitTableId }	
			</label>
			<!-- 拆分名称 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="split.splitName" text="拆分名称" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6  detailStyle"> 
				${split.splitName }	
			</label>
			<!-- 拆分方式 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="split.splitMethod" text="拆分方式" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6  detailStyle">
				${splitMethod}
			</label>
			<!-- 拆分比例 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="split.splitRate" text="拆分比例" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6  detailStyle"> 
				${split.splitRate }	
			</label>
			
			<!-- 可拆分最小金额 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="split.splitMinAMT" text="可拆分最小金额" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6  detailStyle"> 
				${split.splitMinAMT }	
			</label>
			<!-- 拆分后金额排序 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="split.splitAmtSort" text="拆分后金额排序" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6  detailStyle">
				${splitAmtSort}
			</label>
			<!-- 拆份固定金额 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="split.splitAMT" text="拆份固定金额" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6  detailStyle">
				${split.splitAMT }	
			</label>
		</div>
		<div class="form-controls">
			<div class="btn-group-sm">
			<k:access code="split_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updateSplit" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updateSplit").click(function(){
						var params = [];
						params.push("splitTableId=${split.splitTableId }");
						$K.frame.reloadSlideInner("${ctx}/split/splitEditPage.in?" + params.join("&"));
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