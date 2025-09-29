package com.spring.mybatis2.service;


import com.spring.mybatis2.model.BookVO;

import java.util.ArrayList;
import java.util.HashMap;

public interface IBookService {
    ArrayList<BookVO> listAllBook();

    void insertBook(BookVO vo);

    void updateBook(BookVO vo);

    void deleteBook(String bookNo);

    BookVO detailViewBook(String bookNo);

    String bookNoCheck(String bookNo);

    ArrayList<BookVO> bookSearch(HashMap<String, Object> map); // 도서 검색
}
