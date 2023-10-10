package br.com.veiculo.application.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.veiculo.application.representation.GastoCombustivelRepresentation;
import br.com.veiculo.domain.entity.GastoCombustivel;

@Component
public class GastoCombustivelConverter {
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public GastoCombustivelRepresentation toRepresentation(GastoCombustivel dominio) {
		return modelMapper.map(dominio, GastoCombustivelRepresentation.class);
	}
	
	
	public List<GastoCombustivelRepresentation> toCollectionRepresentation(List<GastoCombustivel> dominios) {
		return dominios.stream()
				.map(dominio -> toRepresentation(dominio))
				.collect(Collectors.toList());
	}

}
