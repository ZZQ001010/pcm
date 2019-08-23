<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="phyCardCd.detail.title" text="卡面代码参数明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal form-product"  modelAttribute="phyCardCd">
		<div class="form-group row">
			<!-- 卡面代码 -->
			<label class="col-lg-5 col-md-5 col-sm-5 col-xs-5 control-label">
				<spring:message code="phyCardCd.pyhCd" text="卡面代码" />
				:
			</label>
			<label class="col-lg-7 col-md-7 col-sm-7 col-xs-7 detailStyle">
				${phyCardCd.pyhCd }	
			</label>
		</div>
		<div class="form-group row">
			<!-- 描述 -->
			<label class="col-lg-5 col-md-5 col-sm-5 col-xs-5 control-label">
				<spring:message code="phyCardCd.description" text="描述" />
				:
			</label>
			<label class="col-lg-7 col-md-7 col-sm-7 col-xs-7 detailStyle">
				${phyCardCd.description }	
			</label>
		</div>
		<div class="form-group row">
			<!-- 卡面制卡文件 -->
			<label class="col-lg-5 col-md-5 col-sm-5 col-xs-5 control-label">
				<spring:message code="phyCardCd.embossFileName" text="卡面制卡文件" />
				:
			</label>
			<label class="col-lg-7 col-md-7 col-sm-7 col-xs-7 detailStyle">
				${phyCardCd.embossFileName }	
			</label>
		</div>
		<div class="form-group row">
			<!-- 卡面介质类型 -->
			<label class="col-lg-5 col-md-5 col-sm-5 col-xs-5 control-label">
				<spring:message code="phyCardCd.mediaType" text="卡面介质类型" />
				:
			</label>
			<label class="col-lg-7 col-md-7 col-sm-7 col-xs-7 detailStyle">
				${mediaType}
			</label>
		</div>
	</form:form>
	<%@ include file="/common/foot.jsp"%>
	<script type="text/javascript">

	//获取某行数据
	function getRowData(){
		return null;
	}
	</script>
</body>
</html>