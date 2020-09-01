package com.xyq.dao;

import com.xyq.domain.User;

public interface UserDao {

    User findByPhoneAndPassword(String phone, String password);

    User findByPhone(String phone);

    void addUser(User user);

    void updateFid(User user, String fid);

}
