package com.algaworks.algafood.jpa;

import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

public class ConsultaCozinhaMain {
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaRepository cozinha = context.getBean(CozinhaRepository.class);
	
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Brasileira");
		
		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Japonesa");
		
		cozinha.adicionar(cozinha1);
		cozinha.adicionar(cozinha2);
		
		cozinha2.setId(4L);
		cozinha2.setNome("Italiana");
		
		cozinha.adicionar(cozinha2);
		
		List<Cozinha> cozinhas = cozinha.todas();
		
		for(Cozinha c : cozinhas) {
			System.out.println(c.getNome());
		}
		
		Cozinha c = cozinha.porId(1L);
		System.out.printf("%d - %s", c.getId(), c.getNome());
		
		
		Cozinha cozinha3 = new Cozinha();
		cozinha3.setId(4L);
		cozinha3.setNome("Italiana");
		
		cozinha.remover(cozinha3.getId() );
		
		List<Cozinha> cozinhas2 = cozinha.todas();
		
		for(Cozinha d : cozinhas2) {
			System.out.println(d.getNome());
		}
	}
}
