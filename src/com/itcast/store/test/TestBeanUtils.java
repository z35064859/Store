package com.itcast.store.test;

import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import com.itcast.store.domain.User;

public class TestBeanUtils {
    @Test
    public void test01() throws ParseException{
        HashMap<String, String[]> map = new HashMap<>();
        map.put("username", new String[] {"admin"});
        map.put("password", new String[] {"123"});
        User user=new User();
        try {
            BeanUtils.populate(user, map);
            System.out.println(user);
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //时间转换
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dateFormat.format(date));
        String string="2018-09-23";
        System.out.println(dateFormat.parse(string));
        
    }
}
