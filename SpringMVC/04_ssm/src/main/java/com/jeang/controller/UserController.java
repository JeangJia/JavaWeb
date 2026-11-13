package com.jeang.controller;

import com.jeang.domain.User;
import com.jeang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public boolean save(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return userService.delete(id);
    }

    @PutMapping
    public boolean update(@RequestBody User user) {
        return userService.update(user);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }
}
