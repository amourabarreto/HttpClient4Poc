package com.httpclient.httpclient4poc.config;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpConfig {

    @Value("${user.credencialApiAvaliacao}")
    private String credencial;

    @Bean
    public HttpPost httpPost(){
        HttpPost httpPost = new HttpPost();
        httpPost.addHeader(HttpHeaders.AUTHORIZATION,"Basic "+credencial);
        httpPost.addHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
       return httpPost;
    }
}
