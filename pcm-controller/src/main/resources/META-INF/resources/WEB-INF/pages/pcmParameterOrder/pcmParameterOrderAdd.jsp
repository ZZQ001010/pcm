<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="pcmParameterOrder.add.title" text="参数展示字段自定义排序新增" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form class="form-horizontal" id="pcmParameterOrderAddForm" style="padding-top: 40px"   method="post" action="${ctx}/pcmParameterOrder/addPcmParameterOrder.in" >
		<div class="form-group row">
			<!-- 参数全类名 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="pcmParameterOrder.paramClass" text="参数全类名" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<select name="paramClass" class="form-control" data-live-search="true" data-rule-required="true" >
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<c:forEach items="${ units}" var="unit">
						<option value="${unit.key }">${unit.value }</option>
					</c:forEach>
				</select>
				<!-- <input class="form-control" type="text" name="paramClass"  data-rule-required="true"  /> -->
			</div>
			<!-- 参数全类名描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmParameterOrder.paramClass.desc" />
			</div>
		</div>
		
		<div class="form-group row">
			<!-- 字段名字 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="pcmParameterOrder.filedName" text="字段名字" />
				:
			</label>
				<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6"> 
					<select name="filedName" class="form-control" data-rule-required="true" >
						<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					</select>
				</div>
			<!-- 字段名字描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmParameterOrder.filedName.desc" />
			</div>
		</div>
		
		
		<div class="form-group row">
			<!-- 字段名字 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label  ">
				<spring:message code="pcmParameterOrder.filedName" text="字段名字" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
					 <select name="filedName" class="form-control" data-rule-required="true" >
						<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					</select>
			</div>
			<!-- 字段名字描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmParameterOrder.filedName.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 字段名字 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="pcmParameterOrder.filedName" text="字段名字" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
					 <select name="filedName" class="form-control" data-rule-required="true" >
						<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					</select>
			</div>
			<!-- 字段名字描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmParameterOrder.filedName.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 字段名字 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="pcmParameterOrder.filedName" text="字段名字" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
					 <select name="filedName" class="form-control" data-rule-required="true" >
						<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					</select>
			</div>
			<!-- 字段名字描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmParameterOrder.filedName.desc" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 字段名字 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label ">
				<spring:message code="pcmParameterOrder.filedName" text="字段名字" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
					 <select name="filedName" class="form-control"  data-rule-required="true">
						<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					</select>
			</div>
			<!-- 字段名字描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="pcmParameterOrder.filedName.desc" />
			</div>
		</div>
		
		
		<div class="form-controls auto-float">
			<div class="btn-group-md">
				<!-- 确定 -->
				<input type="button" id="submit" class="btn-primary btn" value="<spring:message code='kite.web.common.btnSure' text='确定' />" />
				<!-- 返回 -->
				<input type="button"  id="slide-out" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
			</div>
		</div>
	</form>
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp"%>
	<script type="text/javascript">
		//开启表单验证
		$("#pcmParameterOrderAddForm").validate();
		
		//当select 中的值发生改变的时候， 重新加载
		$('select[name="paramClass"]').change(function(){
			var filedNames = $('select[name="filedName"]')
			if($('select[name="paramClass"]').val()!=''){
				//发送ajax 填充下面的字段
				$K.ajax({
					url: ctx+'/pcmParameterOrder/getFileds.in',
					type: 'post',
					data: {'paramClass': $(this).val()},
					success: function(data){
						console.info(data);
						$.each(filedNames,function(ind,val){
							$(val).empty();
							$(val).append('<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>')
							 $.each(data,function(k,v){
								 $(val).append('<option value="'+k+'">'+v+'</option>');
							 })
							$(val).selectpicker('refresh'); 
						})
					}
				})
			}else{
				$.each(filedNames,function(ind,val){
					$(val).empty();
					$(val).append('<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>')
					$(val).selectpicker('refresh'); 
				})
			}
		})
		
		//转换数据
		$('#submit').click(function(){
			if($("#pcmParameterOrderAddForm").valid()){
				//发送请求，保存数据
				var formArray = $('#pcmParameterOrderAddForm').serializeArray();
						var dataArr = [];
						$.each(formArray,function(ind,val){
						  if(ind != 0){
							  var map  = {};
							  map[val.name]=val.value;
							  map[formArray[0].name]=formArray[0].value
							  dataArr.push(map);
						  }
						})
						
				$K.ajax({
					url: ctx+'/pcmParameterOrder/addPcmParameterOrder.in',
					type: 'POST',
				    contentType : "application/json",
					data:  JSON.stringify(dataArr),
					success: function(data){
						$('#slide-out').click();
					}
				})
			}
		})
		
		
	</script>
</body>
</html>