package com.spring.mybatis.spring_boot_jpa_product1.dto;

import com.spring.mybatis.spring_boot_jpa_product1.entity.ProductEntity;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Builder
@Getter
public class ProductDTO {
	private String prdNo;
	private String prdName;
	private int prdPrice;
	private String prdCompany;
	private int prdStock;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date prdDate;

    // Entity -> DTO
    public static ProductDTO toDto(ProductEntity entity) {
        return ProductDTO.builder()    // builder 클래스 객체 인스턴스 생성
                .prdNo(entity.getPrdNo())
                .prdName(entity.getPrdName())
                .prdPrice(entity.getPrdPrice())
                .prdCompany(entity.getPrdCompany())
                .prdStock(entity.getPrdStock())
                .prdDate(entity.getPrdDate())
                .build();               // ProductDTO 객체 생성
    }
}
