package com.itcast.store.dao;

import java.sql.SQLException;
import java.util.List;

import com.itcast.store.domain.Product;

public interface ProductDao {

    List<Product> findNews() throws SQLException;

    List<Product> findHots() throws SQLException;

    Product fingProductById(String str) throws SQLException;

}
