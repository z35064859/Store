package com.itcast.store.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itcast.store.web.base.BaseServlet;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/CartServlet" })
public class CartServlet extends BaseServlet {
	public String addCartItemToCart(HttpServletRequest request,HttpServletResponse response) {
            String quantity=request.getParameter("quantity");
            String pid=request.getParameter("pid");
            System.out.println(quantity+" "+pid);
            return "/jsp/cart.jsp";
    }

}
