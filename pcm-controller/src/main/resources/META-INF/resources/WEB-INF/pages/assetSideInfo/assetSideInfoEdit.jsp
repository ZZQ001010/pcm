<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="assetSideInfo.update.title" text="资产方基本信息
修改" /></title>
<%@ include file="/common/head.jsp"%>
</head>
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="assetSideInfoUpdForm" cssStyle="padding-top: 40px" modelAttribute="assetSideInfo" method="post" action="${ctx}/assetSideInfo/updAssetSideInfo.in" data-confirm="true">
        <form:hidden path="assetSideCode" />
		
			<div class="form-group row">
			<!-- 资产方描述 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="assetSideInfo.assetSideDesc" text="资产方描述" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control"  path="assetSideDesc"  data-rule-required="true" data-rule-maxlength="50" />
			</div>
			<!-- 资产方描述描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="assetSideInfo.assetSideDesc.desc" />
			</div>
		</div>
		
		<%--<div class="form-group row">--%>
			<%--<!-- 资产方类型 -->--%>
			<%--<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">--%>
				<%--<span class="span-icon">*&nbsp;</span>--%>
				<%--<spring:message code="assetSideInfo.assetSideType" text="资产方类型" />--%>
				<%--:--%>
			<%--</label>--%>
			<%--<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">--%>
				<%--<form:select cssClass="form-control" path="assetSideType">--%>
					<%--<form:options items="${assetSideType}" />--%>
				<%--</form:select>--%>
			<%--</div>--%>
			<%--<!-- 资产方类型描述 -->--%>
			<%--<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">--%>
				<%--<spring:message code="assetSideInfo.assetSideType.desc" />--%>
			<%--</div>--%>
		<%--</div>--%>
		<div class="form-group row">
			<!-- 资产方担保方式 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="assetSideInfo.assetSideWarrantWay" text="资产方担保方式" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="assetSideWarrantWay">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${assetSideWarrantWay}" />
				</form:select>
			</div>
			<!-- 资产方担保方式描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="assetSideInfo.assetSideWarrantWay.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 联系电话1 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="assetSideInfo.phone1" text="联系电话1" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="phone1"  data-rule-required="true" />
			</div>
			<!-- 联系电话1描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="assetSideInfo.phone1.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 联系电话2 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="assetSideInfo.linkman1" text="联系人1" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="linkman1"   />
			</div>
			<!-- 联系电话2描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="assetSideInfo.linkman1.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 传真 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="assetSideInfo.fax" text="传真" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="fax"  data-rule-maxlength="8" />
			</div>
			<!-- 传真描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="assetSideInfo.fax.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 电子邮箱 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="assetSideInfo.email" text="电子邮箱" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="email"  data-rule-required="true" data-rule-maxlength="50" />
			</div>
			<!-- 电子邮箱描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="assetSideInfo.email.desc" />
			</div>
		</div>
		
		
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
			style="margin-left: 20px">
			<h2>
				<spring:message code="assetSideInfo.businessLicense" text="营业执照信息" />
			</h2>
			<hr>
		</div>
		
		
		<div class="form-group row">
			<!-- 名称 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="assetSideInfo.companyName" text="名称" />
				:
			</label>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<form:input cssClass="form-control" type="text" path="companyName"   data-rule-maxlength="50" />
			</div>
			<!-- 名称描述 -->
			<div class="hide desc" for="companyName">
				<spring:message code="assetSideInfo.companyName.desc" />
			</div>
			
			<!-- 登记机关 -->
			<label class="col-lg-1 col-md-1 col-sm-1 col-xs-1 control-label">
				<spring:message code="assetSideInfo.registrationAuthority" text="登记机关" />
				:
			</label>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<form:input cssClass="form-control" type="text" path="registrationAuthority"    data-rule-maxlength="30" />
			</div>
			<!-- 登记机关描述 -->
			<div class="hide desc" for="registrationAuthority">
				<spring:message code="assetSideInfo.registrationAuthority.desc" />
			</div>
			<!-- 成立时间 -->
			<label class="col-lg-1 col-md-1 col-sm-1 col-xs-1 control-label">
				<spring:message code="assetSideInfo.registerDate" text="成立时间" />
				:
			</label>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
				<fmt:formatDate var="registerDateFmt" value="${assetSideInfo.registerDate}" type="date" pattern="yyyy-MM-dd"/>
				<form:input class='form-control customize-datetime'  value="${registerDateFmt }"
					type="text" data-picker-position="top-right" data-role-formate="yyyy-mm-dd" 
					path="registerDate" onfocus="this.blur()"  data-rule-required="true" />
				<i class="fa fa-calendar input_date" ></i>
			</div>
			<!-- 成立时间描述 -->
			<div class="hide desc" for="registerDate">
				<spring:message code="assetSideInfo.registerDate.desc" />
			</div>
		</div>
		<div class="form-group row">
	<!-- 统一社会信用代码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="assetSideInfo.unifySocialCreditCode" text="统一社会信用代码" />
				:
			</label>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<form:input cssClass="form-control" type="text" path="unifySocialCreditCode" 
						   data-rule-maxlength="12" />
			</div>
			<!-- 统一社会信用代码描述 -->
			<div class="hide desc" for="unifySocialCreditCode">
				<spring:message code="assetSideInfo.unifySocialCreditCode.desc" />
			</div>

			<!-- 类型 -->
			<label class="col-lg-1 col-md-1 col-sm-1 col-xs-1 control-label">
				<spring:message code="assetSideInfo.companyType" text="类型" />
				:
			</label>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<form:select cssClass="form-control" path="companyType">
					<form:options items="${companyType}" />
				</form:select>
			</div>
			<!-- 类型描述 -->
			<div class="hide desc" for="companyType">
				<spring:message code="assetSideInfo.companyType.desc" />
			</div>
			
			<!-- 营业期限有限期起始日期 -->
			<label class="col-lg-1 col-md-1 col-sm-1 col-xs-1 control-label">
				<spring:message code="assetSideInfo.businessBeginDate" text="营业期限有限期起始日期" />
				:
			</label>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
				<fmt:formatDate var="businessBeginDateFmt" value="${assetSideInfo.businessBeginDate}" type="date" pattern="yyyy-MM-dd"/>
				
				<form:input class='form-control customize-datetime'  value="${businessBeginDateFmt }"
				 type="text" data-picker-position="top-right" data-role-formate="yyyy-mm-dd" 
				 path="businessBeginDate" onfocus="this.blur()"  data-rule-required="true" />
				<i class="fa fa-calendar input_date" ></i>
			</div>
			<!-- 营业期限有限期起始日期描述 -->
			<div class="hide desc" for="businessBeginDate">
				<spring:message code="assetSideInfo.businessBeginDate.desc" />
			</div>
		</div>
		
		
		<div class="form-group row">
			<!-- 营业期限有限期截止日期 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="assetSideInfo.businessEndDate" text="营业期限有限期截止日期" />
				:
			</label>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
				<fmt:formatDate var="businessEndDateFmt" value="${assetSideInfo.businessEndDate}" type="date" pattern="yyyy-MM-dd"/>
				
				<form:input class='form-control customize-datetime' value="${businessEndDateFmt }" type="text" data-picker-position="top-right" data-role-formate="yyyy-mm-dd" path="businessEndDate" onfocus="this.blur()"    />
				<i class="fa fa-calendar input_date" ></i>
			</div>
			<!-- 营业期限有限期截止日期描述 -->
			<div class="hide desc" for="businessEndDate">
				<spring:message code="assetSideInfo.businessEndDate.desc" />
			</div>

			<!-- 营业执照号码 -->
			<label class="col-lg-1 col-md-1 col-sm-1 col-xs-1 control-label">
				<spring:message code="assetSideInfo.businessLicenseNumber" text="营业执照号码" />
				:
			</label>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<form:input cssClass="form-control" type="text" path="businessLicenseNumber"    data-rule-maxlength="15" />
			</div>
			<!-- 营业执照号码描述 -->
			<div class="hide desc" for="businessLicenseNumber">
				<spring:message code="assetSideInfo.businessLicenseNumber.desc" />
			</div>
			
			<!-- 实收资本 -->
			<label class="col-lg-1 col-md-1 col-sm-1 col-xs-1 control-label">
				<spring:message code="assetSideInfo.paidInCapital" text="实收资本" />
				:
			</label>
			<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
				<form:input cssClass="form-control" type="text" path="paidInCapital.sumNum" id="sumNum"  data-rule-maxlength="12" />
			</div>
			<div class="col-lg-1 col-md-1 ol-sm-1 col-xs-1">
				<form:select cssClass="form-control" path="paidInCapital.currencyCd" id="currencyCd"  >
					<form:options items="${currencyCds}" />
				</form:select>
			</div>
			<!-- 实收资本描述 -->
			<div class="hide desc" for="sumNum">
				<spring:message code="assetSideInfo.paidInCapital.desc" />
			</div>
		</div>
		
		
		
		<div class="form-group row">
			<!-- 法定代表人 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="assetSideInfo.legalPerson" text="法定代表人" />
				:
			</label>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<form:input cssClass="form-control" type="text" path="legalPerson"    data-rule-maxlength="15" />
			</div>
			<!-- 法定代表人描述 -->
			<div class="hide desc" for="legalPerson">
				<spring:message code="assetSideInfo.legalPerson.desc" />
			</div>

			<!-- 注册资本 -->
			<label class="col-lg-1 col-md-1 col-sm-1 col-xs-1 control-label">
				<spring:message code="assetSideInfo.registerMoney" text="注册资本" />
				:
			</label>
			<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
				<form:input cssClass="form-control" type="text" path="registerMoney.sumNum" id="sumNumR"    data-rule-maxlength="12" />
			</div>
			
			<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
				<form:select cssClass="form-control" path="registerMoney.currencyCd" id="registerMoney.currencyCd"  >
					<form:options items="${currencyCds}" />
				</form:select>
			</div>
			<!-- 注册资本描述 -->
			<div class="hide desc" for="sumNumR">
				<spring:message code="assetSideInfo.registerMoney.desc" />
			</div>
			
			<!-- 登记时间 -->
			<label class="col-lg-1 col-md-1 col-sm-1 col-xs-1 control-label">
				<spring:message code="assetSideInfo.register" text="登记时间" />
				:
			</label>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
				<fmt:formatDate var="registerFmt" value="${assetSideInfo.register}" type="date" pattern="yyyy-MM-dd"/>
				<form:input class='form-control customize-datetime' value="${registerFmt }"  type="text" data-picker-position="top-right" data-role-formate="yyyy-mm-dd" path="register" onfocus="this.blur()"    />
				<i class="fa fa-calendar input_date" ></i>
			</div>
			<!-- 登记时间描述 -->
			<div class="hide desc" for="register">
				<spring:message code="assetSideInfo.register.desc" />
			</div>
		</div>
		
		
		
		
		
		
		
		<div class="form-group row">
			<!-- 住所 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="assetSideInfo.residence" text="住所" />
				:
			</label>
			
			
			<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
			<!-- 国家 -->
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
					<!-- 	<form:input cssClass="form-control" type="text" path="residence.country"  data-rule-required="true" data-rule-maxlength="30" /> -->
					<select class="form-control" path="residence.country" id="country">
						<option value="中国" >中国</option>
					<select>
					
				</div>
					<div class=" hide desc" for="country">
							<spring:message code="assetSideInfo.residence.country"/>
						</div>
			<!-- 省 先把省选择上-->
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
					<!-- <form:input cssClass="form-control" type="text" path="residence.province"  data-rule-required="true" data-rule-maxlength="30" /> -->
					<form:select cssClass="form-control" path="residence.province" id="province">
						<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
						<form:options items="${province}" />
					</form:select>
				
			
				</div>
						<div class=" hide desc" for="province">
						<spring:message code="assetSideInfo.residence.province"/>
					</div>
				
			<!-- 市 -->	
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2" id="cityBox">
					<!-- <form:input cssClass="form-control" type="text" path="residence.city"  data-rule-required="true" data-rule-maxlength="30" />
					 -->
					 
					<form:select cssClass="form-control" path="residence.city" id="city" >
						<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
						<form:options items="${city}" />
					</form:select>
						
				</div>
				
				<div class=" hide desc" for="city">
						<spring:message code="assetSideInfo.residence.city"/>
				</div>
				
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2" id="microdistrictBox">
					<!-- <form:input cssClass="form-control" type="text" path="residence.microdistrict"  id="microdistrict" data-rule-required="true" data-rule-maxlength="30" /> -->
					<form:select cssClass="form-control" path="residence.microdistrict" id="microdistrict" >
						<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
						<form:options items="${microdistrict}" />
					</form:select>
					
				</div>
				<div class=" hide desc" for="microdistrict">
						<spring:message code="assetSideInfo.residence.microdistrict"/>
					</div>
				
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
					<form:input cssClass="form-control" type="text" path="residence.specificInformation" id="specificInformation"    data-rule-maxlength="30" />
					
					<div class=" hide desc" for="specificInformation">
						<spring:message code="assetSideInfo.residence.specificInformation"/>
					</div>
				</div>
				<!-- <form:input cssClass="form-control" type="text" path="residence"  data-rule-required="true" data-rule-maxlength="0" /> -->
			
			</div>
			
			
			
			<!-- 住所描述 -->
	<!-- 		<div class="hide desc" for="residence.country">
				<spring:message code="assetSideInfo.residence.desc" />
			</div> -->
		</div>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		<div class="form-group row">
			<!-- 经营范围 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="assetSideInfo.businessScope" text="经营范围" />
				:
			</label>
			<div class="col-lg-8 col-md-8 col-sm-8 col-xs-6">
				<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
				<form:textarea class='form-control'   path="businessScope"    />
			</div>
			<!-- 经营范围描述 -->
			<div class="hide desc" for="businessScope">
				<spring:message code="assetSideInfo.businessScope.desc" />
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
		$("#assetSideInfoUpdForm").validate();
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