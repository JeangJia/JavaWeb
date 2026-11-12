package com.jeang.controller;

import com.jeang.domain.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @PostMapping
    public String save(@RequestBody Book book) {
        System.out.println("save ==>" + book);
        return "save success";
    }

    @GetMapping
    public List<Book> getAll() {
        Book book1 = new Book(1, "计算机", "数据结构", "数据结构描述");
        Book book2 = new Book(2, "汉语 ", "古代文学", "古代文学描述");
        List<Book> listBook = new ArrayList<>();
        listBook.add(book1);
        listBook.add(book2);
        System.out.println("getAll running...");
        return listBook;
    }
}
