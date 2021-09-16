package servlet;

import bean.UserInfo;
import common.DataDB;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Pswd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String password=request.getParameter("oldpassword");
        String newpassword=request.getParameter("newpassword");
        System.out.println("旧密码："+password);
        UserInfo user=new UserInfo();

        int id= (int) request.getSession().getAttribute("user_id");
        PrintWriter out=response.getWriter();
        DataDB dataDB=new DataDB();
        user=dataDB.GetUserInfo(id);

        if (!(user.getPassword().equals(password))){

            out.println("{\"flag\":\"false\"}");
        }
        else {
            out.println("{\"flag\":\"true\"}");
            System.out.println("新密码:"+newpassword);
            dataDB.ModifyUserPassword(id,newpassword);
        }



    }
}
