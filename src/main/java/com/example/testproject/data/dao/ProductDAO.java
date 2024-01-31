package com.example.testproject.data.dao;

import com.example.testproject.data.entity.Product;

public interface ProductDAO {

    // 구체화된 코드가 들어가지 않음
    // 메소드 선언만
    Product saveProduct(Product product);

    Product getProduct(String productId);
    
}
