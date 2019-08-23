<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="productUnits.detail.title" text="产品页面组件表明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="tmProductUnits">
		<div class="form-group row">
			<!-- 分组编码 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="tmProductUnits.groupCode" text="分组编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${tmProductUnits.groupCode }	
			</label>
			<!-- 产品组件编码 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="tmProductUnits.unitCode" text="产品组件编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${tmProductUnits.unitCode }	
			</label>
			<!-- 二级组件 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="tmProductUnits.subUnit" text="二级组件" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${tmProductUnits.subUnit }	
			</label>
			<!-- 关联产品组件 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="tmProductUnits.updateUnits" text="关联组件" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${tmProductUnits.updateUnits }	
			</label>
			<!-- 组件配置窗口 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="tmProductUnits.unitConfig" text="组件配置窗口" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${tmProductUnits.unitConfig }	
			</label>
			<!-- 产品组件名称 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="tmProductUnits.unitName" text="产品组件名称" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${tmProductUnits.unitName }	
			</label>
			<!-- 产品组件国际化名称 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="tmProductUnits.unitNameCn" text="产品组件国际化名称" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${tmProductUnits.unitNameCn }	
			</label>
			<!-- 产品组件序号 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="tmProductUnits.unitIndex" text="产品组件序号" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${tmProductUnits.unitIndex }	
			</label>
			<!-- <!-- 必配组件 
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="tmProductUnits.unitRequired" text="必配组件" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;<input id="unitRequired" type="checkbox" class="js-switch sel" unchecked /> 
				 <form:hidden path="unitRequired"/>
			</label> -->
			<!-- 产品组件 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
			<spring:message code="tmProductUnits.unitModule" text="产品组件" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${unitModule }	
			</label>
			<!-- 创建时间 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="tmProductUnits.createTime" text="创建时间" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${tmProductUnits.createTime }	
			</label>
			<!-- 创建人 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="tmProductUnits.createUser" text="创建人" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${tmProductUnits.createUser }	
			</label>
			<!-- 修改时间 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="tmProductUnits.lstUpdTime" text="修改时间" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${tmProductUnits.lstUpdTime }	
			</label>
			<!-- 修改人 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="tmProductUnits.lstUpdUser" text="修改人" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${tmProductUnits.lstUpdUser }	
			</label>
		</div>
		<div class="form-controls">
			<div class="btn-group-sm">
			<k:access code="productUnits_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updateTmProductUnits" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updateTmProductUnits").click(function(){
						var params = [];
						params.push("id=${tmProductUnits.id }");
						$K.frame.reloadSlideInner("${ctx}/productUnits/productUnitsEditPage.in?" + params.join("&"));
					})
				</script>
			</k:access>
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
			</div>
		</div>
	</form:form>
	<%@ include file="/common/foot.jsp"%>
</body>
<script type="text/javascript">
	$('.sel').each(function(i, ck) {
		$(this).click(function() {
		return false;
	});
});
	bindfun(".sel","Y","N");
	function bindfun(classStyle,cheVal,uncheVal){
		$(classStyle).each(function(i, ck) {
		//給開發賦值
		var value=$(this).parent().find('input[type=hidden]').val();
		if(value=="Y"){
			$(this).attr("checked","checked");
		}
	});
}
</script>
</html>