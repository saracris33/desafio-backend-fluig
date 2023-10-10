package br.com.veiculo.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.veiculo.application.command.CalcularGastoCombustivelCommand;
import br.com.veiculo.domain.entity.GastoCombustivel;
import br.com.veiculo.domain.entity.Veiculo;
import br.com.veiculo.domain.repository.GastoCombustivelRepository;
import br.com.veiculo.infrastructure.exception.VeiculoNaoEncontradoException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class GastoCombustivelService {
	
	
	private final GastoCombustivelRepository repository;
	
	private final VeiculoService serviceVeiculo;
	
	private List<GastoCombustivel> buscaTodos() {
		return repository.buscaTodos();
	}
	
	
	@Transactional
	private GastoCombustivel salva(GastoCombustivel gasto) {
		log.info("Salvando novo gasto");
		final GastoCombustivel gastoSalvo = repository.adiciona(gasto);
		return gastoSalvo;
	}
	
	public List<GastoCombustivel> obtemListaRanqueada(final CalcularGastoCombustivelCommand command) {
		final List<Veiculo> veiculos = serviceVeiculo.buscaTodos();
		if(veiculos.isEmpty()) {
			throw  new VeiculoNaoEncontradoException("Não existe veiculo cadastrado!");
		}

		for(Veiculo veiculo: veiculos) {
			GastoCombustivel gasto = new GastoCombustivel();
			gasto.setVeiculo(veiculo);
			gasto.setKmPercursoCidade(command.getKmPercursoCidade());
			gasto.setKmPercursoRodovia(command.getKmPercursoRodovia());
            gasto.setValorGasolina(command.getValorGasolina());
            gasto.calculaValorTotalGasto();
            this.salva(gasto);
		}
		
		final List<GastoCombustivel> gastos = this.buscaTodos();
		return gastos;
	}
	

}
