package game_project.view;

import game_project.controller.Controller;

import java.util.Scanner;

public class MemberInsertView {
    Controller controller = Controller.getInstance();

    public void insert(Scanner sc) {
        System.out.println("\n*******************************");
        System.out.println("회원가입");
        System.out.println("*********************************");

        System.out.print("아이디 입력: ");
        String memId = sc.nextLine();

        System.out.print("비밀번호 입력: ");
        String memPass = sc.nextLine();

        controller.insert(memId, memPass);
    }
}