package com.seing.practice.servlet.servelet01.sec04;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

@WebServlet("/second05")
public class SecondServlet05 extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * FirstServlet05에서 dispatch 방식으로 포워딩 요청된 서블릿 - 최종 응답 진행
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String html = "<html><body>이름 : " + name + "<br>나이: " + age + "<br></body></html>";
        out.print(html);
    }


}