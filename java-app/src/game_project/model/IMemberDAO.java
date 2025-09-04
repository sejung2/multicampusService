package game_project.model;

import java.util.List;

public interface IMemberDAO {
    // 회원가입
    boolean insert(String id, String password) throws Exception;

    // 회원정보검색 - id 필요
    MemberDTO select(MemberDTO memId) throws Exception;

    // 전체회원검색 - DB에 저장된 모든 회원 정보를 반환, 한 명의 정보는 MemberDTO로 반환 여러명의 정보는 List<MemberDTO>로 반환
    List<MemberDTO> getAllMember() throws Exception;

    // 로그인
    boolean login(String id, String password) throws Exception;

    // 아이디로 회원 정보 검색
    MemberDTO selectById(String memId) throws Exception;

    // 아이디로 비밀번호 수정
    boolean updateById(String memId, String newPassword) throws Exception;

    // 아이디로 회원 탈퇴
    boolean deleteById(String memId) throws Exception;
}
