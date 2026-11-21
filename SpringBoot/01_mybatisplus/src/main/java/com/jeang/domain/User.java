package com.jeang.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user") // 指定数据库表名
public class User {
    @TableId(type = IdType.ASSIGN_ID) // 指定主键生成策略
    private Integer id;
    @TableField(value = "username") // 指定数据库字段名
    private String user;
    @TableField(select = false) // 不查询
    private String password;
    @TableField(exist = false) // 不存在数据库中
    private String email;

    public User() {
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.user = username;
        this.password = password;
    }
}
