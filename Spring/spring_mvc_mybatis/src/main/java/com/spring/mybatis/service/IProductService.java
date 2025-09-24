package com.spring.mybatis.service;

import com.spring.mybatis.model.ProductVO;

import java.util.ArrayList;

public interface IProductService {
    ArrayList<ProductVO> listAllProduct();
    void insertProduct(ProductVO vo);
    void updateProduct(ProductVO vo);
    void deleteProduct(String prdNo);
    ProductVO detailViewProduct(String prdNo);

}
