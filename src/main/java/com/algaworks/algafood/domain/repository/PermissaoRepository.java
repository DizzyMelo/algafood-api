package com.algaworks.algafood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algafood.domain.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long>{
	
//	List<Permissao> listar();
//	Permissao buscar(Long id);
//	Permissao salvar(Permissao permissao);
//	void remover(Permissao permissao);

}
