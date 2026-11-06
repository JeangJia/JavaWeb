package com.jeang.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @Scope("prototype")：多例，每次从容器获取都会创建新对象
 * 不写 @Scope 时默认为 singleton（单例）
 */
@Service
@Scope("prototype")
public class ReportService {

    public void export() {
        System.out.println("导出报表，当前对象: " + this);
    }
}
