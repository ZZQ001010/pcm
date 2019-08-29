<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="parameter.refresh.title" text="刷新参数" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<div class="btn-group-md">
		<button id="parameterRefresh" class='btn btn-primary' ><i class='fa fa-refresh'></i><spring:message code="parameter.refresh.title" text="刷新参数" /></button>
	</div>
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp"%>
	<script type="text/javascript">
	<k:access code="parameter_refresh">
		$("#parameterRefresh").click(function(){
			$K.ajax({
				url:"${ctx}/parameterRefresh/clearParameter.in",
				//data:{key:"",paramClazzName:""},
				type:"POST",
				success:function(response){
					layer.msg("<spring:message code='parameter.refresh.success' text='刷新成功' />");
				}
			});
		});
	</k:access>
	</script>
</body>
</html>