package com.itcast.store.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itcast.store.domain.Product;
import com.itcast.store.service.ProductService;
import com.itcast.store.service.serviceImp.ProductServiceImp;
import com.itcast.store.utils.PageModel;
import com.itcast.store.web.base.BaseServlet;

import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/ProductServlet" })
public class ProductServlet extends BaseServlet {
    // @Override
    public String findProductByPid(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String str = req.getParameter("pid");
        System.out.println(str);
        ProductService productService = new ProductServiceImp();
        Product findProductById = productService.findProductById(str);
        req.setAttribute("pcInfo", findProductById);
        System.out.println(findProductById);
        return "/jsp/product_info.jsp";
    }

    public String findProductsByCidWithPage(HttpServletRequest request,HttpServletResponse response) throws Exception{
       String cid = request.getParameter("cid");
       String num = request.getParameter("num");
       System.out.println(cid+" "+num);
       ProductService productService=new ProductServiceImp();
       PageModel pModel=productService.findProductsByCidWithPage(cid,num);
       System.out.println(pModel.getList());
       request.setAttribute("page", pModel);
       return "/jsp/product_list.jsp";
    }

}
