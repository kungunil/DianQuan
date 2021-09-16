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
        <form action="userServlet" method="post">
            <input type="hidden" name="action" value="UpdateUser">
            <input type="hidden" name="user_id" value="${requestScope.user.user_id}">
            <table class="altrowstable" id="alternatecolor">
                <tr>
                    <th>用户id</th><th>账号</th><th>密码</th><th>电话</th><th>邮箱</th><th>密保问题</th>
                    <th>答案</th><th>账号类型</th><th>昵称</th><th>关注</th><th>收藏</th><th>点评</th>
                    <th>年龄</th><th>性别</th><th>个人简介</th>
                </tr>

                <tr>
                    <td>${requestScope.user.user_id}</td>
                    <td><input style="width: 50px;" value="${requestScope.user.username}" id="username" name="username"></td>
                    <td><input style="width: 50px;" value="${requestScope.user.password}" id="password" name="password"></td>
                    <td><input style="width: 50px;" value="${requestScope.user.telephone}" id="telephone" name="telephone"></td>
                    <td><input style="width: 50px;" value="${requestScope.user.email}" id="email" name="email"></td>
                    <td><input style="width: 50px;" value="${requestScope.user.question}" id="question" name="question"></td>
                    <td><input style="width: 50px;" value="${requestScope.user.answer}" id="answer" name="answer"></td>
                    <td><input style="width: 50px;" value="${requestScope.user.type}" id="type" name="type"></td>
                    <td><input style="width: 50px;" value="${requestScope.user.nickname}" id="nickname" name="nickname"></td>
                    <td><input style="width: 50px;" value="${requestScope.user.attention}" id="attention" name="attention"></td>
                    <td><input style="width: 50px;" value="${requestScope.user.collection}" id="collection" name="collection"></td>
                    <td><input style="width: 50px;" value="${requestScope.user.mysay_id}" id="mysay_id" name="mysay_id"></td>
                    <td><input style="width: 50px;" value="${requestScope.user.age}" id="age" name="age"></td>
                    <td><input style="width: 50px;" value="${requestScope.user.sex}" id="sex" name="sex"></td>
                    <td><input style="width: 50px;" value="${requestScope.user.introduce}" id="introduce" name="introduce"></td>
                </tr>
            </table>


            <div style="width:fit-content; margin: 0 auto;">
            <a href="userServlet?action=GetById&id=${requestScope.user.user_id}">
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
