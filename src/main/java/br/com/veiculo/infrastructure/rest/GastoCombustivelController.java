package br.com.veiculo.infrastructure.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.veiculo.application.command.CalcularGastoCombustivelCommand;
import br.com.veiculo.application.converter.GastoCombustivelConverter;
import br.com.veiculo.application.representation.GastoCombustivelRepresentation;
import br.com.veiculo.application.service.GastoCombustivelService;
import br.com.veiculo.application.service.VeiculoService;
import br.com.veiculo.domain.entity.GastoCombustivel;
import br.com.veiculo.domain.entity.Veiculo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Gasto combustível")
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "/v1" + "/gastos-combustivel",produces = MediaType.APPLICATION_JSON_VALUE)
public class GastoCombustivelController {
	
	private final GastoCombustivelService service;
	
	private final VeiculoService serviceVeiculo;
	
	private final GastoCombustivelConverter converter;
	
	
	@Operation(summary = "Calcula gasto combustivel de todos os veiculos de entrega")
	@PostMapping(consumes  = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public List<GastoCombustivelRepresentation> calculaGasto(@RequestBody @Valid CalcularGastoCombustivelCommand command) {
		log.info("Calculando gasto combustivel");
		final List<Veiculo> veiculos = serviceVeiculo.buscaTodos();
	
		for(Veiculo veiculo: veiculos) {
			GastoCombustivel gasto = new GastoCombustivel();
			gasto.setVeiculo(veiculo);
			gasto.setKmPercursoCidade(command.getKmPercursoCidade());
			gasto.setKmPercursoRodovia(command.getKmPercursoRodovia());
            gasto.setValorGasolina(command.getValorGasolina());
            gasto.calculaValorTotalGasto();
            service.salva(gasto);
		}
		final List<GastoCombustivel> gastos = service.buscaTodos();
		
		
		return converter.toCollectionRepresentation(gastos);

	}
	
	

}
