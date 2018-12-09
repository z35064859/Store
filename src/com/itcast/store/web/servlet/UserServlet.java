package com.itcast.store.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.DateConversion;

import com.itcast.store.domain.User;
import com.itcast.store.service.UserService;
import com.itcast.store.service.serviceImp.UserServiceImp;
import com.itcast.store.utils.MyBeanUtils;
import com.itcast.store.web.base.BaseServlet;

@WebServlet(asyncSupported = true, urlPatterns = { "/UserServlet" })
public class UserServlet extends BaseServlet {

    // 注册页面跳转registUI
    public String registUI(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return "/jsp/register.jsp";
    }

    // 注册userRegist
    public String userRegist(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
        // 接收表单参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
      /*  // 创建时间类型转换器
        DateConverter dt = new DateConverter();
        // 设置转换格式
        dt.setPattern("yyyy-MM-dd");
        // 注册转换器
        ConvertUtils.register(dt, java.util.Date.class);
        BeanUtils.populate(user, parameterMap);*/
        MyBeanUtils.populate(user, parameterMap);
        //调用业务层注册功能
        UserService userService=new UserServiceImp();
        userService.userRegist(user);
        //System.out.println(user);
        /*
         * for(Entry<String, String[]> entry:parameterMap.entrySet()) {
         * System.out.println(entry.getKey()); for(String str:entry.getValue()) {
         * System.out.println(str); } }
         */
        // 调用业务层注册功能
        // 注册成功，向用户邮箱发送信息，跳转提示界面
        // 注册失败，跳转提示页面
        return "/jsp/register.jsp";
    }

}