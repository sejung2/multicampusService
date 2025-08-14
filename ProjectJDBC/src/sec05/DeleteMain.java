package sec05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteMain {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        DBConnect dbCon = new DBConnect();

        Scanner sc = new Scanner(System.in);

        String bookNo;
        System.out.println("도서 정보 삭제");
        System.out.print("삭제할 도서번호 입력 : ");
        bookNo = sc.nextLine();

        try {
            con = dbCon.getConnection();

            String sql = "delete book2 where bookNo=?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, bookNo);

            pstmt.executeUpdate();
            System.out.println("도서 정보가 성공적으로 삭제되었습니다.");

        } catch (SQLException e) {
            System.out.println("도서 정보 삭제 중 오류 발생: " + e.getMessage());
        } finally {
            // 자원 반환
            DBConnect.close(con, pstmt);
            sc.close();
        }
    }
}
