package com.jeang.controller;

import com.jeang.service.UserService;
import org.springframework.stereotype.Controller;

/**
 * @Controller：表现层组件，等价于 @Component
 * <p>
 * 构造器注入：类只有一个构造方法时，@Autowired 可以省略，Spring 会自动使用它注入
 * （推荐写法：属性可声明为 final，依赖不可变）
 */
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void list() {
        System.out.println("[Controller] 接收请求，调用 UserService");
        userService.queryUser(1001);
    }
}
