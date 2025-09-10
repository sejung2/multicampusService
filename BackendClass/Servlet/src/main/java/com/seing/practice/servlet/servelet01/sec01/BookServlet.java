package com.seing.practice.servlet.servelet01.sec01;


import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

@WebServlet("/bookInsert")
public class BookServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init method called");
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
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookNo = request.getParameter("bookNo");
        String bookName = request.getParameter("bookName");
        String bookAuthor = request.getParameter("bookAuthor");
        String bookPrice = request.getParameter("bookPrice");
        String bookStock = request.getParameter("bookStock");
        String bookYear = request.getParameter("bookYear");
        String bookMonth = request.getParameter("bookMonth");
        String bookDate = request.getParameter("bookDate");
        String pubNo = request.getParameter("pubNo");
        System.out.println("bookNo: " + bookNo);
        System.out.println("bookName: " + bookName);
        System.out.println("bookAuthor: " + bookAuthor);
        System.out.println("bookPrice: " + bookPrice);
        System.out.println("publish date: " + bookYear + "-" + bookMonth + "-" + bookDate);
        System.out.println("bookStock: " + bookStock);
        System.out.println("pubNo: " + pubNo);
    }
}