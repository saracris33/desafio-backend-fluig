package br.com.veiculo.infrastructure.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.veiculo.domain.entity.Veiculo;
import br.com.veiculo.domain.repository.VeiculoRepository;
import br.com.veiculo.infrastructure.exception.VeiculoNaoEncontradoException;
import br.com.veiculo.infrastructure.persistence.springdata.SpringVeiculoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class JpaVeiculoRepository implements VeiculoRepository {
	
	private SpringVeiculoRepository springRepository;

	@Override
	@Transactional
	public Veiculo adiciona(Veiculo veiculo) {
		 return this.springRepository.save(veiculo);
	}

	@Override
	public void remove(Veiculo veiculo) {
		this.springRepository.delete(veiculo);
	}

	@Override
	public Veiculo buscaOuFalha(Long id) {
		return this.springRepository.findById(id)
				.orElseThrow(() -> new VeiculoNaoEncontradoException("ID", id));
	}

	@Override
	public List<Veiculo> buscaTodos() {
		return this.springRepository.findAll();
	}


}
