package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import fav.Fav;

public class DoFav extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        com.login.entity.User utemp = (com.login.entity.User) session.getAttribute("login_user");
        User user = null;
        if (utemp != null) {
            user = new User();
            user.setUid(utemp.getU_id());
            user.setUsername(utemp.getUsername());
            user.setType(utemp.getType());
        }

        if (user == null) {
            resp.sendRedirect(req.getContextPath()+"/login");
        } else {
            int uid = user.getUid();
            String wt = req.getParameter("wt"); // user, collect
            int id = Integer.parseInt(req.getParameter("id"));  //用户操作的对象的id:uid,cmtid
            int type = Integer.parseInt(req.getParameter("type"));
            PrintWriter out = resp.getWriter();

            if (wt.equals("user")) {
                Fav.followuser(type, uid, id);
            } else if (wt.equals("collect")) {
                Fav.collect(type, uid, id);
            }

            resp.setContentType("application/json;charset=UTF-8");
            out.print("{\"returninfo\":\"ok\"}");
            out.flush();
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
