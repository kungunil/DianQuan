<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>

<div class="dtest2">
    <div class="dtest4">
        <div class="dtest5">
            <img src="static/img/admin.jpg" class="circleImg">
            <span class="imgfont" style="position: relative;top: 10px;left: 92px ;">Hi，管理员</span>
            <span class="imgfont" style="position: relative;top: 35px;left: 10px; font-size: 6px">${sessionScope.login_user.username}</span>
            <img src="static/img/type.png" style="margin: 45px 50px auto">
            <span style="position: relative;top: 15px;left: 42px; font-size:15px;color: #cfcfcf">点圈技术加密，保障账号信息安全</span>
        </div>
        <div style="border:1px solid #e6eaf2; width: 90% ; margin: 0 auto"> </div>
        <div class="dtest5" style="margin: 10px auto;height: 30%">
            <span style="font: 25px 黑体 bold; margin: 10px 42px auto;">帮助中心</span>
            <a href="pages/dianquan/tip.jsp" class="linkatest" style="margin: 0 35px auto">更多></a>
            <a href="pages/dianquan/tip.jsp"><button class="testbtn">如何注销账号?</button></a><br>
            <a href="pages/dianquan/tip.jsp"><button class="testbtn">账号登录异常？</button></a><br>
            <a href="pages/dianquan/tip.jsp"><button class="testbtn">遇到风险，如何冻结？</button></a><br>
            <a href="pages/dianquan/tip.jsp"><button class="testbtn">如何处理申述？</button></a>
        </div>
        <div style="border:1px solid #e6eaf2; width: 90% ; margin: 10px auto"> </div>
        <div class="dtest5" style="margin: 5px auto;height: 15%">
            <span style="font: 25px 黑体 bold; margin: 10px 42px auto; ">意见反馈</span>
            <a href="#" class="linkatest" style="margin: 0 35px auto">反馈></a>
        </div>
    </div>
</div>