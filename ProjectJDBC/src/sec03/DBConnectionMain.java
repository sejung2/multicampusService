package sec03;

import java.sql.*;

public class DBConnectionMain {
    public static void main(String[] args) {
        // book테이블 data 조회
        DBConnect dbCon = new DBConnect();
        Connection con = dbCon.getConnection(); // DB 연결
        Statement stmt = null;
        ResultSet rs = null;

        // db와 통신하기 때문에 예외 처리 필요
        try {
            stmt = con.createStatement(); // sql 질의 진행 가능한 객체 반환
            String sql = "SELECT * FROM book2 order by bookNo";

            // statement 객체를 통해 질의어 전달해서 실행 후 결과 받아옴
            rs = stmt.executeQuery(sql);
            System.out.println("---------------------- 전체 도서 정보 조회 ----------------------");
            System.out.println("책번호\t 책이름\t\t 저자\t 가격\t 출판일\t\t 재고\t 출판사번호");
            while(rs.next()) {
                String bookNo = rs.getString(1);
                String bookName = rs.getString(2);
                String bookAuthor = rs.getString(3);
                int bookPrice = rs.getInt(4);
                Date bookDate = rs.getDate(5);
                int bookStock = rs.getInt(6);
                String pubNo = rs.getString(7);

                // 한 행씩 출력
                System.out.format("%-10s\t %-20s\t %-10s %6d %13s \t%3d %10s\n",
                        bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
            }
            // 사용 객체 닫기 - 사용 순서의 반대로
            rs.close();
            stmt.close();
            con.close();
            System.out.println("DB 연결 해제 완료!");
        } catch (SQLException e) {
            System.out.println("SQL 예외 발생: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
