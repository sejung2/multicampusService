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

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    MemberDAO memberDAO;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        memberDAO = new MemberDAO();
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

        if (action == null || action.equals("/listMembers.do")) {
            System.out.println("회원 정보 페이지");
            ArrayList<MemberVO> membersList = memberDAO.listMembers();
            request.setAttribute("membersList", membersList);
            nextPage = "/listMembers.jsp";
        } else if (action.equals("/memberForm.do")) {
            nextPage = "/memberForm.jsp";
        } else if (action.equals("/addMember.do")) {
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            MemberVO memberVO = new MemberVO(id, pwd, name, email);
            memberDAO.addMember(memberVO);
            request.setAttribute("msg", "addMember");
            nextPage = "/member/listMembers.do";
        } else if (action.equals("/modMemberForm.do")) {
            String id = request.getParameter("id");
            MemberVO memInfo = memberDAO.findMember(id);
            request.setAttribute("memInfo", memInfo);
            nextPage = "/modMemberForm.jsp";
        } else if (action.equals("/modMember.do")) {
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            MemberVO memberVO = new MemberVO(id, pwd, name, email);
            memberDAO.modMember(memberVO);
            request.setAttribute("msg", "modMember");
            nextPage = "/member/listMembers.do";
        } else if (action.equals("/delMember.do")) {
            String id = request.getParameter("id");
            memberDAO.delMember(id);
            request.setAttribute("msg", "deleted");
            nextPage = "/member/listMembers.do";
        } else {
            List<MemberVO> memberList = memberDAO.listMembers();
            request.setAttribute("memberList", memberList);
            nextPage = "/listMembers.jsp";
        }
        RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
        dispatch.forward(request, response);
    }

}