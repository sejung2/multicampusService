package secure.sec01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BookInjectMain {
    public static void main(String[] args) {
        DBConnect dbCon = new DBConnect();
        Connection con = dbCon.getConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("학생 번호를 입력:");
            String bookNo = sc.nextLine();
            System.out.println(bookNo);

            String sql = "SELECT * FROM Book2 WHERE bookNo='" + bookNo + "'";
            System.out.println(sql);
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            // 제목 출력
            System.out.println("------------ 학생 정보 조회 -------------");
            System.out.println("학생번호 \t 학생이름 \t\t\t 학년");

            // 필요 내용만 추출
            while (rs.next()) {
                String bkNo = rs.getString("bkNo");
                String stdName = rs.getString("stdName");
                int stdYear = rs.getInt("stdYear");

                // 한 행씩 출력
                System.out.format("%-10s\t, %-20s\t %6d \n", bkNo, stdName, stdYear);


            }
            // 리소스 반환
            rs.close();
            pstmt.close();
            con.close();
            sc.close();
        } catch (SQLException e) {
            e.printStackTrace(); // 개발단계에서 개발자가 오류를 추적할 수 있도록 도움
        }
    }
}
