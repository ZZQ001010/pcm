<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="branch.detail.title" text="分支机构明细" /></title>
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
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="branch">
		<div class="form-group row">
			<!-- 机构编号 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="branch.branchId" text="机构编号" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6  detailStyle">
				${branch.branchId }	
			</label>
			<!-- 机构名称 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="branch.name" text="机构名称" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6  detailStyle"> 
				${branch.name }	
			</label>
		<!-- </div>				
		<div class="form-group row"> -->
			<!-- 地址 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="branch.address" text="地址" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6  detailStyle">
				${branch.address }	
			</label>
			<!-- 机构所在国家代码 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="branch.countryCd" text="机构所在国家代码" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6  detailStyle"> 
				${branch.countryCd }	
			</label>
		<!-- </div>				
		<div class="form-group row"> -->
			<!-- 机构所在城市 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="branch.city" text="机构所在城市" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6  detailStyle">
				${branch.city }	
			</label>
			<!-- 区 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="branch.district" text="区" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6  detailStyle"> 
				${branch.district }	
			</label>
		<!-- </div>				
		<div class="form-group row"> -->
			<!-- 邮编 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="branch.zip" text="邮编" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6  detailStyle">
				${branch.zip }	
			</label>
			<!-- 机构级别 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="branch.level" text="机构级别" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6  detailStyle"> 
				${branch.level }	
			</label>
		<!-- </div>				
		<div class="form-group row"> -->
			<!-- 机构联系电话1 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="branch.phone1" text="机构联系电话1" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6  detailStyle">
				${branch.phone1 }	
			</label>
			<!-- 机构联系电话2 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="branch.phone2" text="机构联系电话2" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6  detailStyle"> 
				${branch.phone2 }	
			</label>
		<!-- </div>				
		<div class="form-group row"> -->
			<!-- 上级机构编号 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="branch.superiorBranchId" text="上级机构编号" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6  detailStyle">
				${branch.superiorBranchId }	
			</label>
			<!-- 银行账号 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="branch.settleAcctNbr" text="银行账号" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6  detailStyle"> 
				${branch.settleAcctNbr }	
			</label>
		<!-- </div>				
		<div class="form-group row"> -->
			<!-- 银行代码 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="branch.acctBankId" text="银行代码" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6  detailStyle">
				${branch.acctBankId }	
			</label>
			<!-- 银行名称 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="branch.acctBank" text="银行名称" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6  detailStyle"> 
				${branch.acctBank }	
			</label>
		<!-- </div>				
		<div class="form-group row"> -->
			<!-- 省份 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="branch.acctProvince" text="省份" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6  detailStyle">
				${branch.acctProvince}
			</label>
			<!-- 城市 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="branch.acctCity" text="城市" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6  detailStyle"> 
				${branch.acctCity}
			</label>
		<!-- </div>				
		<div class="form-group row"> -->
			<!-- 所属支行 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="branch.acctBranchBankId" text="所属支行" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6  detailStyle">
				${branch.acctBranchBankId }	
			</label>
			<!-- 机构号 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="branch.orgId" text="机构号" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 detailStyle">
				&nbsp;${branch.orgId }	
			</label>
		<!-- </div>
			
			<div class="form-group row"> -->
			<!-- 登记机构号 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="branch.inputOrgId" text="登记机构号" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 detailStyle">
				&nbsp;${branch.inputOrgId }	
			</label>
			<!-- 登记人编号 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="branch.inputUserId" text="登记人编号" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 detailStyle">
				&nbsp;${branch.inputUserId }	
			</label>
			<!-- 营销机构号 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="branch.updateOrgId" text="营销机构号" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 detailStyle">
				&nbsp;${branch.updateOrgId }	
			</label>
			<!-- 营销人员编号 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="branch.updateUserId" text="营销人员编号" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 detailStyle">
				&nbsp;${branch.updateUserId }	
			</label>
			<!-- 贷后管户人编号 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="branch.manageUserId" text="贷后管户人编号" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 detailStyle">
				&nbsp;${branch.manageUserId }	
			</label>
			<!-- 贷后管户机构号 -->
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 control-label">
				<spring:message code="branch.manageOrgId" text="贷后管户机构号" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-3 col-xs-6 detailStyle">
				&nbsp;${branch.manageOrgId }	
			</label>
		</div>
		<div class="form-controls auto-float">
			<div class="btn-group-sm">
			<k:access code="branch_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updateBranch" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updateBranch").click(function(){
						var params = [];
						params.push("branchId=${branch.branchId }");
						$K.frame.reloadSlideInner("${ctx}/branch/branchEditPage.in?" + params.join("&"));
					})
				</script>
			</k:access>
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
			</div>
		</div>
	</form:form>
	<%@ include file="/common/foot.jsp"%>
</body>
</html>