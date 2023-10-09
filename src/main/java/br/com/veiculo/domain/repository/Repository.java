package br.com.veiculo.domain.repository;

public interface Repository<E, I> {

	public E adiciona(E obj);

	public void remove(E obj);

	public E buscaOuFalha(I id);

}
