package com.algaworks.algafood.domain.exception;

// @ResponseStatus(HttpStatus.NOT_FOUND) Nao precisa especificar o response status ja que especificado na class entidade nao encon.
public class EstadoNaoEncontradoException extends EntidadeNaoEncontradaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EstadoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public EstadoNaoEncontradoException(Long estadoId) {
		this(String.format("Nao existe nenhum estado com o codigo %d", estadoId));
	}
	
}
