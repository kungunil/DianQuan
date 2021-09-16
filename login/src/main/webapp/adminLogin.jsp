<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>adminLogin</title>
    <script src="js/jquery-1.11.3.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/login.css">

    <script>
        <%
          String admin_flag = (String) session.getAttribute("admin_flag");
          String admin_name = (String) session.getAttribute("admin_name");
          if(admin_flag!=null){
              if("1".equals(admin_flag)){
                  out.println("alert('管理员:"+admin_name+"已登录')");
                  session.removeAttribute("admin_flag");
                  session.removeAttribute("admin_name");
              }
          }
      %>
    </script>
</head>
<body>
<%@include file="navigation.jsp"%>
<div  class="lg_layout">
    <div class="lg_left">
        <img src="img/yumao.jpg" height="390px" width="410px">
    </div>
    <div class="lg_right">
        <div class="lg_form">
            <h2>管理员登录</h2>
            <form action="/dianquan/adminLogin.do" method="get" >
                <table >
                    <tr><td class="td_left"><label for="admin_name">用户名:</label></td>
                        <td class="td_right">  <input type="text" name="admin_name" id="admin_name" placeholder="admin:" required="required"><br></td></tr>
                    <tr><td class="td_left"><label for="admin_pwd">密码:</label></td>
                        <td class="td_right"> <input type="password" name="admin_pwd" id="admin_pwd" placeholder="输入密码:" required="required"><br></td></tr>
                    <tr><td colspan="2"  align="center" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="adminlongin" value="登录">
                        <a class="lg_reset" href="adminLogin.jsp">刷新</a></td></tr>
                </table>
            </form>

        </div>
        <div class="lg_msg">
            ${admin_msg}
        </div>
    </div>

</div>

</body>
</html>
