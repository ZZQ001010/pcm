<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<title><spring:message code="organization.query.title" text="机构参数管理查询" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
<style type="text/css">
.switchery{
	margin-top: 10px;
}
.form-horizontal .control-label {
    padding-top: 3px
}
@media (max-width: 750px) {
	.form-horizontal .control-label {
	    text-align: right !important;
	}
	.form-product .control-label {
		text-align: right !important;
	}
	}
</style>	
</head>
<body class="${param.skin}">
<!-- data-confirm=true 提交前需要确认 -->																																	<%-- ${ctx}/organization/updOrganization.in --%>		<%--${ctx}/organization/saveOrganizationPage.in	--%>														
	<form:form cssClass="form-horizontal" id="organizationUpdForm" cssStyle="padding-top: 40px;padding-right: 40px" modelAttribute="organization" method="post" action="${ctx}/organization/saveOrganizationPage.in" data-confirm="true">
		<div class="form-group row col-lg-4 col-md-6 col-sm-6 col-xs-12 ">
			<!-- 支付渠道 -->
			<label class="col-lg-6 col-md-5 col-sm-6 col-xs-6 control-label">
				<spring:message code="organization.paymentChannel" text="支付渠道" />
				:
			</label>
			<div class=" col-lg-6 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="paymentChannel" data-rule-maxlength="20" />
			</div>
			<!-- 支付渠道描述 -->
			<div class="hide desc" for="paymentChannel">
				<spring:message code="organization.paymentChannel.desc" />
			</div>
		</div>
		<div class="form-group row col-lg-4 col-md-6 col-sm-6 col-xs-12 ">
			<!-- 征信金融机构 -->
			<label class="col-lg-6 col-md-5 col-sm-6 col-xs-6 control-label">
				<spring:message code="organization.creditInstitutions" text="征信金融机构" />
				:
			</label>
			<div class=" col-lg-6 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="creditInstitutions" data-rule-maxlength="20" />
			</div>
			<!-- 征信金融机构描述 -->
			<div class="hide desc" for="creditInstitutions">
				<spring:message code="organization.creditInstitutions.desc" />
			</div>
		</div>
		<div class="form-group row col-lg-4 col-md-6 col-sm-6 col-xs-12 ">
			<!-- 人行征信报送类型 -->
			<label class="col-lg-6 col-md-5 col-sm-6 col-xs-6 control-label">
				<spring:message code="organization.pbocType" text="人行征信报送类型" />
				:
			</label>
			<div class=" col-lg-6 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="pbocType">
				<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${pbocType}" />
				</form:select>
			</div>
			<!-- 人行征信报送类型描述 -->
			<div class="hide desc" for="pbocType">
				<spring:message code="organization.pbocType.desc" />
			</div>
		</div>
		<div class="form-group row col-lg-4 col-md-6 col-sm-6 col-xs-12 ">
			<!-- 默认分行号-->
			<label class="col-lg-6 col-md-5 col-sm-6 col-xs-6 control-label">
				<spring:message code="organization.defaultBranchNo" text="默认分行号" />
				:
			</label>
			<div class=" col-lg-6 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="defaultBranchNo"  />
			</div>
			<!-- 默认分行号描述 -->
			<div class="hide desc" for="defaultBranchNo">
				<spring:message code="organization.defaultBranchNo.desc" />
			</div>
		</div>
		<div class="form-group row col-lg-4 col-md-6 col-sm-6 col-xs-12 ">
			<!-- 发送短信机构号-->
			<label class="col-lg-6 col-md-5 col-sm-6 col-xs-6 control-label">
				<spring:message code="organization.smsToOrg" text="发送短信机构号" />
				:
			</label>
			<div class=" col-lg-6 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="smsToOrg"  />
			</div>
			<!-- 发送短信机构号描述 -->
			<div class="hide desc" for="smsToOrg">
				<spring:message code="organization.smsToOrg.desc" />
			</div>
		</div>
		<div class="form-group row col-lg-4 col-md-6 col-sm-6 col-xs-12 ">
			<!-- 实时入账标志-->
			<label class="col-lg-6 col-md-5 col-sm-6 col-xs-6 control-label">
				<spring:message code="organization.bookingOnlineFlag" text="放款实时入账标志" />
				:
			</label>
			<div class=" col-lg-6 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="bookingOnlineFlag">
				<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${bookingOnlineFlag}" />
				</form:select>
			</div>
			<!-- 实时入账标志描述 -->
			<div class="hide desc" for="bookingOnlineFlag">
				<spring:message code="organization.bookingOnlineFlag.desc" />
			</div>
		</div>
        <div class="form-group row col-lg-4 col-md-6 col-sm-6 col-xs-12 ">
            <!-- 实时入账标志-->
            <label class="col-lg-6 col-md-5 col-sm-6 col-xs-6 control-label">
                <spring:message code="organization.repayBookingOnlineFlag" text="还款实时入账标志" />
                :
            </label>
            <div class=" col-lg-6 col-md-7 col-sm-6 col-xs-6">
                <form:select cssClass="form-control" path="repayBookingOnlineFlag">
                    <option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
                    <form:options items="${repayBookingOnlineFlag}" />
                </form:select>
            </div>
            <!-- 实时入账标志描述 -->
            <div class="hide desc" for="repayBookingOnlineFlag">
                <spring:message code="organization.repayBookingOnlineFlag.desc" />
            </div>
        </div>
		<div class="form-group row col-lg-4 col-md-6 col-sm-6 col-xs-12 ">
			<!-- 基准货币代码 -->
			<label class="col-lg-6 col-md-5 col-sm-6 col-xs-6 control-label">
				<spring:message code="organization.baseCurrCd" text="基准货币代码" />
				:
			</label>
			<div class=" col-lg-6 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control"  path="baseCurrCd" data-rule-required="true" data-live-search="true">
				<form:options items="${baseCurrCd}" />
				</form:select>
			</div>
			<!-- 基准货币代码描述 -->
			<div class="hide desc" for="baseCurrCd">
				<spring:message code="organization.baseCurrCd.desc" />
			</div>
		</div>
		<div class="form-group row col-lg-4 col-md-6 col-sm-6 col-xs-12 ">
			<!-- 最大授信额度 -->
			<label class="col-lg-6 col-md-5 col-sm-6 col-xs-6 control-label">
				<spring:message code="organization.maxCreditLimit" text="最大授信额度" />
				:
			</label>
			<div class=" col-lg-6 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="maxCreditLimit"  data-rule-maxlength="15" />
			</div>
			<!-- 最大授信额度描述 -->
			<div class="hide desc" for="maxCreditLimit">
				<spring:message code="organization.maxCreditLimit.desc" />
			</div>
		</div>				
		<div class="form-group row col-lg-4 col-md-6 col-sm-6 col-xs-12 ">
			<!-- 超限免息标识 -->
			<label class="col-lg-6 col-md-5 col-sm-6 col-xs-6 control-label">
				<spring:message code="organization.overlimitDeferInd" text="超限免息标识" />
				:
			</label>
			<div class=" col-lg-6 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="overlimitDeferInd">
				<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${overlimitDeferInd}" />
				</form:select>
			</div>
			<!-- 超限免息标识描述 -->
			<div class="hide desc" for="overlimitDeferInd">
				<spring:message code="organization.overlimitDeferInd.desc" />
			</div>
		</div>				
		<div class="form-group row col-lg-4 col-md-6 col-sm-6 col-xs-12 ">
			<!-- 未全额还款免息标识 -->
			<label class="col-lg-6 col-md-5 col-sm-6 col-xs-6 control-label">
				<spring:message code="organization.nofullpayDeferInd" text="未全额还款免息标识" />
				:
			</label>
			<div class=" col-lg-6 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="nofullpayDeferInd">
				<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${nofullpayDeferInd}" />
				</form:select>
			</div>
			<!-- 未全额还款免息标识描述 -->
			<div class="hide desc" for="nofullpayDeferInd">
				<spring:message code="organization.nofullpayDeferInd.desc" />
			</div>
		</div>				
		<div class="form-group row col-lg-4 col-md-6 col-sm-6 col-xs-12 ">
			<!-- 溢缴款信用计划号 -->
			<label class="col-lg-6 col-md-5 col-sm-6 col-xs-6 control-label">
				<spring:message code="organization.depositPlanNbr" text="溢缴款信用计划号" />
				:
			</label>
			<div class=" col-lg-6 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="depositPlanNbr"  data-rule-maxlength="6" />
			</div>
			<!-- 溢缴款信用计划号描述 -->
			<div class="hide desc" for="depositPlanNbr">
				<spring:message code="organization.depositPlanNbr.desc" />
			</div>
		</div>				
		<div class="form-group row col-lg-4 col-md-6 col-sm-6 col-xs-12 ">
			<!-- 利息按信用计划入账 -->
			<label class="col-lg-6 col-md-5 col-sm-6 col-xs-6 control-label">
				<spring:message code="organization.intPostOnPlan" text="利息按信用计划入账" />
				:
			</label>
			<div class=" col-lg-6 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="intPostOnPlan">
				<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${intPostOnPlan}" />
				</form:select>
			</div>
			<!-- 利息按信用计划入账描述 -->
			<div class="hide desc" for="intPostOnPlan">
				<spring:message code="organization.intPostOnPlan.desc" />
			</div>
		</div>				
		<div class="form-group row col-lg-4 col-md-6 col-sm-6 col-xs-12 ">
			<!-- 还款日调整区间内可调整次数 -->
			<label class="col-lg-6 col-md-5 col-sm-6 col-xs-6 control-label">
				<spring:message code="organization.adjStmtCount" text="还款日调整区间内可调整次数" />
				:
			</label>
			<div class=" col-lg-6 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="adjStmtCount"  data-rule-digits="true" data-rule-min="0" data-rule-max="9" />
			</div>
			<!-- 还款日调整区间内可调整次数描述 -->
			<div class="hide desc" for="adjStmtCount">
				<spring:message code="organization.adjStmtCount.desc" />
			</div>
		</div>				
		<div class="form-group row col-lg-4 col-md-6 col-sm-6 col-xs-12 ">
			<!-- 还款日调整区间（月） -->
			<label class="col-lg-6 col-md-5 col-sm-6 col-xs-6 control-label">
				<spring:message code="organization.adjStmtMonth" text="还款日调整区间（月）" />
				:
			</label>
			<div class=" col-lg-6 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="adjStmtMonth"  data-rule-digits="true" data-rule-min="0" data-rule-max="9" />
			</div>
			<!-- 还款日调整区间（月）描述 -->
			<div class="hide desc" for="adjStmtMonth">
				<spring:message code="organization.adjStmtMonth.desc" />
			</div>
		</div>				
		<div class="form-controls auto-float" >
			<div class="btn-group-md">
				<!-- 确定 -->
				<input type="button" class="btn-primary btn" id="submitBtn" value="<spring:message text="保存" code='kite.web.common.save' />" />
				<%-- <!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='取消' />" /> --%>
			</div>
		</div>
	</form:form>
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp"%>
	<script type="text/javascript">
		//开启表单验证
		$("#organizationUpdForm").validate();
		// 自定义提交
		$('#submitBtn').click(function() {
			// 处理数据
			var organizationUpdForm = $("#organizationUpdForm").getFormData();
			// 提交
			$K.ajax({
				type: 'post',
				url: '${ctx}/organization/saveOrganizationPage.in',
				contentType:"application/json;charset=utf-8",
				data: $K.JSON.stringify(organizationUpdForm),
				success: function() {
					layer.msg('<spring:message code="kite.web.common.operateSuccess" text="操作成功" />');
				}
			});
		});
		bindfun(".sel","Y","N");
		bindfun(".che","true","false");
		function bindfun(classStyle,cheVal,uncheVal){
			$(classStyle).each(function(i, ck) {
				//给开关判断事件
				$(this).change(function() {
					if ($(this).is(':checked')) {
						$(this).parent().find('input[type=hidden]').val(cheVal);
					} else {
						$(this).parent().find('input[type=hidden]').val(uncheVal);
					}
				});
			});
		}
	</script>
</body>
</html>
	