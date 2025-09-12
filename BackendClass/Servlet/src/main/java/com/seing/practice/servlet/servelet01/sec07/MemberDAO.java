package com.seing.practice.servlet.servelet01.sec07;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {
    private static Dotenv dotenv = Dotenv.load();

    private Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

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
            System.out.println("DB 연결실패!" + e);
        }
        return con;
    }

    public ArrayList<MemberVO> memeberSelect() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        ArrayList<MemberVO> memList = new ArrayList<>();

        try {
            con = getConnection();

            String query = "SELECT * FROM member2";
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                MemberVO vo = new MemberVO();
                vo.setMemID(rs.getString("memID"));
                vo.setMemPWD(rs.getString("memPWD"));
                vo.setMemName(rs.getString("memName"));
                vo.setMemEmail(rs.getString("memEmail"));
                vo.setMemJoinDate(rs.getDate("memJoinDate"));

                memList.add(vo);
            }
        } catch (Exception e) {
            System.out.println("DB 연결실패!" + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                con.close();
            } catch (Exception e) {
                System.out.println("DB 연결실패!" + e);
            }
        }
        return memList;
    }
}
