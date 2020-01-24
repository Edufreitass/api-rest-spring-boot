package com.produtos.apirest.config;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

// Classe de configuração do Swagger
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	// Método que irá retornar o tipo Docket, que é uma classe externa da aplicação.
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.produtos.apirest")) // pacote aonde estão todas as classes java
				.paths(regex("/api.*")) // mostra qual caminho a classe poderá acessar
				.build()
				.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo("Produtos API REST", // nome da api
				"API REST de cadastro de produtos", // descrição da api
				"1.0", // versão da api
				"Terms of Service", // termos de serviço da aplicação
				new Contact("Eduardo Freitas", "https://github.com/Edufreitass", // contato da pessoa que criou a api
						"edu_ar_dofreitas@hotmail.com"),
				"Apache License Version 2.0",
				"https://www.apache.org/licenses/", new ArrayList<VendorExtension>()
		);
		
		return apiInfo;
	}
	
}
