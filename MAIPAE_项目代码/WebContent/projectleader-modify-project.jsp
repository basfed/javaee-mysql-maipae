<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
        <title>修改建设项目工程 - MAIPAE - 建筑工程多主体交互平台</title>
        <meta name="keywords" content="MAIPAE,maipae,建筑工程多主体交互平台">
        <meta name="description" content="建筑工程多主体交互平台（MAIPAE）主要通过对建筑工程各责任主体进行质量监督。主要包括工程报监督、工程监督、竣工备案构成。">
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui">
        <base href="<%=request.getContextPath() %>/">
        <meta name="author" content="Java EE 第8组：兰必钟，黄惠清，郭昊，杨雯升，怀智博，丹增乔热">
        <meta name="robots" content="index, follow">
        <link rel="shortcut icon" href="images/maipae-logo.png">
        <link rel="stylesheet" href="css/material.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
    	<%
    		request.setCharacterEncoding("utf-8");
    		
    		session = request.getSession(true);//获取会话对象
    		Integer personID = (Integer)session.getAttribute("PERSON_ID");//从会话中获取人员ID
    		String personIdentity = (String)session.getAttribute("PERSON_Identity");//从会话中获取人员身份
    		Integer enterpriseid = (Integer)session.getAttribute("PERSON_EnterpriseID");//从会话中获取各责任主体ID
    		
    		if(personIdentity == null || !(personIdentity.equals("建设项目负责人"))){
                response.sendRedirect("index.jsp");
            }
        %>
        <div class="maipae-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
            <header class="mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600" role="banner">
                <div class="mdl-layout__header-row">
                    <span class="mdl-layout-title">建设项目负责人 - 修改建设项目工程</span>
                    <div class="mdl-layout-spacer"></div>
                    <%@ include file="sub-nav.jsp" %>
                    <a class="mdl-navigation__link is-active" href="projectleader-index.jsp">注册建设项目工程</a>
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
                            <h1>修改建设项目工程</h1>
                        </header>
                        <div class="page-content mdl-cell mdl-cell--12-col">
                            <form action="ProjectleaderServlet?type=modifyProject" method="POST" class="page-form form-cell--12-col">
                            <c:forEach items="${projectDetail}" var="pd">
                                <input type="hidden" name="projectID" value="${projectID}">
                                <input type="hidden" name="enterpriseID" value="<%=enterpriseid%>">
                                <input type="hidden" name="personID" value="<%=personID%>">
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="text" name="projectName" value="${pd.projectName }" id="projectName">
                                    <label class="mdl-textfield__label" for="projectName">项目名</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <span class="maipae-radio-title">质监站属地</span>
                                    <label>四川省成都市</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <span class="maipae-radio-title">质监站名称</span>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="sn-option-1">
                                        <input type="radio" id="sn-option-1" class="mdl-radio__button" name="stationName" value="锦江区质监站" <c:if test="${pd.stationName == '锦江区质监站' }">checked</c:if>>
                                        <span class="mdl-radio__label">锦江区质监站</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="sn-option-2">
                                        <input type="radio" id="sn-option-2" class="mdl-radio__button" name="stationName" value="青羊区质监站" <c:if test="${pd.stationName == '青羊区质监站' }">checked</c:if>>
                                        <span class="mdl-radio__label">青羊区质监站</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="sn-option-3">
                                        <input type="radio" id="sn-option-3" class="mdl-radio__button" name="stationName" value="金牛区质监站" <c:if test="${pd.stationName == '金牛区质监站' }">checked</c:if>>
                                        <span class="mdl-radio__label">金牛区质监站</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="sn-option-4">
                                        <input type="radio" id="sn-option-4" class="mdl-radio__button" name="stationName" value="武侯区质监站" <c:if test="${pd.stationName == '武侯区质监站' }">checked</c:if>>
                                        <span class="mdl-radio__label">武侯区质监站</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="sn-option-5">
                                        <input type="radio" id="sn-option-5" class="mdl-radio__button" name="stationName" value="成华区质监站" <c:if test="${pd.stationName == '成华区质监站' }">checked</c:if>>
                                        <span class="mdl-radio__label">成华区质监站</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="sn-option-6">
                                        <input type="radio" id="sn-option-6" class="mdl-radio__button" name="stationName" value="高新区质监站" <c:if test="${pd.stationName == '高新区质监站' }">checked</c:if>>
                                        <span class="mdl-radio__label">高新区质监站</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="sn-option-7">
                                        <input type="radio" id="sn-option-7" class="mdl-radio__button" name="stationName" value="龙泉驿区质监站" <c:if test="${pd.stationName == '龙泉驿区质监站' }">checked</c:if>>
                                        <span class="mdl-radio__label">龙泉驿区质监站</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="sn-option-8">
                                        <input type="radio" id="sn-option-8" class="mdl-radio__button" name="stationName" value="青白江区质监站" <c:if test="${pd.stationName == '青白江区质监站' }">checked</c:if>>
                                        <span class="mdl-radio__label">青白江区质监站</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="sn-option-9">
                                        <input type="radio" id="sn-option-9" class="mdl-radio__button" name="stationName" value="新都区质监站" <c:if test="${pd.stationName == '新都区质监站' }">checked</c:if>>
                                        <span class="mdl-radio__label">新都区质监站</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="sn-option-10">
                                        <input type="radio" id="sn-option-10" class="mdl-radio__button" name="stationName" value="温江区质监站" <c:if test="${pd.stationName == '温江区质监站' }">checked</c:if>>
                                        <span class="mdl-radio__label">温江区质监站</span>
                                    </label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="date" name="projectStartTime" value="${pd.projectStartTime }" id="projectStartTime">
                                    <label class="mdl-textfield__label" for="projectStartTime">项目开始时间</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="date" name="projectEndTime" value="${pd.projectEndTime }" id="projectEndTime">
                                    <label class="mdl-textfield__label" for="projectEndTime">项目结束时间</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <span class="maipae-radio-title">报监状态</span>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="sn-option-1">
                                        <input type="radio" id="sn-option-1" class="mdl-radio__button" name="monitorState" value="未报监" <c:if test="${pd.monitorState == '未报监' }">checked</c:if>>
                                        <span class="mdl-radio__label">未报监</span>
                                    </label>
                                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="sn-option-2">
                                        <input type="radio" id="sn-option-2" class="mdl-radio__button" name="monitorState" value="已报监" <c:if test="${pd.monitorState == '已报监' }">checked</c:if>>
                                        <span class="mdl-radio__label">已报监</span>
                                    </label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="text" name="projectFiles" value="${pd.projectFiles }" id="projectFiles">
                                    <label class="mdl-textfield__label" for="projectFiles">项目资料</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                	<textarea class="mdl-textfield__input" type="text" name="remarks" placeholder="${pd.remarks }" rows="5" id="remarks"></textarea>
                                    <label class="mdl-textfield__label" for="remarks">备注</label>
                                </div>
                            </c:forEach>
                                <p>
                                    <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit">
                                        修改
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