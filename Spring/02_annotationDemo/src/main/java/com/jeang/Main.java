package com.jeang;

import com.jeang.config.SpringConfig;
import com.jeang.controller.UserController;
import com.jeang.service.MockUserService;
import com.jeang.service.ReportService;
import com.jeang.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * 注解开发样例入口
 * <p>
 * 对比 01_IocDemo：那边用 applicationContext.xml 注册 Bean，这里全部由注解完成，
 * 容器通过 SpringConfig 配置类启动。
 */
public class Main {

    public static void main(String[] args) {
        // 纯注解方式启动容器：传入配置类（无需 XML）
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        System.out.println("\n===== 1. @Repository / @Service / @Controller + 依赖注入 =====");
        UserController userController = ctx.getBean(UserController.class);
        userController.list();

        System.out.println("\n===== 2. @Qualifier 在同类型多个 Bean 中选择 =====");
        ctx.getBean(MockUserService.class).queryUser(1001);

        System.out.println("\n===== 3. @Value 读取 properties + @Bean 注入第三方对象 =====");
        UserService userService = ctx.getBean("userService", UserService.class);
        userService.queryUser(2002);

        System.out.println("\n===== 4. 作用域：singleton 与 prototype =====");
        System.out.println("userService 两次获取是否为同一对象: "
                + (userService == ctx.getBean("userService")));
        System.out.println("reportService 两次获取是否为同一对象: "
                + (ctx.getBean(ReportService.class) == ctx.getBean(ReportService.class)));

        System.out.println("\n===== 5. 容器中由注解扫描注册的 Bean =====");
        Arrays.stream(ctx.getBeanDefinitionNames())
                .filter(name -> {
                    Class<?> type = ctx.getType(name);
                    // 排除配置类自身（@Configuration 会被 CGLIB 增强，类名带 $$）
                    return type != null && type.getName().startsWith("com.jeang")
                            && !type.getName().contains("$$");
                })
                .sorted()
                .forEach(name -> System.out.println(name + " -> " + ctx.getType(name).getSimpleName()));

        // 容器关闭，触发 @PreDestroy
        System.out.println("\n===== 6. 关闭容器，触发 @PreDestroy =====");
        ctx.close();
    }
}
