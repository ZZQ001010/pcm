<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><spring:message code="claimSettlement.detail.title" text="理赔明细" /></title>
    <!-- 引入css样式和部分js -->
    <%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="claimSettlement">
    <div class="form-group row">
        <!-- 风管方式 -->
        <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
            <spring:message code="claimSettlement.claimSettlementCode" text="理赔编码" />
            :
        </label>
        <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
            &nbsp;${claimSettlement.claimSettlementCode}
        </label>
        <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
            <spring:message code="claimSettlement.claimSettlementDesc" text="理赔描述" />
            :
        </label>
        <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
            &nbsp;${claimSettlement.claimSettlementDesc}
        </label>

        <!-- 所属机构 -->
        <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
            <spring:message code="claimSettlement.organization" text="所属机构" />
            :
        </label>
        <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
            &nbsp;${org }
        </label>
        <!-- 合作方类型 -->
        <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
            <spring:message code="claimSettlement.partnerType" text="合作方类型" />
            :
        </label>
        <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
            &nbsp;${partnerType}
        </label>
        <!-- 合作方编码 -->
        <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
            <spring:message code="claimSettlement.partnerCode" text="合作方编码" />
            :
        </label>
        <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
            &nbsp;${partner }
        </label>
        <!-- 转出账号 -->
        <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
            <spring:message code="claimSettlement.transferAccount" text="转出账号" />
            :
        </label>
        <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
            &nbsp;${claimSettlement.transferAccount }
        </label>
        <!-- 转入账号 -->
        <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
            <spring:message code="claimSettlement.transferToAccount" text="转入账号" />
            :
        </label>
        <label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
            &nbsp;${claimSettlement.transferToAccount }
        </label>
    </div>
    <c:if test="${factory==false }">
        <div class="form-controls auto-float">
            <div class="btn-group-sm">
                <k:access code="claimSettlement_edit">
                    <!--修改 -->
                    <input type="button" class="btn-info btn" id="updateClaimSettlement" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
                    <script type="text/javascript">
                        $("#updateClaimSettlement").click(function(){
                            var params = [];
                            params.push("aId=${claimSettlement.claimSettlementCode}");
                            $K.frame.reloadSlideInner("${ctx}/claimSettlement/claimSettlementEditPage.in?" + params.join("&"));
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