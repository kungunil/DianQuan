<%@ page import="com.login.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: 黄龍
  Date: 2021/6/18
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="css/navigation.css">
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
        <% User login_user = (User) request.getSession().getAttribute("login_user");
            if(login_user!=null && login_user.getType() == 2){
        %>
        <script>
            function temp() {
                document.querySelector("#loginplace").innerHTML = `<a href='<%out.print(request.getContextPath()+"/usercenter");%>'><%=login_user.getUsername()%></a>`;
            }
            window.onload = temp;
        </script>
        <%
            }
            else if (login_user!=null && login_user.getType() == 1) { %>
                <script>
                    function temp() {
                        let a = document.querySelector("#loginplace");
                        a.innerHTML = "<a href='applyServlet?action=page'>管理中心</a>";
                    }
                    window.onload = temp;
                </script>
            <%}%>
</head>
<body>
<nav>
    <ul class="navbar" id="na">
        <li><a href="index.html"><img src="image/logo.png" alt="logo" width="75px" height="40px"/></a><li>
        <li><a href="search.jsp">搜索发现</a><li>
        <li id="loginplace"><a href="loginUser.jsp" id="a">登录/注册</a><li>
    </ul>
</nav>
</body>
</html>
