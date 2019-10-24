<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="serverInfo.detail.title" text="服务方基本信息明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="serverInfo">
		<div class="form-group row">
			<!-- 服务方编码 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serverInfo.serverCode" text="服务方编码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${serverInfo.serverCode }	
			</label>
			<!-- 服务方描述 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serverInfo.serverDesc" text="服务方描述" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${serverInfo.serverDesc }	
			</label>
			<!-- 联系电话 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serverInfo.phone" text="联系电话" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${serverInfo.phone }	
			</label>
			<!-- 联系人 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serverInfo.linkman" text="联系人" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${serverInfo.linkman }	
			</label>
			<!-- 传真 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serverInfo.fax" text="传真" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${serverInfo.fax }	
			</label>
			<!-- 电子邮箱 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serverInfo.email" text="电子邮箱" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${serverInfo.email }	
			</label>
			
			<!-- 名称 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serverInfo.companyName" text="名称" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${serverInfo.companyName }	
			</label>
			<!-- 登记机关 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serverInfo.registrationAuthority" text="登记机关" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${serverInfo.registrationAuthority }	
			</label>
			<!-- 成立时间 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serverInfo.registerDate" text="成立时间" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				<fmt:formatDate var="registerDateFmt" value="${serverInfo.registerDate }" type="date" pattern="yyyy-MM-dd" />
				&nbsp;${registerDateFmt }
			</label>
			<!-- 统一社会信用代码 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serverInfo.unifySocialCreditCode" text="统一社会信用代码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${serverInfo.unifySocialCreditCode }	
			</label>
			<!-- 类型 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serverInfo.companyType" text="类型" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${companyType}
			</label>
			<!-- 营业期限有限期起始日期 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serverInfo.businessBeginDate" text="营业期限有限期起始日期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				<fmt:formatDate var="businessBeginDateFmt" value="${serverInfo.businessBeginDate }" type="date" pattern="yyyy-MM-dd" />
				&nbsp;${businessBeginDateFmt }
			</label>
			<!-- 营业期限有限期截止日期 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serverInfo.businessEndDate" text="营业期限有限期截止日期" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				<fmt:formatDate var="businessEndDateFmt" value="${serverInfo.businessEndDate }" type="date" pattern="yyyy-MM-dd" />
				&nbsp;${businessEndDateFmt }
			</label>
			<!-- 营业执照号码 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serverInfo.businessLicenseNumber" text="营业执照号码" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${serverInfo.businessLicenseNumber }	
			</label>
			<!-- 实收资本 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serverInfo.paidInCapital" text="实收资本" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${paidInCapital }	
			</label>
			<!-- 法定代表人 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serverInfo.legalPerson" text="法定代表人" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${serverInfo.legalPerson }	
			</label>
			<!-- 注册资本 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serverInfo.registerMoney" text="注册资本" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${registerMoney }	
			</label>
			<!-- 登记时间 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serverInfo.register" text="登记时间" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				<fmt:formatDate var="registerFmt" value="${serverInfo.register }" type="date" pattern="yyyy-MM-dd" />
				&nbsp;${registerFmt }
			</label>
			<!-- 住所 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serverInfo.residence" text="住所" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${addr }	
			</label>
			<!-- 经营范围 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="serverInfo.businessScope" text="经营范围" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
				&nbsp;${serverInfo.businessScope }	
			</label>
			
		</div>
		<if: test="${factory==false }">
			<div class="form-controls auto-float">
				<div class="btn-group-sm">
				<k:access code="serverInfo_edit">
					<!--修改 -->
					<input type="button" class="btn-info btn" id="updateServerInfo" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
					<script type="text/javascript">
						$("#updateServerInfo").click(function(){
							var params = [];
							params.push("serverCode=${serverInfo.serverCode }");
							$K.frame.reloadSlideInner("${ctx}/serverInfo/serverInfoEditPage.in?" + params.join("&"));
						})
					</script>
				</k:access>
					<!-- 返回 -->
					<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
				</div>
			</div>
		</if>
	</form:form>
	<%@ include file="/common/foot.jsp"%>
</body>
</html>