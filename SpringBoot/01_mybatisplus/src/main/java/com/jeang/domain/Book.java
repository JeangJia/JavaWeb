package com.jeang.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("book")
public class Book {
    private Integer id;
    @TableField(value = "book_name")
    private String name;
    private String category;
    private String author;
    private Double price;
    private String description;
}
