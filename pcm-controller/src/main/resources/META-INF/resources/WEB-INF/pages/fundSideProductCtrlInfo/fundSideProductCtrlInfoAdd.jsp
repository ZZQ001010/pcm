<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="fundSideProductCtrlInfo.add.title" text="资金方产品经营控制
新增" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
	<link rel="stylesheet" type="text/css" href="${ctx }/static/plugins/jquery_datetime/css/normalize.css" />
	<style type="text/css">
		.dateTimeInput{
			width: 80px;
		}
	</style>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
	<!-- data-confirm=true 提交前需要确认 -->
	<form:form cssClass="form-horizontal" id="fundSideProductCtrlInfoAddForm" cssStyle="padding-top: 40px" modelAttribute="fundSideProductCtrlInfo" method="post" action="${ctx}/fundSideProductCtrlInfo/addFundSideProductCtrlInfo.in" data-confirm="true">
		<div class="form-group row">
			<!-- 资金方管控编码 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="fundSideProductCtrlInfo.fundSideCtrlCode" text="资金方管控编码" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="fundSideCtrlCode"  data-rule-required="true" data-rule-maxlength="12" />
			</div>
		</div>
		<div class="form-group row">
			<!-- 资金方管控描述 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<span class="span-icon">*&nbsp;</span>
				<spring:message code="fundSideProductCtrlInfo.fundSideCtrlDesc" text="资金方管控描述" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<form:input cssClass="form-control" type="text" path="fundSideCtrlDesc"  data-rule-required="true" />
			</div>
		</div>
        <div class="form-group row">
            <!-- 资金方编码 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <span class="span-icon">*&nbsp;</span>
                <spring:message code="fundSideProductCtrlInfo.fundSideCode" text="资金方编码" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:select cssClass="form-control" path="fundSideCode" id="fundSideCode">
                	<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
                    <form:options items="${fundSideCode}" />
                </form:select>
            </div>
        </div>
        <div class="form-group row">
            <!-- 资金方支持展业省份 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="fundSideProductCtrlInfo.fundSideProv" text="资金方支持展业省份" />
                :
            </label>
            <div class="col-lg-7 col-md-7  col-sm-6 col-xs-6">
                <form:select cssClass="form-control" path="fundSideProv" id="fundSideProv">
                    <option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
                    <form:options items="${fundSideProv}" />
                </form:select>
            </div>
        </div>
        
        
        <div class="form-group row">
            <!-- 资金方支持展业城市 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="fundSideProductCtrlInfo.fundSideCity" text="资金方支持展业城市" />
                :
            </label>
            <div id="cityBox" class="col-lg-7 col-md-7  col-sm-6 col-xs-12" >
                <form:select cssClass="form-control" path="fundSideCity" id="fundSideCity" name="fundSideCity">
                    <option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
                    <form:options items="${fundSideCity}" />
                </form:select>
            </div>
        </div>
        
          <div class="form-group row">
            <!-- 资金方支持展业区、县 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="fundSideProductCtrlInfo.fundSideDistrict" text="资金方支持展业区、县" />
                :
            </label>
            <div id="districtBox" class="col-lg-7 col-md-7  col-sm-6 col-xs-12" >
                <form:select cssClass="form-control" path="fundSideDistrict" id="fundSideDistrict" name="fundSideDistrict">
                    <option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
                   <%--  <form:options items="${fundSideCity}" /> --%>
                </form:select>
            </div>
        </div>
        
        
        
        
        
        
        <div class="form-group row">
            <!-- 资金方申请行业范围 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="fundSideProductCtrlInfo.fundSideBusinessScope" text="资金方申请行业范围" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:select cssClass="form-control" path="fundSideBusinessScope">
                    <form:options items="${fundSideBusinessScopes}" />
                </form:select>
            </div>
        </div>
        <div class="form-group row">
            <!-- 资金方申请职业范围 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="fundSideProductCtrlInfo.fundSideProfessionScope" text="资金方申请职业范围" />
                :
            </label>
            <div class="col-lg-7 col-md-7  col-sm-6 col-xs-6">
                <form:select cssClass="form-control" multiple="multiple" path="fundSideProfessionScope" id="fundSideProfessionScope">
                    <option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
                    <form:options items="${fundSideProfessionScopes}" />
                </form:select>
            </div>
        </div>
        <div class="form-group row">
            <!-- 资金方申请年龄范围 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="fundSideProductCtrlInfo.applicantsAgeRange" text="资金方申请年龄范围" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:input cssClass="form-control" type="text" path="applicantsAgeRange"  data-rule-required="false" data-rule-maxlength="12" />
            </div>
        </div>
        <div class="form-group row">
            <!-- 资金方专项资产方 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="fundSideProductCtrlInfo.fundSideInfo" text="资金方专项资产方" />
                :
            </label>
            <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
                <form:select cssClass="form-control" path="fundSideInfo">
                	<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
                    <form:options items="${assetFundSideCode}" />
                </form:select>
            </div>
        </div>
        <div class="form-group row">
            <!-- 资金方是否支持部分还款 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="fundSideProductCtrlInfo.fundSidePartRepay" text="资金方是否支持部分还款" />
                :
            </label>
            <div class="col-lg-7 col-md-7  col-sm-6 col-xs-6">
                <form:select cssClass="form-control" path="fundSidePartRepay" id="fundSidePartRepay">
                    <option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
                    <form:options items="${fundSidePartRepay}" />
                </form:select>
            </div>
        </div>
        <div class="form-group row">
			<!-- 资金方支持还款日区间 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="fundSideProductCtrlInfo.fundSideProductDuedayCR" text="资金方支持还款日区间" />
				:
			</label>
			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
				<form:input class='form-control customize-date-range' type="text" data-picker-position="bottom-right" data-role-formate="dd" path="fundSideProductDuedayCR" onfocus="this.blur()" />
				<i class="fa fa-calendar input_date" ></i>
			</div>
		</div>
		<div class="form-group row">
			<!-- 资金方产品-工作日支持征信时间段 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="fundSideProductCtrlInfo.fundSideProductWorkdayCR" text="资金方产品-工作日支持征信时间段" />
			</label>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
				 <form:input    path="fundSideProductWorkdayCRStart" class="time form-control dateTimeInput" type="text"     />
				<span> - </span>
				 <form:input    path="fundSideProductWorkdayCREnd"  class="time form-control dateTimeInput" type="text"    />
			</div>
			
			<!-- 资金方产品-节假日支持征信时间段 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label" style="margin-left:110px">
				<spring:message code="fundSideProductCtrlInfo.fundSideProductHolidaysCR" text="资金方产品-节假日支持征信时间段" />
			</label>
			
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
				 <form:input    path="fundSideProductHolidaysCRStart" class="time form-control dateTimeInput" type="text"     />
				<span> - </span>
				 <form:input    path="fundSideProductHolidaysCREnd"  class="time form-control dateTimeInput" type="text"    />
			</div>
			
		</div>
		<div class="form-group row">
			<!-- 资金方产品-工作日支持授信时间段 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="fundSideProductCtrlInfo.fundSideProductWorkdaySX" text="资金方产品-工作日支持授信时间段" />
			</label>
			
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
				 <form:input    path="fundSideProductWorkdaySXStart" class="time form-control dateTimeInput" type="text"     />
				<span> - </span>
				 <form:input    path="fundSideProductWorkdaySXEnd"  class="time form-control dateTimeInput" type="text"    />
			</div>
			
			<!-- 资金方产品-节假日支持授信时间段 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label" style="margin-left:110px">
				<spring:message code="fundSideProductCtrlInfo.fundSideProductHolidaysSX" text="资金方产品-节假日支持授信时间段" />
			</label>
			
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
				 <form:input    path="fundSideProductHolidaysSXStart" class="time form-control dateTimeInput" type="text"     />
				<span> - </span>
				 <form:input    path="fundSideProductHolidaysSXEnd"  class="time form-control dateTimeInput" type="text"    />
			</div>
			
		</div>
		<div class="form-group row">
			<!-- 资金方产品-工作日支持放款时间段 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="fundSideProductCtrlInfo.fundSideProductWorkdayFK" text="资金方产品-工作日支持放款时间段" />
			</label>
			
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
				 <form:input    path="fundSideProductWorkdayFKStart" class="time form-control dateTimeInput" type="text"     />
				<span> - </span>
				 <form:input    path="fundSideProductWorkdayFKEnd"  class="time form-control dateTimeInput" type="text"    />
			</div>
			
			<!-- 资金方产品-节假日支持放款时间段 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label" style="margin-left:110px">
				<spring:message code="fundSideProductCtrlInfo.fundSideProductHolidaysFK" text="资金方产品-节假日支持放款时间段" />
			</label>
			
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
				 <form:input    path="fundSideProductHolidaysFKStart" class="time form-control dateTimeInput" type="text"     />
				<span> - </span>
				 <form:input    path="fundSideProductHolidaysFKEnd"  class="time form-control dateTimeInput" type="text"    />
			</div>
			
		</div>
		<div class="form-group row">
			<!-- 资金方产品-工作日支持还款时间段 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="fundSideProductCtrlInfo.fundSideProductWorkdayHK" text="资金方产品-工作日支持还款时间段" />
			</label>
			
			
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
				 <form:input    path="fundSideProductWorkdayHKStart" class="time form-control dateTimeInput" type="text"     />
				<span> - </span>
				 <form:input    path="fundSideProductWorkdayHKEnd"  class="time form-control dateTimeInput" type="text"    />
			</div>
			
			
			<!-- 资金方产品-节假日支持还款时间段 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label" style="margin-left:110px">
				<spring:message code="fundSideProductCtrlInfo.fundSideProductHolidaysHK" text="资金方产品-节假日支持还款时间段" />
			</label>
			
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
				 <form:input    path="fundSideProductHolidaysHKStart" class="time form-control dateTimeInput" type="text"     />
				<span> - </span>
				 <form:input    path="fundSideProductHolidaysHKEnd"  class="time form-control dateTimeInput" type="text"    />
			</div>
			
		</div>
		 <div class="form-group row">
			<!-- 资金方产品-当日还款截止时间 -->
			<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
				<spring:message code="fundSideProductCtrlInfo.fundSideProductDueDayPayOver" text="资金方产品-当日还款截止时间" />
				:
			</label>
			<div class="col-lg-7 col-md-7  col-sm-6 col-xs-6" >
				<!-- data-picker-position="top-right/top-left/bottom-right/bottom-left"  -->
				 <form:input  style="width:100%"   path="fundSideProductDueDayPayOver" class="time form-control dateTimeInput" type="text"     />
			</div>
		</div>
		<div class="form-group row">
           <!-- 资金方征信评分卡标识 -->
            <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
                <spring:message code="fundSideProductCtrlInfo.fundSideCreditCardCode" text="资金方征信评分卡标识" />
                :
            </label>
            <div class="col-lg-7 col-md-7  col-sm-6 col-xs-6">
                <form:select cssClass="form-control" path="fundSideCreditCardCode" id="fundSideCreditCardCode">
                    <option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--" /></option>
                    <form:options items="${fundSideCreditCardCode}" />
                </form:select>
            </div>
        </div>
       
		<div class="form-controls auto-float">
			<div class="btn-group-md">
				<!-- 确定 -->
				<input type="submit" class="btn-primary btn" onclick="funCode()" value="<spring:message code='kite.web.common.btnSure' text='确定' />" />
				<!-- 返回 -->
				<input type="button" class="btn-default btn only-slide-out" value="<spring:message code='kite.web.common.btnBack' text='返回' />" />
			</div>
		</div>
	</form:form>
	<!-- 引入js文件-->
	<%@ include file="/common/foot.jsp"%>
	<script type="text/javascript">
		function funCode(){
			var code=$("#fundSideCode").val();
			debugger
			if(code==""){
				 layer.msg("资金方编码不能为空");
			}
		}
		//开启表单验证
		$("#fundSideProductCtrlInfoAddForm").validate();
		
        $("#fundSideProv").on("change",
                function() {
                    $.ajax({
                            type : "post",
                            url : "${ctx}/webCommon/loadCity.in ",
                            cache : false,
                            //async : false,
                            data : $("#fundSideProv").val(),
                            dataType : "json",
                            contentType : "application/json",
                            success : function(data) {
                                $("#cityBox").empty();
                                $("#cityBox")
                                    .append(
                                        `<select id="fundSideCity" class="form-control" name="fundSideCity"><option value="">--- 请选择 --- </option></select>`);
                                for ( var key in data) {
                                    $("#fundSideCity").append(
                                        `<option value=`+key+`>`
                                        + data[key]
                                        + `</option>`);
                                }
                            }

                        });
                });
        

		$(document)
		.on(
				"change",
				"#fundSideCity",
				function() {
					$.ajax({
								type : "post",
								url : "${ctx}/webCommon/loadDistricts.in  ",
								cache : false,
								//async : false,
								data : $("#fundSideCity").val(),
								dataType : "json",
								contentType : "application/json",
								success : function(data) {
			
									 $("#districtBox").empty();
									$("#districtBox")
											.append(
													`<select id="fundSideDistrict" class="form-control" name="fundSideDistrict"><option value="">--- 请选择 --- </option></select>`);
									for ( var key in data) {
										$("#fundSideDistrict").append(
												`<option value=`+key+`>`
														+ data[key]
														+ `</option>`);
									} 
								}

							});
				});
		
	</script>
	
	<script type="text/javascript" src="${ctx }/static/plugins/jquery_datetime/js/jquery-clock-timepicker.min.js"></script>
    	<script type="text/javascript">
    		$(document).ready(function() {
    			$('.time').clockTimePicker({});
    			//
    			$('#fundSideProductDueDayPayOver').parent().css("width","100%")
    		});
    	</script>
</body>
</html>