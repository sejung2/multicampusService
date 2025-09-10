package com.seing.practice.servlet.servelet01.sec04;


import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

@WebServlet("/second03")
public class SecondServlet03 extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("secondServlet03 doGet() 처리");
        // 응답처리
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String html = "<html><body>Location script 이용한 포워딩 출력입니다.</body></html>";
        out.print(html);
    }


}