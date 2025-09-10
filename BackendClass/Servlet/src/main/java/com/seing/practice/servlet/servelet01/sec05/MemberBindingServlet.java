package com.seing.practice.servlet.servelet01.sec05;


import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/memBinding")
public class MemberBindingServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 요청을 doProcess로 넘김
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    /**
     * 요청을 doProcess로 넘김
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    /**
     * 요청을 doProcess로 넘김
     */
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // DB의 member 테이블에서 조회해서 ArrayList<MemberVO>로 저장했다고 가정
        MemberVO vo1 = new MemberVO("kim", "1234", "김유신", "kim@naver.com");
        MemberVO vo2 = new MemberVO("lee", "1234", "이몽룡", "lee@naver.com");
        MemberVO vo3 = new MemberVO("hong", "1234", "홍길동", "hong@gmail.com");

        ArrayList<MemberVO> memberList = new ArrayList<>();
        memberList.add(vo1);
        memberList.add(vo2);
        memberList.add(vo3);

        // 데이터 바인딩
        request.setAttribute("memberList", memberList); // 바인딩 되는 데이터 값은 Object 타입이므로 타입 상관없이 바인딩 가능

        // 포워딩
        RequestDispatcher dispatch = request.getRequestDispatcher("memberView");
        dispatch.forward(request, response);
    }

}