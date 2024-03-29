package com.example.testproject.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * GitHub : https://github.com/ulisesbocchio/jasypt-spring-boot
 */
@Configuration
public class JasyptConfig {

    // Bean - Spring Container에 객체 등록할 때 사용
    @Bean(name = "jasyptStringEncryptor")
    public StringEncryptor stringEncryptor(){
        String password = "around_hub_studio"; // 패스워드 값
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();

        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(password); // 암호화할 때 사용하는 키
        config.setAlgorithm("PBEWithMD5AndDES"); // 암호화 알고리즘
        config.setKeyObtentionIterations("1000"); // 반복할 해싱 횟수
        config.setPoolSize("1"); // 인스턴스 pool
        // config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator"); // salt 생성 클래스
        // config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGanerator");
        config.setStringOutputType("base64"); // 인코딩 방식

        encryptor.setConfig(config);
        return encryptor;
    }

}
