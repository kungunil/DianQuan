package servlet;

import bean.MyTools;
import common.DataDB;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteCollection extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("你好");
        int id= MyTools.strToint(request.getParameter("id"));
        int uid= MyTools.strToint(request.getParameter("uid"));
        DataDB dataDB=new DataDB();
        dataDB.DeleteCollection(uid,id);
        response.sendRedirect("mycollection.jsp");
    }
}
