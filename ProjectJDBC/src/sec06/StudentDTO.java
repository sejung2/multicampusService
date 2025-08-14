package sec06;

import java.util.Date;

// 학생의 정보를 담아 교환하기 위한 클래스
public class StudentDTO {
    // db 테이블의 컬럼과 동일한 필드 선언
    private String stdNo; // 학번
    private String stdName; // 이름
    private int stdYear;
    private String stdAddress; // 주소
    private Date stdBirth; // 생년월일
    private String dptNo;

    public StudentDTO(String stdNo, String stdName, int stdYear, String stdAddress, Date stdBirth, String dptNo) {
        this.stdNo = stdNo;
        this.stdName = stdName;
        this.stdYear = stdYear;
        this.stdAddress = stdAddress;
        this.stdBirth = stdBirth;
        this.dptNo = dptNo;
    }

    public String getStdNo() {
        return stdNo;
    }

    public void setStdNo(String stdNo) {
        this.stdNo = stdNo;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public int getStdYear() {
        return stdYear;
    }

    public void setStdYear(int stdYear) {
        this.stdYear = stdYear;
    }

    public String getStdAddress() {
        return stdAddress;
    }

    public void setStdAddress(String stdAddress) {
        this.stdAddress = stdAddress;
    }

    public Date getStdBirth() {
        return stdBirth;
    }

    public void setStdBirth(Date stdBirth) {
        this.stdBirth = stdBirth;
    }

    public String getDptNo() {
        return dptNo;
    }

    public void setDptNo(String dptNo) {
        this.dptNo = dptNo;
    }
}
