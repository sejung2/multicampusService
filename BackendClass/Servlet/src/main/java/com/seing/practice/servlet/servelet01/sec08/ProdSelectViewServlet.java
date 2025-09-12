package com.seing.practice.servlet.servelet01.sec08;


import com.seing.practice.servlet.servelet01.sec06.ProductVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.util.ArrayList;

@WebServlet("/prodView")
public class ProdSelectViewServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<ProdVO> prodList = (ArrayList<ProdVO>) request.getAttribute("prodList");
        // (1) 요청받음
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();


        // (3) 응답 처리: 클라이언트에게 결과 전송
        out.print("<html><head></head><body>");
        out.print("<table border=1><tr align='center' bgcolor='gold'>");
        out.print("<td>상품번호</td><td>상품명</td><td>가격</td>"
                + "<td>제조사</td><td>색상</td><td>카테고리번호</td><td>삭제</td></tr>");

        for (ProdVO vo : prodList) {
            out.print("<tr><td>" + vo.getPrdNo() + "</td>");
            out.print("<td>" + vo.getPrdName() + "</td>");
            out.print("<td>" + vo.getPrdPrice() + "</td>");
            out.print("<td>" + vo.getPrdMaker() + "</td>");
            out.print("<td>" + vo.getPrdColor() + "</td>");
            out.print("<td>" + vo.getCtgNo() + "</td>");
            out.print("<td><a href='/Servlet/memDelete?memId=" + vo.getPrdNo() + "'>삭제</a></td></tr>");
        }
        out.print("</table></body></html>");
        // out 객체 I/O 스트림 닫기
        out.close();
    }

}