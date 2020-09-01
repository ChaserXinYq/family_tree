package com.xyq.dao;

import com.xyq.dao.impl.UserDaoImpl;

import com.xyq.domain.User;
import org.junit.Test;

public class RegisterDaoTest {

    @Test
    public void testRegisterDao(){
        UserDao dao = new UserDaoImpl();
        dao.findByPhoneAndPassword("123123123", "123123");

    }

    @Test
    public void testLoginDao(){
        UserDao dao = new UserDaoImpl();
        User user = dao.findByPhoneAndPassword("13097018075", "123123123");
        System.out.println(user);
    }
}
