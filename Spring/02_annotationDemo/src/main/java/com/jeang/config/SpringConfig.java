package com.jeang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.time.format.DateTimeFormatter;

/**
 * 纯注解配置类，替代 applicationContext.xml
 */
@Configuration                                  // 声明为配置类（容器入口）
@ComponentScan("com.jeang")                     // 替代 <context:component-scan base-package="..."/>
@PropertySource(value = "classpath:app.properties", encoding = "UTF-8") // 替代 <context:property-placeholder/>
public class SpringConfig {

    /**
     * @Bean：用于注册「第三方类」或需要手动构建的对象（自己写的类用 @Component 系列即可）
     * 方法名即 Bean 的 id
     */
    @Bean
    public DateTimeFormatter dateTimeFormatter() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }
}
