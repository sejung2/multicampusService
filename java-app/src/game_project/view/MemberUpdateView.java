package game_project.view;

import game_project.controller.Controller;

import java.util.Scanner;

public class MemberUpdateView {
    Controller controller = Controller.getInstance();
    Scanner sc = new Scanner(System.in);

    public void updatePassword(Scanner sc) {
        System.out.println("\n*******************************");
        System.out.println("비밀번호 변경");
        System.out.println("*********************************");

        System.out.print("아이디 입력: ");
        String memId = sc.nextLine();

        System.out.print("새 비밀번호 입력: ");
        String newPassword = sc.nextLine();

        controller.updatePassword(memId, newPassword);
    }
}