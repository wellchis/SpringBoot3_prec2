plugins {
    java
    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.0" // 버전 관리 해주는 플러그인
    id("io.freefair.lombok") version "8.4"
}

group = "com.example"
version = "1.0.0"
description = "testproject"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    // implementation("org.springframework.boot:spring-boot-starter-jdbc:3.2.1")
    implementation("org.springframework.boot:spring-boot-configuration-processor")
    implementation("io.spring.gradle:dependency-management-plugin:1.1.0")

    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")

    implementation("com.google.code.gson:gson:2.10.1") // 서드파티
    implementation("com.github.ulisesbocchio:jasypt-spring-boot-starter:3.0.5")

    implementation("org.mariadb.jdbc:mariadb-java-client")
    // implementation("org.projectlombok:lombok:1.18.24")

    testImplementation ("org.springframework.boot:spring-boot-starter-test")

}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

// 테스트용
tasks.test {
    useJUnitPlatform()
    // systemProperties["spring.profiles.active"] = "test"
}



