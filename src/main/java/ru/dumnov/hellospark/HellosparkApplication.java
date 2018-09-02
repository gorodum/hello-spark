package ru.dumnov.hellospark;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class HellosparkApplication {

    public static void main(String[] args) {

        log.info("hello wolds");
        SpringApplication.run(HellosparkApplication.class, args);
    }
}
