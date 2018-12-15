package com.itcast.store.web.servlet;

import com.itcast.store.domain.Category;
import com.itcast.store.service.CategoryService;
import com.itcast.store.service.serviceImp.CategoryServiceImp;
import com.itcast.store.web.base.BaseServlet;
import java.util.List;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/IndexServlet" })
public class IndexServlet extends BaseServlet {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService cService = new CategoryServiceImp();
        List<Category> categoryList;
        try {
            categoryList = cService.getAllcats();
            //System.out.println(categoryList);
            request.setAttribute("allCats", categoryList);
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "/jsp/index.jsp";
    }
}
