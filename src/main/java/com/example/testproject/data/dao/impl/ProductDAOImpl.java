package com.example.testproject.data.dao.impl;

import com.example.testproject.data.dao.ProductDAO;
import com.example.testproject.data.entity.Product;
import com.example.testproject.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAOImpl implements ProductDAO{

    // 인터페이스 실체
    ProductRepository productRepository; // Repository 선언

    // Spring Boot는 기본적으로 SingleTon Pattern
    // 하나의 Repository로 여러 곳에서 사용하는 방식
    @Autowired // 자동으로 연결 // 객체주입 // DI(의존성 주입)
    // 생성자
    public ProductDAOImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product){
        productRepository.save(product); // 기본 메서드 save(DB에 저장)
        return product;
    }

    @Override
    public Product getProduct(String productId){
        Product product = productRepository.getById(productId); // 기본 메서드 Id 기반으로 데이터를 가져옴
        return product;
    }
}
