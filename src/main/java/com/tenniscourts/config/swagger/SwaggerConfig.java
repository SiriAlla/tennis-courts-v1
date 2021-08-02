package com.tenniscourts.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;


/**
 * The type Swagger config.
 */
@Configuration
public class SwaggerConfig {

    /**
     * Product api docket.
     *
     * @return the docket
     */
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.tenniscourts"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * Api info api info.
     *
     * @return the api info
     */
    @Bean
    ApiInfo apiInfo()
    {
        return new ApiInfo("Tennis Courts - Challenge",
                "Tennis Courts - Challenge",
                "1.0.0",
                "http://localhost:8080/swagger-ui.html",
                new Contact("Guest Developer",
                        "http://localhost:8080/swagger-ui.html",
                        "rafaelldanieli@gmail.com"),
                "The Apache Software License, Version 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0.txt",
                Collections.EMPTY_LIST
        );
    }
}
