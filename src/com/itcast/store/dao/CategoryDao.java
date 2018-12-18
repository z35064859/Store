package com.itcast.store.dao;

import java.sql.SQLException;
import java.util.List;

import com.itcast.store.domain.Category;

public interface CategoryDao {

    List<Category> getAllcats() throws SQLException;

    List<Category> findNews();

    List<Category> findHots();

}
