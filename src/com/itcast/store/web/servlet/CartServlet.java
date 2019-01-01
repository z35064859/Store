package com.itcast.store.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itcast.store.dao.ProductDao;
import com.itcast.store.domain.CarItem;
import com.itcast.store.domain.Cart;
import com.itcast.store.domain.Product;
import com.itcast.store.service.ProductService;
import com.itcast.store.service.serviceImp.ProductServiceImp;
import com.itcast.store.web.base.BaseServlet;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/CartServlet" })
public class CartServlet extends BaseServlet {
    public String addCartItemToCart(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (null == cart) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);

        }
        // 获取Pid和数量
        String pid = request.getParameter("pid");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        // 通过id查询商品对象
        ProductService productService = new ProductServiceImp();
        Product product = productService.findProductById(pid);
        // 获取到待购买的购物项
        CarItem carItem = new CarItem();
        carItem.setNum(quantity);
        carItem.setProduct(product);
        // 添加到购物车
        cart.addCatItemToCar(carItem);
        cart.setTotal();
        response.sendRedirect("/store_v5/jsp/cart.jsp");
        return null;
    }

    public String removeCartItemFromCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        String id = request.getParameter("id");
        cart.removeCatItem(id);
        cart.setTotal(); 
        response.sendRedirect("/store_v5/jsp/cart.jsp");
        return null;
    }
    public String removeAllCartItemFromCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.clearCatItem(); 
        response.sendRedirect("/store_v5/jsp/cart.jsp");
        System.out.println("已清空");
        return null;
    }
    
}
