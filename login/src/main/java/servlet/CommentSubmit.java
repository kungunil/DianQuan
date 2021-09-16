package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import bean.Comment;
import bean.User;
import submit.Commentsbm;

@MultipartConfig()
public class CommentSubmit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            resp.sendRedirect(req.getContextPath()+"/login");  //重定向到登录页面
        }
        else {
            Comment usercmt = new Comment();
            Part imgpart = req.getPart("imgfile");
            String filerealname = imgpart.getSubmittedFileName();
            PrintWriter out = resp.getWriter();
            String returninfo;

            if (!filerealname.equals("")) {
                String filetype = filerealname.substring(filerealname.lastIndexOf("."));
                String filename = UUID.randomUUID().toString() + filetype;
                String path = req.getServletContext().getRealPath("./uploadimg/");
                System.out.println(path);
                usercmt.setImgname(filename);
                imgpart.write(path+filename);
            }

            usercmt.setCmttext(req.getParameter("cmttext"));
            usercmt.setItemid(Integer.parseInt(req.getParameter("itemid")));
            usercmt.setUid(user.getUid());
            if (req.getParameter("public").equals("true")) {
                usercmt.setPblic(true);
            }
            else {
                usercmt.setPblic(false);
            }

            if (Commentsbm.storage(usercmt) == 0) {
                returninfo = "failed";
            }
            else {
                returninfo = "ok";
            }

            resp.setContentType("application/json;charset=UTF-8");
            out.print("{\"returninfo\":\""+returninfo+"\"}");
            out.flush();
            out.close();
        }
    }
}
