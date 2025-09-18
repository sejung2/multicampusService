package kr.seing.practice.di.spring_di_annotation_component2;

public class AnotherNameService
implements INameService {

    @Override
    public String showName(String name) {
        System.out.println("AnotherNameService showName() method");
        String myname = "Another my name is " + name;
        return myname;
    }
}
