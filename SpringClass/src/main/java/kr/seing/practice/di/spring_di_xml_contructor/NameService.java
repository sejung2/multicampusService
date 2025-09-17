package kr.seing.practice.spring_di_xml_contructor;

public class NameService {
    public String showName(String name) {
        System.out.println("NameService showName() method");
        String myname = "my name is " + name;
        return myname;
    }
}
