package util;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// database 연결 및 종료 관리
public class DBConnect {
    private static Dotenv dotenv = Dotenv.load();

    public static Connection getConnection() {
        Connection con = null;

        try {
            String url = dotenv.get("DB_URL");
            String username = dotenv.get("DB_USERNAME");
            String password = dotenv.get("DB_PASSWORD");

            con = DriverManager.getConnection(url, username, password);
            if (con != null) {
                System.out.println("DB 연결성공!");
            } else {
                System.out.println("DB 연결실패!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    // 자원 반환 메소드: close()
    // static 메소드로 선언하여 객체 생성 없이 호출 가능

    // 1. Connection, PreparedStatement, ResultSet 자원 3개 반환
    public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                rs = null; // rs를 null로 설정하여 가비지 컬렉션 대상이 되도록 함
            }
            if (pstmt != null) {
                pstmt.close();
                pstmt = null;
            }
            if (con != null) {
                con.close();
                con = null;
                System.out.println("DB 연결 해제 완료!");
            }
        } catch (Exception e) {
            System.out.println("자원 반환 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 2. Connection, PreparedStatement 자원 2개 반환
    public static void close(Connection con, PreparedStatement pstmt) {
        try {
            if (pstmt != null) {
                pstmt.close();
                pstmt = null;
            }
            if (con != null) {
                con.close();
                con = null;
                System.out.println("DB 연결 해제 완료!");
            }
        } catch (Exception e) {
            System.out.println("자원 반환 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 3. Connection 자원 1개 반환
    public static void close(Connection con) {
        try {
            if (con != null) {
                con.close();
                con = null;
                System.out.println("DB 연결 해제 완료!");
            }
        } catch (Exception e) {
            System.out.println("자원 반환 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
    // 4. PreparedStatement, ResultSet 자원 2개 반환
    public static void close(PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                rs = null; // rs를 null로 설정하여 가비지 컬렉션 대상이 되도록 함
            }
            if (pstmt != null) {
                pstmt.close();
                pstmt = null;
            }
        } catch (Exception e) {
            System.out.println("자원 반환 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
    // 5. PreparedStatement 자원 1개 반환
    public static void close(PreparedStatement pstmt) {
        try {
            if (pstmt != null) {
                pstmt.close();
                pstmt = null;
            }
        } catch (Exception e) {
            System.out.println("자원 반환 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
