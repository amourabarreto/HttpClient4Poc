package com.httpclient.httpclient4poc.config;

import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;


public class FeignConfig {

    @Value("${user.credencialApiAvaliacao}")
    private String credencial;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("Accept", "application/json");
            requestTemplate.header("Authorization ", " Basic " +credencial);
        };
    }


}
