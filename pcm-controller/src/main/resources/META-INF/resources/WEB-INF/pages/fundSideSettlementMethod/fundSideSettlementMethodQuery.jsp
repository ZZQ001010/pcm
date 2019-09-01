<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<title><spring:message code="fundSideSettlementMethod.query.title" text="资金方理赔方式
查询" /></title>
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
						<form:form class="form-search form-horizontal form-label-left" datatable-target="fundSideSettlementMethod_datatable" modelAttribute="fundSideSettlementMethod">
							<div class="form-group">
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="fundSideCode">
									<spring:message code="fundSideSettlementMethod.fundSideCode" text="资金方编码" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="fundSideCode"  data-rule-maxlength="32" />
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
								<table id="fundSideSettlementMethod_datatable" class="datatable table table-hover table-striped table-bordered">
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
	<k:access code="fundSideSettlementMethod_add" var="addUrl"/>
	<k:access code="fundSideSettlementMethod_edit" var="editUrl"/>
	<k:access code="fundSideSettlementMethod_delete" var="delUrl"/>
	<!-- 创建datatable表格 -->
	<script type="text/javascript">
		var pkNames = [];
		var columns = [];
		pkNames.push("fundSideCode");
		columns.push({ title: '<spring:message code="fundSideSettlementMethod.fundSideCode" text="资金方编码" />', data: 'fundSideCode'});
		columns.push({ title: '<spring:message code="fundSideSettlementMethod.fundSideDesc" text="资金方描述" />', data: 'fundSideDesc'});
        columns.push({ title: '<spring:message code="fundSideSettlementMethod.fundSide" text="资金方" />', data: 'fundSide',
            render : function(data, type, row, meta) {
                return ${fundSideInfoJson}[data];
            }
        });
		columns.push({ title: '<spring:message code="fundSideSettlementMethod.fundSideInfo" text="理赔模式" />', data: 'fundSideInfo',
			render : function(data, type, row, meta) {
				return ${fundSideInfoJson}[data];
			}
		});
		columns.push({ title: '<spring:message code="fundSideSettlementMethod.daysOverdue" text="逾期理赔等待期天数" />', data: 'daysOverdue'});
		columns.push({ title: '<spring:message code="fundSideSettlementMethod.otalNumberOfClaimsStartPeriods" text="全期理赔起始期数" />', data: 'otalNumberOfClaimsStartPeriods'});
		columns.push({ title: '<spring:message code="fundSideSettlementMethod.claimsReconciliationAllowanceAmount" text="理赔对账容差金额" />', data: 'claimsReconciliationAllowanceAmount'});
		var grid = $("#fundSideSettlementMethod_datatable").grid({
			datatable : {
	          	ajax: {
	  				url: "${ctx}/fundSideSettlementMethod/queryFundSideSettlementMethodList.in",
	  				method: "post",
	  				data: function(d) {
						d.fundSideCode = $("#fundSideCode").val();
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
			$K.frame.loadPage("${ctx}/fundSideSettlementMethod/fundSideSettlementMethodDetailPage.in?" + params.join("&"), grid);
		}
		grid.dbClick(dbclick);
	</script>
	<!-- 权限单元-控制代码块 -->
</body>	
</html>