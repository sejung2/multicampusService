package sec05;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectMain {
    public static void main(String[] args) {
        // 조건절이 있는 select 쿼리 실행
        // db 연결
        DBConnect dbCon = new DBConnect();
        Connection con = dbCon.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);


        try {
            System.out.print("조회할 도서번호 입력: ");
            String bookno = sc.nextLine();
            String sql = "select * from book2 where bookNo='" + bookno + "'";

            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            while(rs.next()) {
                String bookNo = rs.getString(1);
                String bookName = rs.getString(2);
                int bookStock = rs.getInt(6);

                System.out.format("%-10s \t %-20s\t %3d \n", bookNo, bookName, bookStock);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
