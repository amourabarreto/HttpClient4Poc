package com.httpclient.httpclient4poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HttpClient4PocApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttpClient4PocApplication.class, args);
    }

}
