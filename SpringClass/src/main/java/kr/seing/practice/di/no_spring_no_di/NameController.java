package kr.seing.practice.no_spring_no_di;

import kr.seing.practice.di.no_spring_di_constructor.NameService;

public class NameController {

    NameService nameService;
    // setter의 파라미터를 통해서 NameService 객체 인스턴스 전달받음
    public void setNameService(NameService nameService) {
        this.nameService = nameService;
    }

    public void show(String name) {
        System.out.println("NameController = " + nameService.showName(name));
    }
}
