package com.example.testproject.test;

import org.junit.jupiter.api.*;

public class TestLifeCycle {

    @BeforeAll // 테스트 시작 전
    static void beforeAll(){
        System.out.println("## BeforeAll Annotation 호출 ##");
        System.out.println();
    }

    @AfterAll // 테스트 종료 후
    static void afterAll(){
        System.out.println("## AfterAll Annotation 호출 ##");
        System.out.println();
    }

    @BeforeEach // 테스트 메소드 시작 전마다
    void beforeEach(){
        System.out.println("## BeforeEach Annotation 호출 ##");
        System.out.println();
    }

    @AfterEach // 테스트 메소드 종료 후마다
    void afterEach(){
        System.out.println("## afterEach Annotation 호출 ##");
        System.out.println();
    }

    @Test
    void test1(){
        System.out.println("## test1 시작 ##");
        System.out.println();
    }

    @Test
    @DisplayName("Test Case 2!!!")
    void test2(){
        System.out.println("## test2 시작 ##");
        System.out.println();
    }

    @Test
    @Disabled // Disabled Annotation : 테스트를 실행하지 않게 설정하는 어노테이션
    void test3(){
        System.out.println("## test3 시작 ##");
        System.out.println();
    }
}
