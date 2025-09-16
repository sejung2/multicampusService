package com.membercontrol;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/product/*")
public class ProductController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    ProductDAO productDAO;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        productDAO = new ProductDAO();
    }

    /**
     * @see Servlet#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nextPage = null; // forward할 페이지
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getPathInfo(); // 서블릿에 전달된 경로만 반환
        System.out.println("action : " + action);

        if (action == null || action.equals("/listProducts.do")) {
            System.out.println("상품 정보 페이지");
            ArrayList<ProductVO> productsList = productDAO.listProducts();
            request.setAttribute("productsList", productsList);
            nextPage = "/listProducts.jsp";
        } else if (action.equals("/productForm.do")) {
            nextPage = "/productForm.jsp";
        } else if (action.equals("/addProduct.do")) {
            String prdNo = request.getParameter("prdNo");
            String prdName = request.getParameter("prdName");
            int prdPrice = Integer.parseInt(request.getParameter("prdPrice"));
            String prdMaker = request.getParameter("prdMaker");
            String prdColor = request.getParameter("prdColor");
            String ctgNo = request.getParameter("ctgNo");
            ProductVO productVO = new ProductVO(prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo);
            productDAO.addProduct(productVO);
            request.setAttribute("msg", "addProduct");
            nextPage = "/product/listProducts.do";
        } else if (action.equals("/modProductForm.do")) {
            String no = request.getParameter("no");
            ProductVO productInfo = productDAO.findProduct(no);
            request.setAttribute("productInfo", productInfo);
            nextPage = "/modProductForm.jsp";
        } else if (action.equals("/modProduct.do")) {
            String prdNo = request.getParameter("prdNo");
            String prdName = request.getParameter("prdName");
            int prdPrice = Integer.parseInt(request.getParameter("prdPrice"));
            String prdMaker = request.getParameter("prdMaker");
            String prdColor = request.getParameter("prdColor");
            String ctgNo = request.getParameter("ctgNo");
            ProductVO productVO = new ProductVO(prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo);
            productDAO.modProduct(productVO);
            request.setAttribute("msg", "modProduct");
            nextPage = "/product/listProducts.do";
        } else if (action.equals("/delProduct.do")) {
            String no = request.getParameter("no");
            productDAO.delProduct(no);
            request.setAttribute("msg", "deleted");
            nextPage = "/product/listProducts.do";
        } else {
            List<ProductVO> productList = productDAO.listProducts();
            request.setAttribute("productList", productList);
            nextPage = "/listProducts.jsp";
        }
        RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
        dispatch.forward(request, response);
    }

}