package br.com.veiculo.application.command;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name="Calcular gasto combustivel", description = "Representação de um calculo de gasto combustivel")
public class CalcularGastoCombustivelCommand {
	
	@NotNull
	@Positive
	private BigDecimal valorGasolina;
	
	@NotNull
	@PositiveOrZero
	private Long kmPercursoCidade;
	
	@NotNull
	@PositiveOrZero
	private Long kmPercursoRodovia;

}
