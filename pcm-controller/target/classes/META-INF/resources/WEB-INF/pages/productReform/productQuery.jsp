<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp" %>
<html lang="en">
	<head>
	    <meta charset="utf-8"/>
	    <title><spring:message code="product.query.title" text="产品参数管理查询"/></title>
	    <!-- 引入css样式和部分js -->
	    <%@ include file="/common/head.jsp" %>
	    <style type="text/css">
	    </style>
	</head>
	
	<body class="${param.skin}">
		<div class="container">
		    <div class="row" style="margin: 0px;">
		        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="padding: 0px;">
		            <div class="x_panel">
		                <div class="x_content">
		                    <!-- datatable-target="(table-id)" 配置查询表单关联对应的datatable数据表格 -->
		                    <form:form class="form-search form-horizontal form-label-left" datatable-target="product_datatable" modelAttribute="product">
		                        <div class="form-group">
		                            <label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="productCd">
		                                <spring:message code="product.productCd" text="产品代码"/>:
		                            </label>
		                            <div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
		                                <form:input cssClass="form-control" type="text" path="productCode"
		                                            data-rule-required="true" data-rule-maxlength="6"/>
		                            </div>
		                           <%--  <label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="productType">
		                                <spring:message code="product.productType" text="产品类型"/>:
		                            </label>
		                            <div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
		                                <form:select cssClass="form-control" path="productType">
		                                    <option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--"/></option>
		                                    <form:options items="${productTypeMap}"/>
		                                </form:select>
		                            </div> --%>
		                        </div>
		                        <div class="form-controls">
		                            <div class="btn-group-sm">
		                                <!-- grid-search,点击该按钮自动查询form[datatable-target]对应的数据 -->
		                                <button class="btn btn-success grid-search" type="button">
		                                    <!-- 查询 -->
		                                    <i class="fa fa-search"></i>
		                                    <spring:message code="kite.web.common.btnCheck" text="查询"/>
		                                </button>
		                                <button class="btn btn-primary" type="reset">
		                                    <!-- 重置-->
		                                    <i class="fa fa-refresh"></i>
		                                    <spring:message code="kite.web.common.btnReset" text="重置"/>
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
	</body>
	
	<!-- 引入js -->
	<%@ include file="/common/foot.jsp" %>
	<!-- 权限单元-控制js变量 -->
	<k:access code="productReform_delete" var="delUrl"/>
	<!-- 创建datatable表格 -->
	<script type="text/javascript">
	    var pkNames = ['productCode'];
	    var columns = [];
	    columns.push({title: '<spring:message code="product.productCode" text="产品代码" />', data: 'productCode'});
	    columns.push({title: '<spring:message code="product.description" text="产品描述" />', data: 'description'});
	    columns.push({
	        title: '<spring:message code="product.productType" text="产品类型" />', data: 'groupType',
	        render: function (data, type, row, meta) {
	        	return ${productTypeJson}[data] || data;
	        }
	    });
	    var grid = $("#product_datatable").grid({
	        datatable: {
	            ajax: {
	                url: "${ctx}/productReform/queryProductList.in",
	                method: "post",
	                data: function (d) {
	                    d.productCode = $("#productCode").val();
/* 	                    d.description = $("#description").val();
	                    d.productType = $("#productType").val(); */
	                 /*    d.productType = "${productType}"; */
	                }
	            },
	            columns: columns
	        },
	        deleteUrl: delUrl,//删除数据url
	        pkNames: pkNames//表格数据主键字段名称
	    });
	    var dbclick = function (rowIndex, rowData, rowObj) {
	        var menuMap = {
        		id: "productShow_" + rowData.productCode,
				text: "<spring:message code='product.productShow' text='产品展示' />",
				url: "${ctx}/productReform/productShow.in?productCode=" + rowData.productCode
	        };
	        //新添加一个tab
	        window.top.add_menu_tab(menuMap);
	    }
	    grid.dbClick(dbclick);
	</script>
	
	<k:access code="productReform_add" var="addUrl"/>
	<k:access code="productReform_add">
		<script type="text/javascript">
		    var addBtn = $("<button class='btn btn-success' ><i class='fa fa-plus'></i><spring:message code='product_add' text='新增' /></button>");
		    addBtn.click(function () {
		        var menuMap = {
					id: "productReformAdd",
					text: "<spring:message code='product.productAdd' text='产品新增' />",
					url: "${ctx}" + addUrl + '?productType=${productType}'
				};
		        //新添加一个tab
		        window.top.add_menu_tab(menuMap);
		    })
		    grid.addButton(addBtn, 1);
		</script>
	</k:access>
	
	<k:access code="productReform_edit" var="editUrl"/>
	<k:access code="productReform_edit">
		<script type="text/javascript">
		    var updBtn = $("<button class='btn btn-success' ><i class='fa fa-edit'></i><spring:message code='kite.web.common.btnUpd' text='修改' /></button>");
		    updBtn.click(function () {
		        var rows = grid.getSelectRows();
		        if (rows.length > 1 || rows.length == 0) {
		            return layer.msg('<spring:message code="kite.web.mustSelectOne" text="请选择一行数据" />');
		        }
		        var menuMap = {
		            id: "productReformEdit",
		            text: "<spring:message code='product.productEdit' text='产品修改' />",
		            url: "${ctx}" + editUrl + "?productCode=" + rows[0].productCode + "&currPage=edit"
		        };
		        //新添加一个tab
		        window.top.add_menu_tab(menuMap);
		    })
		    grid.addButton(updBtn, 2);
		</script>
	</k:access>
	
	<k:access code="productReform_delete">
		<script type="text/javascript">
		</script>
	</k:access>
</html>