package com.example.testproject.data.repository;

import com.example.testproject.data.dto.ShortUrlResponseDto;
import org.springframework.data.repository.CrudRepository;

public interface ShortUrlRedisRepository extends CrudRepository<ShortUrlResponseDto, String> {

}
