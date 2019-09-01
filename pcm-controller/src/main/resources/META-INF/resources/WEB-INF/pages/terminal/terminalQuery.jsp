<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<title><spring:message code="terminal.query.title" text="终端类型维护查询" /></title>
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
						<form:form class="form-search form-horizontal form-label-left" datatable-target="terminal_datatable" modelAttribute="terminal">
							<div class="form-group">
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="terminalId">
									<spring:message code="terminal.terminalId" text="终端类型ID" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="terminalId"  data-rule-maxlength="20" />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="terminalDesc">
									<spring:message code="terminal.terminalDesc" text="终端描述" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="terminalDesc"  data-rule-maxlength="100" />
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
								<table id="terminal_datatable" class="datatable table table-hover table-striped table-bordered">
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
	<k:access code="terminal_add" var="addUrl"/>
	<k:access code="terminal_edit" var="editUrl"/>
	<k:access code="terminal_delete" var="delUrl"/>
	<!-- 创建datatable表格 -->
	<script type="text/javascript">
		var pkNames = [];
		var columns = [];
		pkNames.push("terminalId");
		columns.push({ title: '<spring:message code="terminal.terminalId" text="终端类型ID" />', data: 'terminalId'});
		columns.push({ title: '<spring:message code="terminal.terminalDesc" text="终端描述" />', data: 'terminalDesc'});
		var grid = $K.createGrid("#terminal_datatable",{
	          	ajax: {
	  				url: "${ctx}/terminal/queryTerminalList.in",
	  				method: "post",
	  				data: function(d) {
						d.terminalId = $("#terminalId").val();
						d.terminalDesc = $("#terminalDesc").val();
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
			$K.frame.loadPage("${ctx}/terminal/terminalDetailPage.in?" + params.join("&"), grid);
		}
		grid.dbClick(dbclick);
	</script>
	<!-- 权限单元-控制代码块 -->
	
</html>