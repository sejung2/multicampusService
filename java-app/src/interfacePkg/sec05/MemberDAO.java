package interfacePkg.sec05;

import java.util.List;

public class MemberDAO implements IMemberDAO{
    // db connection data fields
    // db connection methods


    // 실제 구현은 DB와 연결하여 CRUD 작업을 수행하는 로직이 필요함
    // 관련 쿼리를 전달해서 각 기능이 수행되게 해야 함
    @Override
    public void insertMember(MemberDTO member) {
        String id = member.getMemId();
        System.out.println("회원가입 성공");
        System.out.println(id + " 님 회원가입이 완료되었습니다.");
    }

    @Override
    public void deleteMember(String memId) {

    }

    @Override
    public MemberDTO selectMember(String memId) {
        // db에 id를 전달하여 검색된 회원 정보룰 받았다고 가정하면 정보를 DTO에 담아서 반환
        MemberDTO dto = new MemberDTO("123", "abcd", "홍길동", "1111", "서울시 강남구");
        return null;
    }

    @Override
    public void updateMember(MemberDTO member) {

    }

    @Override
    public List<MemberDTO> getAllMember() {
        return List.of();
    }

    @Override
    public List<MemberDTO> getNameMember(String memName) {
        return List.of();
    }
}
