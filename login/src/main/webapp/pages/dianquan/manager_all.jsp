<%--
  Created by IntelliJ IDEA.
  User: Tao
  Date: 2021/5/24
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/common_one.jsp"%>
<script type="text/javascript">
    $(function (){
        //2.Jquery调用getjson对象
        $.getJSON("${basepath}managerServlet","action=todayCount",function (data) {
            $("#scount").html("&nbsp&nbsp&nbsp&nbsp"+data.count)
        });
    });
</script>

<div class="box">
    <div class="dtest">
        <div class="dtest3" style="height: 55%">
            <div style="height: 80%">
        <form>
            <table class="altrowstable" id="alternatecolor">
                <tr><th>条目名称</th><th>创建用户</th><th>管理</th></tr>
                <c:forEach items="${requestScope.page.items}" var="Tiaomu">
                    <tr>
                        <td>${Tiaomu.title}</td>
                        <td>${Tiaomu.username}</td>
                        <td><a href="managerServlet?action=GetById&id=${Tiaomu.item_id}">编辑</a></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
            </div>
            <%@include file="../common/commons_pages.jsp"%>
        </div>
        <div class="dtest3" style="height: 20%; background: #f2f4fb ">
            <div class="dtest31"  >
                <img src="static/img/m4.png" style="transform: scale(0.45);">
                <span style="font: 25px 微软雅黑 ; ">总条目数量<br><span style="font-size: 10px; color: #a1a1a1 ">&nbsp;&nbsp;截止到现在</span></span>
                <span style="font: 120px 微软雅黑 ; color: #3F83F1 ">&nbsp;&nbsp;&nbsp;&nbsp;${requestScope.page.pageTotalCount}</span>
            </div >

            <div class="dtest31"  style="float: right;">
                <img src="static/img/m7.png" style="transform: scale(0.45);">
                <span style="font: 25px 微软雅黑 ; ">今日新增条目<br><span style="font-size: 10px; color: #a1a1a1 ">&nbsp;&nbsp;&nbsp;截止到现在</span></span>
                <span style="font: 120px 微软雅黑 ; color: #3F83F1 " id="scount">&nbsp;&nbsp;&nbsp;&nbsp;</span>
            </div>
        </div>
    </div>

    <%@include file="../common/common_foot.jsp"%>


</div>

</body>
</html>
