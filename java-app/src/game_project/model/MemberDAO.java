package game_project.model;

import game_project.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO implements IMemberDAO {

    @Override
    public boolean insert(String id, String pass) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBConnect.getConnection();
            // memNo는 AUTO_INCREMENT이므로 제외
            pstmt = con.prepareStatement("INSERT INTO member (memId, memPass) VALUES (?, ?)");
            pstmt.setString(1, id);
            pstmt.setString(2, pass);

            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            throw e;
        } finally {
            DBConnect.close(con, pstmt);
        }
    }

    @Override
    public MemberDTO select(MemberDTO member) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        MemberDTO memberDTO = null;

        try {
            con = DBConnect.getConnection();
            String sql = "SELECT * FROM member WHERE memNo=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, member.getMemNo());
            rs = pstmt.executeQuery();

            if (rs.next()) {
                memberDTO = new MemberDTO(
                        rs.getInt("memNo"),
                        rs.getString("memId"),
                        rs.getString("memPass")
                );
            }
        } catch (Exception e) {
            throw e;
        } finally {
            DBConnect.close(con, pstmt, rs);
        }
        return memberDTO;
    }

    @Override
    public MemberDTO selectById(String memId) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        MemberDTO memberDTO = null;

        try {
            con = DBConnect.getConnection();
            String sql = "SELECT * FROM member WHERE memId=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                memberDTO = new MemberDTO(
                        rs.getInt("memNo"),
                        rs.getString("memId"),
                        rs.getString("memPass")
                );
            }
        } catch (Exception e) {
            throw e;
        } finally {
            DBConnect.close(con, pstmt, rs);
        }
        return memberDTO;
    }

    @Override
    public boolean updateById(String memId, String newPassword) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBConnect.getConnection();
            String sql = "UPDATE member SET memPass=? WHERE memId=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, newPassword);
            pstmt.setString(2, memId);

            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            throw e;
        } finally {
            DBConnect.close(con, pstmt);
        }
    }

    @Override
    public boolean deleteById(String memId) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBConnect.getConnection();
            String sql = "DELETE FROM member WHERE memId=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memId);

            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            throw e;
        } finally {
            DBConnect.close(con, pstmt);
        }
    }

    @Override
    public List<MemberDTO> getAllMember() throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<MemberDTO> dataSet = null;

        try {
            con = DBConnect.getConnection();
            pstmt = con.prepareStatement("SELECT * FROM member ORDER BY memNo");
            rs = pstmt.executeQuery();
            dataSet = new ArrayList<>();

            while (rs.next()) {
                dataSet.add(new MemberDTO(
                        rs.getInt("memNo"),      // int로 수정
                        rs.getString("memId"),
                        rs.getString("memPass")
                ));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            DBConnect.close(con, pstmt, rs);
        }
        return dataSet;
    }

    @Override
    public boolean login(String id, String password) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean loginSuccess = false;

        try {
            con = DBConnect.getConnection();
            String sql = "SELECT * FROM member WHERE memId=? AND memPass=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                loginSuccess = true;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            DBConnect.close(con, pstmt, rs);
        }
        return loginSuccess;
    }
}