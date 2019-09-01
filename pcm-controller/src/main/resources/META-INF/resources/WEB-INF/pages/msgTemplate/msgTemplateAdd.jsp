<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="msgTemplate.add.title" text="短信模板新增" /></title>
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
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="bMPMessageTemplateAddForm" cssStyle="padding-top: 40px" modelAttribute="bMPMessageTemplate" method="post" action="${ctx}/msgTemplate/addMsgTemplate.in" data-confirm="true">
		<div class="form-group row">
			<!-- 信息代码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label ">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="bMPMessageTemplate.code" text="信息代码" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-5">
				<form:input cssClass="form-control" type="text" path="code"  data-rule-required="true" data-rule-maxlength="20" />
			</div>
			<!-- 信息代码描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-3 remark">
				<spring:message code="bMPMessageTemplate.code.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 系统类型 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label ">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="bMPMessageTemplate.systemType" text="系统类型" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-5">
				<form:select cssClass="form-control" path="systemType" >
					<form:options items="${systemType}" />
				</form:select>
			</div>
			<!-- 系统类型描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-3 remark">
				<spring:message code="bMPMessageTemplate.systemType.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 信息分类 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label ">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="bMPMessageTemplate.msgCategory" text="信息分类" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-5">
				<form:select cssClass="form-control" path="msgCategory" data-rule-required="true">
					<form:options items="${msgCategory}" />
				</form:select>
			</div>
			<!-- 信息分类描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-3 remark">
				<spring:message code="bMPMessageTemplate.msgCategory.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 发送方法 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label ">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="bMPMessageTemplate.sendingMethod" text="发送方法" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-5">
				<form:select cssClass="form-control" path="sendingMethod">
					<form:options items="${sendingMethod}" />
				</form:select>
			</div>
			<!-- 发送方法描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-3 remark">
				<spring:message code="bMPMessageTemplate.sendingMethod.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 信息描述 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label ">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="bMPMessageTemplate.desc" text="信息描述" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-5">
				<form:input cssClass="form-control" type="text" path="desc"  data-rule-required="true" data-rule-maxlength="40" />
			</div>
			<!-- 信息描述描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-3 remark">
				<spring:message code="bMPMessageTemplate.desc.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 发送起始时间 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label ">
				<spring:message code="bMPMessageTemplate.startTime" text="发送起始时间" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-5">
				<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
				<form:input class='form-control customize-datetime' type="text" data-picker-position="top-right" data-role-formate="yyyy-mm-dd" path="startTime" onfocus="this.blur()"  />
				<i class="fa fa-calendar input_date" ></i>
			</div>
			<!-- 发送起始时间描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-3 remark">
				<spring:message code="bMPMessageTemplate.startTime.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 发送结束时间 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label ">
				<spring:message code="bMPMessageTemplate.endTime" text="发送结束时间" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-5">
				<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
				<form:input class='form-control customize-datetime' type="text" data-picker-position="top-right" data-role-formate="yyyy-mm-dd" path="endTime" onfocus="this.blur()"  />
				<i class="fa fa-calendar input_date" ></i>
			</div>
			<!-- 发送结束时间描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-3 remark">
				<spring:message code="bMPMessageTemplate.endTime.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 内容模版 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label ">
				<spring:message code="bMPMessageTemplate.contentTemplate" text="内容模版" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-5">
				<form:textarea cssClass='form-control' path="contentTemplate"  rows="3"  />
			</div>
			<!-- 内容模版描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-3 remark">
				<spring:message code="bMPMessageTemplate.contentTemplate.desc" />
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
		$("#bMPMessageTemplateAddForm").validate();
	</script>
</body>
</html>