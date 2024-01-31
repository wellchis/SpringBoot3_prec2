package com.example.testproject.data.repository;

import com.example.testproject.data.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {

    // void findBy처럼 작성할 수도 있다.
    ShortUrl findByUrl(String url);

    ShortUrl findByOrgUrl(String originalUrl);

}
