package com.itcast.store.dao.daoImp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itcast.store.dao.CategoryDao;
import com.itcast.store.domain.Category;
import com.itcast.store.utils.JDBCUtils;

public class CategoryDaoImp implements CategoryDao {

    @Override
    public List<Category> getAllcats() throws SQLException {
        // TODO Auto-generated method stub
        String sql = "select * from category";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<Category> list = queryRunner.query(sql, new BeanListHandler<Category>(Category.class));
        System.out.println(list);
        return list;
    }

    @Override
    public List<Category> findNews() {
        String sql = "SELECT * FROM product WHERE is_hot=1 AND pflag=0 ORDER BY pdate DESC LIMIT 0,9";
        QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
        return null;
    }

    @Override
    public List<Category> findHots() {
        String sql = "SELECT * FROM product WHERE pflag=0 ORDER BY pdate DESC LIMIT 0,9";

        return null;
    }

}
