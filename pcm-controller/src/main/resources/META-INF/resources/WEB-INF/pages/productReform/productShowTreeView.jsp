<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp" %>
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	    <title><spring:message code='product.productShow' text='产品展示' /></title>
	    <!-- 引入css样式和部分js -->
	    <%@ include file="/common/head.jsp" %>
	    <link type="text/css" rel="stylesheet" href="${ctxStatic}/plugins/circle.web/css/circle.css" />
	    <link href="${ctx }/static/css/productshowTree.css"  rel="stylesheet"/>
	   <link href="${ctx }/static/plugins/orgChart/css/bootstrap.css" rel="stylesheet">
    <link href="${ctx }/static/plugins/orgChart/css/font-awesome.min.css" rel="stylesheet">
    <%-- <link href="${ctx }/static/plugins/orgChart/css/animate.css" rel="stylesheet"> --%>
    <link href="${ctx }/static/plugins/orgChart/css/jquery.orgchart.css" rel="stylesheet">
    
	    <style type="text/css">
	    	.unitParamId {
	    		display: none
	    	}
	    	.unitCode{
	    		display: none
	    	}
	    	.nodeDBId{
	    	display: none
	    	}
	    	.content{
	    		height: auto !important;
	    		border-radius: 0px 0px 0px 0px !important;
	    		overflow: auto !important;
	    		text-overflow: clip !important;
	    		text-align:left !important;
	    		/*  text-align: left !important */;
	    	}
			.orgchart.l2r .node{
				 width: 100px !important;
    			 height: 130px !important;
			}
			.orgchart{
				cursor:pointer
			}
			#contextDiv {
	            width:135px;
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
	
	<!-- 整体皮肤样式 -->
	<body class="${param.skin}">
		<!-- 树状图展示 -->
		    <div id="listGroupManage" >
		    	<div class="animated fadeInRight">  
		        <div id="chart-container" class="view-state"></div>
		    </div>
		    <div id="contextDiv"  class="list-group">
		        <div class="lable" id="add-unit">
		            <img alt="新增组件" title="新增组件" src="${ctx }/img/add.png" style="height: 20px;width: 20px;">
		        </div>
		        <div class="lable" id="edit-unit">
		            <img alt="修改组件" title="修改组件" src="${ctx }/img/update.png" style="height: 20px;width: 20px;">
		        </div>
		        <div class="lable" id="del-unit">
		            <img alt="删除组件" title="删除组件" src="${ctx }/img/delete.png" style="height: 20px;width: 20px;">
		        </div>
		        <div class="lable" id="detail-unit">
		            <img alt="组件详情" title="组件详情" src="${ctx }/img/edit.png" style="height: 20px;width: 20px;">
		        </div>
		    </div>
		    <!-- <div id="contextDiv" class="list-group">
		      <a href="#" id="add-unit" class="list-group-item">新增组件</a>
		       <a href="#" id="edit-unit" class="list-group-item">修改组件</a>
		       <a href="#" id="del-unit" class="list-group-item">删除组件</a>
			  <a href="#" id="detail-unit" class="list-group-item">组件详情</a>
			</div> -->
			
			
		<div id="config_select_area" class="layer-page-panel form-group" style="height: auto;">
			<div style="text-align: center;width: 60%;margin-left: 20%;">
					<div class="form-group row">
						<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
							组件名称
						</label>
						<div class="col-lg-10 col-md-4 col-sm-4 col-xs-4">
							<select id="unit_select" name="unit_name"  class="form-control" data-live-search="true" ></select>
						</div>
					
				</div>
				<div class="form-group row">
						<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
							组件值
						</label>
						<div class="col-lg-10 col-md-4 col-sm-4 col-xs-4">
							<select id="config_select" name="unit_key" class="form-control" data-live-search="true"></select>
						</div>
			   </div>
			   
			</div>	
		</div>
		
		
		<div id="edit_area" class="layer-page-panel form-group" style="height: auto;">
			<div style="text-align: center;width: 60%;margin-left: 20%;">
			 <div class="form-group row">
					<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
						组件值
					</label>
					<div class="col-lg-10 col-md-4 col-sm-4 col-xs-4">
						<select id="paramkeySelect" name="unit_key" class="form-control" data-live-search="true"></select>
					</div>
			   </div>
			   </div>
		</div>
		
		
	</body>
	
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp" %>
	<%-- <script src="${ctx }/static/plugins/orgChart/js/jquery.js"></script>  --%>
    <script src="${ctx }/static/plugins/orgChart/js/html2canvas.js"></script>
    <script src="${ctx }/static/plugins/orgChart/js/jquery.orgchart2.js"></script>
	<script type="text/javascript">
	'use strict';

	  var getdatasource = function(){

	    //调用后台接口获得数据
	    return {
	      'name': 'Ball game',
	      'content': 'general manager',
	      'children':[
	        {
	          'name': 'Ball game',
	          'content': 'general manager',
	        },{
	          'name': 'Ball game',
	          'content': 'general manager',
	        }
	      ]
	    }
	  };

	//获取id
	  var getId = function() {
	    return (new Date().getTime()) * 1000 + Math.floor(Math.random() * 1001);
	  };

	  var getdata = function(){
	    if($('#chart-container').find('.node:first').length===0) return '';
	    var hierarchy = $('#chart-container').orgchart('getHierarchy');
	    if(hierarchy) {return hierarchy;}
	    return '';
	  }


	//渲染组织树
	  var renderpic = function(datascource){
	    $('#chart-container').empty();//渲染之前先全部清空
	    $('#chart-container').orgchart({
	      'data' : datascource,
	      'parentNodeSymbol': '',
	     /*  'parentDesc': "parentDesc",   */
	      'nodeTitle': 'unitNameCn',
	      'direction': 'l2r',
	     'pan': false, 
	     'draggable': false, //禁止拖拽
	      'createNode': function($node, data) {//节点创建完毕之后往上加
	         //创建节点的时候可以一些事情
	        $node[0].id = getId();
	      
	        if(typeof(data.paramKey)!="undefined"){
	        	
	    	  $node.append('<div class="unitParamId">'+data.paramKey+'</div>'); 
	        	$node.append('<div class="unitCode">'+data.unitCode+'</div>');
	           	 	
	        	$node.append('<div class="nodeDBId">'+data.id+'</div>')
	        }else{
	        	//父节点
				
	        	$node.append('<div class="unitParamId">'+data.value+'</div>');
	        	
	     		var html = '<div class="content">' ;
	     		html+='产品代码：'+data.value+'<br>';
	     		html+='bin：'+data.bin+'<br>';
	     		html+='货币代码：'+data.currency+'<br>';
	        	$node.append(html);
				
	        }
	        

	 	     
	       /*  $node.mouseover(function(){
	        	$node.children('.second-menu').toggle()
	        })
	         $node.mouseout(function(){
	        	 $node.children('.second-menu').toggle()
	         }) */
	         if(typeof(data.unitCode)=='undefined'){
	        	 return
	         }
	       
	         var unitClass = $K.infos[data.unitCode].unitClass
	         //加载简略信息
	        $K.ajax({
				url: '${ctx}/paramCommon/getParamBaseInfo.in',// isUpdate是标记为数据更新
				type: 'POST',
				datType: 'json',
				async: false,
				data: {'code':data.paramKey,'paramClass':unitClass},
				success: function(val) {
					var html = '<div class="content">';
					$.each(val,function(index,value){
						html+=''+index+'：'+value+'<br>'
					});
					html+='</div>';
					$node.append(html);
			 	     
				},
			}); 
	 	    

	        
	        
	      },
/* 	      'draggable': true,
	      'dropCriteria': function($draggedNode, $dragZone, $dropZone) {
	        if($draggedNode.find('.content').text().indexOf('manager') > -1 && $dropZone.find('.content').text().indexOf('engineer') > -1) {
	          return false;
	        }
	        return true;
	      } */
	    })
	    .on('mouseover','.node',function(ev){
	    let nodeWidth =  $(this).css('width').split('p')[0];
	    let top =   $(this).offset().top;
	    let left = 	$(this).offset().left+parseInt(nodeWidth);
	      var oEvent= ev||event;
	      var oUl=document.getElementById("contextDiv");
	      oUl.style.display="block";
	      oUl.style.left=left+'px';//oEvent.clientX
	      oUl.style.top=top+'px';
	      clicknode = $(this)[0].id
	      // clicknode = $(this)
	      return false;
	    })
	    /* .children('.orgchart').on('nodedropped.orgchart', function(event) {
	      console.log('draggedNode:' + event.draggedNode.children('.title').text()
	        + ', dragZone:' + event.dragZone.children('.title').text()
	        + ', dropZone:' + event.dropZone.children('.title').text()
	      );
	    }) */
	    
	  }
	
	
	
	

	  var disnone = function(){
	    var oUl=document.getElementById("contextDiv");
	    oUl.style.display="none";
	  }

	  var erg = function(obj,id){
	    var fobj
	    findobj(obj,id)
	    function findobj(obj,id){
	      if(Object.prototype.toString.call(obj)==="[object Object]"){
	        if(obj.id === id){
	          fobj= obj;
	        }else if(obj.children){
	          findobj(obj.children,id);
	        }
	      }else{
	        for(var i in obj){
	          findobj(obj[i],id);
	        }
	      }
	    }
	    return fobj;
	  }

	  // 以上事封装的方法，下面是具体执行的顺序
	  // 设置一些常用量
	  var data = getdatasource()
	  var clicknode = '';
	  

	 

	  $('body').on('click',disnone)
	  
	  

	 

	  $('#godetail').on('cilck',function(){console.log(top.ifame5)});

	  $('#detail-unit').on('click',function(){
	    	disnone()
	    	  var $node = $("#"+clicknode)
	    	//判断是否为树节点，产品节点
	    	 if ($node[0] === $('.orgchart').find('.node:first')[0]) {
	    		 //获取产品编号
	    		 var productCode  = $node.children('.unitParamId').first().html();
	    		 showProductDetails(productCode);
	    	 }else{
		    	//获取到正在点击的节点
		    	var unitParamId  = $node.children('.unitParamId').first().html();
		    	var unitCode  = $node.children('.unitCode').first().html();
		    	//查询
		    	//请求后台获取详情页面
		    	showDetails($K.infos[unitCode].unitDetailUrl,unitParamId);
	    	 }
	  })

	  /**
	  	展示产品基本信息
	 **/
	 function showProductDetails(productCode){
			var width='1129px';
			var height='558px';
		  $K.layerOpen({
				win: window,
				type: 2,
				btn: [],
				area: [width, height],
				maxmin: true,
				title: (lang_current === lang_zh_CN ? '产品详情' : 'Product info'),
				content: "${ctx}/productReform/productDetailPage.in?productCode="+productCode,
			}); 
	  }
	  
	  
	  /**
	  	展示详情页面
	 	*/
	 	
	  function showDetails(unitDetailUrl,unitParamId){
		//默认中屏
			var width='1129px';
			var height='558px';
		  $K.layerOpen({
				win: window,
				type: 2,
				btn: [],
				area: [width, height],
				maxmin: true,
				title: (lang_current === lang_zh_CN ? '组件详情' : 'Unit info'),
				content: "${ctx}"+unitDetailUrl+"?code="+unitParamId,
			});
	  }
	  
	  
	  
	  $(function(){
		var index = layer.load(1);
		  //1.拿到数据
		  var product = ${product}
		  //把product code 变成 value
		  
		  var rels = ${rels}
		  var infos = ${infos}
		  $K.infos= infos ;
		  //2.重新组装数据结构
		 $.each(rels,function(i,val){
			 val['value']= val.unitCode;
			 val['unitNameCn']=infos[val.unitCode].unitNameCn;
		  })
		 var viewData =  editData(product,rels,infos);
		viewData.bin=product.bin;
		viewData.currency=product.currency;
		  //3.渲染页面
		  renderpic(viewData)
		  layer.close(index)
	  })
	  
	  function editData(product,rels,infos){
		   var viewData={};
		  viewData['value'] =  product.productCode;
		  viewData['unitNameCn']=product.description;
		  
		  var children = translateDataToTree(rels);

		  viewData['children'] = children ; 
		  
			return viewData ; 
		  
	  }
	  
	  /**
	   把 {'id':,'parentId':}形式转换为 {'id':,child:[]}的形式
	  */
	  function translateDataToTree(data) {
		  let parents = data.filter(value => value.parentId == 'undefined' || value.parentId == null)
		  let children = data.filter(value => value.parentId !== 'undefined' && value.parentId != null)
		  let translator = (parents, children) => {
		    parents.forEach((parent) => {
		      children.forEach((current, index) => {
		        if (current.parentId === parent.id) {
		          let temp = JSON.parse(JSON.stringify(children))
		          temp.splice(index, 1)
		          translator([current], temp)
		          typeof parent.children !== 'undefined' ? parent.children.push(current) : parent.children = [current]
		        }
		      }
		      )
		    }
		    )
		  }
		  translator(parents, children)
		  return parents
		}
	   
	   
	   //删除
	   $("#del-unit").on('click',function(){
		   var $node = $('#' + clicknode)
		    //获取productCode
		    var productCode  = $($('.node')[0]).children('.unitParamId').text();
		    var paramKey = $node.children('.unitParamId').text()
		    var parentId = $node.attr('data-parent');
		    //发送ajax ，删除节点
	        $K.ajax({
				url: '${ctx}/productReform/delUnitRel.in',// isUpdate是标记为数据更新
				type: 'GET',
				dataType: 'text',
				data: {'productCode':productCode,'unitParamKey':paramKey,'parentId':parentId},
				success: function(val) {
					 if ($node[0] === $('.orgchart').find('.node:first')[0]) {
					    	layer.msg('不能删除根节点,删除失败!')
					      return getdata();
					    }
					    $('#chart-container').orgchart('removeNodes', $node)
					    $('#selected-node').val('').data('node', null)
					layer.msg("删除成功...")			 	     
				},
			}); 
		    
	   }) 
	   
	   
	   /**
	    * 根据unitcode 找到对应的unitObj
	    */
	   function getUnitUrl(unitCode){
	 	  var obj = $K.infos[unitCode];
	 	  return obj ; 
	   }
	   
	   $("#add-unit").on('click',function(){
			let isRoot =false ; //是否是在根节点上添加
			 //0.获取获取configurl
			var $node = $("#"+clicknode);
			if ($node[0] === $('.orgchart').find('.node:first')[0]) {
		     	isRoot=true;
		    }
					//填充关联组件
					var configArea = $('#config_select_area');
					var  $config_select =$('#config_select');
					//初始化选择组件下拉框
					var $unit_select = $('#unit_select');
				// 下拉构建
				$config_select.empty().append('<option value> -- please choose -- </option>');
				$unit_select.empty().append('<option value> -- please choose -- </option>');
				
			 	$K.ajax({
			 		async: false,
			 		url: '${ctx}/productReform/getAddunits.in',
			 		type: 'get',
			 		data:{
			 			'productId': $($('.orgchart').find('.node:first')[0]).children('.unitParamId').text(),
			 			'parentUnitCode': $node.children(".unitCode").text(),
			 			'isRoot': isRoot
			 		},
			 		dataType: 'json',
			 		success: function(data){
			 			$.each(data,function(index,code){
							$unit_select.append('<option value="' + code + '">' + ($K.infos[code].unitNameCn || code) + '</option>')
			 			})
			 		}
			 	})  
				
				
				$unit_select.data('size', '6').selectpicker('refresh');
			 /* 	 $config_select.data('size', '6').selectpicker('refresh');  */
				// 弹窗选择
					$K.layerOpen({
						win: window,
						type: 1,
						title: (lang_current === lang_zh_CN ? '组件选择' : 'Unit Select'),
						content: configArea,
						btn: [$K.msg.text($K.msg.common.confirm, '确定'), $K.msg.text($K.msg.common.cancel, '取消')],
						yes: function(index, layero) {
							//验证参数
							var paramKey = top.$("#config_select").val().trim();
							var unitCode = top.$('#unit_select').val().trim();
							
							if(paramKey=='' || unitCode==''){
								layer.msg("请完善表单数据!")
								return 
							}
							//保存关联
							var parentUnitCode = $('#'+clicknode).children(".unitCode").text();
							var parentParamKey = $('#'+clicknode).children(".unitParamId").text();
							
							var productCode = $($('.node')[0]).children('.unitParamId').text();
							var parentId =$('#'+clicknode).children(".nodeDBId").text();
							 $K.ajax({
								url: '${ctx}/productReform/addUnitRel.in',
								dataType: 'json',
								data: {
									'productCode':productCode,
									'paramKey':paramKey,
									'unitCode': unitCode,
									'parentUnitCode':parentUnitCode,
									'parentParamKey': parentParamKey,
									 'parentId': parentId,
								     'root': isRoot
									},
								success: function(newNodeId){
									//关闭窗口
									 disnone();
									//获取节点名称
									var name = $K.infos[top.$('#unit_select').val().trim()].unitNameCn;
									addnode(name, newNodeId, clicknode,top.$("#config_select").val().trim(),top.$('#unit_select').val().trim())//此处先用getId()代替
									layer.msg('保存成功。。')
									//把select
									layer.close(index);
								}
							}) 
							
				
							
						},
						success: function(layero, index) {
							top.$(layero).find('#unit_select').on('change.product',{infos:$K.infos},function(event){
								 var $config_select = top.$("#config_select");
								 var $unit_select = top.$('#unit_select');
								 
								   let unitCode = $unit_select.val();
								   ////////////////
								   
								  let  unitClass= event.data.infos[unitCode].unitClass;
								  
								   //发送请求
								   $K.ajax({
									  async: false,
									  url: '${ctx}'+'/paramCommon/getParamCollection.in',
									  type: 'post',
									  data: {'paramClass':unitClass},
									  dataType: 'json',
									  success: function(data){
											//重新初始化表单 
										  $config_select.empty().append('<option value> -- please choose -- </option>');
										  $.each(data,function(key,val){
											  $config_select.append('<option value="' + key + '">' +  val+ '</option>')
										  })
										 $config_select.data('size',6).selectpicker('refresh');
										  
									  }
								   })
								  
							});				
						},
						end: function() {
							$('div#config_select_area').off('change.product');
							 
						}
					});
				//}
		//	});	
			   
	   })
	   
	   
	   
	   
	/**
   * 添加节点
   */
   var addnode = function( name , cid , pid,unitParamId,unitCode){
	    var $chartContainer = $('#chart-container')
	    var nodeVals = []
	    var obj = {name: '',content: ''}
	    obj.name = name ? name : ''
	    obj.id = cid ? cid : ''
	    nodeVals.push(obj)
	    if (pid)var $node = $('#' + pid);     
	    var hasChild = $node.parent().attr('colspan') > 0 ? true : false
	    if (!hasChild) {
	      var rel = nodeVals.length > 1 ? '110' : '100'
	      $chartContainer.orgchart('addChildren', $node, {
	        'children': nodeVals.map(function (item) {
	        	
	          return { 'unitNameCn': item.name,  'relationship': rel, 'id': item.id,'paramKey':unitParamId,'unitCode':unitCode,'children':[],'parentId':$node.children('.nodeDBId').text()}
	        })
	      }, $.extend({}, $chartContainer.find('.orgchart').data('options'), { depth: 0 }))
	    } else {
	    	layer.load(1);
	    	location.reload();
	     /*  $chartContainer.orgchart('addSiblings', $node.closest('tr').siblings('.nodes').find('.node:first'),
	        { 'siblings': nodeVals.map(function (item) {
	        	
	        	return { 'unitNameCn': item.name,'paramKey':unitParamId, 'unitCode':unitCode, 'relationship': '110', 'id': item.id,'children':[]}; })
	        }) */
	    }
	   }
		 
	   
	   
		   
		   
		   
		   $('#edit-unit').on('click',function(){

			   //获取点击节点
			   var $node = $('#'+clicknode);
				 if ($node[0] === $('.orgchart').find('.node:first')[0]) {
				    	layer.msg('请在列表页面进行修改。')
				      return getdata();
				    }
			   //获取对应的unitCode 
			   var unitCode = getunitCode($node);
			   //根据unitCode查找对应的url
			   var paramClass = getParamClass(unitCode);
			   //发送ajax 得到列表数据
			   var arr = getArrData(paramClass);
			   //取出当前选中的数据
			   var selectNode = $node.children('.unitParamId').text().trim();
			   //初始化select
			   initSelectpicker($('#paramkeySelect'),arr,selectNode);
			  //打开窗口，创建select
			  $K.layerOpen({
					win: window,
					type: 1,
					title: (lang_current === lang_zh_CN ? '组件选择' : 'Unit Select'),
					content: $('#edit_area'),
					btn: [$K.msg.text($K.msg.common.confirm, '确定'), $K.msg.text($K.msg.common.cancel, '取消')],
					yes: function(index, layero) {
						  //确定更新数据库数据
						  if (updateDBrel($('#'+clicknode).children('.nodeDBId').text(),top.$('#paramkeySelect').val().trim())){
							  var paramClass =  $K.infos[$('#'+clicknode).children('.unitCode').text()].paramClass; 
							 var code = top.$('#paramkeySelect').val().trim();
							 $.ajax({
								 url: '${ctx}/paramCommon/getParamCollection.in',
								 type: 'POST',
								 data: {'paramClass':code },
								 async: false,
								 dataType: 'json',
								success: function(data){
									//更改unitParamId
									$('#'+clicknode).children('.unitParamId').text(top.$('#paramkeySelect').val().trim())
								    //更新baseinfo
								   $('#'+clicknode).children('.content').remove();
								   //重新的去加载一遍信息
								     var unitClass = $K.infos[$('#'+clicknode).children('.unitCode').text()].unitClass
						         //加载简略信息
							        $K.ajax({
										url: '${ctx}/paramCommon/getParamBaseInfo.in',// isUpdate是标记为数据更新
										type: 'POST',
										datType: 'json',
										async: false,
										data: {'code':top.$('#paramkeySelect').val().trim(),'paramClass':unitClass},
										success: function(val) {
											var html = '<div class="content">';
											$.each(val,function(index,value){
												html+=''+index+':'+value+'<br>'
											});
											html+='</div>';
											$('#'+clicknode).append(html);
									 	     
										},
									}); 
								   layer.msg('修改成功。。。。。')
								 }
							 })
						  }
						  
						  layer.close(index)
					},
					success: function(){
						
					},
					end:function(){
						
					}
			  })
			
		   })
		   
		   /**
		   	更新后台数据库中的关联信息
		   	id 数据库中额主键
		   	paramKey 参数主键
		   */
		   function updateDBrel(id,paramKey){
			   var flag = false ; 
			   $K.ajax({
				   url: '${ctx}/productReform/updUnitRel.in',
				   async: false,
				   dataType: 'text',
				   data: {'id':id,'paramKey':paramKey},
				   success: function(){
					   flag=true;
				   }
			   })
			   return flag; 
		   }
		   
		   function initSelectpicker($node,arr,selectNode){
			   $('#paramkeySelect').empty()
			   $('dropdown-menu').empty()
				  $.each(arr,function(key,val){
					  $node.append('<option value="' + key + '">' +  val+ '</option>')
				  })
				  $node.selectpicker('val',selectNode);
				  $node.data('size',6).selectpicker('refresh');
				  
		   }

		   function getunitCode($node){
			  return  $node.children('.unitCode').text();
		   }

		   function getUnitConfigUrl(unitCode){
			   return $K.infos[unitCode].unitConfigUrl
		   }
		   
		   function getParamClass(unitCode){
				return $K.infos[unitCode].unitClass;	   
		   }
		   
		   function getArrData(paramClass){
				var arr = [] ; 			   
			   $K.ajax({
				   url: '${ctx}/paramCommon/getParamCollection.in',
				   type:  'post',
				   async: false,
				   data: {'paramClass':paramClass},
				   success: function(data){
					   arr=data; 
				   }
			   })
			   return arr ; 
		   }
	</script>
</html>