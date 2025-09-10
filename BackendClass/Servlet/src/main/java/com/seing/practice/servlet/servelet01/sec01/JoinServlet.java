package com.seing.practice.servlet.servelet01.sec01;


import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

@WebServlet("/insertMember")
public class JoinServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init() called");
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
        System.out.println("get 방식으로 요청");
        doProcess(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post 방식으로 요청");
        doProcess(request, response);
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String phone = request.getParameter("phonF") + "-"
                + request.getParameter("phonS") + "-"
                + request.getParameter("phonT");
        String grade = request.getParameter("grade");
        String[] interests = request.getParameterValues("interests");
        String department = request.getParameter("department");

        // MIME-TYPE 설정
        response.setContentType("text/html; charset=UTF-8");
        // java i/o 스트림 사용가능한 PrintWriter 객체 생성 - HttpServletResponse 객체의 getWriter() 메서드 사용
        PrintWriter out = response.getWriter();

        // html 문서 작성
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>회원가입 내용</h1>");
        out.println("<p>성명: " + name + "</p>");
        out.println("<p>아이디: " + id + "</p>");
        out.println("<p>비밀번호: " + pw + "</p>");
        out.println("<p>휴대전화: " + phone + "</p>");
        out.println("<p>학년: " + grade + "</p>");
        out.print("<p>관심분야: ");
        if (interests != null) {
            for (String interest : interests) {
                out.print(interest + " ");
            }
        }
        out.println("</p>");
        out.println("<p>학과: " + department + "</p>");
        out.println("</body>");
        out.println("</html>");
    }

}