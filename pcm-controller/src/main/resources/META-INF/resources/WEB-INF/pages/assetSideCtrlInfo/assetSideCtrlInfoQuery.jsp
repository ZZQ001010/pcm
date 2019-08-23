<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<title><spring:message code="assetSideCtrlInfo.query.title" text="资产方管控信息查询" /></title>
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
						<form:form class="form-search form-horizontal form-label-left" datatable-target="assetSideCtrlInfo_datatable" modelAttribute="assetSideCtrlInfo">
							<div class="form-group">
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="assetSideCtrlCode">
									<spring:message code="assetSideCtrlInfo.assetSideCtrlCode" text="资产方管控编码" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="assetSideCtrlCode"  data-rule-required="true" data-rule-maxlength="32" />
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
								<table id="assetSideCtrlInfo_datatable" class="datatable table table-hover table-striped table-bordered">
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
	<k:access code="assetSideCtrlInfo_add" var="addUrl"/>
	<k:access code="assetSideCtrlInfo_edit" var="editUrl"/>
	<k:access code="assetSideCtrlInfo_delete" var="delUrl"/>
	<!-- 创建datatable表格 -->
	<script type="text/javascript">
		var pkNames = [];
		var columns = [];
		pkNames.push("assetSideCtrlCode");
		columns.push({ title: '<spring:message code="assetSideCtrlInfo.assetSideCtrlCode" text="资产方管控编码" />', data: 'assetSideCtrlCode'});
		columns.push({ title: '<spring:message code="assetSideCtrlInfo.assetSideCtrlDesc" text="资产方管控描述" />', data: 'assetSideCtrlDesc'});
		columns.push({ title: '<spring:message code="assetSideCtrlInfo.assetSideCode" text="资产方编码" />', data: 'assetSideCode'});
		columns.push({ title: '<spring:message code="assetSideCtrlInfo.assetSideAmountGeneralControl" text="资产方额度总控" />', data: 'assetSideAmountGeneralControl'});
		columns.push({ title: '<spring:message code="assetSideCtrlInfo.authorizationAmountUsefulLife" text="授信额度有效期" />', data: 'authorizationAmountUsefulLife',
			type : 'date',
			render : function(data, type, row, meta) {
				return $K.date.format(data, "date");
			}
		});
		columns.push({ title: '<spring:message code="assetSideCtrlInfo.assetSideLoanCtrl" text="资产方放款管控" />', data: 'assetSideLoanCtrl',
			render : function(data, type, row, meta) {
				return ${assetSideLoanCtrlJson}[data];
			}
		});
		columns.push({ title: '<spring:message code="assetSideCtrlInfo.loanAmountUsefulLife" text="放款额度有效期" />', data: 'loanAmountUsefulLife',
			type : 'date',
			render : function(data, type, row, meta) {
				return $K.date.format(data, "date");
			}
		});
		columns.push({ title: '<spring:message code="assetSideCtrlInfo.assetSideBalanceControl" text="资产方余额总控" />', data: 'assetSideBalanceControl'});
		columns.push({ title: '<spring:message code="assetSideCtrlInfo.balanceAmountUsefulLife" text="余额额度有效期" />', data: 'balanceAmountUsefulLife',
			type : 'date',
			render : function(data, type, row, meta) {
				return $K.date.format(data, "date");
			}
		});
		var grid = $("#assetSideCtrlInfo_datatable").grid({
			datatable : {
	          	ajax: {
	  				url: "${ctx}/assetSideCtrlInfo/queryAssetSideCtrlInfoList.in",
	  				method: "post",
	  				data: function(d) {
						d.assetSideCtrlCode = $("#assetSideCtrlCode").val();
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
			$K.frame.loadPage("${ctx}/assetSideCtrlInfo/assetSideCtrlInfoDetailPage.in?" + params.join("&"), grid);
		}
		grid.dbClick(dbclick);
	</script>
	<!-- 权限单元-控制代码块 -->
</body>	
</html>