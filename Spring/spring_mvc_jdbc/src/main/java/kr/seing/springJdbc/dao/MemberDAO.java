package kr.seing.springJdbc.dao;

import kr.seing.springJdbc.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

@Repository
public class MemberDAO {
	private DataSource dataFactory;

    @Autowired
	public MemberDAO(DataSource dataFactory) {
		try {
            this.dataFactory = dataFactory;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 회원 정보 조회 메소드 (전체 회원 정보 SELECT 해서 반환)
	// MemberDTO로 받아서 ArrayList에 저장 후 ArrayList 객체 memList 반환
	public ArrayList<MemberDTO> memberSelect() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 데이터 저장해서 반환할 ArrayList 객체 생성
		ArrayList<MemberDTO> memList = new ArrayList<MemberDTO>();
		
		
		try {
			con = dataFactory.getConnection();

			String sql = "select * from member2";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 한 행(1명) 처리
				String memId = rs.getString("memId"); // 순서 번호 1, 2, 3... 사용해도 되고, 열 이름 사용해도 됨
				String memPwd = rs.getString("memPwd");
				String memName = rs.getString("memName");
				String memEmail = rs.getString("memEmail");
				Date memJoinDate = rs.getDate("memJoinDate");
				
				// MemberDTO에 담아서
				MemberDTO vo = new MemberDTO();				
				vo.setMemId(memId);
				vo.setMemPwd(memPwd);
				vo.setMemName(memName);
				vo.setMemEmail(memEmail);
				vo.setMemJoinDate(memJoinDate);
				
				// ArrayList에 추가
				memList.add(vo);
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {}
		}
		
		return memList; // ArrayList 반환
	}
}




