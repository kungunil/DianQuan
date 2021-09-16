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
                <tr>
                    <th>用户id</th><th>账号</th><th>密码</th><th>电话</th><th>邮箱</th><th>密保问题</th>
                    <th>答案</th><th>账号类型</th><th>昵称</th><th>关注</th><th>收藏</th><th>点评</th>
                    <th>年龄</th><th>性别</th><th>个人简介</th>
                </tr>

                <tr>
                    <td>${requestScope.user.user_id}</td>
                    <td>${requestScope.user.username}</td>
                    <td>${requestScope.user.password}</td>
                    <td>${requestScope.user.telephone}</td>
                    <td>${requestScope.user.email}</td>
                    <td>${requestScope.user.question}</td>
                    <td>${requestScope.user.answer}</td>
                    <td>${requestScope.user.type}</td>
                    <td>${requestScope.user.nickname}</td>
                    <td>${requestScope.user.attention}</td>
                    <td>${requestScope.user.collection}</td>
                    <td>${requestScope.user.mysay_id}</td>
                    <td>${requestScope.user.age}</td>
                    <td>${requestScope.user.sex}</td>
                    <td>${requestScope.user.introduce}</td>
                </tr>
            </table>
        </form>
    <div style="width:fit-content; margin: 0 auto;">
        <a href="userServlet?action=page">
            <button class="blue"> 返回 </button>
        </a>

        <a href="userServlet?action=DelById&id=${requestScope.user.user_id}">
            <button class="blue"> 删除 </button>
        </a>

        <a href="userServlet?action=Update&id=${requestScope.user.user_id}">
            <button class="blue"> 编辑 </button>
        </a>
    </div>
        </div>
    </div>

    <%@include file="../common/common_foot.jsp"%>
</div>
</body>
</html>
