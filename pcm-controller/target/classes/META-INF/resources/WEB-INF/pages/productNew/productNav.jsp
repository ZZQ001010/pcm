<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><spring:message code="product.add.title" text="产品参数管理新增"/></title>
    <!-- 引入css样式和部分js -->
    <link rel="stylesheet" type="text/css" href="${ctxStatic}/css/kite.home.partition.css"/>
    <%@ include file="/common/head.jsp" %>
</head>
<!-- 整体皮肤样式 -->
<body class="${param.skin}">
<div id="wizard_verticle" class="form_wizard wizard_verticle">
    <ul class="list-unstyled wizard_steps anchor">
        <li>
            <a href="#step-11" class="done" isdone="1" rel="1">
                <span class="step_no">1</span>
            </a>
        </li>
        <li>
            <a href="#step-22" class="done" isdone="1" rel="2">
                <span class="step_no">2</span>
            </a>
        </li>
        <li>
            <a href="#step-33" class="selected" isdone="1" rel="3">
                <span class="step_no">3</span>
            </a>
        </li>
        <li>
            <a href="#step-44" class="disabled" isdone="0" rel="4">
                <span class="step_no">4</span>
            </a>
        </li>
    </ul>


    <div class="stepContainer" style="height: 211px;">
        <div id="step-11" class="content" style="display: none;">
            <h2 class="StepTitle">Step 1 Content</h2>
            <form class="form-horizontal form-label-left">

                <span class="section">Personal Info</span>

                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3" for="first-name">First Name <span
                            class="required">*</span>
                    </label>
                    <div class="col-md-6 col-sm-6">
                        <input type="text" id="first-name2" required="required" class="form-control col-md-7 col-xs-12">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3" for="last-name">Last Name <span
                            class="required">*</span>
                    </label>
                    <div class="col-md-6 col-sm-6">
                        <input type="text" id="last-name2" name="last-name" required="required"
                               class="form-control col-md-7 col-xs-12">
                    </div>
                </div>
                <div class="form-group">
                    <label for="middle-name" class="control-label col-md-3 col-sm-3">Middle Name / Initial</label>
                    <div class="col-md-6 col-sm-6">
                        <input id="middle-name2" class="form-control col-md-7 col-xs-12" type="text" name="middle-name">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3">Gender</label>
                    <div class="col-md-6 col-sm-6">
                        <div id="gender2" class="btn-group" data-toggle="buttons">
                            <label class="btn btn-default" data-toggle-class="btn-primary"
                                   data-toggle-passive-class="btn-default">
                                <input type="radio" name="gender" value="male"> &nbsp; Male &nbsp;
                            </label>
                            <label class="btn btn-primary" data-toggle-class="btn-primary"
                                   data-toggle-passive-class="btn-default">
                                <input type="radio" name="gender" value="female" checked=""> Female
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3">Date Of Birth <span class="required">*</span>
                    </label>
                    <div class="col-md-6 col-sm-6">
                        <input id="birthday2" class="date-picker form-control col-md-7 col-xs-12" required="required"
                               type="text">
                    </div>
                </div>

            </form>
        </div>
        <div id="step-22" class="content" style="display: none;">
            <h2 class="StepTitle">Step 2 Content</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
                ex ea commodo consequat.
                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
                Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est
                laborum.
            </p>
            <p>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
                ex ea commodo consequat. Duis aute irure dolor
                in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            </p>
            <p>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
                ex ea commodo consequat. Duis aute irure dolor
                in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            </p>
            <p>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
                ex ea commodo consequat. Duis aute irure dolor
                in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            </p>
            <p>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
                ex ea commodo consequat. Duis aute irure dolor
                in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            </p>
        </div>
        <div id="step-33" class="content" style="display: block;">
            <h2 class="StepTitle">Step 3 Content</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
                ex ea commodo consequat.
                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
                Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est
                laborum.
            </p>
            <p>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
                ex ea commodo consequat. Duis aute irure dolor
                in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            </p>
        </div>
        <div id="step-44" class="content" style="display: none;">
            <h2 class="StepTitle">Step 4 Content</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
                ex ea commodo consequat.
                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
                Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est
                laborum.
            </p>
            <p>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
                ex ea commodo consequat. Duis aute irure dolor
                in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            </p>
            <p>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
                ex ea commodo consequat. Duis aute irure dolor
                in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            </p>
        </div>
    </div>
    <div class="actionBar">
        <div class="msgBox">
            <div class="content"></div>
            <a href="#" class="close">X</a></div>
        <div class="loader">Loading</div>
        <a href="#" class="buttonFinish buttonDisabled btn btn-default">Finish</a><a href="#"
                                                                                     class="buttonNext btn btn-success">Next</a><a
            href="#" class="buttonPrevious btn btn-primary">Previous</a></div>
</div>
<!-- 引入js文件-->
<%@ include file="/common/foot.jsp" %>
<script>

</script>
</body>
</html>