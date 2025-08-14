package sec06;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        // DAO 기능 확인
        StudentDAO dao = new StudentDAO(); // 객체를 생성할 때 자동으로 DB 연결
        Scanner sc = new Scanner(System.in);// Scanner 객체 생성
        ArrayList<StudentDTO> stdList = null;
        String stdNo = null;
        String dptNo = null;

        try {
            // 1. 학생 정보 입력
            dao.insertStudent(ReadWrite.getStdInfo(sc));

            // 2. 전체 학생 정보 조회
            stdList = dao.getAllStudent();
            ReadWrite.writeStdInfo(stdList);

            // 3. 학생 정보 수정
            System.out.print("학번을 입력하세요: ");
            stdNo = sc.nextLine();
            ReadWrite.writeStdInfo(dao.detailStudent(stdNo));
            dao.updateStudent(ReadWrite.getStdInfo(sc));

            // 4. 학과번호를 통한 검색
            System.out.print("학과 번호를 입력하세요: ");
            dptNo = sc.nextLine();
            ReadWrite.writeStdInfo(dao.searchStudent(dptNo));

            // 5. 학생 정보 삭제
            System.out.print("삭제할 학생의 학번을 입력하세요: ");
            stdNo = sc.nextLine();
            dao.deleteStudent(stdNo);
        } catch (Exception e) {
            System.out.println("오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
        sc.close();
    }
}
