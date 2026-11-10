package com.jeang.service;

import org.springframework.stereotype.Service;

@Service
public class AccountService {
    public void TestService() {
        for(int i=0;i<100;i++){
            System.out.println("Service Test");
        }
        System.out.println("Service Test");
    }
}
