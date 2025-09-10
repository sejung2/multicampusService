package com.seing.practice.servlet.servelet01.sec04;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

@WebServlet("/second06")
public class SecondServlet06 extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 바인딩으로 전달된 파라미터를 출력
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("SecondServlet06 에서 바인딩 된 데이터 출력: redirect가 binding 데이터 활용 가능? redirect 요청될 때는 새로운 요청 객체가 생성");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // 바인딩된 데이터 추출: getAttribute() Object 타입으로 반환
        String name = (String) request.getAttribute("name");
        String address = (String) request.getAttribute("address");

        out.println("<html><body>");
        out.println("이름: " + name + "<br>");
        out.println("주소: " + address + "<br>");
        out.println("</body></html>");
    }


}