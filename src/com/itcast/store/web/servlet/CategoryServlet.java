package com.itcast.store.web.servlet;

import com.itcast.store.domain.Category;
import com.itcast.store.service.CategoryService;
import com.itcast.store.service.serviceImp.CategoryServiceImp;
import com.itcast.store.utils.JedisUtils;
import com.itcast.store.web.base.BaseServlet;

import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/CategoryServlet" })
public class CategoryServlet extends BaseServlet {
    public String findAllCats(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // redis获取,有直接读取，没有储存再读取\
        Jedis jedis = JedisUtils.getJedis();
        String string = jedis.get("allCats");
        if (null == string || "".equals(string)) {
            //redis没有数据
            System.out.println("没有数据");
            CategoryService categoryService = new CategoryServiceImp();
            java.util.List<Category> allcats = categoryService.getAllcats();
            String jsonStr = JSONArray.fromObject(allcats).toString();
            jedis.set("allCats", jsonStr);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(jsonStr);
        } else {
            //redis有数据
            String jsonStr = jedis.get("allCats");
            System.out.println("有数据");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(jsonStr);
        }

        return null;

    }

}
