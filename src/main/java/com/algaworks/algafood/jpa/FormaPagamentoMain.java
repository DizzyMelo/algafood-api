package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

public class FormaPagamentoMain {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		FormaPagamentoRepository manager = context.getBean(FormaPagamentoRepository.class);
		
		
		FormaPagamento forma = new FormaPagamento();
		forma.setDescricao("Debito");
		FormaPagamento forma2 = manager.salvar(forma);
		
		forma2.setDescricao("Transferencia");
		manager.salvar(forma2);
		
		FormaPagamento forma3 = new FormaPagamento();
		forma3.setId(1L);
		forma3.setDescricao("Dinheiro");
		
		manager.remover(forma3);
		
		List<FormaPagamento> formas = manager.listar();
		for(FormaPagamento f : formas) {
			System.out.printf("Forma de pagamento %s \n", f.getDescricao());
		}
	}
}
