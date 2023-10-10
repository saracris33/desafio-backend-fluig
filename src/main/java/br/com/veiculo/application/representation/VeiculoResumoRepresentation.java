package br.com.veiculo.application.representation;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoResumoRepresentation {
	
	private String nome;
	private String marca;
	private String modelo;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
	private LocalDate dataFabricacao;

}
