package br.com.veiculo.application.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.veiculo.application.command.AlterarVeiculoCommand;
import br.com.veiculo.application.command.IncluirVeiculoCommand;
import br.com.veiculo.application.representation.VeiculoRepresentation;
import br.com.veiculo.domain.entity.Veiculo;

@Component
public class VeiculoConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public Veiculo toDomain(IncluirVeiculoCommand command) {
		return modelMapper.map(command, Veiculo.class);
	}
	
	public void copyToDomainObject(AlterarVeiculoCommand command, Veiculo dominio) {
		modelMapper.map(command, dominio);
	}
	
	
	public VeiculoRepresentation toRepresentation(Veiculo dominio) {
		return modelMapper.map(dominio, VeiculoRepresentation.class);
	}
	
	
	public List<VeiculoRepresentation> toCollectionRepresentation(List<Veiculo> dominios) {
		return dominios.stream()
				.map(dominio -> toRepresentation(dominio))
				.collect(Collectors.toList());
	}

}
