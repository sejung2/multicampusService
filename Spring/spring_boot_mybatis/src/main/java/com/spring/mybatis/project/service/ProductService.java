package com.spring.mybatis.project.service;

import com.spring.mybatis.project.dao.IProductDAO;
import com.spring.mybatis.project.model.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ProductService implements IProductService {

    @Autowired
    @Qualifier("IProductDAO")
    IProductDAO dao;

    @Override
    public ArrayList<ProductVO> listAllProduct() {
        return dao.listAllProduct();
    }

    @Override
    public void insertProduct(ProductVO vo) {
        dao.insertProduct(vo);
    }

    @Override
    public void updateProduct(ProductVO vo) {
        dao.updateProduct(vo);
    }

    @Override
    public void deleteProduct(String prdNo) {
        dao.deleteProduct(prdNo);
    }

    @Override
    public ProductVO detailViewProduct(String prdNo) {
        return dao.detailViewProduct(prdNo);
    }

    @Override
    public String prdNoCheck(String prdNo) {
        return dao.prdNoCheck(prdNo);
    }

    @Override
    public ArrayList<ProductVO> productSearch(HashMap<String, Object> map) {
        return dao.productSearch(map);
    }
}
