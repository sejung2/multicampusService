package game_project.view;

import game_project.controller.Controller;

import java.util.Scanner;

public class MemberDeleteView {
    Controller controller = Controller.getInstance();
    Scanner sc = new Scanner(System.in);

    public void delete() {
        String memeNo;

        System.out.println("\n*************************");
        System.out.println("회원정보 삭제");
        System.out.println("***************************");

        // 전체 도서 출력
        MemberListView mls = new MemberListView();
        mls.getAllMember();

        System.out.print("삭제할 회원번호 입력 : ");
        memeNo = sc.nextLine();
        System.out.println("***************************");

        // 컨트롤러에게 입력받은 회원번호 전달
        controller.delete(memeNo);
    }
}
