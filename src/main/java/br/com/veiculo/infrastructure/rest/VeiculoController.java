package br.com.veiculo.infrastructure.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.veiculo.application.command.AlterarVeiculoCommand;
import br.com.veiculo.application.command.IncluirVeiculoCommand;
import br.com.veiculo.application.converter.VeiculoConverter;
import br.com.veiculo.application.representation.VeiculoRepresentation;
import br.com.veiculo.application.service.VeiculoService;
import br.com.veiculo.domain.entity.Veiculo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Veiculos")
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "/v1" + "/veiculos",produces = MediaType.APPLICATION_JSON_VALUE)
public class VeiculoController {
	
	private final VeiculoService service;
	
	private final VeiculoConverter converter;
	
	

	@Operation(summary = "Busca todos os veículos")
	@GetMapping
	public List<VeiculoRepresentation> buscaTodos() {
		log.info("Buscando todos os veiculos ");
		final List<Veiculo> veiculos = service.buscaTodos();
		return converter.toCollectionRepresentation(veiculos);
	}
	
	@Operation(summary = "Busca veículo por ID")
	@GetMapping(value = "/{id-veiculo}")
	public VeiculoRepresentation buscaPorId(@Parameter(description = "Identificador do veiculo", example = "1") 
	                                        @PathVariable("id-veiculo") Long idVeiculo) {
		log.info("Buscando veiculo com ID: ",idVeiculo);
		
		final Veiculo veiculo = service.buscaOuFalha(idVeiculo);
		return converter.toRepresentation(veiculo);
	}
	
	
	@Operation(summary = "Cadastra um novo veiculo de entrega")
	@PostMapping(consumes  = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public VeiculoRepresentation incluiVeiculo(@RequestBody @Valid IncluirVeiculoCommand command) {
		log.info("Inserindo novo veiculo: ", command.getNome());
		final Veiculo novoVeiculo  = converter.toDomain(command);
		
		final Veiculo veiculoSalvo = service.salva(novoVeiculo);
		
		return converter.toRepresentation(veiculoSalvo);

	}
	
	@Operation(summary = "Altera um veiculo de entrega existente")
	@PutMapping(consumes  = MediaType.APPLICATION_JSON_VALUE)
	public VeiculoRepresentation alteraVeiculo(@RequestBody @Valid AlterarVeiculoCommand command) {
		log.info("Alterando veiculo existente: ", command.getId());
		final Veiculo veiculoExistente = service.buscaOuFalha(command.getId());
		
		converter.copyToDomainObject(command,veiculoExistente);
		
		final Veiculo veiculoAlterado = service.salva(veiculoExistente);
		
		return converter.toRepresentation(veiculoAlterado);

	}
	
	@DeleteMapping("/{id-veiculo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> removeVeiculo(@PathVariable("id-veiculo") Long idVeiculo) {
		service.excluir(idVeiculo);
		return ResponseEntity.noContent().build();
	}

}
