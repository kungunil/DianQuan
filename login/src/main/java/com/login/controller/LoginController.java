package com.login.controller;

import com.login.entity.User;
import com.login.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {
    @Resource
    private UserService service;


    /*
   功能:用户登录方法
   返回值:数据和视图

   * */
    @RequestMapping("/loginUser.do")
    public ModelAndView login(HttpServletResponse response, HttpServletRequest request, HttpSession session)  {
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //封装成User对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);

        ModelAndView mv = new ModelAndView();
        //checkUser为查询数据库得到的User对象
        User checkUser =  service.findUser(loginUser.getUsername());
        //2.判断用户名是否存在
        if(checkUser != null&&checkUser.getType()==2){
            //3.用户名存在,判断密码是否正确
            if(checkUser.getPassword().equals(loginUser.getPassword())){
                session.setAttribute("login_user",checkUser);
                System.out.println(checkUser.getU_id());
                session.setAttribute("user_id",checkUser.getU_id());
                System.out.println("黄龙的user:_______________________"+checkUser);
                System.out.println("controller方法中:login_user:"+checkUser.getUsername());
                mv.addObject("login_msg","登录成功!");
                mv.setViewName("forward:/WEB-INF/jsp/loginSuccess.jsp");

            }else {
                mv.addObject("login_msg","密码错误!");
                mv.setViewName("forward:/loginUser.jsp");

            }
        }else {
            mv.addObject("login_msg","用户名不对!");
            mv.setViewName("forward:/loginUser.jsp");
        }
        return mv;
    }

    @RequestMapping("/adminLogin.do")
    public ModelAndView adminLogin(HttpServletRequest request ,HttpSession session ){
        ModelAndView mv = new ModelAndView();
        //获取请求参数
        String admin_name = request.getParameter("admin_name");
        String admin_pwd = request.getParameter("admin_pwd");

        User queryAdmin = service.findUser(admin_name);
        if(queryAdmin==null){
            mv.addObject("admin_msg","无此管理员,检查管理员名称!");
            mv.setViewName("forward:/adminLogin.jsp");
            return mv;
        }
        if(queryAdmin.getType()==1&&queryAdmin.getPassword().equals(admin_pwd)){
            session.setAttribute("login_user",queryAdmin);
            mv.addObject("admin_msg","管理员"+queryAdmin.getUsername()+"欢迎您!");
            mv.setViewName("forward:/WEB-INF/jsp/adminLoginSuccess.jsp");

        }else {
            mv.addObject("admin_msg","密码错误,请重新输入!");
            mv.setViewName("forward:/adminLogin.jsp");
        }
        return mv;
    }

}
