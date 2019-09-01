<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<title><spring:message code="premiumLiquidatedDamages.query.title" text="提前还款保费收取方式" /></title>
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
						<form:form class="form-search form-horizontal form-label-left" datatable-target="premiumLiquidatedDamages_datatable" modelAttribute="premiumLiquidatedDamages">
							<div class="form-group">
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="code">
									<spring:message code="premiumLiquidatedDamages.code" text="费用编码" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="code"  data-rule-required="true" data-rule-maxlength="12" />
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
								<table id="premiumLiquidatedDamages_datatable" class="datatable table table-hover table-striped table-bordered">
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
	<k:access code="premiumLiquidatedDamages_add" var="addUrl"/>
	<k:access code="premiumLiquidatedDamages_edit" var="editUrl"/>
	<k:access code="premiumLiquidatedDamages_delete" var="delUrl"/>
	<!-- 创建datatable表格 -->
	<script type="text/javascript">
		var pkNames = [];
		var columns = [];
		pkNames.push("code");
		columns.push({ title: '<spring:message code="premiumLiquidatedDamages.code" text="费用编码" />', data: 'code'});
		columns.push({ title: '<spring:message code="premiumLiquidatedDamages.desc" text="费用描述" />', data: 'desc'});
		columns.push({ title: '<spring:message code="premiumLiquidatedDamages.costCalculationMethod" text="费用收取方式" />', data: 'costCalculationMethod',
			render : function(data, type, row, meta) {
				return ${costCalculationMethodJson}[data];
			}
		});
		columns.push({ title: '<spring:message code="premiumLiquidatedDamages.whetherToCharge" text="当期保费是否收取" />', data: 'whetherToCharge',
			render : function(data,type,row,meta){
				if(data){
					return "是";
				}else{
					return "否";
				}
			}			
		});
		columns.push({ title: '<spring:message code="premiumLiquidatedDamages.percentageRemainingPrincipal" text="手续费率" />', data: 'percentageRemainingPrincipal'});
		columns.push({ title: '<spring:message code="premiumLiquidatedDamages.additionalNPremiums" text="加收N期保费" />', data: 'additionalNPremiums',
            render : function(data, type, row, meta) {
                return ${additionalNPremiumsJson}[data];
            }});
		columns.push({ title: '<spring:message code="premiumLiquidatedDamages.chargeFixedAmount" text="收取固定金额" />', data: 'chargeFixedAmount'});
		columns.push({ title: '<spring:message code="premiumLiquidatedDamages.startDate" text="收取起始账期" />', data: 'startDate',
            type : 'date',
            render : function(data, type, row, meta) {
                return $K.date.format(data, "date");
            }});
		columns.push({ title: '<spring:message code="premiumLiquidatedDamages.endDate" text="收取终止账期" />', data: 'endDate',
            type : 'date',
            render : function(data, type, row, meta) {
                return $K.date.format(data, "date");
            }});
		var grid = $("#premiumLiquidatedDamages_datatable").grid({
			datatable : {
	          	ajax: {
	  				url: "${ctx}/premiumLiquidatedDamages/queryPremiumLiquidatedDamagesList.in",
	  				method: "post",
	  				data: function(d) {
						d.code = $("#code").val();
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
	    	console.log(rowData[pkNames[0]]);
			$K.frame.loadPage("${ctx}/premiumLiquidatedDamages/premiumLiquidatedDamagesDetailPage.in?dcode=" + rowData[pkNames[0]], grid);
		}
		grid.dbClick(dbclick);
	</script>
	<!-- 权限单元-控制代码块 -->
</body>	
</html>