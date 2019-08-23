<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="split.update.title" text="扣款拆分修改" /></title>
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
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="splitUpdForm" cssStyle="padding-top: 40px;padding-right: 40px" modelAttribute="split" method="post" action="${ctx}/split/updSplit.in" data-confirm="true">
		<form:hidden path="splitTableId" />
		<div class="form-group row">
			<!-- 拆分表id -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="split.splitTableId" text="拆分表id" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="splitTableId"  data-rule-required="true" data-rule-maxlength="6" readonly="true"/>
			</div>
			<!-- 拆分表id描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="split.splitTableId.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 拆分名称 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="split.splitName" text="拆分名称" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="splitName"  data-rule-required="true" data-rule-maxlength="6" />
			</div>
			<!-- 拆分名称描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="split.splitName.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 拆分方式 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="split.splitMethod" text="拆分方式" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="splitMethod">				
					<form:options items="${splitMethod}" />
				</form:select>
			</div>
			<!-- 拆分方式描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="split.splitMethod.desc" />
			</div>
		</div>				
		<div class="form-group row" id="splitRate">
			<!-- 拆分比例 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="split.splitRate" text="拆分比例" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="splitRate"  data-rule-required="true" data-rule-number="true" data-rule-min="0" data-rule-max="99.9999" id="method_1"/>
			</div>
			<!-- 拆分比例描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="split.splitRate.desc" />
			</div>
		</div>				
		<div class="form-group row" id="splitAMT">
			<!-- 拆份固定金额 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="split.splitAMT" text="拆份固定金额" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="splitAMT"  data-rule-required="true" data-rule-number="true" data-rule-min="0" data-rule-max="9999999999999.99" id="method_2"/>
			</div>
			<!-- 拆份固定金额描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="split.splitAMT.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 可拆分最小金额 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="split.splitMinAMT" text="可拆分最小金额" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="splitMinAMT"  data-rule-number="true" data-rule-min="0" data-rule-max="9999999999999.99" />
			</div>
			<!-- 可拆分最小金额描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="split.splitMinAMT.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 拆分后金额排序 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="split.splitAmtSort" text="拆分后金额排序" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="splitAmtSort">
					<form:options items="${splitAmtSort}" />
				</form:select>
			</div>
			<!-- 拆分后金额排序描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="split.splitAmtSort.desc" />
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
	<script>
		//开启表单验证
		$("#splitUpdForm").validate();
	</script>
	
	
	<script type="text/javascript">
		if ($("#splitMethod").val() == 'A') {
			$("#splitAMT").hide();
			$("#splitRate").show();
		} else if ($("#splitMethod").val() == 'B') {
			$("#splitAMT").show();
			$("#splitRate").hide();
		} 	
		$("#splitMethod").change(function(){
			if (this.value == 'A') {
				$("#splitAMT").hide();
				$("#splitRate").show();
			} else if (this.value == 'B') {
				$("#splitAMT").show();
				$("#splitRate").hide();
			}
		});

	</script>
</body>

</html>