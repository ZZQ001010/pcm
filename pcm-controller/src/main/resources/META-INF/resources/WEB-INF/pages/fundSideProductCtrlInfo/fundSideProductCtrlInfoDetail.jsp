<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="fundSideProductCtrlInfo.detail.title" text="资金方产品经营控制
明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="fundSideProductCtrlInfo">
		<div class="form-group row">
			<!-- 资金方管控编码 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="fundSideProductCtrlInfo.fundSideCtrlCode" text="资金方管控编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${fundSideProductCtrlInfo.fundSideCtrlCode }	
			</label>
			<!-- 资金方管控描述 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="fundSideProductCtrlInfo.fundSideCtrlDesc" text="资金方管控描述" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${fundSideProductCtrlInfo.fundSideCtrlDesc }	
			</label>
            <!-- 资金方管控描述 -->
            <%--<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">--%>
                <%--<spring:message code="fundSideProductCtrlInfo.fundSideCode" text="资金方编码" />--%>
                <%--:--%>
            <%--</label>--%>
            <%--<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">--%>
                <%--&nbsp;${fundSideProductCtrlInfo.fundSideCode }--%>
            <%--</label>--%>
            <!-- 资金方管控描述 -->
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
                <spring:message code="fundSideProductCtrlInfo.fundSideProv" text="资金方支持展业省份" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
                &nbsp;${FundSideProv }
            </label>
            
            
            <!-- 资金方管控描述 -->
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
                <spring:message code="fundSideProductCtrlInfo.fundSideCity" text="资金方支持展业城市" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
                &nbsp;${fundSideCity }
            </label>
            
            <!-- 资金方支持展业区、县 -->
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
                <spring:message code="fundSideProductCtrlInfo.fundSideDistrict" text="资金方支持展业区、县" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
                &nbsp;${fundSideDistrict }
            </label>
            
            
            
            <!-- 资金方管控描述 -->
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
                <spring:message code="fundSideProductCtrlInfo.fundSideBusinessScope" text="资金方申请行业范围" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
                &nbsp;${fundSideBusinessScopes}
            </label>
            <!-- 资金方管控描述 -->
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
                <spring:message code="fundSideProductCtrlInfo.fundSideProfessionScope" text="资金方申请职业范围" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
                &nbsp;${fundSideProfessionScopes}
            </label>
            <!-- 资金方申请年龄范围 -->
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
                <spring:message code="fundSideProductCtrlInfo.applicantsAgeRange" text="资金方申请年龄范围" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
                &nbsp;${fundSideProductCtrlInfo.applicantsAgeRange}
            </label>
            <%--<!-- 资金方管控描述 -->--%>
            <%--<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">--%>
                <%--<spring:message code="fundSideProductCtrlInfo.fundSideInfo" text="资金方专项资产方" />--%>
                <%--:--%>
            <%--</label>--%>
            <%--<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">--%>
                <%--&nbsp;${fundSideProductCtrlInfo.fundSideInfo }--%>
            <%--</label>--%>
            <!-- 资金方管控描述 -->
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
            <spring:message code="fundSideProductCtrlInfo.fundSidePartRepay" text="资金方是否支持部分还款" />
            :
        </label>
            <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
                &nbsp;${fundSidePartRepay }
            </label>
            <%--<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">--%>
                <%--<spring:message code="fundSideProductCtrlInfo.fundSidePartRepayDay" text="资金方支持还款日区间" />--%>
                <%--:--%>
            <%--</label>--%>
            <%--<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">--%>
                <%--&nbsp;${fundSideProductCtrlInfo.fundSidePartRepayDay }--%>
            <%--</label>--%>
		</div>
	<c:if test="${factory==false }">
		<div class="form-controls auto-float">
			<div class="btn-group-sm">
			<k:access code="fundSideProductCtrlInfo_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updateFundSideProductCtrlInfo" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updateFundSideProductCtrlInfo").click(function(){
						var params = [];
						params.push("fundSideCtrlCode=${fundSideProductCtrlInfo.fundSideCtrlCode }");
						$K.frame.reloadSlideInner("${ctx}/fundSideProductCtrlInfo/fundSideProductCtrlInfoEditPage.in?" + params.join("&"));
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