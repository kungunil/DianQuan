<%--
  Created by IntelliJ IDEA.
  User: Tao
  Date: 2021/5/24
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <%
        String basepath = request.getScheme()
                +"://"
                +request.getServerName()
                +":"
                +request.getServerPort()
                +request.getContextPath()
                +"/";

        request.setAttribute("basepath",basepath);
    %>
    <!--写base标签，永远固定相对路径跳转的结果-->
    <base href= "<%=basepath%>">

    <link rel="stylesheet" type="text/css" href="static/css/mycss.css">
    <script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>

</head>
<body>
<nav class="navtest">
    <a href="../../dianquan/index.html" style="float: left;margin: 0 auto"><img src="static/img/logo.png" style="height: 100%; float: left; margin: 0 1% auto"></a>
    <a href="../../dianquan/index.jsp" >${empty sessionScope.login_user.username? "登录/注册":sessionScope.login_user.username}</a><a href="#">关于</a>
    <a href="../../dianquan/search.jsp">搜索发现</a><a href="../../dianquan/index.html">首页</a>
</nav>
</body>
</html>
