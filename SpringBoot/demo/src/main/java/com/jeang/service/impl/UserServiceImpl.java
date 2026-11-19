package com.jeang.service.impl;

import com.jeang.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("save...");
    }
}
