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
                <tr><th>点评id</th><th>点评内容</th><th>所属用户</th><th>可见性</th><th>点评图片</th><th>所属条目</th><th>时间</th></tr>
                <tr><td>${requestScope.comment.cmt_id}</td><td>${requestScope.comment.cmttext}</td><td>${requestScope.comment.user_id}</td><td>${requestScope.comment.pblic==1?"可见":"隐藏"}</td><td>${requestScope.comment.imgname}</td>
                <td>${requestScope.comment.item1_id}</td> <td>${requestScope.comment.date}</td>
                </tr>
            </table>
        </form>
    <div style="width:fit-content; margin: 0 auto;">
        <a href="commentServlet?action=page">
            <button class="blue"> 返回 </button>
        </a>

        <a href="commentServlet?action=DelById&id=${requestScope.comment.cmt_id}">
            <button class="blue"> 删除 </button>
        </a>

        <a href="commentServlet?action=Update&id=${requestScope.comment.cmt_id}">
            <button class="blue"> 编辑 </button>
        </a>
    </div>
        </div>
    </div>

    <div class="dtest2">
        dtest2
        <div class="dtest4">
            dtest4
        </div>
    </div>

    </div>
    </div>

</body>
</html>
