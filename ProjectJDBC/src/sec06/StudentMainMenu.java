package sec06;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentMainMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO(); // 객체를 생성할 때 자동으로 DB 연결
        ArrayList<StudentDTO> stdList = null;
        // dao의 6가지 기능을 메뉴로 구성
        while (true) {
            System.out.println("학생 관리 프로그램을 시작합니다.");
            System.out.println("1. 학생 정보 입력");
            System.out.println("2. 전체 학생 정보 조회");
            System.out.println("3. 학생 정보 수정");
            System.out.println("4. 학과번호를 통한 검색");
            System.out.println("5. 학생 정보 삭제");
            System.out.println("6. 프로그램 종료");
            System.out.print("메뉴를 선택하세요: ");
            int choice = sc.nextInt();
            sc.nextLine(); // 개행 문자 제거
            System.out.println();

            switch (choice) {
                case 1 -> {
                    // 학생 정보 입력
                    dao.insertStudent(ReadWrite.getStdInfo(sc));
                }
                case 2 -> {
                    // 전체 학생 정보 조회
                    stdList = dao.getAllStudent();
                    ReadWrite.writeStdInfo(stdList);
                }
                case 3 -> {
                    // 학생 정보 수정
                    System.out.print("학번을 입력하세요: ");
                    String stdNo = sc.nextLine();
                    ReadWrite.writeStdInfo(dao.detailStudent(stdNo));
                    dao.updateStudent(ReadWrite.getStdInfo(sc));
                }
                case 4 -> {
                    // 학과명 통한 검색
                    System.out.print("학과명을 입력하세요: ");
                    String dptName = sc.nextLine();
                    ReadWrite.writeStdInfo(dao.searchStudent(dptName));
                }
                case 5 -> {
                    // 학생 정보 삭제
                    System.out.print("삭제할 학생의 학번을 입력하세요: ");
                    String stdNo = sc.nextLine();
                    dao.deleteStudent(stdNo);
                    System.out.println("학생 정보가 성공적으로 삭제되었습니다.");
                }
                case 6 -> {
                    // 프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    dao.close(); // DB 연결 해제
                    return; // 메인 메소드 종료
                }
            }
        }
    }
}
