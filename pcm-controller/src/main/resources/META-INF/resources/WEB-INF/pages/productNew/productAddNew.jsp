<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><spring:message code="product.add.title" text="产品参数管理新增"/></title>
    <!-- 引入css样式和部分js -->
    <link rel="stylesheet" type="text/css" href="${ctxStatic}/css/kite.home.partition.css"/>
    <%@ include file="/common/head.jsp" %>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
<!-- data-confirm=true 提交前需要确认 -->
<form:form cssClass="form-horizontal form-product" id="productAddForm" cssStyle="padding-top: 20px"
           modelAttribute="product" method="post" action="${ctx}/product/addProduct.in" data-confirm="true">
    <div class="form-group row">
        <!-- 产品代码 -->
        <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
            <span class="span-icon">*&nbsp;</span>
            <spring:message code="product.productCode" text="产品代码"/>
            :
        </label>
        <div class="col-lg-2 col-md-4 col-sm-4 col-xs-4">
            <form:input cssClass="form-control" path="productCode" data-rule-required="true" data-rule-maxlength="6"/>
        </div>
        <!-- 产品代码描述 -->
        <div class="hide desc">
            <spring:message code="product.productCode.desc"/>
        </div>
        <!-- 产品描述 -->
        <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
            <spring:message code="product.description" text="产品描述"/>
            :
        </label>
        <div class="col-lg-2 col-md-4 col-sm-4 col-xs-4">
            <form:input cssClass="form-control" path="description" data-rule-maxlength="40"/>
        </div>
        <!-- 产品描述描述 -->
        <div class="hide desc">
            <spring:message code="product.description.desc"/>
        </div>
    </div>
    <div class="form-group row">
        <!-- 产品类型 -->
        <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
            <span class="span-icon">*&nbsp;</span>
            <spring:message code="product.productType" text="产品类型"/>
            :
        </label>
        <div class="col-lg-2 col-md-4 col-sm-4 col-xs-4">
            <form:select cssClass="form-control" path="productType">
                <form:options items="${productType}"/>
            </form:select>
        </div>
        <!-- 产品类型描述 -->
        <div class="hide desc">
            <spring:message code="product.productType.desc"/>
        </div>

        <!-- 基准货币 -->
        <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
            <span class="span-icon">*&nbsp;</span>
            <spring:message code="product.currency" text="基准货币"/>
            :
        </label>
        <div class="col-lg-2 col-md-4 col-sm-4 col-xs-4">
            <form:select cssClass="form-control" path="currency" data-live-search="true">
                <form:options items="${currency}"/>
            </form:select>
        </div>
        <!-- 基准货币描述 -->
        <div class="hide desc">
            <spring:message code="product.currency.desc"/>
        </div>
    </div>
    <div class="hide">
        <div class="cbtn-group-md">
            <!-- 确定 -->
            <input type="submit" id="submit" class="btn-primary btn"
                   value="<spring:message code='kite.web.common.btnSure' text='确定' />"/>
            <!-- 返回 -->
            <input type="button" class="btn-default btn only-slide-out"
                   value="<spring:message code='kite.web.common.btnBack' text='返回' />"/>
        </div>
    </div>
</form:form>
<!-- 引入js文件-->
<%@ include file="/common/foot.jsp" %>
<script>
    //开启表单验证
    $("#productAddForm").validate();
</script>
</body>
</html>