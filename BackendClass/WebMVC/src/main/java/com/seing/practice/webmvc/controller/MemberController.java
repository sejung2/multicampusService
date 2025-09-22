package com.seing.practice.webmvc.controller;

import com.seing.practice.webmvc.model.MemberDAO;
import com.seing.practice.webmvc.model.MemberVO;
import jakarta.servlet.RequestDispatcher;
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

    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {
        memberDAO = new MemberDAO();
    }

    public void destroy() {
        // TODO Auto-generated method stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nextPage = null; // forward할 페이지
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getPathInfo(); // 서블릿에 전달된 경로만 반환
        System.out.println("action : " + action);

        if (action == null || action.equals("/")) {
            nextPage = "/main/mainView.jsp";
        }

        if (action.equals("/memberForm.do")) {
            nextPage = "/memberForm.jsp";
        } else if (action.equals("/addMember.do")) {
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            MemberVO memberVO = new MemberVO(id, pwd, name, email);
            memberDAO.addMember(memberVO);
            request.setAttribute("msg", "addMember");
            nextPage = "/main/mainView.jsp";
        } else if (action.equals("/loginMember.do")) {
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");
            ArrayList<MemberVO> members = memberDAO.listMembers();
            boolean found = false;
            String name = null;
            for (MemberVO member : members) {
                if (member.getId().equals(id) && member.getPwd().equals(pwd)) {
                    found = true;
                    name = member.getName();
                    break;
                }
            }
            if (found) {
                request.setAttribute("msg", "loginSuccess");
                request.setAttribute("user", name);
                nextPage = "/main/mainView.jsp";
            } else {
                request.setAttribute("msg", "loginFail");
                nextPage = "/loginMember.jsp";
            }
        } else if (action.equals("/logoutMember.do")) {
            request.setAttribute("msg", "logoutSuccess");
            request.setAttribute("user", null);
            nextPage = "/main/mainView.jsp";
        }
        RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
        dispatch.forward(request, response);
    }

}