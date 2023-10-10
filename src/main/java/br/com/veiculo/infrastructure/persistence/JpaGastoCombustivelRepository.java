package br.com.veiculo.infrastructure.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.veiculo.domain.entity.GastoCombustivel;
import br.com.veiculo.domain.repository.GastoCombustivelRepository;
import br.com.veiculo.infrastructure.exception.GastoCombustivelNaoEncontradoException;
import br.com.veiculo.infrastructure.persistence.springdata.SpringGastoCombustivelRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class JpaGastoCombustivelRepository implements GastoCombustivelRepository {
	
	private SpringGastoCombustivelRepository springRepository;

	@Override
	public GastoCombustivel adiciona(GastoCombustivel gasto) {
		return this.springRepository.save(gasto);
	}

	@Override
	public GastoCombustivel buscaOuFalha(Long id) {
		return this.springRepository.findById(id)
				.orElseThrow(() -> new GastoCombustivelNaoEncontradoException("ID", id));
	}

	@Override
	public List<GastoCombustivel> buscaTodos() {
		return this.springRepository.buscaTodosEmOrdemCrescentePorValorCombustivel();
	}

}
