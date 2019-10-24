<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="product.detail.title" text="产品参数管理明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<div class="x_panel">
		<div class="x_title">
			<h2>
				<spring:message code="financial.baseInfo" text="基本信息" />
			</h2>
			<ul class="nav navbar-right panel_toolbox def-toolbox">
				<li>
					<a class="collapse-link">
						<i class="fa fa-chevron-up"></i>
					</a>
				</li>
			</ul>
			<div class="clearfix"></div>
		</div>
		<div class="x_content">
			<div class='panel panel-default'>
				<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="product">
					<div class="form-group row">
						<!-- 产品代码 -->
						<label class="col-lg-3 col-md-3 col-sm-6 col-xs-6 control-label">
							<spring:message code="product.productCode" text="产品代码" />
							:
						</label>
						<label class="col-lg-3 col-md-3 col-sm-6 col-xs-6 detailStyle"> &nbsp;${product.productCode } </label>
						<!-- 产品描述 -->
						<label class="col-lg-3 col-md-3 col-sm-6 col-xs-6 control-label">
							<spring:message code="product.description" text="产品描述" />
							:
						</label>
						<label class="col-lg-3 col-md-3 col-sm-6 col-xs-6 detailStyle"> &nbsp;${product.description } </label>
						<!-- BIN -->
						<label class="col-lg-3 col-md-3 col-sm-6 col-xs-6 control-label">
							<spring:message code="product.bin" text="BIN" />
							:
						</label>
						<label class="col-lg-3 col-md-3 col-sm-6 col-xs-6 detailStyle"> &nbsp;${product.bin } </label>
						<!-- 产品类型 -->
						<label class="col-lg-3 col-md-3 col-sm-6 col-xs-6 control-label">
							<spring:message code="product.productType" text="产品类型" />
							:
						</label>
						<label class="col-lg-3 col-md-3 col-sm-6 col-xs-6 detailStyle"> &nbsp;${productType} </label>
						<!--  电子账号长度 -->
						<label class="col-lg-3 col-md-3 col-sm-6 col-xs-6 control-label">
							<spring:message code="product.accountLen" text="电子账号长度" />
							:
						</label>
						<label class="col-lg-3 col-md-3 col-sm-6 col-xs-6 detailStyle"> &nbsp;${product.cardnoLen } </label>
						<!--  电子账号上限 -->
						<label class="col-lg-3 col-md-3 col-sm-6 col-xs-6 control-label">
							<spring:message code="product.accountRangeCeil" text="电子账号上限" />
							:
						</label>
						<label class="col-lg-3 col-md-3 col-sm-6 col-xs-6 detailStyle"> &nbsp;${product.cardnoRangeCeil } </label>
						<!--  电子账号下限 -->
						<label class="col-lg-3 col-md-3 col-sm-6 col-xs-6 control-label">
							<spring:message code="product.accountRangeFlr" text="电子账号下限" />
							:
						</label>
						<label class="col-lg-3 col-md-3 col-sm-6 col-xs-6 detailStyle"> &nbsp;${product.cardnoRangeFlr } </label>
						<!--基准货币 -->
						<label class="col-lg-3 col-md-3 col-sm-6 col-xs-6 control-label">
							<spring:message code="product.currency" text="基准货币" />
							:
						</label>
						<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle"> &nbsp;${currency } </label>
						<!-- 人行记录是否合并 -->
						<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
							<spring:message code="product.isPbocInfoMerged" text="人行记录是否合并" />
							:
						</label>
						<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 detailStyle">
								 &nbsp;${isPbocInfoMerged}
						</label>
						<!-- 人行记录是否合并描述 -->
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<c:forEach var="group" items="${groupList }">
		<div class="x_panel">
			<div class="x_title">
				<h2>${group.groupNameCn}</h2>
				<ul class="nav navbar-right panel_toolbox def-toolbox">
					<li>
						<a class="collapse-link">
							<i class="fa fa-chevron-up"></i>
						</a>
					</li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="padding-top: 20px">
					<c:forEach var="units" items="${unitsMap[group.groupCode] }">
						<!-- 在线 -->
						<div class="col-lg-3 col-md-6 col-sm-6 col-xs-6">
							<div class="stats-container">
								<div class="unit-title" style="text-align: left;">
									<span class="">${units.unitNameCn }</span>
									<div class='product hide'>
										<i class='product-view fa fa-list-ul' title="查看" data-target-url="${units.unitDetailUrl }"></i>
										<i class='product-config fa fa-wrench' title="配置" data-target-url="${units.unitConfigUrl }" data-iframe-id="${units.unitCode }" data-config-index="${units.unitIndex }" data-unit-class='${units.unitClass }' data-param-key='${dataMap[units.unitCode]}'
											data-relation-untis="${units.updateUnits }" 
											></i>
									</div>
								</div>
								<div class="unit-content ">
									<!-- scrolling='no'  -->
									<iframe id="iframe_${units.unitCode }" data-oldbase-url='${ctx }${units.unitBaseUrl }' src="${ctx }${units.unitBaseUrl }?productCode=${dataMap[units.unitCode]}&subUnit=${units.subUnit }" style="min-height: 240px; max-height: 240px" width="100%" height="0px" frameborder="no" border="0" marginwidth="0"
										marginheight="0" allowtransparency="yes"></iframe>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</c:forEach>
	<div class="form-controls auto-float">
			<div class="btn-group-sm">
			<k:access code="product_edit">
				<!--修改 -->
				<input type="button" class="btn-info btn" id="updateProduct" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
				<script type="text/javascript">
					$("#updateProduct").click(function(){
						var params = [];
						params.push("productCode=${product.productCode }");
						$K.frame.reloadSlideInner("${ctx}/product/productConfigEditPage.in?" + params.join("&"));
					})
				</script>
			</k:access>
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
			</div>
		</div>
	<%@ include file="/common/foot.jsp"%>
	<script type="text/javascript">
	//开启表单验证 
	$("#productUpdForm").validate();
	$(".product-config").each(function(i,view){
		var paramKey=$(this).data("param-key");
		var index=$(this).data("config-index");
		if(paramKey){
		    var divCont=$(this).parents(".stats-container");
		    divCont.css("border","1px solid rgba(208, 216, 230,0.52)");
		    var relationUnitCodes=$(this).data("relation-untis");//iframe关联 需要关联的iframe的id
		    //判断该iframe是否需要联动其他的iframe
			if(relationUnitCodes){
				var codes=relationUnitCodes.split(",");
				for(var i=0;i<codes.length;i++){
					var	 iframeRelObj=$('#iframe_'+codes[i]);
					var productCode=iframeRelObj.attr("src").split("?")[1];
					var params = [];
					params.push(productCode);
					params.push("parentProductCode="+paramKey);
					iframeRelObj.attr('src', iframeRelObj.data("oldbase-url")+"?"+params.join("&"));
				}
			}
		} 
	})
	</script>
</body>
</html>