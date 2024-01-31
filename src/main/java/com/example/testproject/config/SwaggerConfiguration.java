package com.example.testproject.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Flature
 * @version 1.0.0
 */

// Spring Boot 3 버전부터는 Springfox Swagger를 이용할 수 없음
// Spring Boot 3 용
@OpenAPIDefinition(
        info = @Info(title = "Around Hub Open API Test with Swagger",
                description = "설명 부분",
                version = "1.0.0"))
@RequiredArgsConstructor

@Configuration
// @EnableSwagger2
public class SwaggerConfiguration {

//    private static final String API_NAME = "Programmers Spring Boot Application";
//    private static final String API_VERSION = "1.0.0";
//    private static final String API_DESCRIPTION = "프로그래머스 스프링부트 애플리케이션입니다.";

    // springfox
    // Docket이라는 객체를 반환하는 메서드를 만드는

    /*@Bean
    public Docket api() {
        Parameter parameterBuilder = (Parameter) new ParameterBuilder()
            .name(HttpHeaders.AUTHORIZATION)
            .description("Access Tocken")
            .modelRef(new ModelRef("string"))
            .parameterType("header")
            .required(false)
            .build();

        List<Parameter> globalParameters = new ArrayList<>();
        globalParameters.add(parameterBuilder);

        return new Docket(DocumentationType.SWAGGER_2)
            .globalOperationParameters(globalParameters)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.example.testproject"))
            .paths(PathSelectors.any())
            .build();

        *//*
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.testproject")) // 스캔 범위를 설정(루트 패키지)
                .paths(PathSelectors.any())
                .build();
        *//*
    }*/

    /*private ApiInfo apiInfo() {
        return new ApiInfoBuilder() // ApiInfo()도 있는데, 안에 파라미터 사용할 것만 쓰려면 이게 더 낫다
                .title(API_NAME)
                .version(API_VERSION)
                .description(API_DESCRIPTION)
                .build();
    }*/


    // spring docs
    @Bean
    public GroupedOpenApi SampleOpenApi(){
        String[] paths = {"/**"};

        return GroupedOpenApi.builder()
                .group("Sample 1.0.0")
                .pathsToMatch(paths)
                .build();
    }



}
