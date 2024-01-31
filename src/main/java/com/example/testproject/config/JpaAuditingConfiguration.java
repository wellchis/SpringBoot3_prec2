package com.example.testproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing // 이 어노테이션을 사용해야 JPA Auditing 기능을 사용할 수 있다.
public class JpaAuditingConfiguration {

}
