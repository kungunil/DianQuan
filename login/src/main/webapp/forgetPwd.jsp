<%--
  Created by IntelliJ IDEA.
  User: 黄龍
  Date: 2021/4/26
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>forgetPwd</title>
    <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>


</head>
<body>
<%@include file="navigation.jsp"%>
    <div align="center">
        <form method="post" action="/dianquan/forgetPassword">
            请输入用户名:<input type="text" name="username"  required="required" >
            <input name="submit" type="submit" value="下一步">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a class="lg_reset" href="forgetPwd.jsp">刷新</a>
        </form>

    </div>
    <div align="center">
        ${forgetPwd_msg}
    </div>

</body>
</html>
