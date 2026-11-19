package com.jeang;

import com.jeang.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void testUserService() {
        System.out.println(userService.getByid(1));
    }

}
