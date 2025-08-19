package game_project.model;

import game_project.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO implements IMemberDAO { // IMemberDAO 인터페이스를 구현한 클래스

    @Override
    public boolean insert(MemberDTO member) throws Exception { // 회원가입 메소드
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBConnect.getConnection();
            pstmt = con.prepareStatement("insert into member values(?, ?, ?, ?)");
            pstmt.setString(1, member.getMemNo());
            pstmt.setString(4, member.getMemId());
            pstmt.setString(2, member.getMemPass());
            pstmt.setString(3, member.getMemName());

            int result = pstmt.executeUpdate();
            if (result == 0) {
                return false;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            DBConnect.close(con, pstmt);
        }
        return true;
    }

    @Override
    public MemberDTO select(MemberDTO member) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        MemberDTO memberDTO = null;

        String sql = "select * from member where memNo='" + member.getMemNo() + "'";
        return null;
    }

    @Override
    public List<MemberDTO> getAllMember() throws Exception {
        // 전체 회원 정보를 반환
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<MemberDTO> dataSet = null;

        try {
            con = DBConnect.getConnection();
            pstmt = con.prepareStatement("select * from member order by memNo");
            rs = pstmt.executeQuery();
            dataSet = new ArrayList<>();

            while (rs.next()) {
                dataSet.add(new MemberDTO(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                ));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            DBConnect.close(con, pstmt);
        }
        return dataSet; // 모든 회원 정보를 반환
    }

    @Override
    public boolean update(MemberDTO member) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBConnect.getConnection();
            String sql = "update member set memNo=?, memId=?, memPass=?, memName=?";
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, member.getMemNo());
            pstmt.setString(2, member.getMemId());
            pstmt.setString(3, member.getMemPass());
            pstmt.setString(4, member.getMemName());

            int result = pstmt.executeUpdate();

            if (result == 0) {
                return false;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            DBConnect.close(con, pstmt);
        }
        return true;
    }

    @Override
    public boolean delete(MemberDTO member) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBConnect.getConnection();
            String sql = "delete member where memNo";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, member.getMemNo());

            int result = pstmt.executeUpdate();

            if (result == 0) {
                return false;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            DBConnect.close(con, pstmt);
        }
        return true;
    }
}
