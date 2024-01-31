package com.example.testproject.config.env;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class DevConfiguration implements EnvConfiguration {

    private final Logger LOGGER = LoggerFactory.getLogger(DevConfiguration.class);
    @Value("${around.hub.loading.message}")
    private String message;

    @Override
    @Bean
    public String getMessage() {
        LOGGER.info("[getMessage] devConfiguration 입니다.");
        return message;
    }

}