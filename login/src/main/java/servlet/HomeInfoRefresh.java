package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import home.Inforfs;

public class HomeInfoRefresh extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String myjson = null;
        com.login.entity.User utemp = (com.login.entity.User) session.getAttribute("login_user");
        User user = null;
        if (utemp != null) {
            user = new User();
            user.setUid(utemp.getU_id());
            user.setUsername(utemp.getUsername());
            user.setType(utemp.getType());
        }
        if (user == null) {
            myjson = Inforfs.refreshitem(0);
        }
        else {
            myjson = Inforfs.refreshitem(user.getUid());
        }
        
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(myjson);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
