package br.com.veiculo.infrastructure.exception;

import br.com.veiculo.infrastructure.util.ConstantesMessages;
import br.com.veiculo.infrastructure.util.Mensagens;

public class GastoCombustivelNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	
	private static final String NOME_ENTIDADE = "Gasto combustível";

	public GastoCombustivelNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public GastoCombustivelNaoEncontradoException(String nomeParametro, String valorParametro) {
		this(Mensagens.get(ConstantesMessages.ERRO_RECURSO_NAO_ENCONTRADO, NOME_ENTIDADE, nomeParametro, valorParametro));
	}
	
	public GastoCombustivelNaoEncontradoException(String nomeParametro, Long valorParametro) {
		this(Mensagens.get(ConstantesMessages.ERRO_RECURSO_NAO_ENCONTRADO, NOME_ENTIDADE, nomeParametro, valorParametro));
	}

}
