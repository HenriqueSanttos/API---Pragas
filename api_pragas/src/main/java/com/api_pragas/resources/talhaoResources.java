package com.api_pragas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api_pragas.domain.Talhao;
import com.api_pragas.repository.ITalhaoRepository;


@RestController
@RequestMapping ("/talhao")
public class talhaoResources {

	@Autowired //injeção de dependência do nosso repository
	private ITalhaoRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<Talhao>> listTalhao() {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}
	
	@PostMapping()
	public void salvarTalhao(@RequestBody Talhao t ) {
		repository.save(t);
	}
	
	@PutMapping
	public void atualizarTalhao() {
		
		
	}
	
	@DeleteMapping()
	public void excluirNome() {
		
	}
	
}
