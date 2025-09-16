package com.membercontrol;

import io.github.cdimascio.dotenv.Dotenv;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class ProductDAO {
    private DataSource dataFactory;

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public ProductDAO() {
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            this.dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    public ArrayList<ProductVO> listProducts() {
        ArrayList<ProductVO> productList = new ArrayList<>();

        try {
            // con = getConnection(); // 사용자 정의 메서드
            con = dataFactory.getConnection();

            String query = "SELECT * FROM product3";
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ProductVO vo = new ProductVO();
                vo.setPrdNo(rs.getString("prdNo"));
                vo.setPrdName(rs.getString("prdName"));
                vo.setPrdPrice(rs.getInt("prdPrice"));
                vo.setPrdMaker(rs.getString("prdMaker"));
                vo.setPrdColor(rs.getString("prdColor"));
                vo.setCtgNo(rs.getString("ctgNo"));

                productList.add(vo);
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
        return productList;
    }

    public void addProduct(ProductVO m) {
        try {
            con = dataFactory.getConnection();
            String prdNo = m.getPrdNo();
            String prdName = m.getPrdName();
            int prdPrice = m.getPrdPrice();
            String prdMaker = m.getPrdMaker();
            String prdColor = m.getPrdColor();
            String ctgNo = m.getCtgNo();
            String query = "INSERT INTO product3 (prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo)" + " VALUES(?, ? ,? ,? ,? ,?)";
            System.out.println(query);
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, prdNo);
            pstmt.setString(2, prdName);
            pstmt.setInt(3, prdPrice);
            pstmt.setString(4, prdMaker);
            pstmt.setString(5, prdColor);
            pstmt.setString(6, ctgNo);
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ProductVO findProduct(String _id) {
        ProductVO productInfo = null;
        try {
            con = dataFactory.getConnection();
            String query = "select * from  product3 where prdNo=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, _id);
            System.out.println(query);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            String prdNo = rs.getString("prdNo");
            String prdName = rs.getString("prdName");
            int prdPrice = rs.getInt("prdPrice");
            String prdMaker = rs.getString("prdMaker");
            String prdColor = rs.getString("prdColor");
            String ctgNo = rs.getString("ctgNo");
            productInfo = new ProductVO(prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo);
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productInfo;
    }

    public void delProduct(String no) {
        try {
            con = dataFactory.getConnection();
            String query = "delete from product3 where prdNo=?";
            System.out.println(query);
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, no);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modProduct(ProductVO ProductVO) {
        String prdNo = ProductVO.getPrdNo();
        String prdName = ProductVO.getPrdName();
        int prdPrice = ProductVO.getPrdPrice();
        String prdMaker = ProductVO.getPrdMaker();
        String prdColor = ProductVO.getPrdColor();
        String ctgNo = ProductVO.getCtgNo();
        try {
            con = dataFactory.getConnection();
            String query = "update product3 set prdName=?, prdPrice=?, prdMaker=?, prdColor=?, ctgNo=? where prdNo=?";
            System.out.println(query);
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, prdName);
            pstmt.setInt(2, prdPrice);
            pstmt.setString(3, prdMaker);
            pstmt.setString(4, prdColor);
            pstmt.setString(5, ctgNo);
            pstmt.setString(6, prdNo);
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
