<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="financialOrgProduct.detail.title" text="合作机构管理明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form class="form-horizontal form-product">
		<div class="form-group row">
			<!-- 所属金融机构 -->
			<label class="col-lg-4 col-md-4 col-sm-4  col-xs-4 control-label">
				<spring:message code="financialOrgParam.financialOrgNo" text="所属金融机构" />:
			</label>
			<div class="col-lg-6 col-md-6 col-sm-6  col-xs-6">
				<select class='form-control' name='productCode' id='productCode' >
					<c:forEach var='financeOrg' items='${financeOrgs }'>
						<option value='${financeOrg.financialOrgNO }' <c:if test='${financeOrg.financialOrgNO eq productCode }'>selected='selected'</c:if>>${financeOrg.financialOrgNO }-${financeOrg.financialOrgName }</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</form>
	
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp"%>
</body>
</html>