package com.algaworks.algafood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long>{
	
	List<Cozinha> findByNomeContaining(String nome);
	
//	List<Cozinha> todas();
//	List<Cozinha> consultarPorNome(String nome);
//	Cozinha porId(Long id);
//	Cozinha adicionar(Cozinha cozinha);
//	void remover(Long id);
}
