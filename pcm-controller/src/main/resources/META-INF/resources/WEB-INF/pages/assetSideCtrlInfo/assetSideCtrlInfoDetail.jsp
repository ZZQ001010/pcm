<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="assetSideCtrlInfo.detail.title" text="资产方管控信息明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="assetSideCtrlInfo">
		<div class="form-group row">
			<!-- 资产方管控编码 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideCtrlInfo.assetSideCtrlCode" text="资产方管控编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${assetSideCtrlInfo.assetSideCtrlCode }	
			</label>
			<!-- 资产方管控描述 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideCtrlInfo.assetSideCtrlDesc" text="资产方管控描述" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${assetSideCtrlInfo.assetSideCtrlDesc }	
			</label>
			<!-- 资产方编码 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideCtrlInfo.assetSideCode" text="资产方编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${assetSideCtrlInfo.assetSideCode }	
			</label>
			<!-- 资产方额度总控 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideCtrlInfo.assetSideAmountGeneralControl" text="资产方额度总控" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${assetSideCtrlInfo.assetSideAmountGeneralControl }	
			</label>
			<!-- 授信额度有效期 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideCtrlInfo.authorizationAmountUsefulLife" text="授信额度有效期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				<fmt:formatDate var="authorizationAmountUsefulLifeFmt" value="${assetSideCtrlInfo.authorizationAmountUsefulLife }" type="date" pattern="yyyy-MM-dd" />
				&nbsp;${authorizationAmountUsefulLifeFmt }
			</label>
			<!-- 资产方放款管控 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideCtrlInfo.assetSideLoanCtrl" text="资产方放款管控" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${assetSideLoanCtrl}
			</label>
			<!-- 放款额度有效期 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideCtrlInfo.loanAmountUsefulLife" text="放款额度有效期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				<fmt:formatDate var="loanAmountUsefulLifeFmt" value="${assetSideCtrlInfo.loanAmountUsefulLife }" type="date" pattern="yyyy-MM-dd" />
				&nbsp;${loanAmountUsefulLifeFmt }
			</label>
			<!-- 资产方余额总控 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideCtrlInfo.assetSideBalanceControl" text="资产方余额总控" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${assetSideCtrlInfo.assetSideBalanceControl }	
			</label>
			<!-- 余额额度有效期 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideCtrlInfo.balanceAmountUsefulLife" text="余额额度有效期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				<fmt:formatDate var="balanceAmountUsefulLifeFmt" value="${assetSideCtrlInfo.balanceAmountUsefulLife }" type="date" pattern="yyyy-MM-dd" />
				&nbsp;${balanceAmountUsefulLifeFmt }
			</label>
		</div>
	<c:if test="${factory }">
		<div class="form-controls auto-float">
			<div class="btn-group-sm">
			<k:access code="assetSideCtrlInfo_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updateAssetSideCtrlInfo" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updateAssetSideCtrlInfo").click(function(){
						var params = [];
						params.push("assetSideCtrlCode=${assetSideCtrlInfo.assetSideCtrlCode }");
						$K.frame.reloadSlideInner("${ctx}/assetSideCtrlInfo/assetSideCtrlInfoEditPage.in?" + params.join("&"));
					})
				</script>
			</k:access>
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
			</div>
		</div>
	</c:if>
	</form:form>
	<%@ include file="/common/foot.jsp"%>
</body>
</html>