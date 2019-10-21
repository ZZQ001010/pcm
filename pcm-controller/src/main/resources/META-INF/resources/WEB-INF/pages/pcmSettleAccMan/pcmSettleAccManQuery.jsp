<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<title><spring:message code="pcmSettleAccMan.query.title" text="结算账号管理查询" /></title>
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
						<form:form class="form-search form-horizontal form-label-left" datatable-target="pcmSettleAccMan_datatable" modelAttribute="pcmSettleAccMan">
							<div class="form-group">
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="settleAccCode">
									<spring:message code="pcmSettleAccMan.settleAccCode" text="结算账号编码" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="settleAccCode"  data-rule-maxlength="100" />
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
								<table id="pcmSettleAccMan_datatable" class="datatable table table-hover table-striped table-bordered">
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
	<k:access code="pcmSettleAccMan_add" var="addUrl"/>
	<k:access code="pcmSettleAccMan_edit" var="editUrl"/>
	<k:access code="pcmSettleAccMan_delete" var="delUrl"/>
	<!-- 创建datatable表格 -->
	<script type="text/javascript">
		var pkNames = [];
		var columns = [];
		pkNames.push("settleAccCode");
		columns.push({ title: '<spring:message code="pcmSettleAccMan.settleAccCode" text="结算账号编码" />', data: 'settleAccCode'});
		columns.push({ title: '<spring:message code="pcmSettleAccMan.settleAccDes" text="结算账号描述" />', data: 'settleAccDes'});
		columns.push({ title: '<spring:message code="pcmSettleAccMan.unitName" text="单位名称" />', data: 'unitName'});
		columns.push({ title: '<spring:message code="pcmSettleAccMan.bankAccount" text="银行账户" />', data: 'bankAccount'});
		columns.push({ title: '<spring:message code="pcmSettleAccMan.openBankCode" text="银行账户编码" />', data: 'openBankCode'});
		columns.push({ title: '<spring:message code="pcmSettleAccMan.openBank" text="开户银行" />', data: 'openBank'});
		columns.push({ title: '<spring:message code="pcmSettleAccMan.openBankProv" text="开户行省份" />', data: 'openBankProv'});
		columns.push({ title: '<spring:message code="pcmSettleAccMan.openBankCity" text="开户行城市" />', data: 'openBankCity'});
		columns.push({ title: '<spring:message code="pcmSettleAccMan.district" text="开户区、县" />', data: 'district'});
		columns.push({ title: '<spring:message code="pcmSettleAccMan.openBankBranch" text="开户行支行" />', data: 'openBankBranch'});
		columns.push({ title: '<spring:message code="pcmSettleAccMan.vUnitName" text="单位名称" />', data: 'vUnitName'});
		columns.push({ title: '<spring:message code="pcmSettleAccMan.vBankAccount" text="银行账户" />', data: 'vBankAccount'});
		columns.push({ title: '<spring:message code="pcmSettleAccMan.vOpenBank" text="开户银行" />', data: 'vOpenBank'});
		columns.push({ title: '<spring:message code="pcmSettleAccMan.vOpenBankProv" text="开户行省份" />', data: 'vOpenBankProv'});
		columns.push({ title: '<spring:message code="pcmSettleAccMan.vOpenBankCity" text="开户行城市" />', data: 'vOpenBankCity'});
		columns.push({ title: '<spring:message code="pcmSettleAccMan.vDistrict" text="开户区、县" />', data: 'vDistrict'});
		columns.push({ title: '<spring:message code="pcmSettleAccMan.vOpenBankBranch" text="开户行支行" />', data: 'vOpenBankBranch'});
		var grid = $("#pcmSettleAccMan_datatable").grid({
			datatable : {
	          	ajax: {
	  				url: "${ctx}/pcmSettleAccMan/queryPcmSettleAccManList.in",
	  				method: "post",
	  				data: function(d) {
						d.settleAccCode = $("#settleAccCode").val();
						d.settleAccDes = $("#settleAccDes").val();
						d.accountOwner = $("#accountOwner").val();
						d.organizationAccountType = $("#organizationAccountType").val();
						d.unitName = $("#unitName").val();
						d.bankAccount = $("#bankAccount").val();
						d.openBank = $("#openBank").val();
						d.openBankProv = $("#openBankProv").val();
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
			$K.frame.loadPage("${ctx}/pcmSettleAccMan/pcmSettleAccManDetailPage.in?" + params.join("&"), grid);
		}
		grid.dbClick(dbclick);
	</script>
	<!-- 权限单元-控制代码块 -->
</body>	
</html>