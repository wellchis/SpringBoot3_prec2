package com.example.testproject.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// Controller단에서 발생하는 예외를 모두 처리해주겠다.
@RestControllerAdvice
public class AroundHubExceptionHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(AroundHubExceptionHandler.class);

    // 예외 처리 Handler
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e){
        HttpHeaders responseHeaders = new HttpHeaders();
        // responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        LOGGER.info("Advice 내 ExceptionHandler 호출");

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", "에러 발생");

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }

    @ExceptionHandler(value = AroundHubException.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(AroundHubException e){
        HttpHeaders responseHeader = new HttpHeaders();

        Map<String, String> map = new HashMap<>();
        map.put("error type", e.getHttpStatusType());
        map.put("error code", Integer.toString(e.getHttpStatusCode())); // e.getHttpStatusCode()가 int 타입이어서 자료형 변환 필요
        map.put("message", e.getMessage());

        return new ResponseEntity<>(map, responseHeader, e.getHttpStatus());
    }
}
