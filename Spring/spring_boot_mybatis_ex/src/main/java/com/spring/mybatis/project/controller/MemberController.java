package com.spring.mybatis.project.controller;

import com.spring.mybatis.project.model.MemberVO;
import com.spring.mybatis.project.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class MemberController {

    @Autowired
    MemberService memService;

    // 로그인 폼 요청 처리
    @GetMapping("/member/loginForm")
    public String loginForm() {
        return "member/loginForm";
    }

    // 로그인 처리 : 암호화 x
//    @ResponseBody
//    @PostMapping("/member/login")
//    public String loginCheck(@RequestParam HashMap<String, Object> map, HttpSession session) {
//        String result = "FAIL";
//        String memId = memService.loginCheck(map);
//
//        if (memId != null) {
//            session.setAttribute("sid", memId);
//            result = "SUCCESS";
//        }
//        return result;
//    }

    // 로그인 처리 : 암호화 o: 로그인 여부 서비스가 결정
    @ResponseBody
    @PostMapping("/member/login")
    public String loginCheck(@RequestParam HashMap<String, Object> param, HttpSession session) {

        String result = memService.loginCheck(param);

        if(result.equals("success")) {
            // 로그인 조건에 만족하면 로그인 처리(세션을 활용) : 세션변수에 id값을 저장
            session.setAttribute("sid", (String)param.get("id"));
        }
        return result;
    }

    // 로그아웃 처리 (세션 유효성 종료)
    @GetMapping("/member/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 무효화
        return "redirect:/"; // 메인 페이지로 이동
    }

    // 회원가입 폼 요청 처리
    @GetMapping("/member/joinForm")
    public String joinForm() {
        return "member/joinForm";
    }

    // id 중복 확인 요청 처리
    @ResponseBody
    @PostMapping("/member/idCheck")
    public int idCheck(@RequestParam("id") String id) {
        int result = 0;
        String id_res = memService.idCheck(id);

        if (id_res != null) {
            result = 1; // 중복된 id가 존재
        }
        return result;
    }

    // 회원가입 요청처리
    @PostMapping("/member/join")
    public String join(MemberVO vo,
                       @RequestParam("memHp1") String memHp1,
                       @RequestParam("memHp2") String memHp2,
                       @RequestParam("memHp3") String memHp3) {
        // 전화번호 조합
        String memHp = memHp1 + "-" + memHp2 + "-" + memHp3;
        vo.setMemHP(memHp);
        memService.insertMember(vo);
        return "redirect:/member/loginForm"; // 로그인 폼 페이지로 이동
    }
}
