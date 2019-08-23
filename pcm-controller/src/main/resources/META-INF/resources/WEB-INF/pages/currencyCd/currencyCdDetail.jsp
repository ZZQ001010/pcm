<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="currencyCd.detail.title" text="货币代码管理明细" /></title>
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
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="currencyCd">
		 <div class="form-group row">
			<!-- 数字代码 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="currencyCd.currencyCd" text="数字代码" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 detailStyle">
				&nbsp;${currencyCd.currencyCd }	
			</label>
		<!-- </div>
		<div class="form-group row"> -->
			<!-- 英文代码 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="currencyCd.alphaCd" text="英文代码" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 detailStyle">
				&nbsp;${currencyCd.alphaCd }	
			</label>
		<!-- </div>
		<div class="form-group row"> -->
			<!-- 兑换汇率 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="currencyCd.conversionRt" text="兑换汇率" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 detailStyle">
				&nbsp;${currencyCd.conversionRt }	
			</label>
		<!-- </div>
		<div class="form-group row"> -->
			<!-- 小数位数 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="currencyCd.exponent" text="小数位数" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 detailStyle">
				&nbsp;${currencyCd.exponent }	
			</label>
		<!-- </div>
		<div class="form-group row"> -->
			<!-- 描述 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="currencyCd.description" text="描述" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 detailStyle">
				&nbsp;${currencyCd.description }	
			</label>
		</div>
		<div class="form-controls auto-float">
			<div class="btn-group-sm">
			<k:access code="currencyCd_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updateCurrencyCd" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updateCurrencyCd").click(function(){
						var params = [];
						params.push("currencyCd=${currencyCd.currencyCd }");
						$K.frame.reloadSlideInner("${ctx}/currencyCd/currencyCdEditPage.in?" + params.join("&"));
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