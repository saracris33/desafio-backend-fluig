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
@Schema(name="Alterar Veiculo", description = "Representação de uma alteração de veiculo")
public class AlterarVeiculoCommand {
	
	@Schema(description = "Informe o identificador", example = "1")
	@NotNull
	private Long id;
	
	@Schema(description = "Nome do Veículo", example = "Hyundai HB20")
	@NotBlank
	private String nome;
	
	@Schema(description = "Informe a marca do Veículo", example = "Hyundai")
	@NotBlank
	private String marca;
	
	@Schema(description = "Informe o modelo do Veículo", example = "HB20")
	@NotBlank
	private String modelo;
	
	@NotNull
	@PastOrPresent
	private LocalDate dataFabricacao;
	
	@Schema(description = "Informe o consumo médio na cidade (KM/L)", example = "11.5")
    @NotNull
    @PositiveOrZero
	private BigDecimal consumoCidade;
	
	@Schema(description = "Informe o consumo médio na rodovia (KM/L)", example = "13")
	@NotNull
	@PositiveOrZero
	private BigDecimal consumoRodovia;

}
