<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html lang="en">
	<head>
	<meta charset="utf-8" />
	<title><spring:message text="" code="user.query.title" /></title>
	<!-- 引入css样式和部分js -->
	<%@ include file="/common/head.jsp"%>
	<link href="${ctx }/static/plugins/orgChart/css/bootstrap.css" rel="stylesheet">
    <link href="${ctx }/static/plugins/orgChart/css/font-awesome.min.css" rel="stylesheet">
    <%-- <link href="${ctx }/static/plugins/orgChart/css/animate.css" rel="stylesheet"> --%>
    <link href="${ctx }/static/plugins/orgChart/css/jquery.orgchart.css" rel="stylesheet">
    <link href="${ctx }/static/css/productunit/productunit.css" rel="stylesheet">
	<style type="text/css">
		#contextDiv {
	            width:100px;
	            height: 25px;
	            overflow: auto;
	            white-space: nowrap;
	        }
	        .lable {
	            width: 30px;
	            display: inline-block;
	        }
	</style>

	</head>
	
	<body class="${param.skin}">
		<!-- 整体皮肤样式 -->
		<!-- <div class="container">  这个地方如果使用container 默认使用的是bootstrap 的-->
				<div align="left" style="width: 20%; float: left;">
					<ul id="productTree" class="ztree box-border" style="width: 230px; overflow: auto;"></ul>
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
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 box-border" style="width: 80%;height:100%; float: left;">
					 
					<!-- 产品模板定义 -->		
 							  
						    <div class="animated fadeInRight">  
						   		 <button type="button" class="btn "  id="saveUnits">保存</button>
						        <div id="chart-container" class="view-state"></div>
						    </div>	
						
						<!-- orgchart 的功能菜单 -->
						<!-- <div id="contextDiv" class="list-group">
						  <a href="#" id="add-node" class="list-group-item">新增组件</a>
						  <a href="#" id="change-props" class="list-group-item">修改组件</a>
						  <a href="#" id="delete-node" class="list-group-item">删除组件</a>
						</div>    --> 
						 <div id="contextDiv"  class="list-group">
					        <div class="lable" id="add-node">
					            <img alt="新增组件" title="新增组件" src="${ctx }/img/add.png" style="height: 20px;width: 20px;">
					        </div>
					        <div class="lable" id="change-props">
					            <img alt="修改组件" title="修改组件" src="${ctx }/img/update.png" style="height: 20px;width: 20px;">
					        </div>
					        <div class="lable" id="delete-node">
					            <img alt="删除组件" title="删除组件" src="${ctx }/img/delete.png" style="height: 20px;width: 20px;">
					        </div>
					    </div>   
						    	
				</div>
				<!-- col-12 -->
		<!-- </div> -->
		
		
		
		
		<!--正常情况下隐藏-->
<div id="myModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title">修改</h4>
        </div>
        <div class="modal-body">
            <form>
				<!-- 应该一个options 供选择 -->
				<div>
				<label for="unitCode">请选择组件:</label>
					<select id="unitchoose" name="unitCode"  class="form-control" data-live-search="true">
						 <option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
						 <c:forEach items="${unitOptions }" var="item" varStatus="index">
						 	<option value="${item.key }">${item.value }</option>
						 </c:forEach>
					</select>
				</div>
				<div class="unitIndex" style='display:none'>
					<label for="unitIndex" >请输入组件序号(序号越小越靠前)</label>
					<input type="number" name="unitIndex" class="form-control" />
				</div>
            </form>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            <button type="button" class="btn btn-default"  id="savechange">保存</button>
        </div>
        </div>
    </div>
