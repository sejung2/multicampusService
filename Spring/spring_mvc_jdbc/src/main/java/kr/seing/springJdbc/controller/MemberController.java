package kr.seing.springJdbc.controller;

import kr.seing.springJdbc.dao.MemberDAO;
import kr.seing.springJdbc.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class MemberController {

    @Autowired
    MemberDAO memDao;

    // 시작 시 index 페이지 응답
    @RequestMapping("/")
    public String viewIndex() {
        return "index"; // view 결정
    }

    @RequestMapping("/member/memberSelect")
    public String memberSelect(Model model) {
        // 1. 서비스(DAO)의 처리기능 호출
        ArrayList<MemberDTO> memList = memDao.memberSelect();

        // 2. 반환된 결과를 Model 객체에 속성으로 저장
        model.addAttribute("memList", memList);

        // 3. model과 함께 view 페이지 반환
        return "memberSelect";
    }
}
