package com.itcast.store.service.serviceImp;

import java.sql.SQLException;

import com.itcast.store.dao.UserDao;
import com.itcast.store.dao.daoImp.UserDaoImp;
import com.itcast.store.domain.User;
import com.itcast.store.service.UserService;

public class UserServiceImp implements UserService {

    @Override
    public void userRegist(User user) throws Exception {
        // TODO Auto-generated method stub
        UserDao userDao = new UserDaoImp();
        userDao.userRegist(user);
    }

    @Override
    public User userLogin(User user) throws Exception {
        // TODO Auto-generated method stub
        UserDao userDao = new UserDaoImp();
        User uu = userDao.userLogin(user);
        if (uu==null) {
            throw new RuntimeException("密码不正确");
        }else if (uu.getState()==0) {
            throw new RuntimeException("用户未激活");
        }else {
            return uu;
        }
        
    }

}
