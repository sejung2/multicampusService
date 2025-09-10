package com.seing.practice.servlet.servelet01.sec04;


import java.io.IOException;
import java.io.Serial;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/first01")
public class FirstServlet01 extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet01() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        System.out.println("firstServlet 시작");
    }

    /**
     * @see Servlet#destroy()
     */
    public void destroy() {
        System.out.println("firstServlet 종료");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("firstServlet doGet() 처리: redirect 처리");
        response.sendRedirect("second01"); // 웹 브라우저에서 second01 서블릿으로 포워딩(재요청)
    }

}