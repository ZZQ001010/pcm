<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<title><spring:message code="msgTemplate.query.title" text="短信模板查询" /></title>
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
						<form:form class="form-search form-horizontal form-label-left" datatable-target="bMPMessageTemplate_datatable" modelAttribute="bMPMessageTemplate">
							<div class="form-group">
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="code">
									<spring:message code="bMPMessageTemplate.code" text="信息代码" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="code"  data-rule-required="true" data-rule-maxlength="20" />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="systemType">
									<spring:message code="bMPMessageTemplate.systemType" text="系统类型" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:select cssClass="form-control" path="systemType" >
										<option value=""><spring:message code="kite.web.common.pleaseChoose"  text="--请选择--" /></option>
										<form:options items="${systemType}" />
									</form:select>
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="msgCategory">
									<spring:message code="bMPMessageTemplate.msgCategory" text="信息分类" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:select cssClass="form-control" path="msgCategory" >
										<option value=""><spring:message code="kite.web.common.pleaseChoose"  text="--请选择--" /></option>
										<form:options items="${msgCategory}" />
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
								<table id="bMPMessageTemplate_datatable" class="datatable table table-hover table-striped table-bordered">
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
	<k:access code="msgTemplate_add" var="addUrl"/>
	<k:access code="msgTemplate_edit" var="editUrl"/>
	<k:access code="msgTemplate_delete" var="delUrl"/>
	<!-- 创建datatable表格 -->
	<script type="text/javascript">
		var pkNames = [];
		var columns = [];
		pkNames.push("code");
		columns.push({ title: '<spring:message code="bMPMessageTemplate.code" text="信息代码" />', data: 'code'});
		columns.push({ title: '<spring:message code="bMPMessageTemplate.systemType" text="系统类型" />', data: 'systemType',
			render : function(data, type, row, meta) {
				return ${systemTypeJson}[data];
			}
		});
		columns.push({ title: '<spring:message code="bMPMessageTemplate.msgCategory" text="信息分类" />', data: 'msgCategory',
			render : function(data, type, row, meta) {
				return ${msgCategoryJson}[data];
			}
		});
		columns.push({ title: '<spring:message code="bMPMessageTemplate.sendingMethod" text="发送方法" />', data: 'sendingMethod',
			render : function(data, type, row, meta) {
				return ${sendingMethodJson}[data];
			}
		});
		columns.push({ title: '<spring:message code="bMPMessageTemplate.desc" text="信息描述" />', data: 'desc'});
		var grid = $K.createGrid("#bMPMessageTemplate_datatable",{
	          	ajax: {
	  				url: "${ctx}/msgTemplate/queryMsgTemplateList.in",
	  				method: "post",
	  				data: function(d) {
						d.code = $("#code").val();
						d.systemType = $("#systemType").val();
						d.msgCategory = $("#msgCategory").val();
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
			$K.frame.loadPage("${ctx}/msgTemplate/msgTemplateDetailPage.in?" + params.join("&"), grid);
		}
		grid.dbClick(dbclick);
		<k:access code="msgTemplate_detail">
		//自定义按钮
		var btn=$("<button class='btn btn-success' ><i class='fa fa-newspaper-o' aria-hidden='true'><spring:message code='product.detail' text='详情' /></i></button>")
		btn.click(function(){
			var rowDatas = grid.getSelectRows();
			if (rowDatas==undefined||rowDatas==null||rowDatas.length==0) {
				layer.msg(""+"<spring:message code='workBench.mustselectone' text='必须选中一行!' />");
				return;
			}else if(rowDatas.length>1){
			layer.msg(""+"<spring:message code='' text='不可选择多行，只能选中一行!' />");
				return;
			} 
// 			var jsonData=JSON.stringify(rowDatas);
// 			var org=${org};
			var msgTemplate=rowDatas[0].code;
			$K.frame.loadPage("${ctx}/msgTemplate/msgTemplateCheckPage.in?code="+msgTemplate,grid);
		});
		grid.addButton(btn);
		
		</k:access>
	</script>
	<!-- 权限单元-控制代码块 -->
	
</html>