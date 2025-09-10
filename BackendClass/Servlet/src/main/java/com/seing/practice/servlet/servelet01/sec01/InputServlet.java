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

@WebServlet("/input")
public class InputServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init() 실행");
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

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_id = request.getParameter("user_id");
        String user_pw = request.getParameter("user_pw");
        String emailRcv = request.getParameter("emailRcv");
        // 동일한 name 속성으로 값이 여러개가 전송되는 경우 배열로 받음
        String[] subject = request.getParameterValues("subject");

        System.out.println("id: " + user_id);
        System.out.println("pw: " + user_pw);
        System.out.println("emailRcv: " + emailRcv);

        System.out.println("Selected subjects: ");
        if (subject != null) {
            for (String sub : subject) {
                System.out.print(sub + " ");
            }
        } else {
            System.out.println("No subjects selected");
        }
        System.out.println();
    }

}