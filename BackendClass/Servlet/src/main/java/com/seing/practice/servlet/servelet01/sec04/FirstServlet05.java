package com.seing.practice.servlet.servelet01.sec04;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;
import java.net.URLEncoder;

@WebServlet("/first05")
public class FirstServlet05 extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Dispatcher 활용한 포워딩 -> 현재 서블릿이 다른 서블릿을 요청: 관련 메소드는 Request 객체에 포함되어있음
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = "홍길동";
        String encodedName = URLEncoder.encode(name, "utf-8"); // 한글 인코딩
        int age = 30;
        RequestDispatcher dispatcher = request.getRequestDispatcher("/second05?name=" + encodedName + "&age=" + age);
        // 목적지는 dispatch 인스턴스 생성 시 결정
        dispatcher.forward(request, response); // dispatch 메서드 forward(현재 메서드의 request, response 객체를 전달)
    }

}