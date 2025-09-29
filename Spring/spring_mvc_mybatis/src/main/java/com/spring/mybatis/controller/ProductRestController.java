package com.spring.mybatis.controller;

import com.spring.mybatis.model.ProductVO;
import com.spring.mybatis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController //클래스 빈 등록, 컨트롤러 의미 전달, Rest 방식의 응답처리
public class ProductRestController {
    @Autowired
    ProductService prdService;

    @RequestMapping("product/productSearch3")
    public ArrayList<ProductVO> productSearch2(@RequestParam HashMap<String, Object> param) {
        ArrayList<ProductVO> prdList = prdService.productSearch(param);
        return prdList;
    }
}
