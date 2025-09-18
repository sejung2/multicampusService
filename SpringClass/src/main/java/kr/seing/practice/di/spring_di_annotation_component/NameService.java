package kr.seing.practice.di.spring_di_annotation_component;

import org.springframework.stereotype.Component;

// 주입되어지는 클래스
// bean으로 등록
@Component
public class NameService implements INameService {

    @Override
    public String showName(String name) {
        System.out.println("NameService showName() method");
        String myname = "my name is " + name;
        return myname;
    }
}
