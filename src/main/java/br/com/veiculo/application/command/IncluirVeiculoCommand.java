package br.com.veiculo.application.command;

import java.math.BigDecimal;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name="Incluir Veiculo", description = "Representação de uma inclusão de veiculo")
public class IncluirVeiculoCommand {
	
	@Schema(description = "Nome do Veículo", example = "Honda HRV")
	@NotBlank
	private String nome;
	
	@Schema(description = "Informe a marca do Veículo", example = "Honda")
	@NotBlank
	private String marca;
	
	@Schema(description = "Informe o modelo do Veículo", example = "HRV")
	@NotBlank
	private String modelo;

	@NotNull
	@PastOrPresent
	private LocalDate dataFabricacao;
	
	@Schema(description = "Informe o consumo médio na cidade (KM/L)", example = "9.2")
    @NotNull
    @PositiveOrZero
	private BigDecimal consumoCidade;
	
	@Schema(description = "Informe o consumo médio na rodovia (KM/L)", example = "10.9")
	@NotNull
	@PositiveOrZero
	private BigDecimal consumoRodovia;

}
