<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<title><spring:message code="phyCardCd.query.title" text="卡面代码参数查询" /></title>
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
						<form:form class="form-search form-horizontal form-label-left" datatable-target="phyCardCd_datatable" modelAttribute="phyCardCd">
							<div class="form-group">
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="pyhCd">
									<spring:message code="phyCardCd.pyhCd" text="卡面代码" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="pyhCd"  data-rule-required="true" data-rule-maxlength="10" />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="description">
									<spring:message code="phyCardCd.description" text="描述" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="description"  data-rule-required="true" data-rule-maxlength="40" />
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
								<table id="phyCardCd_datatable" class="datatable table table-hover table-striped table-bordered">
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
	<k:access code="phyCardCd_add" var="addUrl"/>
	<k:access code="phyCardCd_edit" var="editUrl"/>
	<k:access code="phyCardCd_delete" var="delUrl"/>
	<!-- 创建datatable表格 -->
	<script type="text/javascript">
		var pkNames = [];
		var columns = [];
		pkNames.push("pyhCd");
		columns.push({ title: '<spring:message code="phyCardCd.pyhCd" text="卡面代码" />', data: 'pyhCd'});
		columns.push({ title: '<spring:message code="phyCardCd.description" text="描述" />', data: 'description'});
		columns.push({ title: '<spring:message code="phyCardCd.embossFileName" text="卡面制卡文件" />', data: 'embossFileName'});
		var grid = $("#phyCardCd_datatable").grid({
			datatable : {
	          	ajax: {
	  				url: "${ctx}/phyCardCd/queryPhyCardCdList.in",
	  				method: "post",
	  				data: function(d) {
						d.pyhCd = $("#pyhCd").val();
						d.description = $("#description").val();
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
			$K.frame.loadPage("${ctx}/phyCardCd/phyCardCdDetailPage.in?" + params.join("&"), grid);
		}
		grid.dbClick(dbclick);
		<k:access code="phyCardCd_detail">
		//自定义按钮
		var btn=$("<button class='btn btn-success' ><i class='fa fa-newspaper-o' aria-hidden='true'><spring:message code='product.detail' text='详情' /></i></button>")
		btn.click(function(){
			var rowDatas = grid.getSelectRows();
			if (rowDatas==undefined||rowDatas==null||rowDatas.length==0) {
				layer.msg(""+"<spring:message code='product.mustselectone1' text='必须选中一行!' />");
				return;
			}else if(rowDatas.length>1){
			layer.msg(""+"<spring:message code='product.mustselectone2' text='不可选择多行，只能选中一行!' />");
				return;
			} 
// 			var jsonData=JSON.stringify(rowDatas);
// 			var org=${org};
			var pyhCd=rowDatas[0].pyhCd;
			$K.frame.loadPage("${ctx}/phyCardCd/phyCardCdCheckPage.in?pyhCd="+pyhCd,grid);
		});
		grid.addButton(btn);
		
		</k:access>
	</script>
	<!-- 权限单元-控制代码块 -->
	
</html>