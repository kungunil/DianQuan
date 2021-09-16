<%@ page import="com.login.util.PageBean" %>
<%@ page import="com.login.entity.Trcmitem" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <title>toplist.jsp</title>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>

</head>
<body >
<%@include file="navigation.jsp"%>
<%
    PageBean<Trcmitem> pb = (PageBean<Trcmitem>) request.getAttribute("pb");
    System.out.println("-------------pb:"+pb);
    if(pb == null) {
        response.sendRedirect(request.getContextPath()+"/toplist?pageNum=1");
    }

%>
    <h2 align="center">排行榜</h2><br>

    <ol id="ol1">
        <c:forEach items="${pb.list}" var="s">
            <li>标题:<a href="item/${s.title}">${s.title}</a><br><h3>简介:</h3>${s.introduction}<hr></li>
        </c:forEach>
    </ol>
    <ul>

        <span>
            共${pb.totalCounts}条记录
        </span>
    </ul>
</body>
</html>