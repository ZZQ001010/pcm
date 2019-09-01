<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp" %>
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	    <title><spring:message code='product.productShow' text='产品展示' /></title>
	    <!-- 引入css样式和部分js -->
	    <%@ include file="/common/head.jsp" %>
	    <link type="text/css" rel="stylesheet" href="${ctxStatic}/plugins/circle.web/css/circle.css" />
	    <style type="text/css">
	    	.hs-container {
	    		padding-top: 20px;
	    	}
	    	.contentCircle {
	    		background: url(${ctxStatic}/plugins/circle.web/img/bgcircle.png) no-repeat;
	    	}
	    	.ci-item-one {
				width: 70%;
				margin: auto;
				overflow: hidden;
				text-overflow: ellipsis;
				white-space: nowrap;
	    	}
	    	.ci-item-one.pdt {
	    		height: 58.3px;
				height: calc(70% / 3);
				line-height: 58.3px;
	    	}
	    	.ci-item-one:FIRST-OF-TYPE {
				margin-top: 15%;
			}
	    	.ci-item-one:LAST-OF-TYPE {
				margin-bottom: 15%;
			}
	    </style>
	</head>
	
	<!-- 整体皮肤样式 -->
	<body class="${param.skin}">
		<div class="hs-container">
			<div class="holderCircle">
				<div class="dotCircle">
					<span class="itemDot active itemDot1" data-tab="1">
						<!-- 1- --><spring:message code="product.basicInfo" text="基本信息" />
						<span class="forActive"></span>
					</span>
					
					<c:forEach var="rel" items="${rels}" varStatus="status">
						<span class="itemDot itemDot${status.index + 2}" data-tab="${status.index + 2}">
							<%-- ${status.index + 2}- --%><c:if test="${isChinese}">${infos[rel.unitCode].unitNameCn}</c:if><c:if test="${!isChinese}">${infos[rel.unitCode].unitName}</c:if>
							<span class="forActive"></span>
						</span>
					</c:forEach>
				</div>
				<div class="contentCircle">
					<div class="CirItem active CirItem1" data-tab="1">
						<div class="ci-item-one pdt">${product.productCode}</div>
						<div class="ci-item-one pdt">${product.description}</div>
						<div class="ci-item-one pdt">${product.productType}</div>
					</div>
					
					<c:forEach var="rel" items="${rels}" varStatus="status">
						<div class="CirItem CirItem${status.index + 2}" 
							data-tab="${status.index + 2}" 
							data-unit="${infos[rel.unitCode].unitCode}" 
							data-base="${ctx}${infos[rel.unitCode].unitBaseUrl}" 
							data-code="${rel.paramKey}" >
							${status.index + 2}-${rel.unitCode}
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</body>
	
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp" %>
	<script type="text/javascript" src="${ctxStatic}/plugins/circle.web/js/circle.js"></script>
	<script type="text/javascript">
		new CircleWeb();
	</script>
</html>