package com.api_pragas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api_pragas.domain.Pragas;
import com.api_pragas.repository.IPragasRepository;



@RestController
@RequestMapping ("/pragas")
public class pragasResources {
	//repository tem os métodos CRUD.
	
	@Autowired //injeção de dependência do nosso repository
	private IPragasRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<Pragas>> listPragas() {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}
	
	@PostMapping
	public void salvarPragas() {
		
		Pragas p = new Pragas ();
		p.setNome("Vagalume");
		
		repository.save(p);
	}
	
	@PutMapping
	public void atualizarPragas() {
		
		
	}

}
