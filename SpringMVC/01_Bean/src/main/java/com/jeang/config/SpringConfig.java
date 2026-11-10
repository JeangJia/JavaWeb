package com.jeang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(
        value = "com.jeang",
        excludeFilters = {
                // 按注解过滤：排除所有 @Controller 标识的类，交给 SpringMVC 容器管理
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        classes = Controller.class
                ),
                // 排除配置类所在包，避免 SpringMvcConfig 被 Spring 容器重复扫描
                @ComponentScan.Filter(
                        type = FilterType.REGEX,
                        pattern = "com\\.jeang\\.config\\..*"
                )
        }
)
public class SpringConfig {
}
