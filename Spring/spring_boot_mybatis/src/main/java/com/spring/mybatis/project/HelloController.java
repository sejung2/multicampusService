package com.spring.mybatis.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

//    @ResponseBody
//    @GetMapping("/")
//    public String home() {
//        System.out.println("Hello Spring");
//        return "Hello Spring"; // view 로 인식하면 view를 찾음, 404 에러 발생, @ResponseBody 사용 rest 응답
//    }

    @GetMapping("/")
    public String home(Model model) {
        System.out.println("Hello Spring");
        model.addAttribute("message", "Hello Spring");
        return "hello"; // view 페이지 결정
    }
}
