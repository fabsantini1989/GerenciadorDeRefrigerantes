package com.fabsantini.stockrefri.config;
import com.fabsantini.stockrefri.dto.RefriDTO;
import com.fabsantini.stockrefri.dto.QuantityDTO;
import com.fabsantini.stockrefri.exception.RefriAlreadyRegisteredException;
import com.fabsantini.stockrefri.exception.RefriNotFoundException;
import com.fabsantini.stockrefri.exception.RefriStockExceededException;
import io.swagger.annotations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.Valid;
import java.util.List;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String BASE_PACKAGE = "com.fabsantini.stockrefri.controller";
    private static final String API_TITLE = "Refri Stock API";
    private static final String API_DESCRIPTION = "REST API for refri stock management";
    private static final String CONTACT_NAME = "Fabiano Santini";
    private static final String CONTACT_GITHUB = "https://gtihub.com/fabsantini1989";
    private static final String CONTACT_EMAIL = "fabsantini@live.com";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(buildApiInfo());
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title(API_TITLE)
                .description(API_DESCRIPTION)
                .version("1.0.0")
                .contact(new Contact(CONTACT_NAME, CONTACT_GITHUB, CONTACT_EMAIL))
                .build();
    }
}
