package com.spring.mybatis.project.controller;

import com.spring.mybatis.project.model.ProductVO;
import com.spring.mybatis.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class ProductController {
    // DI 주입
    @Autowired
    ProductService service;

    @RequestMapping("/")
    public String viewIndex() {
        return "index";
    }

    //전체 상품 조회
    @RequestMapping("/product/listAllProduct")
    public String listAllProduct(Model model) {
        //1. service 메소드 호출
        ArrayList<ProductVO> prdList = service.listAllProduct();
        //2. model에 prdList 저장
        model.addAttribute("prdList", prdList);
        //3. 뷰 페이지 결정 후 반환
        return "product/productListView";
    }

    //상품 등록 폼 요청
    @RequestMapping("/product/newProductForm")
    public String newProductForm() {
        return "product/newProductForm";
    }

    // 상품 등록 요청 -> 로직 처리
    @RequestMapping("/product/insertProduct")
    public String insertProduct(ProductVO vo) {
        // 1. insert 기능을 처리할 service 메소드 호출 (파라미터로 전달된 입력값을 command 객체에 저장해서 전송)
        service.insertProduct(vo);
        // 2. 상품 등록 후에 확인 위해서 전체상품목록을 뷰로 결정 - 전체 상품조회 재요청
        return "redirect: /product/listAllProduct";
    }

    // 상품 상세 조회
    @RequestMapping("/product/detailViewProduct/{prdNo}")
    public String detailViewProduct(@PathVariable String prdNo, Model model) {
        // 1. 상품 정보 전송해서 관련 정보 반환
        ProductVO prd = service.detailViewProduct(prdNo);
        // 2. 반환 정보 model에 저장
        model.addAttribute("prd", prd);
        // 3. 뷰 페이지 결정 후 반환
        return "/product/productDetailView";
    }

    // 상품 정보 수정 요청 처리: /product/updateProductForm/1003
    @RequestMapping("/product/updateProductForm/{prdNo}")
    public String updateProduct(@PathVariable String prdNo, Model model) {
        ProductVO prd = service.detailViewProduct(prdNo);
        model.addAttribute("prd", prd);
        return "product/updateProductForm";
    }

    // 상품 정보 수정 로직 처리
    @RequestMapping("/product/updateProduct")
    public String updateProduct(ProductVO prd) {
        service.updateProduct(prd);
        return "redirect:/product/listAllProduct";
    }

    // 상품정보 삭제 로직 처리
    @RequestMapping("/product/deleteProduct/{prdNo}")
    public String deleteProduct(@PathVariable String prdNo) {
        service.deleteProduct(prdNo);
        return "redirect:/product/listAllProduct";
    }

    // --------------------------------------------------------

    // ajax 처리 연습

    @ResponseBody
    @RequestMapping("/product/prdNoCheck")
    public String prdNoCheck(@RequestParam("prdNo") String prdNo) {
        String prdNo_result = service.prdNoCheck(prdNo);

        String result = "available";
        if (prdNo_result != null) {
            result = "no_available";
        }
        return result;
    }

    // ajax get 방식요청처리 - 요청 url에 상품 번호가 포함됨
    // 상품 정보 중복 체크
    @ResponseBody
    @RequestMapping("/product/prdNoCheck1/{prdNo}")
    public String prdNoCheck1(@PathVariable String prdNo) {
        String prdNo_result = service.prdNoCheck(prdNo);

        String result = "available";
        if (prdNo_result != null) {
            result = "no_available";
        }
        return result;
    }

    // fetch get 방식요청처리 - 요청 url에 상품 번호가 포함됨
    @ResponseBody
    @RequestMapping("/product/prdNoCheck2/{prdNo}")
    public String prdNoCheck2(@PathVariable String prdNo) {
        String prdNo_result = service.prdNoCheck(prdNo);

        String result = "available";
        if (prdNo_result != null) {
            result = "no_available";
        }
        return result;
    }

    // fetch post 방식요청처리
    @ResponseBody
    @RequestMapping("/product/prdNoCheck3")
    public String prdNoCheck3(@RequestBody String prdNo) {
        String prdNo_result = service.prdNoCheck(prdNo);

        String result = "available";
        if (prdNo_result != null) {
            result = "no_available";
        }
        return result;
    }

    // axios get 방식요청처리 - 요청 url에 상품 번호가 포함됨
    @ResponseBody
    @RequestMapping("/product/prdNoCheck4/{prdNo}")
    public String prdNoCheck4(@PathVariable String prdNo) {
        String prdNo_result = service.prdNoCheck(prdNo);

        String result = "available";
        if (prdNo_result != null) {
            result = "no_available";
        }
        return result;
    }

    // axios post 방식요청처리 - 요청 url에 상품 번호가 포함됨
    @ResponseBody
    @RequestMapping("/product/prdNoCheck5")
    public String prdNoCheck5(@RequestBody HashMap<String, String> map) {
        String prdNo = map.get("prdNo");
        String prdNo_result = service.prdNoCheck(prdNo);

        String result = "available";
        if (prdNo_result != null) {
            result = "no_available";
        }
        return result;
    }

    // 상품 검색 폼 요청처리
    @RequestMapping("/product/productSearchForm1")
    public String productSearchForm1() {
        return "product/productSearchForm1";
    }

    // 상품 검색 처리
    // 파라미터 2개 전송됨: 검색 기준, 검색어
    @ResponseBody
    @RequestMapping("/product/productSearch1")
    public String productSearch1(@RequestParam HashMap<String, Object> param, Model model) {
        ArrayList<ProductVO> prdList = service.productSearch(param);
        model.addAttribute("prdList", prdList);
        return "/product/productSearchResulView";
    }

    //상품검색 폼2 요청 처리
    @RequestMapping("/product/productSearchForm2")
    public String productSearchForm2() {
        return "/product/productSearchForm2";
    }

    //상품 검색 처리2
    //파라미터 2개 전송됨 : 검색기준,검색어 : type:prdName keyword:모니터
    @RequestMapping("/product/productSearch2")
    public String productSearch2(@RequestParam HashMap<String, Object> param, Model model) {
        System.out.println("test");
        ArrayList<ProductVO> prdList = service.productSearch(param);
        model.addAttribute("prdList", prdList);

        return "product/productSearchResultView";
    }

    //상품검색 폼3 요청 처리
    @RequestMapping("/product/productSearchForm3")
    public String productSearchForm3() {
        return "/product/productSearchForm3";
    }
}
