package ex04;

import sec03.DBConnect;

import java.sql.*;

public class ProductMain {
    public static void main(String[] args) {
        // product테이블 data 조회
        sec03.DBConnect dbCon = new DBConnect();
        Connection con = dbCon.getConnection(); // DB 연결
        Statement stmt = null;
        ResultSet rs = null;

        // db와 통신하기 때문에 예외 처리 필요
        try {
            stmt = con.createStatement(); // sql 질의 진행 가능한 객체 반환
            String sql = "SELECT * FROM product3";

            // statement 객체를 통해 질의어 전달해서 실행 후 결과 받아옴
            rs = stmt.executeQuery(sql);
            System.out.println("---------------------- 전체 상품 정보 조회 ----------------------");
            System.out.println("상품번호\t\t\t 상품명\t\t 가격\t\t 제조사\t\t 출판일\t\t 색상\t 분류");
            while(rs.next()) {
                String prdNo = rs.getString(1);
                String prdName = rs.getString(2);
                int prdPrice = rs.getInt(3);
                String prdMaker = rs.getString(4);
                String prdColo = rs.getString(5);
                String ctgNo = rs.getString(6);

                // 한 행씩 출력
                System.out.format("%-10s\t %-20s\t %-10d %6s %13s \t%3s\n",
                        prdNo, prdName, prdPrice, prdMaker, prdColo, ctgNo);
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
