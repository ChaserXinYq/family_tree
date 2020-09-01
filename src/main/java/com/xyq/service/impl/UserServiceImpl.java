package com.xyq.service.impl;

import com.xyq.dao.impl.UserDaoImpl;
import com.xyq.domain.User;
import com.xyq.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDaoImpl userDao = new UserDaoImpl();
    @Override
    public Boolean addUser(User user) {
        Boolean flag;
        //使用电话号码查询是否用户已经存在
        //存在返回false，不存在存入数据库返回true
        User phone = userDao.findByPhone(user.getPhone());
        if (phone==null){
            //用户不存在可以添加
            userDao.addUser(user);
            flag=true;
        }else {
            //用户存在了
            flag=false;

        }

        return flag;
    }

    @Override
    public User findByUser(User user) {
        User user1 = userDao.findByPhoneAndPassword(user.getPhone(), user.getUpassword());
        //如果用户存在，返回true
        if (user1 != null){
            return user1;
        }else {
            //用户不存在返回false
            return null;
        }
    }

    @Override
    public User updateFid(User user) {
        //创建fid
        String fid = System.currentTimeMillis()+"";
        //将创建好的fid存入user用户中
        user.setFid(fid);
        //调用UserDao更新user
        userDao.updateFid(user,fid);
        User u = userDao.findByPhone(user.getPhone());
        return u;
    }
}

