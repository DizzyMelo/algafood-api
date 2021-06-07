package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

public class EstadoMain {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		EstadoRepository manager = context.getBean(EstadoRepository.class);
		
		
		Estado estado = new Estado();
		estado.setNome("BA");
		manager.salvar(estado);
		
		List<Estado> estados = manager.listar();
		
		for (Estado p : estados) {
			System.out.printf("O estado %s foi criado \n", p.getNome());
		}
	}
}
