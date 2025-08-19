package game_project.model;

import java.util.Objects;

public class MemberDTO { // 회원 정보를 저장하는 DTO 클래스
    private String memNo; // 회원 번호
    private String memId; // 회원 아이디
    private String memPass; // 회원 비밀번호
    private String memName; // 회원 이름(닉네임)

    public MemberDTO() {
    }

    public MemberDTO(String memNo, String memId, String memPass, String memName) {
        this.memNo = memNo;
        this.memId = memId;
        this.memPass = memPass;
        this.memName = memName;
    }

    public String getMemNo() {
        return memNo;
    }

    public void setMemNo(String memNo) {
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

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MemberDTO memberDTO = (MemberDTO) o;
        return Objects.equals(memNo, memberDTO.memNo) && Objects.equals(memId, memberDTO.memId) && Objects.equals(memPass, memberDTO.memPass) && Objects.equals(memName, memberDTO.memName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memNo, memId, memPass, memName);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(memNo);
        builder.append("\t");
        builder.append(memId);
        builder.append("\t");
        builder.append(memPass);
        builder.append("\t");
        builder.append(memName);
        return builder.toString();
    }
}
