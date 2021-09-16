<%--
  Created by IntelliJ IDEA.
  User: 黄龍
  Date: 2021/5/21
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>getPwd</title>
</head>
<body>
<%@include file="../../navigation.jsp"%>
    <form action="/dianquan/getPwd" name="getPwd" method="post">
        <input type="hidden" name="username" value="${requestScope.username}">
        密码提示问题:<input type="text" name="question" value="${requestScope.question}"><br>
        提示问题答案:<input type="text" name="answer" required="required"><br>
        <input type="submit" value="下一步">
    </form>
    <div align="center">
        ${getPwd_msg}

    </div>
</body>
</html>
