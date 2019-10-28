<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="assetSideRiskCtrl.update.title" text="资产方风险管理修改" /></title>
<%@ include file="/common/head.jsp"%>
</head>
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="assetSideRiskCtrlUpdForm" cssStyle="padding-top: 40px" modelAttribute="assetSideRiskCtrl" method="post" action="${ctx}/assetSideRiskCtrl/updAssetSideRiskCtrl.in" data-confirm="true">
		<form:hidden path="aId" />
		
		<div class="form-group row">
			<!-- 风管方式 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="assetSideRiskCtrl.riskCtrlWays" text="风管方式" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="riskCtrlWays" data-rule-required="true">
					<form:options items="${riskCtrlWays}" />
				</form:select>
			</div>
			<!-- 风管方式描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="assetSideRiskCtrl.riskCtrlWays.desc" />
			</div>
		</div>	
		
		
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="margin-left: 20px">
				<h2><spring:message code="assetSideRiskCtrl.marginCtrl.title" text="保证金管理"/> </h2>
				<hr>
			</div>	
			
					
		<div class="form-group row">
			<!-- 保证金基数 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">&nbsp;</span>
				<spring:message code="assetSideRiskCtrl.marginBase" text="保证金基数" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="marginBase">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${marginBase}" />
				</form:select>
			</div>
			<!-- 保证金基数描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="assetSideRiskCtrl.marginBase.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 保证金比例 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="assetSideRiskCtrl.marginProportion" text="保证金比例" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="marginProportion"  data-rule-maxlength="12" />
			</div>
			<!-- 保证金比例描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="assetSideRiskCtrl.marginProportion.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 保证金预警比例 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="assetSideRiskCtrl.marginWarningProportion" text="保证金预警比例" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="marginWarningProportion"  data-rule-maxlength="12" />
			</div>
			<!-- 保证金预警比例描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="assetSideRiskCtrl.marginWarningProportion.desc" />
			</div>
		</div>
		
		<div class="form-group row">
			<!-- 描述 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="assetSideRiskCtrl.desc" text="描述" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:textarea cssClass="form-control"  path="desc" data-rule-required="true" data-rule-maxlength="50" />
			</div>
			<!-- 描述描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="assetSideRiskCtrl.desc.desc" />
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
		$("#assetSideRiskCtrlUpdForm").validate();
	</script>
</body>
</html>