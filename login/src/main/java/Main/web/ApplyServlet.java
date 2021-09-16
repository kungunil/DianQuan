package Main.web;

import Main.Utils.UserBeanUtils;
import Main.bean.ItemApply;
import Main.bean.Page;
import Main.bean.User;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplyServlet extends BaseServlet {

    protected void Apply(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ItemApply tm = UserBeanUtils.BeanUt(req.getParameterMap(), new ItemApply());

        //设置当前申请时间
        Date utilDate = new Date();
        Timestamp sqlDate = new Timestamp(utilDate.getTime());
        tm.setDate(sqlDate);

        System.out.println(tmService.saveApply(tm));

        resp.sendRedirect("/dianquan/pages/dianquan/apply_success.jsp");
    }

    protected void GetAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<ItemApply> applys = tmService.getAllApply();

        req.setAttribute("applys", applys);

        req.getRequestDispatcher("/pages/dianquan/apply_all.jsp").forward(req, resp);
    }

    protected void SaveTm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ItemApply tm = tmService.applyGetById(id);

        tmService.savaTm(tm);
        tmService.applyDelById(id);

        resp.sendRedirect("/dianquan/applyServlet?action=page");
    }

    protected void GetById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ItemApply tm = tmService.applyGetById(id);
        req.setAttribute("Tiaomu", tm);
        req.getRequestDispatcher("/pages/dianquan/apply_one.jsp").forward(req, resp);
    }

    protected void UpdateApply(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String uaction = req.getParameter("uaction");
        ItemApply apply ;
        if(uaction.equals("statement")){
            apply =  tmService.applyGetById(Integer.parseInt(req.getParameter("id")));
            apply.setStatements(req.getParameter("statement"));
        }else{
            apply = UserBeanUtils.BeanUt(req.getParameterMap(), new ItemApply());
        }

        tmService.updateApply(apply);
        resp.sendRedirect("/dianquan/applyServlet?action=GetById&id=" + apply.getApply_id());
    }

    protected void Update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        ItemApply apply = tmService.applyGetById(id);
        req.setAttribute("apply", apply);

        req.getRequestDispatcher("/pages/dianquan/apply_update.jsp").forward(req, resp);
    }

    protected void ajaxExistName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数username
        String tmname = req.getParameter("tmname");

        System.out.println(tmname);

        //2.判断username是否存在
        boolean existsTmname = tmService.existsTmname(tmname);

        System.out.println(existsTmname);

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("existsTmname", existsTmname);
        //3.利用gson将map封装成json对象
        Gson gson = new Gson();
        String json = gson.toJson(result);
        //4.返回结果
        resp.getWriter().write(json);
    }

    protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUser_id(2019081244);
        user.setUsername("小波");

        System.out.println("设置session对象" + user.toString());

        req.getSession().setAttribute("login_user", user);
        resp.sendRedirect("/dianquan/applyServlet?action=page");
    }

    protected void DelById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        tmService.applyDelById(id);

        resp.sendRedirect("/dianquan/applyServlet?action=page");

    }

    protected void getApplysCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<ItemApply> allApply = tmService.getAllApply();
        int count = 0 ;
        for(ItemApply tmp : allApply){
            if(tmp.getStatements().equals("待审核")){
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

        Page<ItemApply> page =  tmService.pageApplys(pageNo,pageSize);

        page.setUrl("applyServlet?action=page");
        req.setAttribute("page",page);

        req.getRequestDispatcher("/pages/dianquan/apply_all.jsp").forward(req, resp);
    }
}
