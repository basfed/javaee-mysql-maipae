<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
        <title>MAIPAE - 建筑工程多主体交互平台</title>
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
		<div class="maipae-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
            <header class="mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600" role="banner">
                <div class="mdl-layout__header-row">
                    <span class="mdl-layout-title">首页</span>
                    <div class="mdl-layout-spacer"></div>
                    <%@ include file="sub-nav.jsp" %>
                    <a class="mdl-navigation__link" href="enterprise-sign-up.jsp">注册单位</a>
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
                            <h1>建筑工程多主体交互平台（MAIPAE）</h1>
                        </header>
                        <div class="page-content page-content-text mdl-cell mdl-cell--12-col">
                            <p>建筑工程多主体交互平台（MAIPAE）主要通过对建筑工程各责任主体进行质量监督。主要包括工程报监督、工程监督、竣工备案。</p>
                            <p>随着我国信息化的高速发展和不断应用，其影响已波及到传统建筑业的方方面面，近年来，随着经济建设的持续发展，市场经济环境日益成熟，工程建设规模不断扩大，建设工程质量监督活动与日俱增，相关法律法规不断健全，要求工程质量监督工作的效率相应提高。5.12汶川地震和上海闵行“莲花河畔景苑”在建楼房倒覆事故，使建设工程质量再次成为人们关注的热点，究竟如何搞好建设工程质量监督管理工作，仁人志士也是各有己见。在国际上日本的建设工程质量名列世界前茅，同时日本的建设工程质量政府监督管理信息化也是世界最好的。管理体制信息化已经被实践证明是一条行之有效的工程质量管理捷径，也是我们当前建筑领域亟待研究和解决的问题。建设工程质量政府监督管理是一个庞大的系统工程。</p>
                            <p>建设工程质量监督工作的信息化建设是推动质监工作现代化建设的助推器。而长期以来，我国工程建设信息的查询、统计主要依靠逐层人工统计，书面或简单的报表方式上报，不能有效、准确、及时对工程有关信息进行查询、统计和分析，严重影响了建设行政主管部门对有关责任主体和工程的监管效率和监管力度，难以适应新形势下对工程质量监督工作的新要求。充分利用信息技术，可以及时掌握准确、完整信息，可以使建设工程的实施过程更加透明和公正，可以对管理目标进行更好的评估、预测和控制，可以使建设工程各方责任主体及相关单位更加重视工程质量和使用安全。通过质量监督工作信息化建设，用公正、公平的监督标准来保证整个监督管理工作规范化与程序化，强化监管工作过程中的薄弱环节，可以使监督人员耳聪目明，卓有成效地开展监督工作，近而推动提高建设工程质量提高。四川省质检总站在学习其他兄弟省份建设工程质量监督管理系统的基础上，结合四川省的实际情况，委托四川省建筑科学院设计研发建筑工程多主体交互平台。</p>
                        </div>
                    </div>
                </section>
            </main>
        </div>
        <script src="js/material.min.js"></script>
	</body>
</html>