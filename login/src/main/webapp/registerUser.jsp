
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>register</title>
    <link rel="stylesheet" type="text/css" href="css/register.css">

    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>

    <script type="text/javascript">

        $(function () {
            //验证用户名是否存在,给出提示信息
            $("#username").blur(function () {
                var username = $(this).val();
                if (username === "") {

                } else {
                    $.ajax({
                        url: "/dianquan/userIfExist.do",
                        data: {
                            username: username
                        },
                        dataType: "json",
                        success: function (data) {
                            var span = $("#s1");
                            if (data.userExist) {
                                span.css("color", "red");
                                span.html(data.msg);
                            } else {
                                span.css("color", "green");
                                span.html(data.msg);
                            }
                        }
                    })
                }

            });
        });

      function check(){
          if (frm.username.value===""||frm.password1.value===""||frm.password2.value===""||frm.telephone.value===""
              ||frm.email.value===""||frm.question.value===""||frm.answer.value===""){
              alert("有未填项!");
              return;
          }
            if (frm.input_verifyCode.value===""){
                alert("请输入验证码!");
                frm.input_verifyCode.focus();
                return;
            }
            if (frm.password1.value!==frm.password2.value){
                alert("确认密码有误!重新输入!");
                frm.password2.focus();
                return;
            }


           var reg = /^[0-9]+$/;
            if(frm.telephone.value!=""&&!reg.test(frm.telephone.value)){
                alert('只能输入数字！');
                return ;
            }
          var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
          if(!myreg.test(frm.email.value))
          {
              alert('请输入有效的邮箱！');
              return;
          }
            frm.submit();
        }


        //给验证码换一张
        window.onload = function (){
          var img = document.getElementById("verifyCode");
          img.onclick = function (){
              img.src = "/dianquan/verifyCode.do?"+new Date().getTime();
          }
      }


    </script>

</head>
<body>
    <%@include file="navigation.jsp"%>
    <div  class="rg_layout">
        <div class="rg_left">
            <img src="img/yumao.jpg" height="390px" width="410px">
        </div>
        <div class="rg_right">
            <div class="rg_form">
                <h2>用户注册</h2>
                <form action="/dianquan/registerUser.do" method="post" name="frm">
                    <table >
                        <tr><td class="td_left"><label for="username">用户名:</label></td>
                            <td class="td_right"> <input type="text" id="username" name="username" placeholder="最多20个字符" maxlength="20" required="required">
                                <br><span id="s1"> </span></td></tr>
                        <tr><td class="td_left"><label for="password1">密码:</label></td>
                            <td class="td_right"><input type="password" id="password1"  name="password" placeholder="请输入密码" required="required"></td></tr>
                        <tr><td class="td_left"><label for="password2">确认密码:</label></td>
                            <td class="td_right"><input type="password" id="password2" placeholder="确认密码" required="required"></td></tr>
                        <tr><td class="td_left"><label for="telephone">电话:</label></td>
                            <td class="td_right"><input type="tel" id="telephone" name="telephone" placeholder="请输入电话号码"  required="required"></td></tr>
                        <tr><td class="td_left"><label for="email">邮箱:</label></td>
                            <td class="td_right"><input type="email" id="email" name="email" placeholder="请输入邮箱" required="required"></td></tr>
                        <tr><td class="td_left"><label for="question">密码提示问题:</label></td>
                            <td class="td_right"><input type="text" name="question" id="question" placeholder="如:我的学校" required="required"></td></tr>
                        <tr><td class="td_left"><label for="answer">提示问题答案:</label></td>
                            <td class="td_right"><input type="text" name="answer" id="answer" placeholder="必填" required="required"></td></tr>
                        <tr><td class="td_left"><label for="input_verifyCode">验证码:</label></td>
                            <td class="td_right"><input name="input_verifyCode" id="input_verifyCode" type="text" placeholder="请输入验证码"></td></tr>
                        <tr><td colspan="2" align="center"><img id="verifyCode" src="/dianquan/verifyCode.do"></td></tr>
                        <tr><td colspan="2"  align="center" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="register" value="提交" onclick="check();">
                            <a class="rg_reset" href="registerUser.jsp">刷新</a></td></tr>
                    </table>
                </form>
            </div>
            <div class="rg_msg">
                ${register_msg}<br>
                ${verifycode_msg}<%request.getSession().removeAttribute("verifycode_msg");%><br>
            </div>
        </div>

    </div>

</body>
</html>
