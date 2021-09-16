package com.login.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class verifyCodeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        String input_verifyCode = request.getParameter("input_verifyCode");
        String verifyCode = null;
        Object attribute = request.getSession().getAttribute("verifyCode");
        request.getSession().removeAttribute("verifyCode");
        Map<String,Object> map = new HashMap<String,Object>();
        if(attribute==null||input_verifyCode==null){
            return false;
        }
        if("".equals(input_verifyCode)){
            request.setAttribute("verifycode_msg","请输入验证码");
             request.getRequestDispatcher("/dianquan/registerUser.jsp").forward(request,response);
            return false;
        }
        verifyCode = (String) attribute;
        if(!verifyCode.equalsIgnoreCase(input_verifyCode)){
            System.out.println("verifycode_error");
            /*request.setAttribute("verifycode_msg","验证码错误!请重新输入");
            request.getRequestDispatcher("/registerUser.jsp").forward(request,response);*/
            HttpSession session = request.getSession();
            session.setAttribute("verifycode_msg","验证码错误!请重新输入");
            response.sendRedirect("/dianquan/registerUser.jsp");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

    }
}
