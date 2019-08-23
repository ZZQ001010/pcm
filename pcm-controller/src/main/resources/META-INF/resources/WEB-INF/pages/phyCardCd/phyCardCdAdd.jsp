<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="phyCardCd.add.title" text="卡面代码参数新增" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
<style type="text/css">

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
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="phyCardCdAddForm" cssStyle="padding-top: 40px;padding-right: 40px" modelAttribute="phyCardCd" method="post" action="${ctx}/phyCardCd/addPhyCardCd.in" data-confirm="true">
		<div class="form-group row">
			<!-- 卡面代码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="phyCardCd.pyhCd" text="卡面代码" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="pyhCd"  data-rule-required="false" data-rule-maxlength="10" />
			</div>
			<!-- 卡面代码描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="phyCardCd.pyhCd.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 描述 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="phyCardCd.description" text="描述" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="description"  data-rule-required="false" data-rule-maxlength="40" />
			</div>
			<!-- 描述描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="phyCardCd.description.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 卡面制卡文件 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="phyCardCd.embossFileName" text="卡面制卡文件" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="embossFileName"  data-rule-required="false" data-rule-maxlength="40" />
			</div>
			<!-- 卡面制卡文件描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="phyCardCd.embossFileName.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 卡面介质类型 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="phyCardCd.mediaType" text="卡面介质类型" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="mediaType">
					<form:options items="${mediaType}" />
				</form:select>
			</div>
			<!-- 卡面介质类型描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="phyCardCd.mediaType.desc" />
			</div>
		</div>
		<div class="form-controls auto-float">
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
		$("#phyCardCdAddForm").validate();
	</script>
</body>
</html>