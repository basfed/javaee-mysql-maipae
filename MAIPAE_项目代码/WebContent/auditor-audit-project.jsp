<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
        <title>审核建设项目工程 - MAIPAE - 建筑工程多主体交互平台</title>
        <meta name="keywords" content="MAIPAE,maipae,建筑工程多主体交互平台">
        <meta name="description" content="建筑工程多主体交互平台（MAIPAE）主要通过对建筑工程各责任主体进行质量监督。主要包括工程报监督、工程监督、竣工备案构成。">
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui">
        <base href="<%=request.getContextPath() %>/">
        <meta name="author" content="兰必钟（Basfed Lan）, http://www.basfed.com">
        <meta name="robots" content="index, follow">
        <link rel="shortcut icon" href="images/maipae-logo.png">
        <link rel="stylesheet" href="css/material.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <%
    		request.setCharacterEncoding("utf-8");
    		
    		session = request.getSession(true);//获取会话对象
    		String personIdentity = (String)session.getAttribute("PERSON_Identity");//从会话中获取人员身份
    		
    		if(personIdentity == null || !(personIdentity.equals("报监审核员"))){
                response.sendRedirect("index.jsp");
            }
        %>
        <div class="maipae-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
            <header class="mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600" role="banner">
                <div class="mdl-layout__header-row">
                    <span class="mdl-layout-title">报监审核员 - 审核建设项目工程</span>
                    <div class="mdl-layout-spacer"></div>
                    <%@ include file="sub-nav.jsp" %>
                    <a class="mdl-navigation__link is-active" href="AuditorServlet?page=auditor-index">报监审查</a>
                </nav>
                <footer class="footer mdl-color-text--blue-grey-100" role="contentinfo">
                    <p>© 2016 MAIPAE</p>
                </footer>
            </div>
            <main class="mdl-layout__content mdl-color--grey-100" role="main">
                <!-- 主要内容 -->
                <section class="section">
                    <div class="mdl-grid page-main mdl-shadow--2dp">
                        <header class="page-header">
                            <h1>建设项目工程信息（审核的）</h1>
                        </header>
                        <div class="page-content mdl-cell mdl-cell--12-col">
                            <form class="page-form form-cell--4-col">
                            <c:forEach items="${projectDetail}" var="pd">
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="text" name="projectName" value="${pd.projectName }" readonly="readonly" id="projectName">
                                    <label class="mdl-textfield__label" for="projectName">项目名</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                	<input class="mdl-textfield__input" type="text" name="belongStations" value="${pd.belongStations }" readonly="readonly" id="belongStations">
                                    <label class="mdl-textfield__label" for="belongStations">质监站属地</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                	<input class="mdl-textfield__input" type="text" name="stationName" value="${pd.stationName }" readonly="readonly" id="stationName">
                                    <label class="mdl-textfield__label" for="stationName">质监站名称</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="text" name="projectStartTime" value="${pd.projectStartTime }" readonly="readonly" id="projectStartTime">
                                    <label class="mdl-textfield__label" for="projectStartTime">项目开始时间</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="text" name="projectEndTime" value="${pd.projectEndTime }" readonly="readonly" id="projectEndTime">
                                    <label class="mdl-textfield__label" for="projectEndTime">项目结束时间</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                	<input class="mdl-textfield__input" type="text" name="monitorState" value="${pd.monitorState }" readonly="readonly" id="monitorState">
                                    <label class="mdl-textfield__label" for="monitorState">报监状态</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="text" name="projectFiles" value="${pd.projectFiles }" readonly="readonly" id="projectFiles">
                                    <label class="mdl-textfield__label" for="projectFiles">项目资料</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                	<input class="mdl-textfield__input" type="text" name="remarks" value="${pd.remarks }" readonly="readonly" id="remarks">
                                    <label class="mdl-textfield__label" for="remarks">备注</label>
                                </div>
                            </c:forEach>
                            </form>
                        </div>
                    </div>
                    <div class="mdl-grid page-main mdl-shadow--2dp">
                        <header class="page-header">
                            <h1>报监，修改报监状态</h1>
                        </header>
                        <div class="page-content mdl-cell mdl-cell--12-col">
                            <form action="AuditorServlet?type=reviewProject" method="POST" class="page-form form-cell--6-col">
                            	<input type="hidden" name="projectID" value="${projectID}">
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <span class="maipae-radio-title">报监结果</span>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="option-1">
                                        <input type="radio" id="option-1" class="mdl-radio__button" name="state" value="通过">
                                        <span class="mdl-radio__label">通过</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="option-2">
                                        <input type="radio" id="option-2" class="mdl-radio__button" name="state" value="不通过">
                                        <span class="mdl-radio__label">不通过</span>
                                </div>
                                <p>
                                    <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit">
                                        提交
                                    </button>
                                </p>
                            </form>
                        </div>
                    </div>
                </section>
            </main>
        </div>
        <script src="js/material.min.js"></script>
    </body>
</html>