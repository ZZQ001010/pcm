<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="productGroup.update.title" text="产品页面分组表修改" /></title>
<%@ include file="/common/head.jsp"%>
</head>
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="tmProductGroupUpdForm" cssStyle="padding-top: 40px" modelAttribute="tmProductGroup" method="post" action="${ctx}/productUnits/updProductGroup.in" data-confirm="true">
		<form:hidden path="id" />
		<form:hidden path="productType" />
		<form:hidden path="productParentId"/>
		<div class="form-group row">
			<!--  分组编码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="tmProductGroup.groupCode" text="分组编码" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input readonly="true" cssClass="form-control" type="text" path="groupCode"  data-rule-required="true" data-rule-maxlength="200" />
			</div>
			<!-- 分组编码描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="tmProductGroup.groupCode.desc" />
			</div>
		</div>
		
		<div class="form-group row">
			<!-- 分组中文名称 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="tmProductGroup.groupNameCn" text="分组中文名称" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="name"  data-rule-required="true" data-rule-maxlength="200" />
			</div>
			<!-- 分组中文名称描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="tmProductGroup.groupNameCn.desc" />
			</div>
		</div>
		
		
		<div class="form-group row">
			<!-- 分组国际化名称 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="tmProductGroup.groupName" text="分组中文名称" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="groupName"  data-rule-required="true" data-rule-maxlength="200" />
			</div>
			<!-- 分组中文名称描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="tmProductGroup.groupName.desc" />
			</div>
		</div>
		
		
		<div class="form-group row">
			<!-- 分组序号  -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="tmProductGroup.groupIndex" text="分组序号 " />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="number" path="groupIndex"  data-rule-required="true" data-rule-maxlength="2" data-rule-digits="true" />
			</div>
			<!-- 分组序号 描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="tmProductGroup.groupIndex.desc" />
			</div>			
		<div class="form-controls hide">
			<div class="cbtn-group-md">
				<!-- 确定 -->
				<input type="submit" id='submit' class="btn-primary btn" value="<spring:message code='kite.web.common.btnSure' text='确定' />" />
			</div>
		</div>						
	</form:form>
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp"%>
	<script>
		//开启表单验证
		$("#tmProductGroupUpdForm").validate();
	</script>
</body>

</html>