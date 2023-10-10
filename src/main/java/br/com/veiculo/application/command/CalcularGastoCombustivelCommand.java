package br.com.veiculo.application.command;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name="Calcular gasto combustivel", description = "Representação de um calculo de gasto combustivel")
public class CalcularGastoCombustivelCommand {
	
	@NotNull
	private BigDecimal valorGasolina;
	
	@NotNull
	private Long kmPercursoCidade;
	
	@NotNull
	private Long kmPercursoRodovia;

}
