package com.login.controller;

import com.github.pagehelper.PageHelper;
import com.login.dao.UserDB;
import com.login.entity.Item;
import com.login.service.ItemService;
import com.login.service.impl.ItemServiceImpl;
import com.login.util.PageBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Search extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keywords = req.getParameter("keywords");
        String _pageNum = req.getParameter("pageNum");
        System.out.println("----------------------------pageNum:"+_pageNum);
        System.out.println("----------------------------keywords:"+keywords);
        int pageNum = Integer.parseInt(_pageNum);

        PageBean<Item> itemPageBean = new PageBean<>();
        UserDB userDB = new UserDB();
        itemPageBean.setKeywords(keywords);
        int totalCount = userDB.selectKeyCounts(keywords);
        itemPageBean.setTotalCounts(totalCount);
        itemPageBean.setRows(2);
        //开始的索引
        int start = (pageNum-1)*itemPageBean.getRows();
        //计算总页码:
        int totalPage = totalCount%itemPageBean.getRows() == 0 ? totalCount/itemPageBean.getRows() : totalCount/itemPageBean.getRows() +1;
        itemPageBean.setTotalPage(totalPage);
        List<Item> list = userDB.getKeyData(keywords,start,itemPageBean.getRows());
        itemPageBean.setList(list);
        System.out.println(list.size());

        if(itemPageBean.getList().isEmpty()){
            req.setAttribute("search_msg","无结果");
        }else {
            req.setAttribute("search_result",itemPageBean);
        }
        req.getRequestDispatcher("/search.jsp").forward(req,resp);
    }
}
