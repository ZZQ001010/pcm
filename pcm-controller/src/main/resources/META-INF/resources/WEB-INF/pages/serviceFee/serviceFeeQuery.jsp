<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<title><spring:message code="serviceFee.query.title" text="服务方服务费查询" /></title>
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
						<form:form class="form-search form-horizontal form-label-left" datatable-target="serviceFee_datatable" modelAttribute="serviceFee">
							<div class="form-group">
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="serviceFeeNo">
									<spring:message code="serviceFee.serviceFeeNo" text="服务方服务费编码" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="serviceFeeNo"  data-rule-maxlength="15" />
								</div>
								<!-- <label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="serviceFeeDesc">
									<spring:message code="serviceFee.serviceFeeDesc" text="服务方服务费描述" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="serviceFeeDesc"  data-rule-maxlength="50" />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="feeCollectionMethod">
									<spring:message code="serviceFee.feeCollectionMethod" text="费用收取方式" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="feeCollectionMethod"  data-rule-maxlength="12" />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="feeBasis">
									<spring:message code="serviceFee.feeBasis" text="费用收取基础" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="feeBasis"  data-rule-maxlength="12" />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="frequencyOfCharge">
									<spring:message code="serviceFee.frequencyOfCharge" text="费用收取频次" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="frequencyOfCharge"  data-rule-maxlength="12" />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="chargeRatio">
									<spring:message code="serviceFee.chargeRatio" text="收取比例" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="chargeRatio"  data-rule-maxlength="12" />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="chargeAmount">
									<spring:message code="serviceFee.chargeAmount" text="收取金额" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="chargeAmount"  data-rule-maxlength="12" />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="organization">
									<spring:message code="serviceFee.organization" text="所属机构" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="organization"  data-rule-maxlength="12" />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="partnerType">
									<spring:message code="serviceFee.partnerType" text="合作方类型" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="partnerType"  data-rule-maxlength="12" />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="partnerCode">
									<spring:message code="serviceFee.partnerCode" text="合作方编码" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="partnerCode"  data-rule-maxlength="12" />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="transferAccount">
									<spring:message code="serviceFee.transferAccount" text="转出账号" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="transferAccount"  data-rule-maxlength="12" />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="transferToAccount">
									<spring:message code="serviceFee.transferToAccount" text="转入账号" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="transferToAccount"  data-rule-maxlength="12" />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="billingCycle">
									<spring:message code="serviceFee.billingCycle" text="结算周期" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="billingCycle"  data-rule-maxlength="12" />
								</div> -->
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
								<table id="serviceFee_datatable" class="datatable table table-hover table-striped table-bordered">
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
	<k:access code="serviceFee_add" var="addUrl"/>
	<k:access code="serviceFee_edit" var="editUrl"/>
	<k:access code="serviceFee_delete" var="delUrl"/>
	<!-- 创建datatable表格 -->
	<script type="text/javascript">
		var pkNames = [];
		var columns = [];
		var codetype = null;
		pkNames.push("serviceFeeNo");
		columns.push({ title: '<spring:message code="serviceFee.serviceFeeNo" text="服务方服务费编码" />', data: 'serviceFeeNo'});
		columns.push({ title: '<spring:message code="serviceFee.serviceFeeDesc" text="服务方服务费描述" />', data: 'serviceFeeDesc'});
		columns.push({ title: '<spring:message code="serviceFee.feeCollectionMethod" text="费用收取方式" />', data: 'feeCollectionMethod',
			render : function(data, type, row, meta) {
				return ${feeCollectionMethodJson}[data];
			}
		});
		columns.push({ title: '<spring:message code="serviceFee.feeBasis" text="费用收取基础" />', data: 'feeBasis',
			render : function(data, type, row, meta) {
				return ${feeBasisJson}[data];
			}
		});
		columns.push({ title: '<spring:message code="serviceFee.frequencyOfCharge" text="费用收取频次" />', data: 'frequencyOfCharge',
			render : function(data, type, row, meta) {
				return ${frequencyOfChargeJson}[data];
			}
		});
		columns.push({ title: '<spring:message code="serviceFee.chargeRatio" text="收取比例" />', data: 'chargeRatio'});
		columns.push({ title: '<spring:message code="serviceFee.chargeAmount" text="收取金额" />', data: 'chargeAmount'});
		columns.push({ title: '<spring:message code="serviceFee.organization" text="所属机构" />', data: 'organization',
			render : function(data, type, row, meta) {
				return ${orgJson}[data];
			}	
		});
		columns.push({ title: '<spring:message code="serviceFee.partnerType" text="合作方类型" />', data: 'partnerType',
			render : function(data, type, row, meta) {
				codetype = data;				
				return ${partnerTypeJson}[data];
			}
		});
		columns.push({ title: '<spring:message code="serviceFee.partnerCode" text="合作方编码" />', data: 'partnerCode',
			render : function(data, type, row, meta) {
				if(codetype=='ZJ'){
					return ${fundSideInfoJson}[data];
				}
				if(codetype=='ZC'){
					return ${assetSideInfoJson}[data];
				}
				if(codetype=='QD'){
					return ${channelInfoJson}[data];
				}
				if(codetype=='FW'){
					return ${serverInfoJson}[data];
				}
			}
		});
		columns.push({ title: '<spring:message code="serviceFee.transferAccount" text="转出账号" />', data: 'transferAccount'});
		columns.push({ title: '<spring:message code="serviceFee.transferToAccount" text="转入账号" />', data: 'transferToAccount'});
		columns.push({ title: '<spring:message code="serviceFee.billingCycle" text="结算周期" />', data: 'billingCycle',
			render : function(data, type, row, meta) {
				return ${billingCycleJson}[data];
			}
		});
		//columns.push({ title: '<spring:message code="serviceFee.balanceDate" text="结算日期" />', data: 'balanceDate'});
		var grid = $("#serviceFee_datatable").grid({
			datatable : {
	          	ajax: {
	  				url: "${ctx}/serviceFee/queryServiceFeeList.in",
	  				method: "post",
	  				data: function(d) {
						d.serviceFeeNo = $("#serviceFeeNo").val();
						/* d.serviceFeeDesc = $("#serviceFeeDesc").val();
						d.feeCollectionMethod = $("#feeCollectionMethod").val();
						d.feeBasis = $("#feeBasis").val();
						d.frequencyOfCharge = $("#frequencyOfCharge").val();
						d.chargeRatio = $("#chargeRatio").val();
						d.chargeAmount = $("#chargeAmount").val();
						d.organization = $("#organization").val();
						d.partnerType = $("#partnerType").val();
						d.partnerCode = $("#partnerCode").val();
						d.transferAccount = $("#transferAccount").val();
						d.transferToAccount = $("#transferToAccount").val();
						d.billingCycle = $("#billingCycle").val(); */
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
			$K.frame.loadPage("${ctx}/serviceFee/serviceFeeDetailPage.in?" + params.join("&"), grid);
		}
		grid.dbClick(dbclick);
	</script>
	<!-- 权限单元-控制代码块 -->
</body>	
</html>