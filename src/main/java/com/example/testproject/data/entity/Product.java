package com.example.testproject.data.entity;

import com.example.testproject.data.dto.ProductDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
// 테이블명
@Table(name = "product")
public class Product extends BaseEntity {

    // Primary Key
    @Id
    String id;
    String name;
    Integer price;
    Integer stock;

    public ProductDto toDto(){
        return ProductDto.builder()
                .productId(id)
                .productName(name)
                .productPrice(price)
                .productStock(stock)
                .build();
    }
}
