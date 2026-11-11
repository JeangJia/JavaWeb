package com.jeang.controller;

import org.springframework.web.bind.annotation.*;

//@Controller
//@ResponseBody
@RestController // 可以替代@Controller和@ResponseBody
@RequestMapping("/users")
public class UserController {
    //    @RequestMapping(method = RequestMethod.POST)
    @PostMapping // 可以替代@RequestMapping(method = RequestMethod.POST)
    public String save() {
        System.out.println("save running...");
        return "success";
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    // @PathVariable 可以从URL中提取变量值
    // http://localhost:8080/02_rest/users/1
    public String delete(@PathVariable("id") int id) {
        System.out.println("delete running..." + id);
        return "success";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestParam("id") int id) {
        System.out.println("update running..." + id);
        return "success";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String find(@RequestParam("id") int id) {
        System.out.println("find running..." + id);
        return "success";
    }
}
