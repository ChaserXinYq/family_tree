package com.xyq.service;

import com.xyq.domain.User;

public interface UserService {
    Boolean addUser(User user);

    User findByUser(User user);

    User updateFid(User user);
}
