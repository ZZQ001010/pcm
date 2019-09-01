<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="premium.detail.title" text="保费明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="premium">
		<div class="form-group row">
			<!-- 保费编码 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="premium.premiumCode" text="保费编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${premium.premiumCode }	
			</label>
			<!-- 保费描述 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="premium.premiumDesc" text="保费描述" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${premium.premiumDesc }	
			</label>

			<!-- 费用收取频次 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="premium.frequencyOfCharge" text="费用收取频次" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${frequencyOfCharge}
			</label>
            <!-- 费用累计月天数-->
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
                <spring:message code="" text="费用累计月天数" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
                &nbsp;${expenses }
            </label>
			<!-- 转出账号 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="premium.transferAccount" text="转出账号" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${premium.transferAccount }	
			</label>
			<!-- 转入账号 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="premium.transferToAccount" text="转入账号" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${premium.transferToAccount }	
			</label>
			<!-- 结算周期 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="premium.billingCycle" text="结算周期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${billingCycle}
			</label>

			
						<!--所属机构 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="premium.organization" text="所属机构" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${org}
			</label>
			
			
						<!-- 合作方类型 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="premium.partnerType" text="合作方类型" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${partnerType}
			</label>
			
			
						<!-- 合作方编码 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="premium.partnerCode" text="合作方编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${partnerCode}
			</label>

            <!-- 结算周期 -->
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
                <spring:message code="bankPrincipalInterest.billingCycle" text="结算周期" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
                &nbsp;${billingCycle}
            </label>
						
						<!-- 结算日期 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="premium.balanceDate" text="ç" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${premium.balanceDate}
			</label>
			

		</div>
		
 <c:if test="${factroy==false }">
		<div class="form-controls auto-float">
			<div class="btn-group-sm">
			<k:access code="premium_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updatePremium" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updatePremium").click(function(){
						var params = [];
						params.push("premiumCode=${premium.premiumCode }");
						$K.frame.reloadSlideInner("${ctx}/premium/premiumEditPage.in?" + params.join("&"));
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