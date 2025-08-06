package game_project.auth;

import java.util.ArrayList;
import java.util.List;

public class MemberDAO implements IMemberDAO { // IMemberDAO 인터페이스를 구현한 클래스
    List<MemberDTO> memberRepo = new ArrayList<>(); // 회원 정보를 저장하는 클래스

    @Override
    public void insertMember(MemberDTO member) { // 회원가입 메소드
        MemberDTO memberDTO = selectMember(member);
        if (memberDTO == null) { // 회원 정보가 존재하지 않으면 회원가입 진행
            System.out.println("회원가입 성공");
            System.out.println(member.getId() + " 님 회원가입이 완료되었습니다.");
            memberRepo.add(member); // 회원 정보를 저장
            System.out.println("회원 정보: " + member.toString()); // 회원 정보 출력
        } else {
            System.out.println("회원가입을 다시 시도해주세요.");
        }
    }

    @Override
    public MemberDTO selectMember(MemberDTO member) {
        // 이미 존재하는 계정인지 확인
        for (MemberDTO existingMember : memberRepo) {
            if (existingMember.equals(member)) {
                System.out.println("이미 존재하는 회원입니다.");
                return existingMember; // 회원 정보가 존재하면 해당 정보를 반환
            }
        }
        return null;
    }

    public MemberDTO findMemberById(String memId) {
        // 회원 ID로 회원 정보를 찾는 메소드
        for (MemberDTO member : memberRepo) {
            if (member.getId().equals(memId)) {
                return member; // 해당 ID의 회원 정보를 반환
            }
        }
        return null; // 해당 ID의 회원 정보가 없으면 null 반환
    }

    @Override
    public List<MemberDTO> getAllMember() {
        // 전체 회원 정보를 반환
        if (memberRepo.isEmpty()) {
            System.out.println("등록된 회원이 없습니다.");
            return List.of(); // 빈 리스트 반환
        }
        return memberRepo; // 모든 회원 정보를 반환
    }

    @Override
    public boolean login(String memId, String pass) {
        // 존재하는지 확인하고 로그인 기능 구현
        MemberDTO memberById = findMemberById(memId);
        if (memberById == null) {
            System.out.println("로그인 실패: 아이디가 존재하지 않습니다.");
            return false; // 아이디가 존재하지 않으면 로그인 실패
        }
        // 로그인 기능
        for (MemberDTO member : memberRepo) {
            if (member.getId().equals(memId) && member.getPass().equals(pass)) {
                System.out.println("로그인 성공");
                System.out.println("환영합니다, " + member.getName() + " 님!");
                return true; // 로그인 성공
            }
        }
        System.out.println("로그인 실패: 아이디 또는 비밀번호가 잘못되었습니다.");
        return false;
    }
}
