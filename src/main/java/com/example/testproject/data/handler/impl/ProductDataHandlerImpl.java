package com.example.testproject.data.handler.impl;

import com.example.testproject.data.dao.ProductDAO;
import com.example.testproject.data.entity.Product;
import com.example.testproject.data.handler.ProductDataHandler;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductDataHandlerImpl implements ProductDataHandler {

    ProductDAO productDAO;

    @Autowired
    public ProductDataHandlerImpl(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    @Override
    public Product saveProductEntity(String productId, String productName, int productPrice, int productStock){
        Product product = new Product(productId, productName, productPrice, productStock);

        return productDAO.saveProduct(product);
    }

    @Override
    public Product getProductEntity(String productId){
        return productDAO.getProduct(productId);
    }
}
