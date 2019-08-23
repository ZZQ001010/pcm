<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<title><spring:message code="product.query.title" text="产品参数管理查询" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
<style type="text/css">
	/* a{
		background-color: 
	} */
</style>
</head>
<body class="${param.skin}">
	<!-- 整体皮肤样式 -->
	<div class="container">
		<div class="row" style="margin: 0px;">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="padding: 0px;">
				<div class="x_panel">
					<div class="x_content">
						<!-- datatable-target="(table-id)" 配置查询表单关联对应的datatable数据表格 -->
						<form:form class="form-search form-horizontal form-label-left" datatable-target="product_datatable" modelAttribute="product">
							<div class="form-group">
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="productCode">
									<spring:message code="product.productCode" text="产品代码" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="productCode"  data-rule-required="true" data-rule-maxlength="6" />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="description">
									<spring:message code="product.description" text="产品描述" />
									:
								</label>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="productType">
									<spring:message code="product.productType" text="产品类型" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:select cssClass="form-control" path="productType">
										<option value=""><spring:message code="kite.web.common.pleaseChoose"  text="--请选择--" /></option>
										<form:options items="${productType}" />
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
								<table id="product_datatable" class="datatable table table-hover table-striped table-bordered">
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
	<k:access code="product_add" var="addUrl"/>
	<k:access code="product_edit" var="editUrl"/>
	<k:access code="product_delete" var="delUrl"/>
	<!-- 创建datatable表格 -->
	<script type="text/javascript">
		var pkNames = [];
		var columns = [];
		pkNames.push("productCode");
		columns.push({ title: '<spring:message code="product.productCode" text="产品代码" />', data: 'productCode'});
		columns.push({ title: '<spring:message code="product.description" text="产品描述" />', data: 'description'});
		columns.push({ title: '<spring:message code="product.productType" text="产品类型" />', data: 'productType',
			render : function(data, type, row, meta) {
				return ${productTypeJson}[data];
			}
		});
		var grid = $("#product_datatable").grid({
			datatable : {
	          	ajax: {
	  				url: "${ctx}/product/queryProductList.in",
	  				method: "post",
	  				data: function(d) {
						d.productCode = $("#productCode").val();
						d.description = $("#description").val();
						d.productType = $("#productType").val();
	  				}
	  			},
	  			columns: columns
	  		},
	        //addUrl:addUrl,//新增页面url
	        updateUrl:editUrl,//修改页面url
	        deleteUrl:delUrl,//删除数据url
	        pkNames:pkNames//表格数据主键字段名称
		});
		//新增按钮
		if(addUrl){
			var addBtn=$("<button class='btn btn-success' ><i class='fa fa-plus'></i><spring:message code="product_add" text="新增" /></button>");
			addBtn.click(function(){
				var isTrue=false;
				var productCode="";
				// 弹窗
				$K.layerOpen({
					win:window,
					content: ["${ctx}"+addUrl, 'yes'],	// 必填
					type:2,
					area: ['50%', '50%'],
					title:"<spring:message  code='product.addProductConfigPage' text='产品配置新增' />",
					btn: ['<spring:message  code="kite.web.common.btnSure" text="确定" />', '<spring:message  code="kite.web.common.btnBack" text="返回" />'],
					yes: function(index, layero) {
						productCode=$(layero).find("iframe").contents().find("#productCode").val();
						layer.getChildFrame('#submit', index).click();
						isTrue=true;
					},
					btn2: function(index,layero){
						isTrue=false;
					},
					cancel: function(index, layero) {
						isTrue=false;
						layer.close(index);
					},
					end:function(index){
						layer.close(index);
						if(isTrue){
							//跳转到修改页面
							$K.frame.loadPage("${ctx}/product/productEditPage.in?productCode="+productCode, grid);
						}
					}
				}); 
			})
			grid.addButton(addBtn,1);//1代表按钮位置在第几个 从0开始
		}
	
	    var dbclick = function(rowIndex, rowData, rowObj) {
	    	var params = [];
	    	for(var i in pkNames){
	    		if(pkNames[i] && rowData[pkNames[i]]){
	    			params.push(pkNames[i] + "=" + rowData[pkNames[i]]);
	    		}
	    	}
			$K.frame.loadPage("${ctx}/product/productDetailPage.in?" + params.join("&"), grid);
		}
		grid.dbClick(dbclick);


	</script>
	<!-- 权限单元-控制代码块 -->
	
</html>