<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="assetSideRiskCtrl.detail.title" text="资产方风险管理明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="assetSideRiskCtrl">
		<div class="form-group row">
			<!-- 风管方式 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideRiskCtrl.aId" text="编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${assetSideRiskCtrl.aId}
			</label>
			

			
			<!-- 风管方式 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideRiskCtrl.riskCtrlWays" text="风管方式" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${riskCtrlWays}
			</label>
			
			
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="margin-left: 20px">
				<h2><spring:message code="assetSideRiskCtrl.marginCtrl.title" text="保证金管理"/> </h2>
				<hr>
			</div>	
			
			
			<!-- 保证金基数 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideRiskCtrl.marginBase" text="保证金基数" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${marginBase}
			</label>
			<!-- 保证金比例 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideRiskCtrl.marginProportion" text="保证金比例" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${assetSideRiskCtrl.marginProportion }	
			</label>
			<!-- 保证金预警比例 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideRiskCtrl.marginWarningProportion" text="保证金预警比例" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${assetSideRiskCtrl.marginWarningProportion }	
			</label>
			
						<!-- 描述 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideRiskCtrl.desc" text="描述" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${assetSideRiskCtrl.desc }	
			</label>
		</div>
		<c:if test="${factory==false }">
			<div class="form-controls auto-float">
				<div class="btn-group-sm">
				<k:access code="assetSideRiskCtrl_edit">
					<!--修改 -->
					<input type="button" class="btn-info btn" id="updateAssetSideRiskCtrl" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
					<script type="text/javascript">
						$("#updateAssetSideRiskCtrl").click(function(){
							var params = [];
							params.push("aId=${assetSideRiskCtrl.aId }");
							$K.frame.reloadSlideInner("${ctx}/assetSideRiskCtrl/assetSideRiskCtrlEditPage.in?" + params.join("&"));
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