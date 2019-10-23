<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="bankPrincipalInterest.detail.title" text="银行本息明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="bankPrincipalInterest">
		<div class="form-group row">
			<!-- 风管方式 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="bankPrincipalInterest.bankPrincipalInterestCode" text="银行本息编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${bankPrincipalInterest.bankPrincipalInterestCode}
			</label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
                <spring:message code="bankPrincipalInterest.bankPrincipalInterestDesc" text="银行本息描述" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
                &nbsp;${bankPrincipalInterest.bankPrincipalInterestDesc}
            </label>
            <!-- 费用收取频次 -->
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
                <spring:message code="bankPrincipalInterest.frequencyOfCharge" text="费用收取频次" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
                &nbsp;${frequencyOfCharge}
            </label>
            <!-- 所属机构 -->
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
                <spring:message code="bankPrincipalInterest.organization" text="所属机构" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
                &nbsp;${org }
            </label>
            <!-- 合作方类型 -->
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
                <spring:message code="bankPrincipalInterest.partnerType" text="合作方类型" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
                &nbsp;${partnerType}
            </label>
            <!-- 合作方编码 -->
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
                <spring:message code="bankPrincipalInterest.partnerCode" text="合作方编码" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
                &nbsp;${partner }
            </label>
            <!-- 转出账号 -->
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
                <spring:message code="bankPrincipalInterest.transferAccount" text="转出账号" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
                &nbsp;${bankPrincipalInterest.transferAccount }
            </label>
            <!-- 转入账号 -->
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
                <spring:message code="bankPrincipalInterest.transferToAccount" text="转入账号" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
                &nbsp;${bankPrincipalInterest.transferToAccount }
            </label>
            <!-- 结算周期 -->
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
                <spring:message code="bankPrincipalInterest.billingCycle" text="结算周期" />
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
            
            									<!-- 结算信息-->
<!-- 			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"> -->
<!-- 				<spring:message code="fundSideServiceFee.settleAccounts" text="结算信息" /> -->
<!-- 				: -->
<!-- 			</label> -->
<!-- 			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle"> -->
<%-- 				&nbsp;${bankPrincipalInterest.settleAccounts}	 --%>
<!-- 			</label> -->
			
		</div>
		<c:if test="${factory==false }">
			<div class="form-controls auto-float">
				<div class="btn-group-sm">
				<k:access code="bankPrincipalInterest_edit">
					<!--修改 -->
					<input type="button" class="btn-info btn" id="updateBankPrincipalInterestCode" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
					<script type="text/javascript">
						$("#updateBankPrincipalInterest").click(function(){
							var params = [];
							params.push("bankPrincipalInterestCode=${bankPrincipalInterest.bankPrincipalInterestCode}");
							$K.frame.reloadSlideInner("${ctx}/bankPrincipalInterest/bankPrincipalInterestEditPage.in?" + params.join("&"));
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