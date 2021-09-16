package Main.web;

import Main.Utils.UserBeanUtils;
import Main.bean.Item;
import Main.bean.Page;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerServlet extends BaseServlet {
    protected void ManagerAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Item> Managers = tmService.ManagerAllTm();

        req.setAttribute("managers", Managers);

        req.getRequestDispatcher("/pages/dianquan/manager_all.jsp").forward(req, resp);
    }

    protected void DelById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        tmService.managerDelById(id);
        resp.sendRedirect("/dianquan/managerServlet?action=page");
    }

    protected void GetById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Item tm = tmService.managerGetById(id);
        req.setAttribute("Tiaomu", tm);
        req.getRequestDispatcher("/pages/dianquan/manager_one.jsp").forward(req, resp);
    }

    protected void UpdateManager(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Item item = UserBeanUtils.BeanUt(req.getParameterMap(), new Item());
        tmService.updateManager(item);

        resp.sendRedirect("/dianquan/managerServlet?action=GetById&id=" + item.getItem_id());
    }

    protected void Update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        Item item = tmService.managerGetById(id);
        req.setAttribute("item", item);

        req.getRequestDispatcher("/pages/dianquan/manager_update.jsp").forward(req, resp);
    }

    protected void todayCount(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Item> Managers = tmService.ManagerAllTm();
        Date today = new Date();
        int count = 0;

        SimpleDateFormat sft=new SimpleDateFormat("yyyy-MM-dd");
        today = sft.parse(sft.format(today));

        //一天毫秒:86400000
        for (Item tmp : Managers) {
            Date date = tmp.getDate();
            if (date.getTime() - today.getTime() >= 0) {
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
        int pageSize = UserBeanUtils.parseInt(req.getParameter("pageSize"), 9);

        Page<Item> page =  tmService.pageManager(pageNo,pageSize);

        page.setUrl("managerServlet?action=page");
        req.setAttribute("page",page);

        req.getRequestDispatcher("/pages/dianquan/manager_all.jsp").forward(req, resp);
    }

}