<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><spring:message code="claimSettlement.add.title" text="理赔新增" /></title>
    <!-- 引入css样式和部分js -->
    <%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
<!-- data-confirm=true 提交前需要确认 -->
<form:form cssClass="form-horizontal" id="claimSettlementAddForm" cssStyle="padding-top: 40px" modelAttribute="claimSettlement" method="post" action="${ctx}/claimSettlement/addClaimSettlement.in" data-confirm="true">
    <div class="form-group row">
        <!-- 编码 -->
        <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
            <span class="span-icon">*&nbsp;</span>
            <spring:message code="claimSettlement.claimSettlementCode" text="理赔编码" />
            :
        </label>
        <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
            <form:input cssClass="form-control" type="text" path="claimSettlementCode"  data-rule-required="true" data-rule-maxlength="32" />
        </div>
        <!-- 编码描述 -->
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
            <spring:message code="claimSettlement.claimSettlementCode.desc" />
        </div>
    </div>
    <div class="form-group row">
        <!-- 编码 -->
        <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
            <span class="span-icon">*&nbsp;</span>
            <spring:message code="claimSettlement.claimSettlementDesc" text="理赔描述" />
            :
        </label>
        <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
            <form:input cssClass="form-control" type="text" path="claimSettlementDesc"  data-rule-required="true" data-rule-maxlength="32" />
        </div>
        <!-- 编码描述 -->
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
            <spring:message code="claimSettlement.claimSettlementDesc.desc" />
        </div>
    </div>

    <div class="form-group row">
        <!-- 所属机构 -->
        <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
            <spring:message code="claimSettlement.organization" text="所属机构" />
            :
        </label>
        <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
            <form:select cssClass="form-control" path="organization">
                <option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
                <form:options items="${orgMap}" />
            </form:select>
        </div>
        <!-- 所属机构描述 -->
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
            <spring:message code="claimSettlement.organization.desc" />
        </div>
    </div>
    <div class="form-group row">
        <!-- 合作方类型 -->
        <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
            <span class="span-icon">&nbsp;</span>
            <spring:message code="claimSettlement.partnerType" text="合作方类型" />
            :
        </label>
        <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
            <form:select cssClass="form-control" path="partnerType"  id="partnerType" onchange="typeChange();">
                <option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
                <form:options items="${partnerType}" />
            </form:select>
        </div>
        <!-- 合作方类型描述 -->
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
            <spring:message code="claimSettlement.partnerType.desc" />
        </div>
    </div>
    <div class="form-group row">
        <!-- 合作方编码 -->
        <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
            <span class="span-icon">&nbsp;</span>
            <spring:message code="claimSettlement.partnerCode" text="合作方编码" />
            :
        </label>
        <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
            <form:select cssClass="form-control" path="partnerCode"  id="partnerCode">
                <option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
            </form:select>
        </div>
        <!-- 合作方编码描述 -->
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
            <spring:message code="claimSettlement.partnerCode.desc" />
        </div>
    </div>
    <div class="form-group row">
        <!-- 转出账号 -->
        <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
            <spring:message code="claimSettlement.transferAccount" text="转出账号"  />
            :
        </label>
        <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
              <form:select cssClass="form-control" path="transferToAccount" data-rule-required="true">
                    <option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
                    <form:options items="${pcmSettleAccMan}" />
                </form:select>
        </div>
        <!-- 转出账号描述 -->
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
            <spring:message code="claimSettlement.transferAccount.desc" />
        </div>
    </div>
    <div class="form-group row">
        <!-- 转入账号 -->
        <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
            <spring:message code="claimSettlement.transferToAccount" text="转入账号" />
            :
        </label>
        <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
               <form:select cssClass="form-control" path="transferToAccount" data-rule-required="true">
                    <option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
                    <form:options items="${pcmSettleAccMan}" />
                </form:select>
        </div>
        <!-- 转入账号描述 -->
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
            <spring:message code="claimSettlement.transferToAccount.desc" />
        </div>
    </div>
    
    	
	 <div class="form-group row">
		<!-- 结算信息 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="fundSideServiceFee.settleAccounts" text="结算信息" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<input id="settleAccounts" name="settleAccounts" class='form-control' type="text"   />
			</div>
			 <!-- 结算信息 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="fundSideServiceFee.settleAccounts.desc" />
			</div>
		</div>

    <div class="form-controls auto-float">
        <div class="btn-group-md">
            <!-- 确定 -->
            <input type="submit" class="btn-primary btn" value="<spring:message code='kite.web.common.btnSure' text='确定' />" />
            <!-- 返回 -->
            <input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
        </div>
    </div>
</form:form>
<!-- 引入js文件-->
<%@ include file="/common/foot.jsp"%>
<script type="text/javascript">
    //开启表单验证
    $("#claimSettlementAddForm").validate();


    //合作方编码控制
    function typeChange(){
        var type = $("#partnerType").val();
        if(type=='ZJ'){
            var map = ${fundSideInfoMap}
            $("#partnerCode").empty();
            $("#partnerCode").append('<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>');
            for(var key in map){
                $("#partnerCode").append('<option value="'+key+'">'+map[key]+'</option>');
            }
            $("#partnerCode").selectpicker("refresh");
        }
        if(type=='ZC'){
            var map = ${assetSideInfoMap}
            $("#partnerCode").empty();
            $("#partnerCode").append('<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>');
            for(var key in map){
                $("#partnerCode").append('<option value="'+key+'">'+map[key]+'</option>');
            }
            $("#partnerCode").selectpicker("refresh");
        }
        if(type=='QD'){
            var map = ${channelInfoMap}
            $("#partnerCode").empty();
            $("#partnerCode").append('<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>');
            for(var key in map){
                $("#partnerCode").append('<option value="'+key+'">'+map[key]+'</option>');
            }
            $("#partnerCode").selectpicker("refresh");
        }
        if(type=='FW'){
            var map = ${serverInfoMap}
            $("#partnerCode").empty();
            $("#partnerCode").append('<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>');
            for(var key in map){
                $("#partnerCode").append('<option value="'+key+'">'+map[key]+'</option>');
            }
            $("#partnerCode").selectpicker("refresh");
        }
    }

</script>
</body>
</html>