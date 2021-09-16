
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>

<html>
<head>
    <title>adminloginsuccess</title>

</head>
<body>
<%@include file="../../navigation.jsp"%>
<form>
    <div>
        ${admin_msg}<br>
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
