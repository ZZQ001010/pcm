<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<title><spring:message code="pcmOrgParameter.query.title" text="机构参数查询" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<body class="${param.skin}">
	<!-- 整体皮肤样式 -->
	<div class="container">
		<div class="row" style="margin: 0px;">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="padding: 0px;">
				<div class="x_panel">
					<div class="x_content">
						<!-- datatable-target="(table-id)" 配置查询表单关联对应的datatable数据表格 -->
						<form:form class="form-search form-horizontal form-label-left" datatable-target="pcmOrgParameter_datatable" modelAttribute="pcmOrgParameter">
							<div class="form-group">
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="orgCode">
									<spring:message code="pcmOrgParameter.orgCode" text="机构编码" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="orgCode"  data-rule-required="true" data-rule-maxlength="32" />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="orgName">
									<spring:message code="pcmOrgParameter.orgName" text="机构名称" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="orgName"  data-rule-required="true" data-rule-maxlength="32" />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="orgAddress">
									<spring:message code="pcmOrgParameter.orgAddress" text="机构地址" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="orgAddress"  data-rule-required="true" data-rule-maxlength="200" />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="orgLevel">
									<spring:message code="pcmOrgParameter.orgLevel" text="机构级别" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="orgLevel"  data-rule-required="true" data-rule-maxlength="32" />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="parentOrgCode">
									<spring:message code="pcmOrgParameter.parentOrgCode" text="上级机构编码" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="parentOrgCode"  data-rule-required="true" data-rule-maxlength="32" />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="orgContactPhone">
									<spring:message code="pcmOrgParameter.orgContactPhone" text="机构联系电话" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="orgContactPhone"  data-rule-maxlength="32" />
								</div>
							</div>
							<div class="form-controls">
								<div class="btn-group-sm">
									<!-- grid-search,点击该按钮自动查询form[datatable-target]对应的数据 -->
									<button class="btn btn-success grid-search" type="button">
										<!-- 查询 -->
										<i class="fa fa-search"></i>
										<spring:message code="kite.web.common.btnCheck" text="查询" />
									</button>
									<button class="btn btn-primary" type="reset">
										<!-- 重置-->
										<i class="fa fa-refresh"></i>
										<spring:message code="kite.web.common.btnReset" text="重置" />
									</button>
								</div>
							</div>
						</form:form>
						
						<!-- 表格数据展示区域 -->
						<div class="responsive-table">
							<div class="scrollable-area">
								<table id="pcmOrgParameter_datatable" class="datatable table table-hover table-striped table-bordered">
								</table>
							</div>
						</div>
					</div><!-- x_content -->
				</div><!-- x_panel-->
			</div><!-- col-12 -->
		</div>
	</div>
	<!-- 引入js -->
	<%@ include file="/common/foot.jsp"%>
	<!-- 权限单元-控制js变量 -->
	<k:access code="pcmOrgParameter_add" var="addUrl"/>
	<k:access code="pcmOrgParameter_edit" var="editUrl"/>
	<k:access code="pcmOrgParameter_delete" var="delUrl"/>
	<!-- 创建datatable表格 -->
	<script type="text/javascript">
		var pkNames = [];
		var columns = [];
		pkNames.push("orgCode");
		columns.push({ title: '<spring:message code="pcmOrgParameter.orgCode" text="机构编码" />', data: 'orgCode'});
		columns.push({ title: '<spring:message code="pcmOrgParameter.orgName" text="机构名称" />', data: 'orgName'});
		columns.push({ title: '<spring:message code="pcmOrgParameter.orgAddress" text="机构地址" />', data: 'orgAddress'});
		columns.push({ title: '<spring:message code="pcmOrgParameter.orgLevel" text="机构级别" />', data: 'orgLevel'});
		columns.push({ title: '<spring:message code="pcmOrgParameter.parentOrgCode" text="上级机构编码" />', data: 'parentOrgCode'});
		columns.push({ title: '<spring:message code="pcmOrgParameter.orgContactPhone" text="联系电话" />', data: 'orgContactPhone'});
		columns.push({ title: '<spring:message code="pcmOrgParameter.orgContactPerson" text="机构联系人" />', data: 'orgContactPerson'});
		
		columns.push({ title: '<spring:message code="pcmOrgParameter.bussinessScope" text="业务范围" />', data: 'bussinessScope'});
		columns.push({ title: '<spring:message code="pcmOrgParameter.enterpriseNatureCode" text="企业性质代码" />', data: 'enterpriseNatureCode'});
		columns.push({ title: '<spring:message code="pcmOrgParameter.businessLicensStartDate" text="业务许可有效起期 " />', data: 'businessLicensStartDate',
            type : 'date',
            render : function(data, type, row, meta) {
                return $K.date.format(data, "date");
            }});
		columns.push({ title: '<spring:message code="pcmOrgParameter.businessLicensEndDate" text="业务许可有效止期 " />', data: 'businessLicensEndDate',
            type : 'date',
            render : function(data, type, row, meta) {
                return $K.date.format(data, "date");
            }});
		
		columns.push({ title: '<spring:message code="pcmOrgParameter.registeredCapital" text="注册资本" />', data: 'registeredCapital'});
		columns.push({ title: '<spring:message code="pcmOrgParameter.regCapitalCurrencyCod" text="注册资本货币代码 " />', data: 'regCapitalCurrencyCod'});
		columns.push({ title: '<spring:message code="pcmOrgParameter.unifiedSocialCreditCode" text="统一社会信用代码" />', data: 'unifiedSocialCreditCode'});
		columns.push({ title: '<spring:message code="pcmOrgParameter.organizationCode" text="组织机构代码 " />', data: 'organizationCode'});
		
		columns.push({ title: '<spring:message code="pcmOrgParameter.taxRegNum" text="税务登记号码 " />', data: 'taxRegNum'});
		columns.push({ title: '<spring:message code="pcmOrgParameter.businessNo" text="营业执照号码" />', data: 'businessNo'});
		columns.push({ title: '<spring:message code="pcmOrgParameter.supervisoryJurisdictionCod" text="监管辖区代码" />', data: 'supervisoryJurisdictionCod'});
		columns.push({ title: '<spring:message code="pcmOrgParameter.registration" text="注册地" />', data: 'registration'});
		
		columns.push({ title: '<spring:message code="pcmOrgParameter.busPlace" text="经营场所  " />', data: 'busPlace'});
		columns.push({ title: '<spring:message code="pcmOrgParameter.busPlaceZipCode" text="经营场所邮编 " />', data: 'busPlaceZipCode'});
		columns.push({ title: '<spring:message code="pcmOrgParameter.fax" text="传真" />', data: 'fax'});
		columns.push({ title: '<spring:message code="pcmOrgParameter.busCertificateStartDate" text="营业执照有效起期 " />', data: 'busCertificateStartDate',
			 type : 'date',
	            render : function(data, type, row, meta) {
	                return $K.date.format(data, "date");
	            }});
		columns.push({ title: '<spring:message code="pcmOrgParameter.busCertificateEndDate" text="营业执照有效止期  " />', data: 'busCertificateEndDate',
            type : 'date',
            render : function(data, type, row, meta) {
                return $K.date.format(data, "date");
            }});
		
			var grid = $("#pcmOrgParameter_datatable").grid({
			datatable : {
	          	ajax: {
	  				url: "${ctx}/pcmOrgParameter/queryPcmOrgParameterList.in",
	  				method: "post",
	  				data: function(d) {
						d.orgCode = $("#orgCode").val();
						d.orgName = $("#orgName").val();
						d.orgAddress = $("#orgAddress").val();
						d.orgLevel = $("#orgLevel").val();
						d.parentOrgCode = $("#parentOrgCode").val();
						d.orgContactPhone = $("#orgContactPhone").val();
	  				}
	  			},
	  			columns: columns
	  		},
	        addUrl:addUrl,//新增页面url
	        updateUrl:editUrl,//修改页面url
	        deleteUrl:delUrl,//删除数据url
	        pkNames:pkNames//表格数据主键字段名称
		});
	    var dbclick = function(rowIndex, rowData, rowObj) {
	    	var params = [];
	    	for(var i in pkNames){
	    		if(pkNames[i] && rowData[pkNames[i]]){
	    			params.push(pkNames[i] + "=" + rowData[pkNames[i]]);
	    		}
	    	}
			$K.frame.loadPage("${ctx}/pcmOrgParameter/pcmOrgParameterDetailPage.in?" + params.join("&"), grid);
		}
		grid.dbClick(dbclick);
	</script>
	<!-- 权限单元-控制代码块 -->
</body>	
</html>