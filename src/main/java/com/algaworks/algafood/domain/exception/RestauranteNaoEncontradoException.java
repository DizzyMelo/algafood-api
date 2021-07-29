package com.algaworks.algafood.domain.exception;

// @ResponseStatus(HttpStatus.NOT_FOUND) Nao precisa especificar o response status ja que especificado na class entidade nao encon.
public class RestauranteNaoEncontradoException extends EntidadeNaoEncontradaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RestauranteNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public RestauranteNaoEncontradoException(Long restauranteId) {
		this(String.format("Nao existe nenhum restaurante com o codigo %d", restauranteId));
	}
	
}
