package com.example.testproject.service.impl;

import static org.mockito.Mockito.verify;

import com.example.testproject.data.dto.ProductDto;
import com.example.testproject.data.entity.Product;
import com.example.testproject.data.handler.impl.ProductDataHandlerImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// 매개변수가 없으면 전체 Bean을 로드
//@SpringBootTest(classes = {ProductDataHandlerImpl.class, ProductServiceImpl.class})

// 좀 더 하위의 어노테이션(ExtendWith)
@ExtendWith(SpringExtension.class)
@Import({ProductDataHandlerImpl.class, ProductServiceImpl.class})
public class ProductServiceImplTest {

    // 구현체 생성
    @MockBean
    ProductDataHandlerImpl productDataHandler;

    // 객체 주입
    @Autowired
    ProductServiceImpl productService;

    @Test
    @DisplayName("get 테스트")
    public void getProductTest(){
        // given
        Mockito.when(productDataHandler.getProductEntity("123"))
                .thenReturn(new Product("123", "pen", 2000, 3000));

        ProductDto productDto = productService.getProduct("123");

        Assertions.assertEquals(productDto.getProductId(), "123"); // Assertions.assertEquals 값이 같은지 체크
        Assertions.assertEquals(productDto.getProductName(),"pen");
        Assertions.assertEquals(productDto.getProductPrice(),2000);
        Assertions.assertEquals(productDto.getProductStock(),3000);

        // verify
        verify(productDataHandler).getProductEntity("123");
    }

    @Test
    @DisplayName("save 테스트")
    public void saveProductTest(){
        Mockito.when(productDataHandler.saveProductEntity("123", "pen", 2000, 3000))
                .thenReturn(new Product("123", "pen", 2000, 3000));

        ProductDto productDto = productService.saveProduct("123", "pen", 2000, 3000);

        Assertions.assertEquals(productDto.getProductId(),"123");
        Assertions.assertEquals(productDto.getProductName(),"pen");
        Assertions.assertEquals(productDto.getProductPrice(),2000);
        Assertions.assertEquals(productDto.getProductStock(),3000);

        verify(productDataHandler).saveProductEntity("123","pen", 2000, 3000);
    }


}
