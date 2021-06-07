package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;

public class CidadeMain {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CidadeRepository manager = context.getBean(CidadeRepository.class);
		
		List<Cidade> cidades = manager.listar();
		
		for (Cidade c : cidades) {
			System.out.printf("A cidade %s foi criada no estado %s \n", c.getNome(), c.getEstado().getNome());
		}
	}
}
