<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="pcmSettleAccMan.update.title" text="结算账号管理修改" /></title>
<%@ include file="/common/head.jsp"%>
</head>
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="pcmSettleAccManUpdForm" cssStyle="padding-top: 40px" modelAttribute="pcmSettleAccMan" method="post" action="${ctx}/pcmSettleAccMan/updPcmSettleAccMan.in" data-confirm="true">
		<form:hidden path="settleAccCode" />
		<div class="form-group row">
			<!-- 结算账号描述 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmSettleAccMan.settleAccDes" text="结算账号描述" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="settleAccDes"  data-rule-maxlength="200" />
			</div>
			<!-- 结算账号描述描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmSettleAccMan.settleAccDes.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 账号归属 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmSettleAccMan.accountOwner" text="账号归属" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="accountOwner" id="accountOwner" onchange="typeChange();" data-rule-required="true">
					<option value=""><spring:message code="kite.web.common.accountOwner" text="--请选择--" /></option>
					<form:options items="${accountOwner}" />
				</form:select>
			</div>
			<!-- 账号归属描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmSettleAccMan.accountOwner.desc" />
			</div>
		</div>				
		<!-- <div class="form-group row">
			统一社会信用代码
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<%--<spring:message code="pcmSettleAccMan.unifiedSocCreCode" text="统一社会信用代码" />--%>
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<%--<form:input cssClass="form-control" type="text" path="unifiedSocCreCode"  data-rule-maxlength="100" />--%>
			</div>
			统一社会信用代码描述
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<%--<spring:message code="pcmSettleAccMan.unifiedSocCreCode.desc" />--%>
			</div>
		</div> -->	
		<div class="form-group row">
			<!-- 账号归属主体 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmSettleAccMan.orgCode" text="账号归属主体" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="orgCode" id="partnerCode">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
				</form:select>
			</div>
			<!-- 账号归属主体描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmSettleAccMan.orgCode.desc" />
			</div>
		</div>			
		<!-- <div class="form-group row">
			机构编号
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmSettleAccMan.orgCode" text="机构编号" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="orgCode"  data-rule-maxlength="32" />
			</div>
			机构编号描述
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmSettleAccMan.orgCode.desc" />
			</div>
		</div> -->
		<div class="form-group row">
			<!-- 机构账号类型 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmSettleAccMan.organizationAccountType" text="机构账号类型 " />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="organizationAccountType">
					<form:options items="${organizationAccountType}" />
				</form:select>
			</div>
			<!-- 机构账号类型描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmSettleAccMan.organizationAccountType.desc" />
			</div>
		</div>

		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
			style="margin-left: 20px">
			<h2>
				<spring:message code="pcmSettleAccMan.accInfo.title" text="账号信息" />
			</h2>
			<hr>
		</div>
		<div class="form-group row">
			<!-- 单位名称 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
			<span class="span-icon">*&nbsp;</span>
				<spring:message code="pcmSettleAccMan.unitName" text="单位名称" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="unitName"  data-rule-maxlength="100" />
			</div>
			<!-- 单位名称描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmSettleAccMan.unitName.desc" />
			</div>
		</div>	
		<div class="form-group row">
			<!-- 银行账户 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
			<span class="span-icon">*&nbsp;</span>
				<spring:message code="pcmSettleAccMan.bankAccount" text="银行账户" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="bankAccount"  data-rule-maxlength="100" />
			</div>
			<!-- 银行账户描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmSettleAccMan.bankAccount.desc" />
			</div>
		</div>

		<!-- <div class="form-group row">
			账户备注名
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<%--<spring:message code="pcmSettleAccMan.accNoteName" text="账户备注名" />--%>
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<%--<form:input cssClass="form-control" type="text" path="accNoteName"  data-rule-maxlength="32" />--%>
			</div>
			账户备注名描述
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<%--<spring:message code="pcmSettleAccMan.accNoteName.desc" />--%>
			</div>
		</div>				
		<div class="form-group row">
			对公账户的开户行号
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<%--<spring:message code="pcmSettleAccMan.pubOpenNum" text="对公账户的开户行号" />--%>
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<%--<form:input cssClass="form-control" type="text" path="pubOpenNum"  data-rule-maxlength="100" />--%>
			</div>
			对公账户的开户行号描述
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<%--<spring:message code="pcmSettleAccMan.pubOpenNum.desc" />--%>
			</div>
		</div>				 -->
		<div class="form-group row">
			<!-- 开户银行 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmSettleAccMan.openBank" text="开户银行" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="openBank"  data-rule-maxlength="100" />
			</div>
			<!-- 开户银行描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmSettleAccMan.openBank.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 开户行省份 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
			<span class="span-icon">*&nbsp;</span>
				<spring:message code="pcmSettleAccMan.openBankProv" text="开户行省份" />
				:
			</label>
			<div class="col-lg-7 col-md-7  col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="openBankProv" id="openBankProv">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${openBankProv}" />
				</form:select>
			</div>
			<!-- 开户行省份描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmSettleAccMan.openBankProv.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 开户行城市 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="pcmSettleAccMan.openBankCity" text="开户行城市" />
				:
			</label>
			<div id="cityBox" class="col-lg-7 col-md-7  col-sm-6 col-xs-12" >
				<form:select cssClass="form-control" path="openBankCity" id="openBankCity" name="openBankCity">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${city}" />
				</form:select>
			</div>
			<!-- 开户行城市描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmSettleAccMan.openBankCity.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 开户行支行 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
			<span class="span-icon">*&nbsp;</span>
				<spring:message code="pcmSettleAccMan.openBankBranch" text="开户行支行" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="openBankBranch"  data-rule-maxlength="100" />
			</div>
			<!-- 开户行支行描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmSettleAccMan.openBankBranch.desc" />
			</div>
		</div>				
		<div class="form-controls auto-float" >
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
		$("#pcmSettleAccManUpdForm").validate();
		//省份城市
		//省份城市
		$("#openBankProv")
				.on(
						"change",
						function() {

							$
									.ajax({
										type : "post",
										url : "${ctx}/webCommon/loadCity.in ",
										cache : false,
										//async : false,
										data : $("#openBankProv").val(),
										dataType : "json",
										contentType : "application/json",
										success : function(data) {
											$("#cityBox").empty();
											$("#cityBox")
													.append(
															`<select id="openBankCity" class="form-control" name="openBankCity"><option value="">--- 请选择 --- </option></select>`);
											for ( var key in data) {
												$("#openBankCity").append(
														`<option value=`+key+`>`
														+ data[key]
														+ `</option>`);
											}
										}

									});
						});
		
		
		$(function(){
			//初始化数据
			typeChange();
		});
		
		function typeChange(){
			var type = $("#accountOwner").val();
			if(type=='F'){
				var map = ${fundSideInfoMap}
				$("#partnerCode").empty();
				for(var key in map){
					$("#partnerCode").append('<option value="'+key+'">'+map[key]+'</option>');
				}
				$("#partnerCode").selectpicker("refresh");
			}
			if(type=='A'){
				var map = ${assetSideInfoMap}
				$("#partnerCode").empty();
				for(var key in map){
					$("#partnerCode").append('<option value="'+key+'">'+map[key]+'</option>');
				}
				$("#partnerCode").selectpicker("refresh");
			}
			if(type=='Q'){
				var map = ${channelInfoMap}
				$("#partnerCode").empty();
				for(var key in map){
					$("#partnerCode").append('<option value="'+key+'">'+map[key]+'</option>');
				}
				$("#partnerCode").selectpicker("refresh");
			}
			if(type=='Z'){
				var map = ${serverInfoMap}
				$("#partnerCode").empty();
				for(var key in map){
					$("#partnerCode").append('<option value="'+key+'">'+map[key]+'</option>');
				}
				$("#partnerCode").selectpicker("refresh");
			}
		}
	</script>
</body>
</html>