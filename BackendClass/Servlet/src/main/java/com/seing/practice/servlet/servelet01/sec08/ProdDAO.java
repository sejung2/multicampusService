package com.seing.practice.servlet.servelet01.sec08;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdDAO {
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
                System.out.println("DB 연결실패!" + con);
            }
        } catch (Exception e) {
            System.out.println("DB 연결실패!" + e);
        }
        return con;
    }

    public ArrayList<ProdVO> prodSelect() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        ArrayList<ProdVO> prodList = new ArrayList<>();

        try {
            con = getConnection();

            String query = "SELECT * FROM PRODUCT3";
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ProdVO vo = new ProdVO();
                vo.setPrdNo(rs.getString("prdNo"));
                vo.setPrdName(rs.getString("prdName"));
                vo.setPrdPrice(rs.getInt("prdPrice"));
                vo.setPrdMaker(rs.getString("prdMaker"));
                vo.setPrdColor(rs.getString("prdColor"));
                vo.setCtgNo(rs.getString("ctgNo"));

                prodList.add(vo);
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
        return prodList;
    }
}
