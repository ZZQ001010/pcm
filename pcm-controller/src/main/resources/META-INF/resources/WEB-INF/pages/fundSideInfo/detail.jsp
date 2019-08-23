<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="fundSideInfo.detail.title" text="资金方基本信息
明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="fundSideInfo">
		<div class="form-group row">
			<!-- 资金方编码 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideInfo.fundSideCode" text="资金方编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideInfo.fundSideCode }	
			</label>
			<!-- 资金方描述 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideInfo.fundSideDesc" text="资金方描述" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideInfo.fundSideDesc }	
			</label>
			
			<!-- 联系电话1 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideInfo.phone" text="联系电话" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideInfo.phone }
			</label>
			<!-- 联系电话2 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideInfo.linkman" text="联系人" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideInfo.linkman }
			</label>
			<!-- 传真 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideInfo.fax" text="传真" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideInfo.fax }	
			</label>
			<!-- 电子邮箱 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideInfo.postalCode" text="邮政编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideInfo.postalCode }
			</label>
            <!-- 电子邮箱 -->
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
                <spring:message code="fundSideInfo.fundSeverSide" text="资金方技术服务方" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
                &nbsp;${fundSideInfo.fundSeverSide }
            </label>
            <!-- 电子邮箱 -->
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
                <spring:message code="fundSideInfo.headOrgCode" text="总行机构代码" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
                &nbsp;${fundSideInfo.headOrgCode }
            </label>
            <!-- 电子邮箱 -->
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
                <spring:message code="fundSideInfo.branchOrgCode" text="分行机构代码" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
                &nbsp;${fundSideInfo.branchOrgCode }
            </label>
            <!-- 电子邮箱 -->
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
                <spring:message code="fundSideInfo.subOrgCode" text="支行机构代码" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
                &nbsp;${fundSideInfo.subOrgCode }
            </label>
            <!-- 电子邮箱 -->
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
                <spring:message code="fundSideInfo.creditOrgCode" text="征信机构代码" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
                &nbsp;${fundSideInfo.creditOrgCode }
            </label>
            <!-- 电子邮箱 -->
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
                <spring:message code="fundSideInfo.settlementAccount" text="结算账号" />
                :
            </label>
            <label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
                &nbsp;${fundSideInfo.settlementAccount }
            </label>
			<!-- 名称 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideInfo.companyName" text="名称" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideInfo.companyName }	
			</label>
			<!-- 登记机关 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideInfo.registrationAuthority" text="登记机关" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideInfo.registrationAuthority }	
			</label>
			<!-- 成立时间 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideInfo.registerDate" text="成立时间" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				<fmt:formatDate var="registerDateFmt" value="${fundSideInfo.registerDate }" type="date" pattern="yyyy-MM-dd" />
				&nbsp;${registerDateFmt }
			</label>
			<!-- 统一社会信用代码 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideInfo.unifySocialCreditCode" text="统一社会信用代码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideInfo.unifySocialCreditCode }	
			</label>
			<!-- 类型 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideInfo.companyType" text="类型" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${companyType}
			</label>
			<!-- 营业期限有限期起始日期 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideInfo.businessBeginDate" text="营业期限有限期起始日期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				<fmt:formatDate var="businessBeginDateFmt" value="${fundSideInfo.businessBeginDate }" type="date" pattern="yyyy-MM-dd" />
				&nbsp;${businessBeginDateFmt }
			</label>
			<!-- 营业期限有限期截止日期 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideInfo.businessEndDate" text="营业期限有限期截止日期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				<fmt:formatDate var="businessEndDateFmt" value="${fundSideInfo.businessEndDate }" type="date" pattern="yyyy-MM-dd" />
				&nbsp;${businessEndDateFmt }
			</label>
			<!-- 营业执照号码 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideInfo.businessLicenseNumber" text="营业执照号码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideInfo.businessLicenseNumber }	
			</label>
			<!-- 实收资本 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideInfo.paidInCapital" text="实收资本" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${paidInCapital }	
			</label>
			<!-- 法定代表人 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideInfo.legalPerson" text="法定代表人" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideInfo.legalPerson }	
			</label>
			<!-- 注册资本 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideInfo.registerMoney" text="注册资本" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${registerMoney }	
			</label>
			<!-- 登记时间 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideInfo.register" text="登记时间" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				<fmt:formatDate var="registerFmt" value="${fundSideInfo.register }" type="date" pattern="yyyy-MM-dd" />
				&nbsp;${registerFmt }
			</label>
			<!-- 住所 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideInfo.residence" text="住所" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${addr }	
			</label>
			<!-- 经营范围 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="fundSideInfo.businessScope" text="经营范围" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${fundSideInfo.businessScope }
			</label>
		</div>
		<div class="form-controls auto-float">
			<div class="btn-group-sm">
			<k:access code="fundSideInfo_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updateAssetSideInfo" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updateAssetSideInfo").click(function(){
						var params = [];
						params.push("fundSideCode=${fundSideInfo.fundSideCode }");
						$K.frame.reloadSlideInner("${ctx}/fundSideInfo/edit.in?" + params.join("&"));
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