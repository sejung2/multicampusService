package kr.seing.spring;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Student {
    private String no;
    private String name;
    private int year;
    // Date type 필드를 포함하는 클래스가 command 클래스로 주입되어 사용될 때는 입력되는 날짜의 포맷을 결정해야함
    // @DateTimeFormat(pattern = "yyyy-MM-dd") // yyyy/MM/dd
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date birthday;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

//    public Date getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(Date birthday) {
//        this.birthday = birthday;
//    }
}
