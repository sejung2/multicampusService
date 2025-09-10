package com.seing.practice.servlet.servelet01.sec04;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/second01")
public class SecondServlet01 extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet01() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        System.out.println("secondServlet01 시작");
    }

    /**
     * @see Servlet#destroy()
     */
    public void destroy() {
        System.out.println("secondServlet01 종료");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("secondServlet01 doGet() 처리");
        // 응답처리
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String html = "<html><body>SendRedirect를 이용한 redirect 포워딩된 출력입니다.</body></html>";
        out.print(html);
    }


}