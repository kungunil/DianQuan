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
        <form action="../dianquan/commentServlet" method="post">
            <input type="hidden" name="action" value="UpdateCmt">
            <input type="hidden" name="cmt_id" value="${requestScope.comment.cmt_id}">
            <table class="altrowstable" id="alternatecolor">
                <tr><th>点评id</th><th>点评内容</th><th>所属用户</th><th>可见性</th><th>点评图片</th><th>所属条目</th><th>时间</th></tr>
                <tr>
                    <td>${requestScope.comment.cmt_id}</td>
                    <td><input value="${requestScope.comment.cmttext}" id="cmttext" name="cmttext"></td>
                    <td>${requestScope.comment.user_id}</td>
                    <td><span style="font-size: 15px;color: #e51585"><input value="${requestScope.comment.pblic}" id="pblic" name="pblic">0隐藏1可见</span></td>
                    <td><input value="${requestScope.comment.imgname}" id="imgname" name="imgname"></td>
                    <td><input value="${requestScope.comment.item1_id}" id="item1_id" name="item1_id"></td>
                    <td><input value="${requestScope.comment.date}" id="date" name="date"></td>
                </tr>
            </table>


        <div style="width:fit-content; margin: 0 auto;">
            <a href="../dianquan/commentServlet?action=GetById&id=${requestScope.comment.cmt_id}">
                <button class="blue"> 返回 </button>
            </a>

            <button class="blue" type="submit">保存</button>
        </div>
        </form>
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
