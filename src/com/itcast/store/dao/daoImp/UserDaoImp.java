package com.itcast.store.dao.daoImp;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

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

    @Override
    public User userLogin(User user) throws SQLException{
        System.out.println(user.getUsername()+""+user.getPassword());
        User user2=new User();
        String sql="select * from user where username=? and password=?";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        return qr.query(sql, new BeanHandler<User>(User.class),user.getUsername(),user.getPassword());
        
    }
    
}