</div>
	</body>
		
 	 <script src="${ctx }/static/plugins/orgChart/js/jquery.js"></script> 
    <script src="${ctx }/static/plugins/orgChart/js/html2canvas.js"></script>
    <script src="${ctx }/static/plugins/orgChart/js/jquery.orgchart2.js"></script>
    <script src="${ctx }/static/js/productunit/productunit.js"></script>
		  <!-- 这里的foot.jsp 一定要在后面写，不然出不来效果 -->
	<%@ include file="/common/foot.jsp"%>
	<script type="text/javascript">
		var languge = "groupName";
		if ("${lang_current}" === "${lang_zh_CN}") {
			languge="name";
		}
		//左侧菜单
		var productTree,
			setting = {
			data : {
				simpleData : {
					enable : true,
					idKey : "id", //节点id
					pIdKey : "productParentId", //父节点
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
				onClick: zTreeOnClick,
				onRightClick : zTreeOnRightClick
			}
		};
		$(function() {
			$K.units=JSON.parse('${units}')
		
			
			loadLeftTree();
		})
		//加载左侧树节点
		function loadLeftTree() {
			$K.ajax({
				url : "${ctx}/productUnit/loadProductTree.in",
					type : "POST",
					success : function(data) {
						productTree = $.fn.zTree.init($("#productTree"), setting, data);
						//默认选中第一条
						var nodes=productTree.getNodes();
						if (nodes.length>0) {
							productTree.selectNode(nodes[0])
							//zTreeOnClick(null,null,nodes[0]);
							//展开树
							productTree.expandNode(nodes[0],true,true,true,true);
							
							productTree.expandAll(true);
							
							var nodes = productTree.getNodes();
							if (nodes.length > 0) {
								productTree.selectNode(nodes[0])
								zTreeOnClick(null, null, nodes[0]);
							}
						}
					}
				});
			// 展开树
			//productTree.expandAll(true);
			//默认选中第一条
			
		}

		
		
	/* 	grid.getTable().draw(); */
		var rMenu = $("#rMenu");
		var keyId,isParentNode;
		function zTreeOnRightClick(event, treeId, treeNode) {
			if(treeNode==null){
				return;
			}
			productTree.selectNode(treeNode);
			zTreeOnClick(event, treeId, treeNode);
			//根据选择不同的节点隐藏或者显示右键菜单中某些菜单
			productKind=treeNode.productParentId;
			debugger
			if(null==productKind){
				// 如果是根节点，则无法进行右键功能
				addMenu();
			}else{
				allMenu();
			}
			/* else if("type"==productKind){
				// 如果是产品类节点，则需要判断是否有产品分组子节点，若没有可以直接删除的
				typeMenu();
			}else if("group"==productKind){
				// 如果为分组节点  可新增和修改分组 删除需要判断是否有组件
				groupMenu();
			} */
			$K.ztree.showRMenu("node", event.clientX, event.clientY, rMenu);
		}
		
		function allMenu(){
			$("#addGroup").show();
			$("#updGroup").show();
			$("#delGroup").show();
		}
		
		//根节点右键菜单
		function addMenu(){
			$("#addGroup").show();
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
				content: ['${ctx}/productUnits/productGroupAddPage.in?id='+selected.id+'&productType='+selected.productType, 'yes'],	// 必填
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
				content: ['${ctx}/productUnits/productGroupEditPage.in?id='+ productId, 'yes'],	// 必填
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
				data:{id:productId},
				type:"POST",
				success:function(data){
					if(data=="have"){
						layer.alert("<spring:message code='productUnits.beforeDeleteGroup' text="请先删除该产品分组下的组件"/>");	
						return;
					}
					$K.layerConfirm('<spring:message code='productUnits.sureDelete' text="确定删除?"/>', {icon: 3, title:'<spring:message code="kite.web.common.tip" text="提示" />'}, function(index){
							$K.ajax({
								url:"${ctx}/productUnits/delProductGroup.in",
								data:{id:productId},
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
		
		
		
		
		
	//  -----------------------------------ztree 和orgchart 的联动效果
		  //1.点击左边树节点，右边的产品树跟着变化
		function zTreeOnClick(event, treeId, treeNode) {
			//debugger
			productId = treeNode.id;
			/* grid.datatable.ajax.reload(null, true); */
			//重新加载树
			//treeNode{keyId: null, id: "A", pid: null, name: "A", nameCn: "传统贷款产品", …}
			resetOrgTree(treeNode);
		}

	</script>

	
</html>