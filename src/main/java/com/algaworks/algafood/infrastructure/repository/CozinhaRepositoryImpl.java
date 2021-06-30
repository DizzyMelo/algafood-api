//package com.algaworks.algafood.infrastructure.repository;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//
//import com.algaworks.algafood.domain.model.Cozinha;
//import com.algaworks.algafood.domain.repository.CozinhaRepository;
//
//@Repository
//public class CozinhaRepositoryImpl implements CozinhaRepository{
//
//	@PersistenceContext
//	private EntityManager manager;
//	
//	@Override
//	public List<Cozinha> todas() {
//		return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
//	}
//	
//	@Override
//	public List<Cozinha> consultarPorNome(String nome) {
//		// TODO Auto-generated method stub
//		return manager.createQuery("from Cozinha where nome like :nome", Cozinha.class)
//				.setParameter("nome", "%" + nome + "%")
//				.getResultList();
//	}
//	
//	@Override
//	public Cozinha porId(Long id) {
//		return manager.find(Cozinha.class, id);
//	}
//	
//	
//	@Transactional
//	@Override
//	public Cozinha adicionar(Cozinha cozinha) {
//		return manager.merge(cozinha);
//	}
//	
//	@Transactional
//	@Override
//	public void remover(Long id) {
//		Cozinha cozinha = porId(id);
//		
//		if(cozinha == null) {
//			throw new EmptyResultDataAccessException(1);
//		}
//		
//		manager.remove(cozinha);
//	}
//	
//}