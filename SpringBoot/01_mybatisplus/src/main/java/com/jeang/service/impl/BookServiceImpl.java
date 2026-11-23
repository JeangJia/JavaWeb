package com.jeang.service.impl;

import com.jeang.dao.BookDao;
import com.jeang.domain.Book;
import com.jeang.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    @Override
    public String showAll() {
        List<Book> books = bookDao.selectList(null);
        String s = "";
        for (Book book : books) {
            s += book.toString() + "\n";
        }
        return s;
    }
}
