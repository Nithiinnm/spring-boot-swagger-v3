package com.seleniumexpress.curd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket docket() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.seleniumexpress.curd.controller"))
				.paths(PathSelectors.regex("/api/.*"))
				.build();
	}

	private ApiInfo apiInfo() {
	
		return new ApiInfoBuilder().description("Here you can get all the online Cousre details...")
				.license("www.OnlineTraining.com")
				.title("Course Details - API Documentation")
				.version("2.0")
				.build();
	}
}
