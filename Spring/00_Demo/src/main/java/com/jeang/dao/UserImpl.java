package com.jeang.dao;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("userImpl")
@Scope("prototype")
public class UserImpl extends User {
    public UserImpl() {
    }

    public UserImpl(String name, int age) {
        super(name, age);
    }

    public void save() {
        System.out.println("userImpl save running...");
    }

    @PostConstruct
    public void init() {
        System.out.println("init running...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy running...");
    }
}
