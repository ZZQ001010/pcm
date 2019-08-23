<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<title><spring:message code="assetSideInfo.query.title" text="资产方基本信息
查询" /></title>
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
						<form:form class="form-search form-horizontal form-label-left" datatable-target="assetSideInfo_datatable" modelAttribute="assetSideInfo">
							<div class="form-group">
								<label class="control-label col-lg-1 col-md-2 col-sm-6 col-xs-12" for="assetSideCode">
									<spring:message code="assetSideInfo.assetSideCode" text="资产方编码" />
									:
								</label>
								<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
									<form:input cssClass="form-control" type="text" path="assetSideCode"  data-rule-required="true" data-rule-maxlength="32" />
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
								<table id="assetSideInfo_datatable" class="datatable table table-hover table-striped table-bordered">
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
	<k:access code="assetSideInfo_add" var="addUrl"/>
	<k:access code="assetSideInfo_edit" var="editUrl"/>
	<k:access code="assetSideInfo_delete" var="delUrl"/>
	<!-- 创建datatable表格 -->
	<script type="text/javascript">
		var pkNames = [];
		var columns = [];
		pkNames.push("assetSideCode");
		columns.push({ title: '<spring:message code="assetSideInfo.assetSideCode" text="资产方编码" />', data: 'assetSideCode'});
		columns.push({ title: '<spring:message code="assetSideInfo.assetSideDesc" text="资产方描述" />', data: 'assetSideDesc'});
		<%--columns.push({ title: '<spring:message code="assetSideInfo.assetSideType" text="资产方类型" />', data: 'assetSideType',--%>
			<%--render : function(data, type, row, meta) {--%>
				<%--return ${assetSideTypeJson}[data];--%>
			<%--}--%>
		<%--});--%>
		columns.push({ title: '<spring:message code="assetSideInfo.assetSideWarrantWay" text="资产方担保方式" />', data: 'assetSideWarrantWay',
			render : function(data, type, row, meta) {
				return ${assetSideWarrantWayJson}[data];
			}
		});
/* 		columns.push({ title: '<spring:message code="assetSideInfo.phone1" text="联系电话1" />', data: 'phone1'});
		columns.push({ title: '<spring:message code="assetSideInfo.linkman1" text="联系人1" />', data: 'linkman1'});
		columns.push({ title: '<spring:message code="assetSideInfo.fax" text="传真" />', data: 'fax'});
		columns.push({ title: '<spring:message code="assetSideInfo.email" text="电子邮箱" />', data: 'email'}); */
		columns.push({ title: '<spring:message code="assetSideInfo.companyName" text="名称" />', data: 'companyName'});
		columns.push({ title: '<spring:message code="assetSideInfo.registrationAuthority" text="登记机关" />', data: 'registrationAuthority'});
		columns.push({ title: '<spring:message code="assetSideInfo.registerDate" text="成立时间" />', data: 'registerDate',
			type : 'date',
			render : function(data, type, row, meta) {
				return $K.date.format(data, "date");
			}
		});
		columns.push({ title: '<spring:message code="assetSideInfo.unifySocialCreditCode" text="统一社会信用代码" />', data: 'unifySocialCreditCode'});
		columns.push({ title: '<spring:message code="assetSideInfo.companyType" text="类型" />', data: 'companyType',
			render : function(data, type, row, meta) {
				return ${companyTypeJson}[data];
			}
		});
		columns.push({ title: '<spring:message code="assetSideInfo.businessBeginDate" text="营业期限有限期起始日期" />', data: 'businessBeginDate',
			type : 'date',
			render : function(data, type, row, meta) {
				return $K.date.format(data, "date");
			}
		});
		columns.push({ title: '<spring:message code="assetSideInfo.businessEndDate" text="营业期限有限期截止日期" />', data: 'businessEndDate',
			type : 'date',
			render : function(data, type, row, meta) {
				return $K.date.format(data, "date");
			}
		});
		/* columns.push({ title: '<spring:message code="assetSideInfo.businessLicenseNumber" text="营业执照号码" />', data: 'businessLicenseNumber'});
		columns.push({ title: '<spring:message code="assetSideInfo.paidInCapital" text="实收资本" />', data: 'paidInCapital'});
		columns.push({ title: '<spring:message code="assetSideInfo.legalPerson" text="法定代表人" />', data: 'legalPerson'});
		columns.push({ title: '<spring:message code="assetSideInfo.registerMoney" text="注册资本" />', data: 'registerMoney'}); */
		columns.push({ title: '<spring:message code="assetSideInfo.register" text="登记时间" />', data: 'register',
			type : 'date',
			render : function(data, type, row, meta) {
				return $K.date.format(data, "date");
			}
		});
/* 		columns.push({ title: '<spring:message code="assetSideInfo.residence" text="住所" />', data: 'residence'});
		columns.push({ title: '<spring:message code="assetSideInfo.businessScope" text="经营范围" />', data: 'businessScope',
			type : 'date',
			render : function(data, type, row, meta) {
				return $K.date.format(data, "date");
			}
		}); */
		var grid = $("#assetSideInfo_datatable").grid({
			datatable : {
	          	ajax: {
	  				url: "${ctx}/assetSideInfo/queryAssetSideInfoList.in",
	  				method: "post",
	  				data: function(d) {
						d.assetSideCode = $("#assetSideCode").val();
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
			$K.frame.loadPage("${ctx}/assetSideInfo/assetSideInfoDetailPage.in?" + params.join("&"), grid);
		}
		grid.dbClick(dbclick);
	</script>
	<!-- 权限单元-控制代码块 -->
</body>	
</html>