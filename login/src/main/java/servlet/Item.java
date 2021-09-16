package servlet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.DBTool;
import bean.User;

public class Item extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String itemname = req.getPathInfo().substring(1);
        HttpSession session = req.getSession();
        com.login.entity.User utemp = (com.login.entity.User) session.getAttribute("login_user");
        User user = null;
        if (utemp != null) {
            user = new User();
            user.setUid(utemp.getU_id());
            user.setUsername(utemp.getUsername());
            user.setType(utemp.getType());
        }

        String path = null;
        ServletContext sct = getServletContext();

        if (DBTool.isexistitem(itemname)) {
            path = sct.getRealPath("/item/commonitem.html");
            if (user != null && user.getType() == 1) {
                path = sct.getRealPath("/item/adminitem.html");
            }
        } else {
            path = sct.getRealPath("/item/itemnotfind.html");
        }
        PrintWriter out = resp.getWriter();
        try {
            FileInputStream fipts = new FileInputStream(path);
            BufferedReader itemhtml = new BufferedReader(new InputStreamReader(fipts));
            String temp = itemhtml.readLine();
            while (temp != null) {
                out.println(temp);
                temp = itemhtml.readLine();
            }
            itemhtml.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}