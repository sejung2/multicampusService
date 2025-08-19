package game_project.view;

import game_project.controller.Controller;
import game_project.model.MemberDTO;

import java.util.List;

public class MemberListView {
    // 조회된 전체 도서정보 결과 출력
    Controller controller = Controller.getInstance();

    public void getAllMember() { // controller에 요청만 전달
        controller.getAllMember();
    }

    public static void showAllMember(List<MemberDTO> dataSet) {
        System.out.println("\n*******************************");
        System.out.println("회원 정보 조회");
        System.out.println("*********************************");

        System.out.println("회원번호\t 아이디\t\t  비밀번호\t\t 이름");
        System.out.println("--------------------------------------------");

        for (MemberDTO dto : dataSet) {
            System.out.println(dto);
        }
    }
}
