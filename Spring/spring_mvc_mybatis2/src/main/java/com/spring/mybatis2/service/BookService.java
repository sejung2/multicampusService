package com.spring.mybatis2.service;

import com.spring.mybatis2.dao.IBookDAO;
import com.spring.mybatis2.model.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookService implements IBookService {

    @Autowired
    @Qualifier("IBookDAO")
    IBookDAO dao;

    @Override
    public ArrayList<BookVO> listAllBook() {
        return dao.listAllBook();
    }

    @Override
    public void insertBook(BookVO vo) {

    }

    @Override
    public void updateBook(BookVO vo) {

    }

    @Override
    public void deleteBook(String prdNo) {

    }

    @Override
    public BookVO detailViewBook(String prdNo) {
        return null;
    }
}
