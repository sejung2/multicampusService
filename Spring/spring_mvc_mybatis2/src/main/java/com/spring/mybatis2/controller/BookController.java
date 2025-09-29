package com.spring.mybatis2.controller;

import com.spring.mybatis2.model.BookVO;
import com.spring.mybatis2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class BookController {
    // DI 주입
    @Autowired
    BookService service;

    @RequestMapping("/")
    public String viewIndex() {
        return "index";
    }

    //전체 도서 조회
    @RequestMapping("/book/listAllBook")
    public String listAllBook(Model model) {
        //1. service 메소드 호출
        ArrayList<BookVO> bookList = service.listAllBook();
        //2. model에 bookList 저장
        model.addAttribute("bookList", bookList);
        //3. 뷰 페이지 결정 후 반환
        return "book/bookListView";
    }

    //도서 등록 폼 요청
    @RequestMapping("/book/newBookForm")
    public String newBookForm() {
        return "book/newBookForm";
    }

    // 도서 등록 요청 -> 로직 처리
    @RequestMapping("/book/insertBook")
    public String insertBook(BookVO vo) {
        // 1. insert 기능을 처리할 service 메소드 호출 (파라미터로 전달된 입력값을 command 객체에 저장해서 전송)
        service.insertBook(vo);
        // 2. 상품 등록 후에 확인 위해서 전체상품목록을 뷰로 결정 - 전체 상품조회 재요청
        return "redirect:/book/listAllBook";
    }

    // 도서 상세 조회
    @RequestMapping("/book/detailViewBook/{bookNo}")
    public String detailViewBook(@PathVariable String bookNo, Model model) {
        // 1. 도서 정보 전송해서 관련 정보 반환
        BookVO book = service.detailViewBook(bookNo);
        // 2. 반환 정보 model에 저장
        model.addAttribute("book", book);
        // 3. 뷰 페이지 결정 후 반환
        return "/book/bookDetailView";
    }

    // 도서 수정 폼 요청
    @RequestMapping("/book/updateBookForm/{bookNo}")
    public String updateBookForm(@PathVariable String bookNo, Model model) {
        // 1. 도서 정보 전송해서 관련 정보 반환
        BookVO book = service.detailViewBook(bookNo);
        // 2. 반환 정보 model에 저장
        model.addAttribute("book", book);
        // 3. 뷰 페이지 결정 후 반환
        return "/book/updateBookForm";
    }

    // 도서 수정 요청
    @RequestMapping("/book/updateBook")
    public String updateBook(BookVO vo) {
        service.updateBook(vo);
        return "redirect:/book/listAllBook";
    }

    // 도서 삭제 요청
    @RequestMapping("/book/deleteBook/{bookNo}")
    public String deleteBook(@PathVariable String bookNo) {
        service.deleteBook(bookNo);
        return "redirect:/book/listAllBook";
    }

    // ------------------- Ajax ------------------ //

    // 도서 중복 체크

    @ResponseBody
    @RequestMapping("/book/bookNoCheck/{bookNo}")
    public String bookNoCheck(@PathVariable String bookNo) {
        String bookNo_result = service.bookNoCheck(bookNo);

        String result = "available";
        if (bookNo_result != null) {
            result = "no_available";
        }

        return result;
    }

    //도서검색 폼 요청 처리
    @RequestMapping("/book/bookSearchForm")
    public String bookSearchForm() {
        return "/book/bookSearchForm";
    }
}
