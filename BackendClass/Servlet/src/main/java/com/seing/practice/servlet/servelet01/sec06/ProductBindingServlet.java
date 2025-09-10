package com.seing.practice.servlet.servelet01.sec06;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;

@WebServlet("/prodBinding")
public class ProductBindingServlet extends HttpServlet {
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
        // DB에서 상품 조회해서 저장했다고 가정
        ProductVO product1 = new ProductVO("001", "noteBook", 800000);
        ProductVO product2 = new ProductVO("002", "desktop", 600000);
        ProductVO product3 = new ProductVO("003", "tablet", 400000);

        ArrayList<ProductVO> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        // 데이터 바인딩
        request.setAttribute("productList", productList);

        // 데이터 포워딩
        RequestDispatcher dispatcher = request.getRequestDispatcher("productView");
        dispatcher.forward(request, response);
    }

}