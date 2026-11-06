package com.jeang.service;

import com.jeang.dao.UserDao;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Service：业务层组件，等价于 @Component
 * "userService" 为手动指定的 Bean id，不写则默认 userService（类名首字母小写）
 */
@Service("userService")
public class UserService {

    /**
     * @Autowired：按类型注入
     * 此处 UserDao 有两个实现类，必须用 @Qualifier 指定 Bean 名称，否则启动报
     * NoUniqueBeanDefinitionException
     */
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    /** @Value：从 properties 读取简单类型，${key} 为占位符 */
    @Value("${app.name}")
    private String appName;

    /** 冒号后为默认值：配置中不存在 app.page-size 时使用 10 */
    @Value("${app.page-size:10}")
    private int pageSize;

    /** @Bean 注册的第三方对象同样可以按类型注入 */
    @Autowired
    private DateTimeFormatter dateTimeFormatter;

    @PostConstruct
    public void init() {
        System.out.println("[初始化] UserService 创建完成 -> appName=" + appName + ", pageSize=" + pageSize);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("[销毁] UserService 即将被容器销毁");
    }

    public void queryUser(int id) {
        System.out.println("【" + appName + "】" + LocalDateTime.now().format(dateTimeFormatter));
        System.out.println("查询结果: " + userDao.getUserById(id));
    }
}
