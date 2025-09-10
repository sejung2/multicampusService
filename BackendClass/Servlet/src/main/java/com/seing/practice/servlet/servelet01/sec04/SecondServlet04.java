package com.seing.practice.servlet.servelet01.sec04;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

@WebServlet("/second04")
public class SecondServlet04 extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 파라미터로 전달된 값 추출해서 클라이언트에 응답 데이터로 사용
     * 요청은 firstServlet에 의해 redirect(재요청) 됨
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("secondServlet04 처리");
        // 응답처리
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String html = "<html><body>이름 : " + name + "<br>나이: " + age + "<br></body></html>";
        out.print(html);
    }


}