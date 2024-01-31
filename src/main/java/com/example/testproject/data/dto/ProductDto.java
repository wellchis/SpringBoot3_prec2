package com.example.testproject.data.dto;

import com.example.testproject.data.entity.Product;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDto {

    @NotNull
    // @Size(min = 8, max = 8) // abcdefg
    private String productId;

    @NotNull
    private String productName;

    @NotNull
    @Min(value = 500)
    @Max(value = 3000000)
    private int productPrice;

    @NotNull
    @Min(value = 0)
    @Max(value = 9999)
    private int productStock;

    public Product toEntity(){
        return Product.builder()
            .id(productId)
            .name(productName)
            .price(productPrice)
            .stock(productStock)
            .build();
    }

}
