<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<title><spring:message code="prepaymentFee.query.title" text="提前还款手续费查询" /></title>
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
						<form:form class="form-search form-horizontal form-label-left" datatable-target="prepaymentFee_datatable" modelAttribute="prepaymentFee">
							<div class="form-group">
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="prepaymentFeeCode">
									<spring:message code="prepaymentFee.prepaymentFeeCode" text="提前还款手续费编码" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="prepaymentFeeCode"  data-rule-required="true" data-rule-maxlength="15" />
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
								<table id="prepaymentFee_datatable" class="datatable table table-hover table-striped table-bordered">
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
	<k:access code="prepaymentFee_add" var="addUrl"/>
	<k:access code="prepaymentFee_edit" var="editUrl"/>
	<k:access code="prepaymentFee_delete" var="delUrl"/>
	<!-- 创建datatable表格 -->
	<script type="text/javascript">
		var pkNames = [];
		var columns = [];
		var codetype = null;
		pkNames.push("prepaymentFeeCode");
		columns.push({ title: '<spring:message code="prepaymentFee.prepaymentFeeCode" text="提前还款手续费编码" />', data: 'prepaymentFeeCode'});
		columns.push({ title: '<spring:message code="prepaymentFee.prepaymentFeeDesc" text="提前还款手续费描述" />', data: 'prepaymentFeeDesc'});
		columns.push({ title: '<spring:message code="prepaymentFee.feeCollectionMethod" text="费用收取方式" />', data: 'feeCollectionMethod',
			render : function(data, type, row, meta) {
				return ${feeCollectionMethodJson}[data];
			}
		});
		columns.push({ title: '<spring:message code="prepaymentFee.loanDayFeeColMethod" text="放款当天提前结清费用收取方式" />', data: 'loanDayFeeColMethod',
			render : function(data, type, row, meta) {
				return ${loanDayFeeColMethodJson}[data];
			}
		});
		columns.push({ title: '<spring:message code="prepaymentFee.organization" text="所属机构" />', data: 'organization',
			render : function(data, type, row, meta) {
				return ${orgJson}[data];
			}
		});
		columns.push({ title: '<spring:message code="prepaymentFee.partnerType" text="合作方类型" />', data: 'partnerType',
			render : function(data, type, row, meta) {
				codetype = data;				
				return ${partnerTypeJson}[data];
			}
		});
		columns.push({ title: '<spring:message code="prepaymentFee.partnerCode" text="合作方编码" />', data: 'partnerCode',
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
		columns.push({ title: '<spring:message code="prepaymentFee.transferAccount" text="转出账号" />', data: 'transferAccount'});
		columns.push({ title: '<spring:message code="prepaymentFee.transferToAccount" text="转入账号" />', data: 'transferToAccount'});
		columns.push({ title: '<spring:message code="prepaymentFee.billingCycle" text="结算周期" />', data: 'billingCycle',
			render : function(data, type, row, meta) {
				return ${billingCycleJson}[data];
			}
		});
		var grid = $("#prepaymentFee_datatable").grid({
			datatable : {
	          	ajax: {
	  				url: "${ctx}/prepaymentFee/queryPrepaymentFeeList.in",
	  				method: "post",
	  				data: function(d) {
						d.prepaymentFeeCode = $("#prepaymentFeeCode").val();
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
			$K.frame.loadPage("${ctx}/prepaymentFee/prepaymentFeeDetailPage.in?" + params.join("&"), grid);
		}
		grid.dbClick(dbclick);
	</script>
	<!-- 权限单元-控制代码块 -->
</body>
</html>