package interfacePkg.sec05;

import java.util.List;

// 1. 회원가입: 1명의 정보를 받아서 DB에 저장하고 종료. 반환값 없음
// 2. 회원탈퇴: 1명의 정보를 받아서 DB에서 삭제하고 종료. 반환값 없음
// 3. 회원정보검색: 1명의 정보를 받아서 DB에서 검색하고, 검색된 정보를 반환
// 4. 회원정보수정: 1명의 정보를 받아서 DB에서 수정하고 종료. 반환값 없음
// 관리자 기능
// 5. 전체회원검색: DB에 저장된 모든 회원 정보를 반환, 반환값 있음
// 6. 회원 이름으로 조회: 1명의 이름을 받아서 DB에서 검색하고, 검색된 정보를 반환
public interface IMemberDAO {
    // 1. 회원가입
    public void insertMember(MemberDTO member);

    // 2. 회원탈퇴 - id 필요
    public void deleteMember(String memId);

    // 3. 회원정보검색 - id 필요
    public MemberDTO selectMember(String memId);

    // 4. 회원정보수정 - 해당 id 레코드의 모든 정보를 수정, 클라이언트로부터 수정된 정보를 전달 받으면 전달받은 정보 모두 없데이트
    public void updateMember(MemberDTO member);

    // 5. 전체회원검색 - DB에 저장된 모든 회원 정보를 반환, 한 명의 정보는 MemberDTO로 반환 여러명의 정보는 List<MemberDTO>로 반환
    public List<MemberDTO> getAllMember();

    // 6. 회원 이름으로 조회 - 이름을 받아서 DB에서 검색하고, 검색된 정보를 반환, 중복된 이름이 있을 수 있으므로 List<MemberDTO>로 반환
    public List<MemberDTO> getNameMember(String memName);
}
