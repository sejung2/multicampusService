package com.spring.mybatis2.controller;

import com.spring.mybatis2.model.BookVO;
import com.spring.mybatis2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class BookRestController {

    @Autowired
    BookService bookService;

    @RequestMapping("book/bookSearch")
    public ArrayList<BookVO> bookSearch(@RequestParam HashMap<String, Object> param) {
        ArrayList<BookVO> bookList = bookService.bookSearch(param);
        return bookList;
    }
}
