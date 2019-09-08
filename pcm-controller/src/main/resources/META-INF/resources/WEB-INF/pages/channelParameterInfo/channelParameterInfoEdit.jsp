<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="channelParameterInfo.update.title" text="渠道参数信息修改" /></title>
<%@ include file="/common/head.jsp"%>
</head>
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="channelParameterInfoUpdForm" cssStyle="padding-top: 40px" modelAttribute="channelParameterInfo" method="post" action="${ctx}/channelParameterInfo/updChannelParameterInfo.in" data-confirm="true">
		<form:hidden path="channelCode" />
		<div class="form-group row">
			<!-- 渠道名称 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="channelParameterInfo.channelName" text="渠道名称" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="channelName"  data-rule-required="true" data-rule-maxlength="50" />
			</div>
			<!-- 渠道名称描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="渠道名称" />
			</div>
		</div>
        <div class="form-group row">
            <!-- 渠道归属类型 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <span class="span-icon">*&nbsp;</span>
                <spring:message code="channelParameterInfo.channelAttributionType" text="渠道归属类型" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:select cssClass="form-control" path="channelAttributionType">
                    <form:options items="${channelAttributionType}" />
                </form:select>
            </div>
            <!-- 渠道归属类型描述 -->
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
                <spring:message code="渠道归属类型" />
            </div>
        </div>
		<div class="form-group row">
			<!-- 渠道归属 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="channelParameterInfo.channelAttribution" text="渠道归属" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				 <form:select cssClass="form-control" path="channelAttribution"    data-rule-required="true">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${channelAttribution}" />
				</form:select>
			</div>
			<!--渠道归属描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="渠道归属" />
			</div>
		</div>
		<div class="form-controls auto-float">
			<div class="btn-group-md">
				<!-- 确定 -->
				<input type="submit" class="btn-primary btn" value="<spring:message code='kite.web.common.btnSure' text='确定' />" />
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='取消' />" />
			</div>
		</div>
	</form:form>
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp"%>
	<script type="text/javascript">
		//开启表单验证
		$("#channelParameterInfoUpdForm").validate();
		
		$(function(){
			$('#channelAttributionType').change();
		})
		
		$('#channelAttributionType').on('change',function(){
			var type = $(this).val();
			if(type=='A'){
				appendNode(${fundSideInfoJson})
			}
			if(type=='B'){
				appendNode(${assetSideInfoJson})
			}
			if(type=='C'){
				appendNode(${channelInfoJson})
			}
			if(type=='D'){
				appendNode(${serverInfoJson})
				
			}
			if(type=='E'){
				appendNode(${orgMap})
			}
		})
		
		//追加节点
		function appendNode(map){
			$("#channelAttribution").empty();
			$("#channelAttribution").append('<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>');
			for(var key in map){
				$("#channelAttribution").append('<option value="'+key+'">'+map[key]+'</option>');
			}
			$("#channelAttribution").selectpicker("refresh");
		}
	</script>
</body>
</html>