<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="fundSideCtrlInfo.detail.title" text="资金方管控信息
明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="fundSideCtrlInfo">
		<div class="form-group row">
			<!-- 资金方管控编码 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideCtrlInfo.fundSideCtrlCode" text="资金方管控编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideCtrlInfo.fundSideCtrlCode }	
			</label>
			<!-- 资金方管控描述 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideCtrlInfo.fundSideCtrlDesc" text="资金方管控描述" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideCtrlInfo.fundSideCtrlDesc }	
			</label>
            <!-- 资金方 -->
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
                <spring:message code="fundSideCtrlInfo.fundSide" text="资金方编码" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
                &nbsp;${fundSide}
            </label>
            <!-- 资金方 -->
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
                <spring:message code="fundSideCtrlInfo.fundSideCreditLimit" text="资金方授信管控" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
                &nbsp;${fundSideCreditLimit}
            </label>
			<!-- 资金方总授信额度 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideCtrlInfo.fundSideTotalTrustworthinessLimit" text="资金方授信额度总控" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideCtrlInfo.fundSideTotalTrustworthinessLimit }	
			</label>
			<!-- 授信额度有效期 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideCtrlInfo.authorizationAmountUsefulLife" text="授信额度有效期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
			 <fmt:formatDate var="authorizationAmountUsefulLifeFmt" value="${fundSideCtrlInfo.authorizationAmountUsefulLife}" type="date" pattern="yyyy-MM-dd"/>
				&nbsp;${authorizationAmountUsefulLifeFmt }	
			</label>
            <!-- 资金方放款管控 -->
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
                <spring:message code="fundSideCtrlInfo.fundSideLoanLimit" text="资金方放款管控" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
                &nbsp;${fundSideLoanLimit}
            </label>
			<!-- 资金方总放款额度 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideCtrlInfo.fundSideTotalLoanAmount" text="资金方放款额总控" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideCtrlInfo.fundSideTotalLoanAmount }	
			</label>
			<!-- 放款额度有效期 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideCtrlInfo.loanAmountUsefulLife" text="放款额度有效期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
			<fmt:formatDate var="loanAmountUsefulLifeFmt" value="${fundSideCtrlInfo.loanAmountUsefulLife}" type="date" pattern="yyyy-MM-dd"/>
				&nbsp;${loanAmountUsefulLifeFmt}	
			</label>
            <!-- 资金方总放款额度 -->
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
                <spring:message code="fundSideCtrlInfo.fundSideTotalLoanAmountM" text="资金方月放款额管控" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
                &nbsp;${fundSideCtrlInfo.fundSideTotalLoanAmountM }
            </label>
            <!-- 资金方总放款额度 -->
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
                <spring:message code="fundSideCtrlInfo.fundSideTotalLoanAmountW" text="资金方周放款额管控" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
                &nbsp;${fundSideCtrlInfo.fundSideTotalLoanAmountW }
            </label>
            <!-- 资金方总放款额度 -->
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
                <spring:message code="fundSideCtrlInfo.fundSideTotalLoanAmountD" text="资金方日放款额管控" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
                &nbsp;${fundSideCtrlInfo.fundSideTotalLoanAmountD }
            </label>
			<!-- 资金方总余额 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideCtrlInfo.fundSideTotalBalance" text="资金方余额总控" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideCtrlInfo.fundSideTotalBalance }	
			</label>
			<!-- 余额额度有效期 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideCtrlInfo.balanceAmountUsefulLife" text="余额额度有效期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
			<fmt:formatDate var="balanceAmountUsefulLifeFmt" value="${fundSideCtrlInfo.balanceAmountUsefulLife}" type="date" pattern="yyyy-MM-dd"/>
				&nbsp;${balanceAmountUsefulLifeFmt }	
			</label>
		</div>
	<c:if test="${factory==false }">
		<div class="form-controls auto-float">
			<div class="btn-group-sm">
			<k:access code="fundSideCtrlInfo_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updateFundSideCtrlInfo" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updateFundSideCtrlInfo").click(function(){
						var params = [];
						params.push("fundSideCtrlCode=${fundSideCtrlInfo.fundSideCtrlCode }");
						$K.frame.reloadSlideInner("${ctx}/fundSideCtrlInfo/fundSideCtrlInfoEditPage.in?" + params.join("&"));
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