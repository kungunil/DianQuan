

<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>

<html>
<head>
    <title>findSuccess</title>

</head>
<body>
<%@include file="../../navigation.jsp"%>
<form>
    <div style="text-align: center">
        ${login_msg},<span style="font-size: x-large">${login_user.getUsername()}</span> 欢迎您!<br>
        <p><span id="skip"></span>秒后跳转到首页</p>
    </div>
</form>
<script type="text/javascript">

    var t = 5;
    function showTime() {
        t -= 1;
        document.getElementById('skip').innerHTML = t;
        if (t === 0) {

            window.location.href ='./';

        }
        setTimeout("showTime()",1000);
    }
    showTime();
</script>
</body>
</html>
