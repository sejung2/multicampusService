package com.seing.practice.servlet.servelet01.sec04;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.net.URLEncoder;

@WebServlet("/first04")
public class FirstServlet04 extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * redirect 방식으로 다른 서블릿에 데이터 전달
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("location script를 이용한 포워딩: FirstServlet 처리");
        response.setContentType("text/html;charset=utf-8");
        String name = URLEncoder.encode("홍길동", "utf-8"); // 조합문자를 url 파라미터 값으로 추가할 때는 url 사용가능한 범위의 문자로 인코딩 필요
        // 한글 인코딩: URLEncoder.encode("홍길동", "utf-8")
        int age = 30;
        // parameter 추가 : uri?parameter=value, 여러 값 전달 시 : uri?parameter1=value1&parameter2=value2
        response.sendRedirect("second04?name=" + name + "&age=" + age);
    }

}