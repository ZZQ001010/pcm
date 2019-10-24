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
        ,{
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

  /**
   * 获取全部数据
   */
  var getdata = function(){
    if($('#chart-container').find('.node:first').length===0) return '';
    var hierarchy = $('#chart-container').orgchart('getHierarchy');
    if(hierarchy) {return hierarchy;}
    return '';
  }

  /**
   * 添加节点
   */
  var addnode = function( name , content , cid , pid){
    var $chartContainer = $('#chart-container')
    var nodeVals = []
    var obj = {'id':getId(),'unitName':'','unitNameCn':'新增产品组件','value':'请选择'}
//    obj.name = name ? name : ''
//    obj.content = content ? content : ''
//    obj.id = cid ? cid : ''
    nodeVals.push(obj)
    if (pid)var $node = $('#' + pid);     
    var hasChild = $node.parent().attr('colspan') > 0 ? true : false
    if (!hasChild) {
      var rel = nodeVals.length > 1 ? '110' : '100'
      $chartContainer.orgchart('addChildren', $node, {
        'children': nodeVals.map(function (item) {
        	return {'id':item.id,'relationship':rel,'unitName':'','unitNameCn':item.unitNameCn,'value':item.value}
         // return { 'name': item.name,'content': item.content, 'relationship': rel, 'Id': item.id }
        })
      }, $.extend({}, $chartContainer.find('.orgchart').data('options'), { depth: 0 }))
    } else {
      $chartContainer.orgchart('addSiblings', $node.closest('tr').siblings('.nodes').find('.node:first'),
        { 'siblings': nodeVals.map(function (item) {  
        	return {'id':item.id,'unitName':'','unitNameCn':item.unitNameCn,'value':item.value,'relationship': '110'}
        	//{ 'name': item.name, 'content': item.content,'relationship': '110', 'Id': item.id }; 
        	})
        })
    }
    $K.flag=1; //如果为1表示有添加的
  renderpic(getdata());
   }

  //删除节点
   var deletenode = function(pid){
    var $node = $('#' + pid)
    if ($node[0] === $('.orgchart').find('.node:first')[0]) {
    	layer.msg('不能删除根节点,删除失败!')
      return getdata();
    }
    $('#chart-container').orgchart('removeNodes', $node)
    $('#selected-node').val('').data('node', null)
    return getdata();
  }

var ocCopy ;
//渲染组织树
  var renderpic = function(datascource){
    $('#chart-container').empty();//渲染之前先全部清空
    ocCopy =  $('#chart-container').orgchart({
      'data' : datascource,
//      'parentNodeSymbol': 'fa-th-large',
//			'exportButton': true,
//			'exportFilename': 'unitsChart',
      'nodeContent': "unitNameCn",
      'nodeTitle': 'value', 
      'direction': 'l2r',
      'pan': false,
      'draggable': false,
//      'zoom': true,
//      'zoominLimit': 3,
//      'zoomoutLimit': 0.2,
      'createNode': function($node, data) {
        $node[0].id = data.id;
        if(data.unitParamId=='null' || typeof (data.unitParamId)=='undefined'){
        	data.unitParamId='';
        }
        $node.append('<div class="unitParamId">'+data.unitParamId+'</div>'); 
      },
      'draggable': false,
      'dropCriteria': function($draggedNode, $dragZone, $dropZone) {
        if($draggedNode.find('.content').text().indexOf('manager') > -1 && $dropZone.find('.content').text().indexOf('engineer') > -1) {
          return false;
        }
        return true;
      }
    })
    .on('mouseover','.node',function(ev){
	    let top =   $(this).offset().top;
	    let left = 	$(this).offset().left-220;
	      var oEvent= ev||event;
	      var oUl=document.getElementById("contextDiv");
	      oUl.style.display="block";
	      oUl.style.left=left+'px';//oEvent.clientX
	      oUl.style.top=top+'px';
	      clicknode = $(this)[0].id
	     //clicknode = $(this)
	      return false;
	    })
    .children('.orgchart').on('nodedropped.orgchart', function(event) {
      console.log('draggedNode:' + event.draggedNode.children('.title').text()
        + ', dragZone:' + event.dragZone.children('.title').text()
        + ', dropZone:' + event.dropZone.children('.title').text()
      );
    })
    
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
  var data ;
  var clicknode = '';
//  renderpic(data)
  // 给标签绑定增加事件
  $('#add-node').on('click', function() {
	  if($K.flag==1){layer.msg("请完成上个组件的配置!");return}
	  
    disnone();
    var name = '新的节点' //默认name
    var content = '节点描述' // 默认content
    // console.log(clicknode +','+ name +','+ content)
    //调用接口返回新的id,cid

    //调用接口返回新的id,cid
    addnode(name, content, getId(), clicknode)//此处先用getId()代替
   })
  // 给标签绑定增加事件

  // 绑定删除事件
  $('#delete-node').on('click', function() {
    disnone()
    //因为可以修改节点内容，不允许删除根节点
    //调用接口通知后台
    
    //调用接口通知后台
    
    data = deletenode(clicknode);
    $K.flag=$K.flag-1;
  });
  // 绑定删除事件

  // body绑定disnone事件，用于隐藏contextnemu
  $('body').on('click',disnone)
  // body绑定disnone事件，用于隐藏contextnemu
  
  // 绑定修改属性事件
  $('#change-props').on('click',function(){
	  
	    var $node = $('#' +clicknode )
	    
	    if($node.attr('data-parent')=='all'){
	    	$('.unitIndex').css('display','block')
	    }else{
	    	$('.unitIndex').css('display','none')
	    }
	    
	    
	    if ($node[0] === $('.orgchart').find('.node:first')[0]) {
	    	layer.msg('不能修改根节点!')
	      return getdata();
	    }
	 var value = $node.children('.title')[0].innerHTML;
	 var index  = $node.children('.unitParamId').text()
	 $("#unitchoose").selectpicker("destroy");
	 if(value=='请选择'){
		 $("#unitchoose").selectpicker("val",'')
	 }else{
		 $("#unitchoose").selectpicker("val",value)
	 }
	 $('input[name="unitIndex"]').val(index);
	 
    //调用接口，返回数据
	 $("#myModal").modal({backdrop: 'static', keyboard: false});
    $('#myModal').modal('show');
    $("#unitchoose").selectpicker();
    
  })
  // 绑定修改属性事件

 var tempdata ={'id':'','unitName':'','unitNameCn':'','value':'','children': []} ; 
  
  
  $('#savechange').on('click',function(){
	  let $node = $('#'+clicknode);
	  if($node.attr('data-parent')=='all' && $('input[name="unitIndex"]').val()==''){
		  layer.msg("请填写组件序号!")
		  return 
	  }
	  
	  $node.children('.title').text($('#unitchoose').val())
	  $node.children('.content').text($K.units[$('#unitchoose').val()].unitNameCn);
	  $node.children('.unitParamId').text($('input[name="unitIndex"]').val())
	  $('#myModal').modal('hide')
     $K.flag=0;
  })
  
 


  $('#godetail').on('cilck',function(){console.log(top.ifame5)});

  $('#getData').on('click',function(){
    disnone()
    if(clicknode){
      window.location.href = 'detail.html?id='+clicknode; 
    }
  })
  
  
  
  
 //------------------------重置orgtree ----------------------————//
function  resetOrgTree(data){
	  //获取树的子节点
	  var data =  getOrgTreeTemplate(data);

}


 /**
  * 获取模板数据
  * @param id 当前节点的id  方法会递归的获取此节点下的所有子节点，如果没有子节点则返回null
  */
function getOrgTreeTemplate(data){
	$K.ajax({
		url:ctx+"/productUnit/queryProductUnitList.in",
		data:{'groupCode':data.groupCode,'productType':data.productType},
		type:"POST",
		success:function(v){
			//创建一个父节点
			//填充关联组件
			
			fullUnitsName(v);
			$K.currUnits = {'id':'all','unitParamId':'','unitName':'','unitNameCn':data.name,'value':data.groupCode,'children':v}
			renderpic($K.currUnits)
		}
	});	
}

//递归给关联的组件填充组件名称
function fullUnitsName(v){
	$.each(v,function(i,val){
		if(val.unitNameCn==null){
			val.unitNameCn=$K.units[val.value].unitNameCn;
		}else if(!(val.children!=null)){
			fullUnitsName(val.children);
		}else{
			return ;
		}
	})
}


$("#saveUnits").on("click",function(){
	if($K.flag==1){layer.msg("请检查所有组件是否都完成配置!" );return}
	var alldata = getdata();
	//发送ajax 保存到后台
	$K.ajax({
		url:ctx+"/productUnit/saveProductTemplate.in",
		data: JSON.stringify(alldata),
		type:"POST",
		contentType: 'application/json;charset=utf-8',
		dataType: "text",
		success:function(v){
			//创建一个父节点
			//填充关联组件
			layer.msg("保存成功😊")
		}
	});	
	
})





