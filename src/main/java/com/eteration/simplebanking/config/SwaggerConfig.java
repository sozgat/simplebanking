package com.eteration.simplebanking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Simple Banking API")
                .description("API reference for developers")
                .contact(new Contact("Said Özgat","","said.ozgat(at)gmail.com")).version("1.0").build();
    }

}
