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
    public void test01(){
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
        Date date=new Date();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        String format = df.format(date);
        System.out.println(format);
        String dates="2018-08-29";
        Date dateN;
        try {
            dateN = df.parse(dates);
            System.out.println(dateN);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
