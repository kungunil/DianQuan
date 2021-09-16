package com.login.controller;

import com.github.pagehelper.PageHelper;
import com.login.dao.UserDB;
import com.login.entity.Item;
import com.login.util.PageBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TopList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String _pageNum = req.getParameter("pageNum");
        int pageNum = Integer.parseInt(_pageNum);

        PageBean<Item> itemPageBean = new PageBean<>();
        UserDB userDB = new UserDB();
        int totalCount = userDB.selectTopListCounts();
        itemPageBean.setTotalCounts(totalCount);
        itemPageBean.setRows(5);
        //开始的索引
        int start = (pageNum-1)*itemPageBean.getRows();
        itemPageBean.setCurrentPage(start);
        //计算总页码:
        int totalPage = totalCount%itemPageBean.getRows() == 0 ? totalCount/itemPageBean.getRows() : totalCount/itemPageBean.getRows() +1;
        itemPageBean.setTotalPage(totalPage);
        List<Item> list = userDB.getTopList();
        itemPageBean.setList(list);
        System.out.println(list.size());



        System.out.println("------执行了TopListController---------------");
        req.setAttribute("pb",itemPageBean);
        try {
            req.getRequestDispatcher("./toplist.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
