package kr.seing.practice.di.no_spring_di_constructor;

public class NameService {

    public String getMember(String name) {
        return "Member Name: " + name;
    }

    public String showName(String name) {
        return "NameService = " + getMember(name);
    }
}
