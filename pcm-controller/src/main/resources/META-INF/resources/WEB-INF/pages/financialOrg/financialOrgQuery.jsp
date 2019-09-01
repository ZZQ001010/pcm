<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<title><spring:message code="financialOrg.query.title" text="合作机构查询" /></title>
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
						<form:form class="form-search form-horizontal form-label-left" datatable-target="financialOrg_datatable" modelAttribute="financialOrg">
							<div class="form-group">
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="financialOrgNO">
									<spring:message code="financialOrg.financialOrgNO" text="金融机构编码" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" path="financialOrgNO"  />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="financialOrgName">
									<spring:message code="financialOrg.financialOrgName" text="金融机构名称" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" path="financialOrgName"   />
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
								<table id="financialOrg_datatable" class="datatable table table-hover table-striped table-bordered">
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
	<k:access code="financialOrg_add" var="addUrl"/>
	<k:access code="financialOrg_edit" var="editUrl"/>
	<k:access code="financialOrg_delete" var="delUrl"/>
	<!-- 创建datatable表格 -->
	<script type="text/javascript">
		var pkNames = [];
		var columns = [];
		pkNames.push("financialOrgNO");
		columns.push({ title: '<spring:message code="financialOrg.financialOrgName" text="金融机构名称" />', data: 'financialOrgName'});
		columns.push({ title: '<spring:message code="financialOrg.financialOrgAcctNo" text="金融机构对公账户" />', data: 'financialOrgAcctNo'});
		columns.push({ title: '<spring:message code="financialOrg.financialOrgPayNo" text="金融机构理赔账户" />', data: 'financialOrgPayNo'});
		columns.push({ title: '<spring:message code="financialOrg.adFeeScale" text="提前还款手续费分成比例" />', data: 'adFeeScale'});
		columns.push({ title: '<spring:message code="financialOrg.acqAcceptorId" text="金融机构标识码" />', data: 'acqAcceptorId'});
		var grid = $K.createGrid("#financialOrg_datatable",{
	          	ajax: {
	  				url: "${ctx}/financialOrg/queryFinancialOrgList.in",
	  				method: "post",
	  				data: function(d) {
						d.financialOrgNO = $("#financialOrgNO").val();
						d.financialOrgName = $("#financialOrgName").val();
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
			$K.frame.loadPage("${ctx}/financialOrg/financialOrgDetailPage.in?" + params.join("&"), grid);
		}
		grid.dbClick(dbclick);
// 	    var dbclick = function(rowIndex, rowData, rowObj) {
// 	    	var params = [];
// 	    	for(var i in pkNames){
// 	    		if(pkNames[i] && rowData[pkNames[i]]){
// 	    			params.push(pkNames[i] + "=" + rowData[pkNames[i]]);
// 	    		}
// 	    	}
// 			$K.frame.loadPage("${ctx}/financialOrg/financialOrgCheckPage.in?" + params.join("&"), grid);
// 		}
// 		grid.dbClick(dbclick);
		<k:access code="financialOrg_detail">
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
			var financialOrgNO=rowDatas[0].financialOrgNO;
			$K.frame.loadPage("${ctx}/financialOrg/financialOrgCheckPage.in?financialOrgNO="+financialOrgNO,grid);
		});
		grid.addButton(btn);
		
		</k:access>
	</script>
	<!-- 权限单元-控制代码块 -->
	
</html>