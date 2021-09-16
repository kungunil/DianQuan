package servlet;

import bean.MyTools;
import common.DataDB;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteAttention extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=MyTools.strToint(request.getParameter("id"));
        int uid= MyTools.strToint(request.getParameter("uid"));
        DataDB dataDB=new DataDB();
        dataDB.DeleteAttention(uid,id);
        response.sendRedirect("myattention.jsp");
    }
}
