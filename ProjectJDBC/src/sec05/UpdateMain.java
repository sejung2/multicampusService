package sec05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain {
    public static void main(String[] args) {
        // update 기능은 질의문에 모든 컬럼에 대한 update가 진행되도록 구성
        DBConnect dbCon = new DBConnect();
        Connection con = dbCon.getConnection();

        PreparedStatement pstmt = null;

        Scanner sc = new Scanner(System.in);

        // input update data
        // 기본키 값은 수정 불가능
        System.out.println("도서 정보 수정");
        System.out.print("수정할 도서번호 입력 : ");
        String bookNo = sc.nextLine();

        System.out.print("도서명 입력 : ");
        String bookName = sc.nextLine();

        System.out.print("도서저자 입력 : ");
        String bookAuthor = sc.nextLine();

        System.out.print("도서가격 입력 : ");
        int bookPrice = sc.nextInt();
        sc.nextLine();

        System.out.print("발행일 입력 : ");
        String bookDate = sc.nextLine();

        System.out.print("도서재고 입력 : ");
        int bookStock = sc.nextInt();

        sc.nextLine();

        System.out.print("출판사번호 입력 : ");
        String pubNo = sc.nextLine();

        try {
            String sql = "UPDATE book2 SET bookName=?, bookAuthor=?, bookPrice=?, bookDate=?, bookStock=?, pubNo=? WHERE bookNo=?";
            pstmt = con.prepareStatement(sql);

            // set parameters
            pstmt.setString(1, bookName);
            pstmt.setString(2, bookAuthor);
            pstmt.setInt(3, bookPrice);
            pstmt.setString(4, bookDate);
            pstmt.setInt(5, bookStock);
            pstmt.setString(6, pubNo);
            pstmt.setString(7, bookNo);

            pstmt.executeUpdate();
            System.out.println("도서 정보가 성공적으로 수정되었습니다.");

        } catch (SQLException e) {
            System.out.println("도서 정보 수정 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DBConnect.close(con, pstmt);
        }
    }
}
