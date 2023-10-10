package br.com.veiculo.infrastructure.persistence.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.veiculo.domain.entity.GastoCombustivel;

public interface SpringGastoCombustivelRepository extends JpaRepository<GastoCombustivel, Long> {

}
