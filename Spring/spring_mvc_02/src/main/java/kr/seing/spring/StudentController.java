package kr.seing.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class StudentController {

    @RequestMapping("/student/studentForm")
    public String studentFormView() {
        return "student/studentForm";
    }

    @RequestMapping("/student/studentForm2")
    public String studentFormView2() {
        return "student/studentForm2";
    }

    @RequestMapping("/student/studentForm3")
    public String studentFormView3() {
        return "student/studentForm3";
    }

    @RequestMapping("/student/studentForm4")
    public String studentFormView4() {
        return "student/studentForm4";
    }

    @RequestMapping("/student/studentForm5")
    public String studentFormView5() {
        return "student/studentForm5";
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

    // 3. command 객체 활용 파라미터 사용
    @RequestMapping("/student/newStudent3")
    public String insertStudent3(Student student) {
        System.out.println(student.getNo());
        System.out.println(student.getName());
        System.out.println(student.getYear());
        // command 객체 통해서 파라미터 값 바로 추출해서 객체에 저장 가능한 이유는?
        // 파라미터명과 객체의 필드명이 동일하지 않기 때문에 모듈이 파라미터명과 필드명으로 매칭을 시킴
        // 두 name이 다르면 매칭되지 않아 값 활용 불가능
        return "student/studentResult2";
    }

    // view 로 전달되는 command 객체명 변경 어노테이션 @ModelAttribute
    @RequestMapping("student/newStudent4")
    public String insertStudent4(@ModelAttribute("studentInfo") Student student) {
        return "student/studentResult3";
    }

    @RequestMapping("student/newStudent5")
    public String insertStudent5(Student student) {
        return "student/studentResult4";
    }

    @RequestMapping("student/studentSearchForm")
    public String studentSearch(Student student) {
        return "student/studentSearchForm";
    }

    // uri 구성시 {변수명} -> 파라미터명처럼 변수명이 사용되어져서 stdNo 위치의 문자열은 전송 value로 사용가능
    @RequestMapping("student/studentDetailView/{stdNo}")
    public String studentDetailView(@PathVariable String stdNo) { // url로 전달된 값을 사용 @PathVariable 어노테이션 사용
        System.out.println("학생 상세보기, 학번: " + stdNo);
        return "student/studentResult";
    }

    @RequestMapping("student/studentDetailView/{stdNo}/{stdName}/{stdYear}")
    public String studentDetailView1(@PathVariable String stdNo, @PathVariable String stdName, @PathVariable String stdYear) {
        System.out.println("학생 상세보기, 학번: " + stdNo);
        System.out.println("학생 상세보기, 이름: " + stdName);
        System.out.println("학생 상세보기, 학년: " + stdYear);
        return "student/studentResult";
    }

    @RequestMapping("/student/studentSearch")
    public String studentSearch(@RequestParam HashMap<String, Object> param, Model model) {
        // param 참조변수 통해 전달된 파라미터 출력
        System.out.println(param.get("type"));
        System.out.println(param.get("keyword"));
        // 서비스 통해서 dbms 연결 후  keyword를 통한 select 진행 후 결과 반환받는 코드

        // name 홍길동으로 검색한 결과가 2명 존재한다고 가정
        Student student = new Student();
        student.setName("홍길동");
        student.setYear(1);
        student.setNo("2024001");

        Student student2 = new Student();
        student2.setName("홍길동");
        student2.setYear(3);
        student2.setNo("2022005");

        // ArrayList 활용해서 검색 결과 저장
        ArrayList<Student> stdList = new ArrayList<>();
        stdList.add(student);
        stdList.add(student2);

        // Model 객체에 collection 저장 후 view로 전달
        model.addAttribute("stdList", stdList);

        return "student/studentSearchResult";
    }
}
