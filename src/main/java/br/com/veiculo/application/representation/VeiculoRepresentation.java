package br.com.veiculo.application.representation;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoRepresentation {
	
	private Long id;
	private String nome;
	private String marca;
	private String modelo;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataFabricacao;
	private BigDecimal consumoCidade;
	private BigDecimal consumoRodovia;

}
