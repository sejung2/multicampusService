package sec05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertInputBookMain {
    public static void main(String[] args) {
        DBConnect dbCon = new DBConnect();
        Connection con = dbCon.getConnection();
        PreparedStatement pstmt = null;

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("도서 번호 입력: ");
            String bookNo = sc.nextLine();
            System.out.print("도서명 입력: ");
            String bookName = sc.nextLine();
            System.out.print("저자명 입력: ");
            String bookAuthor = sc.nextLine();
            System.out.print("가격 입력: ");
            int bookPrice = Integer.parseInt(sc.nextLine());
            System.out.print("출판일 입력 (YYYY-MM-DD): ");
            String bookDate = sc.nextLine();
            System.out.print("재고 입력: ");
            int bookStock = Integer.parseInt(sc.nextLine());
            System.out.print("출판사 번호 입력: ");
            String pubNo = sc.nextLine();
            sc.close();

            String sql = "INSERT INTO book2 VALUES (?, ?, ?, ?, ?, ?, ?)";

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
//            pstmt.close();
//            con.close();
        } catch (Exception e) {
            System.out.println("입력 오류: " + e.getMessage());
            return;
        } finally {
            // 자원 반환
            DBConnect.close(con, pstmt);
            System.out.println("자원 반환 완료!");
        }
    }
}
