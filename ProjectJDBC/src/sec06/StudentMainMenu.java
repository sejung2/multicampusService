package sec06;

import java.util.Scanner;

public class StudentMainMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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

            switch (choice) {
                case 1-> {
                    // 학생 정보 입력
                    StudentDAO dao = new StudentDAO();
                    dao.insertStudent(ReadWrite.getStdInfo(sc));
                }
                case 2-> {
                    // 전체 학생 정보 조회
                    StudentDAO dao = new StudentDAO();
                    ReadWrite.writeStdInfo(dao.getAllStudent());
                }
                case 3-> {
                    // 학생 정보 수정
                    StudentDAO dao = new StudentDAO();
                    System.out.print("학번을 입력하세요: ");
                    String stdNo = sc.nextLine();
                    ReadWrite.writeStdInfo(dao.detailStudent(stdNo));
                    dao.updateStudent(ReadWrite.getStdInfo(sc));
                }
                case 4-> {
                    // 학과번호를 통한 검색
                    StudentDAO dao = new StudentDAO();
                    System.out.print("학과 번호를 입력하세요: ");
                    String dptNo = sc.nextLine();
                    ReadWrite.writeStdInfo(dao.searchStudent(dptNo));
                }
                case 5-> {
                    // 학생 정보 삭제
                    StudentDAO dao = new StudentDAO();
                    System.out.print("삭제할 학생의 학번을 입력하세요: ");
                    String stdNo = sc.nextLine();
                    dao.deleteStudent(stdNo);
                    System.out.println("학생 정보가 성공적으로 삭제되었습니다.");
                }
                case 6-> {
                    // 프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                    return; // 메인 메소드 종료
                }
            }

        }
        sc.close();
        DBConnect.close();
    }
}
