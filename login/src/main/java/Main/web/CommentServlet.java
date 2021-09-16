package Main.web;

import Main.Utils.UserBeanUtils;
import Main.bean.Comment;
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

public class CommentServlet extends BaseServlet{
    protected void CommentAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Comment> Comments = cmtService.getAllComments();

        req.setAttribute("comments", Comments);

        req.getRequestDispatcher("/pages/dianquan/comment_all.jsp").forward(req, resp);
    }

    protected void GetById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Comment cmt = cmtService.getCmtById(id);
        req.setAttribute("comment", cmt);
        req.getRequestDispatcher("/pages/dianquan/comment_one.jsp").forward(req, resp);
    }

    protected void DelById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        cmtService.delCmtById(id);

        resp.sendRedirect("/dianquan/commentServlet?action=page");
    }

    protected void UpdateCmt(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Comment cmt = UserBeanUtils.BeanUt(req.getParameterMap(), new Comment());
        cmtService.updateCmt(cmt);

        resp.sendRedirect("/dianquan/commentServlet?action=GetById&id="+cmt.getCmt_id());
    }

    protected void Update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Comment cmt = cmtService.getCmtById(id);

        req.setAttribute("comment",cmt);

        req.getRequestDispatcher("/pages/dianquan/comment_update.jsp").forward(req, resp);
    }

    protected void todayCount(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Comment> Comments = cmtService.getAllComments();
        Date today = new Date();
        int count = 0;

        SimpleDateFormat sft=new SimpleDateFormat("yyyy-MM-dd");
        today = sft.parse(sft.format(today));
        //一天毫秒:86400000
        for (Comment tmp : Comments) {
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

        Page<Comment> page =  cmtService.page(pageNo,pageSize);

        page.setUrl("commentServlet?action=page");
        req.setAttribute("page",page);

        req.getRequestDispatcher("/pages/dianquan/comment_all.jsp").forward(req, resp);
    }
}
