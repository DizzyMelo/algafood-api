package com.algaworks.algafood.jpa;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class RestauranteMain {
	public static void main(String[] args) {
		
		
		ConfigurableApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository restauranteManager = context.getBean(RestauranteRepository.class);
		
		
		
		Restaurante restaurante = new Restaurante();
		
//		restaurante.setNome("Camaroes");
//		restaurante.setTaxaFrete(BigDecimal.TEN);
//		restauranteManager.salvar(restaurante);
//		
		List<Restaurante> restaurantes = restauranteManager.listar();
		
		
		for(Restaurante r : restaurantes) {
			System.out.println("Restaurante: " + r.getNome()  + " - " + r.getTaxaFrete() + " - " + r.getCozinha().getNome());
		}
	}
}
