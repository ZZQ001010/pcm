<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="pursuingRecovery.detail.title" text="追偿明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="pursuingRecovery">
		<div class="form-group row">
			<!-- 风管方式 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="pursuingRecovery.pursuingRecoveryCode" text="追偿编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${pursuingRecovery.pursuingRecoveryCode}
			</label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
                <spring:message code="pursuingRecovery.pursuingRecoveryDesc" text="追偿描述" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
                &nbsp;${pursuingRecovery.pursuingRecoveryDesc}
            </label>
            
            <!-- 所属机构 -->
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
                <spring:message code="pursuingRecovery.organization" text="所属机构" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
                &nbsp;${org }
            </label>
            <!-- 合作方类型 -->
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
                <spring:message code="pursuingRecovery.partnerType" text="合作方类型" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
                &nbsp;${partnerType}
            </label>
            <!-- 合作方编码 -->
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
                <spring:message code="pursuingRecovery.partnerCode" text="合作方编码" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
                &nbsp;${partner }
            </label>
            <!-- 转出账号 -->
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
                <spring:message code="pursuingRecovery.transferAccount" text="转出账号" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
                &nbsp;${pursuingRecovery.transferAccount }
            </label>
            <!-- 转入账号 -->
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
                <spring:message code="pursuingRecovery.transferToAccount" text="转入账号" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
                &nbsp;${pursuingRecovery.transferToAccount }
            </label>
            <!-- 结算周期 -->
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
                <spring:message code="pursuingRecovery.billingCycle" text="结算周期" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
                &nbsp;${billingCycle}
            </label>
            <!-- 结算日期 -->
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
                <spring:message code="platformCoupon.balanceDate" text="结算日期" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle" id="balanceDate">
                &nbsp;${balanceDate}
            </label>
            
            
		</div>
		<c:if test="${factory==false }">
			<div class="form-controls auto-float">
				<div class="btn-group-sm">
				<k:access code="pursuingRecovery_edit">
					<!--修改 -->
					<input type="button" class="btn-info btn" id="updatePursuingRecovery" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
					<script type="text/javascript">
						$("#updatePursuingRecovery").click(function(){
							var params = [];
							params.push("aId=${pursuingRecovery.pursuingRecoveryCode}");
							$K.frame.reloadSlideInner("${ctx}/pursuingRecovery/pursuingRecoveryEditPage.in?" + params.join("&"));
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