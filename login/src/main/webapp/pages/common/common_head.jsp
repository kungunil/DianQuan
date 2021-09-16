<%--
  Created by IntelliJ IDEA.
  User: 刘涛
  Date: 2021/5/16
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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

<%=basepath%>
<!--写base标签，永远固定相对路径跳转的结果-->

<base href= "<%=basepath%>">

<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>

<link rel="stylesheet" type="text/css" href="static/css/student.css">

