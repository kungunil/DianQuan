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
  收藏页面！
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
    UserInfo user=new UserInfo();
    int id= (int) session.getAttribute("user_id");
    user=dataDB.GetUserInfo(id);//此处需要登录id
    String attentionlist=user.getCollection();
    String[] at=attentionlist.split(",");
    String atn="";
    for (int k=0;k<at.length;k++){
        for(int j=0;j<attentions.size();j++){
            if (at[k].equals(String.valueOf(attentions.get(j).getId()))){
                atn+= ""+at[k]+",";

            }
        }
    }
    if (atn==null||atn.length()==0){%>
        收藏为空！
 <%
    }else {
 %>
<%

    String[] result=atn.split(",");
    int i=0;
    for (String r:result){

%>
<body>
<a href="context.jsp?id=<%=attentions.get(MyTools.find(attentions,MyTools.strToint(r))).getId()%>"><table>
    <hr><tr><td><%=i+1%>:</td><td><b><font style="color: crimson;"><%if (attentions.get(MyTools.find(attentions,MyTools.strToint(r))).getContex().length()>=5){%><%=attentions.get(MyTools.find(attentions,MyTools.strToint(r))).getContex().substring(0,5)%>.....<%}else {%><%=attentions.get(MyTools.find(attentions,MyTools.strToint(r))).getContex().substring(1)%><%}%></font></b></td><td><a href="DeleteCollection?id=<%=r%>&uid=<%=id%>">删除</a></td></tr>
    <tr>
        <td>
            <br>
        </td>
    </tr>
</table></a>
<br>
</body>
<%
    i++;}
    }
%>