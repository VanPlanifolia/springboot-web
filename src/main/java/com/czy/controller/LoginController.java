package com.czy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(String username, String password, Model model, HttpSession session){
//        判断账号密码正确吗，正确的话跳转到主页
        if(password.equals("001")){
            //登录成功的话，往session中存入一个属性
            session.setAttribute("userSession",username);
            return "redirect:/dashboard";
        }
        model.addAttribute("msg","用户或密码不正确！");
        return "/index";
    }

    /**
     * 登出的Controller
     * @param session session
     * @return 重定向/index
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        Object userSession = session.getAttribute("userSession");
        if (userSession!=null){
            session.removeAttribute("userSession");
        }
        return "redirect:/index";
    }
}
