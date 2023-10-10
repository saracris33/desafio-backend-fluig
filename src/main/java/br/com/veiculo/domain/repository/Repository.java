package br.com.veiculo.domain.repository;

import java.util.List;

public interface Repository<E, I> {

	public E adiciona(E obj);

	public E buscaOuFalha(I id);
	
	public List<E> buscaTodos();

}
