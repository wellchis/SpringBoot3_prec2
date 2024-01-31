package com.example.testproject.controller;

import com.example.testproject.data.dto.MemberDTO;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Rest한 Controller를 만들겠다는 것을 알려주는 어노테이션
@RestController
// 공통되는 URL
@RequestMapping("/api/v1/get-api")
public class GetController {

    // RequestMapping
    // http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello(){
        return "Hello World";
    }

    // GetMapping
    // http://localhost:8080/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName(){
        System.out.println("getName 실행되었습니다.");
        return "Flature";
    }

    // GetMapping에 작성된 {variable}과 Parameter의 variable이 일치해야 함
    // http://localhost:8080/api/v1/get-api/variablae1/{String 값}
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }

    // 동일하지 않을 때
    // http://localhost:8080/api/v1/get-api/variable1/{Stirng 값}
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    // 여러 값을 받을 때
    // http://localhost:8080/api/v1/get-api/request1?
    // name=Flature&
    // email=thinkground.flature@gmail.com&
    // organization=thinkground
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    // 정해지지 않은 경우
    // http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
            //sb.append(map.getKey()).append(" : ").append(map.getValue()).append("\n");
        });

        return sb.toString();
    }

    // 값을 모르는 경우
    // http://localhost:8080/api/v1/get-api/request3?name=flature&email=thinkground@gmail.com&organization=thinkground
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDTO memberDTO){
        //return memberDTO.getName() + " " + memberDTO.getEmail() + " " + memberDTO.getOrganization()
        return memberDTO.toString();
    }
}
