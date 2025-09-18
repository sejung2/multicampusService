package kr.seing.practice.di.spring_di_annotation_component2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class NameController {
    @Autowired
    INameService nameService;

//    public void setNameService(INameService nameService) {
//        this.nameService = nameService;
//    }

    public void show(String name) {
        System.out.println("NameController : " + nameService.showName(name));
    }
}
