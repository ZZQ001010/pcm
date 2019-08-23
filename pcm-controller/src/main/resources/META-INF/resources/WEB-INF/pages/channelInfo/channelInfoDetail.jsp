<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="channelInfo.detail.title" text="渠道方基本信息明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="channelInfo">
		<div class="form-group row">
			<!-- 渠道方编码 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelInfo.channelCode" text="渠道方编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${channelInfo.channelCode }	
			</label>
			<!-- 渠道方描述 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelInfo.channelDesc" text="渠道方描述" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${channelInfo.channelDesc }	
			</label>
			<!-- 联系电话 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelInfo.phone" text="联系电话" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${channelInfo.phone }	
			</label>
			<!-- 联系人 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelInfo.linkman" text="联系人" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${channelInfo.linkman }	
			</label>
			<!-- 传真 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelInfo.fax" text="传真" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${channelInfo.fax }	
			</label>
			<!-- 电子邮箱 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelInfo.email" text="电子邮箱" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${channelInfo.email }	
			</label>
			<!-- 名称 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelInfo.companyName" text="名称" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${channelInfo.companyName }	
			</label>
			<!-- 登记机关 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelInfo.registrationAuthority" text="登记机关" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${channelInfo.registrationAuthority }	
			</label>
			<!-- 成立时间 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelInfo.registerDate" text="成立时间" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				<fmt:formatDate var="registerDateFmt" value="${channelInfo.registerDate }" type="date" pattern="yyyy-MM-dd" />
				&nbsp;${registerDateFmt }
			</label>
			<!-- 统一社会信用代码 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelInfo.unifySocialCreditCode" text="统一社会信用代码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${channelInfo.unifySocialCreditCode }	
			</label>
			<!-- 类型 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelInfo.companyType" text="类型" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${companyType}
			</label>
			<!-- 营业期限有限期起始日期 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelInfo.businessBeginDate" text="营业期限有限期起始日期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				<fmt:formatDate var="businessBeginDateFmt" value="${channelInfo.businessBeginDate }" type="date" pattern="yyyy-MM-dd" />
				&nbsp;${businessBeginDateFmt }
			</label>
			<!-- 营业期限有限期截止日期 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelInfo.businessEndDate" text="营业期限有限期截止日期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				<fmt:formatDate var="businessEndDateFmt" value="${channelInfo.businessEndDate }" type="date" pattern="yyyy-MM-dd" />
				&nbsp;${businessEndDateFmt }
			</label>
			<!-- 营业执照号码 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelInfo.businessLicenseNumber" text="营业执照号码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${channelInfo.businessLicenseNumber }	
			</label>
			<!-- 实收资本 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelInfo.paidInCapital" text="实收资本" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${paidInCapital }	
			</label>
			<!-- 法定代表人 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelInfo.legalPerson" text="法定代表人" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${channelInfo.legalPerson }	
			</label>
			<!-- 注册资本 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelInfo.registerMoney" text="注册资本" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${registerMoney }	
			</label>
			<!-- 登记时间 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelInfo.register" text="登记时间" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				<fmt:formatDate var="registerFmt" value="${channelInfo.register }" type="date" pattern="yyyy-MM-dd" />
				&nbsp;${registerFmt }
			</label>
			<!-- 住所 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelInfo.residence" text="住所" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${addr }	
			</label>
			<!-- 经营范围 -->
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">
				<spring:message code="channelInfo.businessScope" text="经营范围" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-12 col-xs-12 detailStyle">
				&nbsp;${channelInfo.businessScope }	
			</label>
		</div>
		<c:if test="${factory == true }">
		<div class="form-controls auto-float">
			<div class="btn-group-sm">
			<k:access code="assetSideInfo_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updatechannelInfo" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updatechannelInfo").click(function(){
						var params = [];
						params.push("assetSideCode=${channelInfo.channelCode }");
						$K.frame.reloadSlideInner("${ctx}/channelInfo/channelInfoEditPage.in?" + params.join("&"));
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