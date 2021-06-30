//package com.algaworks.algafood.infrastructure.repository;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.algaworks.algafood.domain.model.FormaPagamento;
//import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;
//
//@Component
//public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository{
//	
//	@Autowired
//	private EntityManager manager;
//
//	@Override
//	public List<FormaPagamento> listar() {
//		return manager.createQuery("from FormaPagamento", FormaPagamento.class).getResultList();
//	}
//
//	@Override
//	public FormaPagamento buscar(Long id) {
//		return manager.find(FormaPagamento.class, id);
//	}
//	
//	@Transactional
//	@Override
//	public FormaPagamento salvar(FormaPagamento forma) {
//		return manager.merge(forma);
//	}
//
//	@Transactional
//	@Override
//	public void remover(FormaPagamento forma) {
//		forma = buscar(forma.getId());
//		manager.remove(forma);
//	}
//
//}
