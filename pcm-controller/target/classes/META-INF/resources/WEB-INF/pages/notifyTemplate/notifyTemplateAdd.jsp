<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="notifyTemplate.add.title"
		text="通知模板管理新增" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
<style type="text/css">
label.control-label {
	margin-top: 10px;
}

label.detailStyle {
	font-weight: 700;
	margin-top: 10px;
	text-align: left;
}

@media ( max-width : 768px) {
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
	<form:form cssClass="form-horizontal" id="notifyTemplateAddForm"
		cssStyle="padding-top: 40px;padding-right: 100px"
		modelAttribute="notifyTemplate" method="post"
		action="${ctx}/notifyTemplate/addNotifyTemplate.in"
		data-confirm="true">
		<div class="form-group row">
			<!-- 通知代码 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<span class="span-icon">*&nbsp;</span> <spring:message
					code="notifyTemplate.notifyCode" text="通知代码" /> :
			</label>
			<div class="col-lg-2 col-md-3 col-sm-6 col-xs-6"
				style="margin-top: 8px;">
				<form:input cssClass="form-control" path="notifyCode"
					data-rule-required="true" data-rule-maxlength="80" />
			</div>
			<!-- 通知名称 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="notifyTemplate.noticeName" text="通知名称" /> :
			</label>
			<div class="col-lg-2 col-md-3 col-sm-6 col-xs-6"
				style="margin-top: 8px;">
				<form:input cssClass="form-control" path="noticeName"
					data-rule-maxlength="80" />
			</div>
			<!-- 通知代码描述 -->
			<div class="hide remark">
				<spring:message code="notifyTemplate.notifyCode.desc" />
			</div>
			<!-- 合作机构 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="notifyTemplate.cooperationChannel" text="合作机构" />
				:
			</label>
			<div class="col-lg-2 col-md-3 col-sm-6 col-xs-6"
				style="margin-top: 8px;">
				<form:input cssClass="form-control" path="cooperationChannel"
					data-rule-maxlength="80" />
			</div>
			<!-- 合作机构描述 -->
			<div class="hide remark">
				<spring:message code="notifyTemplate.cooperationChannel.desc" />
			</div>
			<!-- </div>
		<div class="form-group row"> -->
			<!-- 发送地址 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<span class="span-icon">*&nbsp;</span> <spring:message
					code="notifyTemplate.sendUrl" text="发送地址" /> :
			</label>
			<div class="col-lg-2 col-md-3 col-sm-6 col-xs-6"
				style="margin-top: 8px;">
				<form:input cssClass="form-control" path="sendUrl"
					data-rule-required="true" data-rule-maxlength="80" />
			</div>
			<!-- 发送地址描述 -->
			<div class="hide remark">
				<spring:message code="notifyTemplate.sendUrl.desc" />
			</div>
			<!-- 报文类型 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<span class="span-icon">*&nbsp;</span> <spring:message
					code="notifyTemplate.messageType" text="报文类型" /> :
			</label>
			<div class="col-lg-2 col-md-3 col-sm-6 col-xs-6"
				style="margin-top: 8px;">
				<form:select cssClass="form-control" path="messageType">
					<form:options items="${messageType}" />
				</form:select>
			</div>
			<!-- 报文类型描述 -->
			<div class="hide remark">
				<spring:message code="notifyTemplate.messageType.desc" />
			</div>
			<!-- </div>
		<div class="form-group row"> -->
			<!-- 重发时间间隔 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<span class="span-icon" id='reDate'>*&nbsp;</span> <spring:message
					code="notifyTemplate.repeatInterval" text="重发时间间隔" /> :
			</label>
			<div class="col-lg-2 col-md-3 col-sm-6 col-xs-6"
				style="margin-top: 8px;">
				<form:input cssClass="form-control" path="repeatInterval"
					data-rule-required="true" data-rule-digits="true" data-rule-min="0"
					data-rule-max="99999" />
			</div>
			<!-- 重发时间间隔描述 -->
			<div class="hide remark">
				<spring:message code="notifyTemplate.repeatInterval.desc" />
			</div>
			<!-- </div>
		<div class="form-group row"> -->
			<!-- 重发次数上限 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<span class="span-icon" id='reCount'>*&nbsp;</span> <spring:message
					code="notifyTemplate.maxRepeat" text="重发次数上限" /> :
			</label>
			<div class="col-lg-2 col-md-3 col-sm-6 col-xs-6"
				style="margin-top: 8px;">
				<form:input cssClass="form-control" path="maxRepeat"
					data-rule-required="true" data-rule-digits="true" data-rule-min="0"
					data-rule-max="99999" />
			</div>
			<!-- 重发次数上限描述 -->
			<div class="hide remark">
				<spring:message code="notifyTemplate.maxRepeat.desc" />
			</div>
			<!-- 发送延时时间 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="notifyTemplate.sendTimeLapse" text="发送延时时间" />
				:
			</label>
			<div class="col-lg-2 col-md-3 col-sm-6 col-xs-6"
				style="margin-top: 8px;">
				<form:input cssClass="form-control" path="sendTimeLapse"
					data-rule-digits="true" data-rule-min="0" data-rule-max="99999" />
			</div>
			<!-- 发送延时时间描述 -->
			<div class="hide remark">
				<spring:message code="notifyTemplate.sendTimeLapse.desc" />
			</div>
			<!-- </div>
		<div class="form-group row"> -->
			<!-- 传输协议 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<span class="span-icon">*&nbsp;</span> <spring:message
					code="notifyTemplate.transportProtocol" text="传输协议" /> :
			</label>
			<div class="col-lg-2 col-md-3 col-sm-6 col-xs-6"
				style="margin-top: 8px;">
				<form:select cssClass="form-control" path="transportProtocol">
					<form:options items="${transportProtocol}" />
				</form:select>
			</div>
			<!-- 传输协议描述 -->
			<div class="hide remark">
				<spring:message code="notifyTemplate.transportProtocol.desc" />
			</div>
			<!-- 响应码 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="notifyTemplate.respCode" text="响应码" /> :
			</label>
			<div class="col-lg-2 col-md-3 col-sm-6 col-xs-6"
				style="margin-top: 8px;">
				<form:input cssClass="form-control" path="respCode"
					data-rule-maxlength="1200" />
			</div>
			<!-- 响应码描述 -->
			<div class="hide remark">
				<spring:message code="notifyTemplate.respCode.desc" />
			</div>
			<!-- </div>
		<div class="form-group row"> -->
			<!-- 响应值 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="notifyTemplate.respValue" text="响应值" /> :
			</label>
			<div class="col-lg-2 col-md-3 col-sm-6 col-xs-6"
				style="margin-top: 8px;">
				<form:input cssClass="form-control" path="respValue"
					data-rule-maxlength="80" />
			</div>
			<!-- 响应值描述 -->
			<div class="hide remark">
				<spring:message code="notifyTemplate.respValue.desc" />
			</div>
			<!-- 通知名称描述 -->
			<div class="hide remark">
				<spring:message code="notifyTemplate.noticeName.desc" />
			</div>
			<!-- </div>
		<div class="form-group row"> -->
			<!-- 请求类型 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="notifyTemplate.requestType" text="请求类型" /> :
			</label>
			<div class="col-lg-2 col-md-3 col-sm-6 col-xs-6"
				style="margin-top: 8px;">
				<form:select cssClass="form-control" path="requestType">
					<form:options items="${requestType}" />
				</form:select>
			</div>
			<!-- 请求类型描述 -->
			<div class="hide remark">
				<spring:message code="notifyTemplate.requestType.desc" />
			</div>
			<!-- </div>
		<div class="form-group row"> -->
			<!-- 报文长度位数 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="notifyTemplate.lengthSize" text="报文长度位数" /> :
			</label>
			<div class="col-lg-2 col-md-3 col-sm-6 col-xs-6"
				style="margin-top: 8px;">
				<form:input cssClass="form-control" path="lengthSize"
					data-rule-maxlength="8" />
			</div>
			<!-- 报文长度位数描述 -->
			<div class="hide remark">
				<spring:message code="notifyTemplate.lengthSize.desc" />
			</div>

			<!-- 是否需要重发 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<span class="span-icon">*&nbsp;</span> <spring:message
					code="notifyTemplate.isRepeat" text="是否需要重发" /> :
			</label>
			<div class="col-lg-2 col-md-3 col-sm-6 col-xs-6"
				style="margin-top: 20px;">
				<input id="isRepeat" type="checkbox" class="js-switch" unchecked />
				<form:hidden path="isRepeat" value="N" />
			</div>
			<!-- 包含请求头 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<span class="span-icon">*&nbsp;</span> <spring:message
					code="notifyTemplate.isHeaders" text="包含请求头" /> :
			</label>
			<div class="col-lg-2 col-md-3 col-sm-6 col-xs-6"
				style="margin-top: 20px;">
				<input id="isHeaders" type="checkbox" class="js-switch" unchecked />
				<form:hidden path="isHeaders" value="N" />
			</div>
			<!-- 包含请求头描述 -->
			<div class="hide remark">
				<spring:message code="notifyTemplate.isHeaders.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 通知模板 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<span class="span-icon">*&nbsp;</span> <spring:message
					code="notifyTemplate.notifyTemplate" text="通知模板" /> :
			</label>
			<div class="col-lg-10 col-md-9 col-sm-6 col-xs-6"
				style="margin-top: 8px;">
				<form:textarea cssClass='form-control noresize'
					path="notifyTemplate" rows="5" data-rule-required="true" />
			</div>
			<!-- 通知模板描述 -->
			<div class="hide remark">
				<spring:message code="notifyTemplate.notifyTemplate.desc" />
			</div>
		</div>
		<div class="form-controls auto-float">
			<div class="btn-group-md ">
				<!-- 确定 -->
				<input type="submit" class="btn-primary btn"
					value="<spring:message code='kite.web.common.btnSure' text='确定' />" />
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out"
					value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
			</div>
		</div>
	</form:form>
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp"%>
	<script type="text/javascript">
		//开启表单验证
		$("#notifyTemplateAddForm").validate();
		$(".js-switch").each(
				function(i, ck) {
					$(this).change(
							function() {
								if ($(this).is(":checked")) {
									$(this).parent().find('input[type=hidden]')
											.val('Y');
								} else {
									$(this).parent().find('input[type=hidden]')
											.val('N');
								}
								//如果当前选择的是是否需要重发
								if ($(this).is(":checked")
										&& $(this).attr("id") == 'isRepeat') {
									$("#reDate").show();
									$("#repeatInterval").data("rule-required",
											true)
									$("#reCount").hide();
									$("#maxRepeat")
											.data("rule-required", false)
								} else if ($(this).attr("id") == 'isRepeat') {
									defaultShow();
								}
							});

				});
		function defaultShow() {
			$("#reDate").hide();
			$("#repeatInterval").data("rule-required", false)
			$("#reCount").show();
			$("#maxRepeat").data("rule-required", true)
		}
	</script>
</body>
</html>