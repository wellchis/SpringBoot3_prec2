package com.example.testproject.data.handler;

import com.example.testproject.data.entity.Product;

public interface ProductDataHandler {

    Product saveProductEntity(String productId, String productName, int productPrice, int productStock);

    Product getProductEntity(String productId);

}
