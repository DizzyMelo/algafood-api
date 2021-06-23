package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Cidade salvar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoRepository.buscar(estadoId);
		
		
		if(estado == null) {
			throw new EntidadeNaoEncontradaException(String.format("nao existe nenhum estado com o codigo %d", estadoId));
		}
		
		cidade.setEstado(estado);
		return cidadeRepository.salvar(cidade);
	}
	
	public void remover(Long cidadeId) {
		try {
			cidadeRepository.remover(cidadeId);
		}catch(EmptyResultDataAccessException ex) {
			throw new EntidadeNaoEncontradaException(String.format("Nao existe nenhuma cidade com o codigo %d", cidadeId));
		}catch(DataIntegrityViolationException ex) {
			throw new EntidadeEmUsoException(String.format("O código %d está em uso e nao pode ser removido.", cidadeId));
		}
	}
}
