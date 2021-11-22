package com.freshmarketer.catchhook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CatchhookApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatchhookApplication.class, args);
    }

}
