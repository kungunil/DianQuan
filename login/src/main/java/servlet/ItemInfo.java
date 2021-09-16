package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import DB.DBTool;
import bean.User;
import item.Itmifoanduac;

public class ItemInfo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String itemname = req.getParameter("itemname");
        String uidtemp = req.getParameter("uid");
        int itemid = DBTool.getitmidbyname(itemname);
        HttpSession session = req.getSession();
        com.login.entity.User utemp = (com.login.entity.User) session.getAttribute("login_user");
        User user = null;
        if (utemp != null) {
            user = new User();
            user.setUid(utemp.getU_id());
            user.setUsername(utemp.getUsername());
            user.setType(utemp.getType());
        }

        if (itemid == -1) {
            resp.setStatus(404);
        } else {
            String myjson = null;
            if (uidtemp != null) {
                int uid = Integer.parseInt(uidtemp);
                myjson = Itmifoanduac.getjsonuserlook(itemid, uid);
            }
            else {
                if (user != null) {
                    myjson = Itmifoanduac.getitemsjson(itemid, user.getUid());
                }
                else {
                    myjson = Itmifoanduac.getitemsjson(itemid, 0);
                }
            }

            System.out.println(myjson);
            resp.setContentType("application/json;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.print(myjson);
            out.flush();
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
