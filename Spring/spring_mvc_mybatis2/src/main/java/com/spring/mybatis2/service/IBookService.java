package com.spring.mybatis2.service;


import com.spring.mybatis2.model.BookVO;

import java.util.ArrayList;

public interface IBookService {
    ArrayList<BookVO> listAllBook();

    void insertBook(BookVO vo);

    void updateBook(BookVO vo);

    void deleteBook(String bookNo);

    BookVO detailViewBook(String bookNo);

    String bookNoCheck(String bookNo);
}
