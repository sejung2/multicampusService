package com.spring.mybatis.spring_boot_jpa_product1.service;

import com.spring.mybatis.spring_boot_jpa_product1.dao.ProductDAO;
import com.spring.mybatis.spring_boot_jpa_product1.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceDataHandle implements IProductServiceDataHandle{

    ProductDAO dao;

    @Autowired
    public ProductServiceDataHandle(ProductDAO dao) {
        this.dao = dao;
    }

    @Override
    public ArrayList<ProductEntity> listAllProduct() {
        return dao.listAllProduct();
    }

    @Override
    public void insertProduct(ProductEntity entity) {
        dao.insertProduct(entity);
    }

    @Override
    public void updateProduct(ProductEntity entity) {
        dao.updateProduct(entity);
    }

    @Override
    public void deleteProduct(String prdNo) {
        dao.deleteProduct(prdNo);
    }

    @Override
    public Optional<ProductEntity> detailViewProduct(String prdNo) {
        return dao.detailViewProduct(prdNo);
    }

    @Override
    public String prdNoCheck(String prdNo) {
        return dao.prdNoCheck(prdNo);
    }

    @Override
    public ArrayList<ProductEntity> productSearch(HashMap<String, String> map) {
        return dao.productSearch(map);
    }
}
