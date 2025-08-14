package sec06;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

// 입출력 기능
public class ReadWrite {
    // 학생 정보 입력
    // StudentDTO 타입
    public static StudentDTO getStdInfo(Scanner sc) {
        StudentDTO dto = null;
        try {
            // 학생 데이터 입력
            System.out.println("학생 정보 등록");
            System.out.print("학번 입력 : ");
            String stdNo = sc.nextLine();

            System.out.print("성명 입력 : ");
            String stdName = sc.nextLine();

            System.out.print("학년 입력 : ");
            int stdYear = sc.nextInt();

            sc.nextLine();

            System.out.print("주소 입력 : ");
            String stdAddress = sc.nextLine();

            System.out.print("생년월일 입력 : ");
            String stdBirthday = sc.nextLine();

            System.out.print("학과 번호 입력 : ");
            String dptNo = sc.nextLine();

            SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
            Date date = fm.parse(stdBirthday);

            // StudentDTO 객체 생성
            dto = new StudentDTO(stdNo, stdName, stdYear, stdAddress, date, dptNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }


    public static void writeStdInfo(ArrayList<StudentDTO> stdList) {
        System.out.println("----- 전체 학생 정보 조회 ------");
        System.out.format("%-10s\t %-10s\t %-4s %-20s \t%13s %5s\n",
                "학번", "성명", "학년", "주소", "출생일", "학과번호");

        for (StudentDTO dto : stdList) {
            String stdNo = dto.getStdNo();
            String stdName = dto.getStdName();
            int stdYear = dto.getStdYear();
            String stdAddress = dto.getStdAddress();
            Date stdBirthday = dto.getStdBirth();
            String dptNo = dto.getDptNo();

            // 한 행씩 출력
            System.out.format("%-10s\t %-10s\t %-4d %-20s \t%13s %5s\n",
                    stdNo, stdName, stdYear, stdAddress, stdBirthday, dptNo);
        }
    }

    // 학생 1명 정보 출력
    public static void writeStdInfo(StudentDTO dto) {
        System.out.println("----- 학생 정보 조회 ------");
        System.out.format("%-10s\t %-10s\t %-4s %-20s \t%13s %5s\n",
                "학번", "성명", "학년", "주소", "출생일", "학과번호");

        String stdNo = dto.getStdNo();
        String stdName = dto.getStdName();
        int stdYear = dto.getStdYear();
        String stdAddress = dto.getStdAddress();
        Date stdBirthday = dto.getStdBirth();
        String dptNo = dto.getDptNo();

        // 한 행씩 출력
        System.out.format("%-10s\t %-10s\t %-4d %-20s \t%13s %5s\n",
                stdNo, stdName, stdYear, stdAddress, stdBirthday, dptNo);
    }
}

