<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="pcmSettleAccMan.detail.title" text="结算账号管理明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="pcmSettleAccMan">
		<div class="form-group row">
			<!-- 结算账号编码 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="pcmSettleAccMan.settleAccCode" text="结算账号编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${pcmSettleAccMan.settleAccCode }	
			</label>
			<!-- 结算账号描述 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="pcmSettleAccMan.settleAccDes" text="结算账号描述" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${pcmSettleAccMan.settleAccDes }	
			</label>
			<!-- 账号归属 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="pcmSettleAccMan.accountOwner" text="账号归属" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${accountOwner}
			</label>
			
			<!-- 账号归属主体 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="pcmSettleAccMan.orgCode" text="账号归属主体" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${partner}	
			</label>
			<!-- 机构账号类型 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="pcmSettleAccMan.organizationAccountType" text="机构账号类型" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${org }
			</label>
			
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
			style="margin-left: 20px">
			<h2>
				<spring:message code="pcmSettleAccMan.accInfo.title" text="账号信息" />
			</h2>
			<hr>
		</div>

			<!-- 单位名称 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="pcmSettleAccMan.unitName" text="单位名称" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${pcmSettleAccMan.unitName }	
			</label>
			<!-- 银行账户 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="pcmSettleAccMan.bankAccount" text="银行账户" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${pcmSettleAccMan.bankAccount }	
			</label>

			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="pcmSettleAccMan.openBank" text="开户银行" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${pcmSettleAccMan.openBank }	
			</label>
			<!-- 开户行省份 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="pcmSettleAccMan.openBankProv" text="开户行省份" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${pcmSettleAccMan.openBankProv }	
			</label>
			<!-- 开户行城市 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="pcmSettleAccMan.openBankCity" text="开户行城市" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${pcmSettleAccMan.openBankCity }	
			</label>
			<!-- 开户行支行 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="pcmSettleAccMan.openBankBranch" text="开户行支行" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${pcmSettleAccMan.openBankBranch }	
			</label>
		</div>
		<c:if test="${factory }">
		<div class="form-controls auto-float" >
			<div class="btn-group-sm">
			<k:access code="pcmSettleAccMan_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updatePcmSettleAccMan" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updatePcmSettleAccMan").click(function(){
						var params = [];
						params.push("settleAccCode=${pcmSettleAccMan.settleAccCode }");
						$K.frame.reloadSlideInner("${ctx}/pcmSettleAccMan/pcmSettleAccManEditPage.in?" + params.join("&"));
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