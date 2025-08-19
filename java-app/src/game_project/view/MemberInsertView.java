package game_project.view;

import game_project.controller.Controller;
import game_project.model.MemberDTO;

import java.util.Scanner;

public class MemberInsertView {
    Controller controller = Controller.getInstance();
    Scanner sc = new Scanner(System.in);

    public void insert() {
        String memNo, memId, memPass, memName;

        System.out.println("\n*************************");
        System.out.println("회원정보 등록");
        System.out.println("***************************");

        System.out.print("회원번호 입력 : ");
        memNo = sc.nextLine();

        System.out.print("아이디 입력 : ");
        memId = sc.nextLine();

        System.out.print("비밀번호 입력 : ");
        memPass = sc.nextLine();

        System.out.print("이름 입력 : ");
        memName = sc.nextLine();

        System.out.println("***************************");
        controller.insert(new MemberDTO(memNo, memId, memPass, memName));
    }
}
