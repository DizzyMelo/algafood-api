package com.algaworks.algafood.api.cotroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.service.CadastroEstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoRepository repository;

	@Autowired
	private CadastroEstadoService cadastroEstado;

	@GetMapping
	public List<Estado> listar() {
		return repository.findAll();
	}
	
	@GetMapping("/{estadoId}")
	public ResponseEntity<?> buscar(@PathVariable Long estadoId) {
		
		Optional<Estado> estado = repository.findById(estadoId);
		
		if(estado.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(estado);
	}

	@PostMapping
	public Estado adicionar(@RequestBody Estado estado) {
		return cadastroEstado.adicionar(estado);
	}

	@PutMapping("/{estadoId}")
	public ResponseEntity<?> atualizar(@PathVariable Long estadoId, @RequestBody Estado estado) {

		Optional<Estado> estadoAtual = repository.findById(estadoId);

		if (estadoAtual.isPresent()) {
			BeanUtils.copyProperties(estado, estadoAtual.get(), "id");

			Estado estadoNovo = cadastroEstado.adicionar(estadoAtual.get());

			return ResponseEntity.ok(estadoNovo);
		}

		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{estadoId}")
	public ResponseEntity<?> remover(@PathVariable Long estadoId) {
		try {
			cadastroEstado.remover(estadoId);
			
			return ResponseEntity.noContent().build();
		}catch(EntidadeNaoEncontradaException ex) {
			return ResponseEntity.notFound().build();
		}catch(EntidadeEmUsoException ex) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}
