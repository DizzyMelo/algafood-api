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
//import com.algaworks.algafood.domain.model.Restaurante;
//import com.algaworks.algafood.domain.repository.RestauranteRepository;
//
//@Component
//public class RestauranteRepositoryImpl implements RestauranteRepository{
//
//	@Autowired
//	private EntityManager manager;
//	
//	@Override
//	public List<Restaurante> listar() {
//		// TODO Auto-generated method stub
//		return manager.createQuery("from Restaurante", Restaurante.class).getResultList();
//	}
//
//	@Override
//	public Restaurante buscar(Long id) {
//		// TODO Auto-generated method stub
//		return manager.find(Restaurante.class, id);
//	}
//
//	@Transactional
//	@Override
//	public Restaurante salvar(Restaurante restaurante) {
//		// TODO Auto-generated method stub
//		return manager.merge(restaurante);
//	}
//
//	@Transactional
//	@Override
//	public void remover(Restaurante restaurante) {
//		// TODO Auto-generated method stub
//		restaurante = this.buscar(restaurante.getId());
//		manager.remove(restaurante);
//	}
//
//}
