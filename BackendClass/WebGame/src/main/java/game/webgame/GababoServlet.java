package game.webgame;


import java.io.IOException;
import java.io.Serial;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/gababo")
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
        request.getRequestDispatcher("/Gababo.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int choice = Integer.parseInt(request.getParameter("choice"));
        request.setAttribute("choice", choice);

        int computerChoice = (int) (Math.random() * 3) + 1; // 1부터 3까지의 랜덤 값 생성
        request.setAttribute("computer", computerChoice);

        int result = result(choice, computerChoice);


        switch (result) {
            case 0 -> request.setAttribute("result", "비겼습니다.");
            case 1 -> request.setAttribute("result", "이겼습니다.");
            case -1 -> request.setAttribute("result", "졌습니다.");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("Gababo.jsp");
        dispatcher.forward(request, response);
    }

    private int result(int userChoice, int computerChoice) {
        if (userChoice == computerChoice) {
            // 사용자와 컴퓨터의 선택이 같을 때
            return 0;
        } else if ((userChoice == 1 && computerChoice == 3) ||
                (userChoice == 2 && computerChoice == 1) ||
                (userChoice == 3 && computerChoice == 2)) {
            // 사용자 승리 조건
            return 1;
        } else {
            // 컴퓨터 승리 조건
            return -1;
        }
    }

}