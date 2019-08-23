<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="branch.add.title" text="分支机构新增" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
<style type="text/css">
label.detailStyle {
    font-weight: 700;
    margin-top: 10px;
    text-align: left;
}
@media (max-width: 768px) {
	.form-horizontal .control-label {
	    text-align: right !important;
	}
	.form-product .control-label {
		text-align: right !important;
	}
}
</style>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="branchAddForm" cssStyle="padding-top: 40px;padding-left: 10px" modelAttribute="branch" method="post" action="${ctx}/branch/addBranch.in" data-confirm="true">
		<div class="form-group row">
			<!-- 机构编号 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label"> <span class="span-icon">*&nbsp;</span> <spring:message code="branch.branchId" text="机构编号" /> :
			</label>
			<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
				<form:input cssClass="form-control" type="text" path="branchId" data-rule-required="true" data-rule-maxlength="9" />
			</div>
			<!-- 机构编号描述 -->
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
				<spring:message code="branch.branchId.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 机构名称 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label"> <span class="span-icon">*&nbsp;</span> <spring:message code="branch.name" text="机构名称" /> :
			</label>
			<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
				<form:input cssClass="form-control" type="text" path="name" data-rule-required="true" data-rule-maxlength="80" />
			</div>
			<!-- 机构名称描述 -->
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
				<spring:message code="branch.name.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 地址 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label"> <spring:message code="branch.address" text="地址" /> :
			</label>
			<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
				<form:input cssClass="form-control" type="text" path="address" data-rule-maxlength="200" />
			</div>
			<!-- 地址描述 -->
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
				<spring:message code="branch.address.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 机构所在国家代码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label"> <spring:message code="branch.countryCd" text="机构所在国家代码" /> :
			</label>
			<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
				<form:input cssClass="form-control" type="text" path="countryCd" data-rule-maxlength="3" />
			</div>
			<!-- 机构所在国家代码描述 -->
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
				<spring:message code="branch.countryCd.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 机构所在城市 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label"> <spring:message code="branch.city" text="机构所在城市" /> :
			</label>
			<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
				<form:input cssClass="form-control" type="text" path="city" data-rule-maxlength="20" />
			</div>
			<!-- 机构所在城市描述 -->
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
				<spring:message code="branch.city.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 机构所在区 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label"> <spring:message code="branch.district" text="区机构所在" /> :
			</label>
			<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
				<form:input cssClass="form-control" type="text" path="district" data-rule-maxlength="20" />
			</div>
			<!-- 区描述 -->
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
				<spring:message code="branch.district.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 邮编 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label"> <span class="span-icon">*&nbsp;</span> <spring:message code="branch.zip" text="邮编" /> :
			</label>
			<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
				<form:input cssClass="form-control" type="text" path="zip" data-rule-digits="true" data-rule-required="true" data-rule-maxlength="10" />
			</div>
			<!-- 邮编描述 -->
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
				<spring:message code="branch.zip.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 机构级别 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label"> <span class="span-icon">*&nbsp;</span> <spring:message code="branch.level" text="机构级别" /> :
			</label>
			<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
				<form:input cssClass="form-control" type="text" path="level" data-rule-required="true" data-rule-maxlength="1" />
			</div>
			<!-- 机构级别描述 -->
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
				<spring:message code="branch.level.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 机构联系电话1 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label"> <spring:message code="branch.phone1" text="机构联系电话1" /> :
			</label>
			<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
				<form:input cssClass="form-control" type="text" path="phone1" data-rule-digits="true" data-rule-maxlength="20" />
			</div>
			<!-- 机构联系电话1描述 -->
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
				<spring:message code="branch.phone1.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 机构联系电话2 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label"> <spring:message code="branch.phone2" text="机构联系电话2" /> :
			</label>
			<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
				<form:input cssClass="form-control" type="text" path="phone2" data-rule-digits="true" data-rule-maxlength="20" />
			</div>
			<!-- 机构联系电话2描述 -->
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
				<spring:message code="branch.phone2.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 上级机构编号 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label"> <span class="span-icon">*&nbsp;</span> <spring:message code="branch.superiorBranchId" text="上级机构编号" /> :
			</label>
			<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
				<form:input cssClass="form-control" type="text" path="superiorBranchId" data-rule-required="true" data-rule-maxlength="15" />
			</div>
			<!-- 上级机构编号描述 -->
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
				<spring:message code="branch.superiorBranchId.desc" />
			</div>
		</div>
		<div class="x_panel">
			<div class="x_title">
				<h2>
					<spring:message code="loanPlanDiff.loanFeeParam" text="银行账户参数" />
					<!--  <a href="#/credit-card"><i class="fa fa-credit-card"></i> </a>-->
				</h2>
				<ul class="nav navbar-right def-toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<div class="form-group row">
					<!-- 银行账号 -->
					<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label"> <span class="span-icon">*&nbsp;</span> <spring:message code="branch.settleAcctNbr" text="银行账号" /> :
					</label>
					<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
						<form:input cssClass="form-control" type="text" path="settleAcctNbr" data-rule-digits="true" data-rule-required="true" data-rule-maxlength="30" />
					</div>
					<!-- 银行账号描述 -->
					<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
						<spring:message code="branch.settleAcctNbr.desc" />
					</div>
				</div>
				<div class="form-group row">
					<!-- 银行代码 -->
					<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label"> <span class="span-icon">*&nbsp;</span> <spring:message code="branch.acctBankId" text="银行代码" /> :
					</label>
					<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
						<form:input cssClass="form-control" type="text" path="acctBankId" data-rule-required="true" data-rule-maxlength="9" />
					</div>
					<!-- 银行代码描述 -->
					<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
						<spring:message code="branch.acctBankId.desc" />
					</div>
				</div>
				<div class="form-group row">
					<!-- 银行名称 -->
					<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label"> <span class="span-icon">*&nbsp;</span> <spring:message code="branch.acctBank" text="银行名称" /> :
					</label>
					<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
						<form:input cssClass="form-control" type="text" path="acctBank"  data-rule-required="true" data-rule-maxlength="50" />
					</div>
					<!-- 银行名称描述 -->
					<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
						<spring:message code="branch.acctBank.desc" />
					</div>
				</div>
				<div class="form-group row">
					<!-- 省份 -->
					<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label"> <span class="span-icon">*&nbsp;</span> <spring:message code="branch.acctProvince" text="省份" /> :
					</label>
					<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
						<form:select cssClass="form-control" path="acctProvince" data-rule-required="true" >
							<option value=""><spring:message code="kite.web.common.pleaseChoose" /></option>
							<form:options items="${acctProvince}" />
						</form:select>
					</div>
					<!-- 省份描述 -->
					<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
						<spring:message code="branch.acctProvince.desc" />
					</div>
				</div>
				<div class="form-group row">
					<!-- 城市 -->
					<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label"> <span class="span-icon">*&nbsp;</span> <spring:message code="branch.acctCity" text="城市" /> :
					</label>
					<div id="acctCityBox" class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
						<form:select cssClass="form-control" path="acctProvince" data-rule-required="true" >
							<option value=""><spring:message code="kite.web.common.pleaseChoose" /></option>
						</form:select>
					</div>
					<!-- 城市描述 -->
					<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
						<spring:message code="branch.acctCity.desc" />
					</div>
				</div>
				<div class="form-group row">
					<!-- 所属支行 -->
					<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label"> <span class="span-icon">*&nbsp;</span> <spring:message code="branch.acctBranchBankId" text="所属支行" /> :
					</label>
					<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
						<form:input cssClass="form-control" type="text" path="acctBranchBankId" data-rule-required="true" data-rule-maxlength="9" />
					</div>
					<!-- 所属支行描述 -->
					<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
						<spring:message code="branch.acctBranchBankId.desc" />
					</div>
				</div>
			</div>
		</div>
		<div class="x_panel">
			<div class="x_title">
				<h2>
					<spring:message code="loanPlanDiff.orgInfo" text="机构信息参数" />
					<!--  <a href="#/credit-card"><i class="fa fa-credit-card"></i> </a>-->
				</h2>
				<ul class="nav navbar-right def-toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<div class="form-group row">
					<!-- 机构号 -->
					<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label"> <spring:message code="branch.orgId" text="机构号" /> :
					</label>
					<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
						<form:input cssClass="form-control" type="text" path="orgId" data-rule-maxlength="10" />
					</div>
					<!-- 机构号描述 -->
					<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
						<spring:message code="branch.orgId.desc" />
					</div>
				</div>
				<div class="form-group row">
					<!-- 登记机构号 -->
					<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label"> <spring:message code="branch.inputOrgId" text="登记机构号" /> :
					</label>
					<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
						<form:input cssClass="form-control" type="text" path="inputOrgId" data-rule-maxlength="10" />
					</div>
					<!-- 登记机构号描述 -->
					<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
						<spring:message code="branch.inputOrgId.desc" />
					</div>
				</div>
				<div class="form-group row">
					<!-- 登记人编号 -->
					<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label"> <spring:message code="branch.inputUserId" text="登记人编号" /> :
					</label>
					<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
						<form:input cssClass="form-control" type="text" path="inputUserId" data-rule-maxlength="10" />
					</div>
					<!-- 登记人编号描述 -->
					<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
						<spring:message code="branch.inputUserId.desc" />
					</div>
				</div>
				<div class="form-group row">
					<!-- 营销机构号 -->
					<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label"> <spring:message code="branch.updateOrgId" text="营销机构号" /> :
					</label>
					<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
						<form:input cssClass="form-control" type="text" path="updateOrgId" data-rule-maxlength="10" />
					</div>
					<!-- 营销机构号描述 -->
					<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
						<spring:message code="branch.updateOrgId.desc" />
					</div>
				</div>
				<div class="form-group row">
					<!-- 营销人员编号 -->
					<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label"> <spring:message code="branch.updateUserId" text="营销人员编号" /> :
					</label>
					<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
						<form:input cssClass="form-control" type="text" path="updateUserId" data-rule-maxlength="10" />
					</div>
					<!-- 营销人员编号描述 -->
					<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
						<spring:message code="branch.updateUserId.desc" />
					</div>
				</div>
				<div class="form-group row">
					<!-- 贷后管户人编号 -->
					<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label"> <spring:message code="branch.manageUserId" text="贷后管户人编号" /> :
					</label>
					<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
						<form:input cssClass="form-control" type="text" path="manageUserId" data-rule-maxlength="10" />
					</div>
					<!-- 贷后管户人编号描述 -->
					<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
						<spring:message code="branch.manageUserId.desc" />
					</div>
				</div>
				<div class="form-group row">
					<!-- 贷后管户机构号 -->
					<label class="col-lg-2 col-md-2 col-sm-2 col-xs-4 control-label"> <spring:message code="branch.manageOrgId" text="贷后管户机构号" /> :
					</label>
					<div class="col-lg-7 col-md-7 col-sm-7 col-xs-6">
						<form:input cssClass="form-control" type="text" path="manageOrgId" data-rule-maxlength="10" />
					</div>
					<!-- 贷后管户机构号描述 -->
					<div class="col-lg-3 col-md-3 col-sm-3 col-xs-2 remark">
						<spring:message code="branch.manageOrgId.desc" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-controls">
			<div class="cbtn-group-md auto-float">
				<!-- 确定 -->
				<input type="submit" class="btn-primary btn" value="<spring:message code='kite.web.common.btnSure' text='确定' />" />
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
			</div>
		</div>
	</form:form>
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp"%>
	<script>
		//开启表单验证
		$("#branchAddForm").validate();
		$("#acctProvince").bind("change",function(){
			$.ajax({
  		        type: "post",
  		        url: "${ctx}/webCommon/loadCity.in ",
  		        cache: false,
  		        //async : false,
  		        data: $("#acctProvince").val(),
  		        dataType: "json",
  		        contentType:"application/json",
  		        success: function (data)
  		        {		
  		            
  		        	$("#acctCityBox").empty();
					$("#acctCityBox").append(`
						<select id="acctCity" class="form-control" name="acctCity" data-rule-required="true" >
						<option value=""><spring:message code="kite.web.common.pleaseChoose" /> </option>
						</select>
						`); 
  		        	for (var key in data) {
  		        		$("#acctCity").append(`<option value=`+key+`>`+data[key]+`</option>`);
  		        		
  		        	}
  		        }
  		     
  		     });
		});
	</script>
</body>
</html>