package br.com.veiculo.infrastructure.exception;

import br.com.veiculo.infrastructure.util.ConstantesMessages;
import br.com.veiculo.infrastructure.util.Mensagens;

public class VeiculoNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	
	private static final String NOME_ENTIDADE = "Veiculo";

	public VeiculoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public VeiculoNaoEncontradoException(String nomeParametro, String valorParametro) {
		this(Mensagens.get(ConstantesMessages.ERRO_RECURSO_NAO_ENCONTRADO, NOME_ENTIDADE, nomeParametro, valorParametro));
	}
	
	public VeiculoNaoEncontradoException(String nomeParametro, Long valorParametro) {
		this(Mensagens.get(ConstantesMessages.ERRO_RECURSO_NAO_ENCONTRADO, NOME_ENTIDADE, nomeParametro, valorParametro));
	}

}
