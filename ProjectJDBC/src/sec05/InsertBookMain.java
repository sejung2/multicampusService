package sec05;

import java.sql.*;
import java.util.Scanner;

public class InsertBookMain {
    public static void main(String[] args) {
// 조건절이 있는 select 쿼리 실행
        // db 연결
        DBConnect dbCon = new DBConnect();
        Connection con = dbCon.getConnection();
        PreparedStatement pstmt = null;

        String bookNo = "1020";
        String bookName = "algorithm 2";
        String bookAuthor = "김철수";
        int bookPrice = 25000;
        String bookDate = "2023-10-01";
        int bookStock = 10;
        String pubNo = "1";

        try {
            // 열의 value자리에 '?' (placeholder) 사용 - 바인딩 변수
            String sql = "insert into book2 values(?,?,?,?,?,?,?)";

            // preparedStatement 객체 생성 시 바인딩될 쿼리구문 전달
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, bookNo);
            pstmt.setString(2, bookName);
            pstmt.setString(3, bookAuthor);
            pstmt.setInt(4, bookPrice);
            pstmt.setString(5, bookDate);
            pstmt.setInt(6, bookStock);
            pstmt.setString(7, pubNo);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("도서 정보가 성공적으로 입력되었습니다.");
            } else {
                System.out.println("도서 정보 입력에 실패했습니다.");
            }

            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
