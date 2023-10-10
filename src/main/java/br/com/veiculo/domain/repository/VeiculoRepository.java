package br.com.veiculo.domain.repository;

import br.com.veiculo.domain.entity.Veiculo;

public interface VeiculoRepository extends Repository<Veiculo, Long> {
	
	public void remove(Veiculo veiculo);

}
