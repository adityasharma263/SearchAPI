package com.needle.innovizsion.searchapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.needle.innovizsion.searchapi.*"})
public class SearchapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchapiApplication.class, args);
    }

}
