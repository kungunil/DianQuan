package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import recommend.rcm;

public class Rcm extends HttpServlet {

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

        if (user.getType() == 1) {
            int type = Integer.parseInt(req.getParameter("type"));
            int id = Integer.parseInt(req.getParameter("id"));
            if (type == 1) {
                rcm.itemrcm(id);
                
            } else if (type == 2) {
                rcm.cmtrcm(id);
            }
            resp.setContentType("application/json;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.print("{\"returninfo\":\"ok\"}");
            out.flush();
            out.close();
        } else {
            resp.setStatus(403);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
