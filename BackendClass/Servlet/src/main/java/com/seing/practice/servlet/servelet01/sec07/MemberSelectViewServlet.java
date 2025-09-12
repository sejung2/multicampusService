package com.seing.practice.servlet.servelet01.sec07;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.util.ArrayList;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/memSelect")
public class MemberSelectViewServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // (1) 요청받음
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // (2) 비즈니스 로직 처리: DB 연동 후 결과 받음
        MemberDAO dao = new MemberDAO();
        ArrayList<MemberVO> memList = dao.memeberSelect();

        // (3) 응답 처리: 클라이언트에게 결과 전송
        out.print("<html><head></head><body>");
        out.print("<table border=1><tr align='center' bgcolor='gold'>");
        out.print("<td>아이디</td><td>비밀번호</td><td>이름</td>"
                + "<td>이메일</td><td>가입일</td><td>삭제</td></tr>");

        for (MemberVO vo : memList) {
            out.print("<tr><td>" + vo.getMemID()+ "</td>");
            out.print("<td>" + vo.getMemPWD() + "</td>");
            out.print("<td>" + vo.getMemName() + "</td>");
            out.print("<td>" + vo.getMemEmail() + "</td>");
            out.print("<td>" + vo.getMemJoinDate() + "</td>");
            out.print("<td><a href='/Servlet/memDelete?memId=" +  vo.getMemID() + "'>삭제</a></td></tr>");
        }
        out.print("</table></body></html>");
        // out 객체 I/O 스트림 닫기
        out.close();
    }

}