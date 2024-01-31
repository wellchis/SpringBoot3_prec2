package com.example.testproject.controller;

import com.example.testproject.common.annotation.FieldAnnotation;
import com.example.testproject.common.annotation.MethodAnnotation;
import com.example.testproject.common.annotation.TypeAnnotation;
import com.example.testproject.common.valid.TempDto;
import jakarta.validation.Valid;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@TypeAnnotation(name = "Hello?", value = "World")
public class HelloController {
    @FieldAnnotation(name = "returnValue", value = "Bye World!")
    public String returnValue = "Hello World!";

    //LoggerFactory.getLogger(해당 클래스명.class);
    private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    @GetMapping("hello")
    public String hello(){
        return "Hello Around Hub Studio!";
    }

    @RequestMapping("/hello1")
    @MethodAnnotation(name = "Hello1",value = "World1")
    public String hello1() throws NoSuchMethodException{
        Method method = this.getClass().getMethod("hello1"); // reflect api 땡겨쓰는 // 자기 자신 가져오는
        Annotation[] annotations = method.getDeclaredAnnotations(); // 어노테이션 객체 배열들을 나열

        // 가져온 어노테이션을 for문으로 작업
        for(Annotation annotation : annotations){
            if(annotation instanceof MethodAnnotation) {
                MethodAnnotation methodAnnotation = (MethodAnnotation) annotation;
                return methodAnnotation.name() + ", " + methodAnnotation.value();
            }
        }
        return "Hello World!";
    }

    // Validation Check를 위해서는 @Valid 어노테이션을 꼭 추가해야한다.
    @RequestMapping("/hello2")
    public String hello2(@RequestBody @Valid TempDto dto){
        return "Valid value : " + dto.getValue();
    }

    @PostMapping("log-test")
    public void logTest(){

        LOGGER.trace("Trace Log");
        LOGGER.debug("Debug Log");
        LOGGER.info("Info Log");
        LOGGER.warn("Warn Log");
        LOGGER.error("Error Log");

    }


    // 예외 던져주는
    @PostMapping("/exception")
    public void exceptionTest() throws Exception {
        throw new Exception();
    }
/*
    // 예외 처리 Handler
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e){
        HttpHeaders responseHeaders = new HttpHeaders();
        // responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        LOGGER.info(e.getMessage());
        LOGGER.info("Controller 내 ExceptionHandler 호출");

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", "에러 발생");

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }
*/

}
