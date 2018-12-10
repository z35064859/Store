package com.itcast.store.service.serviceImp;

import java.sql.SQLException;

import com.itcast.store.dao.UserDao;
import com.itcast.store.dao.daoImp.UserDaoImp;
import com.itcast.store.domain.User;
import com.itcast.store.service.UserService;

public class UserServiceImp implements UserService{

    @Override
    public void userRegist(User user) throws Exception {
        // TODO Auto-generated method stub
        UserDao userDao=new UserDaoImp();
        userDao.userRegist(user);
    }
   
}
