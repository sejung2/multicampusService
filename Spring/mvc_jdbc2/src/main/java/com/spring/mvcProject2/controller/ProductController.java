package com.spring.mvcProject2.controller;

import com.spring.mvcProject2.dao.ProductDAO;
import com.spring.mvcProject2.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class ProductController {

    @Autowired
    ProductDAO productDao;

    // 시작 시 index 페이지 응답
    @RequestMapping("/")
    public String viewIndex() {
        return "index"; // view 결정
    }

    @RequestMapping("/product/productSelect")
    public String productSelect(Model model) {
        // 1. 서비스(DAO)의 처리기능 호출
        ArrayList<ProductDTO> prdList = productDao.productSelect();

        // 2. 반환된 결과를 Model 객체에 속성으로 저장
        model.addAttribute("prdList", prdList);

        // 3. model과 함께 view 페이지 반환
        return "productSelect";
    }
}
