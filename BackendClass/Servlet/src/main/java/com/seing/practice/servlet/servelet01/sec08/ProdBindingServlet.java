package com.seing.practice.servlet.servelet01.sec08;


import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;

import com.seing.practice.servlet.servelet01.sec06.ProductVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/productBinding")
public class ProdBindingServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProdDAO dao = new ProdDAO();
        ArrayList<ProdVO> productList = dao.prodSelect();

        // 데이터 바인딩
        request.setAttribute("prodList", productList);

        // 데이터 포워딩
        RequestDispatcher dispatcher = request.getRequestDispatcher("prodView");
        dispatcher.forward(request, response);
    }

}