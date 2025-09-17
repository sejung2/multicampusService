package com.seing.practice.webmvc.controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/guess")
public class GuessServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    public GuessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
    }

    public void destroy() {
        // TODO Auto-generated method stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int computerChoice = (int) (Math.random() * 10) + 1;
        int attempt = 0;
        request.setAttribute("answer", computerChoice);
        request.setAttribute("attempt", attempt);

        request.getRequestDispatcher("/Guess.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            int answer = Integer.parseInt(request.getParameter("answer"));
            int currentAttempt = Integer.parseInt(request.getParameter("attempt"));

            int newAttempt = currentAttempt + 1;

            int userChoice = Integer.parseInt(request.getParameter("choice"));

            if (userChoice < 1 || userChoice > 10) {
                throw new NumberFormatException();
            }

            if (userChoice == answer) {
                if (newAttempt == 1) {
                    request.setAttribute("user", userChoice);
                    request.setAttribute("result", "첫 시도에 맞추셨네요! 대단해요! 답: " + answer);
                } else {
                    request.setAttribute("user", userChoice);
                    request.setAttribute("result", newAttempt + "번째 시도에 맞추셨네요! 축하합니다! 답: " + answer);
                }
            } else {
                request.setAttribute("user", userChoice);
                request.setAttribute("answer", answer);
                request.setAttribute("attempt", newAttempt);
                request.setAttribute("result", "틀렸습니다! 다시 시도해보세요!");
            }

        } catch (NumberFormatException e) {
            request.setAttribute("error", "유효한 숫자를 입력해주세요.");
            request.setAttribute("answer", request.getParameter("answer"));
            request.setAttribute("attempt", request.getParameter("attempt"));
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Guess.jsp");
        dispatcher.forward(request, response);
    }
}