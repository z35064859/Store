package com.itcast.store.service;

import java.sql.SQLException;
import java.util.List;

import com.itcast.store.domain.Product;

public interface ProductService {

    List<Product> findHots() throws SQLException;

    List<Product> findNews() throws SQLException;

    Product findProductById(String str) throws SQLException;

}
