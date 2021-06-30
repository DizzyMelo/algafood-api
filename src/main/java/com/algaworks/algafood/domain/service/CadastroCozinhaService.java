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
					String.format("A cozinha de código %d não foi encontrada.", id));
		} catch(DataIntegrityViolationException ex) {
			throw new EntidadeEmUsoException(
					String.format("Cozinha de código %d não pode ser removida porque está em uso.", id));
		}
	}
}
