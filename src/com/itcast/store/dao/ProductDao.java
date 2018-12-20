package com.itcast.store.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itcast.store.domain.Product;
import com.itcast.store.utils.JDBCUtils;
import com.itcast.store.utils.PageModel;
import com.sun.javafx.sg.prism.web.NGWebView;

public interface ProductDao {

    List<Product> findNews() throws SQLException;

    List<Product> findHots() throws SQLException;

    Product fingProductById(String str) throws SQLException;

    static int findTotalRecords(String cid) throws SQLException {
        String sql = "select count(*) from product where cid=" + cid + "";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Long num = (Long) queryRunner.query(sql, new ScalarHandler());
        return num.intValue();
    }

    static List findProductsByCidWithPage(String cid, int startIndex, int pageSize) throws SQLException {
        String sql1 = "select * from product where cid=" + cid + " limit " + startIndex + "," + pageSize + "";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        return queryRunner.query(sql1, new BeanListHandler<Product>(Product.class));
    }

}
