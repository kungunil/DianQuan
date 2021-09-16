<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>loginUser</title>
    <script src="js/jquery-1.11.3.min.js"></script>

    <script type="text/javascript">
        <%
            String login_flag = (String) session.getAttribute("login_flag");
            String username = (String) session.getAttribute("username");
            if(login_flag!=null){
                if("1".equals(login_flag)){
                    out.println("alert('"+username+"已登录')");
                    session.removeAttribute("login_flag");
                    session.removeAttribute("username");
                }
            }
        %>
    </script>
    <link rel="stylesheet" type="text/css" href="css/login.css">

</head>
<body >
<%--    导航栏--%>
<%@include file="navigation.jsp"%>
    <div class="lg_layout">
        <div class="lg_left">
            <img src="img/下载.png" height="390px" width="410px">
        </div>
        <div class="lg_right">
            <div class="lg_form">
                <h2>用户登录</h2> <a href="registerUser.jsp">没有账号?立即注册</a>
                <form action="./loginUser.do" method="get" >
                    <table >
                       <tr><td class="td_left"><label for="username">用户名:</label></td>
                           <td class="td_right"> <input type="text" name="username" id="username" placeholder="输入用户名:" required="required"><br></td></tr>
                       <tr><td class="td_left"><label for="password">密码:</label></td>
                           <td class="td_right"> <input type="password" name="password" id="password" placeholder="输入密码:" required="required"><br></td></tr>
                        <tr><td colspan="2"  align="center" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" name="login" value="登录" >
                            <a class="lg_reset" href="loginUser.jsp">刷新</a></td></tr>
                    </table>
                </form>
                <br>



                <input name="forgetPwd" type="button" onclick="location.href='./forgetPwd.jsp'" value="忘记密码" >
                <input class="admin_lg" name="adminLogin" type="button" onclick="location.href='./adminLogin.jsp'" value="管理员登录">
            </div>
            <div class="lg_msg">
                ${login_msg}
            </div>
        </div>

</div>

</body>
</html>
