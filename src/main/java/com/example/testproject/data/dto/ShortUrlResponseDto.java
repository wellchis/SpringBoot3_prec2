package com.example.testproject.data.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@RedisHash(value = "shortUrl", timeToLive = 60)
// value = 직렬화, 역직렬화 할 때 key 값에 prefix로 들어갈 수 있는 value 값 설정
// timeToLive = (초단위) 지나면 없애라
public class ShortUrlResponseDto implements Serializable {

    // ehcache 같은 것을 쓸 때는 직렬화가 필수임
    private static final long serialVersionUID = -611412290159054821L;

    // spring과 java 중 spring으로 설정
    @Id
    private String orgUrl;

    private String shortUrl;

}
