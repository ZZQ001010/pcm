<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title><spring:message code="productUnits.detail.title" text="产品页面组件表明细" /></title>
		<!-- 引入css样式和部分js -->
		<%@ include file="/common/head.jsp"%>
		<link type="text/css" rel="stylesheet" href="${ctxStatic}/css/associatedSelector.css" />
	</head>
	
	<!-- 整体皮肤样式 -->
	<body class="${param.skin}">
		<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="bPcmProductUnit">
			<div class="form-group row">
				<%-- 隐藏的关联选择器的原始下拉 --%>
				<form:select cssClass="form-control hide" path="unitModule" data-rule-required="true" disabled="true" >
					<option value=""><spring:message code="kite.web.common.pleaseChoose" /></option>
					<form:options items="${unitModule}" />
				</form:select>
				
				<!-- 产品组件名称 -->
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
					<spring:message code="pcmProductUnit.unitCode" text="产品组件编码" />:
				</label>
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
					&nbsp;${bPcmProductUnit.unitCode}	
				</label>
				<!-- 产品组件名称 -->
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
					<spring:message code="pcmProductUnit.unitName" text="产品组件国际化名称" />:
				</label>
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
					&nbsp;${bPcmProductUnit.unitName}	
				</label>
				<!-- 产品组件国际化名称 -->
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
					<spring:message code="pcmProductUnit.unitNameCn" text="产品组件中文名称" />:
				</label>
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
					&nbsp;${bPcmProductUnit.unitNameCn}	
				</label>
				<!-- 产品组件类型 -->
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
					<spring:message code="pcmProductUnit.unitModule" text="产品组件类型" />:
				</label>
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
					&nbsp;${unitModuleStr}
				</label>
				<!-- 允许多选 -->
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
					<spring:message code="pcmProductUnit.multiple" text="允许多选" />:
				</label>
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
					&nbsp;${mltipleStr}
				</label>
				<!-- 产品组件序号 -->
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
					<spring:message code="pcmProductUnit.unitIndex" text="产品组件序号" />:
				</label>
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
					&nbsp;${bPcmProductUnit.unitIndex}	
				</label>
				<!-- 创建时间 -->
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
					<spring:message code="pcmProductUnit.createTime" text="创建时间" />:
				</label>
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
					<fmt:formatDate var="createTimeFmt" value="${bPcmProductUnit.createTime}" type="date" pattern="yyyy-MM-dd hh:mm:ss" />
					${createTimeFmt}
				</label>
				<!-- 创建人 -->
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
					<spring:message code="pcmProductUnit.createUser" text="创建人" />:
				</label>
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
					&nbsp;${bPcmProductUnit.createUser}	
				</label>
				<!-- 最后更新时间 -->
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
					<spring:message code="pcmProductUnit.lstUpdTime" text="最后更新时间" />:
				</label>
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
					<fmt:formatDate var="lstUpdTimeFmt" value="${bPcmProductUnit.lstUpdTime}" type="date" pattern="yyyy-MM-dd hh:mm:ss" />
					${lstUpdTimeFmt}
				</label>
				<!-- 最后更新人 -->
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
					<spring:message code="pcmProductUnit.lstUpdUser" text="最后更新人" />:
				</label>
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
					&nbsp;${bPcmProductUnit.lstUpdUser}	
				</label>
				<!-- 关联组件 -->
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
					<spring:message code="pcmProductUnit.unitRelations" text="关联组件" />:
				</label>
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
					<div id="unit_rel_div"></div>
				</div>
			</div>
			<div class="form-controls auto-float">
				<div class="btn-group-sm">
					<k:access code="productUnit_edit">
						<!--修改 -->
						<input type="button" class="btn-info btn" id="updateTmProductUnit" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
					</k:access>
					<!-- 返回 -->
					<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
				</div>
			</div>
		</form:form>
	</body>
	
	<%@ include file="/common/foot.jsp"%>
	<script type="text/javascript" src="${ctxStatic}/js/associatedSelector.js"></script>
	<script type="text/javascript">
		// 关联选择器初始化
		var ascSlt = new AssociatedSelector({
			select: $("#unitModule"),
			units: ${units},
			target: $('#unit_rel_div'),
			emptyShow: '<spring:message code="kite.web.common.pleaseChoose" />',
			optionKey: lang_current === lang_zh_CN ? 'unitNameCn' : 'unitName',
			data: JSON.parse('${unitRelations}'),
			readOnly: true
		});
	</script>
	<k:access code="productUnit_edit">
		<script type="text/javascript">
			$("#updateTmProductUnit").click(function() {
				var params = [];
				params.push("id=${bPcmProductUnit.id}");
				$K.frame.reloadSlideInner("${ctx}/productUnit/productUnitEditPage.in?" + params.join("&"));
			});
		</script>
	</k:access>
</html>