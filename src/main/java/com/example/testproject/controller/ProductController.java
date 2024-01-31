package com.example.testproject.controller;

import com.example.testproject.common.Constants;
import com.example.testproject.common.exception.AroundHubException;
import com.example.testproject.data.dto.ProductDto;
import com.example.testproject.service.ProductService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class); // log 설정
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // http://localhost:8080/api/v1/product-api/product/{productId}
    @GetMapping(value = "/product/{productId}")
    public ProductDto getProduct(@PathVariable String productId) {

        long startTime = System.currentTimeMillis();
        LOGGER.info("[ProductController] perform {} of Around Hub API.", "getProduct");

        ProductDto productDto = productService.getProduct(productId);

        LOGGER.info(
            "[ProductController] Response :: productId = {}, productName = {}, productPrice = {}, productStock={}, Response Time = {}ms",
            productDto.getProductId(), productDto.getProductName(), productDto.getProductPrice(),
            productDto.getProductStock(), (System.currentTimeMillis() - startTime));

        return productDto;
    }

    // http://localhost:8080/api/v1/product-api/product
    @PostMapping(value = "/product")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {

        // 직접 작성
        // Validation Code Example
        /*
        if (productDto.getProductId().equals("") || productDto.getProductId().isEmpty()){
            LOGGER.error("[createProduct] failed Response :: productId is Empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(productDto);
        }
        */
        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        ProductDto response = productService.saveProduct(productId, productName, productPrice,
            productStock);

        LOGGER.info(
            "[createProduct] Response >> productId : {}, productName : {}, productPrice : {}, productStock : {}",
            response.getProductId(), response.getProductName(), response.getProductPrice(),
            response.getProductStock()
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // http://localhost:8080/api/v1/product-api/product/{productId}
    @DeleteMapping(value = "/product/{productId}")
    public ProductDto deleteProduct(@PathVariable String productId) {
        return null;
    }

    @PostMapping(value = "/product/exception")
    public void exceptionTest() throws AroundHubException {
        // throw new AroundHubException(Constants.ExceptionClass.PRODUCT, HttpStatus.BAD_REQUEST, "의도된 에러가 발생했습니다.");
        throw new AroundHubException(Constants.ExceptionClass.PRODUCT, HttpStatus.FORBIDDEN,
            "접근이 금지되었습니다.");
    }

}
