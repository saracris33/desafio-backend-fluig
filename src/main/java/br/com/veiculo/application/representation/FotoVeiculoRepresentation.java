package br.com.veiculo.application.representation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FotoVeiculoRepresentation {
	
	private Long idVeiculo;
	private String contentType;
	private String imagemBase64;

}
