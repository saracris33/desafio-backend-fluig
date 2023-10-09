package br.com.veiculo.infrastructure.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
	
	@Bean
    ModelMapper modelMapper() {
		var modelMapper = new ModelMapper();
		 
		return modelMapper;
	}

}
