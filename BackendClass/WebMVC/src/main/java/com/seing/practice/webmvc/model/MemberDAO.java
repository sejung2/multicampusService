package com.seing.practice.webmvc.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {
    private DataSource dataFactory;
    public MemberDAO() {
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            this.dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<MemberVO> memeberSelect() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        ArrayList<MemberVO> memList = new ArrayList<>();

        try {
            // con = getConnection(); // 사용자 정의 메서드
            con = dataFactory.getConnection();

            String query = "SELECT * FROM member2";
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                MemberVO vo = new MemberVO();
                vo.setMemId(rs.getString("memID"));
                vo.setMemPwd(rs.getString("memPWD"));
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
