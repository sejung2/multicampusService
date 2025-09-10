package com.seing.practice.servlet.servelet01.sec04;


import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/first02")
public class FirstServlet02 extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet02() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        System.out.println("firstServlet02 시작");
    }

    /**
     * @see Servlet#destroy()
     */
    public void destroy() {
        System.out.println("firstServlet02 종료");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("firstServlet02 Refresh 처리");
        response.addHeader("Refresh", "2;url=second02"); // 웹 브라우저에서 second01 서블릿으로 포워딩(재요청)
    }

}