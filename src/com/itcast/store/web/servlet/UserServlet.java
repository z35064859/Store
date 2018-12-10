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
import com.itcast.store.utils.UUIDUtils;
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
        MyBeanUtils.populate(user, parameterMap);
        System.out.println(user);
        // 为用户其他属性赋值，uid,code
        user.setUid(UUIDUtils.getId());
        user.setState(0);
        user.setCode(UUIDUtils.getCode());
        
        // 调用业务层注册功能

        try {
            UserService userService = new UserServiceImp();
            userService.userRegist(user);
            // 注册成功，向用户邮箱发送信息，跳转提示界面
            request.setAttribute("msg", "注册成功，请激活");
        } catch (Exception e) {
            // TODO: handle exception
            // 注册失败，跳转提示页面
            request.setAttribute("msg", "注册失败，请重新注册");
        }
        return "/jsp/info.jsp";
    }

}