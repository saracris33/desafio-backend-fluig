package br.com.veiculo.application.representation;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GastoCombustivelRepresentation {
	

	private VeiculoResumoRepresentation veiculo;
	
	private Long quantidadeTotalGasto;
	
	private BigDecimal valorTotalGasto;


}
