package com.itcast.store.dao.daoImp;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itcast.store.dao.UserDao;
import com.itcast.store.domain.User;
import com.itcast.store.utils.JDBCUtils;

public class UserDaoImp implements UserDao{

    @Override
    public void userRegist(User user) throws SQLException {
        // TODO Auto-generated method stub
        String sql="insert into user values(?,?,?,?,?,?,?,?,?,?)";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        System.out.println(user.getSex());
        Object[] params= {user.getUid(),user.getUsername(),user.getPassword(),
                user.getName(),user.getEmail(),user.getTelephone(),
                user.getBirthday(),user.getSex(),user.getState(),
                user.getCode()};
        qr.update(sql, params);
    }
    
}
