package br.com.veiculo.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	
	@Bean
    OpenAPI infoOpenAPI() {
	    return new OpenAPI()
	    	.info(new Info().title("API Veiculos")
	    	.description("Rest API de cadastro de veiculos para previsão de gasto com combustivel.")
	    	.version("v1"));
	}

}
