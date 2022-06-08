package com.czy.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLoginInterceptor implements HandlerInterceptor {
    //登陆前拦截器，拦截没有正确登录的请求
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果session是空的话，我们就拦截他的 请求，否则就放行
        if(request.getSession().getAttribute("userSession")==null){
            //存入一个msg
            request.setAttribute("msg","您没有权限，请先登录");
            //请求内跳转到登录页面
            request.getRequestDispatcher("/index").forward(request,response);
            return false;
        }
        return true;
    }
}
