package com.login.handler;

import com.login.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User login_user = (User) request.getSession().getAttribute("login_user");

        String username = request.getParameter("username");
        System.out.println("login_user:"+login_user+"-----username:"+username);
        if(!"".equals(login_user)&&login_user!=null){
            if(login_user.getUsername().equals(username)){

                //login_flag登录标识,0 未登录,1已登录
                request.getSession().setAttribute("login_flag","1");
                request.getSession().setAttribute("username",username);
                request.getRequestDispatcher("/loginUser.jsp").forward(request,response);
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
