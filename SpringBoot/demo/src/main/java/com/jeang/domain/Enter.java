package com.jeang.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "enter")
public class Enter {
    private String name;
    private Integer age;
    private List<String> likes;

    public Enter() {
    }

    public Enter(String name, Integer age, List<String> likes) {
        this.name = name;
        this.age = age;
        this.likes = likes;
    }
}
