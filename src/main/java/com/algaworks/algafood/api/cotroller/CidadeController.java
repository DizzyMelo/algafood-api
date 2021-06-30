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
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.service.CadastroCidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeRepository repository;

	@Autowired
	private CadastroCidadeService cadastroCidade;

	@GetMapping
	public List<Cidade> listar() {
		return repository.findAll();
	}

	@GetMapping("/{cidadeId}")
	public ResponseEntity<?> buscar(@PathVariable Long cidadeId) {

		Optional<Cidade> cidade = repository.findById(cidadeId);

		if (cidade.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(cidade);
	}

	@PostMapping
	public ResponseEntity<?> adicionar(@RequestBody Cidade cidade) {
		try {
			cidade = cadastroCidade.salvar(cidade);
			return ResponseEntity.ok(cidade);
		} catch (EntidadeEmUsoException ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

	@PutMapping("/{cidadeId}")
	public ResponseEntity<?> atualizar(@PathVariable Long cidadeId, @RequestBody Cidade cidade) {
		try {
			Optional<Cidade> cidadeAtual = repository.findById(cidadeId);
			if(cidadeAtual.isPresent()) {
				BeanUtils.copyProperties(cidade, cidadeAtual.get(), "id");
				Cidade cidadeNova = cadastroCidade.salvar(cidadeAtual.get());
				
				return ResponseEntity.ok(cidadeNova);
			}
			return ResponseEntity.notFound().build();
		}catch(EntidadeNaoEncontradaException ex) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
		}
	}

	@DeleteMapping("/{cidadeId}")
	public ResponseEntity<?> remover(@PathVariable Long cidadeId) {
		try {
			cadastroCidade.remover(cidadeId);
			return ResponseEntity.noContent().build();
		} catch (EntidadeNaoEncontradaException ex) {
			return ResponseEntity.notFound().build();
		} catch (EntidadeEmUsoException ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

}
