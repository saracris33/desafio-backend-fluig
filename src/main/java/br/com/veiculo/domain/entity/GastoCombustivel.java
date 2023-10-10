package br.com.veiculo.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_GASTO_COMBUSTIVEL")
public class GastoCombustivel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_GASTO_COMBUSTIVEL", nullable = false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ID_VEICULO", nullable = false)
	private Veiculo veiculo;
	
	@Column(name = "VL_GASOLINA", nullable = false)
	private BigDecimal valorGasolina;
	
	@Column(name = "KM_PERCURSO_CIDADE", nullable = false)
	private Long kmPercursoCidade;
	
	@Column(name = "KM_PERCURSO_RODOVIA", nullable = false)
	private Long kmPercursoRodovia;
	
	@Column(name = "QTD_COMBUSTIVEL_GASTO", nullable = false)
	private Long quantidadeTotalGasto;
	
	@Column(name = "VL_COMBUSTIVEL_GASTO", nullable = false)
	private BigDecimal valorTotalGasto;
	

	
	private void calculaQuantidadeLitrosTotalGasto() {
		final BigDecimal consumoVeiculoCidade = this.getVeiculo().getConsumoCidade();
		final BigDecimal kmPercorridoCidade = BigDecimal.valueOf(this.getKmPercursoCidade());
		final BigDecimal quantidadeCidade =  kmPercorridoCidade.divide(consumoVeiculoCidade, 2, RoundingMode.HALF_UP);
		
		final BigDecimal consumoVeiculoRodovia = this.getVeiculo().getConsumoRodovia();
		final BigDecimal kmPercorridoRodovia = BigDecimal.valueOf(this.getKmPercursoRodovia());
		final BigDecimal quantidadeRodovia = kmPercorridoRodovia.divide(consumoVeiculoRodovia, 2, RoundingMode.HALF_UP);
		
		
		final BigDecimal quantidadeTotalGasolina =  quantidadeCidade.add(quantidadeRodovia);
		this.setQuantidadeTotalGasto(quantidadeTotalGasolina.setScale(0, RoundingMode.HALF_UP).longValue());
	}
	

    public void calculaValorTotalGasto() {
    	this.calculaQuantidadeLitrosTotalGasto();
    	final BigDecimal quantidadeLitrosTotalGasto = BigDecimal.valueOf(this.getQuantidadeTotalGasto());
		
		this.setValorTotalGasto(this.getValorGasolina().multiply(quantidadeLitrosTotalGasto));
	}
	


}
