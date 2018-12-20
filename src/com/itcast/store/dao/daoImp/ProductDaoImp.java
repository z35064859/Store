package com.itcast.store.dao.daoImp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itcast.store.dao.ProductDao;
import com.itcast.store.domain.Product;
import com.itcast.store.utils.JDBCUtils;
import com.itcast.store.utils.PageModel;


public class ProductDaoImp implements ProductDao {

    @Override
    public List<Product> findNews() throws SQLException {
        String sqlN = "SELECT * FROM product WHERE is_hot=1 and pflag=0 ORDER BY pdate DESC LIMIT 0,9";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<Product> queryN = queryRunner.query(sqlN, new BeanListHandler<Product>(Product.class));
        System.out.println(queryN);
        return queryN;
    }

    @Override
    public List<Product> findHots() throws SQLException {
        String sqlN = "SELECT * FROM product WHERE pflag=0 ORDER BY pdate DESC LIMIT 0,9";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<Product> queryH = queryRunner.query(sqlN, new BeanListHandler<Product>(Product.class));
        System.out.println(queryH);
        return queryH;
    }

    @Override
    public Product fingProductById(String str) throws SQLException{
        String findSql="select * from product where pid="+str+"";
        QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
        Product product=queryRunner.query(findSql, new BeanHandler<Product>(Product.class));
        return product;
    }


 

}
