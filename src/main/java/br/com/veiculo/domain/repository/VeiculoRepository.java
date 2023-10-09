package br.com.veiculo.domain.repository;

import java.util.List;

import br.com.veiculo.domain.entity.Veiculo;

public interface VeiculoRepository extends Repository<Veiculo, Long> {
	
	public List<Veiculo> buscaTodos();

}
