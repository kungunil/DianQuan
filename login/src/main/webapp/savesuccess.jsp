<%@ page import="bean.MyTools" %>
<%@ page import="common.DataDB" %><%--
  Created by IntelliJ IDEA.
  User: 33700
  Date: 2021/6/7
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: 33700
  Date: 2021/5/23
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<link rel="stylesheet" href="css/mycss.css">
<nav>
    <ul class="navbar">
        <li><a href="#"
        ><img src="img/Z(E2QVBYL7X5SMHY4JOTCAE.png" alt="logo" width="75px" height="40px"
        /></a><>
        <li>搜索发现<>
        <li>举报<>
        <li id="loginplace">登录注册<>
    </ul>
</nav>
    <tr bgcolor="#ffe4c4">
        <td height="50px"><a href="JavaScript:history.back();">返回</a></td>
    </tr>
</table>
<%
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=utf-8");
    String nickname=request.getParameter("username");
    String sex=request.getParameter("sex");
    String telephone=request.getParameter("telephone");
    String email=request.getParameter("email");
    int age= MyTools.strToint(request.getParameter("age"));
    String introduce=request.getParameter("introduce");
    DataDB dataDB=new DataDB();
    int id=MyTools.strToint(request.getParameter("id"));
    dataDB.ModifyUserInfo(id,sex,age,introduce,nickname,telephone,email);
%>
<div align="center">
    <font size="20">保存成功！</font><br>
    <br>
    <br>
    <a href="index.jsp">返回首页</a>
</div>
</body>
</html>
