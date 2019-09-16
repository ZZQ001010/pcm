<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="assetSideInfo.detail.title" text="资产方基本信息
明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="assetSideInfo">
		<div class="form-group row">
			<!-- 资产方编码 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideInfo.assetSideCode" text="资产方编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${assetSideInfo.assetSideCode }	
			</label>
			<!-- 资产方描述 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideInfo.assetSideDesc" text="资产方描述" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${assetSideInfo.assetSideDesc }	
			</label>
			<!-- 资产方类型 -->
			<%--<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">--%>
				<%--<spring:message code="assetSideInfo.assetSideType" text="资产方类型" />--%>
				<%--:--%>
			<%--</label>--%>
			<%--<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">--%>
				<%--&nbsp;${assetSideType}--%>
			<%--</label>--%>
			<!-- 资产方担保方式 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideInfo.assetSideWarrantWay" text="资产方担保方式" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${assetSideWarrantWay}
			</label>
			<!-- 联系电话1 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideInfo.phone1" text="联系电话1" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${assetSideInfo.phone1 }	
			</label>
			<!-- 联系电话2 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideInfo.linkman1" text="联系人1" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${assetSideInfo.linkman1 }
			</label>
			<!-- 传真 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideInfo.fax" text="传真" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${assetSideInfo.fax }	
			</label>
			<!-- 电子邮箱 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideInfo.email" text="电子邮箱" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${assetSideInfo.email }	
			</label>
			<!-- 名称 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideInfo.companyName" text="名称" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${assetSideInfo.companyName }	
			</label>
			<!-- 登记机关 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideInfo.registrationAuthority" text="登记机关" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${assetSideInfo.registrationAuthority }	
			</label>
			<!-- 成立时间 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideInfo.registerDate" text="成立时间" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				<fmt:formatDate var="registerDateFmt" value="${assetSideInfo.registerDate }" type="date" pattern="yyyy-MM-dd" />
				&nbsp;${registerDateFmt }
			</label>
			<!-- 统一社会信用代码 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideInfo.unifySocialCreditCode" text="统一社会信用代码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${assetSideInfo.unifySocialCreditCode }	
			</label>
			<!-- 类型 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideInfo.companyType" text="类型" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${companyType}
			</label>
			<!-- 营业期限有限期起始日期 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideInfo.businessBeginDate" text="营业期限有限期起始日期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				<fmt:formatDate var="businessBeginDateFmt" value="${assetSideInfo.businessBeginDate }" type="date" pattern="yyyy-MM-dd" />
				&nbsp;${businessBeginDateFmt }
			</label>
			<!-- 营业期限有限期截止日期 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideInfo.businessEndDate" text="营业期限有限期截止日期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				<fmt:formatDate var="businessEndDateFmt" value="${assetSideInfo.businessEndDate }" type="date" pattern="yyyy-MM-dd" />
				&nbsp;${businessEndDateFmt }
			</label>
			<!-- 营业执照号码 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideInfo.businessLicenseNumber" text="营业执照号码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${assetSideInfo.businessLicenseNumber }	
			</label>
			<!-- 实收资本 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideInfo.paidInCapital" text="实收资本" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${paidInCapital }	
			</label>
			<!-- 法定代表人 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideInfo.legalPerson" text="法定代表人" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${assetSideInfo.legalPerson }	
			</label>
			<!-- 注册资本 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideInfo.registerMoney" text="注册资本" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${registerMoney }	
			</label>
			<!-- 登记时间 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideInfo.register" text="登记时间" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				<fmt:formatDate var="registerFmt" value="${assetSideInfo.register }" type="date" pattern="yyyy-MM-dd" />
				&nbsp;${registerFmt }
			</label>
			<!-- 住所 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideInfo.residence" text="住所" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${addr }	
			</label>
			<!-- 经营范围 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="assetSideInfo.businessScope" text="经营范围" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${assetSideInfo.businessScope }
			</label>
		</div>
	<c:if test="${factory == true }">
		<div class="form-controls auto-float">
			<div class="btn-group-sm">
			<k:access code="assetSideInfo_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updateAssetSideInfo" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updateAssetSideInfo").click(function(){
						var params = [];
						params.push("assetSideCode=${assetSideInfo.assetSideCode }");
						$K.frame.reloadSlideInner("${ctx}/assetSideInfo/assetSideInfoEditPage.in?" + params.join("&"));
					})
				</script>
			</k:access>
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
			</div>
		</div>
	</c:if>
	</form:form>
	<%@ include file="/common/foot.jsp"%>
</body>
</html>