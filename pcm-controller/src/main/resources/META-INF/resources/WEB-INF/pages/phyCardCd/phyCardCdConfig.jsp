<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="phyCardCd.add.title" text="卡面代码参数新增" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form class="form-horizontal form-product">
		<!-- 配置参数 -->
		<div class="form-group row">
			<!-- 超限费信息编码 -->
			<label class="col-lg-4 col-md-4 col-sm-4  col-xs-4 control-label">
				<spring:message code="phyCardCd.pyhCd" text="卡面代码" />:
			</label>
			<div class="col-lg-6 col-md-6 col-sm-6  col-xs-6">
				<select class='form-control' name='productCode' id='productCode'>
					<c:forEach var='code' items='${phyCardCodes }'>
						<option value='${code.pyhCd }' <c:if test='${code.pyhCd eq productCode }'>selected='selected'</c:if>>${code.description }</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</form>
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp"%>
	<script>
	</script>
</body>
</html>