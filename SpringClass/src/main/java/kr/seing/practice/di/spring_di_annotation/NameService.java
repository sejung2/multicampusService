package kr.seing.practice.di.spring_di_annotation;

public class NameService implements INameService {

    @Override
    public String showName(String name) {
        System.out.println("NameService showName() method");
        String myname = "my name is " + name;
        return myname;
    }
}
