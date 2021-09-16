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
        $.getJSON("${basepath}userServlet","action=adminCount",function (data) {
            $("#scount").html("&nbsp&nbsp&nbsp&nbsp&nbsp"+data.count)
        });


        $("#goToPag").click(function () {
            var pageNo = $("#pn_input").val();

            var pageTotal = ${requestScope.page.pageTotal};

            if(pageNo>pageTotal || pageNo<1){
                alert("你输入的页码数有误，请重新输入！")
            }else{
                location.href = "${basepath}userServlet?action=page&pageNo="+pageNo;
            }
            })
        })
</script>

<div class="box">
    <div class="dtest">
        <div class="dtest3" style="height: 55%">
            <div style="height: 80%">
        <form>
            <!-- Table goes in the document BODY -->
            <table class="altrowstable" id="alternatecolor">
                <tr>
                    <th>用户id</th><th>账号</th><th>密码</th><th>电话</th><th>邮箱</th><th>密保问题</th>
                    <th>答案</th><th>账号类型</th><th>昵称</th><th>关注</th><th>收藏</th><th>点评</th>
                    <th>年龄</th><th>性别</th><th>个人简介</th><th>管理</th>
                </tr>
                <c:forEach items="${requestScope.page.items}" var="users">
                    <tr>
                        <td>${users.user_id}</td>
                        <td>${users.username}</td>
                        <td>${users.password}</td>
                        <td>${users.telephone}</td>
                        <td>${users.email}</td>
                        <td>${users.question}</td>
                        <td>${users.answer}</td>
                        <td>${users.type}</td>
                        <td>${users.nickname}</td>
                        <td>${users.attention}</td>
                        <td>${users.collection}</td>
                        <td>${users.mysay_id}</td>
                        <td>${users.age}</td>
                        <td>${users.sex}</td>
                        <td>${users.introduce}</td>
                        <td><a href="userServlet?action=GetById&id=${users.user_id}">查看</a></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
            </div>
            <%@include file="../common/commons_pages.jsp"%>
        </div>
        <div class="dtest3" style="height: 20%; background: #f2f4fb ">
            <div class="dtest31"  >
                <img src="static/img/m10.png" style="transform: scale(0.45);">
                <span style="font: 25px 微软雅黑 ; ">总用户数量<br><span style="font-size: 10px; color: #a1a1a1 ">&nbsp;&nbsp;&nbsp;截止到现在</span></span>
                <span style="font: 120px 微软雅黑 ; color: #3F83F1 ">&nbsp;&nbsp;&nbsp;&nbsp;${requestScope.page.pageTotalCount}</span>
            </div >

            <div class="dtest31"  style="float: right;">
                <img src="static/img/m11.png" style="transform: scale(0.45);">
                <span style="font: 25px 微软雅黑 ; ">管理员数量<br><span style="font-size: 10px; color: #a1a1a1 ">&nbsp;&nbsp;&nbsp;截止到现在</span></span>
                <span style="font: 120px 微软雅黑 ; color: #3F83F1 " id="scount">&nbsp;</span>
            </div>
        </div>
    </div>

    <%@include file="../common/common_foot.jsp"%>

</div>
</body>
</html>
