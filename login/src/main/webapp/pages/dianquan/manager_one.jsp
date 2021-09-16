<%--
  Created by IntelliJ IDEA.
  User: Tao
  Date: 2021/5/24
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>

<%@include file="../common/common_one.jsp"%>

<div class="box">
    <div class="dtest">dtest1
        <div class="dtest3"> dtest3
        <form>
            <table class="altrowstable" id="alternatecolor">
                <tr><th>条目名称</th><th>条目简介</th><th>创建人</th><th>创建时间</th>
                <tr><td>${requestScope.Tiaomu.title}</td><td>${requestScope.Tiaomu.introduction}</td><td>${requestScope.Tiaomu.username}</td><td>${requestScope.Tiaomu.date}</td></tr>
            </table>
        </form>

        <div style="width:fit-content; margin: 0 auto;">
            <a href="managerServlet?action=page">
                <button class="blue"> 返回 </button>
            </a>

            <a href="managerServlet?action=DelById&id=${requestScope.Tiaomu.item_id}">
                <button class="blue"> 删除 </button>
            </a>

            <a href="managerServlet?action=Update&id=${requestScope.Tiaomu.item_id}">
                <button class="blue"> 编辑 </button>
            </a>
        </div>
        </div>
    </div>

    <%@include file="../common/common_foot.jsp"%>

</div>
</body>
</html>
