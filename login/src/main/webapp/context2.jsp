<%@ page import="common.DataDB" %>
<%@ page import="bean.UserInfo" %>
<%@ page import="bean.MyTools" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.ContextInfo" %><%--
  Created by IntelliJ IDEA.
  User: 33700
  Date: 2021/6/17
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    DataDB dataDB =new DataDB();
    UserInfo user=new UserInfo();
    int id= MyTools.strToint(request.getParameter("id"));
    ArrayList<ContextInfo> attentions=new ArrayList<>();
    attentions=dataDB.GetAllattention();
    user=dataDB.GetUserInfo(id);
    String mysaylist=user.getMysay();
    String[] at=mysaylist.split(",");
    String atn="";
    for (int k=0;k<at.length;k++){
        for(int j=0;j<attentions.size();j++){
            if (at[k].equals(String.valueOf(attentions.get(j).getId()))){
                atn+= ""+at[k]+",";

            }
        }
    }
    System.out.println("mysaylist:"+mysaylist);
    if (atn.length()==0){
%>
发言为空！
<%
}else {
%>
<%
    String[] result=atn.split(",");
    int i=0;
    for (String r:result){

%>
<a href="context.jsp?id=<%=r%>"><table>
    <hr><tr><td><%=i+1%>:</td><td><b><font style="color: crimson;"><%if (attentions.get(MyTools.find(attentions,MyTools.strToint(r))).getContex().length()>=5){%><%=attentions.get(MyTools.find(attentions,MyTools.strToint(r))).getContex().substring(0,5)%>.....<%}else {%><%=attentions.get(MyTools.find(attentions,MyTools.strToint(r))).getContex().substring(1)%><%}%></font></b></td>
    <tr>
        <td>
            <br>
        </td>
    </tr>
</table></a>
<%
        i++;}}
%>


