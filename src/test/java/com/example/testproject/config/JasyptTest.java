package com.example.testproject.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
@SpringBootTest(classes = {JasyptTest.class})
public class JasyptTest {

    @Test
    void encryptTest(){
        String url = "jdbc:mariadb://localhost:3306/around_hub_shop";
        String id = "flature";
        String password = "aroundhub12#";

        System.out.println(jasyptEncoding(url));
        System.out.println("---------------------------------------");
        System.out.println(jasyptEncoding(id));
        System.out.println("---------------------------------------");
        System.out.println(jasyptEncoding(password));
    }

    public String jasyptEncoding(String value){
        String key = "around_hub_studio";
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword(key);
        return pbeEnc.encrypt(value);
    }

}
