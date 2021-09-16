<%--
  Created by IntelliJ IDEA.
  User: Tao
  Date: 2021/5/24
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>

<%@include file="../common/common_one.jsp"%>

<script type="text/javascript">



    function statement(){
        if($("#statement").val() == "待审核"){
            alert("请修改状态标签，给出拒绝理由。");
            return false;
        }else{
            frm.submit();
        }
    };
</script>

<div class="box">
    <div class="dtest">dtest1
        <div class="dtest3"> dtest3
            <form action="applyServlet" method="post" name="frm">
                <input type="hidden" name="action" value="UpdateApply">
                <input type="hidden" name="uaction" value="statement">
                <input type="hidden" name="id" value="${requestScope.Tiaomu.apply_id}">
                <table class="altrowstable" id="alternatecolor">
                    <tr><th>条目名称</th><th>条目简介</th><th>申请时间</th><th>用户id</th><th>当前状态</th></tr>
                    <tr><td>${requestScope.Tiaomu.title}</td><td>${requestScope.Tiaomu.introduction}</td><td>${requestScope.Tiaomu.date}</td><td>${requestScope.Tiaomu.user_id}</td>
                        <td><input value="${requestScope.Tiaomu.statements}" name="statement" id="statement"></td></tr>
                </table>
            </form>

            <div style="width:fit-content; margin: 0 auto;">
                <a href="applyServlet?action=DelById&id=${requestScope.Tiaomu.apply_id}">
                    <button class="blue"> 删除 </button>
                </a>
                <a href="applyServlet?action=SaveTm&id=${requestScope.Tiaomu.apply_id}">
                    <button class="blue"> 审核通过 </button>
                </a>
                <a onclick="return statement()" >
                    <button class="blue"> 拒绝 </button>
                </a>
                <a href="applyServlet?action=Update&id=${requestScope.Tiaomu.apply_id}">
                    <button class="blue"> 编辑 </button>
                </a>
            </div>

        </div>
    </div>

    <%@include file="../common/common_foot.jsp"%>

</div>

</body>
</html>
