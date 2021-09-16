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
        <form action="managerServlet" method="post">
            <input type="hidden" name="action" value="UpdateManager">
            <input type="hidden" name="item_id" value="${requestScope.item.item_id}">
            <table class="altrowstable" id="alternatecolor">
                <tr><th>条目id</th><th>条目标题</th><th>内容</th><th>所属用户</th><th>创建时间</th><th>用户id</th></tr>
                <tr>
                    <td>${requestScope.item.item_id}</td>
                    <td><input value="${requestScope.item.title}" id="title" name="title"></td>
                    <td><input value="${requestScope.item.introduction}" id="introduction" name="introduction"></td>
                    <td><input value="${requestScope.item.username}" id="username" name="username"></td>
                    <td><input value="${requestScope.item.date}" id="date" name="date"></td>
                    <td><input value="${requestScope.item.user_id}" id="user_id" name="user_id"></td>
                </tr>
            </table>


        <div style="width:fit-content; margin: 0 auto;">
            <a href="managerServlet?action=GetById&id=${requestScope.item.item_id}">
                <button class="blue"> 返回 </button>
            </a>

            <button class="blue" type="submit">保存</button>
        </div>
        </form>
         </div>
     </div>

     <%@include file="../common/common_foot.jsp"%>
 </div>

</body>
</html>
