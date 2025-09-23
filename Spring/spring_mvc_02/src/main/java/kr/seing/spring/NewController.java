package kr.seing.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URLEncoder;

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

    @RequestMapping("/redirect")
    public String redirect() {
        System.out.println("redirect 요청 처리");
        // showInfo redirect
        // 클라이언트에 302 응답코드와 함께 /showInfo로 재요청
        // redirect: 는 클라이언트 측에 요청이 http로 요청이 들어옴(서버 설정 변경 필요)
        return "redirect:/showInfo"; // / 요청을 다시 처리
    }

    // redirect 시 파라미터 전송 방법
    // 1. 쿼리 스트링 방식으로 url에 포함
    @RequestMapping("/redirectParam1")
    public String redirectParam() throws Exception {
        System.out.println("redirectParam 쿼리스트링");
        String nation = "대한민국1";
        nation = URLEncoder.encode(nation, "UTF-8");
        return "redirect:/showRedirectParam/?nation=" + nation; // / 요청을 다시 처리
    }

    // 2. model 객체에 addAttribute() 메서드로 저장
    @RequestMapping("/redirectParam2")
    public String redirectParam(Model model) {
        System.out.println("redirectParam 쿼리스트링");
        String nation = "대한민국2";
        model.addAttribute("nation", nation);
        return "redirect:/showRedirectParam"; // / 요청을 다시 처리
    }

    // 3. RedirectAttributes 객체 메서드 addAttribute() 사용
    @RequestMapping("/redirectParam3")
    public String redirectParam2(RedirectAttributes reAttr) {
        System.out.println("redirectParam RedirectAttr 활용");
        String nation = "대한민국3";
        reAttr.addAttribute("nation", nation);
        return "redirect:/showRedirectParam";
    }

    // redirect 요청 메서드
    @RequestMapping("/showRedirectParam")
    public String showParam(@RequestParam("nation") String nation, Model model) {
        model.addAttribute("nation", nation);
        return "showRedirectParam";
    }
}
