<%--
  Created by IntelliJ IDEA.
  User: 黄龍
  Date: 2021/5/22
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>search</title>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script>
        $(function (){
            if (${search_result!=null}){

                $("#page").css('display','block');
            }
        })
        function check(){
            if (frm.keywords.value===""){
                alert("请输入数据!");
                frm.keywords.focus();
                return;
            }
        }

    </script>
</head>
<body>
<%@include file="navigation.jsp"%>
   <div align="center">
       <form method="get" name="frm" action="/dianquan/search">
           <input type="hidden" name="pageNum" value="1">
           <input style="width: 300px;height: 50px;" type="text" name="keywords" id="keywords" placeholder="搜索你感兴趣的内容" required="required">
           <input style=" width: 100px;height: 50px;" type="submit" name="search" id="search"  value="搜索" onclick="check();"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="./toplist.jsp" > 排行榜</a>
       </form>
   </div>
    <div>
       <c:forEach items="${search_result.list}" var="str">
          <div>
              <h2><a href="item/${str.title}">${str.title}</a></h2>
              <h3>${str.username}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${str.date}</h3>
              <p>${str.introduction}</p>
              <hr>
          </div>

       </c:forEach>
    </div>
    <ul>
        <c:forEach begin="1" end="${search_result.totalPage}" var="i">
            <li><a href="${pageContext.request.contextPath}/search?keywords=${search_result.keywords}&pageNum=${i}">第${i}页</a></li>
        </c:forEach>

        <span style="display: none" id="page">
            共${search_result.totalCounts}条记录,共${search_result.totalPage}页
        </span>
    </ul>
    <div align="center">
        ${search_msg}
    </div>

</body>
</html>
