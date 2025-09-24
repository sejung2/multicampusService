package com.spring.mybatis.service;

import com.spring.mybatis.dao.IProductDAO;
import com.spring.mybatis.model.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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

    }

    @Override
    public void updateProduct(ProductVO vo) {

    }

    @Override
    public void deleteProduct(String prdNo) {

    }

    @Override
    public ProductVO detailViewProduct(String prdNo) {
        return null;
    }
}
