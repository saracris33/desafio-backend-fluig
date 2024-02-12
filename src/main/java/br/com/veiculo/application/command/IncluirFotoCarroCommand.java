package br.com.veiculo.application.command;

import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name="Incluir Foto Veiculo", description = "Representação de uma inclusão da foto de um veiculo")
public class IncluirFotoCarroCommand {
	
	private MultipartFile arquivo;
	private String descricao;

}
