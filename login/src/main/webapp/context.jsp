<%@ page import="bean.MyTools" %>
<%@ page import="java.awt.image.DataBuffer" %>
<%@ page import="common.DataDB" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.ContextInfo" %>
<%@ page import="bean.UserInfo" %><%--
  Created by IntelliJ IDEA.
  User: 33700
  Date: 2021/6/16
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int id= MyTools.strToint(request.getParameter("id"));
    int i=MyTools.strToint(request.getParameter("i"));
    DataDB dataDB=new DataDB();
    ArrayList<ContextInfo> attentions=new ArrayList<>();
    attentions=dataDB.GetAllattention();
    ArrayList<UserInfo> users=new ArrayList<>();
    users=dataDB.GetAlluser();
    UserInfo user=new UserInfo();

%>
<html>
<body>
<table>
    <tr>
        <td align="center"><%=dataDB.GetUserInfo(attentions.get(MyTools.find(attentions,id)).getUid()).getNickname()%></td>
    </tr>
    <tr>
        <td>
            <%=attentions.get(MyTools.find(attentions,id)).getContex()%>
        </td>
    </tr>
    <tr>
        <td>
            <%=attentions.get(MyTools.find(attentions,id)).getDate()%>
        </td>
    </tr>
</table>

</body>
</html>

