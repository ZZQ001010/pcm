<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="phyCardCd.detail.title" text="卡面代码参数明细" /></title>
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
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px;padding-right: 40px" modelAttribute="phyCardCd">
		<div class="form-group row">
			<!-- 卡面代码 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="phyCardCd.pyhCd" text="卡面代码" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 detailStyle">
				&nbsp;${phyCardCd.pyhCd }	
			</label>
			<!-- 描述 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="phyCardCd.description" text="描述" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 detailStyle">
				&nbsp;${phyCardCd.description }	
			</label>
			<!-- 卡面制卡文件 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="phyCardCd.embossFileName" text="卡面制卡文件" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 detailStyle">
				&nbsp;${phyCardCd.embossFileName }	
			</label>
			<!-- 卡面介质类型 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="phyCardCd.mediaType" text="卡面介质类型" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 detailStyle">
				&nbsp;${mediaType}
			</label>
		</div>
		<div class="form-controls auto-float">
			<div class="btn-group-sm">
			<k:access code="phyCardCd_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updatePhyCardCd" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updatePhyCardCd").click(function(){
						var params = [];
						params.push("pyhCd=${phyCardCd.pyhCd }");
						$K.frame.reloadSlideInner("${ctx}/phyCardCd/phyCardCdEditPage.in?" + params.join("&"));
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