<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>

    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <%
        String basepath = request.getScheme()
                +"://"
                +request.getServerName()
                +":"
                +request.getServerPort()
                +request.getContextPath()
                +"/";

        request.setAttribute("basepath",basepath);
    %>
    <!--写base标签，永远固定相对路径跳转的结果-->

    <base href= "<%=basepath%>">

    <link rel="stylesheet" type="text/css" href="static/css/mycss.css">
    <script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>

    <script type="text/javascript">
        /*
            表格样式
         $(function () {
            var table = document.getElementById('alternatecolor');
            var rows = table.getElementsByTagName("tr");
            for(i = 0; i < rows.length; i++){
                if(i % 2 == 0){
                    rows[i].className = "evenrowcolor";
                }else{
                    rows[i].className = "oddrowcolor";
                }
            };

        })*/
    </script>

</head>

<body>

<nav class="navtest">
   <a href="index.html" style="float: left ; margin: 0 auto"><img src="static/img/logo.png" style="height: 100%; float: left; margin: 0 1% auto"></a>
    <a href="loginUser.jsp" >${empty sessionScope.login_user.username? "登录/注册":sessionScope.login_user.username}</a><a href="index.html">关于</a>
    <a href="search.jsp">搜索发现</a><a href="index.html">首页</a>
</nav>

<div class="leftmanager">
    <div style="margin: 50px auto">
        <a href="applyServlet?action=page">
            <button id="btm1" class="mbtn"> 审核用户申请 </button>
        </a>
        <a href="managerServlet?action=page">
            <button id="btm2" class="mbtn" > 管理条目 </button>
        </a>
        <a href="commentServlet?action=page">
            <button id="btm3" class="mbtn" > 管理点评 </button>
        </a>
        <a href="userServlet?action=page">
            <button id="btm4" class="mbtn" > 用户管理 </button>
        </a>
    </div>
</div>
