package com.api_pragas.resources;

import java.util.List;

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

import com.api_pragas.domain.Cultura;
import com.api_pragas.repository.ICulturaRepository;

@RestController
@RequestMapping ("/v2/culturas")
public class CulturaResources {
	//repository tem os métodos CRUD.
	
	@Autowired //injeção de dependência do nosso repository
	private ICulturaRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<Cultura>> listCultura() {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}
	
	@GetMapping(value = "/{uuid}")
	public ResponseEntity<Cultura> buscarPorUuid(@PathVariable String uuid) {	
       	return ResponseEntity.
			   status(HttpStatus.OK).
			   body( repository.getByUuid(uuid) );
	}
	
	@PostMapping()
	public ResponseEntity <Cultura> salvarCultura(@RequestBody Cultura c ) {
		return ResponseEntity.
				status(HttpStatus.OK).body(this.repository.save(c));
			
	}
	
	@PutMapping
	public void atualizarCultura() {
		
		
	}
	
	@DeleteMapping(value = "/{uuid}")
	public ResponseEntity<Void> excluirCultura(@PathVariable String uuid){
		Cultura c = repository.findByUuid(uuid);
		
		if (c != null) {
			repository.deleteById(c.getId());
		}
		
		return ResponseEntity.noContent().build();
	}

}
