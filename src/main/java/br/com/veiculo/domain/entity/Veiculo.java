package br.com.veiculo.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_VEICULO")
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VEICULO", nullable = false)
	private Long id;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "MARCA", nullable = false)
	private String marca;
	
	@Column(name = "MODELO", nullable = false)
	private String modelo;
	
	@Column(name = "DATA_FABRICACAO", nullable = false)
	private LocalDate dataFabricacao;
	
	@Column(name = "CONSUMO_MEDIO_CIDADE", nullable = false)
	private BigDecimal consumoCidade;
	
	@Column(name = "CONSUMO_MEDIO_RODOVIA", nullable = false)
	private BigDecimal consumoRodovia;
	
	@CreationTimestamp
	@Column(name = "DATA_CADASTRO", columnDefinition = "datetime", nullable = false)
	private LocalDateTime dataCadastro;
	
	@UpdateTimestamp
	@Column(name = "DATA_ALTERACAO", columnDefinition = "datetime", nullable = false)
	private LocalDateTime dataAlteracao;
	
	@Lob 
	//@Basic(fetch= FetchType.LAZY) 
    @Column(name = "imagem", columnDefinition="LONGTEXT")
	private String imagem;
	
	
	@OneToMany(mappedBy = "veiculo")
	private List<GastoCombustivel> gastosCombustivel = new ArrayList<>();

}
