<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="notifyTemplate.detail.title" text="通知模板管理明细" /></title>
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
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="notifyTemplate">
		<div class="form-group row">
			<!-- 通知代码 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="notifyTemplate.notifyCode" text="通知代码" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 detailStyle">
				&nbsp;${notifyTemplate.notifyCode }	
			</label>
			<!-- 合作机构 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="notifyTemplate.cooperationChannel" text="合作机构" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 detailStyle">
				&nbsp;${notifyTemplate.cooperationChannel }	
			</label>
			<!-- 发送地址 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="notifyTemplate.sendUrl" text="发送地址" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 detailStyle">
				&nbsp;${notifyTemplate.sendUrl }	
			</label>
			<!-- 报文类型 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="notifyTemplate.messageType" text="报文类型" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 detailStyle">
				&nbsp;${notifyTemplate.messageType}
			</label>
			<!-- 是否需要重发 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="notifyTemplate.isRepeat" text="是否需要重发" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 detailStyle">
					&nbsp;${isRepeat}
			</label>
			<!-- 重发时间间隔 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="notifyTemplate.repeatInterval" text="重发时间间隔" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 detailStyle">
				&nbsp;${notifyTemplate.repeatInterval }	
			</label>
			<!-- 重发次数上限 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="notifyTemplate.maxRepeat" text="重发次数上限" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 detailStyle">
				&nbsp;${notifyTemplate.maxRepeat }	
			</label>
			<!-- 发送延时时间 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="notifyTemplate.sendTimeLapse" text="发送延时时间" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 detailStyle">
				&nbsp;${notifyTemplate.sendTimeLapse}	
			</label>
			<!-- 传输协议 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="notifyTemplate.transportProtocol" text="传输协议" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 detailStyle">
				&nbsp;${notifyTemplate.transportProtocol}
			</label>
			<!-- 响应码 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="notifyTemplate.respCode" text="响应码" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 detailStyle">
				&nbsp;${notifyTemplate.respCode }	
			</label>
			<!-- 响应值 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="notifyTemplate.respValue" text="响应值" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 detailStyle">
				&nbsp;${notifyTemplate.respValue }	
			</label>
			<!-- 通知名称 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="notifyTemplate.noticeName" text="通知名称" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 detailStyle">
				&nbsp;${notifyTemplate.noticeName }	
			</label>
			<!-- 包含请求头 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="notifyTemplate.isHeaders" text="包含请求头" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 detailStyle">
				&nbsp;${isHeaders}	
			</label>
		</div>
		<div class="form-group row">
			<!-- 通知模板 -->
			<label class="col-lg-2 col-md-3 col-sm-6 col-xs-6 control-label">
				<spring:message code="notifyTemplate.notifyTemplate" text="通知模板" />
				:
			</label>
			<label class="col-lg-10 col-md-9 col-sm-6 col-xs-6 detailStyle">
				&nbsp;${notifyTemplate.notifyTemplate}	
			</label>
		</div>
		<c:if test="${!factory }">
		<div class="form-controls auto-float">
			<div class="btn-group-sm">
			<k:access code="notifyTemplate_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updateNotifyTemplate" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updateNotifyTemplate").click(function(){
						var params = [];
						params.push("notifyCode=${notifyTemplate.notifyCode }");
						$K.frame.reloadSlideInner("${ctx}/notifyTemplate/notifyTemplateEditPage.in?" + params.join("&"));
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
	 <script type="text/javascript">
	$(".js-switch").each(function(i, ck) {
		var value= $(this).parent().find('input[type=hidden]').val();
		if (value == "Y") {
			$(this).attr("checked", "checked");
		}
	});
	</script> 
	
</body>
</html>