package com.jeang;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jeang.dao.UserDao;
import com.jeang.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void testGetAll() {
        List<User> users = userDao.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    void testUserPage() {
        Page<User> page = new Page<>(1, 2);
        userDao.selectPage(page, null);
        System.out.println("当前页码: " + page.getCurrent());
        System.out.println("每页显示数: " + page.getSize());
        System.out.println("一共多少页: " + page.getPages());
        System.out.println("一共多少数据: " + page.getTotal());
        System.out.println("数据: " + page.getRecords());
    }

    @Test
    void testQuery() {
//        通过QueryWrapper 进行条件查询
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.select("count(*) as count,username");
        qw.groupBy("username");
        List<Map<String, Object>> maps = userDao.selectMaps(qw);
        maps.forEach(System.out::println);
    }

    @Test
    void testLambdaQuery() {
//        通过LambdaQueryWrapper 进行条件查询
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
//        设置查询指定字段其余字段为null
        System.out.println(lqw.select(User::getId, User::getUsername));
//        lqw.lt(User::getId, 3)
//                .gt(User::getId, 1);
        lqw.lt(User::getId, 1)
                .or()
                .gt(User::getId, 2);
        userDao.selectList(lqw).forEach(System.out::println);

    }
}
