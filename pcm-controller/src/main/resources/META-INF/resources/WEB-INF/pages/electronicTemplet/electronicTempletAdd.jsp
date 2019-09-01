<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="electronicTemplet.add.title" text="风控电子资料模板管理新增" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
<style type="text/css">

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
	<form:form cssClass="form-horizontal" id="electronicTempletAddForm" cssStyle="padding-top: 40px;padding-right: 40px" modelAttribute="electronicTemplet" data-confirm="true">
		<div class="form-group row">
			<!-- 模板编号 -->
			<label class="col-lg-2 col-md-3 col-sm-5 col-xs-5 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="electronicTemplet.templetId" text="模板编号" />
				:
			</label>
			<div class="col-lg-6 col-md-6  col-sm-5 col-xs-5">
				<form:input cssClass="form-control" type="text" path="templetId" data-rule-required="true" data-rule-maxlength="3" />
			</div>
			<!-- 模板编号描述 -->
			<div class="col-lg-3 col-md-3 col-sm-2 col-xs-2 remark">
				<spring:message code="electronicTemplet.templetId.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 描述 -->
			<label class="col-lg-2 col-md-3 col-sm-5 col-xs-5 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="electronicTemplet.templetDesc" text="描述" />
				:
			</label>
			<div class="col-lg-6 col-md-6  col-sm-5 col-xs-5">
				<form:input cssClass="form-control" type="text" path="templetDesc" data-rule-required="true" data-rule-maxlength="20" />
			</div>
			<!-- 描述描述 -->
			<div class="col-lg-3 col-md-3 col-sm-2 col-xs-2 remark">
				<spring:message code="electronicTemplet.templetDesc.desc" />
			</div>
		</div>
	</form:form>
	<!-- 电子模板列表 -->
	<form:form cssClass="form-horizontal" id="templet" name="templet" cssStyle="padding-top: 40px;padding-right: 40px" modelAttribute="electronicTemplet" data-confirm="true">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					<spring:message code="electronicTempletParam.info" text="电子模板列表" />
				</h2>
				<ul class="nav navbar-right panel_toolbox">
					<li>
						<a class="collapse-link">
							<i class="fa fa-chevron-up"></i>
						</a>
					</li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 公安照片 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
					
						<spring:message code="electronicTemplet.SecurityPhoto" text="公安照片" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="" id="N" name="N">
							<form:options items="${requireType}" />
						</form:select>
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 身份证反面 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="electronicTemplet.OppositeId" text="身份证反面" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="" id="R" name="R">
							<form:options items="${requireType}" />
						</form:select>
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 社保卡 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="electronicTemplet.SINCard" text="社保卡" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="" id="S" name="S">
							<form:options items="${requireType}" />
						</form:select>
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 信用卡与其对应上期电子账单 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="electronicTemplet.CreditCARDS" text="信用卡与其对应上期电子账单" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="" id="E" name="E">
							<form:options items="${requireType}" />
						</form:select>
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 客户与RA合照 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="electronicTemplet.CustomerPhoto" text="客户与RA合照" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="" id="G" name="G">
							<form:options items="${requireType}" />
						</form:select>
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 申请人照片 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="electronicTemplet.ApplicantPhoto" text="申请人照片" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="" id="P" name="P">
							<form:options items="${requireType}" />
						</form:select>
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 代扣银行卡 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="electronicTemplet.DebitCard" text="代扣银行卡" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="" id="W" name="W">
							<form:options items="${requireType}" />
						</form:select>
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 户口本 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="electronicTemplet.HouseholdRegister" text="户口本" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="" id="B" name="B">
							<form:options items="${requireType}" />
						</form:select>
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 居住证明 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="electronicTemplet.ProofResidency" text="居住证明" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="" id="L" name="L">
							<form:options items="${requireType}" />
						</form:select>
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 购货小票 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="electronicTemplet.PurchaseReceipts" text="购货小票" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="" id="T" name="T">
							<form:options items="${requireType}" />
						</form:select>
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 身份证正面 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="electronicTemplet.FaceId" text="身份证正面" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="" id="F" name="F">
							<form:options items="${requireType}" />
						</form:select>
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 工作证明或学生证明 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="electronicTemplet.Proof" text="工作证明或学生证明" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="" id="A" name="A">
							<form:options items="${requireType}" />
						</form:select>
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 工资卡及其流水 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="electronicTemplet.PayCard" text="工资卡及其流水" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="" id="C" name="C">
							<form:options items="${requireType}" />
						</form:select>
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 房产登记证或房产使用权证明 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="electronicTemplet.PropertyCertificate" text="房产登记证或房产使用权证明" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="" id="H" name="H">
							<form:options items="${requireType}" />
						</form:select>
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 人脸识别照片 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="electronicTemplet.FacePhoto" text="人脸识别照片" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="" id="D" name="D">
							<form:options items="${requireType}" />
						</form:select>
					</div>
				</div>
				<div class="form-group row col-lg-4 col-md-6 col-sm-10 col-xs-10 ">
					<!-- 其他 -->
					<label class="col-lg-6 col-md-6 col-sm-6 col-xs-6 control-label">
						<spring:message code="electronicTemplet.Other" text="其他" />
						:
					</label>
					<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6">
						<form:select cssClass="form-control" path="" id="Z" name="Z">
							<form:options items="${requireType}" />
						</form:select>
					</div>
				</div>
			</div>
	</form:form>
	<div class="form-controls">
		<div class="cbtn-group-md">
			<!-- 确定 -->
			<input type="button" id="submit" class="btn-primary btn" value="<spring:message code='kite.web.common.btnSure' text='确定' />" />
			<!-- 返回 -->
			<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
		</div>
	</div>
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp"%>
	<script>
		//开启表单验证
		$("#electronicTempletAddForm").validate();
		$("#submit").click(function(){
			if($("#electronicTempletAddForm").valid()){
				layer.confirm('确定提交?', {icon: 3, title:'提示'}, function(index){
					var vElectronicTemplet={};
					var templetList={};
					var form = $('#electronicTempletAddForm').serializeArray();
					$.each(form, function() {
						vElectronicTemplet[this.name] = this.value;
						});
					var templet_form = $('#templet').serializeArray();
					$.each(templet_form, function() {
						templetList[this.name] = this.value;
						});
					var templetListStr=JSON.stringify(templetList);
					vElectronicTemplet["templetListStr"] = templetListStr;
					$K.ajax({
						url:"${ctx}/electronicTemplet/addElectronicTemplet.in",
						type:"post",
						contentType:"application/json;charset=utf-8",
						data:JSON.stringify(vElectronicTemplet),
						success:function(data){
							$(".only-slide-out").click();
							layer.close(index);
						}
					})
					
				});
		 	}
		});
	</script>
</body>
</html>