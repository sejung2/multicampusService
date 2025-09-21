package kr.seing.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    // showInfo 요청: 컨트롤러에서 데이터를 model 객체에 저장해서 view로 전달하는 메서드
    @RequestMapping("/showInfo")
    public String showInfo(Model model) { // 데이터를 뷰로 전달: model 객체를 통해서
        model.addAttribute("name", "홍길동");
        model.addAttribute("age", 25);
        return "showInfo"; // view 페이지 이름 - /WEB-INF/views/showInfo.jsp
    }

    // ModelAndView 객체: 데이터와 뷰 정보를 객체에 임시저장
    // 데이터: addAttribute, view 정보: setViewName("view 페이지 명")
    // 객체 반환
    @RequestMapping("/showInfo2")
    public ModelAndView showInfo2(ModelAndView mv) {
        mv.addObject("name", "이순신");
        mv.addObject("address", "서울시");
        mv.setViewName("showInfoMV");
        return mv;
    }

    // Model, ModelAndView 객체 모두 주입
    @RequestMapping("/showInfo3")
    public ModelAndView showInfo3(Model model, ModelAndView mv) {
        model.addAttribute("name", "강감찬");
        mv.addObject("name", "김유신");
        mv.addObject("age", 25);
        mv.setViewName("showInfo3");
        model.addAttribute("address", "부산시");

        return mv;
    }
}
