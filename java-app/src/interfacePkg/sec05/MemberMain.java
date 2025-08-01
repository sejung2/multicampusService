package interfacePkg.sec05;

public class MemberMain {
    public static void main(String[] args) {
        // DTO DAO ex
        // 회원가입을 위한 정보가 있다고 가정
        MemberDTO dto = new MemberDTO("abcd", "1234", "홍길동", "010-1234-5678", "서울시 강남구 역삼동");

        // DAO에게 전달하여 회원가입을 요청
        IMemberDAO idao = new MemberDAO();
        MemberDAO dao = new MemberDAO();

        idao.insertMember(dto);
        dao.insertMember(dto);

        // 회원 검색
        dto = idao.selectMember("123");
        // 검색된 결과인 dto를 view로 넘겨서 프론트 단에서 출력
    }
}
