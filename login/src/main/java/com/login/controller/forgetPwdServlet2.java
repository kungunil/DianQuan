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

public class forgetPwdServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String question = req.getParameter("question");
        String answer = req.getParameter("answer");
        UserDB userDB = new UserDB();
        User user = userDB.getUserByName(username);
        if(user!=null){
            if(answer.equals(user.getAnswer())){
                req.setAttribute("getPwd_msg","您的密码是:"+user.getPassword()+"请谨记!");
                req.getRequestDispatcher("/WEB-INF/jsp/findPwdSuccess.jsp").forward(req,resp);
            }else {
                req.setAttribute("username",username);
                req.setAttribute("question",question);
                req.setAttribute("answer",answer);
                req.setAttribute("getPwd_msg","答案错误,请检查您的输入");
                req.getRequestDispatcher("/WEB-INF/jsp/getPwd.jsp").forward(req,resp);
            }
        }
    }
}
