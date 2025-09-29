package com.spring.mybatis.project.service;


import com.spring.mybatis.project.model.ProductVO;

import java.util.ArrayList;
import java.util.HashMap;

public interface IProductService {
    ArrayList<ProductVO> listAllProduct();
    void insertProduct(ProductVO vo);
    void updateProduct(ProductVO vo);
    void deleteProduct(String prdNo);
    ProductVO detailViewProduct(String prdNo);
    String prdNoCheck(String prdNo); // 상품 번호 중복 체크
    ArrayList<ProductVO> productSearch(HashMap<String, Object> map); // 상품 검색
}
