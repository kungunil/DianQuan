<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.5.1.js"></script>
</head>
<body>
<link rel="stylesheet" href="css/mycss.css">
<jsp:include page="navigation.jsp"></jsp:include>
    <tr bgcolor="#ffe4c4">
        <td height="50px"><a href="JavaScript:history.back();">返回</a></td>
    </tr>

<form action="">
    <table>
        <tr>
            <td>
                请输入原密码：<input type="password" name="oldpassword" id="odpsd"><div id="tip"></div>
            </td>
        </tr>
        <tr>
            <td>
                请输入新密码：<input type="password" name="newpassword" id="nwpsd">
            </td>
        </tr>
        <tr>
            <td>
                确认新密码：<input type="password" name="repeatpassword">
            </td>
        </tr>
        <tr>
            <td><input type="button" value="确认" onclick="check(this.form)"></td>
        </tr>
    </table>
</form>
<script>
    function check(form){
        if (form.newpassword.value!=form.repeatpassword.value){
            alert('新密码输入错误')
            focus(form.newpassword);
        }
        else {
            $.get('./Pswd', {newpassword: $('#nwpsd').val(), oldpassword: $('#odpsd').val()}
                , function (data) {
                    $('#tip').text(data.flag)
                    console.log(data.flag)
                    $('#tip').show()
                    if(data.flag=='true'){
                        alert('修改成功')
                    }
                },"JSON")
        }







    }
</script>