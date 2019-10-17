<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="channelParameterInfo.detail.title" text="渠道参数信息明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="channelParameterInfo">
		<div class="form-group row">
			<!-- 渠道编码 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="channelParameterInfo.channelCode" text="渠道编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${channelParameterInfo.channelCode }	
			</label>
			<!-- 渠道名称 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="channelParameterInfo.channelName" text="渠道名称" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${channelParameterInfo.channelName }
			</label>
            <!-- 渠道归属类型 -->
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
                <spring:message code="channelParameterInfo.channelAttributionType" text="保费率" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
                &nbsp;${channelAttributionType }
            </label>
            <!-- 渠道归属-->
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
                <spring:message code="channelParameterInfo.channelAttribution" text="保费缴纳方式" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
                &nbsp;${channelAttribution }
            </label>
		</div>
	<c:if test="${factory==false }">
		<div class="form-controls auto-float">
			<div class="btn-group-sm">
			<k:access code="channelParameterInfo_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updatechannelParameterInfo" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updatechannelParameterInfo").click(function(){
						var params = [];
						params.push("code=${channelParameterInfo.channelCode }");
						$K.frame.reloadSlideInner("${ctx}/channelParameterInfo/channelParameterInfoEditPage.in?" + params.join("&"));
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