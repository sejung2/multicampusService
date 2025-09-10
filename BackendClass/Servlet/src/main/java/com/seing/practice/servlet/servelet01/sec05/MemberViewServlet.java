package com.seing.practice.servlet.servelet01.sec05;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.lang.reflect.Member;
import java.util.ArrayList;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("unchecked")
@WebServlet("/memberView")
public class MemberViewServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<MemberVO> memberList = (ArrayList<MemberVO>) request.getAttribute("memberList");

        // 응답처리
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("<html><head></head><body>");
        out.print("<table border=1><tr align='center' bgcolor='gold'>");
        out.print("<td>아이디</td><td>비밀번호</td><td>이름</td>"
                + "<td>이메일</td><td>삭제</td></tr>");

        for (int i = 0; i < memberList.size(); i++) {
            MemberVO vo = (MemberVO) memberList.get(i);
            out.print("<tr><td>" + vo.getId() + "</td>");
            out.print("<td>" + vo.getPwd() + "</td>");
            out.print("<td>" + vo.getName() + "</td>");
            out.print("<td>" + vo.getEmail() + "</td>");
            out.print("<td><a href='/Servlet/memDelete?id=" + vo.getId() + "'>삭제</a></td></tr>");
        }
        out.print("</table></body></html>");
    }

}