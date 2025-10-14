package com.spring.mybatis.spring_boot_jpa_product1.dao;

import com.spring.mybatis.spring_boot_jpa_product1.dto.ProductDTO;
import com.spring.mybatis.spring_boot_jpa_product1.entity.ProductEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public interface IProductDAO {
    ArrayList<ProductEntity> listAllProduct();

    void insertProduct(ProductEntity entity);

    void updateProduct(ProductEntity entity);

    void deleteProduct(String prdNo);

    Optional<ProductEntity> detailViewProduct(String prdNo); // 1개 entity를 조회하는 repo method는 반환타입 Option<T> 임

    String prdNoCheck(String prdNo);

    ArrayList<ProductEntity> productSearch(HashMap<String, String> map);
}
