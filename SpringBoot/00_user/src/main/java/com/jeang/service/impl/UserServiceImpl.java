package com.jeang.service.impl;

import com.jeang.dao.UserDao;
import com.jeang.domain.User;
import com.jeang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getByid(int id) {
        return userDao.getByid(id);
    }
}
