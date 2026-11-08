package com.jeang.service;

import com.jeang.dao.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserImpl userImpl;
    @Value("${msg_content}")
    private String msg;

    public void save() {
        System.out.println("UserService save running..." + msg);
        userImpl.save();
    }
}
