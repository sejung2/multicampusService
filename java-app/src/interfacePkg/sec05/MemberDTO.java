package interfacePkg.sec05;

// 데이터 전송 객체 (DTO) 클래스
// 회원관리에 사용할 예정 - 회원 한 명에 대한 정보를 담는 클래스
// 필요 필드: 회원가입 시 받아야 할 정보 결정
public class MemberDTO {
    private String memId;
    private String memPass;
    private String memName;
    private String memPhone;
    private String memAddress;

    public MemberDTO(String memId, String memPass, String memName, String memPhone, String memAddress) {
        this.memId = memId;
        this.memPass = memPass;
        this.memName = memName;
        this.memPhone = memPhone;
        this.memAddress = memAddress;
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

    public String getMemPhone() {
        return memPhone;
    }

    public void setMemPhone(String memPhone) {
        this.memPhone = memPhone;
    }

    public String getMemAddress() {
        return memAddress;
    }

    public void setMemAddress(String memAddress) {
        this.memAddress = memAddress;
    }
}
