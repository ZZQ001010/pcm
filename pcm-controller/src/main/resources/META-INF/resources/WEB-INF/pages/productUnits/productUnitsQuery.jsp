<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<title><spring:message text="" code="user.query.title" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<body class="${param.skin}">
	<!-- 整体皮肤样式 -->
	<div class="container">
		<div class="row" style="margin: 0px;">
			<div align="left" style="width: 20%; float: left;">
				<ul id="productTree" class="ztree" style="width: 230px; overflow: auto;"></ul>
			</div>
			<div id="rMenu" class="ztree-right-menu"><!--  -->
				<ul class=" dropdown-menu list-group"><!--list-group ztree-list-group  -->
					<k:access code="right_add">
						<li class="list-group-item" id='addGroup'>
							<a   onclick="addGroup()"><i class="fa fa-plus">&nbsp</i><spring:message code="productUnits.addGroup"  text="新增产品分组"/></a>
						</li>
					</k:access>
					<k:access code="right_upd">
						<li class="list-group-item" id='updGroup'>
							<a  onclick="updGroup()"><i class="fa fa-pencil">&nbsp</i><spring:message code="productUnits.updGroup"  text="修改产品分组"/></a>
						</li>
					</k:access>
					<k:access code="right_delete">
						<li class="list-group-item" id='delGroup'>
							<a   onclick="delGroup()"><i class="fa fa-remove fa-muted">&nbsp</i><spring:message code="productUnits.delGroup"  text="删除产品分组"/></a>
						</li>
					</k:access>		
				</ul>
			</div>
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="width: 80%; float: left;">
				<div class='panel panel-default' id="showDetail">
					<!-- 分组详情  -->
					<form class="form-horizontal hide" id="productGroupDetail">
						<div class="form-group row">
						<!-- 	<label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-3 ">
								<spring:message code="tmProductGroup.groupCode" text="分组编码" />
								:
							</label>
							<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3  detailStyle" id="groupCode1"> </label> -->
							<c:choose>
								<c:when test="${pageContext.response.locale eq 'zh_CN'}">
									<label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-3 ">
										<spring:message code="tmProductGroup.groupNameCn" text="分组名称" />
										:
									</label>	
								</c:when>
								<c:otherwise>
									<label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-3 ">
										<spring:message code="tmProductGroup.groupName" text="分组名称" />
										:
									</label>
								</c:otherwise>
							</c:choose>
							<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3  detailStyle" id="groupName"> </label>
							<label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-3">
								<spring:message code="tmProductGroup.groupIndex" text="分组序号" />
								:
							</label>
							<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3  detailStyle" id="groupIndex"> </label>
						</div>
					</form>
				</div>
				
				<div class="x_panel">
					<div class="x_content panel panel-default">
						<!-- datatable-target="(table-id)" 配置查询表单关联对应的datatable数据表格 -->
						<form:form class="form-search form-horizontal form-label-left" datatable-target="tmProductUnits_datatable" modelAttribute="tmProductUnits">
							<form:input  type="hidden" path="groupCode"/>
							<div class="form-group">
								<label class="control-label col-lg-2 col-md-2 col-sm-6 col-xs-12" for="unitCode">
									<spring:message code="tmProductUnits.unitCode" text="产品组件编码" />
									:
								</label>
								<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="unitCode"  data-rule-required="true" data-rule-maxlength="20" />
								</div>
								<label class="control-label col-lg-2 col-md-2 col-sm-6 col-xs-12" for="unitIndex">
									<spring:message code="tmProductUnits.unitIndex" text="产品组件序号" />
									:
								</label>
								<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="unitIndex"  data-rule-required="true" data-rule-maxlength="2" data-rule-digits="true" data-rule-max="10" data-rule-min="0" />
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
								<table id="tmProductUnits_datatable" class="datatable table table-hover table-striped table-bordered">
								</table>
							</div>
						</div>
					</div>
					<!-- x_content -->
				</div>
				<!-- x_panel-->
			</div>
			<!-- col-12 -->
		</div>
	</div>
	<!-- 引入js -->
	<%@ include file="/common/foot.jsp"%>
	<!-- 权限单元-控制js变量 -->
	<!-- <k:access code="productUnits_add" var="addUrl"/> -->
	<k:access code="productUnits_edit" var="editUrl"/>
	<k:access code="productUnits_delete" var="delUrl"/>
	<!-- 创建datatable表格 -->
	<script type="text/javascript">
		var type;
		var pkNames = [];
		var columns = [];
		pkNames.push("id");
	/* 	columns.push({ title: '<spring:message code="tmProductUnits.productgroupCode" text="产品分组" />', data: 'groupCode',
		render : function(data,type,row,meta){
			return ${groupCodeName}[data];
			}
		}); */
	/* 	columns.push({ title: '<spring:message code="tmProductUnits.unitCode" text="产品组件编码" />', data: 'unitCode'}); */
		if("${pageContext.response.locale}"=="zh_CN"){
			columns.push({ title: '<spring:message code="tmProductUnits.unitNameCn" text="产品组件名称" />', data: 'unitNameCn'});
		}else{
		columns.push({ title: '<spring:message code="tmProductUnits.unitName" text="产品组件名称" />', data: 'unitName'});	
			}
		columns.push({ title: '<spring:message code="tmProductUnits.unitIndex" text="产品组件序号" />', data: 'unitIndex'});
		var grid = $("#tmProductUnits_datatable").grid({
			datatable : {
	          	ajax: {
	  				url: "${ctx}/productUnits/queryProductUnitsList.in",
	  				method: "post",
	  				data: function(d) {
						d.groupCode = $("#groupCode").val();
						d.unitCode = $("#unitCode").val();
						d.unitIndex = $("#unitIndex").val();
						d.type=type;
	  				}
	  			},
	  			columns: columns
			},
			delay: true,
			//addUrl:addUrl,//新增页面url
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
			$K.frame.loadPage("${ctx}/productUnits/productUnitsDetailPage.in?" + params.join("&"), grid);
		}
		grid.dbClick(dbclick);
	</script>
	<script type="text/javascript">
		var languge="nameCn";
		if("${pageContext.response.locale}"=="zh_CN"){
			languge="nameCn";
			unitName="unitNameCn"
		}else{
			languge="name"; 
		}
		var id , productType,isParent,groupCode="";
		//左侧菜单
		var productTree="", setting = {
			data : {
				simpleData : {
					enable : true,
					idKey : "id",
					pIdKey : "pid",
					rootPId : null
				},
				key : {
					name : languge
				}
			},
			view : {
				showIcon : true,
				showTitle : true,
				showLine: false
			},
			check : {
				enable : false,
				chkStyle : "checkbox",
				chkboxType : {
					"Y" : "ps",
					"N" : "ps"
				}
			},
			callback : {
				onRightClick : zTreeOnRightClick,
				onClick: zTreeOnClick
			}
		};
		$(function() {
			loadLeftTree();
		})
		//加载树数据
		function loadLeftTree(){
			$K.ajax({
				url : "${ctx}/productUnits/loadProductTree.in",
				type : "POST",
				success : function(data) {
					productTree = $.fn.zTree.init($("#productTree"), setting, data);
					//展开树
					productTree.expandAll(true);
					//默认选中第一条
					var nodes=productTree.getNodes();
					if (nodes.length>0) {
						productTree.selectNode(nodes[0])
						zTreeOnClick(null,null,nodes[0]);
					}
				}
			});
		}
		//点击树节点
		function zTreeOnClick(event, treeId, treeNode){
			groupCode=treeNode.id;
			id=treeNode.keyId;
			productType=treeNode.id;
			isParent=treeNode.isParent;
			productKind=treeNode.productKind;
			if(treeNode.productKind=="type"){
				$("#showDetail").addClass("hide");
			}else{
				$("#showDetail").removeClass("hide");
			}
			$("#productGroupDetail").removeClass("hide");
			if(treeNode.productKind=="type"){
				type=treeNode.id;
			}else{
				type=treeNode.pid;
			}
	    	$K.ajax({
				url : "${ctx}/productUnits/loadProductGroupInfo.in",
				type : "POST",
				data:{id:treeNode.keyId},
				success : function(data) {
					$("#groupCode1").text(data.groupCode); 
					$("#groupCode").val(data.groupCode);
					 $(".grid-search").trigger('click');
					if(languge=='nameCn'){
						$("#groupName").text(data.groupNameCn); 
					}else{
						$("#groupName").text(data.groupName); 
					}
			    	$("#groupIndex").text(data.groupIndex); 
				}
			});
		}
		grid.getTable().draw();
		var rMenu = $("#rMenu");
		var keyId,isParentNode;
		// 在ztree上的右击事件
		function zTreeOnRightClick(event, treeId, treeNode) {
			if(treeNode==null){
				return;
			}
			productTree.selectNode(treeNode);
			zTreeOnClick(event, treeId, treeNode);
			//根据选择不同的节点隐藏或者显示右键菜单中某些菜单
			productKind=treeNode.productKind;
			if("all"==productKind){
				// 如果是根节点，则无法进行右键功能
				noMenu();
			}else if("type"==productKind){
				// 如果是产品类节点，则需要判断是否有产品分组子节点，若没有可以直接删除的
				typeMenu();
			}else if("group"==productKind){
				// 如果为分组节点  可新增和修改分组 删除需要判断是否有组件
				groupMenu();
			}
			$K.ztree.showRMenu("node", event.clientX, event.clientY, rMenu);
		}
		//根节点右键菜单
		function noMenu(){
			$("#addGroup").hide();
			$("#updGroup").hide();
			$("#delGroup").hide();
		}
		//产品类右键菜单
		function typeMenu(){
			$("#addGroup").show();
			$("#updGroup").hide();
			$("#delGroup").hide();
		}
		//产品分组右键菜单
		function groupMenu(){
			$("#addGroup").hide();
			$("#updGroup").show();
			$("#delGroup").show();
		}
		//新增产品分组 
		function addGroup(){
			var selected = productTree.getSelectedNodes()[0];
			var affterClose="";
			// 弹窗
			$K.layerOpen({
				win: window,					// 必填
				content: ['${ctx}/productUnits/productGroupAddPage.in?productType='+productType, 'yes'],	// 必填
				type: 2,
				area: ['70%', '65%'],
				title: '<spring:message code="productUnits.addGroup" text="新增产品分组" />',
				btn: ['<spring:message code="kite.web.common.btnSure" text="确定" />', '<spring:message code="kite.web.common.btnBack" text="返回" />'],
				yes: function(index, layero) {
					affterClose="yes";
					layer.getChildFrame('#submit', index).click();
				},
				cancel: function(index, layero) {
					layer.close(index);
				},
				end: function() {
					if(affterClose=="yes"){
					loadLeftTree();
					}
				}
			});
		}
		//修改产品分组 
		function updGroup(){
			var affterClose="";
			// 弹窗
			$K.layerOpen({
				win: window,					// 必填
				content: ['${ctx}/productUnits/productGroupEditPage.in?id='+ id, 'yes'],	// 必填
				type: 2,
				area: ['70%', '65%'],
				title: '<spring:message code="productUnits.updGroup" text="修改产品分组" />',
				btn: ['<spring:message code="kite.web.common.btnSure" text="确定" />', '<spring:message code="kite.web.common.btnBack" text="返回" />'],
				yes: function(index, layero) {
					affterClose="yes";
					layer.getChildFrame('#submit', index).click();
				},
				cancel: function(index) {
					layer.close(index);
				},
				end: function() {
					if(affterClose=="yes"){
						loadLeftTree();
						}
				}
			});
		}
		//删除产品分组 
		function delGroup(){
			$K.ajax({
				url:"${ctx}/productUnits/checkInfo.in",
				data:{id:groupCode},
				type:"POST",
				success:function(data){
					if(data=="have"){
						layer.alert("<spring:message code='productUnits.beforeDeleteGroup' text="请先删除该产品分组下的组件"/>");	
						return;
					}
					$K.layerConfirm('<spring:message code='productUnits.sureDelete' text="确定删除?"/>', {icon: 3, title:'<spring:message code="kite.web.common.tip" text="提示" />'}, function(index){
							$K.ajax({
								url:"${ctx}/productUnits/delProductGroup.in",
								data:{id:id},
								type:"POST",
								success:function(data){
									layer.msg("<spring:message code='productUnits.afterDeleteGroup' text="删除产品分组成功"/>");	
									loadLeftTree();//刷新树
								}
							})
							layer.close(index);
						});
				}
			});	
		}
	</script>
	<k:access code="productUnits_add">
		<script type="text/javascript">
				var productUnitsAddBtn = $("<button class='btn btn-success' ><i class='fa fa-plus'></i> <spring:message code='kite.web.common.btnAdd' text='新增' /></button>");
				grid.addButton(productUnitsAddBtn, 1);
				productUnitsAddBtn.on('click', function() {
					if ($('#groupCode').val() != '' && $('#groupCode').val() != 'no_data_take_place') {
						$K.frame.loadPage('/productUnits/productUnitsAddPage.in?groupCode=' + $('#groupCode').val()+"&productType="+type, grid);
					} else {
						layer.msg('<spring:message code="productUnits.btn.beforeAddUnits" text="请先选择一个产品分组"/>');
					}
				});
	    </script>
	</k:access>
	</body>
</html>