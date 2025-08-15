package sec06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

// CRUD 기능 구현 클래스 - interface
public class StudentDAO implements IStudentDAO {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    StudentDTO std = null;
    ArrayList<StudentDTO> stdList = null;

    public StudentDAO() {
        con = DBConnect.getConnection();
    }

    @Override
    public void insertStudent(StudentDTO dto) {
        // 학생 정보 입력
        try {
            String sql = "INSERT INTO student values(?, ?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql);
            // 저장될 학생 정보는 dto 객체에 담겨있음
            pstmt.setString(1, dto.getStdNo());
            pstmt.setString(2, dto.getStdName());
            pstmt.setInt(3, dto.getStdYear());
            pstmt.setString(4, dto.getStdAddress());
            pstmt.setDate(5, new java.sql.Date(dto.getStdBirth().getTime()));
            pstmt.setString(6, dto.getDptNo());

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("학생 정보가 성공적으로 입력되었습니다.");
            } else {
                System.out.println("학생 정보 입력에 실패했습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(pstmt);
        }
    }

    @Override
    public ArrayList<StudentDTO> getAllStudent() {
        // 전체 학생 정보 조회
        stdList = new ArrayList<StudentDTO>();
        try {
            String sql = "SELECT * FROM student ORDER BY stdNo";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String stdNo = rs.getString(1);
                String stdName = rs.getString(2);
                int stdYear = rs.getInt(3);
                String stdAddress = rs.getString(4);
                Date stdBirth = rs.getDate(5);
                String dptNo = rs.getString(6);

                // StudentDTO 객체 생성 후 리스트에 추가
                std = new StudentDTO(stdNo, stdName, stdYear, stdAddress, stdBirth, dptNo);
                stdList.add(std);
            }
        } catch (SQLException e) {
            System.out.println("SQL 예외 발생: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DBConnect.close(pstmt, rs);
        }
        return stdList;
    }

    @Override
    public StudentDTO detailStudent(String dptName) { // 학과명으로 학생 조회
        // 학생 상세 정보 조회
        try {
            String sql = "SELECT * FROM student WHERE dptNo=(SELECT dptNo FROM department WHERE dptName=?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, dptName);
            rs = pstmt.executeQuery();

            rs.next();
            String stdNo = rs.getString(1);
            String stdName = rs.getString(2);
            int stdYear = rs.getInt(3);
            String stdAddress = rs.getString(4);
            Date stdBirth = rs.getDate(5);
            String dptNo = rs.getString(6);

            std = new StudentDTO(stdNo, stdName, stdYear, stdAddress, stdBirth, dptNo);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(pstmt, rs);
        }
        return std;
    }
//    @Override
//    public StudentDTO detailStudent(String stdNo) {
//        // 학생 상세 정보 조회
//        try {
//            String sql = "SELECT * FROM student WHERE stdNo=?";
//            pstmt = con.prepareStatement(sql);
//            pstmt.setString(1, stdNo);
//            rs = pstmt.executeQuery();
//            // 기본키로 조회진행 -> 조회되지 않거나 한 건의 학생 정보만 조회됨
//            // 릴레이션으로 반환 -> 존재하는 학생의 학번이 전달되었다고 가정
//            rs.next();
//            stdNo = rs.getString(1);
//            String stdName = rs.getString(2);
//            int stdYear = rs.getInt(3);
//            String stdAddress = rs.getString(4);
//            Date stdBirth = rs.getDate(5);
//            String dptNo = rs.getString(6);
//
//            // StudentDTO 객체 생성 후 리스트에 추가
//            std = new StudentDTO(stdNo, stdName, stdYear, stdAddress, stdBirth, dptNo);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            DBConnect.close(pstmt, rs);
//        }
//        return null;
//    }

    @Override
    public void deleteStudent(String stdNo) {
        // 학생 정보 삭제
        try {
            // 삭제 쿼리
            String sql = "DELETE FROM student WHERE stdNo=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, stdNo);

            int result = pstmt.executeUpdate();

            System.out.println("학생 정보가 성공적으로 삭제되었습니다.");
        } catch (SQLException e) {
            System.out.println("SQL 예외 발생: " + e.getMessage());
        } finally {
            DBConnect.close(pstmt);
        }
    }

    @Override
    public void updateStudent(StudentDTO dto) {
        // 학생 정보 수정
        try {
            String sql = "UPDATE student SET stdName=?, stdYear=?, stdAddress=?, stdBirth=?, dptNo=? WHERE stdNo=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, dto.getStdName());
            pstmt.setInt(2, dto.getStdYear());
            pstmt.setString(3, dto.getStdAddress());
            pstmt.setDate(4, new java.sql.Date(dto.getStdBirth().getTime()));
            pstmt.setString(5, dto.getDptNo());
            pstmt.setString(6, dto.getStdNo());

            pstmt.executeUpdate();

            System.out.println("학생 정보가 성공적으로 수정되었습니다.");
        } catch (SQLException e) {
            System.out.println("SQL 예외 발생: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DBConnect.close(pstmt);
        }
    }

    @Override
    public ArrayList<StudentDTO> searchStudent(String dptNo) {
        // 과별 학생 검색
        stdList = new ArrayList<StudentDTO>();
        try {
            String sql = "SELECT * FROM student WHERE dptNo=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, dptNo);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String stdNo = rs.getString(1);
                String stdName = rs.getString(2);
                int stdYear = rs.getInt(3);
                String stdAddress = rs.getString(4);
                Date stdBirth = rs.getDate(5);
                dptNo = rs.getString(6);

                // StudentDTO 객체 생성 후 리스트에 추가
                std = new StudentDTO(stdNo, stdName, stdYear, stdAddress, stdBirth, dptNo);
                stdList.add(std);
            }
        } catch (SQLException e) {
            System.out.println("SQL 예외 발생: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DBConnect.close(pstmt, rs);
        }
        return stdList;
    }

    public void close() {
        DBConnect.close(con);
    }
}
