package com.jeang.dao;

import org.springframework.stereotype.Repository;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println(System.currentTimeMillis());
        System.out.println("save running...");
    }

    @Override
    public int update() {
        return 100;
    }
}
