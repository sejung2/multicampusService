package com.spring_boot_react.project.controller;

import com.spring_boot_react.project.model.ProductVO;
import com.spring_boot_react.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin("*")
@RestController
public class ProductRestController {

    @Autowired
    ProductService prdService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    
    // 전체 상품 조회
    @GetMapping("/product/productList")
    public ArrayList<ProductVO> viewProductList() {
        System.out.println("요청 받음");
        return prdService.listAllProduct();
        // 서버 반환 형식이 ArrList
    }
}
