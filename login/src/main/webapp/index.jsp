<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<script src="js/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" href="css/mycss.css">
<script>
    function onload1(){
        document.getElementById('position').src="myattention.jsp"
    }
    function onload2(){
        document.getElementById('position').src="mycollection.jsp"
    }
    function onload3(){
        document.getElementById('position').src="mysay.jsp"
    }
</script>

<%@include file="navigation.jsp"%>
    <tr bgcolor="#ffe4c4">
        <td height="50px"><a href="userinfo.jsp">编辑个人资料</a>&nbsp;<a href="passwordmodify.jsp">修改密码</a></td>
        <td><a href="./pages/dianquan/apply_submit.jsp">点击创建条目</a></td>

    </tr>
    <tr>
        <td>
            <table width="100%">
                <tr>
                    <td width="45%">
                        <font size="4"> <b><a href="javascript:void (0);" onclick="onload1()">我的关注</a></b></font>
                    </td>
                    <td width="50%">
                        <font size="4"> <b><a href="javascript:void (0);" onclick="onload2()">我的收藏</a></b></font>
                    </td>
                    <td width="50%">
                        <font size="4"> <b><a href="javascript:void (0);" onclick="onload3()">我的发言</a></b></font>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>
            <div>
                <iframe style="width:100%;height: 439px" id="position">

                </iframe>
            </div>
        </td>
    </tr>
    <tr align="center">
        <td><input type="button" onclick="exi()" name="exit" value="退出登录"></td>
    </tr>
</table>
</body>
</html>
<script>
    function exi(){
        $.get("./exit",function (data){
            if (data.flag==1){
                alert('退出成功!')
                window.location.href="index.html"
            }
            else {
                alert('退出失败!')
            }
        },"JSON")

    }
</script>
