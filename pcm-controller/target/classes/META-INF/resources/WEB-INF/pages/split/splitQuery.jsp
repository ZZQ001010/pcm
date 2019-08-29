<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<title><spring:message code="split.query.title" text="扣款拆分查询" /></title>
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
						<form:form class="form-search form-horizontal form-label-left" datatable-target="split_datatable" modelAttribute="split">
							<div class="form-group">
								<label class="control-label col-lg-1 col-md-2 col-sm-3 col-xs-12" for="splitName">
									<spring:message code="split.splitName" text="拆分名称" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-9 col-xs-12">
									<form:input cssClass="form-control" type="text" path="splitName"  data-rule-required="true" data-rule-maxlength="6" />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-3 col-xs-12" for="splitMethod">
									<spring:message code="split.splitMethod" text="拆分方式" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-9 col-xs-12">
									<form:select cssClass="form-control" path="splitMethod">
										<option value=""><spring:message code="kite.web.common.pleaseChoose"  text="--请选择--" /></option>
										<form:options items="${splitMethod}" />
									</form:select>
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
								<table id="split_datatable" class="datatable table table-hover table-striped table-bordered">
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
	<k:access code="split_add" var="addUrl"/>
	<k:access code="split_edit" var="editUrl"/>
	<k:access code="split_delete" var="delUrl"/>
	<!-- 创建datatable表格 -->
	<script type="text/javascript">
		var pkNames = [];
		var columns = [];
		pkNames.push("splitTableId");
		columns.push({ title: '<spring:message code="split.splitTableId" text="拆分表id" />', data: 'splitTableId'});
		columns.push({ title: '<spring:message code="split.splitName" text="拆分名称" />', data: 'splitName'});
		columns.push({ title: '<spring:message code="split.splitMethod" text="拆分方式" />', data: 'splitMethod',
			render : function(data, type, row, meta) {
				return ${splitMethodJson}[data];
			}
		});
		columns.push({ title: '<spring:message code="split.splitRate" text="拆分比例" />', data: 'splitRate'});
		columns.push({ title: '<spring:message code="split.splitAMT" text="拆份固定金额" />', data: 'splitAMT'});
		columns.push({ title: '<spring:message code="split.splitMinAMT" text="可拆分最小金额" />', data: 'splitMinAMT'});
		columns.push({ title: '<spring:message code="split.splitAmtSort" text="拆分后金额排序" />', data: 'splitAmtSort',
			render : function(data, type, row, meta) {
				return ${splitAmtSortJson}[data];
			}
		});
		var grid = $K.createGrid("#split_datatable",{
	          	ajax: {
	  				url: "${ctx}/split/querySplitList.in",
	  				method: "post",
	  				data: function(d) {
						d.splitName = $("#splitName").val();
						d.splitMethod = $("#splitMethod").val();
	  				}
	  			},
	  			columns: columns
	          },
	          {
	          	checkbox:true,//是否显示选择框
	          	singleCheck:false,//是否单选
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
			$K.frame.loadPage("${ctx}/split/splitDetailPage.in?" + params.join("&"), grid);
		}
		grid.dbClick(dbclick);
	</script>
	
	<!-- 权限单元-控制代码块 -->
	
</html>