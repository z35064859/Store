package com.itcast.store.service.serviceImp;

import java.sql.SQLException;
import java.util.List;

import com.itcast.store.dao.ProductDao;
import com.itcast.store.dao.daoImp.ProductDaoImp;
import com.itcast.store.domain.Product;
import com.itcast.store.service.ProductService;

public class ProductServiceImp implements ProductService {

    @Override
    public List<Product> findHots() throws SQLException{
        ProductDao productDao=new ProductDaoImp();
        List<Product> listHots=productDao.findHots();
        return listHots;
    }

    @Override
    public List<Product> findNews() throws SQLException {
        ProductDao productDao=new ProductDaoImp();
        List<Product> listNews=productDao.findNews();
        return listNews;
    }

    @Override
    public Product findProductById(String str) throws SQLException {
        ProductDao productDao=new ProductDaoImp();
        Product product=productDao.fingProductById(str);
        return product;
    }

}
