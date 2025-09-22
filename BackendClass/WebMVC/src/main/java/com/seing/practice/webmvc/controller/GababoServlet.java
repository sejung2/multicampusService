package com.seing.practice.webmvc.controller;

import com.seing.practice.webmvc.service.GaBaBo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;
import java.util.Map;

@WebServlet("/game/gababo")
public class GababoServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    public GababoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {

    }

    public void destroy() {
        // TODO Auto-generated method stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Gababo.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            int userChoice = Integer.parseInt(request.getParameter("choice"));

            GaBaBo game = new GaBaBo();

            Map<String, String> gameResult = game.startGame(userChoice);
            request.setAttribute("user", gameResult.get("user"));
            request.setAttribute("computer", gameResult.get("computer"));
            request.setAttribute("result", gameResult.get("result"));

            RequestDispatcher dispatcher = request.getRequestDispatcher("Gababo.jsp");
            dispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "잘못된 입력입니다. 가위, 바위, 보 중 하나를 선택해주세요.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Gababo.jsp");
            dispatcher.forward(request, response);
        }
    }
}