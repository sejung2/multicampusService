package com.spring.mybatis.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/")
    public String home(Model model) {
        System.out.println("Hello Spring");
        model.addAttribute("message", "Hello Spring");
        return "hello"; // view 페이지 결정
    }
}
