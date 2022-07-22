package com.myhotel.userservice.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("user-service")
                .select().apis(RequestHandlerSelectors.basePackage("com.myhotel.userservice"))
                .paths(PathSelectors.any())
                .build().apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder().title("USER Service")
                .description("Sample Documentation Generated For User Services Using SWAGGER2 for our Book Rest API")
                .termsOfServiceUrl("https://www.google.com")
                .license("Java License")
                .licenseUrl("https://www.google.com")
                .contact(new Contact("Debalina", "www.debalina.com", "debalina@gmail.com"))
                .version("1.0").build();
    }
}
