<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<title><spring:message code="fundSideProductCtrlInfo.query.title" text="资金方产品经营控制查询" /></title>
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
						<form:form class="form-search form-horizontal form-label-left" datatable-target="fundSideProductCtrlInfo_datatable" modelAttribute="fundSideProductCtrlInfo">
							<div class="form-group">
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="fundSideCtrlCode">
									<spring:message code="fundSideProductCtrlInfo.fundSideCtrlCode" text="资金方管控编码" />
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
								<table id="fundSideProductCtrlInfo_datatable" class="datatable table table-hover table-striped table-bordered">
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
	<k:access code="fundSideProductCtrlInfo_add" var="addUrl"/>
	<k:access code="fundSideProductCtrlInfo_edit" var="editUrl"/>
	<k:access code="fundSideProductCtrlInfo_delete" var="delUrl"/>
	<!-- 创建datatable表格 -->
	<script type="text/javascript">
		var pkNames = [];
		var columns = [];
		pkNames.push("fundSideCtrlCode");
		columns.push({ title: '<spring:message code="fundSideProductCtrlInfo.fundSideCtrlCode" text="资金方管控编码" />', data: 'fundSideCtrlCode'});
		columns.push({ title: '<spring:message code="fundSideProductCtrlInfo.fundSideCtrlDesc" text="资金方管控描述" />', data: 'fundSideCtrlDesc'});
		<%--columns.push({ title: '<spring:message code="fundSideProductCtrlInfo.fundSideCode" text="资金方编码" />', data: 'fundSideCode'});--%>
		columns.push({ title: '<spring:message code="fundSideProductCtrlInfo.fundSideProv" text="资金方支持展业省份" />', data: 'fundSideProv'});
		columns.push({ title: '<spring:message code="fundSideProductCtrlInfo.fundSideCity" text="资金方支持展业城市" />', data: 'fundSideCity'});
		columns.push({ title: '<spring:message code="fundSideProductCtrlInfo.fundSideBusinessScope" text="资金方申请行业范围" />', data: 'fundSideBusinessScope',
            render : function(data, type, row, meta) {
                var i18arr = [] ;
                $.each(data,function(index,val){
                    var i18val = ${fundSideBusinessScopeJson}[val]
                    i18arr.push(i18val);
                })
                return i18arr;
            }
		});
		columns.push({ title: '<spring:message code="fundSideProductCtrlInfo.fundSideProfessionScope" text="资金方申请职业范围" />', data: 'fundSideProfessionScope',
            render : function(data, type, row, meta) {
                var i18arr = [] ;
                $.each(data,function(index,val){
                    var i18val = ${fundSideProfessionScopeJson}[val]
                    i18arr.push(i18val);
                })
                return i18arr;
            }
        });
		<%--columns.push({ title: '<spring:message code="fundSideProductCtrlInfo.fundSideInfo" text="资金方专项资产方" />', data: 'fundSideInfo'});--%>
		columns.push({ title: '<spring:message code="fundSideProductCtrlInfo.fundSidePartRepay" text="资金方是否支持部分还款" />', data: 'fundSidePartRepay',
            render : function(data,type,row,meta){
                if(data){
                    return "是";
                }else{
                    return "否";
                }
            }
        });
		<%--columns.push({ title: '<spring:message code="fundSideProductCtrlInfo.fundSidePartRepayDay" text="资金方支持还款日区间" />', data: 'fundSidePartRepayDay'});--%>
		<%--columns.push({ title: '<spring:message code="fundSideProductCtrlInfo.fundSideProductWorkdayCR" text="资金方产品-工作日支持征信时间段" />', data: 'fundSideProductWorkdayCR'});--%>
		<%--columns.push({ title: '<spring:message code="fundSideProductCtrlInfo.fundSideProductHolidayCR" text="资金方产品-节假日支持征信时间段" />', data: 'fundSideProductHolidayCR'});--%>
		<%--columns.push({ title: '<spring:message code="fundSideProductCtrlInfo.fundSideProductWorkdayC" text="资金方产品-工作日支持授信时间段" />', data: 'fundSideProductWorkdayC'});--%>
		<%--columns.push({ title: '<spring:message code="fundSideProductCtrlInfo.fundSideProductHolidayC" text="资金方产品-节假日支持授信时间段" />', data: 'fundSideProductHolidayC'});--%>
		<%--columns.push({ title: '<spring:message code="fundSideProductCtrlInfo.fundSideProductWorkdayL" text="资金方产品-工作日支持放款时间段" />', data: 'fundSideProductWorkdayL'});--%>
		<%--columns.push({ title: '<spring:message code="fundSideProductCtrlInfo.fundSideProductHolidayL" text="资金方产品-节假日支持放款时间段" />', data: 'fundSideProductHolidayL'});--%>
		<%--columns.push({ title: '<spring:message code="fundSideProductCtrlInfo.fundSideProductWorkdayR" text="资金方产品-工作日支持还款时间段" />', data: 'fundSideProductWorkdayR'});--%>
		<%--columns.push({ title: '<spring:message code="fundSideProductCtrlInfo.fundSideProductHolidayR" text="资金方产品-节假日支持还款时间段" />', data: 'fundSideProductHolidayR'});--%>
		<%--columns.push({ title: '<spring:message code="fundSideProductCtrlInfo.fundSideProductRepayDay" text="资金方产品-当日还款截止时间" />', data: 'fundSideProductRepayDay'});--%>
		<%--columns.push({ title: '<spring:message code="fundSideProductCtrlInfo.fundSideCRScorecardLogo" text="资金方征信评分卡标识" />', data: 'fundSideCRScorecardLogo'});--%>

		var grid = $("#fundSideProductCtrlInfo_datatable").grid({
			datatable : {
	          	ajax: {
	  				url: "${ctx}/fundSideProductCtrlInfo/queryFundSideProductCtrlInfoList.in",
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
			$K.frame.loadPage("${ctx}/fundSideProductCtrlInfo/fundSideProductCtrlInfoDetailPage.in?" + params.join("&"), grid);
		}
		grid.dbClick(dbclick); 
	</script>
	<!-- 权限单元-控制代码块 -->
</body>	
</html>