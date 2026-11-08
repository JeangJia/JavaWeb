package com.jeang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.jeang")
@PropertySource({"classpath:jdbc.properties"})
public class SpringConfig {
}
