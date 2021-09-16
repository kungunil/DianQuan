package com.login.handler;
import com.login.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLoginIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User login_admin = (User) request.getSession().getAttribute("login_user");

        String admin_name = request.getParameter("admin_name");
        if(login_admin!=null){
            if(login_admin.getUsername().equals(admin_name)){
                //admin_flag登录标识,0 未登录,1已登录
                request.getSession().setAttribute("admin_flag","1");
                request.getSession().setAttribute("admin_name",admin_name);
                request.getRequestDispatcher("/adminLogin.jsp").forward(request,response);
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
