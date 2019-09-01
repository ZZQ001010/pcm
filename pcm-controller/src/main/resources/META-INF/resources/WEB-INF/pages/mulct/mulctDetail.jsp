<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="mulct.detail.title" text="罚金利率明细" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<form:form cssClass="form-horizontal" cssStyle="padding-top: 40px" modelAttribute="mulct">
		<div class="form-group row">
			<!-- 罚金表id -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="mulct.mulctTableId" text="罚金表id" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3  detailStyle">
				${mulct.mulctTableId }	
			</label>
			<!-- 罚金名称 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="mulct.mulctName" text="罚金名称" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3  detailStyle"> 
				${mulct.mulctName }	
			</label>
		</div>				
		<div class="form-group row">
			<!-- 罚金收取方式 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="mulct.mulctMethod" text="罚金收取方式" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3  detailStyle">
				${mulctMethod}
			</label>
			<!-- 罚金计算方式 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="mulct.mulctCalMethod" text="罚金计算方式" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3  detailStyle"> 
				${mulctCalMethod}
			</label>
		</div>				
		<div class="form-group row">
			<!-- 计息基准年 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="mulct.baseYear" text="计息基准年" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3  detailStyle">
				${mulct.baseYear }	
			</label>
			<!-- 描述 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="mulct.description" text="描述" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3  detailStyle"> 
				${mulct.description }	
			</label>
		</div>				
		<div class="form-group row">
			<!-- CPD容差 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="mulct.cpdToleLmt" text="CPD容差" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3  detailStyle">
				${mulct.cpdToleLmt }	
			</label>
			<!-- DPD容差 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="mulct.dpdToleLmt" text="DPD容差" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3  detailStyle"> 
				${mulct.dpdToleLmt }	
			</label>
		</div>				
		<div class="form-group row">
			<!-- 扣款延迟入账是否回溯罚金 -->
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">
				<spring:message code="mulct.isReviewMulct" text="扣款延迟入账是否回溯罚金" />
				:
			</label>
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3  detailStyle">						
				<input  type="checkbox" class="js-switch" readonly="true" unchecked/>					
				<form:hidden path="isReviewMulct" value="${isReviewMulct}" />									
			</label>
		</div>
		<input id="mulctDefstr" name="mulctDefstr" hidden >
		<div class="form-group row">
			<div class="responsive-table">
				<div class="scrollable-area">
					<table id="mulctDef_datatable" class="datatable table table-hover table-striped table-bordered">
					</table>
				</div>
			</div>
		</div>		
	</form:form>
	<!--数据表格展示区域  -->
	<div class="form-group row">
		<div class="responsive-table">
			<div class="scrollable-area">
				<table id="mulctDefs_datatable" class="datatable table table-hover table-striped table-bordered">
				</table>
			</div>
		</div>
	</div>
	<div class="form-controls auto-float">
		<div class="btn-group-sm">
		<k:access code="mulct_edit">
			<!--修改 -->
			<input type="button" class="btn-info btn" id="updateMulct" value="<spring:message code='kite.web.common.btnUpd' text='修改' />" />
			<script type="text/javascript">
				$("#updateMulct").click(function(){
					var params = [];
					params.push("mulctTableId=${mulct.mulctTableId }");
					$K.frame.reloadSlideInner("${ctx}/mulct/mulctEditPage.in?" + params.join("&"));
				})
			</script>
		</k:access>
			<!-- 返回 -->
			<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
		</div>
	</div>
	<%@ include file="/common/foot.jsp"%>
	<!-- 创建datatable表格 -->
	<script type="text/javascript">
	if($("#isReviewMulct").val() == "Y" || $("#isReviewMulct").val() == "是"){
		$("#isReviewMulct").parent().find('input[type=checkbox]').prop("checked",true);
	}
		
	var list = ${list};	
	var grid = $("#mulctDefs_datatable").grid(
		{
			datatable : {
				columns : [
						{//罚金-逾期天数
							title : '<spring:message code="mulctDef.mulctOverDays" text="罚金-逾期天数" />',
							data : 'mulctOverDays'
						},
						{//CPD-逾期天数
							title :'<spring:message code="mulctDef.cpdOverDays" text="CPD-逾期天数" />',
							data : 'cpdOverDays'
						},
						{//罚金列表-罚金金额
							title : '<spring:message code="mulctDef.mulctOverAmt" text="罚金列表-罚金金额" />',
							data : 'mulctOverAmt'
						},
						{//罚金列表-罚金费率
							title : '<spring:message code="mulctDef.mulctOverRate" text="罚金列表-罚金费率" />',
							data : 'mulctOverRate'
						} ]
			},
			hideRefresh : true,
			checkbox : true,//是否显示选择框
			singleCheck : false,//是否单选
			pkNames : ['id'],//表格数据主键名称
			editable : false, //编辑表格
			editColumns : {
				mulctOverDays : {
					type : 'text'
				},
				cpdOverDays : {
					type : 'text'
				},
				mulctOverAmt : {
					type : 'text'					
				},
				mulctOverRate : {
					type : 'text'					
				}
			}
		}
	);
	
	grid.getTable().rows.add(list).draw();
	</script>
	
</body>
</html>