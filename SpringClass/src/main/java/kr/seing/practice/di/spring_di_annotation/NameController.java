package kr.seing.practice.di.spring_di_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class NameController {
    //@Resource(name="anotherNameService") // 인터페이스 타입 참조 객체 변수
    @Resource() // 인터페이스 타입 참조 객체 변수
    INameService nameService;
    //setter 주입
    // spring xml을 활용한 setter의존성 주입일때는 클래스의 기본생성자 외에 다른 형태의 생성자는 필요없음
    //@Autowired
    //@Qualifier("anotherNameService") // 동일 타입 bean이 있을 때 특정 bean이 주입되도록
    public void setNameService(INameService nameService) {
        //etter의 파라미터를 통해서 NameService 객체 인스턴스 전달받음
        this.nameService = nameService;
    }

    public void show(String name) {
        System.out.println("NameController : " + nameService.showName(name));
    }
}
