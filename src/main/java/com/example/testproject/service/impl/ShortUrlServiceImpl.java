package com.example.testproject.service.impl;

import com.example.testproject.data.dao.ShortUrlDAO;
import com.example.testproject.data.dto.NaverUriDto;
import com.example.testproject.data.dto.ShortUrlResponseDto;
import com.example.testproject.data.entity.ShortUrl;
import com.example.testproject.data.repository.ShortUrlRedisRepository;
import com.example.testproject.service.ShortUrlService;
import java.net.URI;
import java.util.Arrays;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ShortUrlServiceImpl implements ShortUrlService {

    private final Logger LOGGER = LoggerFactory.getLogger(ShortUrlServiceImpl.class);
    private final ShortUrlDAO shortUrlDAO;
    // Cahce 객체 생성
    private final ShortUrlRedisRepository shortUrlRedisRepository;

    @Autowired
    public ShortUrlServiceImpl(ShortUrlDAO shortUrlDAO, ShortUrlRedisRepository shortUrlRedisRepository) {
        this.shortUrlDAO = shortUrlDAO;
        this.shortUrlRedisRepository = shortUrlRedisRepository; // 객체 주입
    }

    @Override
    public ShortUrlResponseDto getShortUrl(String clientId, String clientSecret,
        String originalUrl) {

        LOGGER.info("[getShortUrl] request data : {}", originalUrl);

        // Cache Logic - Search
        // Cache가 있으면 뒤에 로직 없이 구현 가능
        Optional<ShortUrlResponseDto> foundResponseDto = shortUrlRedisRepository.findById(originalUrl);
        if(foundResponseDto.isPresent()){
            LOGGER.info("[getShortUrl] Cache Data is existed.");
            return foundResponseDto.get();
        } else {
            LOGGER.info("[getShortUrl] Cache Data does not exist");
        }

        ShortUrl getShortUrl = shortUrlDAO.getShortUrl(originalUrl);

        String orgUrl;
        String shortUrl;

        if (getShortUrl == null) {
            LOGGER.info("[getShortUrl] No Entity in Database. ");
            // 메소드 명에 맞게 코드를 짜는 것이 좋음
            // 지금 코드는 generateShortUrl()과 겹치는 부분이 있음(중복되는 코드가 없는게 좋은 코드)
            ResponseEntity<NaverUriDto> responseEntity = requestShortUrl(clientId, clientSecret,
                originalUrl);

            orgUrl = responseEntity.getBody().getResult().getOrgUrl();
            shortUrl = responseEntity.getBody().getResult().getUrl();
            String hash = responseEntity.getBody().getResult().getHash();

            ShortUrl shortUrlEntity = new ShortUrl();
            shortUrlEntity.setOrgUrl(orgUrl);
            shortUrlEntity.setUrl(shortUrl);
            shortUrlEntity.setHash(hash);

            shortUrlDAO.saveShortUrl(shortUrlEntity);

        } else {
            orgUrl = getShortUrl.getOrgUrl();
            shortUrl = getShortUrl.getUrl();
        }

        ShortUrlResponseDto shortUrlResponseDto = new ShortUrlResponseDto(orgUrl, shortUrl);

        // Cache Logic - Save
        shortUrlRedisRepository.save(shortUrlResponseDto);

        LOGGER.info("[generateShortUrl] Response DTO : {}", shortUrlResponseDto);
        return shortUrlResponseDto;
    }

    @Override
    public ShortUrlResponseDto generateShortUrl(String clientId, String clientSecret,
        String originalUrl) {

        // URL이 어떤 값으로 들어왔는지
        LOGGER.info("[generateShortUrl] request data : {}", originalUrl);

        if (originalUrl.contains("me2.do")) {
            throw new RuntimeException();
        }

        ResponseEntity<NaverUriDto> responseEntity = requestShortUrl(clientId, clientSecret,
            originalUrl);

        // requestShortUrl로 반환 받은 ResponseEntity<NaverUriDto>를 String 객체에 담아서
        String orgUrl = responseEntity.getBody().getResult().getOrgUrl();
        String shortUrl = responseEntity.getBody().getResult().getUrl();
        String hash = responseEntity.getBody().getResult().getHash();

        // Entity에 set
        ShortUrl shortUrlEntity = new ShortUrl();
        shortUrlEntity.setOrgUrl(orgUrl);
        shortUrlEntity.setUrl(shortUrl);
        shortUrlEntity.setHash(hash);

        shortUrlDAO.saveShortUrl(shortUrlEntity);

        ShortUrlResponseDto shortUrlResponseDto = new ShortUrlResponseDto(orgUrl, shortUrl);

        // Cache Logic - Cache Save
        shortUrlRedisRepository.save(shortUrlResponseDto);

        LOGGER.info("[generateShortUrl] Response DTO : {}", shortUrlResponseDto.toString());
        return shortUrlResponseDto;
    }

    @Override
    public ShortUrlResponseDto updateShortUrl(String clientId, String clientSecret,
        String originalUrl) {
        return null;
    }

    // delete 전처리
    @Override
    public void deleteShortUrl(String url) {
        if (url.contains("me2.do")) {
            LOGGER.info("[deleteShortUrl] Request Url is 'ShortUrl'.");
            deleteByShortUrl(url);
        } else {
            LOGGER.info("[deleteShortUrl] Request Url is 'OriginalUrl'.");
            deleteByOriginalUrl(url);
        }
    }

    private void deleteByShortUrl(String url) {
        LOGGER.info("[deleteByShortUrl] delete record");
        shortUrlDAO.deleteByShortUrl(url);
    }

    private void deleteByOriginalUrl(String url) {
        LOGGER.info("[deleteByOriginalUrl] delete record");
        shortUrlDAO.deleteByOriginalUrl(url);
    }

    private ResponseEntity<NaverUriDto> requestShortUrl(String clientId, String clientSecret,
        String originalUrl) {
        // log에 남기면 안 되는 내용 ***로 처리
        LOGGER.info("[requestShortUrl] client ID : ***, client Secret : ***, original URL : {}",
            originalUrl);

        URI uri = UriComponentsBuilder
            .fromUriString("https://openapi.naver.com") // 주소
            .path("/v1/util/shorturl") // 세부주소
            .queryParam("url", originalUrl)
            .encode()
            .build()
            .toUri();

        LOGGER.info("[requestShortUrl] set HTTP Request Header");
        // 헤더 세팅
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Naver-Client-id", clientId);
        headers.set("X-Naver-Client-Secret", clientSecret);

        // body와 header 조합해주는
        HttpEntity<String> entity = new HttpEntity<>("", headers);

        // RestTemplate 초기화
        RestTemplate restTemplate = new RestTemplate();

        LOGGER.info("[requestShortUrl] request by restTemplate");
        // exchage 메소드로 요청 exchange(uri, RESTful 형태, HttpEntity, return Object)
        ResponseEntity<NaverUriDto> responseEntity = restTemplate.exchange(uri, HttpMethod.GET,
            entity, NaverUriDto.class);

        LOGGER.info("[requestShortUrl] request has been successfully complete.");

        return responseEntity;
    }

}
