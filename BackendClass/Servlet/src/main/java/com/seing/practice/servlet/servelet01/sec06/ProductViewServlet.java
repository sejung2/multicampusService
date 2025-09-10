package com.seing.practice.servlet.servelet01.sec06;


import com.seing.practice.servlet.servelet01.sec05.MemberVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.util.ArrayList;

@WebServlet("/productView")
public class ProductViewServlet extends HttpServlet {
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
        ArrayList<ProductVO> productList = (ArrayList<ProductVO>) request.getAttribute("productList");

        // 응답처리
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("<html><head></head><body>");
        out.print("<table border=1><tr align='center' bgcolor='gold'>");
        out.print("<td>상품번호</td><td>상품명</td><td>가격</td><td>삭제</td></tr>");

        for (int i = 0; i < productList.size(); i++) {
            ProductVO vo = (ProductVO) productList.get(i);
            out.print("<tr><td>" + vo.getProdNo() + "</td>");
            out.print("<td>" + vo.getProdName() + "</td>");
            out.print("<td>" + vo.getProdPrice() + "</td>");
            out.print("<td><a href='/Servlet/prodDelete?id=" + vo.getProdNo() + "'>삭제</a></td></tr>");
        }
        out.print("</table></body></html>");
    }

}