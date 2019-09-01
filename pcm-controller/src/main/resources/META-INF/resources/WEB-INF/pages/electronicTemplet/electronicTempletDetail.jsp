<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="electronicTemplet.detail.title" text="风控电子资料模板管理明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
<style type="text/css">
label.detailStyle {
    font-weight: 700;
    margin-top: 10px;
    text-align: left;
}
.form-horizontal .control-label {
    padding-top: 8px;
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
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px;padding-right: 40px" modelAttribute="electronicTemplet">
		<div class="form-group row">
			<!-- 模板编号 -->
			<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
				<spring:message code="electronicTemplet.templetId" text="模板编号" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle">
				&nbsp;${electronicTemplet.templetId }	
			</label>
			<!-- 描述 -->
			<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
				<spring:message code="electronicTemplet.templetDesc" text="描述" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle">
				&nbsp;${electronicTemplet.templetDesc }	
			</label>
			<!-- 公安照片 -->
			<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
				<spring:message code="electronicTemplet.SecurityPhoto" text="公安照片" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle">
				&nbsp;${N }	
			</label>
			</label>
			<!-- 社保卡 -->
			<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
				<spring:message code="electronicTemplet.SINCard" text="社保卡" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle">
				&nbsp;${S }	
			</label>
			</label>
			<!-- 客户与RA合照 -->
			<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
				<spring:message code="electronicTemplet.CustomerPhoto" text="客户与RA合照" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle">
				&nbsp;${G }	
			</label>
			</label>
			<!-- 申请人照片 -->
			<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
				<spring:message code="electronicTemplet.ApplicantPhoto" text="申请人照片" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle">
				&nbsp;${P }	
			</label>
			</label>
			<!-- 户口本 -->
			<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
				<spring:message code="electronicTemplet.HouseholdRegister" text="户口本" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle">
				&nbsp;${B }	
			</label>
			</label>
			<!-- 购货小票 -->
			<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
				<spring:message code="electronicTemplet.PurchaseReceipts" text="购货小票" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle">
				&nbsp;${T }	
			</label>
			</label>
			<!-- 工作证明或学生证明 -->
			<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
				<spring:message code="electronicTemplet.Proof" text="工作证明或学生证明" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle">
				&nbsp;${A }	
			</label>
			</label>
			<!-- 房产登记证或房产使用权证明  -->
			<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
				<spring:message code="electronicTemplet.PropertyCertificate" text="房产登记证或房产使用权证明" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle">
				&nbsp;${H }	
			</label>
			<!-- 身份证反面  -->
			<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
				<spring:message code="electronicTemplet.OppositeId" text="身份证反面" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle">
				&nbsp;${R }	
			</label>
			<!-- 信用卡与其对应上期电子账单  -->
			<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
				<spring:message code="electronicTemplet.CreditCARDS" text="信用卡与其对应上期电子账单" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle">
				&nbsp;${E }	
			</label>
			<!-- 其他  -->
			<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
				<spring:message code="electronicTemplet.Other" text="其他" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle">
				&nbsp;${Z }	
			</label>
			<!-- 代扣银行卡 -->
			<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
				<spring:message code="electronicTemplet.DebitCard" text="代扣银行卡" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle">
				&nbsp;${W }	
			</label>
			<!-- 居住证明 -->
			<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
				<spring:message code="electronicTemplet.ProofResidency" text="居住证明" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle">
				&nbsp;${L }	
			</label>
			<!-- 身份证正面 -->
			<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
				<spring:message code="electronicTemplet.FaceId" text="身份证正面" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle">
				&nbsp;${F }	
			</label>
			<!-- 工资卡及其流水 -->
			<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
				<spring:message code="electronicTemplet.PayCard" text="工资卡及其流水" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle">
				&nbsp;${C }	
			</label>
			<!-- 人脸识别照片 -->
			<label class="col-lg-2 col-md-3 col-sm-4 col-xs-6 control-label">
				<spring:message code="electronicTemplet.FacePhoto" text="人脸识别照片" />
				:
			</label>
			<label class="col-lg-2 col-md-3 col-sm-2 col-xs-6  detailStyle">
				&nbsp;${D }	
			</label>
		</div>
		<div class="form-controls">
			<div class="btn-group-sm">
			<k:access code="electronicTemplet_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updateElectronicTemplet" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updateElectronicTemplet").click(function(){
						var params = [];
						params.push("templetId=${electronicTemplet.templetId }");
						$K.frame.reloadSlideInner("${ctx}/electronicTemplet/electronicTempletEditPage.in?" + params.join("&"));
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