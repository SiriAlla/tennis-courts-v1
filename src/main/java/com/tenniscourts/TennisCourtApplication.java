package com.tenniscourts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The type Tennis court application.
 */
@SpringBootApplication
@EnableJpaAuditing
@EnableSwagger2
public class TennisCourtApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(TennisCourtApplication.class, args);
    }

}