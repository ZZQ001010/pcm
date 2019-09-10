<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="mulct.update.title" text="罚金利率修改" /></title>
<%@ include file="/common/head.jsp"%>
<style type="text/css">
.btn-group-sm {
	margin-left:10px;
}
</style>
</head>
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="mulctUpdForm" cssStyle="padding-top: 40px" modelAttribute="mulct" method="post" action="${ctx}/mulct/updMulct.in" data-confirm="true">
		<form:hidden path="mulctTableId" />
		<div class="form-group row">
			<!-- 罚金表id -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="mulct.mulctTableId" text="罚金表id" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="mulctTableId"  data-rule-required="true" data-rule-maxlength="6" readonly="true"/>
			</div>
			<!-- 罚金表id描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="mulct.mulctTableId.desc" />
			</div>
		</div>	
		<div class="form-group row">
			<!-- 罚金名称 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="mulct.mulctName" text="罚金名称" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="mulctName"  data-rule-required="true" data-rule-maxlength="50" />
			</div>
			<!-- 罚金名称描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="mulct.mulctName.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 罚金收取方式 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="mulct.mulctMethod" text="罚金收取方式" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="mulctMethod">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${mulctMethod}" />
				</form:select>
			</div>
			<!-- 罚金收取方式描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="mulct.mulctMethod.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 罚金计算方式 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="mulct.mulctCalMethod" text="罚金计算方式" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:select cssClass="form-control" path="mulctCalMethod">
					<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
					<form:options items="${mulctCalMethod}" />
				</form:select>
			</div>
			<!-- 罚金计算方式描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="mulct.mulctCalMethod.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 计息基准年 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="mulct.baseYear" text="计息基准年" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="baseYear"  data-rule-required="true" data-rule-digits="true" data-rule-min="0" data-rule-max="999" />
			</div>
			<!-- 计息基准年描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="mulct.baseYear.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 描述 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="mulct.description" text="描述" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="description"  data-rule-maxlength="200" />
			</div>
			<!-- 描述描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="mulct.description.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- CPD容差 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="mulct.cpdToleLmt" text="CPD容差" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="cpdToleLmt"  data-rule-number="true" data-rule-min="0" data-rule-max="9999999999999.99" />
			</div>
			<!-- CPD容差描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="mulct.cpdToleLmt.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- DPD容差 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="mulct.dpdToleLmt" text="DPD容差" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="dpdToleLmt"  data-rule-number="true" data-rule-min="0" data-rule-max="9999999999999.99" />
			</div>
			<!-- DPD容差描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<spring:message code="mulct.dpdToleLmt.desc" />
			</div>
		</div>				
		<div class="form-group row">
			<!-- 扣款延迟入账是否回溯罚金 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="mulct.isReviewMulct" text="扣款延迟入账是否回溯罚金" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<label class="col-lg-1 col-md-1 col-sm-1 col-xs-1 control-label">
					<input  type="checkbox" class="js-switch" unchecked/>
					<form:hidden path="isReviewMulct" value="${isReviewMulct}"/>	
				</label>		
			</div>
			<!-- 扣款延迟入账是否回溯罚金描述 -->
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 remark">
				<!-- <spring:message code="mulct.isReviewMulct.desc" /> -->
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
		<div class="cbtn-group-md">
			<!-- 确定 -->
			<input type="submit" id="submit" class="btn-primary btn" value="<spring:message code='kite.web.common.btnSure' text='确定' />" />
			<!-- 返回 -->
			<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='取消' />" />
		</div>
	</div>
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp"%>
	
	<script type="text/javascript">
	
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
			editable : true, //编辑表格
			editColumns : {
				mulctOverDays : {
					type : 'text',
					validate:function(val){
						return valid_Integer(val); 						 
					}
				},
				cpdOverDays : {
					type : 'text',
					validate:function(val){
						return valid_Integer(val); 						 
					}
				},
				mulctOverAmt : {
					type : 'text',
					validate:function(val){
						return validPrecisions(val);						 
					}
				},
				mulctOverRate : {
					type : 'text',
					validate:function(val){
						return validPrecision(val); 						 
					}
				}
			}
		}
	);
	//整数 
	function valid_Integer(val){
		if(!(new RegExp(/^[0-9]{0,3}$/g).test($.trim(val)))){
				return '<spring:message code="mulctDef.length" text="必须是小于四位的整数" />';
		}	
	} 
	//小数		
	function validPrecision(val){					
		if(!(new RegExp(/^(?=\d+.?\d+$)[\d.]{0,7}$/g).test($.trim(val)))){
			return '<spring:message code="mulctDef.digitalPrecisions" text="必须是长度小于7位的数" />';			
		}	
	}
	function validPrecisions(val){			
		if(!(new RegExp(/^(?=\d+.?\d+$)[\d.]{0,16}$/g).test($.trim(val)))){				
			return '<spring:message code="mulctDef.digitalPrecision" text="必须是长度小于16位的数 "/>';			
		}	
	}
		
	grid.getTable().rows.add(list).draw();
	
	var add = $("<button class='btn btn-success' ><i class='fa fa-plus'></i><spring:message code='kite.web.common.btnAdd' text='增加' /></button>")
	add.click(function(){
		grid.getTable().rows.add([{mulctOverDays:"",cpdOverDays:"",mulctOverAmt:"",mulctOverRate:""}]).draw();
		$("#mulctDefsStr").val(JSON.stringify(grid.getData()));
	});
	grid.addButton(add);
	
	var del = $("<button class='btn btn-success' ><i class='fa fa-trash'></i><spring:message code='kite.web.common.btnDel' text='删除' /></button>")
	del.click(function(){
		grid.getTable().rows('.row-selected').remove().draw();
		$("#mulctDefsStr").val(JSON.stringify(grid.getData()));
	});
	grid.addButton(del);
	
	/* var dbclick = function(rowIndex, rowData, rowObj) {
		$K.frame.loadPage("${ctx}/mulct/mulctDefEditPage.in?id=" + rowData.id, grid);
	}
	grid.dbClick(dbclick); */

	//开启表单验证
	$("#mulctUpdForm").validate();
	if($("#isReviewMulct").val() == "Y" || $("#isReviewMulct").val() == "是"){
		$("#isReviewMulct").parent().find('input[type=checkbox]').prop("checked",true);
	}
	$(function(){
		$(".js-switch").each(function(i,ck){
			$(this).change(function(){
				if($(this).is(":checked")){
					$(this).parent().find("input[type=hidden]").val('Y');
				}else{
					$(this).parent().find("input[type=hidden]").val('N');
				}
			});
		});
	})
		

	$("#submit").click(function(){
		if($("#mulctUpdForm").valid()){
			layer.confirm('<spring:message code="mulctDef.common.confirmsubmit" text="确定提交？" />', {icon: 3, title:'<spring:message code="kite.web.common.tip" text="提示" />',btn:["<spring:message code='kite.web.common.btnSure' text='确定' />","<spring:message code='kite.web.common.btnBack' text='取消' />"]},
				function(index){
					var vMulct={};
					var form = $('#mulctUpdForm').serializeArray();
					$.each(form, function() {
						vMulct[this.name] = this.value;
						});
					if(grid.getData().length>0){
						vMulct.mulctDefsStr=JSON.stringify(grid.getData());
					}
					$K.ajax({
						url:"${ctx}/mulct/updMulct.in",
						type:"post",
						contentType:"application/json;charset=utf-8",
						data:JSON.stringify(vMulct),
						success:function(data){
							$(".only-slide-out").click();
							layer.close(index);
						}
					})
				}
				
			);
	 	}
	});
	</script>

</body>

</html>