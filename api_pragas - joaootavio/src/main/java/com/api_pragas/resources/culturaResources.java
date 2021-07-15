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

import com.api_pragas.domain.Cultura;
import com.api_pragas.repository.ICulturaRepository;

@RestController
@RequestMapping ("/cultura")
public class culturaResources {
	
	@Autowired //injeção de dependência do nosso repository
	private ICulturaRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<Cultura>> listCultura() {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}
	
	@PostMapping()
	public void salvarCultura(@RequestBody Cultura c ) {
		repository.save(c);
	}
	
	@PutMapping
	public void atualizarCultura() {
		
		
	}
	
	@DeleteMapping()
	public void excluirNome() {
		
	}

}
	
	
	
	

