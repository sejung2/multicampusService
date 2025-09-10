package com.seing.practice.servlet.servelet01.sec03;


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

@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Login2 시작");
    }

    /**
     * @see Servlet#destroy()
     */
    public void destroy() {
        System.out.println("Login2 종료");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // (1) 요청 처리
        // 전송되는 데이터 인코딩
        request.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("user_id");
        String userPw = request.getParameter("user_pw");

        // (2) 응답처리
        // MIME-TYPE 설정
        response.setContentType("text/html; charset=UTF-8");
        // java i/o 스트림 사용가능한 PrintWriter 객체 생성 - HttpServletResponse 객체의 getWriter() 메서드 사용
        PrintWriter out = response.getWriter();

        // html 문서 작성
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>userId: " + userId + "</p>");
        out.println("<p>userPw: " + userPw + "</p>");
        out.println("</body>");
        out.println("</html>");

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}