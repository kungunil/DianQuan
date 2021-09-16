<%@ page import="common.DataDB" %>
<%@ page import="bean.ContextInfo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="bean.UserInfo" %>
<%@ page import="bean.MyTools" %><%--
  Created by IntelliJ IDEA.
  User: 33700
  Date: 2021/6/16
  Time: 19:22
  To change this template use File | Settings | File Templates.

  关注页面！
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style type="text/css">
    body{
        background-image:url(img/img_4.png);
        background-repeat:no-repeat;
        background-size:100% auto;
    }
</style>
<%
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=utf-8");
    DataDB dataDB=new DataDB();
    ArrayList<ContextInfo> attentions=dataDB.GetAllattention();
    ArrayList<UserInfo> users=dataDB.GetAlluser();
    UserInfo user=new UserInfo();
    int id= (int) session.getAttribute("user_id");
    user=dataDB.GetUserInfo(id);//此处需要登录id
    String collectionlist=user.getAttention();
    if (collectionlist==null||collectionlist.length()==0){
        %>
    关注为空！
    <%
    }else {
    %>
<%
    System.out.println(collectionlist);
    String subcollection=collectionlist.substring(0,collectionlist.length());

    String[] result=subcollection.split(",");
    int i=0;
    for (String r:result){

%>
<body>
<a href="context2.jsp?id=<%=r%>"><table>
    <hr>
    <tr>
        <td>
            <%=i+1%>:
        </td>
        <td>
            <b><font style="color: crimson;"><%=users.get(MyTools.finduser(users,MyTools.strToint(r))).getNickname()%></font></b>
        </td>
        <td>
            <a href="DeleteAttention?id=<%=r%>&uid=<%=id%>">&nbsp;删除</a>
        </td>
    </tr>
    <tr>
        <td>
            <br>
        </td>
    </tr>
</table></a>


</body>
<%
        i++;}
    }
%>