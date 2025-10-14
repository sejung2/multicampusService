package com.spring.mybatis.spring_boot_jpa_product1.entity;

import com.spring.mybatis.spring_boot_jpa_product1.dto.ProductDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

// @Builder // DTO <-> Entity 변환
// @AllArgsConstructor // 클래스의 모든 필드 값을 파라미터로 받는 생성자 자동 생성
// @NoArgsConstructor // 기본 생성자 자동 생성
// @Getter // 클래스의 모든 필드에 대한 getter 메서드 자동 생성
// @Setter // 클래스의 모든 필드에 대한 setter 메서드 자동 생성
// @Data // @ToString, @Getter, @Setter, 등을 한번에 처리

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product2")
public class ProductEntity {
    @Id
    private String prdNo;
    private String prdName;
    private int prdPrice;
    private String prdCompany;
    private int prdStock;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prdDate;

    // DTO -> Entity
    public static ProductEntity toEntity(ProductDTO dto) {
        return ProductEntity.builder()
                .prdNo(dto.getPrdNo())
                .prdName(dto.getPrdName())
                .prdPrice(dto.getPrdPrice())
                .prdCompany(dto.getPrdCompany())
                .prdStock(dto.getPrdStock())
                .prdDate(dto.getPrdDate())
                .build();
    }
}
