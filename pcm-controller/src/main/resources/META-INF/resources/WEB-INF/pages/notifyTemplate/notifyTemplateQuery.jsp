<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<title><spring:message code="notifyTemplate.query.title" text="通知模板管理查询" /></title>
<!-- 引入css样式和部分js -->
<%@ include file="/common/head.jsp"%>
</head>
<body class="${param.skin}">
	<!-- 整体皮肤样式 -->
	<div class="container">
		<div class="row" style="margin: 0px;">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="padding: 0px;">
				<div class="x_panel">
					<div class="x_content">
						<!-- datatable-target="(table-id)" 配置查询表单关联对应的datatable数据表格 -->
						<form:form class="form-search form-horizontal form-label-left" datatable-target="notifyTemplate_datatable" modelAttribute="notifyTemplate">
							<div class="form-group">
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="notifyCode">
									<spring:message code="notifyTemplate.notifyCode" text="通知代码" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="notifyCode"  data-rule-required="true" data-rule-maxlength="80" />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="cooperationChannel">
									<spring:message code="notifyTemplate.cooperationChannel" text="合作机构" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="cooperationChannel"  data-rule-maxlength="80" />
								</div>
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="messageType">
									<spring:message code="notifyTemplate.messageType" text="报文类型" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:select cssClass="form-control" path="messageType">
										<option value=""><spring:message code="kite.web.common.pleaseChoose"  text="--请选择--" /></option>
										<form:options items="${messageType}" />
									</form:select>
								</div>
							</div>
							<div class="form-controls">
								<div class="btn-group-sm">
									<!-- grid-search,点击该按钮自动查询form[datatable-target]对应的数据 -->
									<button class="btn btn-success grid-search" type="button">
										<!-- 查询 -->
										<i class="fa fa-search"></i>
										<spring:message code="kite.web.common.btnCheck" text="查询" />
									</button>
									<button class="btn btn-primary" type="reset">
										<!-- 重置-->
										<i class="fa fa-refresh"></i>
										<spring:message code="kite.web.common.btnReset" text="重置" />
									</button>
								</div>
							</div>
						</form:form>
						
						<!-- 表格数据展示区域 -->
						<div class="responsive-table">
							<div class="scrollable-area">
								<table id="notifyTemplate_datatable" class="datatable table table-hover table-striped table-bordered">
								</table>
							</div>
						</div>
					</div><!-- x_content -->
				</div><!-- x_panel-->
			</div><!-- col-12 -->
		</div>
	</div>
	<!-- 引入js -->
	<%@ include file="/common/foot.jsp"%>
	<!-- 权限单元-控制js变量 -->
	<k:access code="notifyTemplate_add" var="addUrl"/>
	<k:access code="notifyTemplate_edit" var="editUrl"/>
	<k:access code="notifyTemplate_delete" var="delUrl"/>
	<!-- 创建datatable表格 -->
	<script type="text/javascript">
		var pkNames = [];
		var columns = [];
		pkNames.push("notifyCode");
		columns.push({ title: '<spring:message code="notifyTemplate.notifyCode" text="通知代码" />', data: 'notifyCode'});
		columns.push({ title: '<spring:message code="notifyTemplate.cooperationChannel" text="合作机构" />', data: 'cooperationChannel'});
		columns.push({ title: '<spring:message code="notifyTemplate.sendUrl" text="发送地址" />', data: 'sendUrl'});
		columns.push({ title: '<spring:message code="notifyTemplate.messageType" text="报文类型" />', data: 'messageType',
			render : function(data, type, row, meta) {
				return ${messageTypeJson}[data];
			}
		});
		columns.push({ title: '<spring:message code="notifyTemplate.isRepeat" text="是否需要重发" />', data: 'isRepeat',
			render : function(data, type, row, meta) {
				if(data == 'Y'){
					if("${pageContext.response.locale}"=="zh_CN"){
						return "是";
						}else{
							return "Yes";
						}
				}else{
					if("${pageContext.response.locale}"=="zh_CN"){
						return "否";
						}else{
							return "No";
						}
				}
			}});
		columns.push({ title: '<spring:message code="notifyTemplate.repeatInterval" text="重发时间间隔" />', data: 'repeatInterval'});
		columns.push({ title: '<spring:message code="notifyTemplate.maxRepeat" text="重发次数上限" />', data: 'maxRepeat'});
		columns.push({ title: '<spring:message code="notifyTemplate.sendTimeLapse" text="发送延时时间" />', data: 'sendTimeLapse'});
		columns.push({ title: '<spring:message code="notifyTemplate.transportProtocol" text="传输协议" />', data: 'transportProtocol',
			render : function(data, type, row, meta) {
				return ${transportProtocolJson}[data];
			}
		});
		columns.push({ title: '<spring:message code="notifyTemplate.respCode" text="响应码" />', data: 'respCode'});
		columns.push({ title: '<spring:message code="notifyTemplate.respValue" text="响应值" />', data: 'respValue'});
		columns.push({ title: '<spring:message code="notifyTemplate.noticeName" text="通知名称" />', data: 'noticeName'});
		var grid = $("#notifyTemplate_datatable").grid({
			datatable : {
	          	ajax: {
	  				url: "${ctx}/notifyTemplate/queryNotifyTemplateList.in",
	  				method: "post",
	  				data: function(d) {
						d.notifyCode = $("#notifyCode").val();
						d.cooperationChannel = $("#cooperationChannel").val();
						d.messageType = $("#messageType").val();
	  				}
	  			},
	  			columns: columns
	  		},
	        addUrl:addUrl,//新增页面url
	        updateUrl:editUrl,//修改页面url
	        deleteUrl:delUrl,//删除数据url
	        pkNames:pkNames//表格数据主键字段名称
		});
	    var dbclick = function(rowIndex, rowData, rowObj) {
	    	var params = [];
	    	for(var i in pkNames){
	    		if(pkNames[i] && rowData[pkNames[i]]){
	    			params.push(pkNames[i] + "=" + rowData[pkNames[i]]);
	    		}
	    	}
			$K.frame.loadPage("${ctx}/notifyTemplate/notifyTemplateDetailPage.in?" + params.join("&"), grid);
		}
		grid.dbClick(dbclick); 
	</script>
	<!-- 权限单元-控制代码块 -->
</body>	
</html>