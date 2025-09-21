package kr.seing.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewController {

    @RequestMapping("/newView") // contexthPath/newView 로 들어온 요청이 메서드로 전달(호출되면서 관련 정보객체가 전달됨)
    public String newView() {
        return "newView"; // view 파일 결정해서 반환
    }


}
