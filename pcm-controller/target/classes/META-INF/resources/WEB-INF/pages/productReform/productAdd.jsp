<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp" %>
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	    <title><spring:message code="product.add.title" text="产品参数管理新增"/></title>
	    <!-- 引入css样式和部分js -->
	    <%@ include file="/common/head.jsp" %>
	    <style type="text/css">
	    	.required-star:before {
				content: "* ";
				color: red;
			}
	    </style>
	</head>
	
	<!-- 整体皮肤样式 -->
	<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
		<form:form cssClass="form-horizontal " id="productAddForm" cssStyle="padding-top: 50px" modelAttribute="product">
		    <div class="form-group row">
		        <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label required-star">
		            <spring:message code="product.productCode" text="产品代码"/>:
		        </label>
		        <div class="col-lg-2 col-md-4 col-sm-4 col-xs-4">
		            <form:input cssClass="form-control" path="productCode" data-rule-required="true" data-rule-maxlength="6"/>
		        </div>
		        <div class="hide desc" for="productCode">
		            <spring:message code="product.productCode.desc"/>
		        </div>
		        
		        <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label required-star">
		            <spring:message code="product.productType" text="产品类型"/>:
		        </label>
		        <div class="col-lg-2 col-md-4 col-sm-4 col-xs-4">
		          <%--   <form:select cssClass="form-control" path="productType" data-rule-required="true">
		            	<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--"/></option>
		                <form:options items="${productTypeMap}"/>
		            </form:select> --%>
		            <form:input cssClass="form-control" path="groupType" data-rule-required="true" />
		        </div>
		        <script>
		        	
		        </script>
		        <div class="hide desc" for="productType">
		            <spring:message code="product.productType.desc"/>
		        </div>
		    </div>
		   
		    
		    <div class="form-group row">
		        <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
		            <spring:message code="product.description" text="产品描述"/>
		            :
		        </label>
		        <div class="col-lg-6 col-md-10 col-sm-10 col-xs-10">
		            <form:textarea cssClass="form-control" path="description" rows="4" data-rule-maxlength="200"></form:textarea>
		        </div>
		        <div class="hide desc" for="description">
		            <spring:message code="product.description.desc"/>
		        </div>
		    </div>
		    
		    <div class="row" style="padding-right: 60px">
		        <div class="btn-group-md" align="right">
		            <!-- 确定 -->
		            <input type="button" id="submit" class="btn-primary btn"
		                   value="<spring:message code='kite.web.common.beginCreatePro' text='开始创建产品' />"/>
		        </div>
		    </div>
		</form:form>
	</body>
	
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp" %>
	<script type="text/javascript" src="${ctxStatic}/js/descode.js"></script>
	<script type="text/javascript">
	
	
	$("#productAddForm").validate();
	
	    //点击开始创建按钮 进行创建产品
	    $("#submit").click(function () {
	        if (!$("#productAddForm").valid()) {
	            return false;
	        }
	        var productData = {};
	        var params = $("#productAddForm").serializeArray();
	        $.each(params, function () {
	        	if(this.name=="__groupType"){
	        		return true;
	        	}
	            productData[this.name] = this.value;
	        });
	        debugger
	        // 将参数代入下一个页面
	        $K.frame.reloadSlideInner("${ctx}/productReform/productStepAncestorPage.in?productStr=" + encodeURI(JSON.stringify(productData)));
	    });
	    /* $(function() {
	    	// 初始化选中项
	    	if ('${productType}') {
		    	$('#productType').selectpicker('val', '${productType}');
	    	}
	    }); */
	    
	    
	    
		//hide 描述
		$.each($(".desc"), function(i, d) {
			var tar = $('#' + $(d).attr('for')), desc = d.innerText;
			var tar = $("#"+$(d).attr('for')), desc = d.innerText;
			if (tar && tar[0] && tar[0].tagName === 'SELECT') {
				tar = tar.parent();
			}
			tar.tooltip({
				title : desc
			});
		});
	    
	    
	    <!-- 下拉树 -->
    	var combobox = $("#groupType").combobox({
    		type: 'tree',
			url: '${ctx}/productUnit/loadProductTree.in',
			param: {},
			multi: false,
			value: "groupCode",
			desc: "name",
			tree: {
				data: {
					simpleData: {idKey: "id", pIdKey: "productParentId"},
					key: {name: "name"}
				},
				callback: {
					beforeClick: function(treeId, treeNode, clickFlag) {
			/* 			if (treeNode.abstractInstance != "N") {
							return false;
						} */
					}
				}
			},
			treeExtra: {
				expandAll: false,
				singleSelectHide: true
			}
    	})
	</script>
</html>