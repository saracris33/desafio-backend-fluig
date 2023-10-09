package br.com.veiculo.infrastructure.persistence.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.veiculo.domain.entity.Veiculo;

public interface SpringVeiculoRepository extends JpaRepository<Veiculo, Long> {

}
