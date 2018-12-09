package com.itcast.store.web.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itcast.store.web.base.BaseServlet;


@WebServlet(asyncSupported = true, urlPatterns = { "/UserServlet" })
public class UserServlet extends BaseServlet {

	
    //注册页面跳转registUI
	public String registUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "/jsp/register.jsp";
	}
	//注册userRegist
	public String userRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收表单参数
	    Map<String, String[]> parameterMap = request.getParameterMap();
	  for(Entry<String, String[]> entry:parameterMap.entrySet()) {
	      System.out.println(entry.getKey());
	      for(String str:entry.getValue()) {
	          System.out.println(str);
	      }
	  }
	    //调用业务层注册功能
	    //注册成功，向用户邮箱发送信息，跳转提示界面
	    //注册失败，跳转提示页面
	    return "/jsp/register.jsp";
    }
	
}