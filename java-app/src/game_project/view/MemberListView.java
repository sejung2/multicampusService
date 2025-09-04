package game_project.view;

import game_project.controller.Controller;
import game_project.model.MemberDTO;

import java.util.List;
import java.util.Scanner;

public class MemberListView {
    Controller controller = Controller.getInstance(); // 싱글톤 인스턴스 유지

    public void getAllMember() {
        controller.getAllMember();
    }

    public static void showAllMember(List<MemberDTO> dataSet) {
        System.out.println("\n*******************************");
        System.out.println("회원 정보 조회");
        System.out.println("*********************************");
        System.out.println("회원번호\t아이디\t\t비밀번호");
        System.out.println("------------------------------------");

        for (MemberDTO dto : dataSet) {
            System.out.println(dto); // toString() 활용
        }
        System.out.println("------------------------------------\n");
    }
}