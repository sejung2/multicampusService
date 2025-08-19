package game_project.model;

import java.util.List;

// 1. 회원가입: 1명의 정보를 받아서 DB에 저장하고 종료. 반환값 없음
// 2. 회원정보검색: 1명의 정보를 받아서 DB에서 검색하고, 검색된 정보를 반환
// 3. 전체회원검색: DB에 저장된 모든 회원 정보를 반환, 한 명의 정보는 MemberDTO로 반환, 여러명의 정보는 List<MemberDTO>로 반환
// 4. 로그인 기능: 1명의 정보를 받아서 DB에서 검색하고, 로그인 성공 여부를 반환
public interface IMemberDAO {
    // 1. 회원가입
    boolean insert(MemberDTO member) throws Exception;

    // 2. 회원정보검색 - id 필요
    MemberDTO select(MemberDTO memId) throws Exception;

    // 3. 전체회원검색 - DB에 저장된 모든 회원 정보를 반환, 한 명의 정보는 MemberDTO로 반환 여러명의 정보는 List<MemberDTO>로 반환
    List<MemberDTO> getAllMember() throws Exception;

    // 4. 회원 정보 수정
    boolean update(MemberDTO member) throws Exception;

    // 5.회원 탈퇴
    boolean delete(MemberDTO member) throws Exception;
}
