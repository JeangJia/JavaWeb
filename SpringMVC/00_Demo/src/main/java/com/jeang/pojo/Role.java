package com.jeang.pojo;

import lombok.Data;

@Data
public class Role {
    private String roleName;
    private String roleCode;
    private String description;
    private Integer status;
    private String dataScope;
    private Integer sort;
}