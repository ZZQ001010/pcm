<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>${systemTitle}</title>
		<%@ include file="/common/head.jsp"%>
		<link rel="stylesheet" type="text/css" href="${ctxStatic}/css/kite.home.common.css" />
		<link rel="stylesheet" type="text/css" href="${ctxStatic}/css/kite.home.partition.css"/>
	</head>
	
	<body class="${param.skin}">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<div class="widget">
				<div class="widget-header">
					<i class="fa fa-list-alt"></i>
					<h3><spring:message code="kite.web.home.overview" /></h3>
				</div>
				<div class="widget-content overview-content" style="min-height:385px;">
					<img alt="" style="width:90%" src="${ctx}/img/home.default.png">
					<%-- <div style="height:385px;background-image:url('${ctx}/img/home.default.png');background-size: cover;"></div> --%>
					<div class="clearfix"></div>
					
				</div>
			</div>
		</div>
	</body>
	
	<%@ include file="/common/foot.jsp"%>
</html>