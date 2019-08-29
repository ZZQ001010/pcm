<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="bankChargeMorePenaltyInterest.update.title" text="银行多记罚息修改" /></title>
<%@ include file="/common/head.jsp"%>
</head>
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="bankChargeMorePenaltyInterestUpdForm" cssStyle="padding-top: 40px" modelAttribute="bankChargeMorePenaltyInterest" method="post" action="${ctx}/bankChargeMorePenaltyInterest/updBankChargeMorePenaltyInterest.in" data-confirm="true">
		<form:hidden path="bankChargeMorePenaltyInterestCode" />

        <div class="form-group row">
            <!-- 银行多记罚息描述 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <span class="span-icon">*&nbsp;</span>
                <spring:message code="bankChargeMorePenaltyInterest.bankChargeMorePenaltyInterestDesc" text="银行多记罚息描述" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:input cssClass="form-control" type="text" path="bankChargeMorePenaltyInterestDesc" data-rule-required="true" data-rule-maxlength="15" />
            </div>
            <!-- 银行多记罚息描述 -->
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
                <spring:message code="bankChargeMorePenaltyInterest.bankChargeMorePenaltyInterestDesc.desc" />
            </div>
        </div>
        <div class="form-group row">
            <!-- 收取比例 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <span class="span-icon">&nbsp;</span>
                <spring:message code="bankChargeMorePenaltyInterest.penaltyInterestShareProportion" text="罚息分担比例" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:input cssClass="form-control" type="text" path="penaltyInterestShareProportion" id="penaltyInterestShareProportion"   />
            </div>
            <!-- 收取比例描述 -->
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
                <spring:message code="bankChargeMorePenaltyInterest.penaltyInterestShareProportion.desc" />
            </div>
        </div>
        <div class="form-group row">
            <!-- 所属机构 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="bankChargeMorePenaltyInterest.organization" text="所属机构" />
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
                <spring:message code="bankChargeMorePenaltyInterest.organization.desc" />
            </div>
        </div>
        <div class="form-group row">
            <!-- 合作方类型 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="bankChargeMorePenaltyInterest.partnerType" text="合作方类型" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:select cssClass="form-control" path="partnerType" id="partnerType" onchange="typeChange();">
                    <option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
                    <form:options items="${partnerType}" />
                </form:select>
            </div>
            <!-- 合作方类型描述 -->
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
                <spring:message code="bankChargeMorePenaltyInterest.partnerType.desc" />
            </div>
        </div>
        <div class="form-group row">
            <!-- 合作方编码 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="bankChargeMorePenaltyInterest.partnerCode" text="合作方编码" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:select cssClass="form-control" path="partnerCode" id="partnerCode">
                    <option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
                </form:select>
            </div>
            <!-- 合作方编码描述 -->
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
                <spring:message code="bankChargeMorePenaltyInterest.partnerCode.desc" />
            </div>
        </div>
        <div class="form-group row">
            <!-- 转出账号 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="bankChargeMorePenaltyInterest.transferAccount" text="转出账号" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:input cssClass="form-control" type="text" path="transferAccount"  data-rule-maxlength="12" />
            </div>
            <!-- 转出账号描述 -->
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
                <spring:message code="bankChargeMorePenaltyInterest.transferAccount.desc" />
            </div>
        </div>
        <div class="form-group row">
            <!-- 转入账号 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="bankChargeMorePenaltyInterest.transferToAccount" text="转入账号" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:input cssClass="form-control" type="text" path="transferToAccount"  data-rule-maxlength="12" />
            </div>
            <!-- 转入账号描述 -->
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
                <spring:message code="bankChargeMorePenaltyInterest.transferToAccount.desc" />
            </div>
        </div>
        <div class="form-group row">
            <!-- 结算周期 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <span class="span-icon">*&nbsp;</span>
                <spring:message code="bankChargeMorePenaltyInterest.billingCycle" text="结算周期" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:select cssClass="form-control" path="billingCycle" data-rule-required="true">
                    <option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
                    <form:options items="${billingCycle}" />
                </form:select>
            </div>
            <!-- 结算周期描述 -->
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
                <spring:message code="bankChargeMorePenaltyInterest.billingCycle.desc" />
            </div>
        </div>

        <div class="form-group row">
            <!-- 结算日期 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="dedit.balanceDate" text="结算日期" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <from:input id="balanceDate" path="balanceDate"
                            class='form-control customize-datetime' type="text"
                            data-picker-position="top-right" data-role-formate="yyyy-mm-dd"
                            onfocus="this.blur()"/>
            </div>
            <!-- 结算日期描述 -->
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
                <spring:message code="basicNetPremium.balanceDate.desc" />
            </div>
        </div>

        <div class="form-controls auto-float">
			<div class="btn-group-md">
				<!-- 确定 -->
				<input type="submit" class="btn-primary btn" value="<spring:message code='kite.web.common.btnSure' text='确定' />" />
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='取消' />" />
			</div>
		</div>
	</form:form>
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp"%>
	<script type="text/javascript">
		//开启表单验证
		$("#bankChargeMorePenaltyInterestUpdForm").validate();
        $(function(){
            //初始化数据
            typeChange();
        });

        function typeChange(){
            var type = $("#partnerType").val();
            if(type=='ZJ'){
                var map = ${fundSideInfoMap}
                    $("#partnerCode").empty();
                for(var key in map){
                    $("#partnerCode").append('<option value="'+key+'">'+map[key]+'</option>');
                }
                $("#partnerCode").selectpicker("refresh");
            }
            if(type=='ZC'){
                var map = ${assetSideInfoMap}
                    $("#partnerCode").empty();
                for(var key in map){
                    $("#partnerCode").append('<option value="'+key+'">'+map[key]+'</option>');
                }
                $("#partnerCode").selectpicker("refresh");
            }
            if(type=='QD'){
                var map = ${channelInfoMap}
                    $("#partnerCode").empty();
                for(var key in map){
                    $("#partnerCode").append('<option value="'+key+'">'+map[key]+'</option>');
                }
                $("#partnerCode").selectpicker("refresh");
            }
            if(type=='FW'){
                var map = ${serverInfoMap}
                    $("#partnerCode").empty();
                for(var key in map){
                    $("#partnerCode").append('<option value="'+key+'">'+map[key]+'</option>');
                }
                $("#partnerCode").selectpicker("refresh");
            }
        }

        //结算日期控制
        $(function(){
            var value = $("#billingCycle").val();
            if(value=='A'){
                var zzqParent = $('#balanceDate').parent('div');
                zzqParent.empty();
                zzqParent.append('<input id="balanceDate" name="balanceDate"  class="form-control" type="text"   />')
                $('#balanceDate').attr("disabled",true);
            }else if(value=='Z'){
                var zzqParent = $('#balanceDate').parent('div');
                zzqParent.empty();
                zzqParent.append('<select id="balanceDate" name="balanceDate"  class="form-control">'
                    <c:forEach items="${banceDate}" var="item">
                    +'<option value="${item.key}">${item.value}</option>'
                    </c:forEach>
                    +'<select>');
                $('#balanceDate').val('${bankChargeMorePenaltyInterest.balanceDate}')
            }else if(value=='C'){
                var zzqParent = $('#balanceDate').parent('div');
                zzqParent.empty();
                zzqParent.append('<input id="balanceDate" name="balanceDate"  class="form-control customize-datetime" type="text" data-picker-position="top-right" data-role-formate="dd"  onfocus="this.blur()" />')
                $('#balanceDate').datepicker({
                    autoclose : true,
                    format: 'dd',
                })
                $('#balanceDate').val('${bankChargeMorePenaltyInterest.balanceDate}')
            }else if(value=='I'){
                $('#balanceDate').datepicker('destroy')
                var zzqParent = $('#balanceDate').parent('div');
                zzqParent.empty();
                zzqParent.append('<input id="balanceDate"  name="balanceDate" class="form-control" type="text"   />')
                $('#balanceDate').datepicker({
                    autoclose : true,
                    format: 'mm-dd',
                })
                $('#balanceDate').val('${bankChargeMorePenaltyInterest.balanceDate}')
            }else{
                $('#balanceDate').attr("disabled",false);
            }
        })
        $('#billingCycle').change(function(){
            var value = $(this).val();
            if(value=='A'){
                var zzqParent = $('#balanceDate').parent('div');
                zzqParent.empty();
                zzqParent.append('<input id="balanceDate" name="balanceDate"  class="form-control" type="text"   />')
                $('#balanceDate').attr("disabled",true);
            }else if(value=='Z'){
                var zzqParent = $('#balanceDate').parent('div');
                zzqParent.empty();
                zzqParent.append('<select id="balanceDate" name="balanceDate"  class="form-control">'
                    <c:forEach items="${banceDate}" var="item">
                    +'<option value="${item.key}">${item.value}</option>'
                    </c:forEach>
                    +'<select>');
            }else if(value=='C'){
                var zzqParent = $('#balanceDate').parent('div');
                zzqParent.empty();
                zzqParent.append('<input id="balanceDate" name="balanceDate"  class="form-control customize-datetime" type="text" data-picker-position="top-right" data-role-formate="dd"  onfocus="this.blur()" />')
                $('#balanceDate').datepicker({
                    autoclose : true,
                    format: 'dd',
                })
            }else if(value=='I'){
                $('#balanceDate').datepicker('destroy')
                var zzqParent = $('#balanceDate').parent('div');
                zzqParent.empty();
                zzqParent.append('<input id="balanceDate"  name="balanceDate" class="form-control" type="text"   />')
                $('#balanceDate').datepicker({
                    autoclose : true,
                    format: 'mm-dd',
                })
            }else{
                $('#balanceDate').attr("disabled",false);
            }
        })
	</script>
</body>
</html>