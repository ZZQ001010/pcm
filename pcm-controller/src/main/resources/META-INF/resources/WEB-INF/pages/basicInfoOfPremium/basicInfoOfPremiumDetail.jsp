<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="basicInfoOfPremium.detail.title" text="保费基本信息明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="basicInfoOfPremium">
		<div class="form-group row">
			<!-- 编码 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="basicInfoOfPremium.code" text="保费编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${basicInfoOfPremium.code }	
			</label>
			<!-- 描述 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="basicInfoOfPremium.desc" text="保费描述" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${basicInfoOfPremium.desc }	
			</label>
			<!-- 费用收取方式 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="basicInfoOfPremium.feeCollectionMethod" text="费用收取方式" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${feeCollectionMethod}
			</label>
			<!-- 费用收取频次 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="basicInfoOfPremium.frequencyOfCharge" text="保费缴纳频率" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${frequencyOfCharge}
			</label>
			<!-- 收取本金比例 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="basicInfoOfPremium.principalCollectionRatio" text="保费率" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${basicInfoOfPremium.principalCollectionRatio }	
			</label>
			<!-- 保费缴纳方式 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="basicInfoOfPremium.feePayMethod" text="保费缴纳方式" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${feePayMethod}
			</label>
		</div>
	<c:if test="${!factory }">
		<div class="form-controls auto-float">
			<div class="btn-group-sm">
			<k:access code="basicInfoOfPremium_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updateBasicInfoOfPremium" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updateBasicInfoOfPremium").click(function(){
						var params = [];
						params.push("code=${basicInfoOfPremium.code }");
						$K.frame.reloadSlideInner("${ctx}/basicInfoOfPremium/basicInfoOfPremiumEditPage.in?" + params.join("&"));
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