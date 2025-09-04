package game_project.view;

import game_project.controller.Controller;

import java.util.Scanner;

public class MemberDeleteView {
    Controller controller = Controller.getInstance();

    public void deleteMember(Scanner sc) {
        System.out.println("\n*******************************");
        System.out.println("회원탈퇴");
        System.out.println("*********************************");

        System.out.print("탈퇴할 아이디 입력: ");
        String memId = sc.nextLine();

        System.out.print("정말 탈퇴하시겠습니까? (y/n): ");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("y")) {
            controller.deleteMember(memId);
        } else {
            System.out.println("탈퇴가 취소되었습니다.");
        }
    }
}