package com.itcast.store.service;

import java.sql.SQLException;
import java.util.List;

import com.itcast.store.domain.Category;

public interface CategoryService {

    List<Category> getAllcats() throws SQLException;


}
