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

@WebServlet("/first06")
public class FirstServlet06 extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 바인딩 방식으로 데이터를 생성하고 redirect 방식으로 데이터 전달
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 데이터 바인딩
        request.setAttribute("name", "홍길동");
        request.setAttribute("address", "서울시 강남구");

        //response.sendRedirect("second06"); // request 객체 삭제 -> 포워딩 시 바인딩 데이터 전달 불가
        // dispatch 방식으로 포워딩
        RequestDispatcher dispatch = request.getRequestDispatcher("second06");
        dispatch.forward(request, response);
    }

}