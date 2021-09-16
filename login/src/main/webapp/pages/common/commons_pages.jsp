<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tao
  Date: 2021/2/4
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" type="text/css" href="static/css/mycss.css">

<div class="dtest3" style="height: 10%; width:fit-content; margin: 0 auto; border: 0;">
    <c:if test ="${requestScope.page.pageNo > 1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">${requestScope.page.pageNo-1}</a>
    </c:if>
    【${requestScope.page.pageNo}】
    <c:if test ="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">${requestScope.page.pageNo+1}</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input  name="pn" id="pn_input" style="width: 20px" value="${requestScope.page.pageNo}"/>页
    <input id="goToPag" type="button" value="确定">
</div>
<script type="text/javascript">
    $(function () {
        $("#goToPag").click(function () {
            var pageNo = $("#pn_input").val();

            var pageTotal = ${requestScope.page.pageTotal};

            if(pageNo>pageTotal || pageNo<1){
                alert("你输入的页码数有误，请重新输入！")
            }else{
                location.href = "${requestScope.basepath}${requestScope.page.url}&pageNo="+pageNo;
            }

        })
    })
</script>

