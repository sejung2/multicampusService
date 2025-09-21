package kr.seing.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentController {

    @RequestMapping("/student/studentForm")
    public String studentFormView(Model model) {
        return "student/studentForm";
    }

    @RequestMapping("/student/studentForm2")
    public String studentFormView2(Model model) {
        return "student/studentForm2";
    }

    // 클라이언트로부터 전송된 폼데이터를 받는 방식
    // 1. request 객체 사용
    @RequestMapping("/student/newStudent")
    public String insertStudent(HttpServletRequest request, Model model) {
        // client -> controller
        String no = request.getParameter("no");
        String name = request.getParameter("name");
        String year = request.getParameter("year");

        // controller -> view
        model.addAttribute("no", no);
        model.addAttribute("name", name);
        model.addAttribute("year", year);

        return "student/studentResult";
    }

    // 2. @RequestParam 사용: 파라미터명과 값을 받을 변수명이 동일하면 어노테이션 생략 가능
    @RequestMapping("/student/newStudent2")
    public String insertStudent2(String no, String name, String year, Model model) {
        // controller -> view
        model.addAttribute("no", no);
        model.addAttribute("name", name);
        model.addAttribute("year", year);

        return "student/studentResult";
    }
}
