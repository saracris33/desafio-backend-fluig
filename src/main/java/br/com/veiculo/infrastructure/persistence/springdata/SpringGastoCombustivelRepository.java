package br.com.veiculo.infrastructure.persistence.springdata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.veiculo.domain.entity.GastoCombustivel;

public interface SpringGastoCombustivelRepository extends JpaRepository<GastoCombustivel, Long> {

	@Query(" from GastoCombustivel g "
		  +" join fetch g.veiculo "
		  +" order by g.valorTotalGasto ASC ")
	public List<GastoCombustivel> buscaTodosEmOrdemCrescentePorValorCombustivel();
}
