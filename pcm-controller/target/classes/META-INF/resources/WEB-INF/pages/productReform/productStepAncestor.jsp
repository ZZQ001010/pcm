<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp" %>
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	    <title><spring:message code="product.new.steps" text="产品参数分步配置"/></title>
	    <%-- <link rel="stylesheet" type="text/css" href="${ctxStatic}/css/kite.home.partition.css"/> --%>
	    <%@ include file="/common/head.jsp" %>
	    <%-- <link rel="stylesheet" type="text/css" href="${ctxStatic}/css/product.factory.css"> --%>
	    <link type="text/css" rel="stylesheet" href="${ctxStatic}/css/productStep.css" />
	    	<link href="${ctx }/static/plugins/orgChart/css/bootstrap.css" rel="stylesheet">
    <link href="${ctx }/static/plugins/orgChart/css/font-awesome.min.css" rel="stylesheet">
    <%-- <link href="${ctx }/static/plugins/orgChart/css/animate.css" rel="stylesheet"> --%>
    <link href="${ctx }/static/plugins/orgChart/css/jquery.orgchart.css" rel="stylesheet">
    <link href="${ctx }/static/css/productStepAncestor.css" rel="stylesheet">
    
	    <style type="text/css">
	    	.input_combobox{
	    		display: none;
	    	}
	    	.unitParamId{
	    		display: none
	    	}
	    	.unitCode{
	    	display: none
	    	}
			.wizard_verticle ul.wizard_steps {
				width: 12%;
			}
			.wizard_verticle .stepContainer {
				width: 88%;
			}
			.stepContainer{
				height: 94%!important;
			}
			.actionBar {
				border: 0;
			}
			
			.wizard_verticle ul.wizard_steps li a:first-child {
			    margin-top: 10px;
			}
			.wizard_verticle ul.wizard_steps li a .step_no {
			    width: 34px;
			    height: 34px;
			    line-height: 32px;
			    border-radius: 100px;
			    display: block;
			    margin: 0 auto 5px;
			    font-size: 16px;
			    text-align: center;
			    position: relative;
			    z-index: 5;
			}
			.wizard_verticle ul.wizard_steps li a:before {
			    content: "";
			    position: absolute;
			    height: 85%;
			    background: #ccc;
			    top: 20px;
			    width: 3.5px;
			    z-index: 4;
			    left: 49%;
			}
			.wizard_verticle ul.wizard_steps li a {
			    height: 70px;
			}
			.stepContainer>.content{
				height: 90%!important;
			}
			#contextDiv${unitStatus.index + 2} {
	            width: 50px;
	            height: 23px;
	            overflow: auto;
	            white-space: nowrap;
	        }
	        .lable {
	            width: 20px;
	            display: inline-block;
	        }
	    </style>
	</head>
	
	<body class="${param.skin}">
		
		<!-- 步骤容器 -->
		<div id="wizard_verticle" class="form_wizard wizard_verticle" style="height: 100%">
			
			<!-- 步骤序号 -->
			<ul class="list-unstyled wizard_steps" style="overflow:auto;display:block;max-height:-webkit-fill-available;">
				<li>
					<a href="#step-1"><spring:message code="product.basicInfo" text="基本信息" /><span class="step_no">1</span></a>
				</li>
				<c:forEach var="unit" items="${units}" varStatus="unitStatus">
					<li>
						<a href="#step-${unitStatus.index + 2}">
							<c:if test="${isChinese}">${infos[unit.unitCode].unitNameCn}</c:if>
							<c:if test="${!isChinese}">${infos[unit.unitCode].unitName}</c:if>
							<span class="step_no">${unitStatus.index + 2}</span>
						</a>
					</li>
				</c:forEach>
			</ul>
			<!-- 步骤序号-结束 -->
			
			<%-- 会自动生成div.stepContainer将div.content包裹起来 --%>
			
			<!-- 步骤内容 -->
			<div id="step-1" class="content">
				<h2 class="StepTitle"><spring:message code="product.supplement" text="完善" /><spring:message code="product.basicInfo" text="基本信息" /></h2>
				<div class="product-common">
					<%@include file="/WEB-INF/pages/productReform/productStepCommon.jsp"%>
				</div>
			</div>
			
			<c:forEach var="unit" items="${units}" varStatus="unitStatus">
				<div id="step-${unitStatus.index + 2}" class="content">


				<!-- 树状图 -->
					<h2 class="StepTitle">
						<spring:message code="product.supplement" text="完善" />
						<c:if test="${isChinese}">${unit.unitNameCn}</c:if>
						<c:if test="${!isChinese}">${unit.unitName}</c:if>
						信息
					</h2>
					<div id="chart-container${unitStatus.index + 2}" class="view-state chart-container"></div>
					<div id="contextDiv${unitStatus.index + 2}"  class="list-group contextDiv">
					        <div class="lable" id="select-item${unitStatus.index + 2}">
					            <img alt="选择组件参数" title="选择组件参数" src="${ctx }/img/修 改.png" style="height: 20px;width: 20px;">
					        </div>
					        <div class="lable" id="details${unitStatus.index + 2}">
					            <img alt="组件详情" title="组件详情" src="${ctx }/img/详情.png" style="height: 20px;width: 20px;">
					        </div>
					    </div>   
						<%-- <div id="contextDiv${unitStatus.index + 2}" class="list-group contextDiv"  >
							<a href="#" id="select-item${unitStatus.index + 2}" class="list-group-item">选择组件参数</a>
							 <a href="#" id="details${unitStatus.index + 2}" class="list-group-item">组件详情</a>
						</div> --%>
			</div>
			</c:forEach>
							<!-- orgchart 的功能菜单 -->
			
			<%-- unit=BPcmProductUnit --%>
			<%-- <c:forEach var="unit" items="${units}" varStatus="unitStatus">
				<div id="step-${unitStatus.index + 2}" class="content">
					<h2 class="StepTitle"><spring:message code="product.supplement" text="完善" />
					<c:if test="${isChinese}">${unit.unitNameCn}</c:if><c:if test="${!isChinese}">${unit.unitName}</c:if>信息</h2>
					<div class="unit-assemble" 
						data-code="${infos[unit.unitCode].unitCode}" 
						data-class="${infos[unit.unitCode].unitClass}" 
						data-config="${ctx}${infos[unit.unitCode].unitConfigUrl}" 
						data-detail="${ctx}${infos[unit.unitCode].unitDetailUrl}" 
						data-multiple="${unit.multiple}" 
						>
					</div>
				</div>
			</c:forEach>
			 --%>
			<!-- 步骤内容-结束 -->
			
		</div><!-- 步骤容器-结束 -->
		
		<div id="config_select_area" class="layer-page-panel form-group" style="height: auto;">
			<div style="text-align: center;width: 60%;margin-left: 20%;">
				<select id="config_select" class="form-control"></select>
			</div>	
		</div>
		
	</body>
	 <script src="${ctx }/static/plugins/orgChart/js/jquery.js"></script> 
    <script src="${ctx }/static/plugins/orgChart/js/html2canvas.js"></script>
    <script src="${ctx }/static/plugins/orgChart/js/jquery.orgchart2.js"></script>
    <script src="${ctx }/static/js/productStepAncestor/productStepAncestor.js"></script>
	<%@ include file="/common/foot.jsp" %>
	
	<script type="text/javascript" src="${ctxStatic}/plugins/jquery.smartWizard/3.3.1/jquery.smartWizard.zco.js"></script>
	<%-- <script type="text/javascript" src="${ctxStatic}/js/productStep.js"></script> --%>
	<script type="text/javascript">
		// 变量定义
		var wiz, ps, stepCommonForm = $("#productStepCommon");
		$.isUpdate= ${isEdit};
		$K.stepTree={};
		// 下拉显示条数特殊控制
		$('#currency').data('size', '3').selectpicker('refresh');
		// 通用步骤一的校验
		stepCommonForm.validate();
		// 跳转回调
		var _onLeaveStep = function($step, context) {
			if (context.fromStep == 1 && !stepCommonForm.valid()){
				return false ;
			}else {
				//获取表单数据，存入列队中
				var step1={};
				var fromdata = $("#productStepCommon").serializeArray();
	            $.each(fromdata, function() {
	            	if(this.name!='__groupType'){
	            		step1[this.name] = this.value;
	            	}
	            });
	            $K.stepTree[1]=step1;
			}
			// 返回true才会跳转到下一步
			var fromStepIndex =context.fromStep;
			var toStepIndex =  context.toStep;
			//保存上个stepTree 的数据
			if(fromStepIndex!=1){
				saveStepTreeData(fromStepIndex);
			}
			//初始化下一个stepTree的数据
			if(toStepIndex>fromStepIndex){
				//如果$K.StepTree 中存储了这个，不需要渲染
				if(typeof($K.stepTree[toStepIndex]) == "undefined"){
					//TODO 如果是修改就要去查询下，如果已经配置了，就可以直接点击详情展示
					initNextStepTreeView(toStepIndex)
				}
			}
			return true;
		};
		
		//切换step 时保存上一额step 的数据
		function saveStepTreeData(fromStepIndex){
			
			$K.stepTree[fromStepIndex]=getdata(fromStepIndex)
		}
		
		//根据step初始化下一个
		function initNextStepTreeView(toStepIndex){
			//找到下一个组件，以及他的关联项
			if(toStepIndex==1){
				return
			}else{
				//数据从后台来
				var currStepViewData = JSON.parse(JSON.stringify(getUnitData(toStepIndex-2)).replaceAll("unitRelations","children"));
				currStepViewData.value=currStepViewData.unitCode;
				initStepView(currStepViewData,toStepIndex)
			}
		}
		
		  function initStepView(data,stepIndex){
			  //首先渲染页面
			  renderpic(data,stepIndex)
			  //绑定事件
			  initEvent(stepIndex);
		  }
		
		//根据顺序获取组件
		function getUnitData(index){
			return $K.units[index];
		}
		
		
		
		
		// 展示步骤中showing
		var _onShowStep = function($step, context) {};
		// 展示步骤后shown
		var _onShownStep = function($step, context) {
			$K.frame.autoHeight();
		};
		// 完成按钮
		var _onFinish = function($step, context) {
			

			//获取最后一个step 的数据
			var lastStepIndex = Object.keys($K.stepTree).length+1;
			if(getdata(lastStepIndex)!=null && getdata(lastStepIndex)!="" ){
				$K.stepTree[lastStepIndex]=getdata(lastStepIndex);
			}
			
				//如果treeMap 为null 说明产品没有关联组件，因此直接封装基本信息即可
				var step1={};
				var fromdata = $("#productStepCommon").serializeArray();
			    $.each(fromdata, function() {
			    	if(this.name!='__groupType'){
			    		step1[this.name] = this.value;
			    	}
			    });
			    $K.stepTree[1]=step1;
			    
			    
			    
				//如果只有基本信息 ，校验表单
			if(stepCommonForm.valid()){
				
				// 数据发送
				$K.ajax({
					url: '${ctx}/productReform/saveProductObj.in?isUpdate=${isEdit}',// isUpdate是标记为数据更新
					type: 'post',
					data: $K.JSON.stringify($K.stepTree),
					contentType: 'application/json;charset=utf-8',
					success: function(productCode) {
						//清除前端缓存
						$K.stepTree ={}; 
						if (productCode) {
							//跳转到展示页面
							$K.frame.reloadSlideInner('${ctx}/productReform/productShow.in?productCode=' + productCode);
						}
					}
				});
				
			}
		};
		
		// 初始化
		$(function() {
			initUnits();
			// 步骤构建，属性参考：https://github.com/mstratman/jQuery-Smart-Wizard
			wiz = $('#wizard_verticle').smartWizard({
				selected: 0,// 选中第一步
				keyNavigation: false,
				enableAllSteps: false,
				// 加了动画效果会导致高度修正有延缓效果，体验不好，所以强烈推荐使用none
				transitionEffect: 'none',
				labelNext: '<spring:message code="product.stepNext" text="下一步" />',
				labelPrevious: '<spring:message code="product.stepPrevious" text="上一步" />',
				labelFinish: '<spring:message code="product.stepFinish" text="完成" />',
				onLeaveStep: _onLeaveStep,// triggers when leaving a step
				onShowStep: _onShowStep, // triggers when showing a step
				onFinish: _onFinish,	// triggers when Finish button is clicked
				// 自定义拓展属性
			    btnClass: 'btn-sm btn-default',	// xs sm md lg
			    onShownStep: _onShownStep// 展示步骤后shown的回调
			});
			
			
	//初始化数据
		function initUnits(){
				$K.units=${unitsJson}
				$K.infos=${infosJson}

			if($.isUpdate){
				// 获取模板数据
				
				//填充模板
				
				//转换数据
				 $.each($K.units,function(i,val){
					 val['value']= val.unitCode;
					 val['unitNameCn']=$K.infos[val.unitCode].unitNameCn;
				  })
					$K.units =translateDataToTree($K.units);
			}
			
		}
		
		
		
		
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

			
		});
		
		

		
		
		//tree选择框展示
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
					simpleData: {idKey: "groupCode", pIdKey: "productParentId"},
					key: {name: "name"}
				},
				callback: {
					/* beforeClick: function(treeId, treeNode, clickFlag) {
			 			if (treeNode.abstractInstance != "N") {
							return false;
						} 
					} */
				}
			},
			treeExtra: {
				expandAll: false,
				singleSelectHide: true
			}
    	})
    	
    	$(".combobox-menu").remove();
	</script>
	
	
</html>