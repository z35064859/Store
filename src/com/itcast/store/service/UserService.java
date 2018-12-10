package com.itcast.store.service;

import java.sql.SQLException;

import com.itcast.store.domain.User;

public interface UserService {
    void userRegist(User user) throws Exception;
}
