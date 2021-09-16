package Main.web;

import Main.Utils.UserBeanUtils;
import Main.bean.Page;
import Main.bean.User;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServlet extends BaseServlet {

    protected void UserAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> Users = userService.getAllUser();
        req.setAttribute("users", Users);

        req.getRequestDispatcher("/pages/dianquan/user_all.jsp").forward(req, resp);
    }

    protected void GetById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        User user = userService.getUserById(id);
        req.setAttribute("user", user);

        req.getRequestDispatcher("/pages/dianquan/user_one.jsp").forward(req, resp);
    }

    protected void DelById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        userService.delUserById(id);

        resp.sendRedirect("/dianquan/userServlet?action=page");
    }

    protected void UpdateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = UserBeanUtils.BeanUt(req.getParameterMap(), new User());
        userService.updateUser(user);

        resp.sendRedirect("/dianquan/userServlet?action=GetById&id="+user.getUser_id());
    }

    protected void Update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        User user = userService.getUserById(id);
        req.setAttribute("user",user);

        req.getRequestDispatcher("/pages/dianquan/user_update.jsp").forward(req, resp);
    }

    protected void adminCount(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<User> Users = userService.getAllUser();
        int count = 0;
        for(User user:Users){
            if(user.getType()==1){
                count++;
            }
        }
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("count", count);
        //3.利用gson将map封装成json对象
        Gson gson = new Gson();
        String json = gson.toJson(result);
        //4.返回结果
        resp.getWriter().write(json);
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        int pageNo = UserBeanUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = UserBeanUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<User> page =  userService.page(pageNo,pageSize);
        page.setUrl("userServlet?action=page");
        req.setAttribute("page",page);

        req.getRequestDispatcher("/pages/dianquan/user_all.jsp").forward(req, resp);
    }

}