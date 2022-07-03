package com.capitole.testjava.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket postsApi() {
	return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
		.paths(Predicates.not(PathSelectors.regex("/error.*"))).build();
    }

    private ApiInfo apiInfo() {
	return new ApiInfoBuilder().title("Test Java - PRICE").description(
		"Microservicio que expone 2 Endpoints para la consulta de precios según fecha de aplicación, producto y brand..")
		.termsOfServiceUrl("http://localhost:8080/").contact("guillermo.pantanetti@hotmail.com")
		.license("Capitole Consulting").licenseUrl("guillermo.pantanetti@hotmail.com").version("1.0").build();
    }

}
