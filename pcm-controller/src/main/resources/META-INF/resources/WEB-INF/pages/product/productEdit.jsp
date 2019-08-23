<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="product.add.title" text="产品参数管理新增" /></title>
<!-- 引入css样式和部分js -->
<link rel="stylesheet" type="text/css" href="${ctxStatic}/css/kite.home.partition.css" />
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
				<!-- data-confirm=true 提交前需要确认 -->
				<form:form cssClass="form-horizontal" id="productUpdForm" cssStyle="padding-top: 20px" modelAttribute="product" method="post" action="${ctx}/product/updProduct.in" data-confirm="true">
					<form:hidden  path='cardClass' value='N'/>
					<form:hidden  path='brand' value='C'/>
					<form:hidden  path='newCardValidPeriod' value='5'/>
					<form:hidden  path='renewValidPeriod' value='5'/>
					<form:hidden  path='fabricationInd' value='N'/>
					<form:hidden  path='jointCode' value=''/>
					<form:hidden  path='jointDescription' value=''/>
					<div class="form-group row">
						<!-- 产品代码 -->
						<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
							<span class="span-icon">*&nbsp;</span>
							<spring:message code="product.productCode" text="产品代码" />
							:
						</label>
						<div class="col-lg-2 col-md-4 col-sm-4 col-xs-4">
							<form:input cssClass="form-control"  path="productCode" readonly='true' data-rule-required="true" data-rule-maxlength="6" />
						</div>
						<!-- 产品代码描述 -->
						<div class="hide desc">
							<spring:message code="product.productCode.desc" />
						</div>
						<!-- 产品描述 -->
						<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
							<spring:message code="product.description" text="产品描述" />
							:
						</label>
						<div class="col-lg-2 col-md-4 col-sm-4 col-xs-4">
							<form:input cssClass="form-control"  path="description" data-rule-maxlength="40" />
						</div>
						<!-- 产品描述描述 -->
						<div class="hide desc">
							<spring:message code="product.description.desc" />
						</div>
					</div>
					<div class="form-group row">
						<!-- BIN -->
						<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
							<span class="span-icon">*&nbsp;</span>
							<spring:message code="product.bin" text="BIN" />
							:
						</label>
						<div class="col-lg-2 col-md-4 col-sm-4 col-xs-4">
							<form:input cssClass="form-control"  path="bin" data-rule-required="true" data-rule-maxlength="6" />
						</div>
						<!-- BIN描述 -->
						<div class="hide desc">
							<spring:message code="product.bin.desc" />
						</div>
						<!-- 产品类型 -->
						<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
							<span class="span-icon">*&nbsp;</span>
							<spring:message code="product.productType" text="产品类型" />
							:
						</label>
						<div class="col-lg-2 col-md-4 col-sm-4 col-xs-4">
							<form:select cssClass="form-control" disabled="true"  path="productType">
								<form:options items="${productType}" />
							</form:select>
						</div>
						<!-- 产品类型描述 -->
						<div class="hide desc">
							<spring:message code="product.productType.desc" />
						</div>
					</div>
					<div class="form-group row">
						<!-- 电子账号上限 -->
						<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
							<span class="span-icon">*&nbsp;</span>
							<spring:message code="product.accountRangeCeil" text="电子账号上限" />
							:
						</label>
						<div class="col-lg-2 col-md-4 col-sm-4 col-xs-4">
							<form:input cssClass="form-control"  path="cardnoRangeCeil" data-rule-required="true" data-rule-digits="true" data-rule-maxlength="12"/>
						</div>
						<!-- 电子账号上限描述 -->
						<div class="hide desc">
							<spring:message code="product.accountRangeCeil.desc" />
						</div>
						<!-- 电子账号下限 -->
						<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
							<span class="span-icon">*&nbsp;</span>
							<spring:message code="product.accountRangeFlr" text="电子账号下限" />
							:
						</label>
						<div class="col-lg-2 col-md-4 col-sm-4 col-xs-4">
							<form:input cssClass="form-control"  path="cardnoRangeFlr" data-rule-required="true" data-rule-digits="true" data-rule-maxlength="12" data-rule-amountLimit="true"/>
						</div>
						<!-- 电子账号下限描述 -->
						<div class="hide desc">
							<spring:message code="product.accountRangeFlr.desc" />
						</div>
					</div>
					<div class="form-group row">
						<!-- 卡号长度 -->
						<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
							<span class="span-icon">*&nbsp;</span>
							<spring:message code="product.accountLen" text="电子账号长度" />
							:
						</label>
						<div class="col-lg-2 col-md-4 col-sm-4 col-xs-4">
							<form:input cssClass="form-control"  path="cardnoLen" data-rule-required="true" data-rule-digits="true" data-rule-min="0" data-rule-max="99" />
						</div>
						<!-- 卡号长度描述 -->
						<div class="hide desc">
							<spring:message code="product.accountLen.desc" />
						</div>
						<!-- 基准货币 -->
						<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
							<span class="span-icon">*&nbsp;</span>
							<spring:message code="product.currency" text="基准货币" />
							:
						</label>
						<div class="col-lg-2 col-md-4 col-sm-4 col-xs-4">
							<form:select cssClass="form-control" path="currency" data-live-search="true" >
								<form:options items="${currency}" />
							</form:select>
						</div>
						<!-- 基准货币描述 -->
						<div class="hide desc">
							<spring:message code="product.currency.desc" />
						</div>
					</div>
						<div class="form-group row">
						<!-- 人行记录是否合并 -->
						<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
							<span class="span-icon">*&nbsp;</span>
							<spring:message code="product.isPbocInfoMerged" text="人行记录是否合并" />
							:
						</label>
						<div class="col-lg-2 col-md-4 col-sm-4 col-xs-4">
							<form:select cssClass="form-control" path="isPbocInfoMerged"  >
								<option value=""><spring:message code="kite.web.common.pleaseChoose" text='---请选择---'/></option>
								<form:options items="${isPbocInfoMerged}" />
							</form:select>
						</div>
						<!-- 人行记录是否合并描述 -->
						<div class="hide desc">
							<spring:message code="product.isPbocInfoMerged.desc" />
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<c:forEach var="group" items="${groupList }">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					${group.groupNameCn}
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
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="padding-top: 20px">
					<c:forEach var="units" items="${unitsMap[group.groupCode] }" >
						<!-- 在线 -->
						<div class="col-lg-3 col-md-6 col-sm-6 col-xs-6">
							<div class="stats-container">
								<div class="unit-title" style="text-align: left;">
									<span class='content-opacity'>${units.unitNameCn }</span>
									<div class='product content-opacity'>
										<i class='product-view fa fa-list-ul' title="查看"  data-target-url="${units.unitDetailUrl }"></i>
										<i class='product-config fa fa-wrench' title="配置" data-target-url="${units.unitConfigUrl }"
										 data-iframe-id="${units.unitCode }" data-config-index="${units.unitIndex }" 
										 data-unit-class='${units.unitClass }' data-relation-untis="${units.updateUnits }"  data-config-page='${units.unitConfig }' 
										 data-unit-subunit='${units.subUnit }' data-unit-title='${units.unitNameCn }'></i>
									</div>
								</div>
								<div class="unit-content content-opacity">
									<!-- scrolling='no' -->
									<iframe id="iframe_${units.unitCode }" data-oldbase-url='${ctx }${units.unitBaseUrl }' src=" ${ctx }${units.unitBaseUrl }"  style="min-height: 240px;max-height: 240px" width="100%" height="0px" frameborder="no"  border="0" marginwidth="0" marginheight="0"  allowtransparency="yes"></iframe>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div> 
	</c:forEach>
	
	<div class="form-controls">
		<div class="cbtn-group-md auto-float">
			<!-- 确定 -->
			<input type="button" id='submit' class="btn-primary btn" value="<spring:message code='kite.web.common.btnSure' text='确定' />" />
			<!-- 返回 -->
			<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
		</div>
	</div>
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp"%>
	<script>
	jQuery.validator.addMethod("amountLimit", function(value, element) {
		var cardnoRangeCeil = $("#cardnoRangeCeil").val();
		var cardnoRangeFlr = $("#cardnoRangeFlr").val();
		if(parseFloat(cardnoRangeFlr)<parseFloat(cardnoRangeCeil)){
			return true;
		}
		return false;
	}, "电子账号上限必须大于电子账号下限。");
		//开启表单验证 
		$("#productUpdForm").validate();
		//查看按钮
		var productDatas=[];		
		var configMap={};
		var configCount=0;
		var productCode="";
		var paramsMap={};
		$("i[data-config-index='1']").parent().removeClass("content-opacity");
		$(".product-view").each(function(i,view){
			$(this).click(function(){
				var detailUrl=$(this).data("target-url");
				var paramKey=$(this).next().data("param-key");
				var unitTitle=$(this).next().data("unit-title");
				if(paramKey==""||paramKey==null){
					return;
				}
				var url=detailUrl+"?productCode="+paramKey;
				//子产品参数详情页面
				var code=$(this).next().data("iframe-id");
				if(paramsMap[code]){
					var iframeObj=$('#iframe_'+code);
					var rowData=iframeObj[0].contentWindow.getRowData();
					if(rowData==null){
						return layer.msg("<spring:message code='' text='请选择一行数据'/>");
					}
					url=detailUrl+"?productLoanTerm="+encodeURI(JSON.stringify(rowData));
				}else{
					var iframeObj=$('#iframe_'+code);
					var proCode=iframeObj[0].contentWindow.getRowData();
					if(proCode!=null){
						url=detailUrl+"?productCode="+proCode;
					}else{
						//说明没有选数据
						if((paramKey+"").indexOf(",")>0){
							return layer.msg("<spring:message code='' text='请选择一行数据'/>");
						}
					}
				}
				// 弹窗
				$K.layerOpen({
					win:window,
					content: ["${ctx}"+url, 'yes'],	// 必填
					type:2,
					area: ["80%", "80%"],//h w
					title:unitTitle,
					btn: ['<spring:message  code="kite.web.common.btnBack" text="返回" />'] , 
					yes: function(index, layero) {
						layer.close(index);
					},
					cancel: function(index, layero) {
						
					},
					end:function(index){
						
					}
				}); 		
			})
		})
		$(".product-config").each(function(i,view){
			$(this).click(function(){
				var formVd=$("#productUpdForm").valid();//表单校验
				if(!formVd){
					return ;
					//layer.msg("<spring:message code='product.configOrder' text='请按照顺序配置 !'/>");
				}
				//引导式配置
				var configObj=$(this);
				var configIndex=configObj.data("config-index");
				if(configIndex>1){
					if(configCount==0){
						return;// layer.msg("<spring:message code='product.configOrder' text='请按照顺序配置 !'/>");
					}
					var mapSize=0;
					$.each(configMap,function(key,value){
						mapSize++;
					})
					if(mapSize<configIndex-1){
						return;// layer.msg("<spring:message code='product.configOrder' text='请按照顺序配置 !'/>");
					}
				}
				productCode=configObj.data("param-key");
				//为了判断弹框内容是否是表单
				if(productCode==""||productCode==null){
					productCode='${product.productCode}';
				}
				var targetUrl=configObj.data("target-url")+"?productCode="+productCode;//配置页面url
				//判断页面是否是子页面
				var subUnit=configObj.data("unit-subunit");
				if(subUnit){
					targetUrl=configObj.data("target-url")+"?productCode="+productCode+"&subUnit="+subUnit;
				}
				var iframeId=configObj.data("iframe-id");
				var unitClass=configObj.data("unit-class");//参数的类路径
				var relationUnitCodes=configObj.data("relation-untis");//iframe关联 需要关联的iframe的id
				//判断是否需要联动查询数据
				if(paramsMap[iframeId]){
					targetUrl=$(this).data("target-url")+"?"+paramsMap[iframeId].join("&");
				}
				//获取弹窗配置大小
				var windowWH=configObj.data("config-page");
				//默认中屏
				var width='40%';
				var height='60%';
				if(windowWH=='B'){
					width='60%';
					height='80%';
				}else if(windowWH=='S'){
					width='35%';
					height='30%';
				}
				var unitTitle=configObj.data('unit-title')
				// 弹窗
				$K.layerOpen({
					win:window,
					content: ["${ctx}"+targetUrl, 'yes'],	// 必填
					type:2,
					area: ['40%', '60%'],
					title:unitTitle,
					btn: ['<spring:message  code="kite.web.common.btnSure" text="确定" />', '<spring:message  code="kite.web.common.btnBack" text="返回" />'],
					yes: function(index, layero) {
						var validCallBack='not';
						var openIfram=$(layero).find("iframe").contents();
						productCode=openIfram.find("#productCode").val();
						if(productCode==''||productCode==null){
							layer.close(index);
							return ;
						}
						if(jQuery.isArray( productCode )){
							productCode=productCode.join(",");
						}
						if(productCode=='${product.productCode}'){
							var isFail=$(layero).find("iframe")[0].contentWindow.formSubmit();
							if(!isFail){
								return;
							}
						}else{
							//除了产品编码和产品工厂编码一直的不需校验 其他的都需要校验							
							$K.ajax({
								type:'post',
								url:'${ctx}/product/commonValidParam.in',
								async: false ,
								data:{productCode:'${product.productCode}',paramKey:productCode,paramClass:unitClass},
								success:function(data){
									validCallBack=data;
								}
							})
						}
						if(validCallBack!='not'){
							//给出提示
							layer.msg("此参数已被{ "+validCallBack+" }产品使用")
						}
						configObj.data("param-key",productCode);
						var iframeObj=$('#iframe_'+iframeId);
						//判断是否需要联动查询数据
						if(paramsMap[iframeId]){
							var newParams=[];
							var params=paramsMap[iframeId];
							for(var i=0;i<params.length;i++){
								var str=params[i];
								if(str.indexOf("parentProductCode")>=0){
									newParams.push(str);
								}
							}
							newParams.push("productCode="+productCode);
							if(subUnit){
								newParams.push("subUnit="+subUnit);
							}
							paramsMap[iframeId]=newParams;
							iframeObj.attr('src', iframeObj.data("oldbase-url")+"?"+newParams.join("&"));
						}else{
							//刷新iframe
							iframeObj.attr('src', iframeObj.data("oldbase-url")+"?productCode="+productCode+'&subUnit='+subUnit);
						}
						//有关联的数据这需要联动关联的iframe
						if(relationUnitCodes){
							var codes=relationUnitCodes.split(",");
							for(var i=0;i<codes.length;i++){
								var	 iframeRelObj=$('#iframe_'+codes[i]);
								var params = [];
								params.push("productCode=");
								params.push("parentProductCode="+productCode);
								paramsMap[codes[i]]=params;
								iframeRelObj.attr('src', iframeRelObj.data("oldbase-url")+"?"+params.join("&"));
							}
						}
						configMap[configIndex]=true;
						configCount++;
						var isNotExist=true;
						//排除重复添加通过一条数据
						for(var i =0;i<productDatas.length;i++){ 
							var proData = productDatas[i];
							//代表集合中已经存在这个编码
							if(proData.unitCode==iframeId){
								proData.paramKey=productCode;//参数配置页面的paramKey
								isNotExist=false;
							}
						} 
						if(isNotExist){
							var divCont=configObj.parents(".stats-container");
							divCont.css("border","1px solid rgba(76,140,245,0.52)");
							//新增数据
							var proMap={};
							proMap.productCode="${product.productCode}";
							proMap.productType="${product.productType}";
							proMap.unitCode=iframeId;
							proMap.paramClass=unitClass;
							proMap.paramKey=productCode;//参数配置页面的paramKey
							productDatas.push(proMap);
							//将本身的模糊样式移除 顺便吧下一个ifrmae 的模糊样式移除
							configObj.parents(".stats-container").children().each(function(i,view){
							    if($(this).children().length>0){
							    	$(this).children().each(function(i,view){
							    		$(this).removeClass("content-opacity");
							   		});
							   	}
							    $(this).removeClass("content-opacity");
							  });
							$("i[data-config-index='"+(configIndex+1)+"']").parent().removeClass("content-opacity");
						}
						layer.close(index);
					},
					btn2: function(index,layero){
						//configMap[configIndex]=false;
					},
					cancel: function(index, layero) {
						//configMap[configIndex]=false;
					},
					end:function(index){
						
					}
				}); 
				
			})
		})
		$("#submit").click(function(){
			var formVd=$("#productUpdForm").valid();//表单校验
			if(!formVd){
				return;
			}
			$K.layerConfirm("<spring:message code='customServiceFee.sureSubmit' text='确认提交'/>",null,
				function(index){
					var productInfoData={};
					var productInfo = $("#productUpdForm").serializeArray();
					$.each(productInfo, function() {
						if(this.value){
							productInfoData[this.name] = this.value;
						}
					});
					productInfoData.productType="${product.productType}";
					//productInfoData.currency="${product.currency}";
					//修改参数信息
					$K.ajax({
						url:"${ctx}/product/updProduct.in",
						type:"post",
						contentType:"application/json;charset=utf-8",
						data:JSON.stringify(productInfoData),
						success:function(data){
							//保存参数映射
							$K.ajax({
								url:"${ctx}/product/saveProductData.in",
								type:"post",
								contentType:"application/json;charset=utf-8",
								data:JSON.stringify(productDatas),
								success:function(data){
									$(".only-slide-out").click();
									layer.close(index);
								}
							})
						}
					})
				},null)
			})
	</script>
</body>
</html>