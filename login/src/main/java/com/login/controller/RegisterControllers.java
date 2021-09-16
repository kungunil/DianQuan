package com.login.controller;

import com.login.entity.User;
import com.login.util.VerifyCode;
import com.login.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;


@Controller
public class RegisterControllers {
    @Resource
    private UserService service;

    //ajax 提示用户是否存在
    @RequestMapping("/userIfExist.do")
    @ResponseBody
    public void userIfExist(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");

        User user = service.findUser(username);
        Map<String,Object> map = new HashMap<>();
        if(user != null){
            /*userExist 判断用户是否存在,true为存在,false不存在;
            * msg :提示信息.
            * */
            map.put("userExist","true");
            map.put("msg","此用户太受欢迎,请更换一个!");
        }else {
            map.put("userExist","false");
            map.put("msg","此用户名可用");
        }

        //将数据转为json,传递给客户端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);
    }


    /*
    功能:用户注册方法
    返回值:数据和视图
    * */
    @RequestMapping("/registerUser.do")
    public ModelAndView register(HttpServletRequest request,HttpSession session) {
       ModelAndView mv = new ModelAndView();
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String question = request.getParameter("question");
        String answer = request.getParameter("answer");

        //参数封装为User对象
        User registerUser = new User();
        registerUser.setUsername(username);
        registerUser.setPassword(password);
        registerUser.setTelephone(telephone);
        registerUser.setEmail(email);
        registerUser.setQuestion(question);
        registerUser.setAnswer(answer);
        registerUser.setType(2);

        //判断用户名重复
        User serviceUser = service.findUser(registerUser.getUsername());
        if(serviceUser!=null){
            mv.addObject("register_msg","用户名已存在,请更换用户名!");
            mv.setViewName("forward:/registerUser.jsp");
        }else {
            //调用service方法注册用户,返回成功的行数,若>0则注册成功
            int rows =  service.addUser(registerUser);
            if(rows>0){
                session.setAttribute("register_user",registerUser);
                mv.addObject("register_username",username);
                mv.addObject("register_msg",username+"注册成功!");
                mv.setViewName("forward:/WEB-INF/jsp/registerSuccess.jsp");
            }else {
                mv.addObject("register_msg","注册失败!");
                mv.setViewName("forward:/registerUser.jsp");
            }
        }

       return mv;
    }



    //获取验证码
    @RequestMapping("/verifyCode.do")
    public void checkCode(HttpServletResponse response, HttpServletRequest request) {
        try {

            int width=200;
            int height=69;
            BufferedImage verifyImg=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
            //功能是生成验证码字符并加上噪点，干扰线，返回值为验证码字符
            String randomText = VerifyCode.drawRandomText(width,height,verifyImg);
            request.getSession().setAttribute("verifyCode", randomText);
            response.setContentType("image/png");
            OutputStream os = response.getOutputStream();
            ImageIO.write(verifyImg,"png",os);

            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}
