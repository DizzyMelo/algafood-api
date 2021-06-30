package com.algaworks.algafood.api.cotroller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/testes")
public class TesteController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@GetMapping("/cozinhas/por-nome")
	public List<Cozinha> cozinhaPorNome(@RequestParam("nome") String nome) {
		return cozinhaRepository.findByNomeContaining(nome);
	}
	
	@GetMapping("/restaurantes/por-taxa-frete")
	public List<Restaurante> restaurantesPorTaxaFrete(BigDecimal taxainicial, BigDecimal taxafinal) {
		return restauranteRepository.findByTaxaFreteBetween(taxainicial, taxafinal);
	}
	
	@GetMapping("/restaurantes/por-nome")
	public List<Restaurante> restaurantePorNome(String nome, Long cozinha) {
		return restauranteRepository.consultarPorNome(nome, cozinha);
	}
	
	@GetMapping("/restaurantes/dois-por-nome")
	public List<Restaurante> restaurantesPorNome(String nome) {
		return restauranteRepository.findTop2ByNomeContaining(nome);
	}
	
	@GetMapping("/restaurantes/existe-por-nome")
	public boolean restauranteExistePorNome(String nome) {
		return restauranteRepository.existsByNome(nome);
	}
	
	@GetMapping("/restaurantes/contador-por-cozinha")
	public int restaurantePorCozinha(Long cozinha) {
		return restauranteRepository.countByCozinhaId(cozinha);
	}
}
