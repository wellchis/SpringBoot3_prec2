package com.example.testproject.service;

import com.example.testproject.data.dto.ProductDto;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);

    ProductDto getProduct(String productId);

}
