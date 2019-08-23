<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="channelInfo.add.title" text="渠道方基本信息新增" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="channelInfoAddForm" cssStyle="padding-top: 40px" modelAttribute="channelInfo" method="post" action="${ctx}/channelInfo/addChannelInfo.in" data-confirm="true">
		<div class="form-group row">
			<!-- 渠道方编码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="channelInfo.channelCode" text="渠道方编码" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="channelCode"  data-rule-required="true" data-rule-maxlength="32" />
			</div>
			<!-- 渠道方编码描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="channelInfo.channelCode.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 渠道方描述 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="channelInfo.channelDesc" text="渠道方描述" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control"  path="channelDesc"  data-rule-required="true" data-rule-maxlength="50" />
			</div>
			<!-- 渠道方描述描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="channelInfo.channelDesc.desc" />
			</div>
		</div>
		
		<div class="form-group row">
			<!-- 联系电话 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="channelInfo.phone" text="联系电话" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="phone" />
			</div>
			<!-- 联系电话描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="channelInfo.phone.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 联系人 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="channelInfo.linkman" text="联系人" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="linkman"   />
			</div>
			<!-- 联系人描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="channelInfo.linkman.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 传真 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="channelInfo.fax" text="传真" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="fax"  data-rule-maxlength="8" />
			</div>
			<!-- 传真描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="channelInfo.fax.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 电子邮箱 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="channelInfo.email" text="电子邮箱" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="email"   data-rule-maxlength="50" />
			</div>
			<!-- 电子邮箱描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="channelInfo.email.desc" />
			</div>
		</div>


		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
			style="margin-left: 20px">
			<h2>
				<spring:message code="channelInfo.businessLicense" text="营业执照信息" />
			</h2>
			<hr>
		</div>



		<div class="form-group row">
			<!-- 名称 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="channelInfo.companyName" text="名称" />
				:
			</label>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<form:input cssClass="form-control" type="text" path="companyName"  data-rule-required="true" data-rule-maxlength="50" />
			</div>
			<!-- 名称描述 -->
			<div class="hide desc" for="companyName">
				<spring:message code="channelInfo.companyName.desc" />
			</div>
		
			<!-- 登记机关 -->
			<label class="col-lg-1 col-md-1 col-sm-1 col-xs-1 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="channelInfo.registrationAuthority" text="登记机关" />
				:
			</label>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<form:input cssClass="form-control" type="text" path="registrationAuthority"  data-rule-required="true" data-rule-maxlength="30" />
			</div>
			<!-- 登记机关描述 -->
			<div class="hide desc" for="registrationAuthority">
				<spring:message code="channelInfo.registrationAuthority.desc" />
			</div>
			<!-- 成立时间 -->
			<label class="col-lg-1 col-md-1 col-sm-1 col-xs-1 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="channelInfo.registerDate" text="成立时间" />
				:
			</label>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
				<form:input class='form-control customize-datetime' type="text" data-picker-position="top-right" data-role-formate="yyyy-mm-dd" path="registerDate" onfocus="this.blur()"  data-rule-required="true" />
				<i class="fa fa-calendar input_date" ></i>
			</div>
			<!-- 成立时间描述 -->
			<div class="desc hide" for="registerDate">
				<spring:message code="channelInfo.registerDate.desc" />
			</div>
		</div>
		
		
		
		<div class="form-group row">
			<!-- 统一社会信用代码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="channelInfo.unifySocialCreditCode" text="统一社会信用代码" />
				:
			</label>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<form:input cssClass="form-control" type="text" path="unifySocialCreditCode" 
						 data-rule-required="true"  />
			</div>
			<!-- 统一社会信用代码描述 -->
			<div class="hide desc" for="unifySocialCreditCode">
				<spring:message code="channelInfo.unifySocialCreditCode.desc" />
			</div>
			<!-- 类型 -->
			<label class="col-lg-1 col-md-1 col-sm-1 col-xs-1 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="channelInfo.companyType" text="类型" />
				:
			</label>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<form:select cssClass="form-control" path="companyType">
					<form:options items="${companyType}" />
				</form:select>
			</div>
			<!-- 类型描述 -->
			<div class="hide desc" for="companyType">
				<spring:message code="channelInfo.companyType.desc" />
			</div>
			<!-- 营业期限有限期起始日期 -->
			<label class="col-lg-1 col-md-1 col-sm-1 col-xs-1 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="channelInfo.businessBeginDate" text="营业期限有限期起始日期" />
				:
			</label>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
				<form:input class='form-control customize-datetime' type="text" data-picker-position="top-right" data-role-formate="yyyy-mm-dd" path="businessBeginDate" onfocus="this.blur()"  data-rule-required="true" />
				<i class="fa fa-calendar input_date" ></i>
			</div>
			<!-- 营业期限有限期起始日期描述 -->
			<div class="hide desc " for="businessBeginDate">
				<spring:message code="channelInfo.businessBeginDate.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 营业期限有限期截止日期 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="channelInfo.businessEndDate" text="营业期限有限期截止日期" />
				:
			</label>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
				<form:input class='form-control customize-datetime' type="text" data-picker-position="top-right" data-role-formate="yyyy-mm-dd" path="businessEndDate" onfocus="this.blur()"  data-rule-required="true" />
				<i class="fa fa-calendar input_date" ></i>
			</div>
			<!-- 营业期限有限期截止日期描述 -->
			<div class="hide desc" for="businessEndDate">
				<spring:message code="channelInfo.businessEndDate.desc" />
			</div>
			<!-- 营业执照号码 -->
			<label class="col-lg-1 col-md-1 col-sm-1 col-xs-1 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="channelInfo.businessLicenseNumber" text="营业执照号码" />
				:
			</label>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<form:input cssClass="form-control" type="text" path="businessLicenseNumber"  data-rule-required="true" data-rule-maxlength="15" />
			</div>
			<!-- 营业执照号码描述 -->
			<div class="hide desc" for="businessLicenseNumber">
				<spring:message code="channelInfo.businessLicenseNumber.desc" />
			</div>
			
			<!-- 实收资本 -->
			<label class="col-lg-1 col-md-1 col-sm-1 col-xs-1 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="channelInfo.paidInCapital" text="实收资本" />
				:
			</label>
			<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
				<form:input cssClass="form-control" type="text" path="paidInCapital.sumNum" id="sumNum" data-rule-required="true" data-rule-maxlength="12" />
			</div>
			<div class="col-lg-1 col-md-1 ol-sm-1 col-xs-1">
				<form:select cssClass="form-control" path="paidInCapital.currencyCd" id="currencyCd" data-rule-required="true">
					<form:options items="${currencyCds}" />
				</form:select>
			</div>
			<!-- 实收资本描述 -->
			<div class="hide desc" for="sumNum">
				<spring:message code="channelInfo.paidInCapital.desc" />
			</div>
		</div>
		
		
		
		<div class="form-group row">
			<!-- 法定代表人 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="channelInfo.legalPerson" text="法定代表人" />
				:
			</label>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<form:input cssClass="form-control" type="text" path="legalPerson"  data-rule-required="true" data-rule-maxlength="15" />
			</div>
			<!-- 法定代表人描述 -->
			<div class="hide desc" for="legalPerson">
				<spring:message code="channelInfo.legalPerson.desc" />
			</div>

			<!-- 注册资本 -->
			<label class="col-lg-1 col-md-1 col-sm-1 col-xs-1 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="channelInfo.registerMoney" text="注册资本" />
				:
			</label>
			<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
				<form:input cssClass="form-control" type="text" path="registerMoney.sumNum" id="sumNumR"  data-rule-required="true" data-rule-maxlength="12" />
			</div>
			
			<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
				<form:select cssClass="form-control" path="registerMoney.currencyCd" id="registerMoney.currencyCd" data-rule-required="true">
					<form:options items="${currencyCds}" />
				</form:select>
			</div>
			<!-- 注册资本描述 -->
			<div class="hide desc" for="sumNumR">
				<spring:message code="channelInfo.registerMoney.desc" />
			</div>
			<!-- 登记时间 -->
			<label class="col-lg-1 col-md-1 col-sm-1 col-xs-1 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="channelInfo.register" text="登记时间" />
				:
			</label>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
				<form:input class='form-control customize-datetime'  type="text"
					 data-picker-position="top-right" data-role-formate="yyyy-mm-dd" path="register" onfocus="this.blur()"  data-rule-required="true" />
				<i class="fa fa-calendar input_date" ></i>
			</div>
			<!-- 登记时间描述 -->
			<div class="hide desc" for="register">
				<spring:message code="channelInfo.register.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 住所 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="channelInfo.residence" text="住所" />
				:
			</label>
			
			
			<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
			<!-- 国家 -->
				<div class="col-lg-2 col-md-1 col-sm-1 col-xs-1">
					<!-- 	<form:input cssClass="form-control" type="text" path="residence.country"  data-rule-required="true" data-rule-maxlength="30" /> -->
					<select class="form-control" path="residence.country" id="country">
						<option value="中国" >中国</option>
					<select>
					
				</div>
					<div class=" hide desc" for="country">
							<spring:message code="channelInfo.residence.country"/>
						</div>
			<!-- 省 先把省选择上-->
				<div class="col-lg-2 col-md-1 col-sm-1 col-xs-1">
					<!-- <form:input cssClass="form-control" type="text" path="residence.province"  data-rule-required="true" data-rule-maxlength="30" /> -->
					<form:select cssClass="form-control" path="residence.province" id="province" data-rule-required="true">
						<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
						<form:options items="${province}" />
					</form:select>
				
			
				</div>
						<div class=" hide desc" for="province">
						<spring:message code="channelInfo.residence.province"/>
					</div>
				
			<!-- 市 -->	
				<div class="col-lg-2 col-md-1 col-sm-1 col-xs-1" id="cityBox">
					<!-- <form:input cssClass="form-control" type="text" path="residence.city"  data-rule-required="true" data-rule-maxlength="30" />
					 -->
					 
					<form:select cssClass="form-control" path="residence.city" id="city" >
						<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
						<form:options items="${channelInfo.residence.city}" />
					</form:select>
						
				</div>
				
				<div class=" hide desc" for="city">
						<spring:message code="channelInfo.residence.city"/>
				</div>
				
				<div class="col-lg-2 col-md-1 col-sm-1 col-xs-1" id="microdistrictBox">
					<!-- <form:input cssClass="form-control" type="text" path="residence.microdistrict"  id="microdistrict" data-rule-required="true" data-rule-maxlength="30" /> -->
					<form:select cssClass="form-control" path="residence.microdistrict" id="microdistrict" >
						<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
						<form:options items="${channelInfo.residence.microdistrict}" />
					</form:select>
					
				</div>
				<div class=" hide desc" for="microdistrict">
						<spring:message code="channelInfo.residence.microdistrict"/>
					</div>
				
				<div class="col-lg-4 col-md-1 col-sm-1 col-xs-1">
					<form:input cssClass="form-control" type="text" path="residence.specificInformation" id="specificInformation"  data-rule-required="true" data-rule-maxlength="30" />
					
					<div class=" hide desc" for="specificInformation">
						<spring:message code="channelInfo.residence.specificInformation"/>
					</div>
				</div>
				<!-- <form:input cssClass="form-control" type="text" path="residence"  data-rule-required="true" data-rule-maxlength="0" /> -->
			
			</div>
			
			<!-- 住所描述 -->
	<!-- 		<div class="hide desc" for="residence.country">
				<spring:message code="channelInfo.residence.desc" />
			</div> -->
		</div>
		<div class="form-group row">
			<!-- 经营范围 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="channelInfo.businessScope" text="经营范围" />
				:
			</label>
			<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
				<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
				<form:textarea class='form-control'   path="businessScope"    />
			</div>
			<!-- 经营范围描述 -->
			<div class="desc hide" for="businessScope">
				<spring:message code="channelInfo.businessScope.desc" />
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
		$("#channelInfoAddForm").validate();
		
		
		
		//得到頁面上所有class 为 desc 的标签
		$.each($(".desc"), function(i, d) {
			var tar = $('#' + $(d).attr('for')), desc = d.innerText;
			//var tar = $("input[name='"+$(d).attr('for')+"']"), desc = d.innerText;
			if (tar && tar[0] && tar[0].tagName === 'SELECT') {
				tar = tar.parent();
			}
			tar.tooltip({
				title : desc
			});
		});
		
		
		
		
		$("#province")
		.on(
				"change",
				function() {
					$.ajax({
								type : "post",
								url : "${ctx}/webCommon/loadCity.in ",
								cache : false,
								//async : false,
								data : $("#province").val(),
								dataType : "json",
								contentType : "application/json",
								success : function(data) {
			
									 $("#cityBox").empty();
									$("#cityBox")
											.append(
													`<select id="city" class="form-control" name="residence.city"><option value="">--- 请选择 --- </option></select>`);
									for ( var key in data) {
										$("#city").append(
												`<option value=`+key+`>`
														+ data[key]
														+ `</option>`);
									} 
								}

							});
				});
		
		
		

		$(document)
		.on(
				"change",
				"#city",
				function() {
					$.ajax({
								type : "post",
								url : "${ctx}/webCommon/loadDistricts.in  ",
								cache : false,
								//async : false,
								data : $("#city").val(),
								dataType : "json",
								contentType : "application/json",
								success : function(data) {
			
									 $("#microdistrictBox").empty();
									$("#microdistrictBox")
											.append(
													`<select id="microdistrict" class="form-control" name="residence.microdistrict"><option value="">--- 请选择 --- </option></select>`);
									for ( var key in data) {
										$("#microdistrict").append(
												`<option value=`+key+`>`
														+ data[key]
														+ `</option>`);
									} 
								}

							});
				});
		
		
		
	</script>
</body>
</html>