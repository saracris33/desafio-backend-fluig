package br.com.veiculo.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.veiculo.domain.entity.GastoCombustivel;
import br.com.veiculo.domain.repository.GastoCombustivelRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class GastoCombustivelService {
	
	
	private final GastoCombustivelRepository repository;
	
	public List<GastoCombustivel> buscaTodos() {
		return repository.buscaTodos();
	}
	
	
	@Transactional
	public GastoCombustivel salva(final GastoCombustivel gasto) {
		log.info("Salvando novo gasto");
		final GastoCombustivel gastoSalvo = repository.adiciona(gasto);
		return gastoSalvo;
	}

}
