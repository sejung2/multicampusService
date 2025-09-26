package com.spring.mybatis2.dao;

import com.spring.mybatis2.model.BookVO;

import java.util.ArrayList;

public interface IBookDAO {
    ArrayList<BookVO> listAllBook();

    void insertBook(BookVO vo);

    void updateBook(BookVO bookVo);

    void deleteBook(String bookNo);

    BookVO detailViewBook(String bookNo);

    String bookNoCheck(String bookNo);
}

