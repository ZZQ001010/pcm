<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<title><spring:message code="fundSideCtrlInfo.query.title" text="资金方管控信息
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
						<form:form class="form-search form-horizontal form-label-left" datatable-target="fundSideCtrlInfo_datatable" modelAttribute="fundSideCtrlInfo">
							<div class="form-group">
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="fundSideCtrlCode">
									<spring:message code="fundSideCtrlInfo.fundSideCtrlCode" text="资金方管控编码" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="fundSideCtrlCode"  data-rule-required="true" data-rule-maxlength="12" />
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
								<table id="fundSideCtrlInfo_datatable" class="datatable table table-hover table-striped table-bordered">
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
	<k:access code="fundSideCtrlInfo_add" var="addUrl"/>
	<k:access code="fundSideCtrlInfo_edit" var="editUrl"/>
	<k:access code="fundSideCtrlInfo_delete" var="delUrl"/>
	<!-- 创建datatable表格 -->
	<script type="text/javascript">
		var pkNames = [];
		var columns = [];
		pkNames.push("fundSideCtrlCode");
		columns.push({ title: '<spring:message code="fundSideCtrlInfo.fundSideCtrlCode" text="资金方管控编码" />', data: 'fundSideCtrlCode'});
		columns.push({ title: '<spring:message code="fundSideCtrlInfo.fundSideCtrlDesc" text="资金方管控描述" />', data: 'fundSideCtrlDesc'});
		columns.push({ title: '<spring:message code="fundSideCtrlInfo.fundSide" text="资金方编码" />', data: 'fundSide',
            render : function(data, type, row, meta) {
                return ${fundSideInfoJson}[data];
            }
        });
		columns.push({ title: '<spring:message code="fundSideCtrlInfo.fundSideCreditLimit" text="资金方授信管控" />', data: 'fundSideCreditLimit',
            render : function(data, type, row, meta) {
                return ${fundSideCreditLimitJson}[data];
            }
        });
		columns.push({ title: '<spring:message code="fundSideCtrlInfo.fundSideTotalTrustworthinessLimit" text="资金方授信额度总控" />', data: 'fundSideTotalTrustworthinessLimit'});
		columns.push({ title: '<spring:message code="fundSideCtrlInfo.authorizationAmountUsefulLife" text="授信额度有效期" />', data: 'authorizationAmountUsefulLife',
			type : 'date',
			render : function(data, type, row, meta) {
				return $K.date.format(data, "date");
			}
		
		});
        columns.push({ title: '<spring:message code="fundSideCtrlInfo.fundSideLoanLimit" text="资金方放款管控" />', data: 'fundSideLoanLimit',
            render : function(data, type, row, meta) {
                return ${fundSideLoanLimitJson}[data];
            }
        });
        columns.push({ title: '<spring:message code="fundSideCtrlInfo.fundSideTotalLoanAmount" text="资金方放款额总控" />', data: 'fundSideTotalLoanAmount'});
		columns.push({ title: '<spring:message code="fundSideCtrlInfo.loanAmountUsefulLife" text="放款额度有效期" />', data: 'loanAmountUsefulLife',
			type : 'date',
			render : function(data, type, row, meta) {
				return $K.date.format(data, "date");
			}
		});
        columns.push({ title: '<spring:message code="fundSideCtrlInfo.fundSideTotalLoanAmountM" text="资金方月放款额管控" />', data: 'fundSideTotalLoanAmountM'});
        columns.push({ title: '<spring:message code="fundSideCtrlInfo.fundSideTotalLoanAmountW" text="资金方周放款额管控" />', data: 'fundSideTotalLoanAmountW'});
        columns.push({ title: '<spring:message code="fundSideCtrlInfo.fundSideTotalLoanAmountD" text="资金方日放款额管控" />', data: 'fundSideTotalLoanAmountD'});

        columns.push({ title: '<spring:message code="fundSideCtrlInfo.fundSideTotalBalance" text="资金方余额总控" />', data: 'fundSideTotalBalance'});
		columns.push({ title: '<spring:message code="fundSideCtrlInfo.balanceAmountUsefulLife" text="余额额度有效期" />', data: 'balanceAmountUsefulLife',
			type : 'date',
			render : function(data, type, row, meta) {
				return $K.date.format(data, "date");
			}	
		
		});
		var grid = $("#fundSideCtrlInfo_datatable").grid({
			datatable : {
	          	ajax: {
	  				url: "${ctx}/fundSideCtrlInfo/queryFundSideCtrlInfoList.in",
	  				method: "post",
	  				data: function(d) {
						d.fundSideCtrlCode = $("#fundSideCtrlCode").val();
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
			$K.frame.loadPage("${ctx}/fundSideCtrlInfo/fundSideCtrlInfoDetailPage.in?" + params.join("&"), grid);
		}
		grid.dbClick(dbclick);
	</script>
	<!-- 权限单元-控制代码块 -->
</body>	
</html>