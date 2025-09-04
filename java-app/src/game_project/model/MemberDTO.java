package game_project.model;

import java.util.Objects;

// member 테이블 생성쿼리
/*
* CREATE TABLE member (
    memNo INT AUTO_INCREMENT PRIMARY KEY,
    memId VARCHAR(100) NOT NULL,
    memPass VARCHAR(50) NOT NULL
);
* */

public class MemberDTO { // 회원 정보를 저장하는 DTO 클래스
    private int memNo; // 회원 번호 (String -> int로 변경)
    private String memId; // 회원 아이디
    private String memPass; // 회원 비밀번호

    public MemberDTO() {
    }

    // 회원가입용 생성자 (memNo는 DB에서 자동생성)
    public MemberDTO(String memId, String memPass) {
        this.memId = memId;
        this.memPass = memPass;
    }

    // 전체 생성자
    public MemberDTO(int memNo, String memId, String memPass) {
        this.memNo = memNo;
        this.memId = memId;
        this.memPass = memPass;
    }

    // memNo getter/setter 추가
    public int getMemNo() {
        return memNo;
    }

    public void setMemNo(int memNo) {
        this.memNo = memNo;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getMemPass() {
        return memPass;
    }

    public void setMemPass(String memPass) {
        this.memPass = memPass;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MemberDTO memberDTO = (MemberDTO) o;
        return memNo == memberDTO.memNo && Objects.equals(memId, memberDTO.memId) && Objects.equals(memPass, memberDTO.memPass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memNo, memId, memPass);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(memNo);
        builder.append("\t");
        builder.append(memId);
        builder.append("\t");
        builder.append(memPass);
        return builder.toString();
    }
}