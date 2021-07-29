package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {
	
	private static final String MSG_COZINHA_EM_USO = "Cozinha de código %d não pode ser removida porque está em uso.";
	private static final String MSG_COZINHA_NAO_ENCONTRADA = "A cozinha de código %d não foi encontrada.";
	
	@Autowired
	private CozinhaRepository repository;
	
	public Cozinha adicionar(Cozinha cozinha) {
		return repository.save(cozinha);
	}
	
	public void remover(Long id) {
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException ex) {
			throw new EntidadeNaoEncontradaException(
					String.format(MSG_COZINHA_NAO_ENCONTRADA, id));
		} catch(DataIntegrityViolationException ex) {
			throw new EntidadeEmUsoException(
					String.format(MSG_COZINHA_EM_USO, id));
		}
	}
	
	public Cozinha buscarOuFalhar(Long cozinhaId) {
		return repository.findById(cozinhaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(String.format(MSG_COZINHA_NAO_ENCONTRADA, cozinhaId)));
	}
}
