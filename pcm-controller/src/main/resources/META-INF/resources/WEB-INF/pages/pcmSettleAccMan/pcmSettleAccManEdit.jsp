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
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="pcmSettleAccMan.settleAccDes" text="结算账号描述" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="settleAccDes"  data-rule-maxlength="200" data-rule-required="true" />
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
				<form:select cssClass="form-control"  path="accountOwner" >
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${accountOwner}" />
				</form:select> 
			</div>
			<!-- 账号归属描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmSettleAccMan.accountOwner.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 机构账号类型 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmSettleAccMan.organizationAccountType" text="机构账号类型" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select path="organizationAccountType" cssClass="form-control">
			 		<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${organizationAccountType}" />
				</form:select>
			</div>
			<!-- 机构账号类型描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmSettleAccMan.organizationAccountType.desc" />
			</div>
		</div>
		
		<div class="form-group row">
			<!-- 结算账号类型 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmSettleAccMan.settlementAccountType" text="结算账号类型" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select path="settlementAccountType" cssClass="form-control">
			 		<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${settlementAccountType}" />
				</form:select>
				<!-- <form:input cssClass="form-control" type="text" path="organizationAccountType"  data-rule-maxlength="32" /> -->
			</div>
			<!-- 结算账号类型描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmSettleAccMan.settlementAccountType.desc" />
			</div>
		</div>
		
		</br>
		<h2 style="margin-left: 20px">实体账号信息</h2>
		<hr>
				
		<div class="form-group row">
			<!-- 结算账号类型 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmSettleAccMan.settlementAccountType" text="结算账号类型" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select path="settlementAccountType" cssClass="form-control">
			 		<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${settlementAccountType}" />
				</form:select>
				<!-- <form:input cssClass="form-control" type="text" path="organizationAccountType"  data-rule-maxlength="32" /> -->
			</div>
			<!-- 机构账号类型描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmSettleAccMan.settlementAccountType.desc" />
			</div>
		</div>
						
		<div class="form-group row">
			<!-- 单位名称 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmSettleAccMan.unitName" text="单位名称" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="unitName"  data-rule-maxlength="32" />
			</div>
			<!-- 单位名称描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmSettleAccMan.unitName.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 银行账户 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmSettleAccMan.bankAccount" text="银行账户" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="bankAccount"  data-rule-maxlength="32" />
			</div>
			<!-- 银行账户描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmSettleAccMan.bankAccount.desc" />
			</div>
		</div>				
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
				<spring:message code="pcmSettleAccMan.openBankProv" text="开户行省份" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select path="openBankProv" cssClass="form-control">
			 		<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${province}" />
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
				<spring:message code="pcmSettleAccMan.openBankCity" text="开户行城市" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select path="openBankCity" cssClass="form-control">
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
			<!-- 开户区、县 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmSettleAccMan.district" text="开户区、县" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select path="district" cssClass="form-control">
			 		<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
			 		<form:options items="${district }" />
				</form:select>
			</div>
			<!-- 开户区、县描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmSettleAccMan.district.desc" />
			</div>
		</div>		
			
		<div class="form-group row">
			<!-- 开户行支行 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
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
		<h2 style="margin-left: 20px">虚拟账号信息</h2>
		<hr>			
		<div class="form-group row">
			<!-- 单位名称 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmSettleAccMan.vUnitName" text="单位名称" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="vUnitName"  data-rule-maxlength="32" />
			</div>
			<!-- 单位名称描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmSettleAccMan.vUnitName.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 银行账户 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmSettleAccMan.vBankAccount" text="银行账户" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="vBankAccount"  data-rule-maxlength="32" />
			</div>
			<!-- 银行账户描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmSettleAccMan.vBankAccount.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 开户银行 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmSettleAccMan.vOpenBank" text="开户银行" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="vOpenBank"  data-rule-maxlength="100" />
			</div>
			<!-- 开户银行描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmSettleAccMan.vOpenBank.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 开户行省份 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmSettleAccMan.vOpenBankProv" text="开户行省份" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
					<form:select path="vOpenBankProv" cssClass="form-control">
			 		<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${province}" />
				</form:select>
					
			<!-- 	<form:input cssClass="form-control" type="text" path="vOpenBankProv"  data-rule-maxlength="32" /> -->
			</div>
			<!-- 开户行省份描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmSettleAccMan.vOpenBankProv.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 开户行城市 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmSettleAccMan.vOpenBankCity" text="开户行城市" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select path="vOpenBankCity" cssClass="form-control">
			 		<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
			 		<form:options items="${vCity}" />
				</form:select>
			</div>
			<!-- 开户行城市描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmSettleAccMan.vOpenBankCity.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 开户区、县 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmSettleAccMan.vDistrict" text="开户区、县" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
								<form:select path="vDistrict" cssClass="form-control">
			 		<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
			 		<form:options items="${vDistrict }" />
				</form:select>
			</div>
			<!-- 开户区、县描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmSettleAccMan.vDistrict.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 开户行支行 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="pcmSettleAccMan.vOpenBankBranch" text="开户行支行" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="vOpenBankBranch"  data-rule-maxlength="100" />
			</div>
			<!-- 开户行支行描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmSettleAccMan.vOpenBankBranch.desc" />
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
		$("#pcmSettleAccManUpdForm").validate();
		
		
		
		
		
		$(function(){
			$('#vOpenBankProv').on('change',function(){
				$
				.ajax({
					type : "post",
					url : "${ctx}/webCommon/loadCity.in ",
					cache : false,
					//async : false,
					data : $("#vOpenBankProv").val(),
					dataType : "json",
					contentType : "application/json",
					success : function(data) {
						$("#vOpenBankCity").empty();
					/* 	$("#vOpenBankCity")
								.append(
										`<select id="vOpenBankCity" class="form-control" name="vOpenBankCity"><option value="">--- 请选择 --- </option></select>`); */
					$("#vOpenBankCity").append(`<option value="">--- 请选择 --- </option>`)
						for ( var key in data) {
							$("#vOpenBankCity").append(
									`<option value=`+key+`>`
											+ data[key]
											+ `</option>`);
						}
						$('#vOpenBankCity').selectpicker('refresh')
					}

				});
			})	
			
			$('#openBankProv').on('change',function(){
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
						$("#openBankCity").empty();
					/* 	$("#vOpenBankCity")
								.append(
										`<select id="vOpenBankCity" class="form-control" name="vOpenBankCity"><option value="">--- 请选择 --- </option></select>`); */
					$("#openBankCity").append(`<option value="">--- 请选择 --- </option>`)
						for ( var key in data) {
							$("#openBankCity").append(
									`<option value=`+key+`>`
											+ data[key]
											+ `</option>`);
						}
						$('#openBankCity').selectpicker('refresh')
					}

				});
			})
		})
		
		
		$('#openBankCity').on('change', function(){
			$
			.ajax({
				type : "post",
				url : "${ctx}/webCommon/loadDistricts.in ",
				cache : false,
				//async : false,
				data : $("#openBankCity").val(),
				dataType : "json",
				contentType : "application/json",
				success : function(data) {
					$("#district").empty();
				/* 	$("#vOpenBankCity")
							.append(
									`<select id="vOpenBankCity" class="form-control" name="vOpenBankCity"><option value="">--- 请选择 --- </option></select>`); */
				$("#district").append(`<option value="">--- 请选择 --- </option>`)
					for ( var key in data) {
						$("#district").append(
								`<option value=`+key+`>`
										+ data[key]
										+ `</option>`);
					}
					$('#district').selectpicker('refresh')
				}

			});
		})
			 
		
		
		
			$('#vOpenBankCity').on('change', function(){
			$
			.ajax({
				type : "post",
				url : "${ctx}/webCommon/loadDistricts.in ",
				cache : false,
				//async : false,
				data : $("#vOpenBankCity").val(),
				dataType : "json",
				contentType : "application/json",
				success : function(data) {
					$("#vDistrict").empty();
				/* 	$("#vOpenBankCity")
							.append(
									`<select id="vOpenBankCity" class="form-control" name="vOpenBankCity"><option value="">--- 请选择 --- </option></select>`); */
				$("#vDistrict").append(`<option value="">--- 请选择 --- </option>`)
					for ( var key in data) {
						$("#vDistrict").append(
								`<option value=`+key+`>`
										+ data[key]
										+ `</option>`);
					}
					$('#vDistrict').selectpicker('refresh')
				}

			});
		})
		
	</script>
</body>
</html>