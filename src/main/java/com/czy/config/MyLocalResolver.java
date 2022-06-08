package com.czy.config;

import org.springframework.cglib.core.Local;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 自定义的地址转换器，他可以拦截到前端的request，然后拿到里面的数据，然后修改响应头的内容
 * 我们要在这里面完成国际化地区的切换
 */
public class MyLocalResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取request信息中的地区参数
        String localMsg = request.getParameter("l");
        //获取地区信息,这个地区是获取的默认的
        Locale locale=Locale.getDefault();
        if(!StringUtils.isEmpty(localMsg)){
            //我们要处理字符串，取到请求消息里面的地区信息
            String[] local = localMsg.split("_");
            //创建一个Locale对象赋给locale变量并且返回
            locale=new Locale(local[0],local[1]);
        }
        return locale;
    }
    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
