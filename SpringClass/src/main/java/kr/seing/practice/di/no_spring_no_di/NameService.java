package kr.seing.practice.no_spring_no_di;

public class NameService {

    public String getMember(String name) {
        return "Member Name: " + name;
    }

    public String showName(String name) {
        return "NameService = " + getMember(name);
    }
}
