package com.libraryManagement.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

public class SwaggerConfiguration {
	
	
	// properties for customized swagger UI
	@Bean
	public Docket swaggerLibraryApi() {
		return new Docket(DocumentationType.SWAGGER_2)   // docket use builder design pattern to create instance of docket
				.select()  // select method to get builder object
				.apis(RequestHandlerSelectors.basePackage("com.libraryManagement"))     
				.build();   // to get prepared docket object
				
	}
	
	
//	private ApiInfo getApiInfo() {
//		return new ApiInfo("library management APIs documentation",
//				"apis created using springboot", "1.0 version",
//				"termsOfServiceUrl",
//				new Contact("shilpa raghav", "www.wegile.com", "shilpa@wegile.com"),
//				"license",
//				"licenseUrl",
//				Collections.emptyList());
//	}

}
