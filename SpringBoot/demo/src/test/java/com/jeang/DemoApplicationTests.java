package com.jeang;

import com.jeang.dao.UserDao;
import com.jeang.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;

    @Test
    public void save() {
        userService.save();
    }

    @Test
    public void getByid() {
        System.out.println(userDao.getByid(1).getPassword());
    }

}
