package com.itcast.store.dao;

import java.sql.SQLException;

import com.itcast.store.domain.User;

public interface UserDao {
    void userRegist(User user) throws Exception;

    User userLogin(User user) throws Exception;
}
