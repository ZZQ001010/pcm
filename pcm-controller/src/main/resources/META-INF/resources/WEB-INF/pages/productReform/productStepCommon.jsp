<%@ page contentType="text/html;charset=UTF-8" %>
<form:form cssClass="form-horizontal form-product" id="productStepCommon" cssStyle="padding-top: 20px" modelAttribute="product">
    <div class="form-group row">
        <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label required-star">
            <spring:message code="product.productCode" text="产品代码"/>:
        </label>
        <div class="col-lg-2 col-md-4 col-sm-4 col-xs-4">
            <form:input cssClass="form-control" path="productCode" data-rule-required="true" data-rule-maxlength="15"/>
        </div>
        <div class="hide desc">
            <spring:message code="product.productCode.desc"/>
        </div>
        
        <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label required-star">
            <spring:message code="product.productType" text="产品类型"/>:
        </label>
        <div class="col-lg-2 col-md-4 col-sm-4 col-xs-4">
<%--           <form:select cssClass="form-control" path="productType" data-rule-required="true">
            		<option value=""><spring:message code="kite.web.common.pleaseChoose" text="--请选择--"/></option>
                <form:options items="${productTypeMap}"/>
            </form:select> --%>
            <!-- 这个地方应该是一个树形选择框 -->
             <form:input cssClass="form-control" readonly="true" path="groupType" data-rule-required="true" />
        </div>
        <div class="hide desc">
            <spring:message code="product.productType.desc"/>
        </div>
    </div>
    
    


	<div class="form-group row">
		<!-- BIN -->
		<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
			<span class="span-icon">*&nbsp;</span> <spring:message
				code="product.bin" text="BIN" /> :
		</label>
		<div class="col-lg-2 col-md-4 col-sm-4 col-xs-4">
			<form:input cssClass="form-control" path="bin"
				data-rule-maxlength="40" data-rule-required="true"  />
		</div>
		<!-- BIN描述 -->
		<div class="hide desc" for="bin">
			<spring:message code="bin" />
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
								<form:options items="${isPbocInfoMerged}" />
							</form:select>
						</div>
						<!-- 人行记录是否合并描述 -->
						<div class="hide desc">
							<spring:message code="product.isPbocInfoMerged.desc" />
						</div>
					</div>

    <div class="form-group row">
        <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
            <spring:message code="product.description" text="产品描述"/>
            :
        </label>
        <div class="col-lg-6 col-md-10 col-sm-10 col-xs-10">
            <form:textarea cssClass="form-control" path="description" rows="4" data-rule-maxlength="200"></form:textarea>
        </div>
        <div class="hide desc">
            <spring:message code="product.description.desc"/>
        </div>
    </div>
</form:form>


