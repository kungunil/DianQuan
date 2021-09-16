package com.login.controller;

import com.login.dao.UserDB;
import com.login.entity.User;
import com.login.service.UserService;
import com.login.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class forgetPwdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println("---------------:"+username);
        UserDB userDB = new UserDB();
        User user = userDB.getUserByName(username);
        System.out.println("---------user:"+user);

        if(user==null){
            req.setAttribute("forgetPwd_msg","用户名不存在,重新输入");
            req.getRequestDispatcher("/forgetPwd.jsp").forward(req,resp);
           return;
        }
        req.setAttribute("username",user.getUsername());
        req.setAttribute("question",user.getQuestion());
        req.getRequestDispatcher("/WEB-INF/jsp/getPwd.jsp").forward(req,resp);
    }
}
