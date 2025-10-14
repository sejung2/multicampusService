package com.spring.mybatis.spring_boot_jpa_product1.service;

import com.spring.mybatis.spring_boot_jpa_product1.dto.ProductDTO;
import com.spring.mybatis.spring_boot_jpa_product1.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    ProductServiceDataHandle productServiceDataHandle;

    @Autowired
    public ProductService(ProductServiceDataHandle productServiceDataHandle) {
        this.productServiceDataHandle = productServiceDataHandle;
    }

    @Override
    public ArrayList<ProductDTO> listAllProduct() {
        ArrayList<ProductEntity> entityList = productServiceDataHandle.listAllProduct();
        ArrayList<ProductDTO> list = new ArrayList<>();

        // entity -> dto 변환
        for (ProductEntity entity : entityList) {
            ProductDTO dto = ProductDTO.toDto(entity);
            list.add(dto);
        }
        return list;
    }

    @Override
    public void insertProduct(ProductDTO dto) {
        //dto -> entity 변환
        ProductEntity productEntity = ProductEntity.toEntity(dto);
        productServiceDataHandle.insertProduct(productEntity);
    }

    @Override
    public void updateProduct(ProductDTO dto) {
        // dto->entity
        ProductEntity entity = ProductEntity.toEntity(dto);
        productServiceDataHandle.updateProduct(entity);
    }

    @Override
    public void deleteProduct(String prdNo) {
        productServiceDataHandle.deleteProduct(prdNo);
    }

    @Override
    public ProductDTO detailViewProduct(String prdNo) {
        Optional<ProductEntity> entity = productServiceDataHandle.detailViewProduct(prdNo);

        // Optional로 반환된 객체에서 entity 추출(get())
        // entity -> dto 변환
        return ProductDTO.toDto(entity.get());
    }

    @Override
    public String prdNoCheck(String prdNo) {
        String result = productServiceDataHandle.prdNoCheck(prdNo);
        return result;
    }

    @Override
    public ArrayList<ProductDTO> productSearch(HashMap<String, String> map) {
        ArrayList<ProductEntity> entityList = productServiceDataHandle.productSearch(map);
        ArrayList<ProductDTO> list = new ArrayList<>();

        // entity -> dto 변환
        for (ProductEntity entity : entityList) {
            ProductDTO dto = ProductDTO.toDto(entity);
            list.add(dto);
        }
        return list;
    }
}
