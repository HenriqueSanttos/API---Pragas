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

import com.api_pragas.domain.Talhao;
import com.api_pragas.repository.ITalhaoRepository;


@RestController
@RequestMapping ("/v2/talhoes")
public class TalhaoResources {
	//repository tem os métodos CRUD.
	
	@Autowired //injeção de dependência do nosso repository
	private ITalhaoRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<Talhao>> listTalhao() {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}
	
	@GetMapping(value = "/{uuid}")
	public ResponseEntity<Talhao> buscarPorUuid(@PathVariable String uuid) {	
       	return ResponseEntity.
			   status(HttpStatus.OK).
			   body( repository.getByUuid(uuid) );
	}
	
	@PostMapping()
	public ResponseEntity <Talhao> salvarTalhao(@RequestBody Talhao t ) {
		return ResponseEntity.
				status(HttpStatus.OK).body(this.repository.save(t));
			
	}
	
	@PutMapping
	public void atualizarTalhao() {
		
		
	}
	
	@DeleteMapping(value = "/{uuid}")
	public ResponseEntity<Void> excluirtalhao(@PathVariable String uuid){
		Talhao t = repository.findByUuid(uuid);
		
		if (t != null) {
			repository.deleteById(t.getId());
		}
		
		return ResponseEntity.noContent().build();
	}

}
