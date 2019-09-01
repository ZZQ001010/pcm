<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<title><spring:message code="prmAudit.query.title" text="参数变更日志查询" /></title>
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
						<form:form class="form-search form-horizontal form-label-left" datatable-target="tmPrmAudit_datatable" modelAttribute="tmPrmAudit">
							<div class="form-group">
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="paramClass">
									<spring:message code="tmPrmAudit.paramClass" text="参数类别" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="paramClass"  data-rule-maxlength="200" />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="mtnUser">
									<spring:message code="tmPrmAudit.mtnUser" text="修改用户" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="mtnUser"  data-rule-maxlength="40" />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="paramOperation">
									<spring:message code="tmPrmAudit.paramOperation" text="操作" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:select cssClass="form-control" path="paramOperation">
										<option value=""><spring:message code="kite.web.common.pleaseChoose"  text="--请选择--" /></option>
										<form:options items="${paramOperation}" />
									</form:select>
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="jpaTimestamp">
									<spring:message code="tmPrmAudit.jpaTimestamp" text="操作时间" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
									<form:input class='form-control customize-date-range' type="text" data-picker-position="bottom-right" data-role-formate="yyyy-mm-dd" path="jpaTimestamp" />
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
								<table id="tmPrmAudit_datatable" class="datatable table table-hover table-striped table-bordered">
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
	
	<!-- 创建datatable表格 -->
	<script type="text/javascript">
		var pkNames = [];
		var columns = [];
		pkNames.push("id");
		columns.push({ title: '<spring:message code="tmPrmAudit.id" text="ID" />', data: 'id'});
		columns.push({ title: '<spring:message code="tmPrmAudit.paramClass" text="参数类别" />', data: 'paramClass'});
		columns.push({ title: '<spring:message code="tmPrmAudit.mtnUser" text="修改用户" />', data: 'mtnUser'});
		columns.push({ title: '<spring:message code="tmPrmAudit.paramOperation" text="操作" />', data: 'paramOperation',
			render : function(data, type, row, meta) {
				return ${paramOperationJson}[data];
			}
		});
		columns.push({ title: '<spring:message code="tmPrmAudit.jpaTimestamp" text="操作时间" />', data: 'jpaTimestamp',
			type : 'date',
			render : function(data, type, row, meta) {
				return $K.date.format(data, "dateTime");
			}
		});
		var grid = $("#tmPrmAudit_datatable").grid({
			datatable : {
	          	ajax: {
	  				url: "${ctx}/prmAudit/queryPrmAuditList.in",
	  				method: "post",
	  				data: function(d) {
						d.paramClass = $("#paramClass").val();
						d.mtnUser = $("#mtnUser").val();
						d.paramOperation = $("#paramOperation").val();
						d.jpaTimestamp = $("#jpaTimestamp").val();
	  				}
	  			},
	  			columns: columns
			},
			pkNames:pkNames//表格数据主键字段名称
		});
		<k:access code="pcm-auditLog-detail">
	    var dbclick = function(rowIndex, rowData, rowObj) {
	    	var params = [];
	    	for(var i in pkNames){
	    		if(pkNames[i] && rowData[pkNames[i]]){
	    			params.push(pkNames[i] + "=" + rowData[pkNames[i]]);
	    		}
	    	}
			$K.frame.loadPage("${ctx}/prmAudit/prmAuditDetailPage.in?" + params.join("&"), grid);
		}
		grid.dbClick(dbclick);
		</k:access>
	</script>
	<!-- 权限单元-控制代码块 -->
	
</html>