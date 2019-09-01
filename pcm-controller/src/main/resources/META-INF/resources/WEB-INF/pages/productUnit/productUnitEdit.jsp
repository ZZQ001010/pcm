<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title><spring:message code="productUnits.add.title" text="产品页面组件表新增" /></title>
		<!-- 引入css样式和部分js -->
		<%@ include file="/common/head.jsp"%>
		<link type="text/css" rel="stylesheet" href="${ctxStatic}/css/associatedSelector.css" />
	</head>
	
	<!-- 整体皮肤样式 -->
	<body class="${param.skin}">
		<!-- data-confirm=true 提交前需要确认 -->
		<form:form cssClass="form-horizontal" id="pcmProductUnitEditForm" cssStyle="padding-top: 40px" modelAttribute="bPcmProductUnit" method="post" action="${ctx}/productUnit/addProductUnit.in" data-confirm="true">
			<form:hidden path="id"/>
			<form:hidden path="productType"/>
			
			<div class="form-group row">
				<!-- 产品组件 -->
				<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
					<span class="span-icon">*&nbsp;</span>
					<spring:message code="pcmProductUnit.unitModule" text="产品组件类型 " />
					:
				</label>
				<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
					<form:select cssClass="form-control" path="unitModule" data-rule-required="true" disabled="true" >
						<option value=""><spring:message code="kite.web.common.pleaseChoose" /></option>
						<form:options items="${unitModule}" />
					</form:select>
				</div>
				<!-- 产品组件描述 -->
				<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
					<spring:message code="pcmProductUnit.unitModule.desc" />
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
					<span class="span-icon">*&nbsp;</span>
					<spring:message code="pcmProductUnit.unitCode" text="产品组件编码 " />
					:
				</label>
				<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
					<form:input cssClass="form-control" type="text" path="unitCode" data-rule-required="true" data-rule-maxlength="32" readonly="true" />
				</div>
				<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
					<spring:message code="pcmProductUnit.unitCode.desc" />
				</div>
			</div>
			
			<%-- <div class="form-group row">
				<!-- 关联组件 -->
				<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
					<spring:message code="pcmProductUnit.updateUnits" text="关联组件" />
					:
				</label>
				<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
					<form:select cssClass="form-control" path="updateUnits" multiple="multiple">
						<!-- <option value=""><spring:message code="kite.web.common.pleaseChoose" /></option> -->
						<form:options items="${updateUnits}" />
					</form:select>
				</div>
				<!-- 关联组件描述  -->
				<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
					<spring:message code="pcmProductUnit.updateUnits.desc" />
				</div>
			</div> --%>
			
			<%-- <div class="form-group row">
				<!-- 组件配置窗口 -->
				<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
					<spring:message code="pcmProductUnit.unitConfig" text="组件配置窗口" />
					:
				</label>
				<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
					<form:select cssClass="form-control" path="unitConfig">
						<option value=""><spring:message code="kite.web.common.pleaseChoose" /></option>
						<form:options items="${unitConfig}" />
					</form:select>
				</div>
				<!-- 组件配置窗口描述  -->
				<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
					<spring:message code="pcmProductUnit.unitConfig.desc" />
				</div>
			</div> --%>
			
			<div class="form-group row">
				<!-- 产品组件国际化名称 -->
				<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
					<span class="span-icon">*&nbsp;</span>
					<spring:message code="pcmProductUnit.unitName" text="产品组件国际化名称" />
					:
				</label>
				<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
					<form:input cssClass="form-control" type="text" path="unitName"  data-rule-required="true" data-rule-maxlength="200" />
				</div>
				<!-- 产品组件国际化名称描述 -->
				<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
					<spring:message code="pcmProductUnit.unitName.desc" />
				</div>
			</div>
			<div class="form-group row">
				<!-- 产品组件中文名称 -->
				<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
					<span class="span-icon">*&nbsp;</span>
					<spring:message code="pcmProductUnit.unitNameCn" text="产品组件中文名称" />
					:
				</label>
				<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
					<form:input cssClass="form-control" type="text" path="unitNameCn"  data-rule-required="true" data-rule-maxlength="200" />
				</div>
				<!-- 产品组件中文名称描述 -->
				<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
					<spring:message code="pcmProductUnit.unitNameCn.desc" />
				</div>
			</div>
			<div class="form-group row">
				<!-- 产品组件序号 -->
				<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
					<span class="span-icon">*&nbsp;</span>
					<spring:message code="pcmProductUnit.unitIndex" text="产品组件序号" />
					:
				</label>
				<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
					<form:input cssClass="form-control" type="number" min="0" max="2147483647" path="unitIndex"  data-rule-required="true" data-rule-maxlength="2" data-rule-digits="true" />
				</div>
				<!-- 产品组件序号描述 -->
				<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
					<spring:message code="pcmProductUnit.unitIndex.desc" />
				</div>
			</div>
			
			<div class="form-group row">
				<!-- 是否多选 -->
				<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
					<spring:message code="pcmProductUnit.multiple" text="允许多选 " />
					:
				</label>
				<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
					<form:select cssClass="form-control" path="multiple">
						<option value=""><spring:message code="kite.web.common.pleaseChoose" /></option>
						<form:options items="${indicator}" />
					</form:select>
				</div>
				<!-- 产品组件描述 -->
				<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
					<spring:message code="pcmProductUnit.multiple.desc" />
				</div>
			</div>
	
			<%-- 关联组件联动下拉 --%>
			<div class="form-group row">
				<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
					<spring:message code="pcmProductUnit.unitRelations" text="关联组件" />:
				</label>
				<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
					<div id="unit_rel_div"></div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
					<spring:message code="pcmProductUnit.unitRelations.desc" />
				</div>
			</div>
			<div class="form-controls auto-float">
				<div class="cbtn-group-md">
					<!-- 确定 -->
					<input type="button" class="btn-primary btn" id="productUnitEditBtn" value="<spring:message code='kite.web.common.btnSure' text='确定' />" />
					<!-- 返回 -->
					<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
				</div>
			</div>
		</form:form>
	</body>
	
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp"%>
	<script type="text/javascript" src="${ctxStatic}/js/associatedSelector.js"></script>
	<script type="text/javascript">
		// 开启表单验证
		$("#pcmProductUnitEditForm").validate();
		var units = JSON.parse('${units}');
		
		// 关联选择器初始化
		var ascSlt = new AssociatedSelector({
			select: $("#unitModule"),
			units: units,
			target: $('#unit_rel_div'),
			emptyShow: '<spring:message code="kite.web.common.pleaseChoose" />',
			optionKey: lang_current === lang_zh_CN ? 'unitNameCn' : 'unitName',
			data: JSON.parse('${unitRelations}'),
			halfReadOnly: true
		});
		
		// 选中后添加默认的placeholder
		$("#unitModule").change(function() {
			let unit = units[this.value];
			if (unit) {
				$("#unitCode").attr('placeholder', unit.unitCode);
				$("#unitName").attr('placeholder', unit.unitName);
				$("#unitNameCn").attr('placeholder', unit.unitNameCn);
			} else {
				$("#unitCode").attr('placeholder', '');
				$("#unitName").attr('placeholder', '');
				$("#unitNameCn").attr('placeholder', '');
			}
		});
		
		// 提交
		$("#productUnitEditBtn").on('click', function() {
			if ($("#pcmProductUnitEditForm").valid()) {
				let dataMap = $('#pcmProductUnitEditForm').getFormData();
				dataMap['unitRelations'] = $K.JSON.stringify(ascSlt.getValidAssemble());
				$K.ajax({
					url: '${ctx}/productUnit/updProductUnit.in',
					type: 'post',
					data: dataMap,
					success: function() {
						layer.msg('<spring:message code="kite.web.common.operateSuccess" text="操作成功" />');
						$('.only-slide-out').click();
					}
				});
			}
		});
	</script>
</html>