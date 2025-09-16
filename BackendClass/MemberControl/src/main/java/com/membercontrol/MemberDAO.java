package com.membercontrol;

import io.github.cdimascio.dotenv.Dotenv;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {
    private DataSource dataFactory;

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public MemberDAO() {
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

    public ArrayList<MemberVO> listMembers() {
        ArrayList<MemberVO> memList = new ArrayList<>();

        try {
            // con = getConnection(); // 사용자 정의 메서드
            con = dataFactory.getConnection();

            String query = "SELECT * FROM member2";
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                MemberVO vo = new MemberVO();
                vo.setId(rs.getString("memID"));
                vo.setPwd(rs.getString("memPWD"));
                vo.setName(rs.getString("memName"));
                vo.setEmail(rs.getString("memEmail"));
                vo.setJoinDate(rs.getDate("memJoinDate"));

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

    public void addMember(MemberVO m) {
        try {
            con = dataFactory.getConnection();
            String id = m.getId();
            String pwd = m.getPwd();
            String name = m.getName();
            String email = m.getEmail();
            String query = "INSERT INTO member2 (memid, mempwd, memname, mememail)" + " VALUES(?, ? ,? ,?)";
            System.out.println(query);
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            pstmt.setString(3, name);
            pstmt.setString(4, email);
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public MemberVO findMember(String _id) {
        MemberVO memInfo = null;
        try {
            con = dataFactory.getConnection();
            String query = "select * from  member2 where memid=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, _id);
            System.out.println(query);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            String id = rs.getString("memid");
            String pwd = rs.getString("mempwd");
            String name = rs.getString("memname");
            String email = rs.getString("mememail");
            Date joinDate = rs.getDate("memjoinDate");
            memInfo = new MemberVO(id, pwd, name, email, joinDate);
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return memInfo;
    }

    public void delMember(String id) {
        try {
            con = dataFactory.getConnection();
            String query = "delete from member2 where memid=?";
            System.out.println(query);
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modMember(MemberVO memberVO) {
        String id = memberVO.getId();
        String pwd = memberVO.getPwd();
        String name = memberVO.getName();
        String email = memberVO.getEmail();
        try {
            con = dataFactory.getConnection();
            String query = "update member2 set mempwd=?,memname=?,mememail=?  where memid=?";
            System.out.println(query);
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, pwd);
            pstmt.setString(2, name);
            pstmt.setString(3, email);
            pstmt.setString(4, id);
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
