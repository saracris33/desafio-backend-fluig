package br.com.veiculo.infrastructure.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class VeiculoApiTest {
	
	
	@GetMapping("/test")
	public String bemVindo() {
		return String.format("Bem vindo ao cadastro de veiculos!");
	}

}
