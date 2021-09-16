<%@ page import="common.DataDB" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.UserInfo" %>
<%@ page import="bean.MyTools" %><%--
  Created by IntelliJ IDEA.
  User: 33700
  Date: 2021/6/7
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<link rel="stylesheet" href="css/mycss.css">
<%@include file="navigation.jsp"%>
    <tr bgcolor="#ffe4c4">
        <td height="50px"><a href="JavaScript:history.back();">返回</a></td>
    </tr>
    </table>
<%
    System.out.println(session.getAttribute("user_id"));
    int id= (int) session.getAttribute("user_id");
    System.out.println("黄龙传递id"+id);
    DataDB dataDB =new DataDB();
    UserInfo user=new UserInfo();
    user=dataDB.GetUserInfo(id);
%>
<form action="savesuccess.jsp?id=<%=id%>" name="formone" method="post">
    <table width="70%">
        <tr>
            <td>
                <font size="4">昵称</font>
            </td>
            <td><input type="text" name="username" value="<%=user.getNickname()%>"></td>
        </tr>

        <tr>
            <td>
                <font size="4">性别</font>
            </td>
            <td><input type="text" name="sex" value="<%=user.getSex()%>"></td>
        </tr>

        <tr>
            <td>
                <font size="4">年龄</font>
            </td>
            <td><input type="text" name="age" value="<%=user.getAge()%>"></td>
        </tr>
        <tr>
            <td>
                <font size="4">电话</font>
            </td>
            <td><input type="text" name="telephone" value="<%=user.getTelephone()%>"></td>
        </tr>
        <tr>
            <td>
                <font size="4">邮箱</font>
            </td>
            <td><input type="text" name="email" value="<%=user.getEmail()%>"></td>
        </tr>
        <tr>
        <td>
            <font size="4">个人简介</font>
        </td>
        <td><textarea rows="10" cols="50" name="introduce"><%=user.getIntroduce()%></textarea></td>
        </tr>
        <tr>
            <td></td>
        </tr>
        <tr align=>
            <td colspan="2"><input type="button" value="保存修改" onclick="return check(this.form)"><input type="reset" name="reset"></td></td>
        </tr>
    </table>
</form>
<script language="JavaScript">
    function check(form) {
        if (form.username.value == "") {
            alert("用户名为空！");
            form.username.focus();
            return false;
        }
        if (form.sex.value == "") {
            alert("请输入性别！");
            form.sex.focus();
            return false;
        }
        if (form.age.value == "") {
            alert("请输入年龄！");
            form.age.focus();
            return false;
        }
        document.formone.submit()
    }

</script>
</body>
</html>
