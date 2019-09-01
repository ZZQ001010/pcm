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

  var getdata = function(index){
    if($('#chart-container'+index).find('.node:first').length===0) return '';
    var hierarchy = $('#chart-container'+index).orgchart('getHierarchy');
    if(hierarchy) {return hierarchy;}
    return '';
  }

 

//渲染组织树
  var renderpic = function(datascource,index){
    $("#chart-container"+index).empty();//渲染之前先全部清空
   $K['oc'+index]= $("#chart-container"+index).orgchart({
      'data' : datascource,
      'parentNodeSymbol': '',
			'exportButton': false,
			'exportFilename': 'MyOrgChart',
      'nodeContent': "value",
      'nodeTitle': 'unitNameCn', 
      'direction': 'l2r',
      'createNode': function($node, data) {
        $node[0].id = getId();
        	//如果是修改在初始化的时候把unitParamId 直接节点上
        $node.find("div.content").empty()
        $node.find("div.content").append('<p style="color: #999">请选择组件...</p>');
        if($.isUpdate){
        	//填充数据
	        if(typeof(data.paramKey)!="undefined"){
		    	  $node.append('<div class="unitParamId">'+data.paramKey+'</div>'); 
		    	  var unitClass = $K.infos[data.value].unitClass
			         //加载简略信息
			        $K.ajax({
						url: ctx+'/paramCommon/getParamBaseInfo.in',// isUpdate是标记为数据更新
						type: 'POST',
						datType: 'json',
						async: false,
						data: {'code':data.paramKey,'paramClass':unitClass},
						success: function(val) {
							var html = '';
							$.each(val,function(index,value){
								html+=''+index+'：'+value+'<br>'
							});
							html+='';
							$node.find("div.content").empty()
							$node.find("div.content").append(html);
					 	     
						},
					}); 
		    	  
		    	  
		    }
        }
        $node.append('<div class="unitCode">'+data.value+'</div>'); 
      },
    })
    .on('mouseover','.node',function(ev){
	    let top =   $(this).offset().top-20;
	    let left = 	$(this).offset().left-50;
      var oEvent= ev||event;
      var oUl=document.getElementById("contextDiv"+index);
      oUl.style.display="block";
      oUl.style.left=left+'px';//oEvent.clientX
      oUl.style.top=top+'px';
/*      var ratio =parseInt(document.body.clientWidth)*0.12
      oUl.style.left=(oEvent.clientX-ratio)+'px';
      oUl.style.top=(oEvent.clientY)+'px';
      console.info("document.body.clientWidth:"+document.body.clientWidth+"   document.body.clientHeight:"+document.body.clientHeight)
      console.info("此次右击事件发生在:x"+oEvent.clientX+"y"+oEvent.clientY)*/
      clicknode = $(this)[0].id
      // clicknode = $(this)
      return false;
    })
    .children('.orgchart').on('nodedropped.orgchart', function(event) {
      console.log('draggedNode:' + event.draggedNode.children('.title').text()
        + ', dragZone:' + event.dragZone.children('.title').text()
        + ', dropZone:' + event.dropZone.children('.title').text()
      );
    })
    
  }


  // 以上事封装的方法，下面是具体执行的顺序
  // 设置一些常用量
  var data = getdata()
  var clicknode = '';
  
  
  function initEvent(stepIndex){
	  //初始化修改按钮点击事件
	  initEditBtn(stepIndex);
	  //初始化详情按钮点击事件
	  initDetails(stepIndex);
	  //初始化点击body事件
	  initClickBody(stepIndex);
  }
  
  function initClickBody(stepIndex){
	  console.info(stepIndex)
	  $('body').click(function(){
		  disnone(stepIndex)
	  })
  }
  

  
  function initEditBtn(stepIndex){
	  $("#select-item"+stepIndex).click(function(){
		    //获取当前选中的
		 var unitCode =  getUnitCode(clicknode);
		 //发送ajax 获取数据
		 getunitParamsaOptions(unitCode); 
	  })
  }
  
  /**
   * 获取组件参数
   */
  function getunitParamsaOptions( unitCode){
	  var unitObj = getUnitUrl(unitCode);
		$K.ajax({
			async: false,//必须为同步
			url:ctx+"/paramCommon/getParamCollection.in",
			type:"POST",
			data:{
				'paramClass': unitObj.unitClass
			},
			success:function(map){
				//如果节点有值实现默认勾选
				var selectNode= '';
				if($('#'+clicknode).children().is('.unitParamId')){
					 selectNode  = $("#"+clicknode).find("div.unitParamId").html();
				}
				//填充关联组件
				var configArea = $('#config_select_area'),
				select = configArea.find('#config_select');
			// 下拉构建
			select.empty().append('<option value> -- please choose -- </option>');
			for (var code in map) {
				select.append('<option value="' + code + '">' + (map[code] || code) + '</option>');
			}
			select.data('size', '6').selectpicker('val', selectNode).selectpicker('refresh');
			// 弹窗选择
			$K.layerOpen({
				win: window,
				type: 1,
				title: (lang_current === lang_zh_CN ? '组件选择' : 'Unit Select'),
				content: configArea,
				btn: [$K.msg.text($K.msg.common.confirm, '确定'), $K.msg.text($K.msg.common.cancel, '取消')],
				yes: function(index, layero) {
					var unitId = select.selectpicker('val');
//					layer.msg(unitCode);
					//追加
					$("#"+clicknode).find("div.unitParamId").remove();
					$("#"+clicknode).append('<div class="unitParamId">'+unitId+'</div>');
				    var unitClass = $K.infos[$("#"+clicknode).find("div.unitCode").text()].unitClass
			         //加载简略信息
			        $K.ajax({
						url: ctx+'/paramCommon/getParamBaseInfo.in',// isUpdate是标记为数据更新
						type: 'POST',
						datType: 'json',
						async: false,
						data: {'code':unitId,'paramClass':unitClass},
						success: function(val) {
							var html = '';
							$.each(val,function(index,value){
								html+=''+index+':'+value+'<br>'
							});
							html+='';
							$("#"+clicknode).find("div.content").empty()
							$("#"+clicknode).find("div.content").append(html);
					 	     
						},
					}); 
					//动态创建节点
					layer.close(index);
				},
				end: function() {
					select.empty().append('<option value>-- please choose --</option>').selectpicker('refresh');
				}
			});
			}
		});	
  }
  
  
 
  
  /**
   * 根据unitcode 找到对应的unitObj
   */
  function getUnitUrl(unitCode){
	  var obj = $K.infos[unitCode];
	  return obj ; 
  }
  
  
  
  /**
   * 根据id 获取unitcode
   * @returns
   */
  function getUnitCode( id){
	  return $("#"+id).children('.unitCode').text()
  }
  

  function initDetails(stepIndex){
	  $("#details"+stepIndex).click(function(){
		  //判断是否已经选择过组件了，如果没有选择就提示
	  if($("#"+clicknode).children('.unitParamId')[0]){
		  disnone(stepIndex)
	    	//获取到正在点击的节点
	    	var unitParamId  = $("#"+clicknode).children('.unitParamId').first().html();
	    	var unitCode  = $("#"+clicknode).children('.unitCode').text();
	    	//查询
	    	//请求后台获取详情页面
	    	showDetails($K.infos[unitCode].unitDetailUrl,unitParamId);
	  }else{
		  layer.msg("请先选择组件!")
	  }
		 
	  })
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
			title: (lang_current === lang_zh_CN ? '组件选择' : 'Unit Select'),
			content: ctx+unitDetailUrl+"?code="+unitParamId,
		});
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
  
  var disnone = function(stepIndex){
	    var oUl=document.getElementById("contextDiv"+stepIndex);
	    oUl.style.display="none";
}
