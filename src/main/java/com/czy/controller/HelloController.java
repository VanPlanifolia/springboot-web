package com.czy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
    @RequestMapping("/tohello")
    public String toHello(Model model){
        String[] user={"张三","李四"};
        model.addAttribute("msg","helloMsg");
        model.addAttribute("usermsg",user);
        return "hello";
    }
}
