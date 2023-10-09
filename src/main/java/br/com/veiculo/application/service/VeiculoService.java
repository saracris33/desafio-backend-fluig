package br.com.veiculo.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.veiculo.domain.entity.Veiculo;
import br.com.veiculo.domain.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class VeiculoService {
	
	private final VeiculoRepository repository;
	
	
	public List<Veiculo> buscaTodos() {
		return repository.buscaTodos();
	}
	
	public Veiculo buscaPorId(final Long idVeiculo) {
		return repository.buscaOuFalha(idVeiculo);
	}
	
	public Veiculo salva(final Veiculo veiculo) {
		log.info("Salvando novo veiculo validado");
		Veiculo veiculoSalvo = repository.adiciona(veiculo);
		return veiculoSalvo;
	}
	
}
