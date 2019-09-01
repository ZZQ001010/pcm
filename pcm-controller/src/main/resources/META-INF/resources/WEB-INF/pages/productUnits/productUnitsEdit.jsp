<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="productUnits.update.title" text="产品页面组件表修改" /></title>
<%@ include file="/common/head.jsp"%>
</head>
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="tmProductUnitsUpdForm" cssStyle="padding-top: 40px" modelAttribute="tmProductUnits" method="post" action="${ctx}/productUnits/updProductUnits.in" data-confirm="true">
		<form:hidden path="id" />
		<form:hidden path="unitRequired"/>
		<form:hidden path="groupCode" />
		<form:hidden path="unitCode" />
		<div class="form-group row">
		<!-- 产品组件 -->
		<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="tmProductUnits.unitModule" text="产品组件" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="unitModule" data-rule-required="true">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" /></option>
					<form:options items="${unitModule}" />
				</form:select>
			</div>
			<!-- 产品组件描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="tmProductUnits.unitModule.desc" />
			</div>
		</div>
		<div id="unit-sub" class="form-group row">
			<!--二级组件 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="tmProductUnits.subUnit" text="二级组件" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="subUnit">
				</form:select>
			</div>
			<!-- 二级组件描述  -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="tmProductUnits.subUnit.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 关联组件 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="tmProductUnits.updateUnits" text="关联组件" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="updateUnits" multiple="multiple">
					<form:options items="${updateUnits}" />
				</form:select>
			</div>
			<!-- 关联组件描述  -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="tmProductUnits.updateUnits.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 组件配置窗口 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="tmProductUnits.unitConfig" text="组件配置窗口" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="unitConfig">
					<form:options items="${unitConfig}" />
				</form:select>
			</div>
			<!-- 组件配置窗口描述  -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="tmProductUnits.unitConfig.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 产品组件名称 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="tmProductUnits.unitName" text="产品组件名称" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control"  path="unitName"  data-rule-required="true" data-rule-maxlength="200" />
			</div>
			<!-- 产品组件名称描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="tmProductUnits.unitName.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 产品组件国际化名称 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="tmProductUnits.unitNameCn" text="产品组件国际化名称" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control"  path="unitNameCn"  data-rule-required="true" data-rule-maxlength="200" />
			</div>
			<!-- 产品组件国际化名称描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="tmProductUnits.unitNameCn.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 产品组件序号 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="tmProductUnits.unitIndex" text="产品组件序号" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control"  path="unitIndex"  data-rule-required="true" data-rule-maxlength="2" data-rule-digits="true" />
			</div>
			<!-- 产品组件序号描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="tmProductUnits.unitIndex.desc" />
			</div>
		</div>				
		<!-- <div class="form-group row">
		必配组件
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
			<spring:message code="tmProductUnits.unitRequired" text="必配组件" />: 
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<label class="col-lg-1 col-md-1 col-sm-1 col-xs-1 control-label">
				 <input id="unitRequired" type="checkbox" class="js-switch sel" unchecked /> 
				 <form:hidden path="unitRequired" />
				</label> 
			</div>
		</div> -->
		<div class="form-controls auto-float">
			<div class="btn-group-md">
				<!-- 确定 -->
				<input type="submit" class="btn-primary btn" value="<spring:message code='kite.web.common.btnSure' text='确定' />" />
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='取消' />" />
			</div>
		</div>
	</form:form>
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp"%>
	<script>
	$("#unit-sub").hide();
	$("#unitModule").change(function(){
		selOption();
	});
	function selOption(){
		 if($("#unitModule").val()=="CREDITPLAN"){
			 $K.ajax({
					url : "${ctx}/productUnits/checkProductUnitSub.in",
					type : "POST",
					data : {id:$("#unitModule").val()},
					success : function(data) {
						if(data!=null){
							var map=data;
							$("#subUnit").empty();
							$.each(map,function(key,values){ 
							     // 实际的应用中，这里的option一般都是用循环生成多个了
							      var option = $("<option>").val(key).text(values);
							     if(key=='${tmProductUnits.subUnit}'){
							    	 $(option).attr('selected','true');
							     }
							      $("#subUnit").append(option);
							});
							$("#subUnit").selectpicker('refresh');
						}
					}
				});
			 $("#unit-sub").show();
			 $("#unitName").val("");
			 $("#unitNameCn").val("");
			 $("#unit-sub").change(function(){
				 $("#unitName").val($("#unit-sub").val());
				 $("#unitNameCn").val( $("#unit-sub").find("option:selected").text());
			 });
		 }else{
			 $("#unit-sub").hide();
			 $("#unitName").val($("#unitModule").val());
			 $("#unitNameCn").val( $("#unitModule").find("option:selected").text());
		 }
	}
	/* bindfun(".sel","Y","N");
	function bindfun(classStyle,cheVal,uncheVal){
		$(classStyle).each(function(i, ck) {
			//給開發賦值
			var value=$(this).parent().find('input[type=hidden]').val();
			if(value=="Y"){
				$(this).attr("checked","checked");
			}
			//给开关判断事件
			$(this).change(function(){
				if ($(this).is(':checked')) {
					$(this).parent().find('input[type=hidden]').val(cheVal);
				} else {
					$(this).parent().find('input[type=hidden]').val(uncheVal);
				}
			});
		});
	} */
	 var str="${updateUnitsName}";
     var arr=str.split(',');
     $('#updateUnits').selectpicker('val', arr);
		//开启表单验证
		$("#tmProductUnitsUpdForm").validate();
	</script>
</body>

</html>