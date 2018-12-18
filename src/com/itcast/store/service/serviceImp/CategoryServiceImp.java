package com.itcast.store.service.serviceImp;

import java.sql.SQLException;
import java.util.List;

import com.itcast.store.dao.CategoryDao;
import com.itcast.store.dao.UserDao;
import com.itcast.store.dao.daoImp.CategoryDaoImp;
import com.itcast.store.dao.daoImp.UserDaoImp;
import com.itcast.store.domain.Category;
import com.itcast.store.service.CategoryService;

public class CategoryServiceImp implements CategoryService {

    @Override
    public List<Category> getAllcats() throws SQLException {
        // TODO Auto-generated method stub
        CategoryDao categoryDao = new CategoryDaoImp();
        return categoryDao.getAllcats();

    }


}
