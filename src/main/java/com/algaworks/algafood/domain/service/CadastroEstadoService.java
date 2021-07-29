package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EstadoNaoEncontradoException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {

	private static final String MSG_ENTIDADE_EM_USO = "O estado de código %d nao pode ser excluido porque esta em uso";
	
	@Autowired
	private EstadoRepository estadoRepository;

	public Estado adicionar(Estado estado) {
		return estadoRepository.save(estado);
	}

	public void remover(Long id) {
		try {
			estadoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException ex) {
			throw new EstadoNaoEncontradoException(id);
		}catch (DataIntegrityViolationException ex) {
			throw new EntidadeEmUsoException(String.format(MSG_ENTIDADE_EM_USO, id));
		}
	}
	
	public Estado buscarOuFalhar(Long estadoId) {
		return estadoRepository.findById(estadoId)
				.orElseThrow(()-> new EstadoNaoEncontradoException(estadoId));
	}
}
